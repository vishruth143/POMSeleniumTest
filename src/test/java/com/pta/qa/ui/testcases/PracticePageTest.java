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
import com.pta.qa.pages.HomePage;
import com.pta.qa.pages.LoginPage;
import com.pta.qa.pages.PracticePage;
import com.pta.qa.util.TestUtil;

public class PracticePageTest extends TestBase {
	Logger log;
	LoginPage loginpage;
	HomePage homepage;
	PracticePage practicepage;
	
	public PracticePageTest() {
		super();
		log = Logger.getLogger(PracticePageTest.class);
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
		practicepage = homepage.click_practice_lnk();
	}	
	
	@Test(priority=1)
	public void practicePageTitleTest() throws IOException {
		/*
        PRACTICE Page - Test #01: Verify Practice Test Automation [PTA] Application 'PRACTICE' page title.
        Steps:
        01) Get PTA 'PRACTICE' page title.
        02) Verify the 'PRACTICE' page title.
        */
		String className = new Exception().getStackTrace()[0].getClassName();
		String methodName = new Exception().getStackTrace()[0].getMethodName();		
		test = extent.createTest(className+" : "+methodName, "PRACTICE Page - Test #01: Practice Test Automation [PTA] Application 'PRACTICE' Page Title.");
		test.assignCategory("PRACTICE Page");		
		
		log.info("*".repeat(100));
		test.log(Status.INFO, "*".repeat(100));
		
		log.info("PRACTICE Page - Test #01: Verify Practice Test Automation [PTA] Application 'PRACTICE' page title.");
		test.log(Status.INFO, "PRACTICE Page - Test #01: Verify Practice Test Automation [PTA] Application 'PRACTICE' page title.");
		
		log.info("*".repeat(100));
		test.log(Status.INFO, "*".repeat(100));
		try {
			log.info("Step 01: Get PTA 'PRACTICE' page title.");
			test.log(Status.INFO, "Step 01: Get PTA 'PRACTICE' page title.");
			String title = practicepage.validate_practicepage_title();
			
			log.info("Step 02: Verify the 'PRACTICE' page title.");
			test.log(Status.INFO, "Step 02: Verify the 'PRACTICE' page title.");
			assertEquals(title, "Practice | Practice Test Automation");
			log.info("PRACTICE Page - Test #01: Verify Practice Test Automation [PTA] Application 'PRACTICE' page title - Passed");
			test.log(Status.PASS, "PRACTICE Page - Test #01: Verify Practice Test Automation [PTA] Application 'PRACTICE' page title - Passed");
		}catch(AssertionError ae) {
			TestUtil.takeScreenShot(className+"_"+methodName);
			log.info("PRACTICE Page - Test #01: Verify Practice Test Automation [PTA] Application 'PRACTICE' page title - Failed");
			test.log(Status.FAIL, "PRACTICE Page - Test #01: Verify Practice Test Automation [PTA] Application 'PRACTICE' page title - Failed");
			log.error("Assertion failed: " + ae.getMessage());
	        throw ae; // Re-throw so the test fails
		}catch (Exception e) {
			TestUtil.takeScreenShot(className+"_"+methodName);
			log.info("PRACTICE Page - Test #01: Verify Practice Test Automation [PTA] Application 'PRACTICE' page title - Failed");
			test.log(Status.FAIL, "PRACTICE Page - Test #01: Verify Practice Test Automation [PTA] Application 'PRACTICE' page title - Failed");
	        log.error("Exception occurred during test execution", e);
	        throw e; // Re-throw so the test fails
	    }	
		
	}	
	
	@Test(priority=2)
	public void practiceLinkTest() throws IOException {
		/*
        PRACTICE Page - Test #02: Verify 'Practice' text on 'PRACTICE' page.
        Steps:
        01) Login to PTA and navigate to 'PRACTICE' page and verify 'Practice' text.
        */
		String className = new Exception().getStackTrace()[0].getClassName();
		String methodName = new Exception().getStackTrace()[0].getMethodName();		
		test = extent.createTest(className+" : "+methodName, "PRACTICE Page - Test #02: 'Practice' text on 'PRACTICE' page.");
		test.assignCategory("PRACTICE Page");		
		
		log.info("*".repeat(100));
		test.log(Status.INFO, "*".repeat(100));
		
		log.info("PRACTICE Page - Test #02: Verify 'Practice' text on 'PRACTICE' page.");
		test.log(Status.INFO, "PRACTICE Page - Test #02: Verify 'Practice' text on 'PRACTICE' page.");
		
		log.info("*".repeat(100));
		test.log(Status.INFO, "*".repeat(100));
		try {
			log.info("Step 01: Login to PTA and navigate to 'PRACTICE' page and verify 'Practice' text.");
			test.log(Status.INFO, "Step 01: Login to PTA and navigate to 'PRACTICE' page and verify 'Practice' text.");	
			Assert.assertTrue(practicepage.validate_practice_txt());
			log.info("PRACTICE Page - Test #02: Verify 'Practice' text on 'PRACTICE' page - Passed");
			test.log(Status.PASS, "PRACTICE Page - Test #02: Verify 'Practice' text on 'PRACTICE' page - Passed");
		}catch(AssertionError ae) {
			TestUtil.takeScreenShot(className+"_"+methodName);
			log.info("PRACTICE Page - Test #02: Verify 'Practice' text on 'PRACTICE' page - Failed");
			test.log(Status.FAIL, "PRACTICE Page - Test #02: Verify 'Practice' text on 'PRACTICE' page - Failed");
			log.error("Assertion failed: " + ae.getMessage());
	        throw ae; // Re-throw so the test fails
		}catch (Exception e) {
			TestUtil.takeScreenShot(className+"_"+methodName);
			log.info("PRACTICE Page - Test #02: Verify 'Practice' text on 'PRACTICE' page - Failed");
			test.log(Status.FAIL, "PRACTICE Page - Test #02: Verify 'Practice' text on 'PRACTICE' page - Failed");
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
