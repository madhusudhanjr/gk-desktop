package com.gk.tests;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.gk.pageobjects.HomePage;

/**
 * BaseTest Class holds common methods to execute before and after executing the
 * Test Cases
 * 
 * @author Madhusudhan (madhusudhan.jr@gmail.com)
 */
public class BaseTest {

	/**
	 * Class variable which holds the reference to the Logger Object
	 */
	//static Logger logger = Logger.getLogger(BaseTest.class);

	/**
	 * Class variable which holds the reference to the WebDriver Object
	 */
	public static String m_browser;

	enum Drivers {

		CHROME;
	}

	/**
	 * Class variable reference to Page Objects
	 */
	public HomePage m_HomePage;

	/**
	 * Synchronized list of web drivers that stores the browser driver instance
	 * for each thread instance
	 */
	private static List<WebDriver> m_listOfWebDrivers = Collections.synchronizedList(new ArrayList<WebDriver>());
	private static ThreadLocal<WebDriver> m_driverForThread = new ThreadLocal<WebDriver>() {

		@Override
		protected WebDriver initialValue() {
			WebDriver driver = null;
			try {
				driver = loadDriver();

			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("Initializing Webdriver");
			m_listOfWebDrivers.add(driver);
			return driver;
		}
	};

	/**
	 * This method is used to launch the MortgageCalculator URL
	 * 
	 * @param url
	 * @return MortgageCalculatorsPage
	 */
	public HomePage launchURL(String url) {

		getDriverForThread().get(url);

		return new HomePage(getDriverForThread());
	}

	/**
	 * This method will be executed BeforeSuite and is used to initialize the
	 * loggers before executing tests
	 * 
	 * @param browser
	 */
	@Parameters({ "browser" })
	@BeforeSuite(alwaysRun = true)
	public void initialize(String browser) {

		//PropertyConfigurator.configure("src/test/resources/Logger/log4j.properties");
		m_browser = browser;

	}

	/**
	 * This method is used to load driver
	 * 
	 * @return WebDriver
	 */
	public static WebDriver loadDriver() {

		DesiredCapabilities capabilites = null;
		WebDriver driver = null;

		switch (Drivers.valueOf(m_browser)) {
		case CHROME:

			System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
			capabilites = DesiredCapabilities.chrome();
			driver = new ChromeDriver(capabilites);
			break;

		default:
			throw new SkipException(m_browser + ":: Browser Not Implemented!!");
		}

		return driver;
	}

	/**
	 * Before Test executes before executing every Tests (contains one or more
	 * Test Methods)
	 * 
	 * @param browser
	 * @param url
	 */
	@Parameters({ "browser", "url" })
	@BeforeMethod(alwaysRun = true)
	public void setup(String browser, String url, Method method) {

		System.out.println("Enter @BeforeTest method");

		getDriverForThread().manage().window().maximize();
		getDriverForThread().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("Connection established successfully with the browser!!");

		System.out.println("Exit @BeforeTest method");

		System.out.println("\n\n******START OF TEST CASE:: " + method.getName() + "******\n");

	}

	/**
	 * This method executes after every test method
	 * 
	 * @param method
	 */
	@AfterMethod(alwaysRun = true)
	public void tearDown(Method method) {

		System.out.println("\n\n******END OF TEST CASE:: " + method.getName() + "******\n");
	}

	/**
	 * This method executes After Suite and quits driver after executing all Test
	 * Methods which are part of Test Suite
	 */
	@AfterSuite(alwaysRun = true)
	public void shutDown() {

		System.out.println("Enter @AfterTest method");

		getDriverForThread().quit();

		System.out.println("Driver quit success!!");
		System.out.println("Exit @AfterTest method");
	}

	/**
	 * Creates a instance of driver corresponding to the thread id and returns
	 * the driver If a driver instance already exists for thread id then it will
	 * just return that instance
	 * 
	 * @return
	 */
	public WebDriver getDriverForThread() {
		return m_driverForThread.get();
	}

}
