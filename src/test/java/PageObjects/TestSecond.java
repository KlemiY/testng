package test.java.PageObjects;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class TestSecond extends TestingSetup {
    LandPage landPage;

    @BeforeMethod
    public void initialize() {
        landPage = new LandPage(driver);
    }

    @Test
    public void testA() {
        landPage.open();
        /*landPage.search("Apple");
        //Checking correct amount of products type.
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
    public void testB() {
        landPage.open();
        /*landPage.search("Samsung");
        //Checking correct amount of products type.
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
