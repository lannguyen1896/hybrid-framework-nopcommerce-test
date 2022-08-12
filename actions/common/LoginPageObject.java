package common;

import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage{

	private WebDriver driver;
	public String getErrorMessageAtEmail;
	
	public LoginPageObject(WebDriver driver) {
		//super();
		this.driver = driver;
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickElement(driver, LoginPageUI.LOGIN_BUTTON);
		
	}

	public void inputToEmailTextbox(String emailLogin) {
		waitForElementPresence(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver,LoginPageUI.EMAIL_TEXTBOX, emailLogin);
		
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementPresence(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver,LoginPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public String getErrorMessageNotExistedEmail() {
		waitForElementPresence(driver, LoginPageUI.NOT_REGISTED_EMAIL_MESSAGE);
		return getElementText(driver, LoginPageUI.NOT_REGISTED_EMAIL_MESSAGE);
	}

	public String getErrorMessageBlankPassword() {
		waitForElementPresence(driver, LoginPageUI.BLANK_PASSWORD_MESSAGE);
		return getElementText(driver, LoginPageUI.BLANK_PASSWORD_MESSAGE);
	}

	public String getErrorMessageWrongPassword() {
		waitForElementPresence(driver, LoginPageUI.WRONG_PASSWORD_MESSAGE);
		return getElementText(driver, LoginPageUI.WRONG_PASSWORD_MESSAGE);
	}

	public String getErrorMessageBlankEmail() {
		waitForElementPresence(driver, LoginPageUI.BLANK_EMAIL_MESSAGE);
		return getElementText(driver, LoginPageUI.BLANK_EMAIL_MESSAGE);
	}

	public String getErrorMessageInvalidEmail() {
		waitForElementPresence(driver, LoginPageUI.INVALID_EMAIL_MESSAGE);
		return getElementText(driver, LoginPageUI.INVALID_EMAIL_MESSAGE);
	}

}
