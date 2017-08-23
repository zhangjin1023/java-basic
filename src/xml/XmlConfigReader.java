package xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 解析xml文件,单例模式生成数据库配置类
 * 
 * @author zhang_jin[zhang_jin@suixingpay.com]
 *
 */
public class XmlConfigReader {
	private static XmlConfigReader instance = null;

	JdbcConfig jdbcConfig = new JdbcConfig();

	private XmlConfigReader() {
		SAXReader saxReader = new SAXReader();
		//配置文件直接放在classpath的xml子包下
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("xml/config2.xml");
		//配置文件直接放在classpath下
		//InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.xml");

		try {
			// Document doc = saxReader.read(new
			// File("C:\\Projects\\java-basic\\src\\xml\\config.xml"));
			Document doc = saxReader.read(in);
			Element root = doc.getRootElement();
			System.out.println(root.asXML());
			Element dbElement = root.element("db-info");
			System.out.println(dbElement.asXML());

			System.out.println(dbElement.elementText("driver-name"));
			jdbcConfig.setDriverName(dbElement.elementText("driver-name"));
			jdbcConfig.setUserName(dbElement.elementText("user-name"));
			jdbcConfig.setPassword(dbElement.elementText("password"));
			jdbcConfig.setUrl(dbElement.elementText("url"));

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static synchronized XmlConfigReader getInstance() {
		if (instance == null) {
			instance = new XmlConfigReader();
		}
		return instance;
	}

	public JdbcConfig getJdbcConfig() {
		return jdbcConfig;
	}

	public void setJdbcConfig(JdbcConfig jdbcConfig) {
		this.jdbcConfig = jdbcConfig;
	}

	public static void main(String[] args) {
		XmlConfigReader instance1 = XmlConfigReader.getInstance();
		XmlConfigReader instance2 = XmlConfigReader.getInstance();
		System.out.println(instance1 == instance2);//单例模式

		JdbcConfig config = instance1.getJdbcConfig();
		System.out.println(config);
	}

}
