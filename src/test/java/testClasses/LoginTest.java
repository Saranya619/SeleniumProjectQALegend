package testClasses;

import java.io.IOException;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import dataProvider.DataProviderClass;
import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.ResetPasswordPageClass;
import retry.RetryAnalyser;
import utilities.ExcelReadUtility;

public class LoginTest extends BaseClass {
	LoginPageClass lp;
	HomePageClass hp;
	ResetPasswordPageClass rp;
	

	@Test(dataProviderClass = DataProviderClass.class,dataProvider = "successfulLogin",retryAnalyzer = RetryAnalyser.class)
	public void verify_valid_login(String uname, String pass) throws IOException {
		lp = new LoginPageClass(driver);
		//hp = lp.validLogin(ExcelReadUtility.getStringData(0, 0, "loginData"), ExcelReadUtility.getIntegerData(0, 1, "loginData"));
		hp = lp.validLogin(uname, pass);
		hp.clickOnEndTourButton();
		String actualResult = hp.getTextOfWelcomeHeading();
		AssertJUnit.assertTrue(actualResult.contains(ExcelReadUtility.getStringData(5, 1, "loginData")));
	}

	@Test(dataProviderClass = DataProviderClass.class,dataProvider = "unsuccessfulLogin")
	public void verify_invalid_login(String uname, String pass) throws IOException {
		lp = new LoginPageClass(driver);
		lp = lp.invalidLogin(uname, pass);
		String actualResult = lp.getTextOfInvalidErrorMsg();
		AssertJUnit.assertTrue(actualResult.contains("These credentials do not match our records."));
	}
	
	@Test(groups = {"group1"})
	public void verify_UserNameTextBox_Showing_Hint_or_not() {
		lp = new LoginPageClass(driver);
		boolean actualResult = lp.getPlaceholderAttributeOfUsername("placeholder").isEmpty();
		AssertJUnit.assertEquals(actualResult,true);
	
	}
	
	@Test(groups = {"group1"})
	public void  verify_Correct_Application_Is_Launching_While_Hitting_The_URL() {
		lp = new LoginPageClass(driver);
		String actualResult = lp.getApplicationURL();
		AssertJUnit.assertEquals(actualResult, "https://qalegend.com/billing/public/login");
	}
	
	@Test(groups = {"group2"})
	public  void verify_the_RememberMe_checkbox_is_unchecked_by_default () {
		lp =new LoginPageClass(driver);
		boolean actualResult = lp.isRememberMeChecked();
		AssertJUnit.assertFalse(actualResult);
	}
	
	@Test(groups = {"group2"})
	public void verify_the_reset_password_page_is_redirecting_while_clicking_on_Forgot_your_password() {
		lp =new LoginPageClass(driver);
		rp = lp.clickForgotPasswordBtn();
		String actualResult = rp.getResetPasswordPageURL();
		AssertJUnit.assertEquals(actualResult, "https://qalegend.com/billing/public/password/reset");
		String actualHeading = rp.getTextOfResetPasswordHeading();
		AssertJUnit.assertEquals(actualHeading, "Reset Password");
	}
	

}
