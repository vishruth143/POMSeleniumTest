package com.pta.qa.ui.testcases;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pta.qa.base.TestBase;
import com.pta.qa.pages.HomePage;
import com.pta.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	Logger log;
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
		log = Logger.getLogger(LoginPageTest.class);
	}	
	
	@BeforeMethod
	public void setup() throws MalformedURLException {
		initialization();
		initializeReport();
		loginpage = new LoginPage();
	}
	
	
	@Test(priority=1)
	public void loginPageTitleTest() {		
        /*
        Login Page - Test #01 : Verify Practice Test Automation [PTA] Application Title.
        Steps:
        01) Get PTA login page title.
        02) Verify the login page title.
        */
		log.info("*".repeat(100));
		log.info("Login Page - Test #01: Verify Practice Test Automation [PTA] Application Title.");
		log.info("*".repeat(100));
		
		try {			
			log.info("Step 01: Get PTA login page title.");				
			String title = loginpage.get_loginpage_title();
			
			log.info("Step 02: Verify the login page title.");
	        Assert.assertEquals(title, "Test Login | Practice Test Automation", "Login page title not matched");

	        log.info("Login Page - Test #01: Verify Practice Test Automation [PTA] Application Title - Passed");
		}catch(AssertionError ae) {
			log.info("Login Page - Test #01: Verify Practice Test Automation [PTA] Application Title - Failed");
			log.error("Assertion failed: " + ae.getMessage());
	        throw ae; // Re-throw so the test fails
		}catch (Exception e) {
			log.info("Login Page - Test #01: Verify Practice Test Automation [PTA] Application Title - Failed");
	        log.error("Exception occurred during test execution", e);
	        throw e; // Re-throw so the test fails
	    }		
	}
	
	@Test(priority=2)
	public void practiceTestAutomationImageTest() {
		 /*
        Login Page - Test #02 : Verify Practice Test Automation [PTA] Application logo.
        Steps:
        01) Verify the PTA application logo is present.        
        */
		log.info("*".repeat(100));
		log.info("Login Page - Test #02 : Verify Practice Test Automation [PTA] Application logo.");
		log.info("*".repeat(100));
		try {
			log.info("Step 01: Verify the PTA application logo is present.");
			boolean flag = loginpage.validate_practicetestautomation_img();
			Assert.assertTrue(flag);
			log.info("Login Page - Test #02 : Verify Practice Test Automation [PTA] Application logo - Passed");
		}catch(AssertionError ae) {
			log.info("Login Page - Test #02 : Verify Practice Test Automation [PTA] Application logo - Failed");
			log.error("Assertion failed: " + ae.getMessage());
	        throw ae; // Re-throw so the test fails
		}catch (Exception e) {
			log.info("Login Page - Test #02 : Verify Practice Test Automation [PTA] Application logo - Failed");
	        log.error("Exception occurred during test execution", e);
	        throw e; // Re-throw so the test fails
	    }	
		
	}
	
	@Test(priority=3)
	public void loginTest() {
		 /*
        Login Page - Test #03 : Verify Practice Test Automation [PTA] login.
        Steps:
        01) Provide username and password and verify the PTA login.        
        */
		log.info("*".repeat(100));
		log.info("Login Page - Test #03 : Verify Practice Test Automation [PTA] login.");
		log.info("*".repeat(100));
		try {
			log.info("Step 01: Provide username and password and verify the PTA login.");
			homepage =  loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
			log.info("Login Page - Test #03 : Verify Practice Test Automation [PTA] login - Passed");
		}catch (Exception e) {
			log.info("Login Page - Test #03 : Verify Practice Test Automation [PTA] login - Failed");
	        log.error("Exception occurred during test execution", e);
	        throw e; // Re-throw so the test fails
	    }	
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		log.info("Close Chrome");
	}

}
