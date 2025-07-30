package testClasses;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.UserManagementPageClass;
import utilities.ExcelReadUtility;

public class HomeTest extends BaseClass {
	LoginPageClass lp;
	HomePageClass hp;
	UserManagementPageClass um;

	@Test
	public void getHomePageHeading() throws IOException {
		lp = new LoginPageClass(driver);
		hp = lp.validLogin(ExcelReadUtility.getStringData(0, 0, "loginData"),
				ExcelReadUtility.getIntegerData(0, 1, "loginData"));
		hp.clickOnEndTourButton();
		String actualResult = hp.getLogoHeading();
		Assert.assertEquals(actualResult, ExcelReadUtility.getStringData(0, 0, "homePageData"));
	}

	@Test
	public void verify_tooltip_of_calculator_icon() throws IOException {
		lp = new LoginPageClass(driver);
		hp = lp.validLogin(ExcelReadUtility.getStringData(0, 0, "loginData"),
				ExcelReadUtility.getIntegerData(0, 1, "loginData"));
		hp.clickOnEndTourButton();

		String actualResult = hp.getToggleValueofCalculatorIcon("data-original-title");
		Assert.assertEquals(actualResult, ExcelReadUtility.getStringData(1, 0, "homePageData"));
	}
	
	
	
	@Test
	public void verifyVisibleWidgets() {
	    List<String> expectedWidgets = Arrays.asList("Total Purchase", "Total Sales", "Purchase Due", "Invoice Due");
	    List<String> actualWidgets = hp.getWidgetNames();

	    for (String expected : expectedWidgets) {
	        Assert.assertTrue(actualWidgets.contains(expected), "Missing widget: " + expected);
	    }
	}

}
