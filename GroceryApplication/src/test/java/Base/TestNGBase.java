package Base;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.ScreenShotUtility;

public class TestNGBase {
	public WebDriver driver;
	
	@BeforeMethod
	public void browserInitializer() {
		//driver = new FirefoxDriver();
		//ChromeOptions` allows you to customize how Chrome starts — such as setting preferences, enabling headless mode, disabling extensions, password leak detection etc.
		ChromeOptions options = new ChromeOptions();
		//Create a map that has the key as password leak detection, and value to be false so that leak detect is turned off while launching browser.
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.password_manager_leak_detection", false);
		//Set the above pref as "Experimental option" so that it is reflected in user preferences
		options.setExperimentalOption("prefs", prefs);
		//Launch the driver with customized preference with "options"
		driver = new ChromeDriver(options);
		
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void quitAndClose() {
		//driver.close();
		//driver.quit();
	}
	
	@AfterMethod(alwaysRun = true) //always runs after each testcase. if @AfterTest exists, the testcase terminates only after executing "alwaysRun = true"
	public void driverQuit(ITestResult iTestResult) throws IOException //ITestResult is an interface provided by TestNG
	{
		if(iTestResult.getStatus()==ITestResult.FAILURE) //This will be invoked if a testcase fails
		{
			ScreenShotUtility screenShot=new ScreenShotUtility();
			screenShot.getScreenshot(driver, iTestResult.getName());
		}
		driver.quit();

	}

}
