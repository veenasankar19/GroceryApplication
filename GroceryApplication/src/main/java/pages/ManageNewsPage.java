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
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'and @class='small-box-footer']") WebElement managenewstile;
	public void clickManageNewsTile() {
		pageutility.clickElement(managenewstile);
	}
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']") WebElement newbutton;
	public void clickNewbutton() {
		waitutility.waitUntilClickable(driver, newbutton); //from WaitUtility. Confirm that it is clickable and wait for max of 5sec. Once element is confirmed to be clickable, next action will be executed.
		pageutility.clickElement(newbutton);
	}
	@FindBy(xpath = "//textarea[@id='news']") WebElement newstextbox;
	public void enterNewsTextbox() {
		pageutility.sendDataToElement(newstextbox, "Sample News"); //sendDataToElement is the name in PageUtility class. null is added bcz of no parameter
	}
	@FindBy(xpath = "//button[@name='create']") WebElement savebutton;
	public void clickSaveButton() {
		pageutility.clickElement(savebutton);
	}
	@FindBy(xpath = "//a[@href='javascript:void(0)']") WebElement searchbutton;
	public void clickSearchButtonBlue() {
		pageutility.clickElement(searchbutton);
	}
	@FindBy(xpath = "//input[@class='form-control']") WebElement searchtextbox;
	public void enterNewsTextboxInsideSearch() {
		pageutility.sendDataToElement(searchtextbox, "Test");
	}
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']") WebElement searchbuttonred;
	public void clickSearchButtonRed() {
		pageutility.clickElement(searchbuttonred); //click on Search button in red color
	}
	@FindBy(xpath = "//a[@class='btn btn-default btn-fix']") WebElement resetbutton;
	public void clickResetButtonGrey() {
		pageutility.clickElement(resetbutton); //click on Reset button in grey color
	}
	@FindBy(xpath = "//li[@class='breadcrumb-item']") WebElement homelink;
	public void clickHomeLink() {
		pageutility.clickElement(homelink);
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
