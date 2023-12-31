package com.izaanschool.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.lang.reflect.Method;

@Listeners({ TestListener.class })
public class BaseTest {

	protected WebDriver driver;
	protected Logger log;

	protected String testSuiteName;
	protected String testName;
	protected String testMethodName;

	@Parameters({ "browser", "chromeProfile", "deviceName" })
	@BeforeMethod(alwaysRun = true)
	public void setUp(Method method, @Optional("chrome") String browser, @Optional String profile,
			@Optional String deviceName, ITestContext ctx) {
		// Get the current test name
		String testName = ctx.getCurrentXmlTest().getName();
		log = LogManager.getLogger(testName);

		BrowserDriverFactory factory = new BrowserDriverFactory(browser, log);
		/*if (profile != null) {
			driver = factory.createChromeWithProfile(profile);
		} else if (deviceName != null) {
			driver = factory.createChromeWithMobileEmulation(deviceName);
		} else {
			driver = factory.createDriver();
		}*/

		driver = factory.createDriver();

		// This sleep here is for instructor only. Students don't need this here
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.manage().window().maximize();

		this.testSuiteName = ctx.getSuite().getName();
		this.testName = testName;
		this.testMethodName = method.getName();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		log.info("Close driver");
		// Close browser
		driver.quit();
	}

}
