package ecommerceProject.pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;

public class MobileListPage extends Util {
	
	
	private By mobilelnk= By.xpath("//a[contains(text(),'Mobile')]");
	private By selDropdown=By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/select[1]");
    private By products= By.xpath("//img[@id='product-collection-image-']");
	//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]
	//body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/select[1]
	public void verifyMobilePageTitle()
	{
		Assert.assertTrue(getTitle().contains("Mobile"));
	}
	
	public void sortbyName()
	{
		selectDropdown(selDropdown);
		
		//String xpathExp =String.format("//img[@id='product-collection-image-'][%d]", prodid);
		int productItemNumber=1;
		//for (int productItemNumber=0;productItemNumber<3;productItemNumber++)
		//{
			String xpathExp= String.format("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/ul[1]/li[%d]", productItemNumber);
			searchAllProductsViaScrollDown(By.xpath(xpathExp));
		//}
				
		//System.out.println(xpathExp);
	}
	public void mobileLink() throws InterruptedException 
	{
		clickonElement(mobilelnk);
	}
	
	
	

}
