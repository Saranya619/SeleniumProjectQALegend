package testClasses;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import baseClass.BaseClass;
import pageClasses.HomePageClass;
import pageClasses.ListPurchasePageClass;
import pageClasses.LoginPageClass;
import pageClasses.UserManagementPageClass;
import utilities.ExcelReadUtility;

public class ListPurchaseTest extends BaseClass {

	HomePageClass hp;
	LoginPageClass lp;
	UserManagementPageClass um;
	ListPurchasePageClass lpurchase;

	@Test
	public void verify_list_purchase_page_navigation() throws IOException {
		lp = new LoginPageClass(driver);
		hp = lp.validLogin(ExcelReadUtility.getStringData(0, 0, "loginData"),
				ExcelReadUtility.getIntegerData(0, 1, "loginData"));
		hp.clickOnEndTourButton();
		hp.clickPurchases();
		lpurchase = hp.clicklistPurchasesMenu();
		String actualResult = lpurchase.getPurchasesPageHeading();
		Assert.assertEquals(actualResult, ExcelReadUtility.getStringData(0, 0, "listPurchaseData"));

	}
	@Test
	public void verify_purchase_status_dropdownValues() throws IOException {
		lp = new LoginPageClass(driver);
		hp = lp.validLogin(ExcelReadUtility.getStringData(0, 0, "loginData"),
				ExcelReadUtility.getIntegerData(0, 1, "loginData"));
		hp.clickOnEndTourButton();
		hp.clickPurchases();
		lpurchase = hp.clicklistPurchasesMenu();
		List<String> actualResult = lpurchase.getPurchaseStatusDropdownValues();
		List<String> expectedResult = Arrays.asList("All", "Received", "Pending", "Ordered");
		Assert.assertEquals(actualResult, expectedResult);

	}

}
