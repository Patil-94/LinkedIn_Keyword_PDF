package com.bridgelabz.selenium.base;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BaseClass {
    public static WebDriver driver;
    //execute before test
    @BeforeTest
    @Description("Used setUp method for setting the browser")

    public void setup() throws InterruptedException
    {

        //Handling browser level show notification popup window
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");

        //launch chromedriver
        WebDriverManager.chromedriver().setup();

        driver=new ChromeDriver(chromeOptions);

        driver.get("https://www.linkedin.com/");

        /*  launch facebook url and maximize windows */
        driver.manage().window().maximize();
        Thread.sleep(500);
    }

    //execute after test

    @AfterTest
    @Description("used tearDown method for closing the browser")


    //teardown method for close the browser
    public void tearDown()
    {
        driver.close();
        Reporter.log("====Application Launched====");
    }
}
