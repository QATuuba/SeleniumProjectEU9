package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T3_Actions_Hover {

    @Test
    public void hovering_test() {
        //1. Go to https://practice.cydeo.com/hovers
        Driver.getDriver().get("https://practice.cydeo.com/hovers");

        //Locate all images under here:
        WebElement img1 = Driver.getDriver().findElement(By.xpath("(//img)[1]"));
        WebElement img2 = Driver.getDriver().findElement(By.xpath("(//img)[2]"));
        WebElement img3 = Driver.getDriver().findElement(By.xpath("(//img)[3]"));

        //Locate all the "user" texts under here:
        WebElement text1 = Driver.getDriver().findElement(By.xpath("(//h5)[1]"));
        WebElement text2 = Driver.getDriver().findElement(By.xpath("(//h5)[2]"));
        WebElement text3 = Driver.getDriver().findElement(By.xpath("(//h5)[3]"));


        //2. Hover over to first image
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(img1).perform();

        //3. Assert:
        //a. “name: user1” is displayed
        Assert.assertTrue(text1.isDisplayed());

        //4. Hover over to second image
        actions.moveToElement(img2).perform();

        //5. Assert:
        //a. “name: user2” is displayed
        Assert.assertTrue(text2.isDisplayed());

        //6. Hover over to third image
        actions.moveToElement(img3).perform();

        //7. Confirm:
        //a. “name: user3” is displayed
        Assert.assertTrue(text3.isDisplayed());


    }

}
