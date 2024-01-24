package repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class cl {
	String brandLogoImage = "//div[contains(@class,'headerMenu')]//img[@title='%s']";
	public WebElement brandLogoImage(String value)
	{
		String xpath = String.format(brandLogoImage, value);
		return driver.findElement(By.xpath(xpath));
	}
	
	WebDriver driver;
	public cl(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
