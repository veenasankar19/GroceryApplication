package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void sendDataToElement(WebElement element,String text) {
		element.sendKeys(text);
	}
	public void clickElement(WebElement element) {
		element.click();
	}
	public void selectDataWithVisibleText(WebElement element, String text) {
		Select select=new Select(element); //Predefined class Select is used to select element value
		select.selectByVisibleText(text);
	}
	public void scrollToElement(WebDriver driver, WebElement element) { //Not used in the Project. Added JFI
	    Actions actions=new Actions(driver);
	    actions.moveToElement(element).perform();
	}
	public void clearElementData(WebElement element) {
		element.clear();
	}

}
