package web.genericLibraries;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import web.utilities.Initialization;
import web.utilities.PropertyFile;
import web.utilities.WebDriverUtilities;

public class BaseClass 
{
	public WebDriver driver;
	public PropertyFile pdata=new PropertyFile();
	public SoftAssert sa= new SoftAssert();
	public WebDriverUtilities utilities=new WebDriverUtilities();
	public List<String> bankPageTitles= new ArrayList<String>();
	public List<String> occupationOptions= new ArrayList<String>();
	public List<String> sourceOfIncome= new ArrayList<String>();
	public List<String> nationality= new ArrayList<String>();
	
	@Parameters({"env", "paymentMode", "browser", "merchant"})
	@BeforeMethod
	public void open(String env, String paymentMode, String browser, String merchant) throws IOException
	{	
		if(browser.equalsIgnoreCase("chrome"))
		{ 
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(); 
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			FirefoxOptions options=new FirefoxOptions();
			options.addArguments("--headless");
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			EdgeOptions options=new EdgeOptions();
			options.addArguments("--headless");
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		
		if(paymentMode.equalsIgnoreCase("dynamicQR"))
		{
			driver.navigate().to(pdata.getPropertydata(env+"DynamicQR"+merchant));
		}
		else if(paymentMode.equalsIgnoreCase("link"))
		{
			driver.navigate().to(pdata.getPropertydata(env+"Link"+merchant));
		}
		else if(paymentMode.equalsIgnoreCase("physicalQR"))
		{
			driver.navigate().to(pdata.getPropertydata(env+"PhysicalQR"+merchant));
		}
		else if(paymentMode.equalsIgnoreCase("staticQR"))
		{
			driver.navigate().to(pdata.getPropertydata(env+"StaticQR"+merchant));
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		new Initialization().initialization();
	}

	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
	
	@AfterTest
	public void assertAllMethods()
	{
		sa.assertAll();
	}
 
}
