package com.selenium.course;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Slf4j
public class SimpleTest {
    WebDriver driver = null;

    @BeforeTest
    public void setupDriver(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void executeSimpleTest() throws InterruptedException {
        driver.get("https://zoomagazin.eu/");

//        WebElement logInDropMenu = driver.findElement(By.xpath("//a[contains(@class,'logInOut')]"));
//        logInDropMenu.click();
//        WebElement inputEmail = driver.findElement(By.id("headerLoginMail"));
//        inputEmail.sendKeys("satanislaw@yahoo.com");
//        WebElement inputPass = driver.findElement(By.id("headerLoginPassword"));
//        inputPass.sendKeys("666");
//        WebElement logInButton = driver.findElement(By.xpath("//*[@id=\"headerLoginForm\"]/button[1]"));
//        logInButton.click();
//        Thread.sleep(6000);
//
//        WebElement userProfileButton = driver.findElement(By.xpath("//div[@class = 'col-md-3']/a[1]"));
//        Assert.assertEquals(userProfileButton.getText(),"Станислав");

        WebElement dogsMenu = driver.findElement(By.xpath("//div[contains(@class,'main-navigation')]//a[text()='КУЧЕТА']"));
        dogsMenu.click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[contains(@href,'/bg/kategorii/hrani-i-lakomstva-27073')]")).click();

        WebElement dryFoodByBrand = driver.findElement(By.xpath("//h3[contains(text(),'сухи храни')]//parent::div//li[text()=\"alpha spirit\"]"));
        dryFoodByBrand.click();
        Thread.sleep(3000);


        driver.manage().window().maximize();

        WebElement productSamplePlusOneButton = driver.findElement(By.xpath("//a[contains(text(),'Alpha Spirit Only Fish - полусуха храна 85% прясно месо 5.67 кг. / 27 монодози по 210 грама /')]//ancestor::div[@id='contentProduct']//button[contains(@onclick,'addOneToField')]"));
        productSamplePlusOneButton.click();
        productSamplePlusOneButton.click();
        WebElement cart = driver.findElement(By.xpath("//a[contains(text(),'Alpha Spirit Only Fish - полусуха храна 85% прясно месо 5.67 кг. / 27 монодози по 210 грама /')]//ancestor::div[@id='contentProduct']//button[@id='my-add-button']"));
//        driver.manage().window().setPosition(cart.getLocation());
        Thread.sleep(3000);

        cart.click();


        Thread.sleep(6000);


    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}
