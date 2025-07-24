package baseClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;

public class LoginTest extends BaseClass {
	LoginPageClass lp;
	HomePageClass hp;

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
}
