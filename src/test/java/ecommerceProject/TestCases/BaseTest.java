package ecommerceProject.TestCases;

import java.net.MalformedURLException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import ecommerceProject.pageObjects.BrowserManager;
import ecommerceProject.pageObjects.Util;

public class BaseTest extends Util {

	BrowserManager browserManager=new BrowserManager();
	@BeforeMethod
	
	
	public void openBrowser() throws MalformedURLException
	{
		
		browserManager.setupBrowser();
	}
		
		@AfterMethod
		public void closeBrowser(ITestResult result) {
			
			if (ITestResult.FAILURE==result.getStatus())
			{
				takeScreenShot(result.getMethod().getMethodName()+timestamp());
			}
			browserManager.closeBrowser();
		}
	}

