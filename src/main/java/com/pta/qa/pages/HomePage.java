package com.pta.qa.pages;

import org.openqa.selenium.By;

import com.pta.qa.base.TestBase;

public class HomePage extends TestBase{
	By loggedInSuccessfully_txt = By.xpath("//h1[normalize-space()='Logged In Successfully']");	
	By logout_btn = By.xpath("//a[normalize-space()='Log out']");
	By contact_lnk = By.xpath("//a[normalize-space()='Contact']");
	
	//Actions
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validate_loggedInSuccessfully_txt() {
		return  driver.findElement(loggedInSuccessfully_txt).isDisplayed();
	}
	
	public LoginPage click_logout_btn() {
		driver.findElement(logout_btn).click();
		return new LoginPage();
	}
	
	public ContactPage click_contact_lnk() {
		driver.findElement(contact_lnk).click();
		return new ContactPage();
	}
}
