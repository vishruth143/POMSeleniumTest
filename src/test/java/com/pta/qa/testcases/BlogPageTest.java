package com.pta.qa.testcases;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pta.qa.base.TestBase;
import com.pta.qa.pages.BlogPage;
import com.pta.qa.pages.HomePage;
import com.pta.qa.pages.LoginPage;

public class BlogPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	BlogPage blogpage;
	
	public BlogPageTest() {
		super();		
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
		assertEquals(title, "Blog | Practice Test Automation");
	}
	
	@Test(priority=2)
	public void blogLinkTest() {		
		Assert.assertTrue(blogpage.validate_blog_txt());
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
