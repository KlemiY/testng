package test.java.Homework_WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework_phone_number {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/");
        By search = By.cssSelector("[class='link-dashed']");
        WebElement searchEl = driver.findElement(search);
        String phoneNumber = driver.findElement(search).getText().replace("(", "");
        String changedNumber = phoneNumber.replace(")", "");
        String changedNumber2 = changedNumber.replace("-", "");
        String changedNumber3 = changedNumber2.replace(" ", "");

        System.out.println(changedNumber3);
        driver.quit();
    }
}
