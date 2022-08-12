package common;

import org.openqa.selenium.WebDriver;

import pageUIs.HomePageUI;

public class HomePageObject extends BasePage{

	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		//super();
		this.driver = driver;
	}

	public void clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickElement(driver, HomePageUI.REGISTER_LINK);
		
	}

	public void clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickElement(driver, HomePageUI.LOGIN_LINK);
		
	}

	public boolean isMyAccountLinkIsDisplayed() {
		if(isElementDisplayed(driver, "//a[@class='ico-account']")) {
			return true;
		}
		return false;
	}

}
