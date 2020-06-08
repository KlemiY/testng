package test.java.PageObjects;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class Homework_PO extends TestingSetup {
    LandPage landPage;
    LaptopsPage laptopsPage;

    @BeforeMethod
    public void initialize() {
        landPage = new LandPage(driver);
        laptopsPage = new LaptopsPage(driver);
    }

    @Test
    public void appleProductsSearch() {
        landPage.open();
        landPage.search("Apple");
        //Checking correct amount of products type.
        List<WebElement> productLinks = landPage.productType;
        for (WebElement element : productLinks) {
            int expectedAmount = 5;
            int actualAmount = productLinks.size();
            assertEquals(expectedAmount, actualAmount,
                    "Expected amount is " + expectedAmount + ", but got " + actualAmount + "."
            );
        }
    }

    @Test
    public void samsungProductsSearch() {
        landPage.open();
        landPage.search("Samsung");
        //Checking correct amount of products type.
        List<WebElement> productLinks = landPage.productType;
        for (WebElement element : productLinks) {
            int expectedAmount = 9;
            int actualAmount = productLinks.size();
            assertEquals(expectedAmount, actualAmount,
                    "Expected amount is " + expectedAmount + ", but got " + actualAmount + "."
            );
        }
    }

    @Test()
    public void testB() {
        landPage.open();
        fail();
    }

}



