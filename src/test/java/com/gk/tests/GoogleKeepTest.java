package com.gk.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gk.utils.CommonHelper;

/**
 * Test class to test BorrowingCalculator functionalities
 * 
 * @author Madhusudhan (madhusudhan.jr@gmail.com)
 *
 */
public class GoogleKeepTest extends BaseTest {

	/**
	 * Test Scenario: To verify the amount able to borrow for Joint Application
	 * type with dependents
	 * 
	 * @param url
	 * @throws Exception
	 */
	@Parameters({ "url" })
	@Test(priority = 0)
	public void verifyGKHeaderTryGoogleKeepBtnNavigations(String url) throws Exception {

		Reporter.log("Enter TestMethod");
		m_HomePage = launchURL(url);

		String currentURL = "";
		Reporter.log("Click Try Google Keep Btn");
		m_HomePage.clickTryGoogleKeepBtn();

		Reporter.log("Click Android Btn");
		m_HomePage.clickAndroidBtn();
		currentURL = getDriverForThread().getCurrentUrl();
		Assert.assertTrue(currentURL.contains(CommonHelper.ANDROID_PLAYSTORE_URL), "Andorid PlayStore URL Not Found!!");
		CommonHelper.navigateBack(getDriverForThread());
		Reporter.log(currentURL);
		Reporter.log("Verified navigation to Android Play Store successfully!!");

		Reporter.log("Click Try Google Keep Btn");
		m_HomePage.clickTryGoogleKeepBtn();

		Reporter.log("Click iOS Btn");
		m_HomePage.clickIOSBtn();
		currentURL = getDriverForThread().getCurrentUrl();
		Assert.assertTrue(currentURL.contains(CommonHelper.ITUNES_APPSTORE_URL), "iTunes AppStore URL Not Found!!");
		CommonHelper.navigateBack(getDriverForThread());
		Reporter.log(currentURL);
		Reporter.log("Verified navigation to iOS App Store successfully!!");

		Reporter.log("Click Try Google Keep Btn");
		m_HomePage.clickTryGoogleKeepBtn();

		Reporter.log("Click Chrome Btn");
		m_HomePage.clickChromeBtn();
		currentURL = getDriverForThread().getCurrentUrl();
		Assert.assertTrue(currentURL.contains(CommonHelper.CHROME_WEBSTORE_URL), "Chrome Webstore URL Not Found!!");
		CommonHelper.navigateBack(getDriverForThread());
		Reporter.log(currentURL);
		Reporter.log("Verified navigation to Chrome Webstore Store successfully!!");

		Reporter.log("Click Try Google Keep Btn");
		m_HomePage.clickTryGoogleKeepBtn();

		Reporter.log("Click WebVersion Btn");
		m_HomePage.clickWebVersionBtn();
		currentURL = getDriverForThread().getCurrentUrl();
		Assert.assertTrue(currentURL.contains(CommonHelper.GOOGLE_ACCOUNTS_URL), "Google Account URL Not Found!!");
		CommonHelper.navigateBack(getDriverForThread());
		Reporter.log(currentURL);
		Reporter.log("Verified navigation to WebVersion successfully!!");

		Reporter.log("Exit TestMethod");

	}

