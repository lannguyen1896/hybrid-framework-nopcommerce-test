package common;

import org.testng.Assert;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import commons.VerificationFailures;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	protected WebDriver driver;
	protected final Log log;
	
	public WebDriver getDriverInstance() {
		return this.driver;
	}
	
	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}

	protected WebDriver getBrowserDriver(String browserName) {
		if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		/*
		 * if (browserName.equals("chrome")) { WebDriverManager.chromedriver().setup();
		 * driver = new ChromeDriver(); } if (browserName.equals("edge")) {
		 * WebDriverManager.edgedriver().setup(); driver = new EdgeDriver(); }
		 */else {
			// throw new RuntimeException("Browser name is invalid!");
			System.out.println("Invalid");
		}
		return driver;
	}

	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertTrue(condition);
			System.out.println(" -------------------------- PASSED -------------------------- ");

		} catch (Throwable e) {
			System.out.println(" -------------------------- FAILED -------------------------- ");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFailed(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertFalse(condition);
			System.out.println(" -------------------------- PASSED -------------------------- ");

		} catch (Throwable e) {
			System.out.println(" -------------------------- FAILED -------------------------- ");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			System.out.println(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			System.out.println(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

}
