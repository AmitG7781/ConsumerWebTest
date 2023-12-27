package web.genericLibraries;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import web.utilities.PropertyFile;
import web.utilities.WebDriverUtilities;

public class BaseClass 
{
	public WebDriver driver;
	public PropertyFile pdata=new PropertyFile();
	public WebDriverUtilities utilities=new WebDriverUtilities();
	public List<String> uatBankPageTitles= new ArrayList<String>();
	@BeforeSuite
	public void bankPageTitleList() throws IOException
	{
		uatBankPageTitles.add(pdata.getPropertydata("hsbc"));
		uatBankPageTitles.add(pdata.getPropertydata("barclays"));
		uatBankPageTitles.add(pdata.getPropertydata("monzo"));
		uatBankPageTitles.add(pdata.getPropertydata("nationwide"));
		uatBankPageTitles.add(pdata.getPropertydata("natwest"));
		uatBankPageTitles.add(pdata.getPropertydata("rbos"));
		uatBankPageTitles.add(pdata.getPropertydata("santander"));
		uatBankPageTitles.add(pdata.getPropertydata("lloyds"));
		uatBankPageTitles.add(pdata.getPropertydata("revolut"));
		uatBankPageTitles.add(pdata.getPropertydata("bosc"));
		uatBankPageTitles.add(pdata.getPropertydata("halifax"));
		uatBankPageTitles.add(pdata.getPropertydata("starling"));
		uatBankPageTitles.add(pdata.getPropertydata("tsb"));
		uatBankPageTitles.add(pdata.getPropertydata("fd"));
	}
	
	@Parameters({"env", "paymentAcceptMode", "browserName"})
	@BeforeMethod
	public void open(String env, String paymentAcceptMode, String browserName) throws IOException
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{ 
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(); 
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		
		if(env.equalsIgnoreCase("DEV"))
		{
			if(paymentAcceptMode.equalsIgnoreCase("dynamicQR"))
			{
				driver.navigate().to(pdata.getPropertydata("devDynamicQR"));
			}
			else if(paymentAcceptMode.equalsIgnoreCase("link"))
			{
				driver.navigate().to(pdata.getPropertydata("devLink"));
			}
			else if(paymentAcceptMode.equalsIgnoreCase("physicalQR"))
			{
				driver.navigate().to(pdata.getPropertydata("devPhysicalQR"));
			}
			else if(paymentAcceptMode.equalsIgnoreCase("staticQR"))
			{
				driver.navigate().to(pdata.getPropertydata("devStaticQR"));
			}
			else if(paymentAcceptMode.equalsIgnoreCase("cashbackLink"))
			{
				driver.navigate().to(pdata.getPropertydata("cashbackPaymentLink"));
			}
		}
		
		else if(env.equalsIgnoreCase("UAT"))
		{
			if(paymentAcceptMode.equalsIgnoreCase("dynamicQR"))
			{
				driver.navigate().to(pdata.getPropertydata("uatDynamicQR"));
			}
			else if(paymentAcceptMode.equalsIgnoreCase("link"))
			{
				driver.navigate().to(pdata.getPropertydata("uatLink"));
			}
			else if(paymentAcceptMode.equalsIgnoreCase("physicalQR"))
			{
				driver.navigate().to(pdata.getPropertydata("uatPhysicalQR"));
			}
			else if(paymentAcceptMode.equalsIgnoreCase("staticQR"))
			{
				driver.navigate().to(pdata.getPropertydata("uatStaticQR"));
			}
		}
		
		else if(env.equalsIgnoreCase("PROD"))
		{
			if(paymentAcceptMode.equalsIgnoreCase("dynamicQR"))
			{
				driver.navigate().to(pdata.getPropertydata("prodDynamicQR"));
			}
			else if(paymentAcceptMode.equalsIgnoreCase("link"))
			{
				driver.navigate().to(pdata.getPropertydata("prodLink"));
			}
			else if(paymentAcceptMode.equalsIgnoreCase("physicalQR"))
			{
				driver.navigate().to(pdata.getPropertydata("prodPhysicalQR"));
			}
			else if(paymentAcceptMode.equalsIgnoreCase("staticQR"))
			{
				driver.navigate().to(pdata.getPropertydata("prodStaticQR"));
			}
		}
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
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