	/**
	 * Test Scenario: To verify the amount able to borrow for Joint Application
	 * type with dependents and to revising the Estimate
	 * 
	 * @param url
	 * @throws Exception
	 */
	@Parameters({ "url" })
	@Test(priority = 1)
	public void verifyGKHeaderSocialIcons(String url) throws Exception {

		Reporter.log("Enter TestMethod");
		m_HomePage = launchURL(url);

		Reporter.log("Verify Social Icons");
		List<WebElement> socialIcons = m_HomePage.getSocialIcons();

		int size = socialIcons.size();
		Assert.assertTrue(size == 3, "Container Items List Size Mismatched!!");

		String currentURL = "";
		String mainWindow = "";

		// Verify GooglePlus
		Reporter.log("Mouse Hover to Google Plus");
		m_HomePage.moseHoverToGooglePlus();
		m_HomePage.switchToGPlusFrame();

		Reporter.log("Click Google Plus Icon");
		m_HomePage.clickGooglePlusIcon();
		CommonHelper.switchToDefaultContent(getDriverForThread());

		mainWindow = getDriverForThread().getWindowHandle();
		CommonHelper.switchToChildWindow(getDriverForThread());

		currentURL = getDriverForThread().getCurrentUrl();
		Assert.assertTrue(currentURL.contains(CommonHelper.GOOGLE_ACCOUNTS_URL), "Google Plus Window Not Found!!");
		getDriverForThread().close();
		CommonHelper.switchToWindow(getDriverForThread(), mainWindow);
		Reporter.log(currentURL);
		Reporter.log("Google Accounts Window launched auccessfully");

		// Verify Twitter
		Reporter.log("Click Twitter Icon");
		m_HomePage.clickTwitterIcon();
		mainWindow = getDriverForThread().getWindowHandle();
		CommonHelper.switchToChildWindow(getDriverForThread());

		currentURL = getDriverForThread().getCurrentUrl();
		Assert.assertTrue(currentURL.contains(CommonHelper.TWITTER_SHARE), "Twitter Window Not Found!!");
		getDriverForThread().close();
		CommonHelper.switchToWindow(getDriverForThread(), mainWindow);
		Reporter.log(currentURL);
		Reporter.log("Twitter Window launched auccessfully");

		// Verify facebook
		Reporter.log("Click Facebook Icon");
		m_HomePage.clickFacebookIcon();
		mainWindow = getDriverForThread().getWindowHandle();

		CommonHelper.wait(2);
		int count = getDriverForThread().getWindowHandles().size();
		Assert.assertTrue(count == 2, "Facebook Window Not Found!!");

		CommonHelper.switchToChildWindow(getDriverForThread());

		currentURL = getDriverForThread().getCurrentUrl();
		Assert.assertTrue(currentURL.contains(CommonHelper.FACEBOOK_SHARE), "Facebook Window Not Found!!");
		getDriverForThread().close();
		CommonHelper.switchToWindow(getDriverForThread(), mainWindow);
		Reporter.log(currentURL);
		Reporter.log("Facebook Window launched auccessfully");

		Reporter.log("Exit TestMethod");
	}

	/**
	 * Test Scenario: To verify the amount able to borrow for Joint Application
	 * type with dependents and to revising the Estimate
	 * 
	 * @param url
	 * @throws Exception
	 */
	@Parameters({ "url" })
	@Test(priority = 2)
	public void verifyGKContainerItems(String url) throws Exception {

		Reporter.log("Enter TestMethod");
		m_HomePage = launchURL(url);

		Reporter.log("Get Container Items");
		List<WebElement> containerItems = m_HomePage.getContainerItemsList();

		WebElement element = containerItems.get(0);
		CommonHelper.scrollToElement(getDriverForThread(), element);

		CommonHelper.wait(5);
		int size = containerItems.size();
		Assert.assertTrue(size == 4, "Container Items List Size Mismatched!!");

		for (WebElement el : containerItems) {
			Reporter.log("****Container Items***\n");
			Reporter.log(el.getText());
		}

		Reporter.log("Exit TestMethod");
	}

	/**
	 * Test Scenario: To verify the amount able to borrow for Joint Application
	 * type with dependents and to revising the Estimate
	 * 
	 * @param url
	 * @throws Exception
	 */
	@Parameters({ "url" })
	@Test(priority = 3)
	public void verifyGKSuccessfulLogin(String url) throws Exception {

		Reporter.log("Enter TestMethod");
		m_HomePage = launchURL(url);

		String currentURL = "";
		Reporter.log("Click Try Google Keep Btn");
		m_HomePage.clickTryGoogleKeepBtn();

		Reporter.log("Click Web Version Button");
		m_HomePage.clickWebVersionBtn();

		Reporter.log("Assert Google Accounts URL");
		currentURL = getDriverForThread().getCurrentUrl();
		Assert.assertTrue(currentURL.contains(CommonHelper.GOOGLE_ACCOUNTS_URL), "Google Account URL Not Found!!");
		Reporter.log("Google Accounts URL launched successfully!!");

		Reporter.log("Google Accounts - Enter UserName");
		m_HomePage.enterUsername("testqatqa@gmail.com");
		m_HomePage.clickUsernameNextBtn();

		Reporter.log("Google Accounts - Enter Password");
		m_HomePage.enterPassword("Test@123");
		m_HomePage.clickPasswordNextBtn();

		Reporter.log("Exit TestMethod");
	}

}