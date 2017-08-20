package resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * 加载资源
 * 
 * @author zj
 *
 */
public class LoadResource {
	public static void main(String[] args) {
		// 1.文件io流：
		String fileName = "C:\\Users\\zj\\workspace\\testszabcb2c\\src\\ConfigSource.properties";// 绝对路径
		Properties p = new Properties();
		try {
			InputStream is = new FileInputStream(new File(fileName));
			p.load(is);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(p);

		//2.相对路径
		Properties p2=new Properties();
        InputStream is=ClassLoader.getSystemResourceAsStream("ConfigSource.properties");
		//InputStream is=Thread.currentThread().getContextClassLoader().getSystemResourceAsStream("ConfigSource.properties");
        try {
			p2.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(p2);
        
        //3.ResourceBundle
        ResourceBundle bundle = ResourceBundle.getBundle("test/TrustMerchant");//src子包下
        System.out.println(bundle.getString("TrustPayNewLine"));
        ResourceBundle bundle2 = ResourceBundle.getBundle("ConfigSource");//src目录下
        System.out.println(bundle2.getString("test"));
        
	}

}
