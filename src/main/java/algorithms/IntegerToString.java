package algorithms;

import java.util.HashMap;
import java.util.Stack;

/**
 * @description:滴滴面试算法题：自己实现Integer.toString()方法
 * 分析：我们知道String的底层数字符数组char[]构成的.
 * 例如拿到一个int类型的数字123，我们需要将其拆分为三个数字1,2,3，再转化为三个char型'1','2','3'，按顺序构成数组即可转化为String
 * 如何拆分每一个位上的数字呢，可以除以10取余数的方法把数字从右到左依次分割数字。
 * 另外，需要考虑负数情况，以及负数的最小值转化为正数后会溢出的情况。
 * @Date : 2019/12/13 15:07
 * @Author : zhang_jin
 */
public class IntegerToString {
    private static HashMap<Integer, Character> mapping = new HashMap<>();

    static {
        mapping.put(0, '0');
        mapping.put(1, '1');
        mapping.put(2, '2');
        mapping.put(3, '3');
        mapping.put(4, '4');
        mapping.put(5, '5');
        mapping.put(6, '6');
        mapping.put(7, '7');
        mapping.put(8, '8');
        mapping.put(9, '9');
    }

    public static String integerToString(int var) {
        // 如果是负数的最小值，则不能转化为正数，就直接作为特列返回写死的字符串
        if (var == Integer.MIN_VALUE) {
            return "-2147483648";
        }
        // 其他负数就转化为正数处理，最后再补上负号
        boolean negative = false;
        if (var < 0) {
            negative = true;
            var = -var;
        }

        Stack<Character> stack = new Stack<>();
        int result = var;
        while (result >= 10) {
            stack.add(mapping.get(result % 10));
            result = result / 10;
        }
        stack.push(mapping.get(result));
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return negative ? sb.insert(0, "-").toString() : sb.toString();
    }

    public static void main(String[] args) {
        String string = integerToString(-50055124);
        System.out.println(string);
    }
}
