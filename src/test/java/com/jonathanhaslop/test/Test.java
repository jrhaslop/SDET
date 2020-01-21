package com.jonathanhaslop.test;

import org.openqa.selenium.WebDriver;

import com.jonathanhaslop.util.Reporter;
import com.jonathanhaslop.util.Propertie;
import com.jonathanhaslop.webdriver.SingletonDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test {

	private WebDriver driver;
	
	@Before
	public void initWebDriver() {
		this.driver = SingletonDriver.getSingletonInstance(this.driver);
	}
	
	@Given("^I navigate to homePage$")
	public void i_navigate_to_homePage() {
		this.driver.get(Propertie.readPropertie("url"));
	}
	
	@When("^I search for \"([^\"]*)\" on the searchBox$")
	public void i_search_for_on_the_searchBox(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
	}

	@And("^I navegate to the second page from the related list$")
	public void i_navegate_to_the_second_page_from_the_related_list() {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("^There must be at least one item to be bought$")
	public void there_must_be_at_least_one_item_to_be_bought() {
	    // Write code here that turns the phrase above into concrete actions
	}
	
	@After(order = 0)
	public void afterScenarioFinish() {
		Reporter.afterScenarioFinish(this.driver);
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		Reporter.tearDown(scenario, this.driver);
	}
	
}
