package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constants;

public class ExcelReadUtility {
	static FileInputStream file;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	//To read String data from the excel
	public static String getStringData(int row, int col, String sheetName) throws IOException {
		file = new FileInputStream(Constants.excelFilePath);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
		XSSFRow r = sheet.getRow(row);
		XSSFCell c = r.getCell(col);
		return c.getStringCellValue();
	}

	//To read String data from the excel
	public static String getIntegerData(int row, int col, String sheetName) throws IOException {
		file = new FileInputStream(Constants.excelFilePath);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
		XSSFRow r = sheet.getRow(row);
		XSSFCell c = r.getCell(col);
		int cellValue = (int) (c.getNumericCellValue());
		return String.valueOf(cellValue);
	}
}
