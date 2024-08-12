package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utility.GenericUtility;
import Utility.Setup;

public class Offerpage {
Setup utilities;
WebDriver driver;
    public Offerpage(WebDriver driver, Setup utilities) {
    	this.driver= driver;
    	this.utilities= utilities;
    }
   
    
    public void searchItemAndValidate(String name) {
	
    	utilities.genericUtility.waitUntilElementVisible(By.cssSelector("#search-field")).sendKeys(name);
    utilities.offerpagePrice = utilities.genericUtility.waitUntilElementVisible(By.xpath("//td[normalize-space()='" + name + "']/following-sibling::td[2]")).getText().trim();
}
    public boolean validatePrices() {
    	System.out.println("Homepage Price: " + utilities.homepagePrice);
        System.out.println("Offerpage Price: " + utilities.offerpagePrice);
        System.out.println("Homepage Name: " + utilities.homepageName);
        try {
            int homePrice = Integer.parseInt(utilities.homepagePrice);
            int offerPrice = Integer.parseInt(utilities.offerpagePrice);
            if (homePrice == offerPrice) {
                System.out.println("Prices are the same");
            } else {
                System.out.println("Prices are different");
                utilities.flag= true;
            }
        } catch (NumberFormatException e) {
            System.err.println("Invalid string format for price: " + e.getMessage());
        }
        
    return utilities.flag;
    }
    
    
}
