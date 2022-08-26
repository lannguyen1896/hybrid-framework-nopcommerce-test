package pageObject.jQuery.uploadFiles;

import org.openqa.selenium.WebDriver;

public class U_PageGeneratorManager {

	public static HomePageObject getHomePageObject(WebDriver driver) {
		return new HomePageObject(driver);
	}
}
