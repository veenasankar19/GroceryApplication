package Pages;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class LoginPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	/*Parameterised Constructor is created. 
	We have a driver in testNGBase with loginURL. 
	If the constructor and this keyword are not given, a new driver will be created. 
	Instead we need driver from testNGBase where we have given login URL, name of browser to be used etc.*/
	public LoginPage(WebDriver driver) {	
		this.driver=driver; 
		PageFactory.initElements(driver, this); //this keyword in PageFactory helps to access the details of login in entire class
	}
	@FindBy(xpath = "//input[@name='username']") WebElement username;  //"xpath" can be replaced by "id", "name" etc accordingly
	public void enterUserName(String usernameValue) {
		//WebElement username = driver.findElement(By.xpath("//input[@name='username']")); //Commented bcz it is moved to line 19 inside @FindBy
		//username.sendKeys(usernameValue);
		pageutility.sendDataToElement(username, usernameValue); //sendDataToElement is the name in PageUtility class
	}
	@FindBy(xpath = "//input[@name='password']") WebElement password;  //PageFactory helps to reuse this webelement "password" in another method using password.IsDisplayed since this is outside a method
	public void enterPassword(String passwordValue) {
		//WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		//password.sendKeys(passwordValue);
		pageutility.sendDataToElement(password, passwordValue); //sendDataToElement is the name in PageUtility class
	}
	@FindBy(xpath = "//button[@type='submit']") WebElement loginBtn;
	public void clickOnSignin() {
		//WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		//loginBtn.click();
		pageutility.clickElement(loginBtn);
	}
	//Below is the alert message shown while giving invalid credentials in login page of web application
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']") WebElement loginAlert;
	public boolean isLoginAlertDisplayed() {
		//WebElement loginAlert = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		return loginAlert.isDisplayed();
	}
}
