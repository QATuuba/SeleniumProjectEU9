package com.cydeo.tests.day11_actions_jsexecutor_practic;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Circle_Drag_N_Drop2 {

    @Test
    public void test_drag_drop() {

            // TC #: Drag and drop
            //1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index //****** This website has some problems so i used cydeo drag and drop
            Driver.getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");

        /*
        //Locate "Accept Cookies" button and click
        WebElement acceptCookiesButton = Driver.getDriver().findElement(By.id("onetrust-accept-btn-handler"));
        acceptCookiesButton.click();

         */

            // Locate small and big circles to be able to drag them around
            WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
            WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));

            //2. Drag and drop the small circle to bigger circle.
            Actions action = new Actions(Driver.getDriver());
            action.dragAndDrop(smallCircle, bigCircle).perform();
        /*action.clickAndHold(smallCircle)
                .pause(2000)
                .moveToElement(bigCircle)
                .pause(2000)
                .release()
                .perform();

         */


            //3. Assert:
            //-Text in big circle changed to: “You did great!”
            String actualBigCircleText = bigCircle.getText();
            String expectedBigCircleText = "You did great!";

            Assert.assertEquals(actualBigCircleText, expectedBigCircleText);


        }


    }
