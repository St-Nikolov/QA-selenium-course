package com.selenium.course.tests;

import com.selenium.course.driver.DriverFactory;
import com.selenium.course.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestUtil {

    public WebDriver driver = null;

    private String url;
    private String browser;
    protected int implicitWait;
//    protected static WebDriverWait explicitWait;

    protected HomePage homePage;


    @BeforeSuite
    public void readConfigProperties(){
        try (FileReader configFile = new FileReader("src/test/resources/config.properties")) {
            Properties config = new Properties();
            config.load(configFile);
            url = config.getProperty("url");
            browser = config.getProperty("browser");
            implicitWait = Integer.parseInt(config.getProperty("implicitWait"));

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @BeforeTest
    public void setupDriver(){
        driver = DriverFactory.getDriver(browser);
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
//        explicitWait = new WebDriverWait(driver, 15);


        //Accept cookies
        homePage =new HomePage(driver,implicitWait);
        homePage.acceptCookies();
    }


    @AfterTest
    public void closeDriver(){
        driver.quit();
    }

}
