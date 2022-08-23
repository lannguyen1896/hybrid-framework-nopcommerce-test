package pageObject.jQuery;

import org.openqa.selenium.WebDriver;

public class J_PageGeneratorManager {

	public static HomePageObject getHomePageObject(WebDriver driver) {
		return new HomePageObject(driver);
	}
}
