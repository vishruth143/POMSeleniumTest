package com.pta.qa.pages;

import org.openqa.selenium.By;

import com.pta.qa.base.TestBase;

public class HomePage extends TestBase{
	By loggedinsuccessfully_txt = By.xpath("//h1[normalize-space()='Logged In Successfully']");		
	By practice_lnk = By.xpath("//a[normalize-space()='Practice']");	
	By courses_lnk = By.xpath("//a[normalize-space()='Courses']");	
	By blog_lnk = By.xpath("//a[normalize-space()='Blog']");	
	By contact_lnk = By.xpath("//a[normalize-space()='Contact']");	 
	By logout_btn = By.xpath("//a[normalize-space()='Log out']");
	
	//Actions
	public String validate_homepage_title() {
		return driver.getTitle();
	}
	
	public boolean validate_loggedinsuccessfully_txt() {
		return  driver.findElement(loggedinsuccessfully_txt).isDisplayed();
	}		
	
	public PracticePage click_practice_lnk() {
		driver.findElement(practice_lnk).click();
		return new PracticePage();
	}
	
	public CoursesPage click_cources_lnk() {
		driver.findElement(courses_lnk).click();
		return new CoursesPage();
	}
	
	public BlogPage click_blog_lnk() {
		driver.findElement(blog_lnk).click();
		return new BlogPage();
	}
	
	public ContactPage click_contact_lnk() {
		driver.findElement(contact_lnk).click();
		return new ContactPage();
	}
	
	public LoginPage click_logout_btn() {
		driver.findElement(logout_btn).click();
		return new LoginPage();
	}
}
