package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Base.TestNGBase;
import Pages.HomePage;
import Pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends TestNGBase {
	@Test
	public void verifyLogOut() throws IOException {
//verifyLoginWithValidCredentials method in LoginTest Class before. This is done to login to the website.
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");  //Data Driven Approach to fetch data from Excel sheet
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);  //Page Object Model approach. The code is moved from here to src/main/java--LoginPage
		loginpage.enterUserName(usernameValue);
		loginpage.enterPassword(passwordValue);
		loginpage.clickOnSignin();

		HomePage homepage = new HomePage(driver); //Page Object Model approach. The code is moved from here to src/main/java--HomePage
		homepage.clickAdminIcon();
		homepage.clickLogOut();
		
	}

}
