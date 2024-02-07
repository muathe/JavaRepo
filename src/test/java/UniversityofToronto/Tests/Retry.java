package UniversityofToronto.Tests;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{

	int count = 1;
	int max = 2;
	
	@Override
	public boolean retry(ITestResult result) {
		if(count< max) {
			count++;
			return true;
		}
		
		return false;
	}

}
