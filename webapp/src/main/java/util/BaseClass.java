package util;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import repo.cl;

public class BaseClass
{
	protected WebDriver								driver;
	protected A00A_WebDriverUtilityClass			wdU_A00A;
	protected cl			cll;
	
	
	
	@BeforeClass(alwaysRun = true)
	public WebDriver launchBrowser()
	{
		wdU_A00A	= new A00A_WebDriverUtilityClass();
		driver		= wdU_A00A.launchBrowser("chrome", "https://allensolly.abfrl.in/", 10);//chrome or edge or firefox
		cll = new cl(driver);
		
//		H01A_ThreadSafeClass.setWdu(driver);
		return driver;
	}
	@AfterClass(alwaysRun = true)
	public void closeBrowser()
	{
		try {Thread.sleep(5000);}catch(InterruptedException e){e.printStackTrace();}
		wdU_A00A.closeBrowser();
	}
}
