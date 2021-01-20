package com.selenium.course.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends BasePage{

    @FindBy(id="usernamereg-firstName")
    WebElement firstName;

    @FindBy(id="usernamereg-lastName")
    WebElement lastName;

    @FindBy(id="usernamereg-yid")
    WebElement email;

    @FindBy(id="usernamereg-password")
    WebElement password;

    @FindBy(id="usernamereg-phone")
    WebElement mobile;

    @FindBy(id="usernamereg-month")
    WebElement birthMonth;

    @FindBy(id="usernamereg-day")
    WebElement birthDay;

    @FindBy(id="usernamereg-year")
    WebElement birthYear;

    @FindBy(id="reg-submit-button")
    WebElement continueButton;

    @FindBy(id="reg-error-yid")
    WebElement errMessageMail;

    @FindBy(id="reg-error-birthDate")
    WebElement errMessageBirthDate;

    @FindBy(id="reg-error-phone")
    WebElement errMessagePhone;

    @FindBy(id="reg-error-password")
    WebElement errMessagePassword;


    public SignUpPage(WebDriver driver, int implicitWait) {
        super(driver, implicitWait);
    }

    public void signUp(String firstName,String lastName,String email,String password,String mobile,String fullBirthDay) {
        this.firstName.clear();
        this.lastName.clear();
        this.email.clear();
        this.password.clear();
        this.mobile.clear();
        this.birthDay.clear();
        this.birthYear.clear();

        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.mobile.sendKeys(mobile);
        String[] birthDay = fullBirthDay.split("\\.");
        new Select(this.birthMonth).selectByIndex(Integer.parseInt(birthDay[1]));
        this.birthDay.sendKeys(birthDay[0]);
        this.birthYear.sendKeys(birthDay[2]);

        continueButton.click();
    }

    public String getErrMessageMail() {
        return errMessageMail.getText();
    }

    public String getErrMessageBirthDate() {
        return errMessageBirthDate.getText();
    }

    public String getErrMessagePhone() {
        return errMessagePhone.getText();
    }

    public String getErrMessagePassword() {
        return errMessagePassword.getText();
    }
}
