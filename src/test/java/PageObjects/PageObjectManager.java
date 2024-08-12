package PageObjects;

import org.openqa.selenium.WebDriver;

import Utility.Setup;

public class PageObjectManager {
	WebDriver driver;
	 Setup utilities;   
	    public PageObjectManager(WebDriver driver, Setup utilities) {
	    	
	    	this.driver= driver;	
	    	this.utilities= utilities;
	    }
	    
	    public Homepage homePage(WebDriver driver,Setup utilities) {
	    	Homepage homePage = new Homepage(driver, utilities);
	    	return homePage;
	    }
	    
	    public Offerpage OfferPage(WebDriver driver,Setup utilities) {
	    	Offerpage offerPage = new Offerpage(driver, utilities);
	    	return offerPage;
	    }
	    
	    public Cartpage CartpagePage(WebDriver driver,Setup utilities) {
	    	Cartpage Cartpage = new Cartpage(driver, utilities);
	    	return Cartpage;
	    }
}
