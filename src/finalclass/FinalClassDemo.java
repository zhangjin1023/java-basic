package finalclass;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 要创建不可变类，要实现下面几个步骤：
 * 1.将类声明为final，所以它不能被继承
 * 2.将所有的成员声明为私有的，这样就不允许直接访问这些成员
 * 3.对变量不要提供setter方法
 * 4.将所有可变的成员声明为final，这样只能对它们赋值一次
 * 5.通过构造器初始化所有成员，进行深拷贝(deep copy)
 * 6.在getter方法中，不要直接返回对象本身，而是克隆对象，并返回对象的拷贝
 *
 * @author zhang_jin[zhang_jin@suixingpay.com]
 */
public final class FinalClassDemo {
    private final int id;
    private final String name;
    @SuppressWarnings("rawtypes")
    private final HashMap map;

    /**
     * 浅拷贝的构造器
     * @param id
     * @param name
     * @param map
     */
/*	public FinalClassDemo(int id, String name, HashMap map) {
		super();
		System.out.println("Performing Shallow Copy for Object initialization");
		this.id = id;
		this.name = name;
		this.map = map;
	}*/

    /**
     * 深拷贝的构造器
     *
     * @param id
     * @param name
     * @param map
     */
    public FinalClassDemo(int id, String name, HashMap map) {
        super();
        System.out.println("Performing Deep Copy for Object initialization");
        this.id = id;
        this.name = name;
//		this.map = map;
        HashMap newMap = new HashMap();
        Set<Entry> entrySet = map.entrySet();
        for (Entry entry : entrySet) {
            newMap.put(entry.getKey(), entry.getValue());
        }
        this.map = newMap;
    }

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("1", "a");
        hashMap.put("2", "b");
        String name = "zhangsan";
        int id = 1;
        FinalClassDemo finalClassDemo = new FinalClassDemo(id, name, hashMap);

        System.out.println(name == finalClassDemo.getName());
        System.out.println(hashMap == finalClassDemo.getMap());
        //打印属性值
        System.out.println("id: " + finalClassDemo.getId());
        System.out.println("name: " + finalClassDemo.getName());
        System.out.println("map: " + finalClassDemo.getMap());
        //修改原始值
        id = 2;
        name = "lisi";
        hashMap.put("3", "c");

        //再次打印属性值
        System.out.println("*id: " + finalClassDemo.getId());
        System.out.println("*name: " + finalClassDemo.getName());
        System.out.println("*map: " + finalClassDemo.getMap());

        //通过访问方法修改map值
        Map map2 = finalClassDemo.getMap();
        map2.put("4", "d");
        System.out.println("#map: " + finalClassDemo.getMap());

        String test = "aaa|bbb";
        System.out.println(test.contains("|"));


    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /*
     * 可变对象的访问方法：拷贝
     */
    @SuppressWarnings("rawtypes")
    public Map getMap() {
//		return map;
        return (Map) map.clone();
    }


}
