package orange.hr.employeeMng;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import orange.hr.baseClass.Driversetup;

public class LoginPage extends Driversetup{

	
	@FindBy(xpath = "//input[@placeholder = 'Username']")
	WebElement Username;
	
	@FindBy(xpath = "//input[@placeholder = 'Username']")
	WebElement Password;
	
	@FindBy(className="icon login-icon")
	WebElement Login;
	
	@FindBy(className="orangehrm-logo")
	WebElement logo;
	
	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);}
	
	public Dashboard login(String a, String b ) throws IOException {
		Username.sendKeys(a);
		Password.sendKeys(b);
		Login.click();
		return new Dashboard();
	}
	
	public String getTitle() {
		String x = driver.getTitle();
		return x ;
	}
	
	public boolean Logo() {
		boolean w = logo.isDisplayed();
		return w ; 
	}

}
