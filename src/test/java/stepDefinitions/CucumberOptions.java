package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CucumberOptions {
	
	@Given("user lands on webPage")
	public void userOnWebpage() {
		System.out.println("1/4");
	}
	
	@When("user lands on homepage")
	public void userOnHomepage() {
		System.out.println("2nd background is run");
	}
	
	@Then("clears the cache")
	public void clearsTheCache() {
		System.out.println("3rd background is run");
	}
	

	@Given("user is on website")
	public void user_is_on_website() {
	    System.out.println("is landed on wwebsite");
	}

	@When("user logs in to application")
	public void user_logs_in_to_application() {
		  System.out.println("logins to application");
	}

	@Then("homepage is displayed")
	public void homepage_is_displayed() {
		  System.out.println("Home page is displayed");
	}

	@Then("check more outcomes")
	public void check_more_outcomes() {
		System.out.println("other scenarios validated");
	}

}
