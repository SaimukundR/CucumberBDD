package stepDefinitions;

import java.io.IOException;

import Utility.Setup;
import Utility.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class  HomepageStepDefinitions {
	Setup utilities;
	
	public HomepageStepDefinitions(Setup utilities) {
    	this.utilities= utilities;
    }
	
	
	@Given("User lands on GreenCart website")
    public void user_lands_on_green_cart_website() throws IOException {
		//utilities.testbase.WebDriverManager();
    }
	
	

    @When("^user searches with (.+) and (.+) and validates the results and navigates on offers page$")
    public void user_searches_with_name_and_validates_the_results(String name, String quantity) {
    	utilities.pageObjectManager.homePage(utilities.testbase.driver,utilities).searchItemAndValidate(name,quantity);
    }
    
    @When("^user searches with (.+) and (.+) and (.+) to the basket$")
    public void user_searches_and_to_the_basket(String name, String quantity, Integer numberOfItems) {
    	utilities.pageObjectManager.homePage(utilities.testbase.driver,utilities).searchItemIncreaseQuantityAndAddToBasket(name, quantity, numberOfItems);
    }

}
