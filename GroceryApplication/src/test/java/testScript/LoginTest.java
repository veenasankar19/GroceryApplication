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
		
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys(usernameValue);
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordValue);
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();


	}
//Give invalid username and valid password -- Valid Credentials	
	@Test(priority = 2)
	public void verifyLoginWithInvalidUsername() throws IOException {
		String usernameValue=ExcelUtility.getStringData(2, 0, "LoginPage");  //Data Driven Approach to fetch data from Excel sheet
		String passwordValue=ExcelUtility.getStringData(2, 1, "LoginPage");
		
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys(usernameValue);
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordValue);
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();
	}
//Give valid username and invalid password - Invalid Credentials
	@Test (priority = 3)
	public void verifyLoginWithInvalidPassword() throws IOException {
		String usernameValue=ExcelUtility.getStringData(3, 0, "LoginPage");  //Data Driven Approach to fetch data from Excel sheet
		String passwordValue=ExcelUtility.getStringData(3, 1, "LoginPage");
		
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys(usernameValue);
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordValue);
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();
	}
//Give invalid username and invalid password - Invalid Credentials
	@Test  (priority = 4)
	public void verifyLoginWithInvalidUsernamePassword() throws IOException {
		String usernameValue=ExcelUtility.getStringData(4, 0, "LoginPage");  //Data Driven Approach to fetch data from Excel sheet
		String passwordValue=ExcelUtility.getStringData(4, 1, "LoginPage");
		
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys(usernameValue);
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordValue);
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();
	}
	
}
