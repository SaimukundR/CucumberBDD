package runners;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src\\test\\java\\features\\OrderPlacement.feature",
	    glue = {"stepDefinitions"},
	    tags="@productCartValidation or @productPriceValidation",
	    plugin = {
	        "pretty",
	        "html:target/cucumber-reports.html",
	        "json:target/cucumber.json",
	        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
	        "rerun:target/failed_scenarios.txt"
	    }
	)
public class TestNGTestrunner2 extends AbstractTestNGCucumberTests {
     
	@Override
	@DataProvider(parallel=false)
	public Object[][] scenarios(){
		return super.scenarios();
	}
}


