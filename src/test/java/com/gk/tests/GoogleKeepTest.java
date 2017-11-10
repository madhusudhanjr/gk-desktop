package com.gk.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
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

	// Logger logger = Logger.getLogger(GoogleKeepTest.class);

	/**
	 * Test Scenario: To verify the amount able to borrow for Joint Application
	 * type with dependents
	 * 
	 * @param url
	 * @throws Exception
	 */
	@Parameters({ "url" })
	//@Test(priority = 0)
	public void verifyGKHeaderTryGoogleKeepBtnComponent(String url) throws Exception {

		System.out.println("Enter TestMethod");
		m_HomePage = launchURL(url);

		String currentURL = "";
		m_HomePage.clickTryGoogleKeepBtn();
		m_HomePage.clickAndroidBtn();
		currentURL = getDriverForThread().getCurrentUrl();
		Assert.assertTrue(currentURL.contains(CommonHelper.ANDROID_PLAYSTORE_URL), "Andorid PlayStore URL Not Found!!");
		CommonHelper.navigateBack(getDriverForThread());

		m_HomePage.clickTryGoogleKeepBtn();
		m_HomePage.clickIOSBtn();
		currentURL = getDriverForThread().getCurrentUrl();
		Assert.assertTrue(currentURL.contains(CommonHelper.ITUNES_APPSTORE_URL), "iTunes AppStore URL Not Found!!");
		CommonHelper.navigateBack(getDriverForThread());

		m_HomePage.clickTryGoogleKeepBtn();
		m_HomePage.clickChromeBtn();
		currentURL = getDriverForThread().getCurrentUrl();
		Assert.assertTrue(currentURL.contains(CommonHelper.CHROME_WEBSTORE_URL), "Chrome Webstore URL Not Found!!");
		CommonHelper.navigateBack(getDriverForThread());

		m_HomePage.clickTryGoogleKeepBtn();
		m_HomePage.clickWebVersionBtn();
		currentURL = getDriverForThread().getCurrentUrl();
		Assert.assertTrue(currentURL.contains(CommonHelper.GOOGLE_ACCOUNTS_URL), "Google Account URL Not Found!!");
		CommonHelper.navigateBack(getDriverForThread());

		System.out.println("Exit TestMethod");

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
	public void verifyGKHEaderSocialIcons(String url) throws Exception {

		System.out.println("Enter TestMethod");
		m_HomePage = launchURL(url);

		List<WebElement> socialIcons = m_HomePage.getSocialIcons();

		int size = socialIcons.size();
		Assert.assertTrue(size == 3, "Container Items List Size Mismatched!!");


		m_HomePage.clickGooglePlusIcon();
		System.out.println("Exit TestMethod");
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

		System.out.println("Enter TestMethod");
		m_HomePage = launchURL(url);

		List<WebElement> containerItems = m_HomePage.getContainerItemsList();

		WebElement element = containerItems.get(0);
		CommonHelper.scrollToElement(getDriverForThread(), element);

		CommonHelper.wait(5);
		int size = containerItems.size();
		Assert.assertTrue(size == 4, "Container Items List Size Mismatched!!");

		for (WebElement el : containerItems) {
			System.out.println(el.getText());
		}

		System.out.println("Exit TestMethod");
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
	public void verifyGKFooterLinks(String url) throws Exception {

		System.out.println("Enter TestMethod");
		m_HomePage = launchURL(url);

		List<WebElement> footerLinks = m_HomePage.getFooterLinks();

		CommonHelper.wait(5);
		int size = footerLinks.size();
		Assert.assertTrue(size == 4, "Container Items List Size Mismatched!!");

		for (WebElement el : footerLinks) {

			System.out.println(el.getText());
			el.click();

			CommonHelper.wait(5);
			System.out.println("Window Title:: " + getDriverForThread().getCurrentUrl());
			CommonHelper.navigateBack(getDriverForThread());

		}

		System.out.println("Exit TestMethod");
	}

}