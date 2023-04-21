package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import commonFunctions.AddEmpPage;
import config.AppUtilPom;
import utilities.ExcelFileUtil;

public class TestScript extends AppUtilPom{
String inputpath ="D:\\Mrng11oclockBatch\\DDT_FrameWork\\FileInput\\Employee.xlsx";
String outputpath ="D:\\Mrng11oclockBatch\\DDT_FrameWork\\FileOutput\\EmpResults.xlsx";

	@Test
	public void startTest()throws Throwable
	{
		AddEmpPage emp =PageFactory.initElements(driver, AddEmpPage.class);
		//create object  for Excelfile util
		ExcelFileUtil xl = new ExcelFileUtil(inputpath);
		//count no of rows in EmpData Sheet
		int rc =xl.rowCount("EmpData");
		Reporter.log("No of rows are::"+rc,true);
		for(int i=1;i<=rc;i++)
		{
			String FirstName =xl.getCellData("EmpData", i, 0);
			String MiddleName =xl.getCellData("EmpData", i, 1);
			String Lastname =xl.getCellData("EmpData", i, 2);
		boolean res =emp.verify_Emp(FirstName, MiddleName, Lastname);
		if(res)
		{
			//write as pass into status cell
			xl.setCelldata("EmpData", i, 3, "Pass", outputpath);
		}
		else
		{
			xl.setCelldata("EmpData", i, 3, "Fail", outputpath);
		}
			
		}
		
	}

}
