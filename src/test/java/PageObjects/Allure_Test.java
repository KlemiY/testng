package test.java.PageObjects;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@TmsLink("WEB-123") //tms test management system.
@Epic("Card")
public class Allure_Test extends TestingSetup{
        LandPage landPage;

        @BeforeMethod
        public void initialize() {
            landPage = new LandPage(driver);
        }

        @Feature("Add to the card")
        @Story("Positive test 1")
        @Issue("BUG-465")
        @Test
        public void testA() {
            landPage.open();
            landPage.search("Samsung");

        }

        @Link("https://google.com")
        @Feature("Add to the card")
        @Story("Positive test 2")
        @Issues({
                @Issue("WEB-333"),
                @Issue("WEB-334")
        })
        @Test()
        public void testB() {
            landPage.open2("https://google.com");
        }

        @Feature("Remove from the card")
        @Story("Positive test 3")
        @Test()
        public void testC() {
            landPage.open();
            landPage.search("Apple");
            assertTrue(false);
        }

        @Feature("Remove from the card")
        @Story("Positive test 4")
        @Test()
        public void testD() {
            landPage.open();
            driver.findElement(By.id("AAAA")).click();
            landPage.search("Apple");
            assertTrue(false);
        }

        @Feature("Switch product")
        @Story("Positive test 5")
        @Test()
        public void testE() {
            landPage.open();
            if(true) throw new Error("Custom error");
            landPage.search("Apple");
            assertTrue(false);
    }
}


