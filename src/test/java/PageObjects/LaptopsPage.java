package test.java.PageObjects;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LaptopsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    Logger logger = LogManager.getLogger(LandPage.class);

    @FindBy(xpath = "//li/a//*[contains(text(),'Acer')]")
    private WebElement checkBox;
    @FindBy(css = "[class='goods-tile__title']")
    public List<WebElement> laptopItems;



    public LaptopsPage(WebDriver driver) {
        logger.debug("LaptopsPage initialized");
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(driver, this);
    }

    public LaptopsPage open() {
        driver.get("https://rozetka.com.ua/notebooks/c80004/");
        return this;
    }

    public LaptopsPage selectProductCheckbox() {
        wait.until(ExpectedConditions.elementToBeClickable(checkBox)).click();
        return this;
    }

    public LaptopsPage findItems() {
        wait.until(ExpectedConditions.visibilityOfAllElements(laptopItems));
        return this;
    }

}
