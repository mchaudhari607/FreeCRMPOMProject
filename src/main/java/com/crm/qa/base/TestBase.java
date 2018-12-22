package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.stream.FileImageInputStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.crm.qa.util.TestUtil;
//This is base class for all the classes
public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
      public TestBase() {
    	  try {
    		  prop = new Properties();
    		  FileInputStream ip =new FileInputStream("./src/main/java/com/crm/qa/config/config.properties");
    	  prop.load(ip); 
    	  }catch(FileNotFoundException e) {
    		  e.printStackTrace();
    	  }catch(IOException e) {
    		  e.printStackTrace();
    	  }
      }
      public static void initialization() {
    	  String browserName = prop.getProperty("browser");
      if(browserName.equals("chrome")) {
    	 System.setProperty("webdriver.chrome.driver","./resource/chromedriver.exe");
    	 driver=new ChromeDriver();
      }else if(browserName.equals("ff")) {
     	 System.setProperty("webdriver.gecko.driver","./resource/geckodriver.exe");
     	FirefoxOptions options = new FirefoxOptions();
     	options.setCapability("marionette", false);
     	driver = new FirefoxDriver(options);

       } 
      
      driver.manage().window().maximize();
      driver.manage().deleteAllCookies();
      
      driver.get(prop.getProperty("url"));
      driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout,TimeUnit.SECONDS);
      driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait,TimeUnit.SECONDS);
      
      }
      
}
