package Test01;

import org.testng.Assert;
import org.testng.annotations.Test;
import util.BaseClass;

/* Verify user is able to Navigate to the Home page */

public class HomeTest_01 extends BaseClass
{
	@Test(enabled = true)
	public void home001()
	{
		Assert.assertTrue(cll.brandLogoImage("Allen Solly").isDisplayed());
//		driver.findElement(By.xpath("//abc")).isDisplayed();
	}
}
