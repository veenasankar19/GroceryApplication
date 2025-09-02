package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver) {	
		this.driver=driver; 
/*Parameterised Constructor is created. 
We have a driver in testNGBase with loginURL. 
If the constructor and this keyword are not given, a new driver will be created. 
Instead we need driver from testNGBase where we have given login URL, name of browser to be used etc.*/
	}
	public void enterUserName(String usernameValue) {
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys(usernameValue);
	}
	public void enterPassword(String passwordValue) {
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordValue);
	}
	public void clickOnSignin() {
		WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		loginBtn.click();
	}

}
