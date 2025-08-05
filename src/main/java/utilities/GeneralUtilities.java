package utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {

	public String get_attribute_of_element(WebElement element, String attribute) {
		String attributeName = element.getAttribute(attribute);
		return attributeName;
	}

	// Element displayed
	public boolean is_element_displayed(WebElement element) {
		boolean statusOfWebElement = element.isDisplayed();
		return statusOfWebElement;
	}

	// Element enabled
	public boolean is_element_enabled(WebElement element) {
		boolean statusOfWebElement = element.isEnabled();
		return statusOfWebElement;
	}

	// Element selected
	public boolean is_element_selected(WebElement element) {
		boolean statusOfWebElement = element.isSelected();
		return statusOfWebElement;
	}

	public boolean is_multiple_dropdown(WebElement dropdownElement) {
		Select sel = new Select(dropdownElement);
		boolean status = sel.isMultiple();
		return status;
	}

	// Select DropDown - index
	public void select_Option_From_Dropdown_Using_Index(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	// select by value
	public void select_Option_From_Dropdown_Using_Value(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	// select by visibleText
	public void select_Option_From_Dropdown_Using_VisibleText(WebElement element, String Text) {
		Select select = new Select(element);
		select.selectByVisibleText(Text);
	}

	// Deselect all
	public void deselect_all_options(WebElement element) {
		Select sel = new Select(element);
		sel.deselectAll();
	}

	// Deselect by index
	public void deselect_by_index(WebElement element, int index) {
		Select sel = new Select(element);
		sel.deselectByIndex(index);
	}

	// Get All options from dropdown
	public List<String> getAllOptions_From_Dropdown(WebElement element) {
		Select select = new Select(element);
		return select.getOptions().stream().map(WebElement::getText).collect(Collectors.toList());

	}

	// Get All options from the list
	public List<String> getAllOptions_From_CustomDropdown(List<WebElement> containerElements) {
		List<String> allOptions = new ArrayList<>();

		for (WebElement container : containerElements) {
			List<WebElement> items = container.findElements(By.tagName("li"));
			for (WebElement item : items) {
				allOptions.add(item.getText().trim());
			}
		}

		return allOptions;
	}

	

	// to get the name of all values from the drop down
	public List<String> getAllSelectedOptions_From_Dropdown(WebElement element) {
		Select select = new Select(element);
		return select.getAllSelectedOptions().stream().map(WebElement::getText).collect(Collectors.toList());
	}

	// Get Text from Elements
	public List<String> getTextsFromElements(List<WebElement> elements) {
		List<String> texts = new ArrayList<String>();
		for (WebElement element : elements) {
			texts.add(element.getText().trim());
		}
		return texts;
	}

	// File upload
	public void file_Upload(WebElement element, String filePath) {
		element.sendKeys(filePath);
	}

	// Key-Press-Down
	public void keyDown_Utility(WebDriver driver, Keys key) {
		Actions actions = new Actions(driver);
		actions.keyDown(key).perform();
	}

	// Key-Press-UP
	public void keyUp_Utility(WebDriver driver, Keys key) {
		Actions actions = new Actions(driver);
		actions.keyUp(key).perform();
	}

	// Drag and Drop
	public void dragAndDrop_Utility(WebDriver driver, WebElement sourceElement, WebElement destinationElement) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(sourceElement, destinationElement).perform();
	}

	// Accept an alert
	public void alert_Accept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	// Dismiss an alert
	public void alert_Dismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	// HomeWork - Get Text of alert message
	public String get_Text_of_alert_Message(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	// Input Alert
	public void promptAlert_Input_Text(WebDriver driver, String text) {
		driver.switchTo().alert().sendKeys(text);
	}

	// Switch Frame - Name/ID
	public void switchToFrameByNameOrID(WebDriver driver, String NameOrID) {
		driver.switchTo().frame(NameOrID);
	}

	// Switch Frame - WebElement
	public void switchToFrameByWebElement(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	// Add sleep
	public void addSleep_Utility(long timeOut) throws InterruptedException {
		Thread.sleep(timeOut);
	}

}
