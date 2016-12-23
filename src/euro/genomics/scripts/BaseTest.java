package euro.genomics.scripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest implements AutoConst{
	
public WebDriver driver;
	
	@Parameters({"remoteURL","browser"})
	@BeforeMethod
	
	/*
	//Old Code
	public void preCondition()
	{
		String key="webdriver.chrome.driver";
		String value="./driver/chromedriver.exe";
		System.setProperty(key, value);
		driver=new ChromeDriver();
		driver.get("http://localhost");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	*/
	
	/*
	//New Code-1
	public void preCondition() throws MalformedURLException
	{
		URL ra=new URL("http://192.168.1.4:4444/wd/hub");
		DesiredCapabilities dc=new DesiredCapabilities();		
		//dc.setBrowserName("internet explorer");
		dc.setBrowserName("chrome");
		dc.setBrowserName("firefox");
		//dc.setVersion("2.20");
		dc.setPlatform(Platform.WINDOWS);
		driver=new RemoteWebDriver(ra,dc);
		
		//driver=new FirefoxDriver();
		driver.get("http://localhost");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	*/
	
	
	//New Code-2	
	public void preCondition(String remoteURL,String browser) throws MalformedURLException
		{
			URL ra=new URL(remoteURL);
			DesiredCapabilities dc=new DesiredCapabilities();
			dc.setBrowserName(browser);
			//dc.setVersion("2.20");
			dc.setPlatform(Platform.WIN8);
			driver=new RemoteWebDriver(ra,dc);
			
			//driver=new FirefoxDriver();
			driver.get("http://localhost");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	
	
	
	
	@AfterMethod
	public void postCondition()
	{
		driver.close();
	}

}
