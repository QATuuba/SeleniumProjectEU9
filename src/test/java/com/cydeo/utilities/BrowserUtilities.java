package com.cydeo.utilities;

/*
In this class only general utility methods that are NOT related to some specific page.
 */

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BrowserUtilities {

    /*
    This method will accept int (in seconds) and execute Thread.sleep
    for given duration
     */

    public static void sleep(int second){
        second *= 1000;
        try {
            Thread.sleep(second);
        }catch (InterruptedException e){

        }
    }



    public static void SwitchWindowAndVerify(WebDriver driver, String expectedInURL, String expectedInTitle){
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
            System.out.println("Current URL: " + driver.getCurrentUrl());
            if (driver.getCurrentUrl().contains(expectedInURL)){
                break;
            }
        }

        String actualTitle = driver.getTitle();


        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }

    /*
    This method accepts 3 arguments.
    Arg1: webdriver
    Arg2: expectedInUrl : for verify if the url contains given String.
        - If condition matches, will break loop.
    Arg3: expectedInTitle to be compared against actualTitle
     */

    public static void verifyTitle(WebDriver driver, String expectedTitle){

        Assert.assertEquals(driver.getTitle(), expectedTitle);

    }



}
