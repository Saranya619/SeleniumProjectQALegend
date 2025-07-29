package baseClass;

import java.io.FileInputStream; 
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import constants.Constants;

public class BaseClass {

	public WebDriver driver;

	public static Properties prop;

	public static void readProperty() throws IOException {
		prop = new Properties();

		// To run in all user's system
		FileInputStream file = new FileInputStream(Constants.filepath);
		prop.load(file);
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		readProperty();
		driver = new ChromeDriver();
		driver.get(prop.getProperty("baseURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.implicitWaitTimeout));
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
