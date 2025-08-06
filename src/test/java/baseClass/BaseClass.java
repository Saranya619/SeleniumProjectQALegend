package baseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import constants.Constants;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;

	public static void loadProperties() throws IOException {
		prop = new Properties();

		// To run in all user's system
		FileInputStream file = new FileInputStream(Constants.filepath);
		prop.load(file);
	}

	/**
	 * Initializes WebDriver instance based on the specified browser name.
	 * 
	 * @param browserName Name of the browser (e.g., Chrome, Firefox)
	 */

	public static void browserIntialize(String browserName) throws Exception {
		if (browserName.equalsIgnoreCase("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			driver = new ChromeDriver(options);
			// driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("Firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("-headless");
			driver = new FirefoxDriver(options);
//		driver = new FirefoxDriver();

		} else {
			throw new IllegalArgumentException("Unsupported browser!!!" + browserName);
		}
	}

	@BeforeSuite
	public void environmentVerify() {
		System.out.println("Environment setup done");
	}

	@AfterSuite
	public void environmentClose() {
		System.out.println("Environment teardown completed.");
	}

	@BeforeTest
	public void dbConnection() {
		System.out.println("Database connection established.");
	}

	@AfterTest
	public void dbterminate() {
		System.out.println("Database disconnected!");
	}

	@BeforeMethod(groups = { "tearup" })
	@Parameters("Browser")
	public void beforeMethod(String browser) throws Exception {

		loadProperties(); // call static method
		browserIntialize(browser);
		driver.get(prop.getProperty("baseURL")); // read the property file
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.implicitWaitTimeout));
		System.out.println("Navigated to: " + prop.getProperty("baseURL"));
	}

	@AfterMethod(groups = { "teardown" })
	public void afterMethod() {
		System.out.println("Closing browser.....");
		driver.quit();

	}

}
