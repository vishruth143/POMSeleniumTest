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
import com.pta.qa.pages.CoursesPage;
import com.pta.qa.pages.HomePage;
import com.pta.qa.pages.LoginPage;
import com.pta.qa.util.TestUtil;

public class CoursesPageTest extends TestBase {
	Logger log;
	LoginPage loginpage;
	HomePage homepage;
	CoursesPage coursespage;
	
	public CoursesPageTest() {
		super();	
		log = Logger.getLogger(CoursesPageTest.class);
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
		coursespage = homepage.click_cources_lnk();
	}	
	
	@Test(priority=1)
	public void courcesPageTitleTest() throws IOException {
		/*
        COURSES Page - Test #01: Verify Practice Test Automation [PTA] Application 'COURSES' page title.
        Steps:
        01) Get PTA 'COURSES' page title.
        02) Verify the 'COURSES' page title.
        */
		String className = new Exception().getStackTrace()[0].getClassName();
		String methodName = new Exception().getStackTrace()[0].getMethodName();		
		test = extent.createTest(className+" : "+methodName, "COURSES Page - Test #01: Practice Test Automation [PTA] Application 'COURSES' page title.");
		test.assignCategory("COURSES Page");		
		
		log.info("*".repeat(100));
		test.log(Status.INFO, "*".repeat(100));
		
		log.info("COURSES Page - Test #01: Verify Practice Test Automation [PTA] Application 'COURSES' page title.");
		test.log(Status.INFO, "COURSES Page - Test #01: Verify Practice Test Automation [PTA] Application 'COURSES' page title.");
		
		log.info("*".repeat(100));
		test.log(Status.INFO, "*".repeat(100));
		try {
			log.info("Step 01: Get PTA 'COURSES' page title.");
			test.log(Status.INFO, "Step 01: Get PTA 'COURSES' page title.");
			String title = coursespage.validate_coursespage_title();
			
			log.info("Step 02: Verify the 'COURSES' page title.");
			test.log(Status.INFO, "Step 02: Verify the 'COURSES' page title.");
			assertEquals(title, "Courses | Practice Test Automation");
			log.info("COURSES Page - Test #01: Verify Practice Test Automation [PTA] Application 'COURSES' page title - Passed");
			test.log(Status.INFO, "COURSES Page - Test #01: Verify Practice Test Automation [PTA] Application 'COURSES' page title - Passed");
		}catch(AssertionError ae) {
			TestUtil.takeScreenShot(className+"_"+methodName);
			log.info("COURSES Page - Test #01: Verify Practice Test Automation [PTA] Application 'COURSES' page title - Failed");
			test.log(Status.INFO, "COURSES Page - Test #01: Verify Practice Test Automation [PTA] Application 'COURSES' page title - Failed");
			log.error("Assertion failed: " + ae.getMessage());
	        throw ae; // Re-throw so the test fails
		}catch (Exception e) {
			TestUtil.takeScreenShot(className+"_"+methodName);
			log.info("COURSES Page - Test #01: Verify Practice Test Automation [PTA] Application 'COURSES' page title - Failed");
			test.log(Status.INFO, "COURSES Page - Test #01: Verify Practice Test Automation [PTA] Application 'COURSES' page title - Failed");
	        log.error("Exception occurred during test execution", e);
	        throw e; // Re-throw so the test fails
	    }		
	}	
	
	@Test(priority=2)
	public void coursesLinkTest() throws IOException {	
		/*
        COURSES Page - Test #02: Verify 'Courses' text on 'COURSES' page.
        Steps:
        01) Login to PTA and navigate to 'COURSES' page and verify 'Courses' text.
        */
		String className = new Exception().getStackTrace()[0].getClassName();
		String methodName = new Exception().getStackTrace()[0].getMethodName();		
		test = extent.createTest(className+" : "+methodName, "COURSES Page - Test #02: 'Courses' text on 'COURSES' page.");
		test.assignCategory("COURSES Page");		
		
		log.info("*".repeat(100));
		test.log(Status.INFO, "*".repeat(100));
		
		log.info("COURSES Page - Test #02: Verify 'Courses' text on 'COURSES' page.");
		test.log(Status.INFO, "COURSES Page - Test #02: Verify 'Courses' text on 'COURSES' page.");
		
		log.info("*".repeat(100));
		test.log(Status.INFO, "*".repeat(100));
		try {
			log.info("Step 01: Login to PTA and navigate to 'COURSES' page and verify 'Courses' text.");
			test.log(Status.INFO, "Step 01: Login to PTA and navigate to 'COURSES' page and verify 'Courses' text.");	
			Assert.assertTrue(coursespage.validate_courses_txt());
			log.info("COURSES Page - Test #02: Verify 'Courses' text on 'COURSES' page - Passed");
			test.log(Status.INFO, "COURSES Page - Test #02: Verify 'Courses' text on 'COURSES' page - Passed");
		}catch(AssertionError ae) {
			TestUtil.takeScreenShot(className+"_"+methodName);
			log.info("COURSES Page - Test #02: Verify 'Courses' text on 'COURSES' page - Failed");
			test.log(Status.INFO, "COURSES Page - Test #02: Verify 'Courses' text on 'COURSES' page - Failed");
			log.error("Assertion failed: " + ae.getMessage());
	        throw ae; // Re-throw so the test fails
		}catch (Exception e) {
			TestUtil.takeScreenShot(className+"_"+methodName);
			log.info("COURSES Page - Test #02: Verify 'Courses' text on 'COURSES' page - Failed");
			test.log(Status.INFO, "COURSES Page - Test #02: Verify 'Courses' text on 'COURSES' page - Failed");
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
