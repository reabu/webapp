package util;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

				/** This class contains  all  WebDriver based functions. */

 /** Driver access */
 /** Launch the Browser */
 /** ScreenShort */
 /** Close all Browsers */

public class A00A_WebDriverUtilityClass
{
	private  WebDriver driver;
	/**To access the driver.*/
	
	/**	Launch the Browser chrome/edge */	
	public WebDriver launchBrowser(String setBrowser, String setwebURL, long timeOutInSeconds)
	{
		if(setBrowser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();		
		}
		if(setBrowser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		if(setBrowser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.get(setwebURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOutInSeconds));
		return driver;
	}
	
	/**	Launch the Browser chrome/edge Using Desired Capabilities */	
	public WebDriver launchBrowserUsingDesiredCapabilities(String setBrowser, String setwebURL, long setTimeOutInMilliSeconds)
	{
		if(setBrowser.equals("chrome"))
		{
			try 
			{
	//			URL url1 = new URL("http://localhost:4444/wd/hub");
				DesiredCapabilities cap	= new DesiredCapabilities();
				cap.setBrowserName(setBrowser);
				cap.setPlatform(Platform.WINDOWS);
				WebDriverManager.chromedriver().setup();
				ChromeOptions options	= new ChromeOptions();
				options.addArguments("start-maximized");
				cap.merge(options);
				WebDriver remoteWebDriver	= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
				ChromeDriver driver			= (ChromeDriver) remoteWebDriver;
				driver.manage().timeouts().implicitlyWait(Duration.ofMillis(setTimeOutInMilliSeconds));
				driver.get(setwebURL);
			} 
			catch (MalformedURLException e) {	e.printStackTrace();}

		}
		if(setBrowser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		if(setBrowser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.get(setwebURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(setTimeOutInMilliSeconds));
		return driver;
	}
	
	/**To take screenshot but not save in the local machine.
	 *  Set= (String choice, String xpath) &&  Get= File of screenshot	 	*/
	public String takesScreenShot(WebDriver driver)
	{
		TakesScreenshot screenShot=(TakesScreenshot)driver;
		String screenShotTaken=screenShot.getScreenshotAs(OutputType.BASE64);										
		return screenShotTaken;
	}
	
	/**To close the Browser. - driver.quit() - */
	public void closeBrowser()
	{
		driver.quit();
	}
}