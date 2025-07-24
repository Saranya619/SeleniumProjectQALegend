package testClasses;

import org.testng.Assert; 
import org.testng.annotations.Test;
import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.ResetPasswordPageClass;

public class LoginTest extends BaseClass {
	LoginPageClass lp;
	HomePageClass hp;
	ResetPasswordPageClass rp;

	@Test
	public void verify_valid_login() {
		lp = new LoginPageClass(driver);
		hp = lp.validLogin("admin", "123456");
		hp.clickOnEndTourButton();
		String actualResult = hp.getTextOfWelcomeHeading();
		Assert.assertTrue(actualResult.contains("Welcome admin,"));
	}

	@Test
	public void verify_invalid_login() {
		lp = new LoginPageClass(driver);
		lp = lp.invalidLogin("admin", "password");
		String actualResult = lp.getTextOfInvalidErrorMsg();
		Assert.assertTrue(actualResult.contains("These credentials do not match our records."));
	}
	
	@Test
	public void verify_UserNameTextBox_Showing_Hint_or_not() {
		lp = new LoginPageClass(driver);
		boolean actualResult = lp.getPlaceholderAttributeOfUsername("placeholder").isEmpty();
		Assert.assertEquals(actualResult,true);
	
	}
	
	@Test
	public void  verify_Correct_Application_Is_Launching_While_Hitting_The_URL() {
		lp = new LoginPageClass(driver);
		String actualResult = lp.getApplicationURL();
		Assert.assertEquals(actualResult, "https://qalegend.com/billing/public/login");
	}
	
	@Test
	public  void verify_the_RememberMe_checkbox_is_unchecked_by_default () {
		lp =new LoginPageClass(driver);
		boolean actualResult = lp.isRememberMeChecked();
		Assert.assertFalse(actualResult);
	}
	
	@Test
	public void verify_the_reset_password_page_is_redirecting_while_clicking_on_Forgot_your_password() {
		lp =new LoginPageClass(driver);
		lp.clickForgotPasswordBtn();
		rp = new ResetPasswordPageClass(driver);
		String actualResult = rp.getResetPasswordPageURL();
		Assert.assertEquals(actualResult, "https://qalegend.com/billing/public/password/reset");
		String actualHeading = rp.getTextOfResetPasswordHeading();
		Assert.assertEquals(actualHeading, "Reset Password");
	}
	
	
	
}
