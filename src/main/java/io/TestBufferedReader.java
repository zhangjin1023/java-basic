package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class TestBufferedReader {
    public static void main(String[] args) {
        String URL = "http://222.66.72.115:8096/download/20171203/100000000000008/j1dbfd843ac100a8d096f40a95806d569/100000000000008-20171203-DZ.txt";
        TestInputStreamReader test = new TestInputStreamReader();
        System.out.println(test.getStream(URL));
    }

    public String getStream(String url) {
        StringBuilder sb = new StringBuilder();
        try {
            InputStream is = new URL(url).openStream();
            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
            BufferedReader reader = new BufferedReader(isr);
            String tmp;
            while ((tmp = reader.readLine()) != null) {
                sb.append(tmp);
            }
            return sb.toString();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
