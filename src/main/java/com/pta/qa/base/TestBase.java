package com.pta.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.pta.qa.util.TestUtil;
import com.pta.qa.util.WebDriverEventLogger;

public class TestBase {	
	
	public static WebDriver driver;
	public static Properties prop;
	public static Logger log;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;
	public static ExtentTest test;	
		
	public TestBase() {
		 log = Logger.getLogger(TestBase.class);
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
	
	public static void initialization() throws MalformedURLException {
		//String browser = prop.getProperty("browser");
		String browser = System.getProperty("browser", "chrome");
		WebDriver baseDriver = null;
		DesiredCapabilities cap = new DesiredCapabilities();
		
		if(browser.equals("chrome")) {			
			//WebDriverManager.chromedriver().setup();
			//baseDriver = new ChromeDriver();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.LINUX);
			log.info("Launch Chrome");
			baseDriver = new RemoteWebDriver(new URL("http://localhost:4441/wd/hub"), cap);
		} else if(browser.equals("firefox")) {
			//WebDriverManager.firefoxdriver().setup();
			//baseDriver = new FirefoxDriver();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.LINUX);
			log.info("Launch Firefox");
			baseDriver = new RemoteWebDriver(new URL("http://localhost:4442/wd/hub"), cap);
		} else if(browser.equals("edge")) {
			//WebDriverManager.edgedriver().setup();
			//baseDriver = new EdgeDriver();
			cap.setBrowserName("MicrosoftEdge");
			cap.setPlatform(Platform.LINUX);
			log.info("Launch MicrosoftEdge");
			baseDriver = new RemoteWebDriver(new URL("http://localhost:4443/wd/hub"), cap);
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
	
	public static void initializeReport() {
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/extentSparkReport.html");
		sparkReporter.config().setDocumentTitle("PTA Automation Report");
		sparkReporter.config().setReportName("PTA Automation Test Execution Report");
		sparkReporter.config().setTheme(Theme.STANDARD);
		sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
	}
	
	public static String captureScrenshot(ITestResult result) throws IOException {
		String fileSeparator = System.getProperty("file.separator");
		String extentReportPath = "." + fileSeparator + "Reports";
		String screenshotPath = extentReportPath + fileSeparator + "screenshots";

		// Ensure directory exists
		File screenshotDir = new File(screenshotPath);
		if (!screenshotDir.exists()) {
			screenshotDir.mkdirs();
		}

		// Get class name and method name
		String className = result.getTestClass().getRealClass().getSimpleName();
		String methodName = result.getMethod().getMethodName();
		String screenshotName = className + "_" + methodName + ".png";

		// Take screenshot
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String fullPath = screenshotPath + fileSeparator + screenshotName;
		FileUtils.copyFile(srcFile, new File(fullPath));

		// Return relative path for ExtentReports
		return "." + fileSeparator + "screenshots" + fileSeparator + screenshotName;
	}
}


