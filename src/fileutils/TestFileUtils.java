package fileutils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

/**
 * 测试apache的FileUtils工具类
 * 
 * @author zhang_jin[zhang_jin@suixingpay.com]
 *
 */
public class TestFileUtils {
	/**
	 * 读取文件为String
	 */
	@Test
	public void testReadFileToString() {
		String result = "";
		try {
			result = FileUtils.readFileToString(new File("D:/temp/20170927.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
	}

	/**
	 * 考虑场景：从网络上获取流，先转化为字节流，再输出到文件
	 * @throws IOException 
	 */
	@Test
	public void testWriteByteArrayToFile() throws IOException {
//		URL url = new URL("http://www.baidu.com");
		URL url = new URL("https://user.cmbchina.com");
		InputStream is = url.openStream();
		byte[] data = IOUtils.toByteArray(is);
		String result = "";
		try {
			FileUtils.writeByteArrayToFile(new File("D:/temp/baidu_test.txt"), data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
	}

}
