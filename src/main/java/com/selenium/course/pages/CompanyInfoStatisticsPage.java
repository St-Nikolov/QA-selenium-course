package com.selenium.course.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CompanyInfoStatisticsPage extends CompanyInfoPage{

    public CompanyInfoStatisticsPage(WebDriver driver,int implicitWait) {
        super(driver,implicitWait);
    }

//    @FindBy (xpath="//td/span[text()=\"Price/Book\"]/ancestor::tr/td[2]")
//    WebElement priceBookValue;

    private final String PRICE_BOOK_LOCATION = "//td/span[text()=\"Price/Book\"]/ancestor::tr/td[2]";

//    private static String PRICE_BOOK_XPATH_BY_COLUMN_INDEX = "//tr//td//span[text()='Price/Book']//ancestor::tr/td[%s]";
//    private static String COLUMN_HEADER_XPATH_BY_COLUMN_NAME = "//table//th//span[text()='%s']//ancestor::th";
//
//    @FindBy (xpath = "//table//th//span[text()='Current']//ancestor::tr/th" )
//    private List<WebElement> headerElementsRow;
//
//
//    public String getPriceBookValueByColumnName(String columnName){
//       By.ByXPath columnHeaderLocator = new By.ByXPath(String.format(COLUMN_HEADER_XPATH_BY_COLUMN_NAME,columnName));
//       explicitWaitUntilCondition( ExpectedConditions.presenceOfElementLocated(columnHeaderLocator));
//       WebElement columnHeaderElement = driver.findElement(columnHeaderLocator);
//       int columnNumber = headerElementsRow.indexOf(columnHeaderElement);
//       columnNumber++;
//       By.ByXPath priceBookLocator = new By.ByXPath(String.format(PRICE_BOOK_XPATH_BY_COLUMN_INDEX,columnNumber));
//       explicitWaitUntilCondition(ExpectedConditions.presenceOfElementLocated(priceBookLocator));
//       explicitWaitUntilCondition( ExpectedConditions.not(ExpectedConditions.textToBe(priceBookLocator,"")));
//       return driver.findElement(priceBookLocator).getText();
//    }
//
//    public String getPriceBookValue(){
//        return getPriceBookValueByColumnName("Current");
//    }

    public String getPriceBookValue(){
        By priceBookLocator = new By.ByXPath(PRICE_BOOK_LOCATION);
        explicitWaitUntilCondition(ExpectedConditions.presenceOfElementLocated(priceBookLocator));
        explicitWaitUntilCondition( ExpectedConditions.not(ExpectedConditions.textToBe(priceBookLocator,"")));
        return driver.findElement(priceBookLocator).getText();
    }

    }
