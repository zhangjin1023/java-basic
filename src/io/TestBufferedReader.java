package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class TestBufferedReader {
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

	public static void main(String[] args) {
		String URL = "http://blog.csdn.net/zgljl2012/article/details/47267609";
		TestInputStreamReader test = new TestInputStreamReader();
		System.out.println(test.getStream(URL));
	}
}
