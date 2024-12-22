package com.pta.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.openqa.selenium.support.events.EventFiringDecorator;

import com.pta.qa.util.TestUtil;
import com.pta.qa.util.WebDriverEventLogger;

public class TestBase {	
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/pta/qa/config/config.properties");
			prop.load(ip);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		WebDriver baseDriver = null;
		
		if(browserName.equals("chrome")) {
			baseDriver = new ChromeDriver();
		} else if(browserName.equals("firefox")) {
			baseDriver = new FirefoxDriver();
		} else if(browserName.equals("edge")) {
			baseDriver = new EdgeDriver();
		}
		
		// Add the WebDriver listener
		WebDriverDecorator<WebDriver> decorator = new EventFiringDecorator<>(new WebDriverEventLogger());
		driver = decorator.decorate(baseDriver);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		
		driver.get(prop.getProperty("url"));
	}
}


