package utilities;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTableUtility {

	/**
	 * Searches for specific text in a web table.
	 * 
	 * driver WebDriver instance tableXpath XPath for the table rows (e.g.,
	 * "//table/tbody/tr") searchText Text to search for in the table rows true if
	 * the text is found, false otherwise
	 */
	public static boolean isTextPresentInTable(WebDriver driver, String tableXpath, String searchText) {
		List<WebElement> rows = driver.findElements(By.xpath(tableXpath));

		for (WebElement row : rows) {
			String rowText = row.getText();
			if (rowText.contains(searchText)) {
				System.out.println("Text found in row: " + rowText);
				return true; // Text found
			}
		}
		return false; // Text not found
	}

	// paginated table
	public static boolean isTextPresentInPaginatedTable(WebDriver driver, String tableXpath, String searchText,
			By nextButtonLocator) {
		int pageNumber = 1;
		while (true) {
			List<WebElement> rows = driver.findElements(By.xpath(tableXpath));
			for (WebElement row : rows) {
				String rowText = row.getText();
				if (rowText.contains(searchText)) {
					System.out.println("Text found on page" + pageNumber + "in row" + rowText);
					return true;
				}
			}
			// Try to click "Next" if it is enabled
			try {
				WebElement nextButton = driver.findElement(nextButtonLocator);
				if (nextButton.isEnabled() && nextButton.isDisplayed()) {
					nextButton.click();
					Thread.sleep(2000);// small wait for the next page to load
					pageNumber++;
				} else {
					break; // No more pages
				}
			} catch (NoSuchElementException e) {
				e.getMessage();
				break; // end of pages
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		System.out.println("Text not found in any page. ");
		return false;

	}

}