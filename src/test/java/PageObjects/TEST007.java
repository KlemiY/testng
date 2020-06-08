package test.java.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;


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
    public void checkBoxSelection(String producerName, String laptopName) throws InterruptedException {
        driver.get("https://rozetka.com.ua/notebooks/c80004/");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(producerName))).click();
        Thread.sleep(5000);

        /*CSS селектор находит на странице 60 элементов, а в консоль выводит 59,
        я руками посчитал, сколько плиток с товарами на странице, их там 59 не понятно откуда лезет еще 1,
        но вроде работает всё нормально.*/

        List<WebElement> allItems = driver.findElements(By.cssSelector("[class='goods-tile__title']"));
        String [] itemsText = new String[allItems.size()];
        int i=0;
        //Storing List elements text into String array
        for(WebElement element: allItems) {
            String actualWords = itemsText[i]= String.valueOf(element.getText().toLowerCase().contains(laptopName));
            i++;
            String expectedWords = "true";
            assertEquals(actualWords, expectedWords);
        }

    }

    @DataProvider(name = "producers")
    public Object[][] getProducer() {
        return new Object[][] {
                {"//li/a//*[contains(text(),'Acer')]", "ноутбук acer"},
                {"//li/a//*[contains(text(),'Apple')]", "ноутбук apple"},
                {"//li/a//*[contains(text(),'Asus')]", "ноутбук asus"}
        };

    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        driver.quit();
    }
}
