package Test01;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import util.BaseClass;


public class HomeTest_02 extends BaseClass
{
	/** 	 	 */
	@Test
	public void test01()
	{
		Assert.assertTrue(cll.brandLogoImage("Allen Solly").isDisplayed());
		driver.findElement(By.xpath("//abc")).isDisplayed();
	}
}
