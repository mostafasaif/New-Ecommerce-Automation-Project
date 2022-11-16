package org.example.stepDefin;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Hooks {

    static WebDriver driver;


   /* public static void openBrowser()
    {
       //1.Bridge
        System.setProperty("webdriver.chrom.driver","D:\\Java\\Projects for java\\MavenSelenium\\src\\main\\resources\\Browsers\\chromedriver.exe");

    //2.Create new object from chrome driver
        driver=new ChromeDriver();

        //3.configuration
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //4.Navigate to the website
        driver.navigate().to("https://demo.nopcommerce.com/");
    }*/
   @Before
    public static void openChromeBrowser(){
        //WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrom.driver","D:\\Java\\Projects for java\\MavenSelenium\\src\\main\\resources\\Browsers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public static void quitDriver()  {

        driver.quit();

    }
}
