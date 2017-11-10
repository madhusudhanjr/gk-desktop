package com.gk.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * BasePage Class holds abstract / common methods which are supposed to be
 * implemented by all the Page Objects
 * 
 * @author Madhusudhan (madhusudhan.jr@gmail.com)
 */
public abstract class BasePage {

	/**
	 * Class Variable m_driver
	 */
	protected final WebDriver m_driver;

	/**
	 * A base constructor that sets the page's driver
	 *
	 * The page structure is being used within this test in order to separate
	 * the page actions from the tests.
	 *
	 * @param driver
	 *            the driver created in the BeforeTest method.
	 */
	protected BasePage(WebDriver driver) {

		this.m_driver = driver;
		AjaxElementLocatorFactory ajaxElementLocatorFactory = new AjaxElementLocatorFactory(driver, 15);
		PageFactory.initElements(ajaxElementLocatorFactory, this);

	}

}
