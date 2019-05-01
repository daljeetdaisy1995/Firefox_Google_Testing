package initialization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Setup {

    // public static String OS = null;
    public static WebDriver driver = null;

    //To do : setup the path for the Mozilla

    public static WebDriver SetupDriver(String platform, String url, String browser) {
        if (platform.equalsIgnoreCase("mac") && (browser.equalsIgnoreCase("chrome"))) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        } else if (platform.equalsIgnoreCase("windows") && browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");

        }
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        return driver;

    }

    @AfterTest
    public void quitDriver(){
           driver.quit();
    }

    @Test
    public void facebookLogin() {

        SetupDriver("Mac", "http://www.facebook.com/", "chrome");
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("daljeet");
        driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("12345678");

        //driver.findElement(By.xpath("//*[@value='Log In'] ")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


       // driver.quit();

    }
    //5 test cases

    @Test
    public void messengerRediraction() {
        driver = SetupDriver("Mac", "http://www.facebook.com/", "chrome");
        driver.findElement(By.linkText("Messenger")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void InstagramReadiraction(){

        driver = SetupDriver("Mac", "http://www.facebook.com/", "chrome");
        driver.findElement(By.linkText("Instagram")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void LocationsReadiraction(){

        driver = SetupDriver("Mac", "http://www.facebook.com/", "chrome");
        driver.findElement(By.linkText("Locations")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void CareersReadiraction(){

        driver = SetupDriver("Mac", "http://www.facebook.com/", "chrome");
        driver.findElement(By.linkText("Careers")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void GamesReadiraction(){

        driver = SetupDriver("Mac", "http://www.facebook.com/", "chrome");
        driver.findElement(By.linkText("Games")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}