package com.aem.wknd.bdd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;
   
    //declare web elements here!
    //an example below
    //@FindBy(how = How.XPATH, using = "//button[@type='submit']")
    //private WebElement btnLogin;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        
    }

    public void open() {
         //this.driver.navigate().to("INSERT URL HERE");
	}

    public void login() {

    }
    
}
