package com.jonathanhaslop.test;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.jonathanhaslop.util.Reporter;
import com.jonathanhaslop.pom.Page;
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
	private Page page;
	
	@Before
	public void initWebDriver() {
		this.driver = SingletonDriver.getSingletonInstance(this.driver);
		this.page = new Page(this.driver);
	}
	
	@Given("^I navigate to homePage$")
	public void i_navigate_to_homePage() {
		page.visit(Propertie.readPropertie("url"));
	}

	@When("^I search for \"([^\"]*)\" on the searchBox$")
	public void i_search_for_item_on_the_searchBox(String item) {
		page.homePage.searchItem(driver, item);
	}

	@And("^I navegate to the second page from the related list$")
	public void i_navegate_to_the_second_page_from_the_related_list() {
		page.homePage.NextPage(driver);
		System.out.println(page.homePage.getFirstListElementID());
	}

	@Then("^There must be at least one item to be bought$")
	public void there_must_be_at_least_one_item_to_be_bought() {
		page.homePage.waitRelatedNextPage();
		Assert.assertEquals(true, page.homePage.hasAtLeastOneItem());
		System.out.println(page.homePage.getFirstListElementID());
	}
	
	
	/* REPORT METHODS */
	
	@After(order = 0)
	public void afterScenarioFinish() {
		Reporter.afterScenarioFinish(this.driver);
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		Reporter.tearDown(scenario, this.driver);
	}
	
}
