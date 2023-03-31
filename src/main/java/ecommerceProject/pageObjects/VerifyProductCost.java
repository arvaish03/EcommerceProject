package ecommerceProject.pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;

public class VerifyProductCost extends Util{
	
	private By mobileLnk= By.xpath("//*[@id='product-price-1']/span");
	private By sonyXperiaLnk= By.cssSelector( "#product-collection-image-1");
	
	String mSonyXperiaCost,sonyXperiaCost;
	public void getPrice() {
		
		mSonyXperiaCost=getText(mobileLnk);
	System.out.println(mSonyXperiaCost);
	
	}
	public void getSonyXperia() throws InterruptedException
	{
		clickonElement(sonyXperiaLnk);
	}
	
	public void getPriceSonyXperia() {
	//Get the cost of Sony-Xperia after clicking the Sony Xperia from the mobile page 		
		sonyXperiaCost=getText(mobileLnk);
		System.out.println(sonyXperiaCost);
	}
	
	public void compareCost()
	{
		Assert.assertEquals(mSonyXperiaCost, sonyXperiaCost);
	}
}
