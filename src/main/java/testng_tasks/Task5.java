package main.java.testng_tasks;

//import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {

        reversePhrase();
    }

    public static String reversePhrase() {

        String input = "Geeks for Geeks";

        StringBuilder input1 = new StringBuilder();
        input1.append(input);
        input1 = input1.reverse();


        System.out.println(input1);
        return input1.toString();

    }
}
