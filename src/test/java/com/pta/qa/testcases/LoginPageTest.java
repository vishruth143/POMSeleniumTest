package com.pta.qa.testcases;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

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
	public void setup() throws MalformedURLException {
		initialization();
		loginpage = new LoginPage();
	}
	
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginpage.validate_loginpage_title();
		assertEquals(title, "Test Login | Practice Test Automation","Login page title not matched");
	}
	
	@Test(priority=2)
	public void practiceTestAutomationImageTest() {
		boolean flag = loginpage.validate_practicetestautomation_img();
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
