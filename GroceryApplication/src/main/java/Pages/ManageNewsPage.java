package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageNewsPage {
public WebDriver driver;
public ManageNewsPage (WebDriver driver){
		this.driver = driver;
}
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'and @class='small-box-footer']") WebElement managenewstile;
	public void clickManageNewsTile() {
		//WebElement managenewstile = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'and @class='small-box-footer']"));
		managenewstile.click();
	}
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']") WebElement newbutton;
	public void clickNewbutton() {
		//WebElement newbutton = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger']"));
		newbutton.click();
	}
	@FindBy(xpath = "//textarea[@id='news']") WebElement newstextbox;
	public void enterNewsTextbox() {
		//WebElement newstextbox = driver.findElement(By.xpath("//textarea[@id='news']"));
		newstextbox.sendKeys("Sample News");
	}
	@FindBy(xpath = "//button[@name='create']") WebElement savebutton;
	public void clickSaveButton() {
		//WebElement savebutton = driver.findElement(By.xpath("//button[@name='create']"));
		savebutton.click();
	}
	@FindBy(xpath = "//a[@href='javascript:void(0)']") WebElement searchbutton;
	public void clickSearchButtonBlue() {
		//WebElement searchbutton=driver.findElement(By.xpath("//a[@href='javascript:void(0)']"));
		searchbutton.click(); //click on Search Button
	}
	@FindBy(xpath = "//input[@class='form-control']") WebElement searchtextbox;
	public void enterNewsTextboxInsideSearch() {
		//WebElement searchtextbox = driver.findElement(By.xpath("//input[@class='form-control']"));
		searchtextbox.sendKeys("Test");
	}
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']") WebElement searchbuttonred;
	public void clickSearchButtonRed() {
		//WebElement searchbuttonred = driver.findElement(By.xpath("//button[@class='btn btn-danger btn-fix']"));
		searchbuttonred.click(); //click on Search button in red color
	}
	@FindBy(xpath = "//a[@class='btn btn-default btn-fix']") WebElement resetbutton;
	public void clickResetButtonGrey() {
		//WebElement resetbutton = driver.findElement(By.xpath("//a[@class='btn btn-default btn-fix']"));
		resetbutton.click(); //click on Reset button in grey color
	}
	@FindBy(xpath = "//li[@class='breadcrumb-item']") WebElement homelink;
	public void clickHomeLink() {
		//WebElement homelink = driver.findElement(By.xpath("//li[@class='breadcrumb-item']"));
		homelink.click();
	}
//Methods for Assertion WebElements
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement addNewsAlert;
	public boolean isAddNewsAlertDisplayed() {
		//WebElement addNewsAlert = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		return addNewsAlert.isDisplayed();
	}
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]") WebElement firstValueofTable;
	public String isSearchedNewsFoundinTable() {
		//WebElement firstValueofTable = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]"));
		return firstValueofTable.getText();
	}
	@FindBy(xpath = "//form[@role='form']") WebElement searchmanagenews;
	public boolean isSearchManageNews() {
		//WebElement searchmanagenews = driver.findElement(By.xpath("//form[@role='form']"));
		return searchmanagenews.isDisplayed();
	}

}
