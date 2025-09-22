package Pages;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class LoginPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	WaitUtility waitutility = new WaitUtility();
	/*Parameterised Constructor is created. 
	We have a driver in testNGBase with loginURL. 
	If the constructor and this keyword are not given, a new driver will be created. 
	Instead we need driver from testNGBase where we have given login URL, name of browser to be used etc.*/
	public LoginPage(WebDriver driver) {	
		this.driver=driver; 
		PageFactory.initElements(driver, this); //this keyword in PageFactory helps to access the details of login in entire class
	}
	@FindBy(xpath = "//input[@name='username']") WebElement username;  //"xpath" can be replaced by "id", "name" etc accordingly
	public LoginPage enterUserName(String usernameValue) {
		//WebElement username = driver.findElement(By.xpath("//input[@name='username']")); //Commented bcz it is moved to line 19 inside @FindBy
		//username.sendKeys(usernameValue);
		pageutility.sendDataToElement(username, usernameValue); //sendDataToElement is the name in PageUtility class
		return this; //to return the current class object. Because return type is changed from void to LoginPage which is the current class.
	}
	@FindBy(xpath = "//input[@name='password']") WebElement password;  //PageFactory helps to reuse this webelement "password" in another method using password.IsDisplayed since this is outside a method
	public LoginPage enterPassword(String passwordValue) {
		//WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		//password.sendKeys(passwordValue);
		pageutility.sendDataToElement(password, passwordValue); //sendDataToElement is the name in PageUtility class
		return this;
	}
	@FindBy(xpath = "//button[@type='submit']") WebElement loginBtn;
	public HomePage clickOnSignin() {
		//WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		//loginBtn.click();
		waitutility.waitUntilClickable(driver, loginBtn); //from WaitUtility. Confirm that it is clickable and wait for max of 5sec. Once element is confirmed to be clickable, next action will be executed.
		pageutility.clickElement(loginBtn);
		return new HomePage(driver); //to return object of HomePage. Because HomePage is a different class and not the current one.
	}
	//Below is the alert message shown while giving invalid credentials in login page of web application
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']") WebElement loginAlert;
	public boolean isLoginAlertDisplayed() {
		//WebElement loginAlert = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		return loginAlert.isDisplayed();
	}
}
