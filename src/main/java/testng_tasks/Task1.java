package main.java.testng_tasks;

public class Task1 {

    public static void main(String[] args) {
        System.out.println(Task1.min(7, 8, 9));
    }

    public static int min(int a, int b, int c) {

        if (a < b && a < c) {
            return a;
        } else if (b < a && b < c) {
            return b;
        } else {
            return c;
        }
    }

}
