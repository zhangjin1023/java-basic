package jvm;

import java.io.IOException;
import java.io.InputStream;

/**
 * 不同的类加载器对instanceof 关键字运算的结果影响
 *
 * @author zhang_jin[zhang_jin@XXXCompany.com]
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        //自定义一个简单的类加载器。可以加载与自己在同一路径下的Class文件
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public java.lang.Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }

            }
        };

        Object obj = myLoader.loadClass("jvm.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        //jvm.ClassLoaderTest$1@7852e922
        //可见，该对象的Class文件是被自定义类加载器所加载
        System.out.println(obj.getClass().getClassLoader());
        //sun.misc.Launcher$AppClassLoader@73d16e93
        //可见，该类是被系统类加载器所加载
        System.out.println(jvm.ClassLoaderTest.class.getClassLoader());
        System.out.println(obj instanceof jvm.ClassLoaderTest);
    }

}
