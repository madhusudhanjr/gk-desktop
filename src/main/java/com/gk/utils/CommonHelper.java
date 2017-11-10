package com.gk.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonHelper {

	/**
	 * String Constants
	 */
	public static final String ANDROID_PLAYSTORE_URL = "https://play.google.com/store/";
	public static final String ITUNES_APPSTORE_URL = "https://itunes.apple.com/app/apple-store/";
	public static final String CHROME_WEBSTORE_URL = "https://chrome.google.com/webstore/";
	public static final String GOOGLE_ACCOUNTS_URL = "https://accounts.google.com/signin";
	public static final String GOOGLE_PLUS_SHARE = "https://plus.google.com/share";
	public static final String TWITTER_SHARE = "https://twitter.com/intent/tweet";
	public static final String FACEBOOK_SHARE = "https://facebook.com";


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
	 * This method is used to scroll to the WebElement on the Web Page
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
	 * This method is used to mouse hover on a WeElement
	 * 
	 * @param driver
	 * @param el
	 */
	public static void mouseHover(WebDriver driver, WebElement el) {

		Actions action = new Actions(driver);
		action.moveToElement(el).build().perform();
	}

	/**
	 * This method is used to switch to iFrame
	 * 
	 * @param driver
	 * @param el
	 */
	public static void switchToFrame(WebDriver driver, WebElement el) {

		driver.switchTo().frame(el);
	}

	/**
	 * This method is used to switch Default Content
	 * 
	 * @param driver
	 * @param el
	 */
	public static void switchToDefaultContent(WebDriver driver) {

		driver.switchTo().defaultContent();
	}

	/**
	 * This method is used to identify the type of OS
	 * @return OS Name
	 */
	public static String OSDetector() {
		String os = System.getProperty("os.name").toLowerCase();
		if (os.contains("win")) {
			return "Windows";
		} else if (os.contains("nux") || os.contains("nix")) {
			return "Linux";
		} else if (os.contains("mac")) {
			return "Mac";
		} else if (os.contains("sunos")) {
			return "Solaris";
		} else {
			return "Other";
		}
	}

	/**
	 * This method is used to switch To Child Window
	 * 
	 * @param driver
	 * @param el
	 */
	public static void switchToChildWindow(WebDriver driver) {

		String mainWindow = driver.getWindowHandle();

		for (String window : driver.getWindowHandles()) {

			if (!window.equalsIgnoreCase(mainWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}

		driver.switchTo().defaultContent();
	}

	/**
	 * This method is used to switch To Parent Window
	 * 
	 * @param driver
	 * @param el
	 */
	public static void switchToWindow(WebDriver driver, String window) {

		driver.switchTo().window(window);
	}
}
