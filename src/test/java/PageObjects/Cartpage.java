package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Utility.Setup;

public class Cartpage {
	
WebDriver driver;
 Setup utilities;   
 
    public Cartpage(WebDriver driver, Setup utilities) {
    	
    	this.driver= driver;	
    	this.utilities= utilities;
    }
    
    public void proceedToCheckout() {
        String cartIconXpath = "//a[@class='cart-icon']";
        String proceedToCheckoutXpath = "//button[contains(text(),'PROCEED TO CHECKOUT')]";

        utilities.genericUtility.waitUntilElementVisible(By.xpath(cartIconXpath));
        utilities.genericUtility.clickElementWithRetry(driver.findElement(By.xpath(cartIconXpath)), cartIconXpath);

        utilities.genericUtility.waitUntilElementVisible(By.xpath(proceedToCheckoutXpath));
        utilities.genericUtility.clickElementWithRetry(driver.findElement(By.xpath(proceedToCheckoutXpath)), proceedToCheckoutXpath);
    }

    public String placeOrder(Integer quantity) {
    	
    	String actualName= driver.findElement(By.xpath("//p[@class='product-name']")).getText().split("-")[0].trim();
    	String numberOfItems = driver.findElement(By.cssSelector(".quantity")).getText().split(" ")[0].trim();
    	int actualQuantity= Integer.parseInt(numberOfItems);
    	Assert.assertEquals(actualQuantity, quantity);
        String placeOrderXpath = "//button[contains(text(),'Place Order')]";
        utilities.genericUtility.waitUntilElementVisible(By.xpath(placeOrderXpath));
        utilities.genericUtility.clickElementWithRetry(driver.findElement(By.xpath(placeOrderXpath)), placeOrderXpath);
         return actualName;
       
    }

    public void fillOrderDetails() {
        // Example of filling out the order form
//        driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Your Name");
//        driver.findElement(By.cssSelector("input[name='address']")).sendKeys("Your Address");
//        driver.findElement(By.cssSelector("input[name='zip']")).sendKeys("Your ZIP Code");

        
    // Select country from dropdown (example)
    	utilities.genericUtility.waitUntilElementVisible(By.tagName("select"));
    	Select countryDropdown = new Select(driver.findElement(By.tagName("select")));
        countryDropdown.selectByVisibleText("India");

        // Agree to terms and conditions (example)
        driver.findElement(By.cssSelector("input[type='checkbox']")).click();
    }

    public String confirmOrder() {
        String confirmOrderXpath = "//button[contains(text(),'Proceed')]";
        utilities.genericUtility.waitUntilElementVisible(By.xpath(confirmOrderXpath));
        utilities.genericUtility.clickElementWithRetry(driver.findElement(By.xpath(confirmOrderXpath)), confirmOrderXpath);
        String actualConfirmation= driver.findElement(By.xpath("//div[@id='root']")).getText();
       
         
        return actualConfirmation;
       
    }

}
