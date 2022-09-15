package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebTableUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_WebTable_Order_Verify {

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/web-tables");

    }

    @Test
    public void order_name_verify_test() {

        //Locate the cell that has Bob Martin text in it.
        WebElement bobMartinCell = driver.findElement(By.xpath("//Table[@id='ctl00_MainContent_orderGrid']/tbody/tr[7]/td[2]"));

        //System.out.println("bobMartinCell.getText() = " + bobMartinCell.getText());


        //2. Verify Bob’s name is listed as expected.
        //Expected: “Bob Martin”
        String expectedBobName = "Bob Martin";
        String actualBobName = bobMartinCell.getText();

        Assert.assertEquals(actualBobName,expectedBobName);

        //3. Verify Bob Martin’s order date is as expected
        //Expected: 12/31/2021

        WebElement bobMartinOrderDate = driver.findElement(By.xpath("//Table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']/following-sibling::td[3]"));
        String actualBobDate = bobMartinOrderDate.getText();
        String expectedBobDate = "12/31/2021";

        Assert.assertEquals(actualBobDate, expectedBobDate);

        // alternative locator to bobMartinDateCell = "//td[.='Bob Martin']/../td[5]"


    }

    @Test
    //Method #2 info:
    public void test2(){
        String customerOrderDate1 = WebTableUtilities.returnOrderDate(driver, "Alexandra Gray");
        System.out.println("customerOrderDate1 = " + customerOrderDate1);

        String customerOrderDate2 = WebTableUtilities.returnOrderDate(driver, "John Doe");
        System.out.println("customerOrderDate2 = " + customerOrderDate2);
    }

    //Using WebTableUtils.orderVerify(); method
    @Test
    public void test3() {

        WebTableUtilities.orderVerify(driver, "Bart Fisher", "01/16/2021");

    }


    }
