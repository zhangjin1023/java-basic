package oop;


public class IntTest {
    public static void main(String[] args){
        Integer g = 123;
        Integer h = Integer.valueOf(123);
        int i =123;
        Integer j = new Integer(123);
        Integer k = new Integer(123);
        System.out.println(i == g);
        System.out.println(i == h);
        System.out.println(i == k);
        System.out.println(j == k);
        System.out.println(h == k);
    }
}
