package com.pta.qa.ui.testcases;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

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
	public void courcesPageTitleTest() {
		String title = coursespage.validate_coursespage_title();
		assertEquals(title, "Courses | Practice Test Automation");
	}	
	
	@Test(priority=2)
	public void coursesLinkTest() {		
		Assert.assertTrue(coursespage.validate_courses_txt());
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
