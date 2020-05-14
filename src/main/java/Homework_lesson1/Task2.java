package main.java.Homework_lesson1;

/* Мое имя - Oleg.
Вывести на экран свое имя 5 строк по 10 раз (через пробел).
System.out.println, System.out.print можно использовать только по одному разу
для этого нужно воспользоваться циклом for.
*/

public class Task2 {
    public static void main(String[] args) {

        String n = "Marina<3";

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}