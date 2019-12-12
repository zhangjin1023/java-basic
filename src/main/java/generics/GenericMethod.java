package generics;

/**
 * @description:泛型方法
 * @Date : 2019/12/11 16:36
 * @Author : zhang_jin
 */
public class GenericMethod {

    public static void main(String[] args) {
        GenericMethod generics = new GenericMethod();

        Integer[] intArray = {1, 2, 3};
        generics.printArray(intArray);

        String[] strArray = {"1", "2", "3"};
        generics.printArray(strArray);

        printArrayStatic(strArray);
    }

    /**
     * @description 静态的泛型方法
     * @param array
     * @return void
     */
    public static <E> void printArrayStatic(E[] array) {
        for (E e : array) {
            System.out.println(e);
        }
    }

    /**
     * @description 非静态的泛型方法
     * @param array
     * @return void
     */
    public <E> void printArray(E[] array) {
        for (E e : array) {
            System.out.println(e);
        }
    }

}
