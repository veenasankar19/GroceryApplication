package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AdminPage {
public WebDriver driver;
public AdminPage(WebDriver driver) {
		this.driver=driver;
}
	public void clickAdminMoreInfo() {
		WebElement adminMoreInfo = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']"));
		adminMoreInfo.click();
	}
	public void clickNewButton() {
		WebElement newButton = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger']")); //clicking New Button
		newButton.click();
	}
	public void enterUsernameField(String randomname) {
		WebElement usernamefield = driver.findElement(By.xpath("//input[@id='username']"));
		usernamefield.sendKeys(randomname); //take a username randomly from faker Utility
	}
	public void enterPasswordField(String randompassword) {
		WebElement passwordfield = driver.findElement(By.xpath("//input[@id='password']"));
		passwordfield.sendKeys(randompassword);
	}
	public void chooseUserType(String userType) {
		WebElement usertype = driver.findElement(By.xpath("//select[@id='user_type']"));
		Select select=new Select(usertype); //Predefined class Select is used to select usertype value
		select.selectByVisibleText(userType);
	}
	public void clickSaveButton() {
		WebElement savebutton=driver.findElement(By.xpath("//button[@name='Create']"));
		savebutton.click();
	}
}
