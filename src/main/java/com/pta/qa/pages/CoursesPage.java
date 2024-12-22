package com.pta.qa.pages;

import org.openqa.selenium.By;

import com.pta.qa.base.TestBase;

public class CoursesPage extends TestBase {
	
	By courses_txt = By.xpath("//h1[normalize-space()='Courses']");
			
	//Actions
	public String validate_coursespage_title() {
		return driver.getTitle();
	}
	
	public boolean validate_courses_txt() {
		return driver.findElement(courses_txt).isDisplayed();
	}
}
