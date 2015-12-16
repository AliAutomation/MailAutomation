package Core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Open_CloseBrowser {
	
	protected WebDriver driver ;
	
	@Parameters({ "browser", "url" })
	
	@BeforeClass
	
	public void openBrowser(String browser , String url)
	{
		if(browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver() ;
		}
		
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\chromediver.exe" );
			driver = new ChromeDriver() ;
			
		}
		else	if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer_x64_2.45.0\\IEDriverServer.exe");
			DesiredCapabilities cap =  new DesiredCapabilities();
			cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, "true");
			cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, "true");
			 WebDriver driver = new InternetExplorerDriver ();
			 driver= new InternetExplorerDriver(cap);
		}
		
		else 
		{
			driver = new FirefoxDriver();
		}
		
		  driver.get(url);
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	}
	
	
	@AfterClass
	
	public void closebrowser()
	{
		driver.close();
	}

}
