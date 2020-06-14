package OHRM_LoginTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import OHRM_BaseTest.BaseTest;
import OHRM_Login.LoginPage;

public class LoginTest extends BaseTest{
	
	LoginPage loginpage=null;
	@Test()
	public void login() throws IOException
	{
		loginpage=PageFactory.initElements(driver, LoginPage.class);
		
		FileInputStream file=new FileInputStream("C:/Users/Dell/Desktop/POM/src/ApplicationTestDataFiles/OrangeHRM_Login_TestData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("sheet1");
		int rowCount=sheet.getLastRowNum();
		
		for(int i=1;i<=rowCount;i++)
		{
			Row row=sheet.getRow(i);
			loginpage.login(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue());
			driver.navigate().back();
		}
		FileOutputStream file1=new FileOutputStream("C:/Users/Dell/Desktop/POM/src/ApplicationTestdataResult/OrangeHRM_Login_TestDataResult.xlsx");
		workbook.write(file1);
		
	}
	


}
