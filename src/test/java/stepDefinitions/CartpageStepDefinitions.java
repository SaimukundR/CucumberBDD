package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;
//import org.assertj.core.api.Assertions;
import Utility.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CartpageStepDefinitions {
	Setup utilities;
	String confirmation = "GREENKART\nThank you, your order has been placed successfully\nYou'll be redirected to Home page shortly!!"
			.trim();

	public CartpageStepDefinitions(Setup utilities) {
		this.utilities = utilities;
	}

	@And("user selects cart page and proceeds to checkout and validates")
	public void user_selects_cart_page_and_proceeds_to_checkout() throws IOException {
		utilities.pageObjectManager.CartpagePage(utilities.testbase.driver, utilities).proceedToCheckout();
	}

	@And("^validates the product (.+) and (.+) then clicks on place order$")
	public void validates_the_product_name_clicks_on_place_order(String Name, Integer Quantity) throws IOException {
		String actual = utilities.pageObjectManager.CartpagePage(utilities.testbase.driver, utilities).placeOrder(Quantity);
		Assert.assertEquals(actual, Name);
	}

	@Then("user enters the country agrees terms and conditions then places the order")
	public void user_enters_the_country_agrees_terms_and_conditions_then_places_the_order() throws IOException {
		utilities.pageObjectManager.CartpagePage(utilities.testbase.driver, utilities).fillOrderDetails();
		String actual = utilities.pageObjectManager.CartpagePage(utilities.testbase.driver, utilities).confirmOrder();
		Assert.assertEquals(actual, confirmation);
	}
}
