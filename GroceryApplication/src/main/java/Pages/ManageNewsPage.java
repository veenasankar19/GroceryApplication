package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManageNewsPage {
public WebDriver driver;
public ManageNewsPage (WebDriver driver){
		this.driver = driver;
}
	public void clickManageNewsTile() {
		WebElement managenewstile = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'and @class='small-box-footer']"));
		managenewstile.click();
	}
	public void clickNewbutton() {
		WebElement newbutton = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger']"));
		newbutton.click();
	}
	public void enterNewsTextbox() {
		WebElement newstextbox = driver.findElement(By.xpath("//textarea[@id='news']"));
		newstextbox.sendKeys("Sample News");
	}
	public void clickSaveButton() {
		WebElement savebutton = driver.findElement(By.xpath("//button[@name='create']"));
		savebutton.click();
	}
	public void clickSearchButton() {
		WebElement searchbutton=driver.findElement(By.xpath("//a[@href='javascript:void(0)']"));
		searchbutton.click(); //click on Search Button
	}
	public void enterNewsTextboxInsideSearch() {
		WebElement newstextbox = driver.findElement(By.xpath("//input[@class='form-control']"));
		newstextbox.sendKeys("Test");
	}
	public void clickSearchButtonRed() {
		WebElement searchbuttonred = driver.findElement(By.xpath("//button[@class='btn btn-danger btn-fix']"));
		searchbuttonred.click(); //click on Search button in red color
	}
	public void clickResetButtonGrey() {
		WebElement resetbutton = driver.findElement(By.xpath("//a[@class='btn btn-default btn-fix']']"));
		resetbutton.click(); //click on Reset button in grey color
	}
	public void clickHomeLink() {
		WebElement homelink = driver.findElement(By.xpath("//li[@class='breadcrumb-item']"));
		homelink.click();
	}

}
