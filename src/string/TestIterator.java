package string;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestIterator {
    public static void main(String[] args) {
        List<String[]> mobileContent = new ArrayList<>();
        mobileContent.add(new String[]{"123", "abc"});
        mobileContent.add(new String[]{"456", "abc"});
        mobileContent.add(new String[]{"789", "abc"});

        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("333");
        list.add("444");

        Iterator<String[]> iterator = mobileContent.iterator();
        while (iterator.hasNext()) {
            if (list.contains(iterator.next()[0])) {
                iterator.remove();
            }
        }

        for (String[] array : mobileContent) {
            System.out.println(array[0] + "---" + array[1]);
        }
    }

}
