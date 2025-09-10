package testScript;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.TestNGBase; //imported TestNGBase because it is created in a different package
import Pages.LoginPage;
import constant.Constants;
import constant.Messages;
import utilities.ExcelUtility;  //updated on moving "ExcelUtility" class from package "testScript" in src test to "utilities" in src main

public class LoginTest extends TestNGBase {
//Give username and password as admin -- Valid Credentials
	@Test (priority = 1,description = "Login with valid credentials of user admin")
	public void verifyLoginWithValidCredentials() throws IOException {
		String usernameValue=ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);  //Data Driven Approach to fetch data from Excel sheet
		String passwordValue=ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
		
		LoginPage loginpage = new LoginPage(driver); //Page Object Model where the code is taken from src/main/java in LoginPage class
		loginpage.enterUserName(usernameValue);
		loginpage.enterPassword(passwordValue);
		loginpage.clickOnSignin();
//For assertion when the login action fails		
		String actual = driver.getCurrentUrl();
		String expected = "https://groceryapp.uniqassosiates.com/admin";
		Assert.assertEquals(actual, expected, Messages.VALIDCREDENTIALSERROR); //Taken from Messages class of Constant package
	}
//Give valid username and invalid password -- Invalid Credentials	
	@Test(priority = 2,description = "Login with valid username and invalid password")
	public void verifyLoginWithInvalidUsername() throws IOException {
		String usernameValue=ExcelUtility.getStringData(2, 0, Constants.LOGINSHEET);  //Data Driven Approach to fetch data from Excel sheet
		String passwordValue=ExcelUtility.getStringData(2, 1, Constants.LOGINSHEET);
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernameValue);
		loginpage.enterPassword(passwordValue);
		loginpage.clickOnSignin();
//Below Assertion can be done same as above also. With expected = "https://groceryapp.uniqassosiates.com/admin/login"
		boolean isloginalertDisplayed = loginpage.isLoginAlertDisplayed();
		Assert.assertTrue(isloginalertDisplayed, Messages.INVALIDPASSWORDERROR);
	}
//Give invalid username and valid password - Invalid Credentials
	@Test (priority = 3,description="Login with invalid username and valid password")
	public void verifyLoginWithInvalidPassword() throws IOException {
		String usernameValue=ExcelUtility.getStringData(3, 0, Constants.LOGINSHEET);  //Data Driven Approach to fetch data from Excel sheet
		String passwordValue=ExcelUtility.getStringData(3, 1, Constants.LOGINSHEET);
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernameValue);
		loginpage.enterPassword(passwordValue);
		loginpage.clickOnSignin();
		boolean isloginalertDisplayed = loginpage.isLoginAlertDisplayed();
		Assert.assertTrue(isloginalertDisplayed, Messages.INVALIDUSERNAMEERROR);		
	}
//Give invalid username and invalid password - Invalid Credentials
	@Test  (priority = 4,description="Login with invalid username and invalid password")
	public void verifyLoginWithInvalidUsernamePassword() throws IOException {
		String usernameValue=ExcelUtility.getStringData(4, 0, Constants.LOGINSHEET);  //Data Driven Approach to fetch data from Excel sheet
		String passwordValue=ExcelUtility.getStringData(4, 1, Constants.LOGINSHEET);
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernameValue);
		loginpage.enterPassword(passwordValue);
		loginpage.clickOnSignin();
		boolean isloginalertDisplayed = loginpage.isLoginAlertDisplayed();
		Assert.assertTrue(isloginalertDisplayed, Messages.INVALIDCREDENTIALSERROR);
	}
	
}
