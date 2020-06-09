package test.java.PageObjects;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.utils.PropertyLoader;
import io.qameta.allure.Step;

import java.util.List;

public class LandPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private String searchStr;
    Logger logger = LogManager.getLogger(LandPage.class);

    @FindBy(css = "[name='search']")
    private WebElement search;
    @FindBy(css = "[class='m-cat-l-i-title-link novisited']")
    public List<WebElement> productType;

    public LandPage(WebDriver driver) {
        logger.debug("LandPage initialized");
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(driver, this);
    }

    @Step("Open home page")
    public LandPage open() {
        logger.warn("Test warning");
        logger.error("Test error");
        logger.info("Open Home Page");
        driver.get(PropertyLoader.loadProperty("url"));
        //el.sendKeys(PropertyLoader.loaderProperty("login"));
        //el2.sendKeys(PropertyLoader.loaderProperty("password"));
        logger.debug("URL: " + driver.getCurrentUrl());
        return this;
    }

    @Step("Open home page by URL {url}")
    public LandPage open2(String url) {
        logger.warn("Test warning");
        logger.error("Test error");
        logger.info("Open Home Page");
        driver.get(url);
        //el.sendKeys(PropertyLoader.loaderProperty("login"));
        //el2.sendKeys(PropertyLoader.loaderProperty("password"));
        logger.debug("URL: " + driver.getCurrentUrl());
        return this;
    }

    @Step("Search by {searchStr}")
    public LandPage search(String searchStr) {
        logger.info("Search on home page for " + searchStr);
        this.searchStr = searchStr;
        wait.until(ExpectedConditions.elementToBeClickable(search));
        search.sendKeys(this.searchStr);
        search.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfAllElements(productType));
        logger.debug("URL: " + driver.getCurrentUrl());
        return this;
        }
}
