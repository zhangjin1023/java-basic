package concurrent.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * AtomicIntegerArray类需要注意的是，
 * 数组value通过构造方法传递进去，然后AtomicIntegerArray会将当前数组复制一份，
 * 所以当AtomicIntegerArray对内部的数组元素进行修改时，不会影响到传入的数组。
 *
 * @author zhang_jin[zhang_jin@XXXCompany.com]
 */
public class TestAtomicIntegerArray {
    static int[] value = new int[]{1, 2};
    static AtomicIntegerArray ai = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        System.out.println(ai.getAndSet(0, 2));
        System.out.println(ai.get(0) + "," + ai.get(1));
        System.out.println(value[0] + "," + value[1]);
    }

}
