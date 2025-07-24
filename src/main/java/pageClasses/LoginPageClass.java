package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class LoginPageClass {
	WebDriver driver;
	GeneralUtilities gl  = new GeneralUtilities();

	public LoginPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//*//strong[contains(text(),\"These credentials\")]")
	WebElement invalidErrorMsg;
	
	@FindBy(name="remember")
	WebElement rememberMeCheckbox;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/billing/public/password/reset']")
	WebElement forgotPasswordBtn;
	
	public HomePageClass validLogin(String uname,String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePageClass(driver);
	}
	
	public LoginPageClass invalidLogin(String uname,String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginBtn.click();
		return LoginPageClass.this;
		//return this;
	}
	
	public String getTextOfInvalidErrorMsg() {
		return invalidErrorMsg.getText();
	}
	
	public String getPlaceholderAttributeOfUsername(String attribute) {
		String attributeValue  = gl.get_attribute_of_element(username, attribute);
		return attributeValue;
	}
	
	public String getApplicationURL() {
		return driver.getCurrentUrl();
	}
	
	public boolean isRememberMeChecked() {
		return gl.is_element_selected(rememberMeCheckbox);
	}
	
	public ResetPasswordPageClass clickForgotPasswordBtn() {
		forgotPasswordBtn.click();
		return new ResetPasswordPageClass(driver);
	}
	
	
}
