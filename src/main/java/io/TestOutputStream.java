package io;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class TestOutputStream {
    public static void main(String[] args) throws IOException {
        // 1 test FileOutputStream
        String test = "hello world";
        // OutputStream out = new FileOutputStream(new File("D:\\temp\\testio.txt"));
        OutputStream out = new FileOutputStream("D:\\temp\\testio.txt");
        out.write(test.getBytes());
        out.close();

        // 2 test OutputStreamWriter
        String test2 = "hahaha,天骄，老杜";
        OutputStream out2 = new FileOutputStream("D:\\temp\\testio_2.txt");
        OutputStreamWriter writer = new OutputStreamWriter(out2);
        writer.write(test2);
        writer.flush();
        writer.close();

        //3 test BufferedWriter
        String test3 = "lalaa,天骄，老杜";
        OutputStream out3 = new FileOutputStream("D:\\temp\\testio_3.txt");
        OutputStreamWriter writer3 = new OutputStreamWriter(out3);
        BufferedWriter bufWriter = new BufferedWriter(writer3);
        bufWriter.write(test3);
        //另起一行
        bufWriter.newLine();
        bufWriter.write(test3);
        bufWriter.flush();
        bufWriter.close();

    }

}
