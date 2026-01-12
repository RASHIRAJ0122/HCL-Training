package assignment3;

import java.util.*;

public class VectorDemo {
    public static void main(String[] args) {

        Vector<String> v1 = new Vector<>();
        Vector<String> v2 = new Vector<>(5);
        Vector<String> v3 = new Vector<>(5, 3);
        Vector<String> v4 = new Vector<>(Arrays.asList("A", "B"));

        v1.add("Java");
        v1.add("Python");
        v1.addElement("C++");
        v1.insertElementAt("Spring", 1);

        System.out.println(v1.get(0));
        System.out.println(v1.elementAt(1));

        v1.set(0, "JAVA");
        v1.remove("Python");
        v1.removeElement("C++");

        System.out.println(v1.size());
        System.out.println(v1.capacity());
        System.out.println(v1.contains("Spring"));
        System.out.println(v1.isEmpty());
        System.out.println(v1.firstElement());
        System.out.println(v1.lastElement());

        v2.clear();

        System.out.println(v1);
    }
}
