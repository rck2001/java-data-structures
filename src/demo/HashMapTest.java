package demo;

import hashmap.HashMap;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap map = new HashMap(5);

        map.put("Apple", 2);
        map.put("Banana", 51);
        map.put("Mango", 8);
        map.put("Orange", 22);
        map.put("Dragon fruit", 22);
        map.put("Something", 999);
        map.put("Jackfruit", 432);
        System.out.println("Removed value: " + map.remove("Apple"));
        System.out.println("Value at the given key: " + map.get("Dragon fruit"));

        System.out.println("\nHashmap: " + map);
        map.displayCollisionMapping();
        System.out.println("\nCurrent size: " + map.size());
    }
}
