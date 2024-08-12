package Utility;

import java.io.IOException;

import PageObjects.PageObjectManager;

public class Setup {
    public String homepagePrice;
    public String offerpagePrice;
    public String homepageName;
    public boolean flag= false;
    public PageObjectManager pageObjectManager;
    public TestBase testbase;
    public GenericUtility genericUtility;
    Setup utilities;
    public Setup() throws IOException {
    	testbase = new TestBase();
    	genericUtility = new GenericUtility(testbase.WebDriverManager());
    	pageObjectManager  = new PageObjectManager(testbase.WebDriverManager(), utilities);
    	
    }
     

}
