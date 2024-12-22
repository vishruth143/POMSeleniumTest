package com.pta.qa.util;

import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverListener;

import com.pta.qa.base.TestBase;

public class WebDriverEventLogger extends TestBase implements WebDriverListener {

	@Override
	public void beforeGet(WebDriver driver, String url) {
		System.out.println("Navigating to: " + url);
	}

	@Override
	public void afterGet(WebDriver driver, String url) {
		System.out.println("Navigated to: " + url);
	}

	@Override
	public void beforeFindElement(WebDriver driver, By locator) {
		System.out.println("Attempting to find element: " + locator);
	}

	@Override
	public void afterFindElement(WebDriver driver, By locator, WebElement result) {
		System.out.println("Element found: " + locator);
	}

	@Override
	public void beforeClick(WebElement element) {
		System.out.println("Attempting to click on element: " + element);
	}

	@Override
	public void afterClick(WebElement element) {
		System.out.println("Clicked on element: " + element);
	}

	// Override other methods as needed (empty methods will be ignored)
}
