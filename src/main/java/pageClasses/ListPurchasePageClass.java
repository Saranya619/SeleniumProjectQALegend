package pageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class ListPurchasePageClass {
	WebDriver driver;
	WaitUtilities wait = new WaitUtilities();
	GeneralUtilities gl = new GeneralUtilities();

	public ListPurchasePageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(tagName = "h1")
	WebElement purchaseHeading;
	
	@FindBy(id="select2-purchase_list_filter_status-container")
	WebElement purchaseStatus;

	@FindBy(id = "select2-purchase_list_filter_status-results")
	List<WebElement> purchaseStatusDropdown;

	public String getPurchasesPageHeading() {
		wait.waitForElementToBeClickableByWebElement_Utility(driver, purchaseHeading, 5);
		return purchaseHeading.getText();
	}

	public List<String>  getPurchaseStatusDropdownValues() {
		purchaseStatus.click();
		return gl.getAllOptions_From_CustomDropdown(purchaseStatusDropdown);
	}

}
