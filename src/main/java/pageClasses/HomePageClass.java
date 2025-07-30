package pageClasses;

import java.util.ArrayList;
import java.util.List;

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
	
	@FindBy(xpath = "//span[text()='User Management']")
	WebElement userManagementMenu;
	
	@FindBy(xpath = "//a[@href='https://qalegend.com/billing/public/users']")
	WebElement userMenu;
	
	@FindBy(xpath = "//span[text()='Purchases']")
	WebElement purchaseMenu;
	
	@FindBy(xpath = "//a[@href='https://qalegend.com/billing/public/purchases']")
	WebElement listPurchasesMenu;
	
	@FindBy(xpath = "//span[text()='Maxfest Enterprises PVT LTD,Kochi']")
	WebElement logoHeading;
	
	@FindBy(xpath  = "//span[text()='Total purchase']")
	WebElement totalPurchaseinfoWidget;
	
	@FindBy(xpath  = "//span[text()='Total Sales']")
	WebElement totalSalesinfoWidget;
	
	@FindBy(xpath  = "//span[text()='Purchase due']")
	WebElement purchaseDueinfoWidget;
	
	@FindBy(xpath  = "//span[text()='Invoice due']")
	WebElement invoiceDueinfoWidget;

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
	
	public String getLogoHeading() {
		return logoHeading.getText();
	}

	public String getTextOfWelcomeHeading() {
		wait.waitForElementTobeVisible(driver, welcomeHeading, 5);
		return welcomeHeading.getText();
	}

	public List<String> getWidgetNames() {
	    List<String> widgetNames = new ArrayList<>();

	    if (gl.is_element_displayed(totalPurchaseinfoWidget)) {
	        widgetNames.add("Total Purchase");
	    }
	    if (gl.is_element_displayed(totalSalesinfoWidget)) {
	        widgetNames.add("Total Sales");
	    }
	    if (gl.is_element_displayed(purchaseDueinfoWidget)) {
	        widgetNames.add("Purchase Due");
	    }
	    if (gl.is_element_displayed(invoiceDueinfoWidget)) {
	        widgetNames.add("Invoice Due");
	    }

	    return widgetNames;
	}

	
	public String getToggleValueofCalculatorIcon(String attribute) {
		return gl.get_attribute_of_element(calculatorIcon, attribute);
	}
	
	public HomePageClass clickUserManagementMenu() {
		wait.waitForElementToBeClickableByWebElement_Utility(driver, userManagementMenu, 5);
		userManagementMenu.click();
		return this;
	}
	
	public UserManagementPageClass clickUserMenu() {
		wait.waitForElementToBeClickableByWebElement_Utility(driver, userMenu, 5);
		userMenu.click();
		return new UserManagementPageClass(driver);
	}
	
	public HomePageClass clickPurchases() {
		wait.waitForElementToBeClickableByWebElement_Utility(driver, purchaseMenu, 10);
		purchaseMenu.click();
		return this;
	}
	
	public ListPurchasePageClass clicklistPurchasesMenu() {
		wait.waitForElementToBeClickableByWebElement_Utility(driver, listPurchasesMenu, 5);
		listPurchasesMenu.click();
		return new ListPurchasePageClass(driver);
	}
	
}
