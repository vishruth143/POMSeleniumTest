package com.pta.qa.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.pta.qa.base.TestBase;
import com.pta.qa.pages.ContactPage;
import com.pta.qa.pages.HomePage;
import com.pta.qa.pages.LoginPage;
import com.pta.qa.util.TestUtil;

public class ContactPageTest extends TestBase {
	Logger log;
	ContactPage contactpage;
	LoginPage loginpage;
	HomePage homepage;	
	String sheetName = "Contacts";

	public ContactPageTest() {
		super();
		log = Logger.getLogger(ContactPageTest.class);
	}
	
	@BeforeSuite
	public void reportSetup() {
		initializeReport();
	}

	@BeforeMethod
	public void setup() throws MalformedURLException {
		initialization();		
		contactpage = new ContactPage();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactpage = homepage.click_contact_lnk();
	}	


	@Test(priority = 1)
	public void contactPageTitleTest() {
		String title = contactpage.validate_contactpage_title();
		String methodName = new Exception().getStackTrace()[0].getMethodName();		
		String className = new Exception().getStackTrace()[0].getClassName();
		test = extent.createTest(methodName, "Sign in and verify the page title");
		test.log(Status.INFO, "Sign in to PTA Application");
		test.assignCategory("Regression");
		test.log(Status.INFO, "Verify the page title");
		assertEquals(title, "Contact | Practice Test Automation | Selenium WebDriver",
				"Contact page title not matched");		
	}
	
	@Test(priority = 2)
	public void contactPageTitleTestFailed() {
		String title = contactpage.validate_contactpage_title();
		String methodName = new Exception().getStackTrace()[0].getMethodName();		
		String className = new Exception().getStackTrace()[0].getClassName();
		test = extent.createTest(methodName, "Sign in and verify the page title");
		test.log(Status.INFO, "Sign in to PTA Application");
		test.assignCategory("Regression");
		test.log(Status.INFO, "Verify the page title");
		assertEquals(title, "Contact | Practice Test Automation | Selenium WebDriver1",
				"Contact page title not matched");		
	}
	
	

	@Test(priority = 3)
	public void contactLinkTest() {
		Assert.assertTrue(contactpage.validate_contact_txt());
	}

	@DataProvider
	public Object[][] getPTATestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 4, dataProvider = "getPTATestData")
	public void fillContactFormTest(String fn, String ln, String email, String comment) throws IOException {
		// contactpage.fill_contact_form("Test", "Test", "test@test.com", "Test Practice
		// Test Automation");
		contactpage.fill_contact_form(fn, ln, email, comment);
		TestUtil.takeScreenShotAtEndOfTest();
	}

	@AfterMethod
	public void teardown() {		
		driver.quit();
	}
	
	@AfterSuite
	public void reportClosure() {
		if (TestUtil.extent != null) {
	        TestUtil.extent.flush();
	    }
	}	
}
