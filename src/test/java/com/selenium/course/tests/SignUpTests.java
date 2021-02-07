package com.selenium.course.tests;

import com.opencsv.exceptions.CsvException;
import com.selenium.course.pages.LogInPage;
import com.selenium.course.pages.SignUpPage;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import com.selenium.course.utils.*;

import java.io.IOException;

public class SignUpTests extends TestUtil {

    private SignUpPage signUpPage;

    @DataProvider(name="test-data")
    public static Object[][] readDataFile() throws IOException, CsvException {
        Object data [][] =  CsvReader.readCsvFile("src/test/resources/login-data.csv");
        Object [][] dataAndAnswers = new String[data.length/2][data[0].length*2];
        for (int i = 0; i<data.length; i+=2) {
            for (int j = 0; j < data[i].length;j++ ) {
                dataAndAnswers[i / 2][j] = data[i][j];
                dataAndAnswers[i / 2][j + data[i].length] = data[i + 1][j];
            }
        }
        return dataAndAnswers;
    }

    @BeforeTest
    public void setupDriver(){
        super.setupDriver();
        reachCreateAccountPage();
    }

    public void reachCreateAccountPage(){
        LogInPage logInPage = homePage.signIn();
        signUpPage = logInPage.createAnAccount();
    }

    @Test(dataProvider = "test-data")
    public void negativeSignUp(String[] data)  {
        signUpPage.signUp(data[0],data[1],data[2],data[3],data[4],data[5]);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(signUpPage.getErrMessageMail(),data[8]);
        System.out.println(signUpPage.getErrMessageMail());
        softAssert.assertEquals(signUpPage.getErrMessagePassword(),data[9]);
        softAssert.assertEquals(signUpPage.getErrMessagePhone(),data[10]);
        softAssert.assertEquals(signUpPage.getErrMessageBirthDate(),data[11]);
        softAssert.assertAll();
    }

}
