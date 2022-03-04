package com.aem.wknd.bdd.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.LoginPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;

import java.time.Duration;

public class aemStepDefs {
    private TestContextSetup testContextSetup;
    private LoginPage loginPage;

    public aemStepDefs(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.loginPage = testContextSetup.pageObjectManager.getLoginPage();
    }

    @Given("user navigates to login page")
    public void userNavigatesToLoginPage() {
        Assert.assertNotNull(loginPage);
    }

    @When("user logs in as admin")
    public void userLogsInAsAdmin() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        loginPage.enterPassword("admin");
        loginPage.enterUsername("admin");
        loginPage.submitCreds();
    }

    @Then("user sees admin landing page")
    public void userSeesAdminLandingPage() {
        String titleText = driver.findElement(By.className("granite-title")).getText();
        Assert.assertEquals("Navigation", titleText);
        driver.close();
    }

    @Given("user is logged in as admin")
    public void userIsLoggedInAsAdmin() {
    }

    @When("user creates a new page object")
    public void userCreatesANewPageObject() {
    }

    @Then("user sees new page")
    public void userSeesNewPage() {
    }
}
