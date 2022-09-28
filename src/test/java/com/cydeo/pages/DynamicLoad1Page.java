package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoad1Page {

    public DynamicLoad1Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[.=\"Start\"]")
    public WebElement startButton;

    //@FindBy(xpath = "//div[@id=\"loading\"]")
    @FindBy(css = "div#loading")
    public WebElement loadingBar;

    //@FindBy(xpath = "//input[@type=\"username\"]")
    @FindBy(css = "#username")
    public WebElement inputUsername;

    @FindBy(xpath = "//input[@type=\"password\"]")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement submitButton;

    @FindBy(xpath = "//div[@class=\"flash error\"]")
    public WebElement errorMessage;

}
