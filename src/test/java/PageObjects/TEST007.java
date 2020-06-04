package test.java.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TEST007 {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions optionCh = new ChromeOptions();
        optionCh.addArguments("--disable-notifications");
        optionCh.addArguments("--window-size=1300,1080");
        optionCh.addArguments("--incognito");
        driver = new ChromeDriver();
        wait = new WebDriverWait(this.driver, 10);
    }

    @Test(dataProvider = "producers")
    public void checkBoxSelection(String producerName) throws InterruptedException {
        driver.get("https://rozetka.com.ua/notebooks/c80004/");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(producerName))).click();
        Thread.sleep(5000);
    }

    @DataProvider(name = "producers")
    public Object[][] getProducer() {
        return new Object[][] {
                {"//li/a//*[contains(text(),'Acer')]"},
                {"//li/a//*[contains(text(),'Apple')]"},
                {"//li/a//*[contains(text(),'Asus')]"}
        };
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        driver.quit();
    }
}
