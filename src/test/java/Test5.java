package test.java;

import main.java.testng_tasks.Task5;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Test5 {
    Task5 task5;

    @BeforeMethod
    public void initialize() {
        task5 = new Task5();
        System.out.println("Before Method - Hook");
    }

    @Parameters({"browser"})
    @Test
    public void Task5(/*@Optional("firefox")*/ String browser) {
        String actualReverseSentence = Task5.reversePhrase();
        String expectedReverseSentence = "skeeG rof skeeG";
        assertEquals(
                actualReverseSentence,
                expectedReverseSentence,
                "Expected result: " + expectedReverseSentence + ", but got " + actualReverseSentence + "."
        );
        System.out.println("Tested in " + browser);
    }
}
