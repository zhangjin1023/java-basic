package io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class TestInputStreamReader {

	public String getStream(String url) {
		String result = "";
		try {
			InputStream is = new URL(url).openStream();
			InputStreamReader isr = new InputStreamReader(is,"UTF-8");
			int tmp;
			while ((tmp = isr.read()) != -1) {
				result += (char) tmp;
			}
			return result;
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
		String URL = "http://www.baidu.com";
		TestInputStreamReader test = new TestInputStreamReader();
		System.out.println(test.getStream(URL));
	}

}
