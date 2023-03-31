package ecommerceProject.TestCases;
import org.testng.annotations.Test;


import org.testng.Assert;

import ecommerceProject.pageObjects.*;


public class TestSuite extends BaseTest{
	
	MainPage mainPage = new MainPage();
	MobileListPage mobilePage = new MobileListPage();
	VerifyProductCost costPage= new VerifyProductCost();
	AddToCart addtoCartPage	= new AddToCart();
//EmptyCart emptyCartPage= new EmptyCart();
@Test(priority=100)
	public void userShouldbeabletoNavigatetoHomePage() 
	{
	   //to verify user is on the Home Page
		String actualTitle=mainPage.verifyPageTitle();
		System.out.println(actualTitle);
	    Assert.assertEquals(actualTitle,"THIS IS DEMO SITE FOR   ");
	}
	@Test(priority=200)
    public void userShouldbeabletoNavigatetoMobilePage() throws InterruptedException
    {
    	mobilePage.mobileLink();
    	mobilePage.verifyMobilePageTitle();
    	
    }
	
@Test(priority=300)
    public void userShouldbeabletoSortByName() throws InterruptedException
    {
		mobilePage.mobileLink();
    	mobilePage.sortbyName();

    	
    }
@Test(priority=400)
	public void userShouldVerifyCost() throws InterruptedException 
	{
		mobilePage.mobileLink();
		costPage.getPrice();
		costPage.getPriceSonyXperia();
		costPage.compareCost();
	}
	
	@Test(priority=500)
	public void userShouldbeabletoClickAddtoCart() throws InterruptedException 
	{
		mobilePage.mobileLink();
		//costPage.getPrice();
		//costPage.getPriceSonyXperia();
		addtoCartPage.addToCartClick();
		addtoCartPage.updateQty();
		addtoCartPage.emptyCart();
	}
	
	
		
		
	
	
}
