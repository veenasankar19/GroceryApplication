package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Base.TestNGBase;
import utilities.ExcelUtility;

public class ManageNewsTest extends TestNGBase{
//TestCase5 to navigate to Manage News page, click on New button and perform related actions 
	@Test 
	public void verifyAddNews() throws IOException {
		String usernameValue=ExcelUtility.getStringData(6, 0, "LoginPage");  //Data Driven Approach to fetch data from Excel sheet
		String passwordValue=ExcelUtility.getStringData(6, 1, "LoginPage");
	
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys(usernameValue);
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordValue);
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();
	
		WebElement managenewstile = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'and @class='small-box-footer']"));
		managenewstile.click();
		WebElement newbutton = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger']"));
		newbutton.click();
		WebElement newstextbox = driver.findElement(By.xpath("//textarea[@id='news']"));
		newstextbox.sendKeys("Sample News");
		WebElement savebutton = driver.findElement(By.xpath("//button[@name='create']"));
		savebutton.click();
	}
//TestCase6 to navigate to Manage News page, click on Search button and perform related actions
	@Test 
	public void verifySearchNews() throws IOException {
		String usernameValue=ExcelUtility.getStringData(6, 0, "LoginPage");  //Data Driven Approach to fetch data from Excel sheet
		String passwordValue=ExcelUtility.getStringData(6, 1, "LoginPage");
	
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys(usernameValue);
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordValue);
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();
 		
		WebElement managenewstile = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'and @class='small-box-footer']"));
		managenewstile.click();
		WebElement newstextbox = driver.findElement(By.xpath("//input[@class='form-control']"));
		newstextbox.sendKeys("Test");
		WebElement searchbutton = driver.findElement(By.xpath("//button[@class='btn btn-danger btn-fix']"));
		searchbutton.click(); //click on Search button in red color
		WebElement resetbutton = driver.findElement(By.xpath("//a[@class='btn btn-default btn-fix']']"));
		resetbutton.click(); //click on Reset button in grey color	
	}
//TestCase7 to navigate to Manage News page, click on Home link	
	@Test
	public void verifyHomeLink() throws IOException {
		String usernameValue=ExcelUtility.getStringData(6, 0, "LoginPage");  //Data Driven Approach to fetch data from Excel sheet
		String passwordValue=ExcelUtility.getStringData(6, 1, "LoginPage");
	
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys(usernameValue);
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordValue);
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();
 		
		WebElement managenewstile = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'and @class='small-box-footer']"));
		managenewstile.click();	
		WebElement homelink = driver.findElement(By.xpath("//li[@class='breadcrumb-item']"));
		homelink.click();
	}

}
