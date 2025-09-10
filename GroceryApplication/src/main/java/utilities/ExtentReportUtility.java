package utilities; 

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	//ExtentReports is used for customized report generation
	public static final ExtentReports extentReports = new ExtentReports();//static instance of extentreports that can be shared accross the application

	public synchronized static ExtentReports createExtentReports() {
		//Creates an instance of the reporter that will generate the HTML report in the path "./extent-reports/extent-report.html".
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html"); //Folder Creation with folder name extent-reports
		reporter.config().setReportName("7R Mart SuperMarket"); //Report name is 7R Mart SuperMarket
		extentReports.attachReporter(reporter); //Folder and report names are attached to the class ExtentReports
		extentReports.setSystemInfo("Organization", "Obsqura"); //Set name of organization
		extentReports.setSystemInfo("Name", "Veena"); //provides context of the report (tester name)
		return extentReports;
	}

}
