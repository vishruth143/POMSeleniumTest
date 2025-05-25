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
	public void blogPageTitleTest() {
		String title = blogpage.validate_blogpage_title();
		log.info("Validate BLOG page title ");
		assertEquals(title, "Blog | Practice Test Automation");
	}
	
	@Test(priority=2)
	public void blogLinkTest() {
		log.info("Validate BLOG page title ");
		Assert.assertTrue(blogpage.validate_blog_txt());
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
