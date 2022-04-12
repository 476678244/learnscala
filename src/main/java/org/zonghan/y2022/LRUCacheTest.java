package org.zonghan.y2022;

public class LRUCacheTest {
    public static void main(String[] args) {
        LRUCache c = new LRUCache(10);
        c.put(1, 10);
        c.put(2, 20);
        c.put(3, 30);
        c.put(1, 100);
        System.out.println(c.get(1));
    }
}
