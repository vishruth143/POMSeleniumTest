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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.openqa.selenium.support.events.EventFiringDecorator;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.pta.qa.util.TestUtil;
import com.pta.qa.util.WebDriverEventLogger;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {	
	
	public static WebDriver driver;
	public static Properties prop;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	
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
	
	public static void initialization() throws MalformedURLException {
		String browserName = prop.getProperty("browser");
		WebDriver baseDriver = null;
		DesiredCapabilities cap = new DesiredCapabilities();
		
		if(browserName.equals("chrome")) {			
			//WebDriverManager.chromedriver().setup();
			//baseDriver = new ChromeDriver();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.LINUX);
			baseDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		} else if(browserName.equals("firefox")) {
			//WebDriverManager.firefoxdriver().setup();
			//baseDriver = new FirefoxDriver();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.LINUX);
			baseDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		} else if(browserName.equals("edge")) {
			//WebDriverManager.edgedriver().setup();
			//baseDriver = new EdgeDriver();
			cap.setBrowserName("MicrosoftEdge");
			cap.setPlatform(Platform.LINUX);
			baseDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
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
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/extentSparkReport.html");
		sparkReporter.config().setDocumentTitle("PTA Automation Report");
		sparkReporter.config().setReportName("PTA Automation Test Execution Report");
		sparkReporter.config().setTheme(Theme.STANDARD);
		sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
	}
	
	public static String captureScrenshot() throws IOException {
		String fileSparator = System.getProperty("file.speparator");
		String extentReportPath = "."+fileSparator+"Reports";
		String screenShotPath = extentReportPath+fileSparator+"screenshots";
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenShotName = "screenshot"+System.currentTimeMillis()+".png";
		String ScreenShotPath = screenShotPath+fileSparator+screenShotName;
		FileUtils.copyFile(srcFile, new File(ScreenShotPath));
		return "."+fileSparator+"screenshots"+fileSparator+screenShotName;
			
	}
}


