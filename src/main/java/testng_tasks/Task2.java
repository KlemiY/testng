package main.java.testng_tasks;

public class Task2 {
    public static void main() {
        printName();
    }

    public static String printName() {

        String a = "Oleg";
        String n = "";

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                n = n + a + " ";
                //System.out.print(a + " ");
            }
            n = n + "\n";
            //System.out.println();
        }
        System.out.println(n);
        return n;
    }
}

