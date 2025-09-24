package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageNewsPage {
public WebDriver driver;
PageUtility pageutility = new PageUtility();
WaitUtility waitutility = new WaitUtility();
public ManageNewsPage (WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this); //this keyword in PageFactory helps to access the details of login in entire class
}
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']") WebElement newbutton;
	public ManageNewsPage clickNewbutton() {
		waitutility.waitUntilClickable(driver, newbutton); //from WaitUtility. Confirm that it is clickable and wait for max of 5sec. Once element is confirmed to be clickable, next action will be executed.
		pageutility.clickElement(newbutton);
		return this;
	}
	@FindBy(xpath = "//textarea[@id='news']") WebElement newstextbox;
	public ManageNewsPage enterNewsTextbox() {
		pageutility.sendDataToElement(newstextbox, "Sample News"); //sendDataToElement is the name in PageUtility class. null is added bcz of no parameter
		return this;
	}
	@FindBy(xpath = "//button[@name='create']") WebElement savebutton;
	public ManageNewsPage clickSaveButton() {
		pageutility.clickElement(savebutton);
		return this;
	}
	@FindBy(xpath = "//a[@href='javascript:void(0)']") WebElement searchbutton;
	public ManageNewsPage clickSearchButtonBlue() {
		pageutility.clickElement(searchbutton);
		return this;
	}
	@FindBy(xpath = "//input[@class='form-control']") WebElement searchtextbox;
	public ManageNewsPage enterNewsTextboxInsideSearch() {
		pageutility.sendDataToElement(searchtextbox, "Test");
		return this;
	}
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']") WebElement searchbuttonred;
	public ManageNewsPage clickSearchButtonRed() {
		pageutility.clickElement(searchbuttonred); //click on Search button in red color
		return this;
	}
	@FindBy(xpath = "//a[@class='btn btn-default btn-fix']") WebElement resetbutton;
	public ManageNewsPage clickResetButtonGrey() {
		pageutility.clickElement(resetbutton); //click on Reset button in grey color
		return this;
	}
	@FindBy(xpath = "//li[@class='breadcrumb-item']") WebElement homelink;
	public HomePage clickHomeLink() {
		pageutility.clickElement(homelink);
		return new HomePage(driver);
	}
//Methods for Assertion WebElements
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement addNewsAlert;
	public boolean isAddNewsAlertDisplayed() {
		return addNewsAlert.isDisplayed();
	}
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]") WebElement firstValueofTable;
	public String isSearchedNewsFoundinTable() {
		return firstValueofTable.getText();
	}
	@FindBy(xpath = "//form[@role='form']") WebElement searchmanagenews;
	public boolean isSearchManageNews() {
		return searchmanagenews.isDisplayed();
	}
}
