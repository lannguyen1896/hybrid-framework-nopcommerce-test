package common;


import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	protected WebDriver driver;
	
	protected WebDriver getBrowserDriver(String browserName) {
		if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		/*
		 * if (browserName.equals("chrome")) { WebDriverManager.chromedriver().setup();
		 * driver = new ChromeDriver(); } if (browserName.equals("edge")) {
		 * WebDriverManager.edgedriver().setup(); driver = new EdgeDriver(); }
		 */else {
			//throw new RuntimeException("Browser name is invalid!");
			System.out.println("Invalid");
		}
		return driver;
	}
	
	
}
