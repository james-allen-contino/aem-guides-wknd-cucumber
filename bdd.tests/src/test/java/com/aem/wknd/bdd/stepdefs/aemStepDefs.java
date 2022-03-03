package com.aem.wknd.bdd.stepdefs;

import io.cucumber.java.Scenario;
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

import java.time.Duration;

import com.aem.wknd.bdd.pages.DashboardPage;
import com.aem.wknd.bdd.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class aemStepDefs {

    private Scenario scenario;
    
    public WebDriver driver;

    private LoginPage loginPage;

    private DashboardPage dashboardPage;


    public aemStepDefs() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
	public void before(Scenario scenario) {
		this.scenario = scenario;
		driver = new ChromeDriver();
		this.loginPage = new LoginPage(driver);
        this.dashboardPage = new DashboardPage(driver);;

    @Given("user navigates to login page")
    public void userNavigatesToLoginPage() {
        loginPage.open();
    //     System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
    //     ChromeOptions options = new ChromeOptions();
    //     options.addArguments("--headless");
    //     driver = new ChromeDriver(options);
    //     driver.get("http://localhost:4502");
    // }

    @When("user logs in as admin")
    public void userLogsInAsAdmin() {
        //move complexity to page object (loginPage)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("admin");
        driver.findElement(By.id("submit-button")).click();
    }

    @Then("user sees admin landing page")
    public void userSeesAdminLandingPage() {
        //move complexity to page object (dashboardPage)
        String titleText = driver.findElement(By.className("granite-title")).getText();
        Assert.assertEquals("Navigation", titleText);
        driver.close();
    }
}
