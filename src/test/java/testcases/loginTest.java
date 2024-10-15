package testcases;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import base.Base;
import utilities.Data;
import utilities.ExcelRead;

public class loginTest extends Base {
	WebDriver driver;
	private static Logger log=LogManager.getLogger(loginTest.class.getName());
	
	@Test(dataProvider="getData")
	public void navigation(String username,String password) throws IOException
	{
	
		try{
		driver=initializeeDriver();
		driver.get(this.getUrl());		
		log.info("URl launched");			
		LoginPage l1=new LoginPage(driver);
		l1.loginInput().sendKeys(username);
		log.info("Username entered");
		l1.loginPassword().sendKeys(password);
		l1.loginBtn().click();
		//failing the test case
		Assert.assertEquals(driver.getTitle(),"Login | Salesforce");
		//Assert.assertTrue(true);
		}
		catch(Exception ex)
		{
			log.fatal(ex);	
		}	
		//asert to compare		
	}
	@DataProvider
	public Object[][] getData() throws SQLException, IOException
	{
		ExcelRead excelRead=new ExcelRead();
		ArrayList<Data>exelData=excelRead.getData();
		//DbConnect conn=new DbConnect();
		//ArrayList<String>dbdata=conn.dbconnection();
		Object[][] data=new Object[3][2];
		data[0][0]=exelData.get(0).getUsername();
		data[0][1]=exelData.get(0).getPassword();
		data[1][0]=exelData.get(1).getUsername();
		data[1][1]=exelData.get(1).getPassword();
		data[2][0]=exelData.get(2).getUsername();
		data[2][1]=exelData.get(2).getPassword();
		return data;
	}



}
