package com.pta.qa.pages;

import org.openqa.selenium.By;

import com.pta.qa.base.TestBase;

public class BlogPage extends TestBase {
	
	By blog_txt = By.xpath("//h2[contains(text(),'Engaging with the Selenium Community and Expanding')]");
	
	//Actions
	public String validate_blogpage_title() {
		return driver.getTitle();
	}
	
	public boolean validate_blog_txt() {
		return driver.findElement(blog_txt).isDisplayed();
	}
}
