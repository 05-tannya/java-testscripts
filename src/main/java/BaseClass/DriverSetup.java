package BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import org.apache.commons.collections.map.HashedMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Flight.utility.utility;


public class DriverSetup {
	
	public static Properties p;
	public static WebDriver driver ;
// creating constructor of base class 
		 public DriverSetup() throws IOException {
			// Reading the properties file 
				p = new Properties();
			    FileInputStream s = new FileInputStream("C:\\Users\\mittal.tannya\\eclipse-workspace1\\FlightMng\\src\\main\\java\\Flight\\config\\config.properties");
				p.load(s);
			}
			
			public static void initialization() {
				String browserName = p.getProperty("Browser");
				System.out.println(browserName);
				if (browserName.contains("Chrome")) {
					System.setProperty("webdriver.chrome.driver.exe", "C:\\Users\\mittal.tannya\\eclipse-workspace1\\FlightMng\\src\\main\\java\\Flight\\config\\config.properties");
// handling browser pop ups using Chrome Options class 					
					ChromeOptions op = new ChromeOptions();
					HashMap<String , Integer> contentSettings = new HashMap<String , Integer>();
					HashMap<String, Object> profile = new HashMap<String, Object>();
					HashMap<String , Object> prefs = new HashMap <String , Object>();
					
					contentSettings.put("geoloaction", 0);
					contentSettings.put("geolocation" , 2);
					profile.put("managed_content_settings", contentSettings);
					prefs.put("profile", profile);
					op.setExperimentalOption("prefs", prefs);
					
//					op.addArguments("disable-notifications");
					op.addArguments("disable-geolocation"); 
					driver = new ChromeDriver(op); 
					
				    System.out.println("lanching the URL");
			}
			
			//System.out.println("lanching the URL");
			//driver.get(p.getProperty("URL"));
			System.out.println("URL IS LAUNCHED");
		    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(utility.PAGE_LOAD_TIMEOUT));
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(utility.IMPLICIT_WAIT));
		    driver.manage().window().maximize();
		    driver.manage().deleteAllCookies();
		    driver.get(p.getProperty("URL"));
		 
	 }}


