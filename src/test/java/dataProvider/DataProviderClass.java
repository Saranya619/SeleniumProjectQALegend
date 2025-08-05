package dataProvider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import utilities.ExcelReadUtility;

public class DataProviderClass {

	@DataProvider(name = "unsuccessfulLogin")
	public Object[][] dp() throws IOException {
		return new Object[][] {
				new Object[] { ExcelReadUtility.getStringData(1, 0, "loginData"),
						ExcelReadUtility.getIntegerData(1, 1, "loginData") },
				new Object[] { ExcelReadUtility.getStringData(2, 0, "loginData"),
						ExcelReadUtility.getIntegerData(2, 1, "loginData") },
				new Object[] { ExcelReadUtility.getStringData(3, 0, "loginData"),
						ExcelReadUtility.getIntegerData(3, 1, "loginData") } };
	}

	@DataProvider(name = "successfulLogin")
	public Object[][] dp1() throws IOException {
		return new Object[][] { new Object[] { ExcelReadUtility.getStringData(0, 0, "loginData"),
				ExcelReadUtility.getIntegerData(0, 1, "loginData") }, };
	}
}
