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
	// static Logger logger = Logger.getLogger(HomePage.class);

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

	@FindBy(css = "#maia-footer-global a")
	List<WebElement> footerLinks;

	@FindBy(id = "ognwrapper")
	WebElement wrapperHeader;

	@FindBy(xpath = "//*[text()='No thanks']")
	WebElement appAlert;

	public HomePage(WebDriver driver) {

		super(driver);
	}

	/**
	 * This method is used to enter the username
	 * 
	 * @param username
	 */
	public void enterUsername(String username) {

		// logger.info("Enter UserName :: " + username);
		userName.sendKeys(username);
	}

	/**
	 * This method is used to enter the password
	 * 
	 * @param password
	 */
	public void enterPassword(String pwd) {

		// logger.info("Enter Password :: " + pwd);
		password.sendKeys(pwd);
	}

	/**
	 * This method is used to click the "Try Google Keep" button
	 */
	public void clickTryGoogleKeepBtn() {

		// logger.info("Click TryGoogleKeep Button");
		tryGoogleKeepBtn.click();
	}

	/**
	 * This method is used to click the "Try Google Keep -> Android" button
	 */
	public void clickAndroidBtn() {

		// logger.info("Click TryGoogleKeep Button");
		androidBtn.click();
	}

	/**
	 * This method is used to click the "Try Google Keep -> iOS" button
	 */
	public void clickIOSBtn() {

		// logger.info("Click TryGoogleKeep Button");
		iOSBtn.click();
	}

	/**
	 * This method is used to click the "Try Google Keep -> Chrome" button
	 */
	public void clickChromeBtn() {

		// logger.info("Click TryGoogleKeep Button");
		chromeBtn.click();
	}

	/**
	 * This method is used to click the "Try Google Keep -> Web Version" button
	 */
	public void clickWebVersionBtn() {

		// logger.info("Click TryGoogleKeep Button");
		webVersionBtn.click();
	}

	/**
	 * This method is used to click the "Next" button in Google Sign-in form
	 * after entering username
	 */
	public void clickUsernameNextBtn() {

		// logger.info("Click Username -> Next Button");
		userNameNextBtn.click();
	}

	/**
	 * This method is used to click the "Next" button in Google Sign-in form
	 * after entering password
	 */
	public void clickPasswordNextBtn() {

		// logger.info("Click Password -> Next Button");
		passwordNextBtn.click();
	}

	/**
	 * This method is used to verify the presence of "Try Google Keep Button"
	 */
	public void verifyTryGoogleKeepBtn() {

		// logger.info("Verify Try Google Keep Button");

		Assert.assertTrue("Try Google Keep Button not displayed!!", tryGoogleKeepBtn.isDisplayed());
		Assert.assertTrue("Try Google Keep Button not enabled!!", tryGoogleKeepBtn.isEnabled());

		// logger.info("Google Keep Button verified successfully!!");

	}

	/**
	 * This method is used to get the container items list
	 * 
	 * @return List<MobileElement>
	 */
	public List<WebElement> getContainerItemsList() {

		// logger.info("Get Container Items List");

		return containerItems;
	}

	/**
	 * This method is used to verify the presence of "Try Google Keep Button"
	 */
	public void verifyGoogleSigninForm() {

		// logger.info("Verify Google Sign-in Form");

		Assert.assertTrue("Google Sign-in Form displayed!!", userName.isDisplayed());
		Assert.assertTrue("Google Sign-in Form enabled!!", userName.isEnabled());

		// logger.info("Google Sign-in Form verified successfully!!");

	}

	/**
	 * This method is used to get the footer links list
	 * 
	 * @return List<MobileElement>
	 */
	public List<WebElement> getFooterLinks() {

		// logger.info("Get Footer Links");

		return footerLinks;
	}

	/**
	 * This method is used to get the Header Text
	 * 
	 * @return String
	 */
	public String getHeaderText() {

		// logger.info("Get Header Text");

		return wrapperHeader.getText();
	}

	/**
	 * This method is used to click on the Alert
	 */
	public void handleAppAlert() {

		// logger.info("Handle App Alert");

		appAlert.click();
	}

	/**
	 * This method is used to get the footer links list
	 * 
	 * @return List<MobileElement>
	 */
	public List<WebElement> getSocialIcons() {

		// logger.info("Get Footer Links");

		return socialIcons;
	}

	public void clickGooglePlusIcon() {

		CommonHelper.mouseHover(m_driver, gPlusIcon);
		CommonHelper.switchToFrame(m_driver, gPlusIFrame);
		gPlusSocialIcon.click();

	}
}
