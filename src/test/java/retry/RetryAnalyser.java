package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer{

	private int intial_retry_count = 0; //this will increment based of execution. so not declared as const/ static final. 
	private static final int maximum_retry_count =3;
	
	@Override
	public boolean retry(ITestResult result) {
		if(intial_retry_count<maximum_retry_count) {
			intial_retry_count++;
			return true;
		}
		return false;
	}
  
}
