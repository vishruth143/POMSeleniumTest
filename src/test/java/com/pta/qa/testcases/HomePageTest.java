package com.pta.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pta.qa.base.TestBase;
import com.pta.qa.pages.ContactPage;
import com.pta.qa.pages.HomePage;
import com.pta.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	HomePage homepage;
	LoginPage loginpage;
	ContactPage contactpage;
	
	public HomePageTest() {
		super();
	}	
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
		contactpage = new ContactPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));		
	}
	
	@Test(priority=1)
	public void homePageTitleTest() {		
		String title = homepage.validateHomePageTitle();
		assertEquals(title, "Logged In Successfully | Practice Test Automation", "Home page title not matched");
	}
	
	
	@Test(priority=2)
	public void verifyLoggedInSuccessfully_txt() {		
		Assert.assertTrue(homepage.validate_loggedInSuccessfully_txt());
	}
	
	@Test(priority=3)
	public void logout() {		
		homepage.click_logout_btn();
	}
	
	@Test(priority=4)
	public void verifyContactLinkTest() {		
		contactpage = homepage.click_contact_lnk();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
