# 🧪 Selenium - Page Objet Model/Page Chaining Model [Design Pattern] approach - Data Driven Framework - TestNG

> A robust and scalable test automation framework using **Selenium WebDriver**, **TestNG**, **JAVA**, REST Assured. Supports both UI and API testing with environment-driven configuration and Docker integration.

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
2. Add the dependencies required for the automation framework in between **<dependencies> </dependencies>** tags from `https://mvnrepository.com/`

### Add the below depndencies
- **selenium-java**
- **webdrivermanager**
- **testng**
- **poi**
- **poi-ooxml**
- **poi-scratchpad**
- **poi-ooxml-schemas**
- **ooxml-schemas**
- **openxml4j**
- **extentreports**
- **log4j-core**
- **log4j-api**
- **rest-assured**
- **json-simple**

## 🖥️ To make the .files to visible on Package Explorer
1. Click the View Menu (three vertical dots in the top-right corner of the Package Explorer).
2. Select Filters
3. Uncheck . resources* (this hides dotfiles/folders).
4. Click OK.

## 🖥️ Install TestNG on Eclipse IDE
1. Open Eclipse IDE.
2. Go to Help > Eclipse Marketplace.
3. In the "Find" search bar, type: TestNG.
4. Locate TestNG for Eclipse (usually by "beust.com").
5. Click Install.
6. Follow the prompts to accept the license agreement and install.
7. Restart Eclipse when prompted.

## 🖥️ Install Maven

1. **Install Java (JDK)**  
   - Download and install the Java Development Kit (JDK) from [Oracle](https://www.oracle.com/java/technologies/javase-downloads.html) or [Adoptium](https://adoptium.net/).

2. **Download Maven**  
   - Go to [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi)
   - Download the binary zip archive, e.g. `apache-maven-3.9.9-bin.zip`.

3. **Extract Maven**  
   - Extract the archive to a directory like:  
     ```
     C:\Program Files\Apache\maven-3.9.9
     ```

4. **Set Environment Variables**

   - **Add `MAVEN_HOME`**  
     - Variable name: `MAVEN_HOME`  
     - Variable value:  
       ```
       C:\Program Files\Apache\maven-3.9.9
       ```

   - **Add Maven `bin` to `PATH`**  
     - In *System variables*, find and edit the `Path` variable  
     - Add the following entry:  
       ```
       C:\Program Files\Apache\maven-3.9.9\bin
       ```

5. **Verify Installation**

   - Open **Command Prompt** and run:  
     ```bash
     mvn -version
     ```

## 🖥️ Run Selenium scripts using docker compose
1. Navigate to the folder in cmd prompt where we have the `docker-compose-standalone.yml` file.
2. Execute the command `docker compose -f docker-compose-standalone.yml up -d`
3. Browser Containers and Access URLs.                                                                                                                                                                                      
When you run the `docker-compose-standalone.yml` file for the first time, Docker will pull the Selenium Standalone images for Chrome, Firefox, and Edge browsers. Once the containers are up, you can access them as follows:

🔗 Selenium WebDriver URLs:
- [Chrome - http://localhost:4441/](http://localhost:4441/)
- [Firefox - http://localhost:4442/](http://localhost:4442/)
- [Edge - http://localhost:4443/](http://localhost:4443/)

🖥️ noVNC Access (Remote Desktop UI):
- [Chrome noVNC - http://localhost:7901/](http://localhost:7901/)
- [Firefox noVNC - http://localhost:7902/](http://localhost:7902/)
- [Edge noVNC - http://localhost:7903/](http://localhost:7903/)

> **Password:** `secret` (use this when prompted to connect via noVNC)

## 🖥️ Run TestNG files individually
1. Open the test file. Right click on the test file and Select **Run As > 1 TestNG Test**

## 🖥️ Run TestNG Test Suite
1. Ensure the project has TestNG library added. 
	- Right-click project → Build Path → Configure Build Path → Libraries → check for TestNG.
2. Open the `testng_regression.xml` file under `src/main/resources`. Right click and Select **Run As > 1 TestNG Suite**

## 🖥️ To ignore/disable a Test Case in TestNG
1. To ignore a test case use
	- Mark the test with org.testng.annotations.@Test;
2. To disable a test case use
	- use enabled=false
