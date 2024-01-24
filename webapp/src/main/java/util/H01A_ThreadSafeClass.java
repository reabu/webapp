package util;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class H01A_ThreadSafeClass
{
//	private static ThreadLocal<A00A_WebDriverUtilityClass>	driverClassThread	= new ThreadLocal<>();
	private static ThreadLocal<WebDriver>	driverClassThread	= new ThreadLocal<>();
	private static ThreadLocal<ExtentTest> 					extentTest			= new ThreadLocal<>();
	/*	
	public static A00A_WebDriverUtilityClass getWdu()
	{
		return driverClassThread.get();
	}
	public static void setWdu(A00A_WebDriverUtilityClass setWdu) 
	{
		driverClassThread.set(setWdu);
	}*/
	
	public static WebDriver getWdu()
	{
		return driverClassThread.get();
	}
	public static void setWdu(WebDriver setWdu) 
	{
		driverClassThread.set(setWdu);
	}
	
	public static ExtentTest getExtentTest()
	{
		return extentTest.get();
	}
	public static void setExtentTest(ExtentTest setExtentTest)
	{
		extentTest.set(setExtentTest);
	}
}
