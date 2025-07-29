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

public class UserManagementTest extends BaseClass {

	HomePageClass hp;
	LoginPageClass lp;
	UserManagementPageClass um;

	@Test
	public void verify_user_management_menu_redirection() throws IOException {
		lp = new LoginPageClass(driver);
		hp = lp.validLogin(ExcelReadUtility.getStringData(0, 0, "loginData"),
				ExcelReadUtility.getIntegerData(0, 1, "loginData"));
		hp.clickOnEndTourButton();

		hp.clickUserManagementMenu();
		um = hp.clickUserMenu();
		String actualResult = um.getUsersPageHeading();
		Assert.assertEquals(actualResult, "Users Manage users");
	}

	@Test
	public void verify_add_and_search_user() throws IOException {
		lp = new LoginPageClass(driver);
		hp = lp.validLogin(ExcelReadUtility.getStringData(0, 0, "loginData"),
				ExcelReadUtility.getIntegerData(0, 1, "loginData"));
		hp.clickOnEndTourButton();

		hp = hp.clickUserManagementMenu();
		um = hp.clickUserMenu();

		um = um.clickAddButton();
		um.addUser("Diya", "Diyaninnan+1@gmail.com", "diya231", "diya231");
		boolean searchStatus = um.searchAnUser("Diya");
		Assert.assertEquals(searchStatus, true, "User not found!!!!");
	}

	@Test
	public void verify_add_and_search_from_table() throws IOException {
		lp = new LoginPageClass(driver);
		hp = lp.validLogin(ExcelReadUtility.getStringData(0, 0, "loginData"),
				ExcelReadUtility.getIntegerData(0, 1, "loginData"));
		hp.clickOnEndTourButton();

		hp = hp.clickUserManagementMenu();
		um = hp.clickUserMenu();

		um = um.clickAddButton();
		um.addUser("Darwin", "darwin2011@gmail.com", "sara123", "sara123");

		String expectedResult = "darwin2011@gmail.com";
		boolean actualResult = um.isUserPresent(expectedResult);
		System.out.println("Expected EmailID:" + expectedResult + "ActualEmail:" + actualResult);
		Assert.assertTrue(actualResult, "****User not found in the table**!!!!");
	}

	@Test
	public void verify_the_options_inside_action_button() throws IOException {
		lp = new LoginPageClass(driver);
		hp = lp.validLogin(ExcelReadUtility.getStringData(0, 0, "loginData"),
				ExcelReadUtility.getIntegerData(0, 1, "loginData"));
		hp.clickOnEndTourButton();
		hp = hp.clickUserManagementMenu();
		um = hp.clickUserMenu();
		um.clickActionHamburgerMenu();
		List<String> expectedOptions = Arrays.asList("Copy", "Export to CSV", "Export to Excel", "Print",
				"Column visibility", "Export to PDF");
		List<String> actualOptions =  um.isActionOptionsPresent();
		Assert.assertEquals(actualOptions, expectedOptions);
	}

}
