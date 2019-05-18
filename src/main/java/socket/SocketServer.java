package socket;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) {
        ServerSocket socketServer = null;
        try {
            socketServer = new ServerSocket(2333);
            Socket client = socketServer.accept();
            InputStream inputStream = client.getInputStream();
            System.out.println(IOUtils.toString(inputStream));
            try {
                Thread.sleep(30000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            inputStream.close();
            client.close();
            socketServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
