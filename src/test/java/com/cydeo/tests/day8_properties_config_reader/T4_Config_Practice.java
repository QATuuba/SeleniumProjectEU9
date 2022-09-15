package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T4_Config_Practice {

    /*
        public WebDriver driver;
//
    @BeforeMethod
    public void setupMethod(){
//
//        //We are getting the browserType dynamically from our configuration.properties file
        String browserType = ConfigurationReader.getProperty("browser");
        driver = WebDriverFactory.getDriver(browserType);
//
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("https://www.google.com");
        driver.findElement(By.id("L2AGLb")).click();
//
    }

     */

    @Test
    public void google_search_test() {
        //Driver.getDriver() --> driver

        Driver.getDriver().get("https://www.google.com");
        Driver.getDriver().findElement(By.id("L2AGLb")).click();

        WebElement googleSearchBox = Driver.getDriver().findElement(By.xpath("//input[@name=\"q\"]"));

        //3- Write “apple” in search box
        googleSearchBox.sendKeys(ConfigurationReader.getProperty("searchValue")+ Keys.ENTER);

        //4- Verify title:
        //Expected: apple - Google Search
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = ConfigurationReader.getProperty("searchValue") + " - Google Search";

        Assert.assertEquals(actualTitle, expectedTitle);

    }


}
