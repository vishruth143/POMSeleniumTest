package com.pta.qa.pages;

import org.openqa.selenium.By;

import com.pta.qa.base.TestBase;

public class LoginPage extends TestBase{
	//Page Factory - OR:
	private By username_txt = By.xpath("//input[@id='username']");
	private By password_txt = By.xpath("//input[@id='password']");
	private By login_btn = By.xpath("//button[@id='submit']");
	private By logout_btn = By.xpath("//a[normalize-space()='Log out']");
	private By practiceTestAutomation_Img = By.xpath("//img[@alt='Practice Test Automation']");
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validatePracticeTestAutomationImg() {
		return  driver.findElement(practiceTestAutomation_Img).isDisplayed();
	}
	
	public HomePage login(String username, String password) {
		driver.findElement(username_txt).sendKeys(username);
		driver.findElement(password_txt).sendKeys(password);
		driver.findElement(login_btn).click();
		
		return new HomePage();
	}
}
