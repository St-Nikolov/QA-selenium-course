package com.selenium.course.driver;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


import io.github.bonigarcia.wdm.WebDriverManager;

@Slf4j

public class DriverFactory {

    private static final String IGNORE_CERTIFICATE = "--ignore-certificate-errors";

    public static WebDriver getDriver(String browser) {
        WebDriver driver;

        switch (browser) {
            case "FireFox" :
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments(IGNORE_CERTIFICATE);

                WebDriverManager.getInstance(FirefoxDriver.class).setup();
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "GoogleChrome" :
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments(IGNORE_CERTIFICATE);

                WebDriverManager.getInstance(ChromeDriver.class).setup();
                driver = new ChromeDriver(chromeOptions);
                break;
            default :
                log.error("Browser {} not recognized",browser);
                return null;
        }



        return driver;
    }

}
