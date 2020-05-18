package test.java.Homework_WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A_Run_browser_lesson_material {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/");
        By search = By.cssSelector("[name='search']");
        Thread.sleep(5000);
        WebElement searchEl = driver.findElement(search);
        searchEl.sendKeys("iPhone");
        searchEl.click();
        Thread.sleep(5000);
        String name = driver.findElement(By.cssSelector("[class='header-topline__user-link link-dashed']")).getText();
        System.out.println(name);
        //driver.findElement(search).sendKeys("iPhone");
        driver.quit();
    }
}
