package c_Home;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import a_allensolly.utilityPackage.E04A_DataBaseUtility;
import a_allensolly.utilityPackage.F01A_BaseClass;
import a_allensolly.utilityPackage.G01A_Constants;

/* Verify user is able to Navigate to the Home page */

public class HomeTest_01 extends F01A_BaseClass
{
	@Test(enabled = true)
	public void home001()
	{
		Assert.assertTrue(hP_D1.brandLogoImage(G01A_Constants.BrandName_AS).isDisplayed());
		driver.findElement(By.xpath("//abc")).isDisplayed();
	}
	
}
