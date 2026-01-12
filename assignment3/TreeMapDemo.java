package assignment3;

import java.util.*;

public class TreeMapDemo {
    public static void main(String[] args) {

        TreeMap<Integer, String> tm1 = new TreeMap<>();
        TreeMap<Integer, String> tm2 = new TreeMap<>(Comparator.reverseOrder());
        TreeMap<Integer, String> tm3 = new TreeMap<>(tm1);
        TreeMap<Integer, String> tm4 = new TreeMap<>(Map.of(1,"A",2,"B"));

        tm1.put(1, "Java");
        tm1.put(3, "Spring");
        tm1.put(2, "Hibernate");

        System.out.println(tm1.get(1));
        System.out.println(tm1.firstKey());
        System.out.println(tm1.lastKey());
        System.out.println(tm1.containsKey(2));
        System.out.println(tm1.containsValue("Spring"));
        System.out.println(tm1.higherKey(1));
        System.out.println(tm1.lowerKey(3));
        System.out.println(tm1.ceilingKey(2));
        System.out.println(tm1.floorKey(2));
        System.out.println(tm1.pollFirstEntry());
        System.out.println(tm1.pollLastEntry());
        System.out.println(tm1.entrySet());
        System.out.println(tm1.keySet());
        System.out.println(tm1.values());

        tm2.clear();

        System.out.println(tm1);
    }
}
