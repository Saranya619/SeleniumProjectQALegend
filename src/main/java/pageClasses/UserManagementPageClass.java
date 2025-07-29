package pageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtilities;
import utilities.WebTableUtility;

public class UserManagementPageClass {
	WebDriver driver;
	WaitUtilities wait = new WaitUtilities();
	GeneralUtilities gl = new GeneralUtilities();

	public UserManagementPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[contains(., 'Users')]")
	WebElement usersHeading;

	@FindBy(xpath = "//div//a[@href=\"https://qalegend.com/billing/public/users/create\"]")
	WebElement addButton;

	@FindBy(xpath = "//h1[text()='Add user']")
	WebElement addUserHeading;

	@FindBy(name = "first_name")
	WebElement firstName;

	@FindBy(name = "email")
	WebElement email;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "confirm_password")
	WebElement confirmPassword;

	@FindBy(id = "submit_user_button")
	WebElement saveButton;

	@FindBy(xpath = "//input[@type='search']")
	WebElement searchbar;
	
	@FindBy(xpath = "//a[contains(@class,'btn buttons-collection')]")
	WebElement actionButton;
	
	@FindBy(xpath = "//ul[@role='menu']")
	WebElement actionOptions;

	public String getUsersPageHeading() {
		wait.waitForElementToBeClickableByWebElement_Utility(driver, usersHeading, 5);
		return usersHeading.getText();
	}

	public UserManagementPageClass clickAddButton() {
		wait.waitForElementTobeVisible(driver, addButton, 10);
		addButton.click();
		return this;
	}

	public UserManagementPageClass addUser(String fnmae, String mail_id, String pwd, String cpwd) {
		wait.waitForElementTobeVisible(driver, addUserHeading, 5);
		firstName.sendKeys(fnmae);
		email.sendKeys(mail_id);
		password.sendKeys(pwd);
		confirmPassword.sendKeys(cpwd);
		saveButton.click();
		return this;

	}

	public boolean searchAnUser(String searchParameter) {
		String tableXpath = "//table[@id='users_table']/tbody/tr";
		searchbar.sendKeys(searchParameter);
		boolean searchResult = WebTableUtility.isTextPresentInTable(driver, tableXpath, searchParameter);
		return searchResult;
	}

	public boolean isUserPresent(String searchParameter) {
		System.out.println("invoked here");
		String tableXpath = "//table[@id='users_table']/tbody/tr";
		boolean searchResult = WebTableUtility.isTextPresentInPaginatedTable(driver, tableXpath, searchParameter,
				By.xpath("//a[(text())='Next']"));
		return searchResult;
	}
	
	public UserManagementPageClass clickActionHamburgerMenu() {
		actionButton.click();
		return this;
	}
	
	public List<String> isActionOptionsPresent() {
		  return gl.getAllOptions_From_CustomDropdown(actionOptions);
	}
	
	
}
