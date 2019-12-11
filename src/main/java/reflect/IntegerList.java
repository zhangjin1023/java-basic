package reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:面试题：如何往List<Integer> 中插入String 类型的元素
 * @Date : 2019/12/11 16:11
 * @Author : zhang_jin
 */
public class IntegerList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        //list.add("ad"); 编译不通过
        //采用反射方式
        Class<List> listKlass = List.class;
        try {
            Method method = listKlass.getDeclaredMethod("add", new Class[]{Object.class});
            method.invoke(list, "ad");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(list);

    }
}
