package com.pta.qa.pages;

import org.openqa.selenium.By;

import com.pta.qa.base.TestBase;

public class ContactPage extends TestBase{
	By contact_txt = By.xpath("//h1[normalize-space()='Contact']");
	By first_name_txt = By.xpath("//input[@id='wpforms-161-field_0']");
	By last_name_txt = By.xpath("//input[@id='wpforms-161-field_0-last']");
	By email_txt = By.xpath("//input[@id='wpforms-161-field_1']");
	By comment_or_message_txt = By.xpath("//textarea[@id='wpforms-161-field_2']");
			
	
	//Actions
	public String validate_contactpage_title() {
		return driver.getTitle();
	} 
	
	public boolean validate_contact_txt() {
		return  driver.findElement(contact_txt).isDisplayed();
	}	
	
	public void fill_contact_form(String fn, String ln, String email, String comment) {
		driver.findElement(first_name_txt).sendKeys(fn);
		driver.findElement(last_name_txt).sendKeys(ln);
		driver.findElement(email_txt).sendKeys(email);
		driver.findElement(comment_or_message_txt).sendKeys(comment);		
	}	
}
