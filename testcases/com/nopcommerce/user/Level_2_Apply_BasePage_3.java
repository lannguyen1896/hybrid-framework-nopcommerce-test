package com.nopcommerce.user;

import org.testng.annotations.Test;

import common.BasePage;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_2_Apply_BasePage_3 {
	WebDriver driver;
	BasePage basePage;
	String emailAddress = emailAddress();
	String project_path = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", project_path + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		basePage = BasePage.getBasePage();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");

	}

	public void TC_01_Register_Empty_Data() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickElement(driver, "//a[@class='ico-register']");
		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickElement(driver, "//button[@id='register-button']");

		basePage.sleepInSecond(3);
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='FirstName-error']"),
				"First name is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"),
				"Password is required.");
	}

	public void TC_02_Invalid_Email() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickElement(driver, "//a[@class='ico-register']");

		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Nguyen");
		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "Lan");
		basePage.sendkeyToElement(driver, "//input[@id='Email']", "Langfgf%5667#$#3");
		basePage.sendkeyToElement(driver, "//input[@id='Password']", "123456");
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickElement(driver, "//button[@id='register-button']");
		basePage.sleepInSecond(2);
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Wrong email");

	}

	@Test
	public void TC_03_Register_Success() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickElement(driver, "//a[@class='ico-register']");

		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Nguyen");
		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "Lan");
		basePage.sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		basePage.sendkeyToElement(driver, "//input[@id='Password']", "123456");
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickElement(driver, "//button[@id='register-button']");

		basePage.sleepInSecond(2);
		Assert.assertEquals(basePage.getElementText(driver, "//div[@class='result']"), "Your registration completed");

		basePage.waitForElementClickable(driver, "//a[@class='ico-logout']");
		basePage.clickElement(driver, "//a[@class='ico-logout']");
	}

	@Test
	public void TC_04_REgister_Existing_Email() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickElement(driver, "//a[@class='ico-register']");

		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Nguyen");
		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "Lan");
		basePage.sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		basePage.sendkeyToElement(driver, "//input[@id='Password']", "123456");
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickElement(driver, "//button[@id='register-button']");

		basePage.sleepInSecond(2);
		Assert.assertEquals(basePage.getElementText(driver, "//div[contains(@class, 'message-error')]//li"),
				"The specified email already exists");

	}

	@Test
	public void TC_05_Register_Password_Less_Than_6_Chars() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickElement(driver, "//a[@class='ico-register']");

		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Nguyen");
		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "Lan");
		basePage.sendkeyToElement(driver, "//input[@id='Email']", emailAddress());
		basePage.sendkeyToElement(driver, "//input[@id='Password']", "12345");
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "12345");

		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickElement(driver, "//button[@id='register-button']");

		basePage.sleepInSecond(2);
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"),
				"Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void TC_06_Password_And_ConfirmPassword_Is_Differrent() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickElement(driver, "//a[@class='ico-register']");

		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Nguyen");
		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "Lan");
		basePage.sendkeyToElement(driver, "//input[@id='Email']", emailAddress());
		basePage.sendkeyToElement(driver, "//input[@id='Password']", "123456");
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456789");

		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickElement(driver, "//button[@id='register-button']");

		basePage.sleepInSecond(2);
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"),
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

}
