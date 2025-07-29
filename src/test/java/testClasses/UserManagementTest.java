package testClasses;

import java.io.IOException;

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
		hp = lp.validLogin(ExcelReadUtility.getStringData(0, 0, "loginData"), ExcelReadUtility.getIntegerData(0, 1, "loginData"));
		hp.clickOnEndTourButton();

		hp.clickUserManagementMenu();
		um = hp.clickUserMenu();
		String actualResult = um.getUsersPageHeading();
		Assert.assertEquals(actualResult, "Users Manage users");
	}
	
	@Test
	public void verify_add_and_search_user() throws IOException{
		lp = new LoginPageClass(driver);
		hp = lp.validLogin(ExcelReadUtility.getStringData(0, 0, "loginData"), ExcelReadUtility.getIntegerData(0, 1, "loginData"));
		hp.clickOnEndTourButton();

		hp = hp.clickUserManagementMenu();
		um = hp.clickUserMenu();
		
		um = um.clickAddButton();
		um.addUser("Leya", "leyaninnan@gmail.com", "leya231", "leya231");
		boolean searchStatus = um.searchAnUser("Leya");
		Assert.assertEquals(searchStatus, true);
		
	}

	@Test
	public void verify_add_and_search_from_table() throws IOException {
		lp = new LoginPageClass(driver);
		hp = lp.validLogin(ExcelReadUtility.getStringData(0, 0, "loginData"), ExcelReadUtility.getIntegerData(0, 1, "loginData"));
		hp.clickOnEndTourButton();

		hp = hp.clickUserManagementMenu();
		um = hp.clickUserMenu();
		
		um = um.clickAddButton();
		um.addUser("Darwin", "darwin2011@gmail.com", "sara123", "sara123");
		
		String expectedResult= "darwin2011@gmail.com";
		boolean actualResult = um.isUserPresent(expectedResult);
		System.out.println("Expected EmailID:"+expectedResult +"ActualEmail:"+actualResult);
		Assert.assertTrue(actualResult,"****User not found in the table**!!!!");
	}

}
