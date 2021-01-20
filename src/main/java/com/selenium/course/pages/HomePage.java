package com.selenium.course.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    @FindBy(xpath = "//button[@value='agree']")
    private WebElement acceptCookiesButton;

    @FindBy(id="yfin-usr-qry")
    private WebElement searchField;

    @FindBy(id = "header-signin-link")
    private WebElement signInButton;

//    @FindBy(xpath = "//li[contains(@title," +company + ") and  @data-type = 'quotes' and @data-index=0]")
    private static final String FIRST_SEARCH_RESULT_BY_COMPANY_NAME = "//li[contains(@title,'%s') and  @data-type = 'quotes' and @data-index=0]";

    public HomePage(WebDriver driver,int implicitWait) {
        super(driver,implicitWait);
    }

    public CompanyInfoSummaryPage searchCompany(String companyName){
        searchField.sendKeys(companyName);
        WebElement theFirstElementInSearchResults;
        String theFirstElementInSearchXpath = String.format(FIRST_SEARCH_RESULT_BY_COMPANY_NAME,companyName);
        explicitWaitUntilCondition(ExpectedConditions.presenceOfElementLocated(By.xpath(theFirstElementInSearchXpath)));
        theFirstElementInSearchResults = driver.findElement(By.xpath(theFirstElementInSearchXpath));
        theFirstElementInSearchResults.click();
        return new CompanyInfoSummaryPage(driver,implicitWait);
    }

    public void acceptCookies(){
       acceptCookiesButton.click();
    }

    public LogInPage signIn(){
        signInButton.click();
        return new LogInPage(driver,implicitWait);
    }

}
