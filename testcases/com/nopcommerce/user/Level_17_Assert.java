package com.nopcommerce.user;

import org.testng.annotations.Test;

import common.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

@Listeners(common.MethodListener.class)
public class Level_17_Assert extends BaseTest{
	WebDriver driver;
	String project_path = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.firefoxdriver().setup();
		// System.setProperty("webdriver.gecko.driver", project_path +
		// "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");

	}

	@Test
	public void TC_01_Validate_CurrentURL() {
		String loginUrl = driver.getCurrentUrl();
		log.info("hihihih");
		verifyEquals(loginUrl, "www.facebookgfdgfhfgh.com");

		String pageTitle = driver.getTitle();
		verifyEquals(pageTitle, "Facebookkk - log in or sign up");
	}
	
	
	

	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
