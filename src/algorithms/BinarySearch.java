package algorithms;

/**
 * 二分查找：基于有序数组进行查找关键字
 *
 * @author zhang_jin[zhang_jin@suixingpay.com]
 */
public class BinarySearch {
    public static int binarySearch(int key, int[] array) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            // 注意不能使用 (low + high)/2 计算middle 可能会溢出
            // 或者采用无符号位移>>>
            // int middle = (low + high) >>> 1;
            if (key > array[middle]) {
                low = middle + 1;
            } else if (key < array[middle]) {
                high = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 9, 20};
        int index = binarySearch(30, array);
        System.out.println(index);

    }

}
