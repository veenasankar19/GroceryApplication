package Base;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ScreenShotUtility;

public class TestNGBase {
	public WebDriver driver;
	
	@BeforeMethod (alwaysRun = true)
	@Parameters("browser") //"browser"-same as parameter name in testng
	public void browserInitializer(String browser) throws Exception { //Give any variable name with String datatype, here it is "browser"
		//driver = new FirefoxDriver();
		if(browser.equalsIgnoreCase("Chrome")) { //for Chrome browser if browser value in testng is "Chrome"
			//driver=new ChromeDriver();
			ChromeOptions options = new ChromeOptions();
			Map<String,Object> prefs=new HashMap<>();
			prefs.put("profile.password_manager_leak_detection", false);
			options.setExperimentalOption("prefs", prefs);
			driver=new ChromeDriver(options);
		}
		else if(browser.equalsIgnoreCase("Firefox")) { //for Firefox if browser value in testng is "Chrome"
			driver=new FirefoxDriver();
		}
else {
			throw new Exception("Invalid browser name"); //if the browser is not Chrome and Firefox
		}
		
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //Wait 5seconds to identify all elements for all testcases where @FindBy elements are not identified (Instead of giving error "No such element found") due to cases likes slow network.
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
