package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Base.TestNGBase;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminTest extends TestNGBase {
	@Test
	public void verifyAddUser() throws IOException {
//to Login to the site
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");  //Data Driven Approach to fetch data from Excel sheet. "LoginPage" is the name of sheet1
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys(usernameValue);
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordValue);
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();
//To click on AdminUsers MoreInfo and load the second page
		WebElement adminMoreInfo = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']"));
		adminMoreInfo.click();
//To generate random username, password using faker utility
		FakerUtility fakerUtility = new FakerUtility();
		String randomname=fakerUtility.createRandomUserName();
		String randompassword=fakerUtility.createRandomPassword();
		String userType=ExcelUtility.getStringData(1, 2,"HomePage"); //DDA to fetch data from "HomePage" sheet of excel
	
		WebElement newButton = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger']")); //clicking New Button
		newButton.click();
		WebElement username2 = driver.findElement(By.xpath("//input[@id='username']"));
		username2.sendKeys(randomname); //take a username randomly from faker Utility
		WebElement password2 = driver.findElement(By.xpath("//input[@id='password']"));
		password2.sendKeys(randompassword);
		WebElement usertype = driver.findElement(By.xpath("//select[@id='user_type']"));
		Select select=new Select(usertype); //Predefined class Select is used to select usertype value
		select.selectByVisibleText(userType);
	}

}
