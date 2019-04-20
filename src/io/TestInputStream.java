package io;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class TestInputStream {

    public static void main(String[] args) {
        String URL = "http://222.66.72.115:8096/download/20171203/100000000000008/j1dbfd843ac100a8d096f40a95806d569/100000000000008-20171203-DZ.txt";
        TestInputStream test = new TestInputStream();
        System.out.println(test.getStream(URL));
    }

    public String getStream(String url) {
        InputStream is = null;
        String result = "";

        try {
            is = new URL(url).openStream();
            int tmp;
            while ((tmp = is.read()) != -1) {
                result += (char) tmp;
            }
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

}
