package com.selenium.course.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CompanyInfoSummaryPage extends CompanyInfoPage{

    public CompanyInfoSummaryPage(WebDriver driver,int implicitWait) {
        super(driver,implicitWait);
    }

    private By.ByXPath forwardDividendAndYieldFieldLocator = new By.ByXPath("//td[@data-test='DIVIDEND_AND_YIELD-value']");
//    @FindBy(xpath = "//td[@data-test='DIVIDEND_AND_YIELD-value']")
//    private WebElement forwardDividendAndYieldField;

    public String getForwardDividendAndYieldValue(){
        explicitWaitUntilCondition(ExpectedConditions.presenceOfElementLocated(forwardDividendAndYieldFieldLocator));
        return driver.findElement(forwardDividendAndYieldFieldLocator).getText();
    }
}
