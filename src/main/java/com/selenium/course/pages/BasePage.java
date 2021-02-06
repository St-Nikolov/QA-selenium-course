package com.selenium.course.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage {
    protected WebDriver driver;
    protected int implicitWait;
    protected WebDriverWait explicitWait;

    public BasePage(WebDriver driver,int implicitWait){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        this.implicitWait=implicitWait;
        explicitWait = new WebDriverWait(driver,20);
    }

    protected <T> T executeOperationWithExplicitWait(int timeoutInSeconds, ExpectedCondition<T> expectedCondition,int implicitWait){
        WebDriverWait wait = new WebDriverWait(driver,timeoutInSeconds);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        T result = wait.until(expectedCondition);
        driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
        return result;
    }

    protected <T> T explicitWaitUntilCondition(ExpectedCondition<T> expectedCondition){
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        T result = explicitWait.withTimeout(Duration.ofSeconds(20)).until(expectedCondition);
        driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
        return result;

    }
}
