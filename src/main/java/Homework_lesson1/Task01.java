package main.java.Homework_lesson1;

/* Минимум трех чисел
   Написать функцию, которая вычисляет минимум из трёх чисел.

   Буду откровенным, я самостоятельно додумался только написать перебор через if, поскольку изучаю JS и
по факту тут это реализовано таким же образом. Идея про сканер "появилась" когда я подумал:
"А как я буду числа вводить, чтобы проверить?", потому что в JS скорее всего я бы это сделал через prompt.
Спросил совета у коллеги (который учит JAVA) и начал гуглить, не то чтобы я понимаю как всё работает и идеале.
Но вроде все работает:)
*/

import java.util.Scanner; // Импорт сканнера для ввода данных.

public class Task01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, please insert 3 digits: " );
        int numberOne = scanner.nextInt();
        int numberTwo = scanner.nextInt();
        int numberThree = scanner.nextInt();
        System.out.println(Task01.min(numberOne, numberTwo, numberThree));
    }

    // Перебор при помощи if для поиска min числа.
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