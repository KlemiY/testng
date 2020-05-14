package test.java;

import main.java.testng_tasks.Task1;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DP_Test {
    Task1 task1;

    @BeforeMethod
    public void beforeMethod(){
        task1 = new Task1();
    }

    @Test(dataProvider = "randomNumbers") //or name of the method.
    public void differentMinimalNum(int firstNumber, int secondNumber, int thirdNumber, int expectedMinNumber) {
        int minNumber = task1.min(firstNumber, secondNumber, thirdNumber);
        int actualMin = minNumber;
        int expectedMin = expectedMinNumber;
        assertEquals(
                actualMin,
                expectedMin,
                "Expected min is " + expectedMin + ", but got " + actualMin + "."
        );
    }

    @DataProvider(name = "randomNumbers")
    public Object[][] getData() {
        return new Object[][] {
                {4, 5, 6, 4},
                {-4, -5, -6, -6},
                {47, 58, 34, 34},
                {-22, -5, -18, -22},
                {32, 44, 95, 32},
                {100, 99, 98, 98},
                {-100, -99, -98, -100}
        };
    }
}
