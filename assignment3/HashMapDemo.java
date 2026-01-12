package assignment3;

import java.util.*;

public class HashMapDemo {
    public static void main(String[] args) {

        HashMap<Integer, String> map1 = new HashMap<>();
        HashMap<Integer, String> map2 = new HashMap<>(16);
        HashMap<Integer, String> map3 = new HashMap<>(16, 0.75f);
        HashMap<Integer, String> map4 = new HashMap<>(map1);

        map1.put(1, "Java");
        map1.put(2, "Python");
        map1.put(3, "Spring");
        map1.putIfAbsent(2, "C++");

        System.out.println(map1.get(1));
        System.out.println(map1.containsKey(2));
        System.out.println(map1.containsValue("Spring"));
        System.out.println(map1.size());
        System.out.println(map1.isEmpty());
        System.out.println(map1.keySet());
        System.out.println(map1.values());
        System.out.println(map1.entrySet());

        map1.remove(3);
        map1.replace(1, "JAVA");

        System.out.println(map1.getOrDefault(5, "Not Found"));

        map1.forEach((k,v) -> System.out.println(k + " = " + v));

        map2.clear();

        System.out.println(map1);
    }
}
