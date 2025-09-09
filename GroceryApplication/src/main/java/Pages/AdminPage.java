package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AdminPage {
public WebDriver driver;
public AdminPage(WebDriver driver) {
		this.driver=driver;
}
	@FindBy (xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']") WebElement adminMoreInfo;
	public void clickAdminMoreInfo() {
		//WebElement adminMoreInfo = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']"));
		adminMoreInfo.click();
	}
	@FindBy (xpath = "//a[@class='btn btn-rounded btn-danger']") WebElement newButton;
	public void clickNewButton() {
		//WebElement newButton = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger']")); //clicking New Button
		newButton.click();
	}
	@FindBy (xpath = "//input[@id='username']") WebElement usernamefield;
	public void enterUsernameField(String randomname) {
		//WebElement usernamefield = driver.findElement(By.xpath("//input[@id='username']"));
		usernamefield.sendKeys(randomname); //take a username randomly from faker Utility
	}
	@FindBy (xpath = "//input[@id='password']") WebElement passwordfield;
	public void enterPasswordField(String randompassword) {
		//WebElement passwordfield = driver.findElement(By.xpath("//input[@id='password']"));
		passwordfield.sendKeys(randompassword);
	}
	@FindBy (xpath = "//select[@id='user_type']") WebElement usertype;
	public void chooseUserType(String userType) {
		//WebElement usertype = driver.findElement(By.xpath("//select[@id='user_type']"));
		Select select=new Select(usertype); //Predefined class Select is used to select usertype value
		select.selectByVisibleText(userType);
	}
	@FindBy (xpath = "//button[@name='Create']") WebElement savebutton;
	public void clickSaveButton() {
		//WebElement savebutton=driver.findElement(By.xpath("//button[@name='Create']"));
		savebutton.click();
	}
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement addUserAlert;
	public boolean isAlertDisplayed() {
		return addUserAlert.isDisplayed();
	}
}
