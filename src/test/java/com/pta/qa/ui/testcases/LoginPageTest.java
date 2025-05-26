package com.pta.qa.ui.testcases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.annotations.Ignore;
import com.aventstack.extentreports.Status;
import com.pta.qa.base.TestBase;
import com.pta.qa.pages.HomePage;
import com.pta.qa.pages.LoginPage;
import com.pta.qa.util.TestUtil;

public class LoginPageTest extends TestBase{
	Logger log;
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
		log = Logger.getLogger(LoginPageTest.class);
	}
	
	@BeforeSuite
	public void reportSetup() {
		initializeReport();
	}
	
	@BeforeMethod
	public void setup() throws MalformedURLException {
		initialization();		
		loginpage = new LoginPage();
	}
	
	
	@Test(priority=1)
	public void loginPageTitleTest() throws IOException {		
        /*
        Login Page - Test #01: Verify Practice Test Automation [PTA] Application 'Login' page title.
        Steps:
        01) Get PTA 'Login' page title.
        02) Verify the 'Login' page title.
        */
		String className = new Exception().getStackTrace()[0].getClassName();
		String methodName = new Exception().getStackTrace()[0].getMethodName();		
		test = extent.createTest(className+" : "+methodName, "Login Page - Test #01: Practice Test Automation [PTA] Application 'Login' page title.");
		test.assignCategory("Login Page");		
		
		log.info("*".repeat(100));
		test.log(Status.INFO, "*".repeat(100));
		
		log.info("Login Page - Test #01: Verify Practice Test Automation [PTA] Application 'Login' page title.");
		test.log(Status.INFO, "Login Page - Test #01: Verify Practice Test Automation [PTA] Application 'Login' page title.");
		
		log.info("*".repeat(100));
		test.log(Status.INFO, "*".repeat(100));
		
		try {			
			log.info("Step 01: Get PTA 'Login' page title.");
			test.log(Status.INFO, "Step 01: Get PTA 'Login' page title.");
			String title = loginpage.get_loginpage_title();
			
			log.info("Step 02: Verify the 'Login' page title.");
			test.log(Status.INFO, "Step 02: Verify the 'Login' page title.");
	        Assert.assertEquals(title, "Test Login | Practice Test Automation", "'Login' page title not matched");

	        log.info("Login Page - Test #01: Verify Practice Test Automation [PTA] Application 'Login' page title - Passed");
	        test.log(Status.PASS, "Login Page - Test #01: Verify Practice Test Automation [PTA] Application 'Login' page title - Passed");
		}catch(AssertionError ae) {
			TestUtil.takeScreenShot(className+"_"+methodName);
			log.info("Login Page - Test #01: Verify Practice Test Automation [PTA] Application 'Login' page title - Failed");
			test.log(Status.FAIL, "Login Page - Test #01: Verify Practice Test Automation [PTA] Application 'Login' page title - Failed");
			log.error("Assertion failed: " + ae.getMessage());
	        throw ae; // Re-throw so the test fails
		}catch (Exception e) {
			TestUtil.takeScreenShot(className+"_"+methodName);
			log.info("Login Page - Test #01: Verify Practice Test Automation [PTA] Application 'Login' page title - Failed");
			test.log(Status.FAIL, "Login Page - Test #01: Verify Practice Test Automation [PTA] Application 'Login' page title - Failed");
	        log.error("Exception occurred during test execution", e);
	        throw e; // Re-throw so the test fails
	    }		
	}
	
	@Test(enabled=false, priority=2)
	public void practiceTestAutomationImageTest() throws IOException {		
		 /*
        Login Page - Test #02: Verify Practice Test Automation [PTA] Application logo.
        Steps:
        01) Verify the PTA application logo is present.        
        */
		String className = new Exception().getStackTrace()[0].getClassName();
		String methodName = new Exception().getStackTrace()[0].getMethodName();		
		test = extent.createTest(className+" : "+methodName, "Login Page - Test #02: Practice Test Automation [PTA] Application logo.");
		test.assignCategory("Login Page");		
		
		log.info("*".repeat(100));
		test.log(Status.INFO, "*".repeat(100));
				
		log.info("Login Page - Test #02 : Verify Practice Test Automation [PTA] Application logo.");
		test.log(Status.INFO, "Login Page - Test #02 : Verify Practice Test Automation [PTA] Application logo.");
				
		log.info("*".repeat(100));
		test.log(Status.INFO, "*".repeat(100));
				
		try {
			log.info("Step 01: Verify the PTA application logo is present.");
			test.log(Status.INFO, "Step 01: Verify the PTA application logo is present.");
			boolean flag = loginpage.validate_practicetestautomation_img();
			Assert.assertTrue(flag);
			log.info("Login Page - Test #02 : Verify Practice Test Automation [PTA] Application logo - Passed");
			test.log(Status.PASS, "Login Page - Test #02 : Verify Practice Test Automation [PTA] Application logo - Passed");
		}catch(AssertionError ae) {
			TestUtil.takeScreenShot(className+"_"+methodName);
			log.info("Login Page - Test #02 : Verify Practice Test Automation [PTA] Application logo - Failed");
			test.log(Status.FAIL, "Login Page - Test #02 : Verify Practice Test Automation [PTA] Application logo - Failed");
			log.error("Assertion failed: " + ae.getMessage());
	        throw ae; // Re-throw so the test fails
		}catch (Exception e) {
			TestUtil.takeScreenShot(className+"_"+methodName);
			log.info("Login Page - Test #02 : Verify Practice Test Automation [PTA] Application logo - Failed");
			test.log(Status.FAIL, "Login Page - Test #02 : Verify Practice Test Automation [PTA] Application logo - Failed");
	        log.error("Exception occurred during test execution", e);
	        throw e; // Re-throw so the test fails
	    }	
		
	}
	
	@Ignore
	@Test(priority=3)
	public void loginTest() throws IOException {
		 /*
        Login Page - Test #03 : Verify Practice Test Automation [PTA] login.
        Steps:
        01) Provide username and password and verify the PTA login.        
        */
		String className = new Exception().getStackTrace()[0].getClassName();
		String methodName = new Exception().getStackTrace()[0].getMethodName();		
		test = extent.createTest(className+" : "+methodName, "Login Page - Test #03: Practice Test Automation [PTA] login");
		test.assignCategory("Login Page");		
		
		log.info("*".repeat(100));
		test.log(Status.INFO, "*".repeat(100));
				
		log.info("Login Page - Test #03 : Verify Practice Test Automation [PTA] login.");
		test.log(Status.INFO, "Login Page - Test #03 : Verify Practice Test Automation [PTA] login.");
				
		log.info("*".repeat(100));
		test.log(Status.INFO, "*".repeat(100));
		try {			
			log.info("Step 01: Provide username and password and verify the PTA login.");
			test.log(Status.INFO, "Step 01: Provide username and password and verify the PTA login.");
			homepage =  loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
			log.info("Login Page - Test #03 : Verify Practice Test Automation [PTA] login - Passed");
			test.log(Status.PASS, "Login Page - Test #03 : Verify Practice Test Automation [PTA] login - Passed");
		}catch (Exception e) {
			TestUtil.takeScreenShot(className+"_"+methodName);
			log.info("Login Page - Test #03 : Verify Practice Test Automation [PTA] login - Failed");
			test.log(Status.FAIL, "Login Page - Test #03 : Verify Practice Test Automation [PTA] login - Failed");
	        log.error("Exception occurred during test execution", e);
	        throw e; // Re-throw so the test fails
	    }	
	}	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		log.info("Close Chrome");
	}
	
	@AfterSuite
	public void reportClosure() {
		if (TestUtil.extent != null) {
	        TestUtil.extent.flush();
	    }
	}
}