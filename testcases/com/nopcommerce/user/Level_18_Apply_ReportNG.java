package com.nopcommerce.user;

import org.testng.annotations.Test;
import common.BaseTest;
import common.HomePageObject;
import common.LoginPageObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterClass;

@Listeners(common.MethodListener.class)
public class Level_18_Apply_ReportNG extends BaseTest {
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
		verifyEquals(loginPage.getErrorMessageBlankEmail(), "Please enter your email");
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
		verifyEquals(loginPage.getErrorMessageInvalidEmail(), "Wronggg email");

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
		verifyEquals(loginPage.getErrorMessageNotExistedEmail(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04_Blank_Password() {
		System.out.println("Home Page - Step 01: Click to Login link");
		homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(email);

		System.out.println("Login Page - Step 02: Click to Login button");
		loginPage.clickToLoginButton();

		System.out.println("Login page - Step 03: Verify error message");
		verifyEquals(loginPage.getErrorMessageBlankPassword(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}

	@Test
	public void Login_05_Wrong_Password() {
		System.out.println("Home Page - Step 01: Click to Login link");
		homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password + "22233fgfg");

		System.out.println("Login Page - Step 02: Click to Login button");
		loginPage.clickToLoginButton();

		System.out.println("Login page - Step 03: Verify error message");
		verifyEquals(loginPage.getErrorMessageWrongPassword(),
				"Login was unsuccessful. PleaseEEEE correct the errors and try again.\nNo customer account found");

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
