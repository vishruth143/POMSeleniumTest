package com.pta.qa.pages;

import org.openqa.selenium.By;

import com.pta.qa.base.TestBase;

public class LoginPage extends TestBase{
	//Page Factory - OR:
	private By username_txt = By.xpath("//input[@id='username']");
	private By password_txt = By.xpath("//input[@id='password']");
	private By login_btn = By.xpath("//button[@id='submit']");
	private By logout_btn = By.xpath("//a[normalize-space()='Log out']");
	private By practice_test_automation_img = By.xpath("//img[@alt='Practice Test Automation']");
	
	//Actions
	public String get_loginpage_title() {
		return driver.getTitle();
	}
	
	public boolean validate_practicetestautomation_img() {
		return  driver.findElement(practice_test_automation_img).isDisplayed();
	}
	
	public HomePage login(String username, String password) {
		driver.findElement(username_txt).sendKeys(username);
		driver.findElement(password_txt).sendKeys(password);
		driver.findElement(login_btn).click();
		
		return new HomePage();
	}
}
