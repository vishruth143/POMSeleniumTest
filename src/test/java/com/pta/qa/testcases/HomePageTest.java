package com.pta.qa.testcases;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pta.qa.base.TestBase;
import com.pta.qa.pages.ContactPage;
import com.pta.qa.pages.HomePage;
import com.pta.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	Logger log;
	HomePage homepage;
	LoginPage loginpage;
	ContactPage contactpage;
	
	public HomePageTest() {
		super();
		log = Logger.getLogger(HomePageTest.class);
	}	
	
	@BeforeMethod
	public void setup() throws MalformedURLException {
		initialization();
		initializeReport();
		loginpage = new LoginPage();
		contactpage = new ContactPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));		
	}
	
	@Test(priority=1)
	public void homePageTitleTest() {		
		String title = homepage.validate_homepage_title();
		assertEquals(title, "Logged In Successfully | Practice Test Automation", "Home page title not matched");
	}
	
	
	@Test(priority=2)
	public void loggedInSuccessfullyTest() {		
		Assert.assertTrue(homepage.validate_loggedinsuccessfully_txt());
	}
	
	@Test(priority=3)
	public void logoutTest() {		
		homepage.click_logout_btn();
	}
	
	@Test(priority=4)
	public void contactLinkTest() {		
		contactpage = homepage.click_contact_lnk();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
