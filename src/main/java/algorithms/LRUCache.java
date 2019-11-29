package algorithms;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description:手写LRU实现
 * @Date : 2019/11/29 10:43
 * @Author : zhang_jin
 */
public class LRUCache extends LinkedHashMap {
    private static int size = 5;

    public LRUCache() {
        super(size, 0.75F, true);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > size;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache();
        lruCache.put("1", "1");
        lruCache.put("2", "2");
        lruCache.put("3", "3");
        lruCache.put("4", "4");
        lruCache.put("5", "5");
        //{1=1, 2=2, 3=3, 4=4, 5=5}
        System.out.println(lruCache.toString());

        lruCache.put("6", "6");
        lruCache.get("2");
        lruCache.put("7", "7");
        lruCache.get("4");
        //{5=5, 6=6, 2=2, 7=7, 4=4}
        System.out.println(lruCache.toString());
    }


}
