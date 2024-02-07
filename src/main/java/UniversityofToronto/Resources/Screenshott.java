package UniversityofToronto.Resources;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshott {
	
	
	WebDriver driver;
	
	public Screenshott(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public String getScreenshot(String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File path = new File(System.getProperty("user.dir")+ "\\Reports\\" + name +".png");
		FileUtils.copyFile(source, path);
		
		return System.getProperty("user.dir")+ "\\Reports\\" + name +".png";
		
	}
	
	

}
