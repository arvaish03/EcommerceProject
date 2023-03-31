package ecommerceProject.pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;

public class MainPage extends Util {

	
	private By pageTitle =By.tagName("h2");
	
	public String verifyPageTitle()
	{
	       String actualTitle = getText(pageTitle);
		   return actualTitle;
	 }
}
