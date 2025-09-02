package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Base.TestNGBase; //imported TestNGBase because it is created in a different package
import Pages.LoginPage;
import utilities.ExcelUtility;  //updated on moving "ExcelUtility" class from package "testScript" in src test to "utilities" in src main

public class LoginTest extends TestNGBase {
//Give username and password as admin -- Valid Credentials
	@Test (priority = 1,description = "Login with valid credentials")
	public void verifyLoginWithValidCredentials() throws IOException {
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");  //Data Driven Approach to fetch data from Excel sheet
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		
		LoginPage loginpage = new LoginPage(driver); //Page Object Model where the code is taken from src/main/java in LoginPage class
		loginpage.enterUserName(usernameValue);
		loginpage.enterPassword(passwordValue);
		loginpage.clickOnSignin();

	}
//Give invalid username and valid password -- Invalid Credentials	
	@Test(priority = 2,description = "Login with invalid username and valid password")
	public void verifyLoginWithInvalidUsername() throws IOException {
		String usernameValue=ExcelUtility.getStringData(2, 0, "LoginPage");  //Data Driven Approach to fetch data from Excel sheet
		String passwordValue=ExcelUtility.getStringData(2, 1, "LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernameValue);
		loginpage.enterPassword(passwordValue);
		loginpage.clickOnSignin();
	}
//Give valid username and invalid password - Invalid Credentials
	@Test (priority = 3,description="Login with valid username and invalid password")
	public void verifyLoginWithInvalidPassword() throws IOException {
		String usernameValue=ExcelUtility.getStringData(3, 0, "LoginPage");  //Data Driven Approach to fetch data from Excel sheet
		String passwordValue=ExcelUtility.getStringData(3, 1, "LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernameValue);
		loginpage.enterPassword(passwordValue);
		loginpage.clickOnSignin();
	}
//Give invalid username and invalid password - Invalid Credentials
	@Test  (priority = 4,description="Login with invalid username and invalid password")
	public void verifyLoginWithInvalidUsernamePassword() throws IOException {
		String usernameValue=ExcelUtility.getStringData(4, 0, "LoginPage");  //Data Driven Approach to fetch data from Excel sheet
		String passwordValue=ExcelUtility.getStringData(4, 1, "LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernameValue);
		loginpage.enterPassword(passwordValue);
		loginpage.clickOnSignin();
	}
	
}
