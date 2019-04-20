package collection;

import java.util.Arrays;
import java.util.Comparator;

public class TestArrays {
    public static void main(String[] args) {
        int[] arrays = {1, 2, 3, 7, 9, 19};
        // 返回该元素在数组中的索引位置
        System.out.println(Arrays.binarySearch(arrays, 2));
        // 如果不存在该元素，返回(-(insertion point) - 1).
        // insertion point 指的是要查找的元素，应该插入的索引
        System.out.println(Arrays.binarySearch(arrays, 17));

        //非静态内部类，依赖于外部类（相当于外部类的一个成员变量，必须先new 外部类才能new内部类）
        //new GG();这种方式编译不通过
        //ok
        TestArrays testArrays = new TestArrays();
        GG gg2 = testArrays.new GG();

        //ok
        GG gg = new TestArrays().new GG();

        MM[] mms = {new MM(12), new MM(22), new MM(9)};//MM是静态内部类，可以不依赖于外部类，直接new MM()
        Arrays.sort(mms, new Comparator<MM>() {
            @Override
            public int compare(MM o1, MM o2) {
                if (o1.getBeautyCount() > o2.getBeautyCount())
                    return 1;
                if (o1.getBeautyCount() == o2.getBeautyCount())
                    return 0;
                else
                    return -1;
            }
        });
        for (MM mm : mms) {
            System.out.println(mm);
        }


        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        System.out.println(a);
        System.out.println(b);

        //不引入第三变量，实现两个变量交换值
        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println(a);
        System.out.println(b);
    }

    //test static inner class
    static class MM {
        private int beautyCount;

        public MM(int beautyCount) {
            super();
            this.beautyCount = beautyCount;
        }

        public int getBeautyCount() {
            return beautyCount;
        }

        public void setBeautyCount(int beautyCount) {
            this.beautyCount = beautyCount;
        }

        @Override
        public String toString() {
            return "MM [beautyCount=" + beautyCount + "]";
        }

    }

    //test non-static inner class
    class GG {
        private int age = 1;

    }

}
