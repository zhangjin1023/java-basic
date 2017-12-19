package xstream;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class TestXml {
	public static void main(String[] args) {
		Student student = new Student();
		student.setName("张三");
		student.setAge("12");
		student.setSex("男");
		List<String> mobiles = new ArrayList<>();
		mobiles.add("12345678");
		mobiles.add("00000000");
		student.setMobiles(mobiles);

		XStream xStream = new XStream();
		//一定要开启自动检测注解。否则注解无效
		xStream.autodetectAnnotations(true);
		String xml = xStream.toXML(student);
		System.out.println(xml);
		
		
		
		
		
		String testXml = "<student><sex></sex><name>张三</name><age>12</age><mobile>12345678</mobile><mobile>00000000</mobile><address>aaa@aaa</address></student>";
		XStream xStream2 = new XStream();
		xStream2.addPermission(AnyTypePermission.ANY);
		xStream2.processAnnotations(Student.class);// 必须要采用这个开启注解的方式，指定转化的类，否则抛出异常
		// xStream2.autodetectAnnotations(true);
		xStream2.ignoreUnknownElements();// 忽视未知节点
		Student studentFromXml = (Student) xStream2.fromXML(testXml);
		System.out.println(studentFromXml);
	}

}
