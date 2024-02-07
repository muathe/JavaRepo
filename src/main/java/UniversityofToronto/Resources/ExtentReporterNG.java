package UniversityofToronto.Resources;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static ExtentReports getExtentReporter() {
		
		File path = new File(System.getProperty("user.dir")+ "\\Reports\\index.html");
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		
		reporter.config().setReportName("Test Results");
		reporter.config().setDocumentTitle("WebAutomation Results");
		
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Moe");
		
		return extent;
		
	}

}
