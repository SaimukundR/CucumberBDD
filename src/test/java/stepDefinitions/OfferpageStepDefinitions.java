package stepDefinitions;

import org.testng.Assert;

import PageObjects.Offerpage;
import Utility.Setup;
import Utility.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OfferpageStepDefinitions  {
	
Setup utilities;   
    public OfferpageStepDefinitions(Setup utilities) {
    	this.utilities= utilities;
    }
	 @And("^user searches with (.+) in offers page and validates the results$")
	    public void user_searches_with_name_in_offers_page_and_validates_the_results(String name) {
		 utilities.pageObjectManager.OfferPage(utilities.testbase.driver, utilities).searchItemAndValidate(name);
	    }

	    @Then("validates the price in offers page and homepage")
	    public void validates_the_price_in_offers_page_and_homepage() {
	     boolean flagValue= utilities.pageObjectManager.OfferPage(utilities.testbase.driver, utilities).validatePrices(); 
	     Assert.assertTrue(flagValue);
}
}
