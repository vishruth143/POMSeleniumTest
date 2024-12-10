package com.pta.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pta.qa.base.TestBase;
import com.pta.qa.pages.HomePage;
import com.pta.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
	}	
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
	}
	
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginpage.validateLoginPageTitle();
		assertEquals(title, "Test Login | Practice Test Automation");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest() {
		boolean flag = loginpage.validatePracticeTestAutomationImg();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() {
		homepage =  loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
