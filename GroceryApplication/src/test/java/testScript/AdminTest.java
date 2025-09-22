package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNGBase;
import constant.Constants;
import constant.Messages;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminTest extends TestNGBase {
HomePage homepage;
AdminPage adminpage;
	@Test (description="Add User Functionality")
	public void verifyAddUser() throws IOException {
//to Login to the site
		String usernameValue=ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);  //Data Driven Approach to fetch data from Excel sheet. "LoginPage" is the name of sheet1
		String passwordValue=ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
		
		LoginPage loginpage = new LoginPage(driver); //Page Object Model where the code is taken from src/main/java in LoginPage class
		loginpage.enterUserName(usernameValue).enterPassword(passwordValue);
		homepage = loginpage.clickOnSignin();
//To click on AdminUsers MoreInfo and load the second page
		
		adminpage = homepage.clickAdminMoreInfo(); //this method is moved to homepage now. It will redirect to adminpage on clicking.
		
//To generate random username, password using faker utility
		FakerUtility fakerUtility = new FakerUtility();
		String randomname=fakerUtility.createRandomUserName();
		String randompassword=fakerUtility.createRandomPassword();
		String userType=ExcelUtility.getStringData(1, 2, Constants.HOMESHEET); //DDA to fetch data from "HomePage" sheet of excel
	
		adminpage.clickNewButton().enterUsernameField(randomname).enterPasswordField(randompassword).chooseUserType(userType).clickSaveButton(); //Chaining

		boolean isalertDisplayed = adminpage.isAlertDisplayed(); //Always start the boolean variable name with "is". Here it is "isalertDisplayed"
		Assert.assertTrue(isalertDisplayed, Messages.ADDUSERFUNCTIONALITYERROR); //this message is displayed when testcase fails. Message is added in Messages class.
	}

}
