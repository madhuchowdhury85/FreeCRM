package listenerPackage;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class listeners implements ITestListener {

	public void onTestStart(ITestResult result) {
		
		System.out.println("Test Case started "+result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		
		System.out.println("Test Case passed "+result.getName());
	}

	public void onTestFailure(ITestResult result) {
		
		System.out.println("Test Case failed "+result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		
		System.out.println("Test Case skipped "+result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
	
		
	}

	public void onFinish(ITestContext context) {
	
		
	}
	
	

}
