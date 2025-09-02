package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Base.TestNGBase;
import Pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends TestNGBase {
	@Test
	public void verifyLogOut() throws IOException {
//verifyLoginWithValidCredentials method in LoginTest Class before. This is done to login to the website.
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");  //Data Driven Approach to fetch data from Excel sheet
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys(usernameValue);
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordValue);
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();

//for logging out
		WebElement adminIcon = driver.findElement(By.xpath("//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']"));
		adminIcon.click();
		WebElement logOut = driver.findElement(By.xpath("//i[@class='ace-icon fa fa-power-off']"));
		logOut.click();
		
	}

}
