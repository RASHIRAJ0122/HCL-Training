package assignment3;

import java.util.*;

public class ArrayListDemo {
    public static void main(String[] args) {

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>(10);
        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(1,2,3));

        list1.add(10);
        list1.add(20);
        list1.add(30);
        list1.add(1, 15);
        list1.addAll(list3);

        System.out.println(list1.get(2));

        list1.set(0, 100);
        list1.remove(1);
        list1.remove(Integer.valueOf(20));

        System.out.println(list1.contains(30));
        System.out.println(list1.size());
        System.out.println(list1.isEmpty());
        System.out.println(list1.indexOf(30));

        list1.add(30);
        System.out.println(list1.lastIndexOf(30));

        Iterator<Integer> it = list1.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();

        Object[] arr = list1.toArray();
        list2.clear();

        System.out.println(list1);
    }
}
