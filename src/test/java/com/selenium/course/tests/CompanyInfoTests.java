package com.selenium.course.tests;

import com.opencsv.exceptions.CsvException;
import com.selenium.course.pages.CompanyInfoStatisticsPage;
import com.selenium.course.pages.CompanyInfoSummaryPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.selenium.course.utils.*;

import java.io.IOException;

public class CompanyInfoTests extends TestUtil {

    @BeforeTest
    public void setupDriver(){
        super.setupDriver();
    }


    @DataProvider(name="test-data")
    public static Object[][] readDataFile() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/test-data.csv");
    }

    @Test(dataProvider = "test-data")
    public void executeTests(String company,String dividends,String statisticsPrice){

        SoftAssert softAssert = new SoftAssert();
        CompanyInfoSummaryPage companyInfoSummaryPagePage = homePage.searchCompany(company);
        softAssert.assertEquals(companyInfoSummaryPagePage.getForwardDividendAndYieldValue(),dividends);
        CompanyInfoStatisticsPage companyInfoStatisticsPage = companyInfoSummaryPagePage.openCompanyStatistics();
        softAssert.assertEquals(companyInfoStatisticsPage.getPriceBookValue(),statisticsPrice);
        softAssert.assertAll();
    }
}
