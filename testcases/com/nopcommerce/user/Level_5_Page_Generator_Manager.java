package com.nopcommerce.user;

import org.testng.annotations.Test;
import common.BaseTest;
import common.HomePageObject;
import common.LoginPageObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_5_Page_Generator_Manager extends BaseTest {
	private String email, password, invalidEmail, notExistedEmail;
	HomePageObject homePage;
	LoginPageObject loginPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);

		password = "123456";
		email = emailLogin();
		invalidEmail = "abcgmail.com";
		notExistedEmail = "ff" + emailLogin();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);

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

		loginPage.inputToEmailTextbox(invalidEmail);
		loginPage.inputToPasswordTextbox(password);

		System.out.println("Login Page - Step 02: Click to Login button");
		loginPage.clickToLoginButton();

		System.out.println("Login page - Step 03: Verify error message");
		Assert.assertEquals(loginPage.getErrorMessageInvalidEmail(), "Wrong email");

	}

	@Test
	public void Login_03_Not_Registed_Email() {
		System.out.println("Home Page - Step 01: Click to Login link");
		homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(notExistedEmail);
		loginPage.inputToPasswordTextbox(password);

		System.out.println("Login Page - Step 02: Click to Login button");
		loginPage.clickToLoginButton();

		System.out.println("Login page - Step 03: Verify error message");
		Assert.assertEquals(loginPage.getErrorMessageNotExistedEmail(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	public void Login_04_Blank_Password() {
		System.out.println("Home Page - Step 01: Click to Login link");
		homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(email);

		System.out.println("Login Page - Step 02: Click to Login button");
		loginPage.clickToLoginButton();

		System.out.println("Login page - Step 03: Verify error message");
		Assert.assertEquals(loginPage.getErrorMessageBlankPassword(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}

	public void Login_05_Wrong_Password() {
		System.out.println("Home Page - Step 01: Click to Login link");
		homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password + "22233fgfg");

		System.out.println("Login Page - Step 02: Click to Login button");
		loginPage.clickToLoginButton();

		System.out.println("Login page - Step 03: Verify error message");
		Assert.assertEquals(loginPage.getErrorMessageWrongPassword(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}

	public String emailLogin() {
		return "lan" + fakeIntNumber() + "n@gmail.com";
	}

	public int fakeIntNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
