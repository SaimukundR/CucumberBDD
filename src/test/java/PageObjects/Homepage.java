package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.Setup;

public class Homepage {
	
WebDriver driver;
 Setup utilities;   
 
 
    public Homepage(WebDriver driver, Setup utilities) {
    	
    	this.driver= driver;	
    	this.utilities= utilities;
    }
    
    public void searchItemAndValidate(String name, String quantity) {
    	driver.findElement(By.cssSelector(".search-keyword")).sendKeys(name);
    	utilities.genericUtility.waitUntilElementVisible(By.xpath("//div[@class='products']/div/h4[normalize-space()='" + name + " - "+quantity+" Kg']"));
    	utilities.homepageName =utilities.testbase.driver.findElement(By.xpath("//div[@class='products']/div/h4[normalize-space()='" + name + " - "+quantity+" Kg']")).getText();
        utilities.homepagePrice = utilities.testbase.driver.findElement(By.xpath("//div[@class='products']/div/h4[normalize-space()='" + name + " - "+quantity+" Kg']/following-sibling::p")).getText().trim();
        utilities.testbase.driver.findElement(By.linkText("Top Deals")).click();
        utilities.genericUtility.switchToChildWindow();
    }
    
    public void searchItemIncreaseQuantityAndAddToBasket(String Name, String Quantity, Integer numberOfItems) {
        // Enter the search keyword
        driver.findElement(By.cssSelector(".search-keyword")).sendKeys(Name);

        // Wait until the specific product is visible
        utilities.genericUtility.waitUntilElementVisible(By.xpath("//div[@class='products']/div/h4[normalize-space()='" + Name + " - " + Quantity + " Kg']"));

        // Define the XPath for the product stepper and the add to basket button
        String productStepperXpath = "//div[@class='products']/div/h4[@class='product-name']/parent::div//div[@class='stepper-input']/a[@class='increment']";
        String addToBasketXpath = "//div[@class='products']/div/h4[@class='product-name']/parent::div//div[@class='product-action']/button";

        // Wait until the stepper is visible
        utilities.genericUtility.waitUntilElementVisible(By.xpath(productStepperXpath));

        // Find the product stepper element
        WebElement productStepper = driver.findElement(By.xpath(productStepperXpath));

        // Retry mechanism for clicking the stepper
        for (int i = 1; i <= numberOfItems; i++) {
        	utilities.genericUtility.clickElementWithRetry(productStepper, productStepperXpath);
        }

        // Retry mechanism for clicking the add to basket button
        utilities.genericUtility.clickElementWithRetry(driver.findElement(By.xpath(addToBasketXpath)), addToBasketXpath);
    }

    
    
    
    

}
