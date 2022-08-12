package com.nopcommerce.user;

import org.testng.annotations.Test;

import common.HomePageObject;
import common.LoginPageObject;
import common.RegisterPageObject;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

@Test
public class Level_2_Apply_BasePage_2{
	private WebDriver driver;
	private String email, password, invalidEmail, notExistedEmail;
	private String project_path = System.getProperty("user.dir");
	HomePageObject homePage;
	RegisterPageObject registerPage;
	Level_2_Login level_2;
	LoginPageObject loginPage;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", project_path + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		homePage = new HomePageObject(driver);
		loginPage = new LoginPageObject(driver);
		registerPage = new RegisterPageObject(driver);
		level_2 = new Level_2_Login();
		
		password = "123456";
		email = emailLogin();
		invalidEmail = "abcgmail.com";
		notExistedEmail = "ff"+emailLogin();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
 
	}
 
	public void Login_01_Empty_Data() {
		System.out.println("Home Page - Step 01: Click link Login");
		homePage.clickToLoginLink();
		
		System.out.println("Login Page - Step 02: Click button Login");
		loginPage.clickToLoginButton();
		
		System.out.println("Login Page - Step 03: Verify error message");
		Assert.assertEquals(loginPage.getErrorMessageBlankEmail(), "Please enter your email");
	}

	public void Login_02_Invalid_Email() {
		System.out.println("Home Page - Step 01: Click to Login link");
		homePage.clickToLoginLink();

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
		Assert.assertEquals(loginPage.getErrorMessageNotExistedEmail(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	public void Login_04_Blank_Password() {
		System.out.println("Home Page - Step 01: Click to Login link");
		homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(email);

		System.out.println("Login Page - Step 02: Click to Login button");
		loginPage.clickToLoginButton();
		
		System.out.println("Login page - Step 03: Verify error message");
		Assert.assertEquals(loginPage.getErrorMessageBlankPassword(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	

	}

	public void Login_05_Wrong_Password() {
		System.out.println("Home Page - Step 01: Click to Login link");
		homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password+ "22233fgfg");

		System.out.println("Login Page - Step 02: Click to Login button");
		loginPage.clickToLoginButton();
		
		System.out.println("Login page - Step 03: Verify error message");
		Assert.assertEquals(loginPage.getErrorMessageWrongPassword(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	
	}

	public void Login_06_Success_Login() {
		System.out.println("Home Page - Step 01: Click to Login link");
		homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);

		System.out.println("Login Page - Step 02: Click to Login button");
		loginPage.clickToLoginButton();
		
		System.out.println("Login page - Step 03: Verify success move to HomePage");
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isMyAccountLinkIsDisplayed());
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
