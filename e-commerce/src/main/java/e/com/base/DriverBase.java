package e.com.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import e.com.utilities.Utility;

public class DriverBase {
	
	public static Properties p;
	public static  WebDriver driver ;
// creating constructor of base class 
		 public DriverBase() throws IOException {
			// Reading the properties file 
				p = new Properties();
			    FileInputStream s = new FileInputStream("C:\\Users\\mittal.tannya\\eclipse-workspace1\\e-commerce\\src\\main\\java\\e\\com\\config\\config.properties");
				p.load(s);
			}
			
			public static void initialization() {
				String browserName = p.getProperty("Browser");
				System.out.println(browserName);
				if (browserName.contains("Chrome")) {
					System.setProperty("webdriver.chrome.driver.exe", "C:\\Users\\mittal.tannya\\eclipse-workspace1\\e-commerce\\src\\main\\java\\e\\com\\config\\config.properties");
				    driver = new ChromeDriver();
				    System.out.println("lanching the URL");
			}
			
			//System.out.println("lanching the URL");
			//driver.get(p.getProperty("URL"));
			System.out.println("URL IS LAUNCHED");
		    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utility.PAGE_LOAD_TIMEOUT));
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utility.IMPLICIT_WAIT));
		    driver.manage().window().maximize();
		    driver.manage().deleteAllCookies();
		    driver.get(p.getProperty("URL"));
		 
	 }

}
