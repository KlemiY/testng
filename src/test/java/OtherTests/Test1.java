package test.java.OtherTests;
import main.java.testng_tasks.Task1;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Test1 {
    Task1 task1;

    @BeforeMethod
    public void initialize() {
        task1 = new Task1();
        System.out.println("Before Method - Hook");
    }


    @Test
    public void minReturnCorrectNumber() {
        int actualProperNumber = task1.min(10,11,12);
        int expectedProperNumber = 10;
        assertEquals(
                actualProperNumber,
                expectedProperNumber,
                "Expected number " + expectedProperNumber + ", but got " + actualProperNumber + "."
        );

    }

    @Test
    public void minReturnCorrectNegativeNumber() {
        int actualProperNumber = task1.min(-5,-25,-30);
        int expectedProperNumber = -30;
        assertEquals(
                actualProperNumber,
                expectedProperNumber,
                "Expected number " + expectedProperNumber + ", but got " + actualProperNumber + "."
        );

    }
}
