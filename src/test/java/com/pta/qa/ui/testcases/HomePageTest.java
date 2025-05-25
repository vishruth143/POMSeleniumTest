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
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.pta.qa.base.TestBase;
import com.pta.qa.pages.ContactPage;
import com.pta.qa.pages.HomePage;
import com.pta.qa.pages.LoginPage;
import com.pta.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	Logger log;
	HomePage homepage;
	LoginPage loginpage;
	ContactPage contactpage;
	
	public HomePageTest() {
		super();
		log = Logger.getLogger(HomePageTest.class);
	}
	
	@BeforeSuite
	public void reportSetup() {
		initializeReport();
	}
	
	@BeforeMethod
	public void setup() throws MalformedURLException {
		initialization();		
		loginpage = new LoginPage();
		contactpage = new ContactPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));		
	}
	
	@Test(priority=1)
	public void homePageTitleTest() throws IOException {	
		/*
        Home Page - Test #01: Verify Practice Test Automation [PTA] application 'HOME' page title.
        Steps:
        01) Login to PTA and get home page title.
        02) Verify the home page title.
        */
		String className = new Exception().getStackTrace()[0].getClassName();
		String methodName = new Exception().getStackTrace()[0].getMethodName();		
		test = extent.createTest(className+" : "+methodName, "Home Page - Test #01: Practice Test Automation [PTA] application 'HOME' page title.");
		test.assignCategory("Home Page");		
		
		log.info("*".repeat(100));
		test.log(Status.INFO, "*".repeat(100));
		
		log.info("Home Page - Test #01: Verify Practice Test Automation [PTA] application 'HOME' page title.");
		test.log(Status.INFO, "Home Page - Test #01: Verify Practice Test Automation [PTA] application 'HOME' page Title.");
		
		log.info("*".repeat(100));
		test.log(Status.INFO, "*".repeat(100));
		try {
			log.info("Step 01: Login to PTA and get home page title.");
			test.log(Status.INFO, "Step 01: Login to PTA and get home page title.");
			String title = homepage.validate_homepage_title();
			
			log.info("Step 02: Verify the home page title.");
			test.log(Status.INFO, "Step 02: Verify the home page title.");
			assertEquals(title, "Logged In Successfully | Practice Test Automation", "'HOME' page title not matched");
			
			log.info("Home Page - Test #01: Verify Practice Test Automation [PTA] application 'HOME' page title - Passed");
			test.log(Status.PASS, "Home Page - Test #01: Verify Practice Test Automation [PTA] application 'HOME' page Title - Passed");
		}catch(AssertionError ae) {
			TestUtil.takeScreenShot(className+"_"+methodName);
			log.info("Home Page - Test #01: Verify Practice Test Automation [PTA] application 'HOME' page title - Failed");
			test.log(Status.FAIL, "Home Page - Test #01: Verify Practice Test Automation [PTA] Application 'HOME' Page Title - Failed");
			log.error("Assertion failed: " + ae.getMessage());
	        throw ae; // Re-throw so the test fails
		}catch (Exception e) {
			TestUtil.takeScreenShot(className+"_"+methodName);
			log.info("Home Page - Test #01: Verify Practice Test Automation [PTA] application 'HOME' page title - Failed");
			test.log(Status.FAIL, "Home Page - Test #01: Verify Practice Test Automation [PTA] Application 'HOME' Page Title - Failed");
	        log.error("Exception occurred during test execution", e);
	        throw e; // Re-throw so the test fails
	    }		
	}
	
	
	@Test(priority=2)
	public void loggedInSuccessfullyTest() throws IOException {
		/*
        Home Page - Test #02: Verify 'Logged In Successfully' text after login to PTA.
        Steps:
        01) Login to PTA and Verify 'Logged In Successfully' text after login to PTA.
        */
		String className = new Exception().getStackTrace()[0].getClassName();
		String methodName = new Exception().getStackTrace()[0].getMethodName();		
		test = extent.createTest(className+" : "+methodName, "Home Page - Test #02: 'Logged In Successfully' text after login to PTA.");
		test.assignCategory("Home Page");		
		
		log.info("*".repeat(100));
		test.log(Status.INFO, "*".repeat(100));
		
		log.info("Home Page - Test #02: Verify 'Logged In Successfully' text after login to PTA.");
		test.log(Status.INFO, "Home Page - Test #02: Verify 'Logged In Successfully' text after login to PTA.");
		
		log.info("*".repeat(100));
		test.log(Status.INFO, "*".repeat(100));
		
		try {
			log.info("Step 01: Login to PTA and Verify 'Logged In Successfully' text after login to PTA.");
			test.log(Status.INFO, "Step 01: Login to PTA and Verify 'Logged In Successfully' text after login to PTA.");
			Assert.assertTrue(homepage.validate_loggedinsuccessfully_txt());
			log.info("Home Page - Test #02 : Verify 'Logged In Successfully' text after login to PTA - Passed");
			test.log(Status.PASS, "Home Page - Test #02 : Verify 'Logged In Successfully' text after login to PTA - Passed");
		}catch(AssertionError ae) {
			TestUtil.takeScreenShot(className+"_"+methodName);
			log.info("Home Page - Test #02 : Verify 'Logged In Successfully' text after login to PTA - Failed");
			test.log(Status.FAIL, "Home Page - Test #02 : Verify 'Logged In Successfully' text after login to PTA - Failed");
			log.error("Assertion failed: " + ae.getMessage());
	        throw ae; // Re-throw so the test fails
		}catch (Exception e) {
			TestUtil.takeScreenShot(className+"_"+methodName);
			log.info("Home Page - Test #02 : Verify 'Logged In Successfully' text after login to PTA - Failed");
			test.log(Status.FAIL, "Home Page - Test #02 : Verify 'Logged In Successfully' text after login to PTA - Failed");
	        log.error("Exception occurred during test execution", e);
	        throw e; // Re-throw so the test fails
	    }
	}
	
	@Test(priority=3)
	public void logoutTest() throws IOException {
		/*
        Home Page - Test #03: Verify 'Logout' after login to PTA.
        Steps:
        01) Login to PTA and logout.
        */
		String className = new Exception().getStackTrace()[0].getClassName();
		String methodName = new Exception().getStackTrace()[0].getMethodName();		
		test = extent.createTest(className+" : "+methodName, "Home Page - Test #03: 'Logout' after login to PTA.");
		test.assignCategory("Home Page");		
		
		log.info("*".repeat(100));
		test.log(Status.INFO, "*".repeat(100));
		
		log.info("Home Page - Test #03: Verify 'Logout' after login to PTA.");
		test.log(Status.INFO, "Home Page - Test #03: Verify 'Logout' after login to PTA.");
		
		log.info("*".repeat(100));
		test.log(Status.INFO, "*".repeat(100));
		
		try {
			log.info("Step 01: Login to PTA and logout.");
			test.log(Status.INFO, "Step 01: Login to PTA and logout.");			
			homepage.click_logout_btn();
			log.info("Home Page - Test #03: Verify 'Logout' after login to PTA - Passed");
			test.log(Status.PASS, "Home Page - Test #03: Verify 'Logout' after login to PTA - Passed");
			}catch (Exception e) {
				TestUtil.takeScreenShot(className+"_"+methodName);
				log.info("Home Page - Test #03: Verify 'Logout' after login to PTA - Failed");
				test.log(Status.FAIL, "Home Page - Test #03: Verify 'Logout' after login to PTA - Failed");
		        log.error("Exception occurred during test execution", e);
		        throw e; // Re-throw so the test fails
		    }
	}
	
	@Test(priority=4)
	public void contactLinkTest() throws IOException {	
		/*
        Home Page - Test #04: Verify navigation to 'CONTACT' page.
        Steps:
        01) Login to PTA and Verify navigation to 'CONTACT' page.
        */
		String className = new Exception().getStackTrace()[0].getClassName();
		String methodName = new Exception().getStackTrace()[0].getMethodName();		
		test = extent.createTest(className+" : "+methodName, "Home Page - Test #04: Navigation to 'CONTACT' page.");
		test.assignCategory("Home Page");		
		
		log.info("*".repeat(100));
		test.log(Status.INFO, "*".repeat(100));
		
		log.info("Home Page - Test #04: Verify navigation to 'CONTACT' page.");
		test.log(Status.INFO, "Home Page - Test #04: Verify navigation to 'CONTACT' page.");
		
		log.info("*".repeat(100));
		test.log(Status.INFO, "*".repeat(100));
		try {
			log.info("Step 01: Login to PTA and Verify navigation to 'CONTACT' page.");
			test.log(Status.INFO, "Step 01: Login to PTA and Verify navigation to 'CONTACT' page.");		
			contactpage = homepage.click_contact_lnk();
			log.info("Home Page - Test #04: Verify navigation to 'CONTACT' page - Passed");
			test.log(Status.PASS, "Home Page - Test #04: Verify navigation to 'CONTACT' page - Passed");
		}catch (Exception e) {
			TestUtil.takeScreenShot(className+"_"+methodName);
			log.info("Home Page - Test #04: Verify navigation to 'CONTACT' page - Failed");
			test.log(Status.FAIL, "Home Page - Test #04: Verify navigation to 'CONTACT' page - Failed");
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
