package com.nopcommerce.user;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class User_01_Register_Login {
	WebDriver driver;
	String project_path = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", project_path + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");

	}
	
	@Test
	public void TC_01_Register_Empty_Data() {
		driver.findElement(By.cssSelector("a.ico-register")).click();
		driver.findElement(By.cssSelector("button#register-button")).click();
		
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='FirstName-error']")).getText(), "First name is required.");
		Assert.assertEquals(driver.findElement(By.id("LastName-error")).getText(), "Last name is required.");
		Assert.assertEquals(driver.findElement(By.id("Email-error")).getText(), "Email is required.");
		Assert.assertEquals(driver.findElement(By.id("Password-error")).getText(), "Password is required.");
		Assert.assertEquals(driver.findElement(By.id("ConfirmPassword-error")).getText(), "Password is required.");
	}
	
	@Test
	public void TC_02_Invalid_Email() {
		driver.findElement(By.cssSelector("a.ico-register")).click();
		
		driver.findElement(By.id("FirstName")).sendKeys("Nguyen");
		driver.findElement(By.id("LastName")).sendKeys("Lan");
		driver.findElement(By.id("Email")).sendKeys("Nguyen5454$465%^&");
		driver.findElement(By.id("Password")).sendKeys("123456");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("123456");
		
		driver.findElement(By.cssSelector("button#register-button")).click();
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.id("Email-error")).getText(), "Wrong email");

	}
	
	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
