package main.java.lesson9;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class B_Set {
    public static void main(String[] args) {
        Integer[] arr = {45, 46, 46, 46, 80};
        Set<Integer> set = new HashSet(Arrays.asList(arr));
        for (Integer el: set) {
            System.out.println(el);
        }
    }
}
