# 🧪 Selenium - Page Objet Model/Page Chaining Model [Design Pattern] approach - Data Driven Framework - TestNG

	A robust and scalable test automation framework using **Selenium WebDriver**, **TestNG**, **JAVA**, REST Assured. Supports both UI and API testing with environment-driven configuration and Docker integration.

## 🖥️ Framework Structure

1. **Page Layer/Page Libraries**: Divide the application into pages and add the WebObjects/WebElements (Object Repository) and Actions/methods (Features).  
   (`POMSeleniumTest > src/main/java > com.pta.qa.pages`)

2. **Test Layer**:  
   (`POMSeleniumTest > src/test/java > com.pta.qa.ui.testcases > *Test.java`)
   (`POMSeleniumTest > src/test/java > com.qa.api.testcases > *Test.java`)

3. **Base Test**: All the pages under page layer will inherit this class (ParentClass of all page classes). This class contains functions for initializing the WebDriver, initialize Properties, maximize the browser window, `pageloadTimeout()`, `implicitWait()`, `deleteAllCookies()`, `get(url)`  
   (`POMSeleniumTest > com.pta.qa.base > TestBase.java`)
   
4. **Config Layer**: Environment variables - `url, username, password, browser other`                                        
	(`POMSeleniumTest > com.pta.qa.config > config.properties`)  
	
5. **Test Data Layer**: Excel file.  
   (`POMSeleniumTest > src/main/java > com.pta.qa.testdata > TestData.xlsx`)

6. **Utilities Layer**:  Common utilities (Generic Functions) - `Screenshot(), getTestData()`  
   (`POMSeleniumTest > src/main/java > com.pta.qa.util > *.java`)
   
7. **Reporting Layer**:  Test Report - Pass/Fail - HTML, TestNG, XML, ExtentReport    
   (`POMSeleniumTest > src/main/java > com.pta.qa.util > *.java`)

## 🛠️ Tools and Technologies Used

- **Java**
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **Apache POI API**
- **Extent Report** / **TestNG Report**
- **Log4J API**
- **Jenkins** – CI
- **Git** Repository
- **Selenium Grid** – Parallel Testing
- **Browsers** – Chrome / Firefox / Edge
- **Operating Systems** – Windows / Mac / Linux
- **Execution Platforms** – VMs / Sauce Labs / BrowserStack / Local

## 🖥️ Add all the dependencies in pom.xml
1. Create a new maven project in eclipse - `File > New > Maven Project`
2. Add the dependencies required for the automation framework in between <dependencies> </dependencies> tags

## 🖥️ To make the .files to visible on Package Explorer
1. Click the View Menu (three vertical dots in the top-right corner of the Package Explorer).
2. Select Filters
3. Uncheck . resources* (this hides dotfiles/folders).
4. Click OK.