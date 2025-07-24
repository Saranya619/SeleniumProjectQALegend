package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPageClass {
	
	WebDriver driver;
	
	public ResetPasswordPageClass(WebDriver driver){
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[text()='Reset Password']")
	WebElement resetPasswordHeading;
	
	public String getResetPasswordPageURL() {
		return driver.getCurrentUrl();
	}
	
	public String getTextOfResetPasswordHeading() {
		return resetPasswordHeading.getText();
	}
}
