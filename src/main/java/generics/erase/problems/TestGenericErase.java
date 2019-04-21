package generics.erase.problems;

import java.util.ArrayList;
import java.util.List;

public class TestGenericErase {
    //Cannot create a generic array of List<Integer>
    //List<Integer>[] arrayOfLists = new List<Integer>[2];

    public static void main(String[] args) {
        Class clz1 = new ArrayList<Integer>().getClass();
        Class clz2 = new ArrayList<String>().getClass();
        System.out.println(clz1);//class java.util.ArrayList
        System.out.println(clz1 == clz2);//true

        //调用反射方法
        List<String> list = new ArrayList<String>();
        list.add("1");
        try {
            append(list, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }

    public static <E> void append(List<E> list) {
        //Cannot instantiate the type E
        //E e = new E();
        //list.add(e);
    }

    //解决方案：反射
    public static <E> void append(List<E> list, Class<E> clazz) throws InstantiationException, IllegalAccessException {
        E e = clazz.newInstance();
        list.add(e);
    }

    public static <E> void rtti(List<E> list) {
		/*if (list instanceof ArrayList<Integer>) {//error
			
		}*/

        if (list instanceof ArrayList<?>) {//ok

        }
    }

}
