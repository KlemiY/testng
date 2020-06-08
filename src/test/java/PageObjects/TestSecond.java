package test.java.PageObjects;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.utils.RetryAnalyzer;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class TestSecond extends TestingSetup {
    LandPage landPage;

    @BeforeMethod
    public void initialize() {
        landPage = new LandPage(driver);
    }

    @Test
    public void test1() {
        landPage.open();
        //landPage.search("Apple");
        /*//Checking correct amount of products type.
        List<WebElement> productLinks = landPage.productType;
        for (WebElement element : productLinks) {
            int expectedAmount = 5;
            int actualAmount = productLinks.size();
            assertEquals(expectedAmount, actualAmount,
                    "Expected amount is " + expectedAmount + ", but got " + actualAmount + "."
            );
        }*/
    }

    @Test
    public void test2() {
        landPage.open();
        //landPage.search("Samsung");
        /*//Checking correct amount of products type.
        List<WebElement> productLinks = landPage.productType;
        for (WebElement element : productLinks) {
            int expectedAmount = 9;
            int actualAmount = productLinks.size();
            assertEquals(expectedAmount, actualAmount,
                    "Expected amount is " + expectedAmount + ", but got " + actualAmount + "."
            );
        }*/
    }

    @Test
    public void test3() {
        landPage.open();
        //landPage.search("Apple");
        /*//Checking correct amount of products type.
        List<WebElement> productLinks = landPage.productType;
        for (WebElement element : productLinks) {
            int expectedAmount = 5;
            int actualAmount = productLinks.size();
            assertEquals(expectedAmount, actualAmount,
                    "Expected amount is " + expectedAmount + ", but got " + actualAmount + "."
            );
        }*/
    }

    @Test
    public void test4() {
        landPage.open();
        //landPage.search("Samsung");
        /*//Checking correct amount of products type.
        List<WebElement> productLinks = landPage.productType;
        for (WebElement element : productLinks) {
            int expectedAmount = 9;
            int actualAmount = productLinks.size();
            assertEquals(expectedAmount, actualAmount,
                    "Expected amount is " + expectedAmount + ", but got " + actualAmount + "."
            );
        }*/
    }
    @Test
    public void test5() {
        landPage.open();
        //landPage.search("Apple");
        /*//Checking correct amount of products type.
        List<WebElement> productLinks = landPage.productType;
        for (WebElement element : productLinks) {
            int expectedAmount = 5;
            int actualAmount = productLinks.size();
            assertEquals(expectedAmount, actualAmount,
                    "Expected amount is " + expectedAmount + ", but got " + actualAmount + "."
            );
        }*/
    }

    @Test
    public void test6() {
        landPage.open();
        //landPage.search("Samsung");
        /*//Checking correct amount of products type.
        List<WebElement> productLinks = landPage.productType;
        for (WebElement element : productLinks) {
            int expectedAmount = 9;
            int actualAmount = productLinks.size();
            assertEquals(expectedAmount, actualAmount,
                    "Expected amount is " + expectedAmount + ", but got " + actualAmount + "."
            );
        }*/
    }
}
