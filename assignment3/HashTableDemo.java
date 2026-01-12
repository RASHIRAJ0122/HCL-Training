package assignment3;

import java.util.*;

public class HashTableDemo {
    public static void main(String[] args) {

        Hashtable<Integer, String> ht1 = new Hashtable<>();
        Hashtable<Integer, String> ht2 = new Hashtable<>(10);
        Hashtable<Integer, String> ht3 = new Hashtable<>(10, 0.75f);
        Hashtable<Integer, String> ht4 = new Hashtable<>(ht1);

        ht1.put(1, "Java");
        ht1.put(2, "Spring");
        ht1.put(3, "Hibernate");

        System.out.println(ht1.get(1));
        System.out.println(ht1.containsKey(2));
        System.out.println(ht1.containsValue("Spring"));
        System.out.println(ht1.size());
        System.out.println(ht1.isEmpty());

        Enumeration<Integer> keys = ht1.keys();
        while(keys.hasMoreElements()){
            System.out.print(keys.nextElement() + " ");
        }
        System.out.println();

        Enumeration<String> values = ht1.elements();
        while(values.hasMoreElements()){
            System.out.print(values.nextElement() + " ");
        }
        System.out.println();

        System.out.println(ht1.entrySet());

        ht1.remove(3);
        ht1.replace(1, "JAVA");
        ht1.putIfAbsent(4, "Microservices");

        ht1.forEach((k,v)-> System.out.println(k + "=" + v));

        ht2.clear();

        System.out.println(ht1);
    }
}
