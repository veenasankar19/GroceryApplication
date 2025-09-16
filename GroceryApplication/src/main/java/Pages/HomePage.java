package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.PageUtility;

public class HomePage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	public HomePage (WebDriver driver) {
		this.driver=driver;
	}
	@FindBy (xpath = "//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']") WebElement adminIcon;
	public void clickAdminIcon() {
		//WebElement adminIcon = driver.findElement(By.xpath("//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']"));
		//adminIcon.click();
		pageutility.clickElement(adminIcon);
	}
	@FindBy (xpath = "//i[@class='ace-icon fa fa-power-off']") WebElement logOut;
	public void clickLogOut() {
		//WebElement logOut = driver.findElement(By.xpath("//i[@class='ace-icon fa fa-power-off']"));
		//logOut.click();
		pageutility.clickElement(logOut);
	}

}
