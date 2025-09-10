package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Base.TestNGBase;
import Pages.HomePage;
import Pages.LoginPage;
import constant.Constants;
import constant.Messages;
import utilities.ExcelUtility;

public class HomeTest extends TestNGBase {
	@Test (description ="Verify LogOut Functionality")
	public void verifyLogOut() throws IOException {
//verifyLoginWithValidCredentials method in LoginTest Class before. This is done to login to the website.
		String usernameValue=ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);  //Data Driven Approach to fetch data from Excel sheet and Sheetname is fetched from Constants Class in constant package
		String passwordValue=ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
		
		LoginPage loginpage = new LoginPage(driver);  //Page Object Model approach. The code is moved from here to src/main/java--LoginPage
		loginpage.enterUserName(usernameValue);
		loginpage.enterPassword(passwordValue);
		loginpage.clickOnSignin();

		HomePage homepage = new HomePage(driver); //Page Object Model approach. The code is moved from here to src/main/java--HomePage
		homepage.clickAdminIcon();
		homepage.clickLogOut();
//For assertion when the logout action fails
		String actual = driver.getCurrentUrl();
		String expected = "https://groceryapp.uniqassosiates.com/admin/login";
		Assert.assertEquals(actual, expected, Messages.LOGOUTFUNCTIONALITYERROR); //Message is added in Messages Class
	}
}
