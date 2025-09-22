package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminPage {
public WebDriver driver;
PageUtility pageutility = new PageUtility(); //for PageUtility class to access from here
WaitUtility waitutility = new WaitUtility();
public AdminPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this); //this keyword in PageFactory helps to access the details of login in entire class
}
//clickAdminMoreInfo() is moved to HomePage
	@FindBy (xpath = "//a[@class='btn btn-rounded btn-danger']") WebElement newButton;
	public AdminPage clickNewButton() {
		//WebElement newButton = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger']")); //clicking New Button
		//newButton.click();
		waitutility.waitUntilClickable(driver, newButton); //WaitUtility only added for 1 testcase in this class
		pageutility.clickElement(newButton);
		return this;
	}
	@FindBy (xpath = "//input[@id='username']") WebElement usernamefield;
	public AdminPage enterUsernameField(String randomname) {
		//WebElement usernamefield = driver.findElement(By.xpath("//input[@id='username']"));
		//usernamefield.sendKeys(randomname); //take a username randomly from faker Utility
		pageutility.sendDataToElement(usernamefield, randomname); //sendDataToElement is the name in PageUtility class
		return this;
	}
	@FindBy (xpath = "//input[@id='password']") WebElement passwordfield;
	public AdminPage enterPasswordField(String randompassword) {
		//WebElement passwordfield = driver.findElement(By.xpath("//input[@id='password']"));
		//passwordfield.sendKeys(randompassword);
		pageutility.sendDataToElement(passwordfield, randompassword); //sendDataToElement is the name in PageUtility class
		return this;
	}
	@FindBy (xpath = "//select[@id='user_type']") WebElement usertype;
	public AdminPage chooseUserType(String userTypeValue) {
		//WebElement usertype = driver.findElement(By.xpath("//select[@id='user_type']"));
		/*Select select=new Select(usertype); //Predefined class Select is used to select usertype value
		select.selectByVisibleText(userTypeValue);*/
		pageutility.selectDataWithVisibleText(usertype, userTypeValue);
		return this;
	}
	@FindBy (xpath = "//button[@name='Create']") WebElement savebutton;
	public AdminPage clickSaveButton() {
		//WebElement savebutton=driver.findElement(By.xpath("//button[@name='Create']"));
		//savebutton.click();
		pageutility.clickElement(savebutton);
		return this;
	}
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement addUserAlert;
	public boolean isAlertDisplayed() {
		return addUserAlert.isDisplayed();
	}
}
