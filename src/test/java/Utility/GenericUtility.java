package Utility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.PageObjectManager;

public class GenericUtility {
	WebDriver driver;
	public WebDriverWait wait ;
	public GenericUtility(WebDriver driver) {
		this.driver= driver;
	}
	 public WebElement waitUntilElementVisible(By locator) {
		   wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        return wait.ignoring(StaleElementReferenceException.class)
	                .until(ExpectedConditions.visibilityOfElementLocated(locator));
	    }
	 public void switchToChildWindow() {
	        Set<String> windowsSet = driver.getWindowHandles();
	        Iterator<String> it = windowsSet.iterator();
	        String parentWindow = it.next();
	        String childWindow = it.next();
	        driver.switchTo().window(childWindow);
	    }
	 
	 public void clickElementWithRetry(WebElement element, String xpath) {
	        int attempts = 0;
	        while (attempts < 3) {
	            try {
	                element.click();
	                break; // Exit the loop if click is successful
	            } catch (StaleElementReferenceException e) {
	                attempts++;
	                element = driver.findElement(By.xpath(xpath)); // Re-find the element
	            }
	        }
	        if (attempts == 3) {
	            throw new StaleElementReferenceException("Element not found after 3 attempts");
	        }
	    }

}
