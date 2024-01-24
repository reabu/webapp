package util;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class H02A_ListenerClass implements ITestListener
{
	private ExtentSparkReporter extentSparkReporter;
	private ExtentReports extentReports;
	private ExtentTest extentTest;
	
	@Override
	public void onStart(ITestContext context) 
	{
		extentSparkReporter=new ExtentSparkReporter("./extentsparkReporter/extentsparkReporter.html");
		extentSparkReporter.config().setDocumentTitle("ExtentReport-Arinaplus");
		extentSparkReporter.config().setReportName("Arinaplus");
		extentSparkReporter.config().setTheme(Theme.STANDARD);
		
		extentReports=new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		extentReports.setSystemInfo("Operating System", "WINDOWS 10");
		extentReports.setSystemInfo("Reporter", "ARIF");
	}
	@Override
	public void onTestStart(ITestResult result) 
	{
		extentTest=extentReports.createTest(result.getMethod().getMethodName());
		H01A_ThreadSafeClass.setExtentTest(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		H01A_ThreadSafeClass.getExtentTest().pass(result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
//		String getScreenShot=H01A_ThreadSafeClass.getWdu().takesScreenShot();
		String getScreenShot=new A00A_WebDriverUtilityClass().takesScreenShot(H01A_ThreadSafeClass.getWdu());
		H01A_ThreadSafeClass.getExtentTest().addScreenCaptureFromBase64String(getScreenShot, result.getMethod().getMethodName());
		H01A_ThreadSafeClass.getExtentTest().fail(result.getMethod().getMethodName());
		H01A_ThreadSafeClass.getExtentTest().fail(result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
//		String getScreenShot=H01A_ThreadSafeClass.getWdu().takesScreenShot();
		String getScreenShot=new A00A_WebDriverUtilityClass().takesScreenShot(H01A_ThreadSafeClass.getWdu());
		H01A_ThreadSafeClass.getExtentTest().addScreenCaptureFromBase64String(getScreenShot, result.getMethod().getMethodName());
		H01A_ThreadSafeClass.getExtentTest().skip(result.getMethod().getMethodName());
		H01A_ThreadSafeClass.getExtentTest().skip(result.getThrowable());	
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		extentReports.flush();	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
				
	}

	/**To take screenshot but not save in the local machine.
	 *  Set= (String choice, String xpath) &&  Get= File of screenshot	 	*/
	public String takesScreenShot(WebDriver driver)
	{
		TakesScreenshot screenShot=(TakesScreenshot)driver;
		String screenShotTaken=screenShot.getScreenshotAs(OutputType.BASE64);										
		return screenShotTaken;
	}
}
