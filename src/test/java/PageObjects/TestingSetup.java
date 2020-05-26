package test.java.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestingSetup {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--window-size=1300,1080");
        options.addArguments("--incognito");
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}