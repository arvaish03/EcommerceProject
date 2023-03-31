package ecommerceProject.pageObjects;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserManager extends BasePage {

	public void setupBrowser() throws MalformedURLException
	
	
	{
		//setting up driver path
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Selenium\\ChromeDriver\\ChromeDriver107v\\chromedriver.exe");
		 * 
		 * 
		 * driver= new ChromeDriver();
		 * 
		 * driver.manage().window().maximize();
		 * 
		 * driver.get(" http://live.techpanda.org");
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		 */
		
		DesiredCapabilities caps= new DesiredCapabilities();
		caps.setBrowserName("chrome");
		//caps.setPlatform(Platform.WIN11);
		//caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true); -- deprecated
		//caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		
		
		driver= new RemoteWebDriver(new URL("http://192.168.1.242:4444"),caps);
		driver.manage().window().maximize();
		driver.get("http://live.techpanda.org");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}
	
	public void closeBrowser(){
		driver.close();
	}
	
}
