package io;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class TestInputStream {

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
	
	public static void main(String[] args) {
		String URL = "http://www.baidu.com";
        TestInputStream test = new TestInputStream();
        System.out.println(test.getStream(URL));
	}

}
