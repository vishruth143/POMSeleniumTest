package com.pta.qa.pages;

import org.openqa.selenium.By;

import com.pta.qa.base.TestBase;

public class ContactPage extends TestBase{
	By contact_txt = By.xpath("//h1[normalize-space()='Contact']");
	
	//Actions
	public String validateContactPageTitle() {
		return driver.getTitle();
	} 
	
	public boolean validate_contact_txt() {
		return  driver.findElement(contact_txt).isDisplayed();
	}
}
