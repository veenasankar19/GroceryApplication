package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Base.TestNGBase;
import Pages.LoginPage;
import Pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends TestNGBase{
//TestCase5 to navigate to Manage News page, click on New button and perform related actions 
	@Test 
	public void verifyAddNews() throws IOException {
		String usernameValue=ExcelUtility.getStringData(6, 0, "LoginPage");  //Data Driven Approach to fetch data from Excel sheet
		String passwordValue=ExcelUtility.getStringData(6, 1, "LoginPage");
	
		LoginPage loginpage = new LoginPage(driver); //Page Object Model where the code is taken from src/main/java in LoginPage class
		loginpage.enterUserName(usernameValue);
		loginpage.enterPassword(passwordValue);
		loginpage.clickOnSignin();
	
		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		managenewspage.clickManageNewsTile();
		managenewspage.clickNewbutton();
		managenewspage.enterNewsTextbox();
		managenewspage.clickSaveButton();
	}
//TestCase6 to navigate to Manage News page, click on Search button
	@Test 
	public void verifySearchNewsSearchButton() throws IOException {
		String usernameValue=ExcelUtility.getStringData(6, 0, "LoginPage");  //Data Driven Approach to fetch data from Excel sheet
		String passwordValue=ExcelUtility.getStringData(6, 1, "LoginPage");
	
		LoginPage loginpage = new LoginPage(driver); //Page Object Model where the code is taken from src/main/java in LoginPage class
		loginpage.enterUserName(usernameValue);
		loginpage.enterPassword(passwordValue);
		loginpage.clickOnSignin();
 		
		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		managenewspage.clickManageNewsTile();
		managenewspage.clickSearchButton();
		managenewspage.enterNewsTextboxInsideSearch();
		managenewspage.clickSearchButtonRed();
	}
//TestCase7 to navigate to Manage News page, click on Reset button
		@Test 
		public void verifySearchNewsResetButton() throws IOException {
			String usernameValue=ExcelUtility.getStringData(6, 0, "LoginPage");  //Data Driven Approach to fetch data from Excel sheet
			String passwordValue=ExcelUtility.getStringData(6, 1, "LoginPage");
		
			LoginPage loginpage = new LoginPage(driver); //Page Object Model where the code is taken from src/main/java in LoginPage class
			loginpage.enterUserName(usernameValue);
			loginpage.enterPassword(passwordValue);
			loginpage.clickOnSignin();
	 		
			ManageNewsPage managenewspage = new ManageNewsPage(driver);
			managenewspage.clickManageNewsTile();
			managenewspage.clickSearchButton();
			managenewspage.enterNewsTextboxInsideSearch();
			managenewspage.clickResetButtonGrey();
		}
	
//TestCase8 to navigate to Manage News page, click on Home link	
	@Test
	public void verifyHomeLink() throws IOException {
		String usernameValue=ExcelUtility.getStringData(6, 0, "LoginPage");  //Data Driven Approach to fetch data from Excel sheet
		String passwordValue=ExcelUtility.getStringData(6, 1, "LoginPage");
	
		LoginPage loginpage = new LoginPage(driver); //Page Object Model where the code is taken from src/main/java in LoginPage class
		loginpage.enterUserName(usernameValue);
		loginpage.enterPassword(passwordValue);
		loginpage.clickOnSignin();
 		
		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		managenewspage.clickManageNewsTile();
		managenewspage.clickHomeLink();
	}

}
