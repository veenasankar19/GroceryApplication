package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class HomePage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	WaitUtility waitutility = new WaitUtility();
	public HomePage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this); //this keyword in PageFactory helps to access the details of login in entire class
	}
	@FindBy (xpath = "//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']") WebElement adminIcon;
	public HomePage clickAdminIcon() {
		waitutility.waitUntilClickable(driver, adminIcon);
		pageutility.clickElement(adminIcon);
		return this; //return type this because it is staying on same page - HomePage
	}
	@FindBy (xpath = "//i[@class='ace-icon fa fa-power-off']") WebElement logOut;
	public LoginPage clickLogOut() {
		pageutility.clickElement(logOut);
		return new LoginPage(driver);
	}
	//Cut clickAdminMoreInfo() method from AdminPage and pasted here
	@FindBy (xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']") WebElement adminMoreInfo;
	public AdminPage clickAdminMoreInfo() {
		pageutility.clickElement(adminMoreInfo);//from PageUtility class
		return new AdminPage(driver);
	}

}
