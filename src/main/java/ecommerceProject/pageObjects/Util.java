package ecommerceProject.pageObjects;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Util extends BasePage{
		
		public static void clickonElement(By by) throws InterruptedException
		{
			//reusable method from element is clickable
			driver.findElement(by).click();
			
		
		}
		public static void selectDropdown(By by)
		{
			WebElement selDropDown= driver.findElement(by);
			String name=selDropDown.getText();
			System.out.println(name);
			 Select selName= new Select(selDropDown);
			 selName.selectByVisibleText("Name");
		}
		public static void searchAllProductsViaScrollDown(By by) {
			WebElement product1= driver.findElement(by);
			String name=product1.getText();
			System.out.println(name); 
			
			List<WebElement> allProducts= driver.findElements(by);
			 String productResult;
			 System.out.println("Size of Products List");
			 System.out.println(allProducts.size());
			 System.out.println(allProducts);
			 int j=0;
			 Actions action= new Actions(driver);
			 for (WebElement product:allProducts) {
				 
				 action.moveToElement(product).build().perform();
				 productResult=product.getText();
				 System.out.println(productResult);
				 System.out.println("-----------------------------------------");
				j+=5;
			 }
		 }
		public static String getText(By by) 
		{ //reusable method to get text from element
			
			return driver.findElement(by).getText();
		}
		
		public static void typeText(By by, String Text)
		{//reusable method to type text in box
			driver.findElement(by).clear();  // clear existing content
			driver.findElement(by).sendKeys(Text);
			
		}
		
		public static String getTitle()
		{
			//reusable method to get Title from page
			return driver.getTitle();
		}
		
		public static void clickonSubMenu(By by, By by1)
		
		{
			// reusable method to click on submenu 
			WebElement menu =  driver.findElement(by);
			WebElement sub_menu =  driver.findElement(by1);
			Actions action = new Actions(driver);
			action.moveToElement(menu);
			action.click(sub_menu);
			action.build().perform();

		}
		
		
		public static void waituntilElementToBeVisible(By by, int time)
		{
			WebDriverWait wait= new WebDriverWait(driver,java.time.Duration.ofSeconds(time));
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			
		}
		
		public static void switchtoFrame(int index)
		{
			//reusable method to switch to frame
			driver.switchTo().frame(index);
		   		
		}
		
		public static long timestamp()
		{
			//reusable method to return the time in milliseconds
			return (System.currentTimeMillis());
		}
		
		public void takeScreenShot(String screenShotName) {
			
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			String destinationFile=System.getProperty("user.dir")+"\\reports\\"+screenShotName +".png";
			System.out.println(destinationFile);
			try {
				FileUtils.copyFile(source, new File(destinationFile));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			
		
		}
		}

}
