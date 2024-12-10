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

public class ContactPageTest extends TestBase{
	ContactPage contactpage;
	LoginPage loginpage;
	HomePage homepage;
	
	public ContactPageTest() {
		super();
	}	
	
	@BeforeMethod
	public void setup() {
		initialization();		
		contactpage = new ContactPage();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));	
		contactpage = homepage.click_contact_lnk();
	}
	
	@Test(priority=1)
	public void contactPageTitleTest() {		
		String title = contactpage.validateContactPageTitle();
		assertEquals(title, "Contact | Practice Test Automation | Selenium WebDriver", "Contact page title not matched");
	}
	
	@Test(priority=2)
	public void verifyContact_txt() {		
		Assert.assertTrue(contactpage.validate_contact_txt());
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	

}
