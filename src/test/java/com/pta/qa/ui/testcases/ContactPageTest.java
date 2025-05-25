package com.pta.qa.ui.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.pta.qa.base.TestBase;
import com.pta.qa.pages.ContactPage;
import com.pta.qa.pages.HomePage;
import com.pta.qa.pages.LoginPage;
import com.pta.qa.util.RetryAnalyzer;
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

//	@Test(priority = 1, threadPoolSize = 3, invocationCount = 3, timeOut = 1000)
	@Test
	public void contactPageTitleTest() throws IOException {
		/*
        CONTACT Page - Test #01: Verify Practice Test Automation [PTA] Application 'CONTACT' page title.
        Steps:
        01) Get PTA 'CONTACT' page title.
        02) Verify the 'CONTACT' page title.
        */
		String className = new Exception().getStackTrace()[0].getClassName();
		String methodName = new Exception().getStackTrace()[0].getMethodName();		
		test = extent.createTest(className+" : "+methodName, "CONTACT Page - Test #01: Practice Test Automation [PTA] Application 'CONTACT' page title.");
		test.assignCategory("CONTACT Page");		
		
		log.info("*".repeat(100));
		test.log(Status.INFO, "*".repeat(100));
		
		log.info("CONTACT Page - Test #01: Verify Practice Test Automation [PTA] Application 'CONTACT' page title.");
		test.log(Status.INFO, "CONTACT Page - Test #01: Verify Practice Test Automation [PTA] Application 'CONTACT' page title.");
		
		log.info("*".repeat(100));
		test.log(Status.INFO, "*".repeat(100));
		
		try {
			log.info("Step 01: Get PTA 'CONTACT' page title.");
			test.log(Status.INFO, "Step 01: Get PTA 'CONTACT' page title.");
			String title = contactpage.validate_contactpage_title();
			
			log.info("Step 02: Verify the 'CONTACT' page title.");
			test.log(Status.INFO, "Step 02: Verify the 'CONTACT' page title.");
			assertEquals(title, "Contact | Practice Test Automation | Selenium WebDriver",
				"Contact page title not matched");
			
			log.info("CONTACT Page - Test #01: Verify Practice Test Automation [PTA] Application 'CONTACT' page title - Passed");
			test.log(Status.INFO, "CONTACT Page - Test #01: Verify Practice Test Automation [PTA] Application 'CONTACT' page title - Passed");
		}catch(AssertionError ae) {
			TestUtil.takeScreenShot(className+"_"+methodName);
			log.info("CONTACT Page - Test #01: Verify Practice Test Automation [PTA] Application 'CONTACT' page title - Failed");
			test.log(Status.INFO, "CONTACT Page - Test #01: Verify Practice Test Automation [PTA] Application 'CONTACT' page title - Failed");
			log.error("Assertion failed: " + ae.getMessage());
	        throw ae; // Re-throw so the test fails
		}catch (Exception e) {
			TestUtil.takeScreenShot(className+"_"+methodName);
			log.info("CONTACT Page - Test #01: Verify Practice Test Automation [PTA] Application 'CONTACT' page title - Failed");
			test.log(Status.INFO, "CONTACT Page - Test #01: Verify Practice Test Automation [PTA] Application 'CONTACT' page title - Failed");
	        log.error("Exception occurred during test execution", e);
	        throw e; // Re-throw so the test fails
	    }	
		
	}

