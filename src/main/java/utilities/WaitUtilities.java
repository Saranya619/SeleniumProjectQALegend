package utilities;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilities {
	
	

	//Element clickable - Xpath
	public void waitForElementToBeClickableByXpathLocator_Utility(WebDriver driver, String locatorValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
	}

	//Element clickable - ID
	public void waitForElementToBeClickableByIDLocator_Utility(WebDriver driver, String locatorValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorValue)));
	}

	//Element clickable - WebElement
	public void waitForElementToBeClickableByWebElement_Utility(WebDriver driver, WebElement element, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(element)); 

	}

	//Element is visible
	public void waitForElementTobeVisible(WebDriver driver, WebElement element, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	//Fluent wait
	public void fluentWaitForElementtoBeClickableByXpathLocator_Utility(WebDriver driver, String locatorValue,
			int totalTimeOut, int pollingTimeOut) {
		FluentWait<WebDriver> wait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(totalTimeOut))
				.pollingEvery(Duration.ofSeconds(pollingTimeOut))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
	}
	
	//visibilityOfAllElementsLocated
	public void waitForVisibilityOfAllElements(WebDriver driver, int timeOut,List<WebElement> elements) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
	    wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	
	//presenceOfElementLocated
	public void waitForPresenceOfElementLocated(WebDriver driver,String locatorValue,int timeOut) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorValue)));
	}
	
	//isAlertPresent
	public void isAlertPresent(WebDriver driver,int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.alertIsPresent());
	}

}
