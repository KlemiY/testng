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

import static org.testng.Assert.assertEquals;

public class Homework_Wait {
    WebDriver driver;
    WebDriverWait wait;
    By login = By.xpath("//p/a[@class='header-topline__user-link link-dashed']");
    By registration = By.xpath("//a[@class='auth-modal__register-link']");
    By yourName = By.xpath("//input[@formcontrolname='name']");
    By email = By.xpath("//input[@formcontrolname='username']");
    By password = By.xpath("//input[@formcontrolname='password']");
    By enter = By.cssSelector("[class='button button_size_large button_color_green auth-modal__submit']");

    @BeforeMethod
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--window-size=1300,1080");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        //driver.manage().window().maximize();
        wait =  new WebDriverWait(driver, 10);
    }

    @Test
    public void allFieldsAreRed() {
        driver.get("https://rozetka.com.ua/");
        WebElement loginEl = driver.findElement(login);
        wait.until(ExpectedConditions.elementToBeClickable(login));
        loginEl.sendKeys(Keys.ENTER);

        WebElement registrationEl = driver.findElement(registration);
        wait.until(ExpectedConditions.elementToBeClickable(registration));
        registrationEl.sendKeys(Keys.ENTER);

        WebElement yourNameEl = driver.findElement(yourName);
        yourNameEl.click();

        WebElement emailEl = driver.findElement(email);
        emailEl.click();

        WebElement passwordEl = driver.findElement(password);
        passwordEl.click();

        WebElement enterEl = driver.findElement(enter);
        enterEl.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.attributeContains(By.xpath("//input[@formcontrolname='name']"),"border-color", "rgb(248, 65, 71)"));
        wait.until(ExpectedConditions.attributeContains(By.xpath("//input[@formcontrolname='username']"),"border-color", "rgb(248, 65, 71)"));
        wait.until(ExpectedConditions.attributeContains(By.xpath("//input[@formcontrolname='password']"),"border-color", "rgb(248, 65, 71)"));

        // Проверка, что поле "Ваше имя" изменило цвет на rgb(248, 65, 71).
        String actual = yourNameEl.getCssValue("border-color");
        String expected = "rgb(248, 65, 71)";
        assertEquals(actual, expected,
                String.format("Expected '%s' to contain '%s'", actual, expected));

        // Проверка, что поле "Почта" изменило цвет на rgb(248, 65, 71).
        String actual2 = emailEl.getCssValue("border-color");
        String expected2 = "rgb(248, 65, 71)";
        assertEquals(actual2, expected2,
                String.format("Expected '%s' to contain '%s'", actual2, expected2));

        // Проверка, что поле "Пароль" изменило цвет на rgb(248, 65, 71).
        String actual3 = passwordEl.getCssValue("border-color");
        String expected3 = "rgb(248, 65, 71)";
        assertEquals(actual3, expected3,
                String.format("Expected '%s' to contain '%s'", actual3, expected3));

    }

    @Test
    public void oneFieldIsGrey() {
        driver.get("https://rozetka.com.ua/");
        WebElement loginEl = driver.findElement(login);
        wait.until(ExpectedConditions.elementToBeClickable(login));
        loginEl.sendKeys(Keys.ENTER);

        WebElement registrationEl = driver.findElement(registration);
        wait.until(ExpectedConditions.elementToBeClickable(registration));
        registrationEl.sendKeys(Keys.ENTER);

        WebElement yourNameEl = driver.findElement(yourName);
        yourNameEl.click();

        WebElement passwordEl = driver.findElement(password);
        passwordEl.click();

        WebElement emailEl = driver.findElement(email);
        emailEl.sendKeys("test@test.com");
        emailEl.click();

        wait.until(ExpectedConditions.attributeContains(By.xpath("//input[@formcontrolname='name']"),"border-color", "rgb(248, 65, 71)"));
        wait.until(ExpectedConditions.attributeContains(By.xpath("//input[@formcontrolname='password']"),"border-color", "rgb(248, 65, 71)"));
        wait.until(ExpectedConditions.attributeContains(By.xpath("//input[@formcontrolname='username']"),"border-color", "rgb(166, 165, 165)"));

        // Проверка, что поле "Ваше имя" изменило цвет на rgb(248, 65, 71).
        String actualColor = yourNameEl.getCssValue("border-color");
        String expectedColor = "rgb(248, 65, 71)";
        assertEquals(actualColor, expectedColor,
                String.format("Expected '%s' to contain '%s'", actualColor, expectedColor));

        // Проверка, что поле "Пароль" изменило цвет на rgb(248, 65, 71).
        String actualColor2 = passwordEl.getCssValue("border-color");
        String expectedColor2 = "rgb(248, 65, 71)";
        assertEquals(actualColor2, expectedColor2,
                String.format("Expected '%s' to contain '%s'", actualColor2, expectedColor2));

        // Проверка, что поле "Почта" оставило изначальный цвет - rgb(166, 165, 165).
        String actualColor3 = emailEl.getCssValue("border-color");
        String expectedColor3 = "rgb(166, 165, 165)";
        assertEquals(actualColor3, expectedColor3,
                String.format("Expected '%s' to contain '%s'", actualColor3, expectedColor3));

    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
