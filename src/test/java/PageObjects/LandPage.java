package test.java.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LandPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private String searchStr;
    By search = By.cssSelector("[name='search']");
    By productType = By.cssSelector("[class='m-cat-l-i-title-link novisited']");

    public LandPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
    }

    public LandPage open() {
        driver.get("https://rozetka.com.ua/");
        return this;
    }

    public LandPage search(String searchStr) {
        this.searchStr = searchStr;
        WebElement searchEl = driver.findElement(search);
        wait.until(ExpectedConditions.elementToBeClickable(searchEl));
        searchEl.sendKeys(this.searchStr);
        searchEl.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(productType));
        return this;
        }

    public LandPage getAmountOfProductTypes() {
        List<WebElement> productLinks = driver.findElements(productType);
        return this;

    }
}
