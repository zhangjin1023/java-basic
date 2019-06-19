package socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocket {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            public void run() {
                try {
//                    Socket socket = new Socket("192.168.0.192", 2333);
                    Socket socket = new Socket("172.16.136.195", 20883);
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println("hello world!!!!");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    out.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}
