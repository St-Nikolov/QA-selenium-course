package com.selenium.course.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage{

    @FindBy(className = "sign-up-link")
    WebElement createAnAccountButton;

    public LogInPage(WebDriver driver, int implicitWait) {
        super(driver, implicitWait);
    }

    public SignUpPage createAnAccount(){
        createAnAccountButton.click();
        return new SignUpPage(driver,implicitWait);
    }

}
