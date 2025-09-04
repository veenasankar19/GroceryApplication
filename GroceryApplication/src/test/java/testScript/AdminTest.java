package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Base.TestNGBase;
import Pages.AdminPage;
import Pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminTest extends TestNGBase {
	@Test
	public void verifyAddUser() throws IOException {
//to Login to the site
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");  //Data Driven Approach to fetch data from Excel sheet. "LoginPage" is the name of sheet1
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		
		LoginPage loginpage = new LoginPage(driver); //Page Object Model where the code is taken from src/main/java in LoginPage class
		loginpage.enterUserName(usernameValue);
		loginpage.enterPassword(passwordValue);
		loginpage.clickOnSignin();
//To click on AdminUsers MoreInfo and load the second page
		AdminPage adminpage = new AdminPage(driver);
		adminpage.clickAdminMoreInfo();
		
//To generate random username, password using faker utility
		FakerUtility fakerUtility = new FakerUtility();
		String randomname=fakerUtility.createRandomUserName();
		String randompassword=fakerUtility.createRandomPassword();
		String userType=ExcelUtility.getStringData(1, 2,"HomePage"); //DDA to fetch data from "HomePage" sheet of excel
	
		adminpage.clickNewButton();
		adminpage.enterUsernameField(randomname);
		adminpage.enterPasswordField(randompassword);
		adminpage.chooseUserType(userType);
		adminpage.clickSaveButton();
	}

}
