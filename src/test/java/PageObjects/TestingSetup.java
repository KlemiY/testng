package test.java.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import test.java.utils.Screenshot;

import java.net.URL;

public class TestingSetup {
    WebDriver driver;
    Screenshot screenshot;

    @BeforeMethod
    //@Parameters({"browser"})
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        ChromeOptions optionCh = new ChromeOptions();
        optionCh.addArguments("--disable-notifications");
        optionCh.addArguments("--window-size=1300,1080");
        optionCh.addArguments("--incognito");

        /*FirefoxOptions optionFF = new FirefoxOptions();
        optionFF.addArguments("--disable-notifications");
        optionFF.addArguments("--window-size=1300,1080");
        optionFF.addArguments("--incognito");*/

        driver = new ChromeDriver();
        //context.setAttribute("driver", driver);
       /*try {
            driver = new RemoteWebDriver(
                    new URL("http://ec2-18-157-73-62.eu-central-1.compute.amazonaws.com:4444/wd/hub"), optionCh);
                    //new URL("http://ec2-18-156-197-65.eu-central-1.compute.amazonaws.com:4444/wd/hub"), optionsCh)
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }*/
        screenshot = new Screenshot(driver);
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        screenshot.getScreenshot(result);
        driver.quit();
    }
}
