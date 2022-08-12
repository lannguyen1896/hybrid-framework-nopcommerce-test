package com.nopcommerce.user;

import org.testng.annotations.Test;

import common.HomePageObject;
import common.RegisterPageObject;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_2_Apply_BasePage_2{
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", project_path + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		homePage = new HomePageObject(driver);
		registerPage = new RegisterPageObject(driver);
		firstName = "Nguyen";
		lastName = "Lan";
		password = "123456";
		emailAddress = emailAddress();	
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");

	}
 
	@Test
	public void Register_01_Register_Empty_Data() {
		System.out.println("Home Page - Step 01: Click to Register link");
		homePage.clickToRegisterLink();
		
		System.out.println("Register page - Step 02: Click to Register button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Register page - Step 03: Verify error message");
		Assert.assertEquals(registerPage.getErrorMessageAtFirstNameTextbox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");
	}

	@Test
	public void Register_02_Invalid_Email() {
		System.out.println("Home Page - Step 01: Click to Register link");
		homePage.clickToRegisterLink();

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress + "@fdf4#$#%");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register page - Step 02: Click to Register button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Register page - Step 03: Verify error message");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");

	}

	@Test
	public void Register_03_Success() {
		System.out.println("Home Page - Step 01: Click to Register link");
		homePage.clickToRegisterLink();

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register page - Step 02: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register page - Step 04: Verify success message");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		System.out.println("Register page - Step 05: Click button Logout");
        registerPage.clickToLogoutButton();
	}

	@Test
	public void Register_04_Existing_Email() {
		System.out.println("Home Page - Step 01: Click to Register link");
		homePage.clickToRegisterLink();

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register page - Step 02: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register page - Step 03: Verify existing error message");
		Assert.assertEquals(registerPage.getErrorExistingMessage(),
				"The specified email already exists");

	}

	@Test
	public void Register_05_Password_Less_Than_6_Chars() {
		System.out.println("Home Page - Step 01: Click to Register link");
		homePage.clickToRegisterLink();

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress());
		registerPage.inputToPasswordTextbox("12345");
		registerPage.inputToConfirmPasswordTextbox("123456");

		System.out.println("Register page - Step 02: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register page - Step 03: Verify  error message");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(),
				"Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void Registerr_06_Password_And_ConfirmPassword_Is_Differrent() {
		System.out.println("Home Page - Step 01: Click to Register link");
		homePage.clickToRegisterLink();

		registerPage.inputToFirstNameTextbox("Nguyen");
		registerPage.inputToLastNameTextbox("Lan");
		registerPage.inputToEmailTextbox(emailAddress());
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password+ "12345678");

		System.out.println("Register page - Step 02: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register page - Step 03: Verify  error message");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(),
				"The password and confirmation password do not match.");
	}

	public String emailAddress() {
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

	
	
	
	
	private WebDriver driver;
	private String emailAddress;
	private String firstName, lastName, password;
	private String project_path = System.getProperty("user.dir");
	HomePageObject homePage;
	RegisterPageObject registerPage;
}
