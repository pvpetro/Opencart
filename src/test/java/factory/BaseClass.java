package factory;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {

	static WebDriver driver;
    static Properties p;
    static Logger logger;
 	     
public static WebDriver initilizeBrowser() throws IOException
{
	p = getProperties();
   String executionEnv = p.getProperty("execution_env");
   System.out.println(executionEnv);
   String browser = p.getProperty("browser").toLowerCase();
   System.out.println(browser);
//   String os = p.getProperty("os").toLowerCase();
	
	
	if(executionEnv.equalsIgnoreCase("local"))
		{
			switch(browser.toLowerCase()) 
			{
			case "chrome":
		        driver=new ChromeDriver();
		        break;
		    case "edge":
		    	driver=new EdgeDriver();
		        break;
		    case "firefox":
		    	driver=new FirefoxDriver();
		        break;
		    default:
		        System.out.println("No matching browser");
		        driver=null;
			}
		}
	 driver.manage().deleteAllCookies();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	 
	 return driver;
	 
}

public static WebDriver getDriver() {
		return driver;
	}

public static Properties getProperties() throws IOException
{		 
   FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
  	p=new Properties();
	p.load(file);
	return p;
}

public static Logger getLogger() 
{		 
	logger=LogManager.getLogger(); //Log4j
	return logger;
}

public static String randomeString()
{
	String generatedString=RandomStringUtils.randomAlphabetic(6);
	return generatedString;
}


public static String randomeNumber()
{
	String generatedString=RandomStringUtils.randomNumeric(10);
	return generatedString;
}

	
public static String randomAlphaNumeric()
{
String str=RandomStringUtils.randomAlphabetic(5);
 String num=RandomStringUtils.randomNumeric(10);
return str+num;
}


	
	
	
}
