package test.java.PageObjects;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestThird extends TestingSetup {
    LandPage landPage;

    @BeforeMethod
    public void initialize() {
        landPage = new LandPage(driver);
    }

    @Test
    public void testA() {
        landPage.open();
    }

//    @Test
//    public void testB() {
//        landPage.open();
//    }
}
