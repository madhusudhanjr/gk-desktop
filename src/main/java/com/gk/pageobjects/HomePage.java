package com.gk.pageobjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gk.utils.CommonHelper;

/**
 * HomePage Class contains info on all the WebElements and its Operations
 * 
 * @author mjr (madhusudhan.jr@gmail.com)
 */
public class HomePage extends BasePage {

	/**
	 * Class variable which holds the reference to the Logger Object
	 */

	// Header Banner Row Buttons
	@FindBy(xpath = "//div[contains(@class, 'keep-header')]//a[contains(.,'Try Google Keep')]")
	WebElement tryGoogleKeepBtn;

	@FindBy(xpath = "//div[contains(@class, 'keep-header')]//a[contains(.,'Android')]")
	WebElement androidBtn;

	@FindBy(xpath = "//div[contains(@class, 'keep-header')]//a[contains(.,'iOS')]")
	WebElement iOSBtn;

	@FindBy(xpath = "//div[contains(@class, 'keep-header')]//a[contains(.,'Chrome')]")
	WebElement chromeBtn;

	@FindBy(xpath = "//div[contains(@class, 'keep-header')]//a[contains(.,'Web Version')]")
	WebElement webVersionBtn;

	// Header Social Icons
	@FindBy(css = ".social-link")
	List<WebElement> socialIcons;

	@FindBy(css = ".gplus")
	WebElement gPlusIcon;

	@FindBy(css = ".social-link-iframe-wrapper iframe")
	WebElement gPlusIFrame;

	@FindBy(css = ".ozWidgetRioButtonSvg_.ozWidgetRioButtonPlusOne_")
	WebElement gPlusSocialIcon;

	@FindBy(css = ".social-link--facebook a")
	WebElement facebookIcon;

	@FindBy(css = ".social-link--twitter a")
	WebElement twitterIcon;

	// Header Social Icons
	@FindBy(id = "identifierId")
	WebElement userName;

	@FindBy(id = "identifierNext")
	WebElement userNameNextBtn;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(id = "passwordNext")
	WebElement passwordNextBtn;

	@FindBy(css = ".keep-item-container")
	List<WebElement> containerItems;

	public HomePage(WebDriver driver) {

		super(driver);
	}

	/**
	 * This method is used to enter the username
	 * 
	 * @param username
	 */
	public void enterUsername(String username) {

		userName.sendKeys(username);
	}

	/**
	 * This method is used to enter the password
	 * 
	 * @param password
	 */
	public void enterPassword(String pwd) {

		CommonHelper.explicitWaitTillVisible(m_driver, 10, password);
		password.sendKeys(pwd);
	}

	/**
	 * This method is used to click the "Try Google Keep" button
	 */
	public void clickTryGoogleKeepBtn() {

		tryGoogleKeepBtn.click();
	}

	/**
	 * This method is used to click the "Try Google Keep -> Android" button
	 */
	public void clickAndroidBtn() {

		androidBtn.click();
	}

	/**
	 * This method is used to click the "Try Google Keep -> iOS" button
	 */
	public void clickIOSBtn() {

		iOSBtn.click();
	}

	/**
	 * This method is used to click the "Try Google Keep -> Chrome" button
	 */
	public void clickChromeBtn() {

		chromeBtn.click();
	}

	/**
	 * This method is used to click the "Try Google Keep -> Web Version" button
	 */
	public void clickWebVersionBtn() {

		webVersionBtn.click();
	}

	/**
	 * This method is used to click the "Next" button in Google Sign-in form
	 * after entering username
	 */
	public void clickUsernameNextBtn() {

		userNameNextBtn.click();
	}

	/**
	 * This method is used to click the "Next" button in Google Sign-in form
	 * after entering password
	 */
	public void clickPasswordNextBtn() {

		CommonHelper.explicitWaitTillVisible(m_driver, 10, passwordNextBtn);
		passwordNextBtn.click();
	}

	/**
	 * This method is used to get the container items list
	 * 
	 * @return List<WebElement>
	 */
	public List<WebElement> getContainerItemsList() {

		return containerItems;
	}

	/**
	 * This method is used to get the footer links list
	 * 
	 * @return List<WebElement>
	 */
	public List<WebElement> getSocialIcons() {

		return socialIcons;
	}

	/**
	 * This method is used to click the GPlus icon
	 */
	public void clickGooglePlusIcon() {

		gPlusSocialIcon.click();

	}

	/**
	 * This method is used to click the facebook icon
	 */
	public void clickFacebookIcon() {

		facebookIcon.click();

	}

	/**
	 * This method is used to click the Twitter icon
	 */
	public void clickTwitterIcon() {

		twitterIcon.click();

	}

	/**
	 * This method is used to mouseHover on GPlus icon
	 */
	public void moseHoverToGooglePlus() {

		CommonHelper.mouseHover(m_driver, gPlusIcon);
	}

	/**
	 * This method is used to switch to Gplus iframe
	 */
	public void switchToGPlusFrame() {

		CommonHelper.switchToFrame(m_driver, gPlusIFrame);
	}

	/**
	 * This method is used to verify the presence of "Try Google Keep Button"
	 */
	public void verifyTryGoogleKeepBtn() {

		Assert.assertTrue("Try Google Keep Button not displayed!!", tryGoogleKeepBtn.isDisplayed());
		Assert.assertTrue("Try Google Keep Button not enabled!!", tryGoogleKeepBtn.isEnabled());
	}
}