//	@Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
	@Test
	public void contactPageTitleTestFailed() throws IOException {
		/*
        CONTACT Page - Test #01: Verify Practice Test Automation [PTA] Application 'CONTACT' page title.
        Steps:
        01) Get PTA 'CONTACT' page title.
        02) Verify the 'CONTACT' page title.
        */
		String className = new Exception().getStackTrace()[0].getClassName();
		String methodName = new Exception().getStackTrace()[0].getMethodName();		
		test = extent.createTest(className+" : "+methodName, "CONTACT Page - Test #01: Practice Test Automation [PTA] Application 'CONTACT' page title.");
		test.assignCategory("CONTACT Page");		
		
		log.info("*".repeat(100));
		test.log(Status.INFO, "*".repeat(100));
		
		log.info("CONTACT Page - Test #01: Verify Practice Test Automation [PTA] Application 'CONTACT' page title.");
		test.log(Status.INFO, "CONTACT Page - Test #01: Verify Practice Test Automation [PTA] Application 'CONTACT' page title.");
		
		log.info("*".repeat(100));
		test.log(Status.INFO, "*".repeat(100));
		
		try {
			log.info("Step 01: Get PTA 'CONTACT' page title.");
			test.log(Status.INFO, "Step 01: Get PTA 'CONTACT' page title.");
			String title = contactpage.validate_contactpage_title();
			
			log.info("Step 02: Verify the 'CONTACT' page title.");
			test.log(Status.INFO, "Step 02: Verify the 'CONTACT' page title.");
			assertEquals(title, "Contact | Practice Test Automation | Selenium WebDriver1",
				"Contact page title not matched");
			
			log.info("CONTACT Page - Test #01: Verify Practice Test Automation [PTA] Application 'CONTACT' page title - Passed");
			test.log(Status.INFO, "CONTACT Page - Test #01: Verify Practice Test Automation [PTA] Application 'CONTACT' page title - Passed");
		}catch(AssertionError ae) {
			TestUtil.takeScreenShot(className+"_"+methodName);
			log.info("CONTACT Page - Test #01: Verify Practice Test Automation [PTA] Application 'CONTACT' page title - Failed");
			test.log(Status.INFO, "CONTACT Page - Test #01: Verify Practice Test Automation [PTA] Application 'CONTACT' page title - Failed");
			log.error("Assertion failed: " + ae.getMessage());
	        throw ae; // Re-throw so the test fails
		}catch (Exception e) {
			TestUtil.takeScreenShot(className+"_"+methodName);
			log.info("CONTACT Page - Test #01: Verify Practice Test Automation [PTA] Application 'CONTACT' page title - Failed");
			test.log(Status.INFO, "CONTACT Page - Test #01: Verify Practice Test Automation [PTA] Application 'CONTACT' page title - Failed");
	        log.error("Exception occurred during test execution", e);
	        throw e; // Re-throw so the test fails
	    }			
	}	

	@Test(priority = 3)
	public void contactLinkTest() throws IOException {
		/*
        CONTACT Page - Test #03: Verify 'Contact' text on 'CONTACT' page.
        Steps:
        01) Login to PTA and navigate to 'CONTACT' page and verify 'Contact' text.
        */
		String className = new Exception().getStackTrace()[0].getClassName();
		String methodName = new Exception().getStackTrace()[0].getMethodName();		
		test = extent.createTest(className+" : "+methodName, "CONTACT Page - Test #03: 'Contact' text on 'CONTACT' page.");
		test.assignCategory("CONTACT Page");		
		
		log.info("*".repeat(100));
		test.log(Status.INFO, "*".repeat(100));
		
		log.info("CONTACT Page - Test #03: Verify 'Contact' text on 'CONTACT' page.");
		test.log(Status.INFO, "CONTACT Page - Test #03: Verify 'Contact' text on 'CONTACT' page.");
		
		log.info("*".repeat(100));
		test.log(Status.INFO, "*".repeat(100));
		try {
			log.info("Step 01: Login to PTA and navigate to 'CONTACT' page and verify 'Contact' text.");
			test.log(Status.INFO, "Step 01: Login to PTA and navigate to 'CONTACT' page and verify 'Contact' text.");
			Assert.assertTrue(contactpage.validate_contact_txt());
			log.info("CONTACT Page - Test #03: Verify 'Contact' text on 'CONTACT' page - Passed");
			test.log(Status.INFO, "CONTACT Page - Test #03: Verify 'Contact' text on 'CONTACT' page - Passed");
		}catch(AssertionError ae) {
			TestUtil.takeScreenShot(className+"_"+methodName);
			log.info("CONTACT Page - Test #03: Verify 'Contact' text on 'CONTACT' page - Failed");
			test.log(Status.INFO, "CONTACT Page - Test #03: Verify 'Contact' text on 'CONTACT' page - Failed");
			log.error("Assertion failed: " + ae.getMessage());
	        throw ae; // Re-throw so the test fails
		}catch (Exception e) {
			TestUtil.takeScreenShot(className+"_"+methodName);
			log.info("CONTACT Page - Test #03: Verify 'Contact' text on 'CONTACT' page - Failed");
			test.log(Status.INFO, "CONTACT Page - Test #03: Verify 'Contact' text on 'CONTACT' page - Failed");
	        log.error("Exception occurred during test execution", e);
	        throw e; // Re-throw so the test fails
	    }
	}

	@DataProvider
	public Object[][] getPTATestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 4, dataProvider = "getPTATestData")
	public void fillContactFormTest(String fn, String ln, String email, String comment) throws IOException {
		/*
        CONTACT Page - Test #04: Fill contact form on 'CONTACT' page.
        Steps:
        01) Login to PTA and navigate to CONTACT page and fill the contact form.        
        */
		String className = new Exception().getStackTrace()[0].getClassName();
		String methodName = new Exception().getStackTrace()[0].getMethodName();		
		test = extent.createTest(className+" : "+methodName, "CONTACT Page - Test #04: Fill contact form on 'CONTACT' page.");
		test.assignCategory("CONTACT Page");		
		
		log.info("*".repeat(100));
		test.log(Status.INFO, "*".repeat(100));
		
		log.info("CONTACT Page - Test #04: Fill contact form on 'CONTACT' page.");
		test.log(Status.INFO, "CONTACT Page - Test #04: Fill contact form on 'CONTACT' page.");
		
		log.info("*".repeat(100));
		test.log(Status.INFO, "*".repeat(100));
		
		try {
			// contactpage.fill_contact_form("Test", "Test", "test@test.com", "Test Practice
			// Test Automation");
			log.info("Step 01: Login to PTA and navigate to CONTACT page and fill the contact form.");
			test.log(Status.INFO, "Step 01: Login to PTA and navigate to CONTACT page and fill the contact form.");
			contactpage.fill_contact_form(fn, ln, email, comment);
			
			log.info("CONTACT Page - Test #04: Fill contact form on 'CONTACT' page - Passed");
			test.log(Status.INFO, "CONTACT Page - Test #04: Fill contact form on 'CONTACT' page - Passed");
		}catch (Exception e) {
			TestUtil.takeScreenShot(className+"_"+methodName);
			log.info("CONTACT Page - Test #04: Fill contact form on 'CONTACT' page - Failed");
			test.log(Status.INFO, "CONTACT Page - Test #04: Fill contact form on 'CONTACT' page - Failed");
	        log.error("Exception occurred during test execution", e);
	        throw e; // Re-throw so the test fails
	    }	
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
