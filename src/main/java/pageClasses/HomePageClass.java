package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class HomePageClass {
	WebDriver driver;
	WaitUtilities wait = new WaitUtilities();
	GeneralUtilities gl = new GeneralUtilities();

	public HomePageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='End tour']")
	WebElement endTourBtn;

	@FindBy(xpath = "//h1[contains(text(),'Welcome')]")
	WebElement welcomeHeading;

	@FindBy(id = "btnCalculator")
	WebElement calculatorIcon;

	public void clickOnEndTourButton() {
		try {
			wait.waitForElementTobeVisible(driver, endTourBtn, 5);
			if (endTourBtn.isDisplayed()) {
				endTourBtn.click();
				System.out.println("Clicked on End Tour Button");
			} else {
				System.out.println("End Tour Button is not visible");
			}
		} catch (Exception e) {
			System.out.println("Exception Occured!!!!!");
			// e.printStackTrace();
			e.getMessage();
		}

	}

	public String getTextOfWelcomeHeading() {
		wait.waitForElementTobeVisible(driver, welcomeHeading, 5);
		return welcomeHeading.getText();

	}

	public String getToggleValueofCalculatorIcon(String attribute) {
		return gl.get_attribute_of_element(calculatorIcon, attribute);
	}
}
