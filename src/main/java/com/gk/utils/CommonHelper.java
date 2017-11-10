package com.gk.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonHelper {

	/**
	 * String Constants
	 */
	public static final String ANDROID_PLAYSTORE_URL = "https://play.google.com/store/";
	public static final String ITUNES_APPSTORE_URL = "https://itunes.apple.com/app/apple-store/";
	public static final String CHROME_WEBSTORE_URL = "https://chrome.google.com/webstore/";
	public static final String GOOGLE_ACCOUNTS_URL = "https://accounts.google.com/signin";
	public static final String JOINT = "Joint";
	public static final String NO = "No";
	public static final String YES = "Yes";

	/**
	 * This method is used to select the option from the Combo
	 * 
	 * @param selectElement
	 * @param option
	 */
	public static void selectOption(WebElement selectElement, String option) {

		Select select = new Select(selectElement);
		select.selectByVisibleText(option);
	}

	/**
	 * This method is used to wait till the visible of the Element
	 * 
	 * @param driver
	 * @param sec
	 * @param element
	 */
	public static void explicitWaitTillVisible(WebDriver driver, int sec, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method is used to Navigate Back on the Web Page
	 * 
	 * @param driver
	 */
	public static void navigateBack(WebDriver driver) {

		driver.navigate().back();
	}

	/**
	 * This method is used to Navigate Back on the Web Page
	 * 
	 * @param driver
	 */
	public static void scrollToElement(WebDriver driver, WebElement el) {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
	}

	/**
	 * Wait in minutes
	 * 
	 * @param min
	 */
	public static void wait(int min) {

		try {
			Thread.sleep(1000 * min);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to mouse hover on a element
	 * 
	 * @param driver
	 * @param el
	 */
	public static void mouseHover(WebDriver driver, WebElement el) {

		Actions action = new Actions(driver);
		action.moveToElement(el).build().perform();
	}

	/**
	 * This method is used to switch to an element
	 * 
	 * @param driver
	 * @param el
	 */
	public static void switchToFrame(WebDriver driver, WebElement el) {

		driver.switchTo().frame(el);
	}
}
