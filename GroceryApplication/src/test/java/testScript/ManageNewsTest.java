package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNGBase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import constant.Constants;
import constant.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends TestNGBase{
//TestCase5 to navigate to Manage News page, click on New button and perform related actions 
HomePage homepage; //HomePage declaration before testcase is done.
ManageNewsPage managenewspage;
	@Test (description = "Verify Add News")
	public void verifyAddNews() throws IOException {
		String usernameValue=ExcelUtility.getStringData(6, 0, Constants.LOGINSHEET);  //Data Driven Approach to fetch data from Excel sheet and Path&Sheetname from Constants class
		String passwordValue=ExcelUtility.getStringData(6, 1, Constants.LOGINSHEET);
	
		LoginPage loginpage = new LoginPage(driver); //Page Object Model where the code is taken from src/main/java in LoginPage class
		loginpage.enterUserName(usernameValue).enterPassword(passwordValue); //Chaining of methods 
		homepage = loginpage.clickOnSignin();
	
		managenewspage = homepage.clickManageNewsTile();
		managenewspage.clickNewbutton().enterNewsTextbox().clickSaveButton();

//Adding Assertion		
		boolean isaddnewsAlertDisplayed = managenewspage.isAddNewsAlertDisplayed();
		Assert.assertTrue(isaddnewsAlertDisplayed, Messages.ADDNEWSERROR); //Message is added in Messages class
	}
//TestCase6 to navigate to Manage News page, click on Search button
	@Test (description = "Verify Search button in Search section")
	public void verifySearchNewsSearchButton() throws IOException {
		String usernameValue=ExcelUtility.getStringData(6, 0, Constants.LOGINSHEET);  //Data Driven Approach to fetch data from Excel sheet
		String passwordValue=ExcelUtility.getStringData(6, 1, Constants.LOGINSHEET);
	
		LoginPage loginpage = new LoginPage(driver); //Page Object Model where the code is taken from src/main/java in LoginPage class
		loginpage.enterUserName(usernameValue).enterPassword(passwordValue);
		homepage= loginpage.clickOnSignin();
 		
		managenewspage = homepage.clickManageNewsTile();
		managenewspage.clickSearchButtonBlue().enterNewsTextboxInsideSearch().clickSearchButtonRed();

//Adding Assertion	
		String actual = managenewspage.isSearchedNewsFoundinTable();
		String expected = "This is an updated news";
		Assert.assertEquals(actual, expected, Messages.SEARCHINSEARCHSECTIONERROR);
		
	}
//TestCase7 to navigate to Manage News page, click on Reset button
		@Test (description = "Verify Reset button in Search section")
		public void verifySearchNewsResetButton() throws IOException {
			String usernameValue=ExcelUtility.getStringData(6, 0, Constants.LOGINSHEET);  //Data Driven Approach to fetch data from Excel sheet
			String passwordValue=ExcelUtility.getStringData(6, 1, Constants.LOGINSHEET);
		
			LoginPage loginpage = new LoginPage(driver); //Page Object Model where the code is taken from src/main/java in LoginPage class
			loginpage.enterUserName(usernameValue).enterPassword(passwordValue);
			homepage= loginpage.clickOnSignin();
	 		
			managenewspage = homepage.clickManageNewsTile();
			managenewspage.clickSearchButtonBlue().enterNewsTextboxInsideSearch().clickResetButtonGrey();
//Adding Assertion	
			boolean iseditManageNewsInformations = managenewspage.isSearchManageNews();
			Assert.assertFalse(iseditManageNewsInformations, Messages.RESETINSEARCHSECTIONERROR);
		}
	
//TestCase8 to navigate to Manage News page, click on Home link	
	@Test (description = "Verify Home link")
	public void verifyHomeLink() throws IOException {
		String usernameValue=ExcelUtility.getStringData(6, 0, Constants.LOGINSHEET);  //Data Driven Approach to fetch data from Excel sheet
		String passwordValue=ExcelUtility.getStringData(6, 1, Constants.LOGINSHEET);
	
		LoginPage loginpage = new LoginPage(driver); //Page Object Model where the code is taken from src/main/java in LoginPage class
		loginpage.enterUserName(usernameValue).enterPassword(passwordValue);
		homepage= loginpage.clickOnSignin();
 		
		managenewspage=homepage.clickManageNewsTile();
		homepage=managenewspage.clickHomeLink();
//Adding Assertion			
		String actual = driver.getCurrentUrl();
		String expected = "https://groceryapp.uniqassosiates.com/admin/home";
		Assert.assertEquals(actual, expected, Messages.HOMELINKERROR);
	}

}
