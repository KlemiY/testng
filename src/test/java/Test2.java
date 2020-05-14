package test.java;

import main.java.testng_tasks.Task2;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Test2 {
    Task2 task2;

    @AfterClass
    public void tearDown() {
        System.out.println("I am After Class - Hook");
    }

    @BeforeClass
    public void setUp() {
        System.out.println("I am Before Class - Hook");
    }

    @BeforeMethod
    public void initialize() {
        task2 = new Task2();
        System.out.println("Before Method - Hook");
    }

    @Test
    public void amountOfLines() {
        String[] amountOfLines = task2.printName().split("\n");
        int actualAmountOfLines = amountOfLines.length;
        int expectedAmountOfLines = 5;
        assertEquals(
                actualAmountOfLines,
                expectedAmountOfLines,
                "Expected amount of lines: " + expectedAmountOfLines + ", but got " + actualAmountOfLines
        );
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
    public void amountOfNamesInOneLine() {
        String amountOfNames = task2.printName();

    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method - Hook");
    }

}
