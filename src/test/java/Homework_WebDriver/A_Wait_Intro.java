package test.java.Homework_WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class A_Wait_Intro {
    WebDriver driver;
    WebDriverWait wait;
    String searchStr = "iPhone";
    String popupStrSelect = "[class='popup-css lang-switcher-popup sprite-side']";
    By logo = By.cssSelector("[class='logo-link responsive-img logo-link-svg']");
    By search = By.cssSelector("[name='search']");
    By iPhone = By.xpath("//li[1]/app-goods-tile-default/div/div[2]/a[2]/span[contains(text(), '" + searchStr + "')]");
    By popup = By.cssSelector(popupStrSelect);
    By popupClose = By.cssSelector(popupStrSelect + " [class='popup-close']");
    By suggestion = By.cssSelector("//a[@class='search-suggest__item-content search-suggest__item-text']");

    @BeforeMethod
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--window-size=1300,1080");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        wait =  new WebDriverWait(driver, 10);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().window().maximize(); // full window
    }

    @Test
    public void testFirst() {
        driver.get("https://rozetka.com.ua/");
        WebElement searchEl = driver.findElement(search);
        wait.until(ExpectedConditions.elementToBeClickable(searchEl));
        if( driver.findElements(popup).size() > 0 ) {
            driver.findElement(popupClose).click();
        }
        // WebElement iPhone = driver.findElement(By.cssSelector("")); the other option in two lines.
        searchEl.sendKeys(searchStr);
        searchEl.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(iPhone))); //other option of this.
        driver.get("https://rozetka.com.ua/notebooks/c80004/filter/present=workteaching/");
        WebElement searchEl2 = driver.findElement(search);
        wait.until(ExpectedConditions.elementToBeClickable(searchEl2));
        if( driver.findElements(popup).size() > 0 ) {
            driver.findElement(popupClose).click();
        }
        searchEl2.click();
        wait.until(ExpectedConditions.elementToBeClickable(suggestion)).click();
        //driver.findElement(suggestion).click();
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOfElementLocated(iPhone),
                ExpectedConditions.urlContains(searchStr.toLowerCase())
        ));
        String actual = driver.getCurrentUrl();
        String expected = "/#search_text=iphone" + searchStr.toLowerCase();
        assertTrue(actual.contains(expected),
                String.format("Expected '%s' to contain '%s'", actual, expected));

        //driver.findElement(logo).click();
        //new WebDriverWait(driver, 10).until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(iPhone)));
        //new WebDriverWait(driver, 10).until(ExpectedConditions.stalenessOf(driver.findElement(iPhone)));

    }


    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
