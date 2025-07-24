package baseClass;

import org.testng.annotations.BeforeMethod; 

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	public WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://qalegend.com/billing/public/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
