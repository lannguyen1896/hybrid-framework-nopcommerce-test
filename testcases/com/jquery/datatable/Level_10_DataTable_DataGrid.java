package com.jquery.datatable;

import org.testng.annotations.Test;
import common.BaseTest;
import common.PageGeneratorManager;
import pageObject.jQuery.HomePageObject;
import pageObject.jQuery.J_PageGeneratorManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterClass;

public class Level_10_DataTable_DataGrid extends BaseTest {

	HomePageObject homePage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/");
		
		homePage = J_PageGeneratorManager.getHomePageObject(driver);

	}
	
	public void TC_01_Table_Paging() {
		homePage.openPageByNumber("3");
		homePage.sleepInSecond(1);
		
		homePage.openPageByNumber("12");
		homePage.sleepInSecond(1);
		
		homePage.openPageByNumber("22");
		homePage.sleepInSecond(1);
		
		homePage.openPageByNumber("5");
		homePage.sleepInSecond(1);
	}
	
	
	public void TC_02_Enter_To_Header_Textbox_By_Label() {
		homePage.refreshPage(driver);
		homePage.enterToHeraderTextboxByLabel("Country", "Japan");
		homePage.sleepInSecond(2);
	}
	
	@Test
	public void TC_03_Get_Data() {
		homePage.refreshPage(driver);
		homePage.getValueEachRowAtAllPage();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
