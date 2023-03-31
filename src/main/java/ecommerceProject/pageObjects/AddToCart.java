package ecommerceProject.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;

public class AddToCart extends Util {
	private By addtoCartBtn= By.cssSelector("body.catalog-category-view.categorypath-mobile-html.category-mobile:nth-child(2) div.wrapper:nth-child(1) div.page:nth-child(2) div.main-container.col3-layout div.main div.col-wrapper div.col-main div.category-products ul.products-grid.products-grid--max-4-col.first.last.odd:nth-child(2) li.item.last:nth-child(2) div.product-info div.actions button.button.btn-cart span:nth-child(1) > span:nth-child(1)");
	private By qty=By.xpath("//tbody/tr[1]/td[4]/input[1]");
	private By updateQty=By.xpath("//tbody/tr[1]/td[4]/button[1]");
    private By errMsg=By.xpath("//p[contains(text(),'* The maximum quantity allowed for purchase is 500')]");
    private By emptyCartBtn= By.cssSelector("#empty_cart_button");
	private By emptyCartMsg= By.tagName("h1");
	public void addToCartClick() throws InterruptedException
	{
		clickonElement(addtoCartBtn);
	}
	
	public void updateQty() throws InterruptedException
	{
		//waituntilElementToBeVisible(qty, 3);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		typeText(qty,"1000");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		clickonElement(updateQty);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		waituntilElementToBeVisible(errMsg,60);
		String error=getText(errMsg);
		Assert.assertEquals(error, "* The maximum quantity allowed for purchase is 500.");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

	
	public void emptyCart() throws InterruptedException
	{
		clickonElement(emptyCartBtn);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		Assert.assertEquals(getText(emptyCartMsg),"SHOPPING CART IS EMPTY");
		
	}
}
