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
import com.pta.qa.pages.BlogPage;
import com.pta.qa.pages.HomePage;
import com.pta.qa.pages.LoginPage;
import com.pta.qa.util.TestUtil;

public class BlogPageTest extends TestBase {	
	Logger log;
	LoginPage loginpage;
	HomePage homepage;
	BlogPage blogpage;
			
	public BlogPageTest() {
		super();
		log = Logger.getLogger(BlogPageTest.class);	
		log.setLevel(org.apache.log4j.Level.DEBUG);
	}
	
	@BeforeSuite
	public void reportSetup() {
		initializeReport();
	}
	
	@BeforeMethod
	public void setup() throws MalformedURLException {
		initialization();				
		loginpage = new LoginPage();		
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));	
		blogpage = homepage.click_blog_lnk();
	}	
	
	@Test(priority=1)
	public void blogPageTitleTest() throws IOException {
		 /*
        BLOG Page - Test #01: Verify Practice Test Automation [PTA] Application 'BLOG' page title.
        Steps:
        01) Get PTA 'BLOG' page title.
        02) Verify the 'BLOG' page title.
        */
		String className = new Exception().getStackTrace()[0].getClassName();
		String methodName = new Exception().getStackTrace()[0].getMethodName();		
		test = extent.createTest(className+" : "+methodName, "BLOG Page - Test #01: Practice Test Automation [PTA] Application 'BLOG' Page Title.");
		test.assignCategory("BLOG Page");		
		
		log.info("*".repeat(100));
		test.log(Status.INFO, "*".repeat(100));
		
		log.info("Login Page - Test #01: Verify Practice Test Automation [PTA] Application 'BLOG' Page Title.");
		test.log(Status.INFO, "Login Page - Test #01: Verify Practice Test Automation [PTA] Application 'BLOG' Page Title.");
		
		log.info("*".repeat(100));
		test.log(Status.INFO, "*".repeat(100));
		
		try {
			log.info("Step 01: Get PTA 'BLOG' page title.");
			test.log(Status.INFO, "Step 02: Get PTA 'BLOG' page title.");
			String title = blogpage.validate_blogpage_title();
			
			log.info("Step 02: Verify the 'BLOG' page title.");
			test.log(Status.INFO, "Step 02: Verify the 'BLOG' page title.");
			assertEquals(title, "Blog | Practice Test Automation");
			
			log.info("BLOG Page - Test #01: Verify Practice Test Automation [PTA] Application 'BLOG' page title - Passed");
			test.log(Status.INFO, "BLOG Page - Test #01: Verify Practice Test Automation [PTA] Application 'BLOG' page title - Passed");
		}catch(AssertionError ae) {
			TestUtil.takeScreenShot(className+"_"+methodName);
			log.info("BLOG Page - Test #01: Verify Practice Test Automation [PTA] Application 'BLOG' page title - Failed");
			test.log(Status.INFO, "BLOG Page - Test #01: Verify Practice Test Automation [PTA] Application 'BLOG' page title - Failed");
			log.error("Assertion failed: " + ae.getMessage());
	        throw ae; // Re-throw so the test fails
		}catch (Exception e) {
			TestUtil.takeScreenShot(className+"_"+methodName);
			log.info("BLOG Page - Test #01: Verify Practice Test Automation [PTA] Application 'BLOG' page title - Failed");
			test.log(Status.INFO, "BLOG Page - Test #01: Verify Practice Test Automation [PTA] Application 'BLOG' page title - Failed");
	        log.error("Exception occurred during test execution", e);
	        throw e; // Re-throw so the test fails
	    }		
	}
	
	@Test(priority=2)
	public void blogLinkTest() throws IOException {
		/*
        BLOG Page - Test #02: Verify 'Engaging with the Selenium Community and Expanding' text on 'BLOG' page.
        Steps:
        01) Login to PTA and navigate to 'BLOG' page and verify 'Engaging with the Selenium Community and Expanding' text.
        */
		String className = new Exception().getStackTrace()[0].getClassName();
		String methodName = new Exception().getStackTrace()[0].getMethodName();		
		test = extent.createTest(className+" : "+methodName, "BLOG Page - Test #02: 'Engaging with the Selenium Community and Expanding' text on 'BLOG' page.");
		test.assignCategory("BLOG Page");		
		
		log.info("*".repeat(100));
		test.log(Status.INFO, "*".repeat(100));
		
		log.info("BLOG Page - Test #02: Verify 'Engaging with the Selenium Community and Expanding' text on 'BLOG' page.");
		test.log(Status.INFO, "BLOG Page - Test #02: Verify 'Engaging with the Selenium Community and Expanding' text on 'BLOG' page.");
		
		log.info("*".repeat(100));
		test.log(Status.INFO, "*".repeat(100));
		try {
			log.info("Step 01: Login to PTA and navigate to 'BLOG' page and verify 'Engaging with the Selenium Community and Expanding' text.");
			test.log(Status.INFO, "Step 01: Login to PTA and navigate to 'BLOG' page and verify 'Engaging with the Selenium Community and Expanding' text.");	
			Assert.assertTrue(blogpage.validate_blog_txt());
			log.info("BLOG Page - Test #02: Verify 'Engaging with the Selenium Community and Expanding' text on 'BLOG' page - Passed");
			test.log(Status.INFO, "BLOG Page - Test #02: Verify 'Engaging with the Selenium Community and Expanding' text on 'BLOG' page - Passed");
		}catch(AssertionError ae) {
			TestUtil.takeScreenShot(className+"_"+methodName);
			log.info("BLOG Page - Test #02: Verify 'Engaging with the Selenium Community and Expanding' text on 'BLOG' page - Failed");
			test.log(Status.INFO, "BLOG Page - Test #02: Verify 'Engaging with the Selenium Community and Expanding' text on 'BLOG' page - Failed");
			log.error("Assertion failed: " + ae.getMessage());
	        throw ae; // Re-throw so the test fails
		}catch (Exception e) {
			TestUtil.takeScreenShot(className+"_"+methodName);
			log.info("BLOG Page - Test #02: Verify 'Engaging with the Selenium Community and Expanding' text on 'BLOG' page - Failed");
			test.log(Status.INFO, "BLOG Page - Test #02: Verify 'Engaging with the Selenium Community and Expanding' text on 'BLOG' page - Failed");
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
