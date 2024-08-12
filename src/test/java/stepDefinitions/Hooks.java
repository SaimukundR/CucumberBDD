package stepDefinitions;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Utility.Setup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks  {
	
Setup utilities;   
    public Hooks(Setup utilities) {
    	this.utilities= utilities;
    }
	
	
	@Before("@tag1")
	public void runTag1() {
		System.out.println("Hooks before background of tag1");
	}
	@After
	public void closeTabs() {
	utilities.testbase.driver.quit();
	}
	
	@After
	public void addScreenshot(Scenario scenario) throws IOException {
	if(scenario.isFailed()) {
		System.out.println("scenario failed");
	   File sourcePath=  ((TakesScreenshot)utilities.testbase.driver).getScreenshotAs(OutputType.FILE);
	   byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
	   scenario.attach(fileContent, "img/png", "image");
	}
	}
	
	@Before
	public static void startExtentReport() {
		System.setProperty("extent.reporter.html.start", "true");
		System.setProperty("extent.reporter.html.out", "test-output/HtmlReport/ExtentHtml.html");
	}

}
