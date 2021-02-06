package com.selenium.course.tests;

import com.selenium.course.driver.DriverFactory;
import com.selenium.course.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestUtil {

    public WebDriver driver = null;

    private String url;
    private String browser;
    protected int implicitWait;

    protected HomePage homePage;


//    @BeforeSuite
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

//    @BeforeTest
    public void setupDriver(){
        driver = DriverFactory.getDriver(browser);
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);


        homePage =new HomePage(driver,implicitWait);
        homePage.acceptCookies();
    }



    @AfterClass
    public void closeDriver(){
        driver.quit();
    }

}
