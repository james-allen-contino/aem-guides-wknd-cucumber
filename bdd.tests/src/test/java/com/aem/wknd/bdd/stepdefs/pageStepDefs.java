package com.aem.wknd.bdd.stepdefs;

import com.aem.wknd.bdd.pages.DashboardPage;
import com.aem.wknd.bdd.pages.LoginPage;
import com.aventstack.extentreports.gherkin.model.Scenario;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class pageStepDefs {

    private Scenario scenario;
    
    public WebDriver driver;

    private LoginPage loginPage;

    private DashboardPage dashboardPage;

    public pageStepDefs() {
        WebDriverManager.chromedriver().setup();
    }
    @Before
	public void before(Scenario scenario) {
		this.scenario = scenario;
		driver = new ChromeDriver();
		this.loginPage = new LoginPage(driver);
        this.dashboardPage = new DashboardPage(driver);
    }
    
    // @Given("user visits some-site")
    // public void userVisitsSomeSite() {
    // }

    // @When("page is rendered")
    // public void pageIsRendered() {
    // }

    // @Then("title is Hello World")
    // public void titleIsHelloWorld() {
    // }
}
