package test.java.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import test.java.utils.Screenshot;

import java.net.MalformedURLException;
import java.net.URL;

public class TestingSetup {
    WebDriver driver;
    Screenshot screenshot;

    @BeforeMethod
    @Parameters({"browser"})
    public void beforeMethod(String browser){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        ChromeOptions optionCh = new ChromeOptions();
        optionCh.addArguments("--disable-notifications");
        optionCh.addArguments("--window-size=1300,1080");
        optionCh.addArguments("--incognito");

        /*FirefoxOptions optionFF = new FirefoxOptions();
        optionFF.addArguments("--disable-notifications");
        optionFF.addArguments("--window-size=1300,1080");
        optionFF.addArguments("--incognito");*/

        /*if(browser.equalsIgnoreCase("firefox")) {
            try {
                driver = new RemoteWebDriver(
                        new URL("http://ec2-3-127-22-44.eu-central-1.compute.amazonaws.com:4444/wd/hub"), optionFF);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        else if(browser.equalsIgnoreCase("chrome")){
            try {
                driver = new RemoteWebDriver(
                        new URL("http://ec2-3-127-22-44.eu-central-1.compute.amazonaws.com:4444/wd/hub"), optionCh);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }*/

        driver = new ChromeDriver();
        //context.setAttribute("driver", driver);
       /*try {
            driver = new RemoteWebDriver(
                    new URL("http://ec2-3-127-22-44.eu-central-1.compute.amazonaws.com:4444/wd/hub"), optionCh);
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
