package demo;

import hashmap.HashMap;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap map = new HashMap(5);

        map.put("Apple", 2);
        map.put("banana", 3);
        map.put("Mango", 8);
        map.put("Orange", 22);
        map.put("Dragon fruit", 44);


        System.out.println(map);
        System.out.println("Size: " + map.size());
    }
}
