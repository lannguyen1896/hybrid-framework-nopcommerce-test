package common;

import org.openqa.selenium.WebDriver;

import pageUIs.HomePageUI;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage{

	private WebDriver driver;
	
	
	public RegisterPageObject(WebDriver driver) {
		//super();
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickElement(driver, RegisterPageUI.REGISTER_BUTTON);
		
	}

	public String getErrorMessageAtFirstNameTextbox() {
		waitForElementPresence(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtLastNameTextbox() {
		waitForElementPresence(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementPresence(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementPresence(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementPresence(driver, RegisterPageUI.CONFIRMP_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.CONFIRMP_PASSWORD_ERROR_MESSAGE);
	}

	public void inputToFirstNameTextbox(String firstName) {
		//waitForElementPresence(driver, RegisterPageUI.FIRST_NAME_TETXBOX);
		sendkeyToElement(driver,RegisterPageUI.FIRST_NAME_TETXBOX, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		//waitForElementPresence(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver,RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
		
	}

	public void inputToEmailTextbox(String emailAdress) {
		//waitForElementPresence(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver,RegisterPageUI.EMAIL_TEXTBOX, emailAdress);
		
	}

	public void inputToPasswordTextbox(String password) {
		//waitForElementPresence(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver,RegisterPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		//waitForElementPresence(driver, RegisterPageUI.CONFIRMPASSWORD_TEXTBOX);
		sendkeyToElement(driver,RegisterPageUI.CONFIRMPASSWORD_TEXTBOX, confirmPassword);
		
	}

	public String getRegisterSuccessMessage() {
		waitForElementPresence(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public void clickToLogoutButton() {
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickElement(driver, RegisterPageUI.LOGOUT_LINK);
		
	}

	public String getErrorExistingMessage() {
		waitForElementPresence(driver, RegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
	}

}
