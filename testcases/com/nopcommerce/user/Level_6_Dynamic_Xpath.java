package com.nopcommerce.user;

import org.testng.annotations.Test;

import common.AddressPageObject;
import common.BaseTest;
import common.CustomerInforPageObject;
import common.HomePageObject;
import common.LoginPageObject;
import common.MyProductReviewPageObject;
import common.RewardPointPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_6_Dynamic_Xpath extends BaseTest {
	private String password, exactlyEmail;
	HomePageObject homePage;
	LoginPageObject loginPage;
	CustomerInforPageObject customerInfoPage;
	MyProductReviewPageObject myProductReviewPage;
	RewardPointPageObject rewardPointPage;
	AddressPageObject addressPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);

		password = "123456";
		exactlyEmail = "xyz@gmail.com";

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");

		homePage = new HomePageObject(driver);
		customerInfoPage = new CustomerInforPageObject(driver);
		myProductReviewPage = new MyProductReviewPageObject(driver);
		rewardPointPage = new RewardPointPageObject(driver);
		addressPage = new AddressPageObject(driver);
		
	}

	@Test
	public void Login_01_Empty_Data() {
		System.out.println("Home Page - Step 01: Click link Login");
		loginPage = homePage.clickToLoginLink();

		System.out.println("Login Page - Step 02: Click button Login");
		loginPage.clickToLoginButton();

		System.out.println("Login Page - Step 03: Verify error message");
		Assert.assertEquals(loginPage.getErrorMessageBlankEmail(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {
		System.out.println("Home Page - Step 01: Click to Login link");
		loginPage = homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(exactlyEmail);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();

	}

	@Test
	public void Login_03_Dynamic_Xpath() {
		
		rewardPointPage = (RewardPointPageObject) myProductReviewPage.openPageAtMyAccountByName(driver, "Reward points");
		addressPage = (AddressPageObject) rewardPointPage.openPageAtMyAccountByName(driver, "Addresses");
		myProductReviewPage = (MyProductReviewPageObject) addressPage.openPageAtMyAccountByName(driver, "My product reviews");
	}




	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
