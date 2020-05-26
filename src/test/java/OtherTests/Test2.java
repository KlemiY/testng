package test.java.OtherTests;

import main.java.testng_tasks.Task2;
import org.testng.annotations.*;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Test2 {
    Task2 task2;

    @BeforeMethod
    public void initialize() {
        task2 = new Task2();
        System.out.println("Before Method - Hook");
    }

    @Test
    public void printNameShouldReturnAllNamesInUpperCase() {
        String[] capitalLetter = task2.printName().split(", ");
        for (String name: capitalLetter) {
            String actualFirsChar = String.valueOf(name.charAt(0));
            String expectedFirstChar = String.valueOf(name.charAt(0)).toUpperCase();
            assertTrue(
                    actualFirsChar.equals(expectedFirstChar),
                    "Expected first letter " + actualFirsChar + " in name " + name + " to be upper case."
            );
        }
    }

    @Test
    public void linesAmount() {
        String properLinesAmount = task2.printName();
        int actualLineAmount = properLinesAmount.split("\n").length;
        int expectedLineAmount = 5;
        assertEquals(
                actualLineAmount,
                expectedLineAmount,
                "Expected amount of line: " + expectedLineAmount + ", but got " + actualLineAmount
        );
    }

    @Test
    public void spacesAmount() { //Total amount
        String totalSpacesAmount = task2.printName();
        int actualSpacesAmount = totalSpacesAmount.split("\\s+").length;
        int expectedSpacesAmount = 50;
        assertEquals(
                actualSpacesAmount,
                expectedSpacesAmount,
                "Expected amount of names in one row: " + expectedSpacesAmount + ", but got " + actualSpacesAmount + "."
        );
    }
}
