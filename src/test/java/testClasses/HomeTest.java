package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.UserManagementPageClass;

public class HomeTest extends BaseClass {
	LoginPageClass lp;
	HomePageClass hp;
	UserManagementPageClass um;

	@Test
	public void verify_tooltip_of_calculator_icon() {
		lp = new LoginPageClass(driver);
		hp = lp.validLogin("admin", "123456");
		hp.clickOnEndTourButton();

		String actualResult = hp.getToggleValueofCalculatorIcon("data-original-title");
		Assert.assertEquals(actualResult, "Calculator");
	}
	

	

}

//UserManagementpage -> test case verify to add a new user

//homepage -> click usermanagement and users 

//verify table contains added value using contains