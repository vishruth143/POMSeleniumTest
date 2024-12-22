package com.pta.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pta.qa.base.TestBase;
import com.pta.qa.pages.HomePage;
import com.pta.qa.pages.LoginPage;
import com.pta.qa.pages.PracticePage;

public class PracticePageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	PracticePage practicepage;
	
	public PracticePageTest() {
		super();		
	}	
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));	
		practicepage = homepage.click_practice_lnk();
	}	
	
	@Test(priority=1)
	public void practicePageTitleTest() {
		String title = practicepage.validate_practicepage_title();
		assertEquals(title, "Practice | Practice Test Automation");
	}	
	
	@Test(priority=2)
	public void practiceLinkTest() {		
		Assert.assertTrue(practicepage.validate_practice_txt());
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
