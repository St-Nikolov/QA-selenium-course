package com.selenium.course.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompanyInfoPage extends BasePage{

    public CompanyInfoPage(WebDriver driver,int implicitWait) {
        super(driver,implicitWait);
    }


    @FindBy (xpath = "//li[@data-test='STATISTICS']")
    private WebElement statisticsLink;

    public CompanyInfoStatisticsPage openCompanyStatistics(){
        statisticsLink.click();
        return new CompanyInfoStatisticsPage(driver,implicitWait);
    }
}
