package main.java.lesson9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class A_List {
    public static void main(String[] args) {
        int[] arr = {45, 45, 78, 89};
        Integer a = 45;
        Integer a1 = 45;
        Integer b = new Integer(450);
        Integer d = new Integer(450);
//        System.out.println(a == a1); //true
//        System.out.println(b == d); //false
//        System.out.println(b.equals(d)); //true
        List<Integer> list = new ArrayList();
        list.add(45);
        list.add(45);
        list.add(45);
        list.add(8);
        list.add(800);
        list.remove(3);
        System.out.println("Size " + list.size());
        /*for (int i = 0; i < list.size() ; i++) {
            System.out.println(list.get(i));

        }*/
        /*for (Integer el: list) {
            System.out.println(el);
        }*/
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println("-----");
            System.out.println(iterator.next());
        }
    }
}
