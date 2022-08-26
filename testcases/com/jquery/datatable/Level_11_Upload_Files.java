package com.jquery.datatable;

import org.testng.annotations.Test;
import common.BaseTest;
import pageObject.jQuery.uploadFiles.HomePageObject;
import pageObject.jQuery.uploadFiles.U_PageGeneratorManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterClass;

public class Level_11_Upload_Files extends BaseTest {

	HomePageObject homePage;
	String p1 ="1.jpg";
	String p2 = "2.png";
	String p3 = "3.jpg";
	String p4 = "4.jpg";
	
	String[] multipleFile = {p1, p2, p3, p4};
	
	
	

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");

		homePage = U_PageGeneratorManager.getHomePageObject(driver);
	}

	@Test
	public void TC_01_Upload_1_File_Per_Time() {
		homePage.uploadMultipleFile(driver, p1);
		homePage.sleepInSecond(2);

	}

	@Test
	public void TC_02_Upload_Multiple_File_Per_Time() {
		homePage.uploadMultipleFile(driver, multipleFile);
		homePage.sleepInSecond(2);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
