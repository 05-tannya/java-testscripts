package e.com.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import e.com.base.DriverBase;


public class loginPage extends DriverBase {

	@FindBy(id="user-name")
	WebElement name ;
	
	@FindBy(id="password")
	WebElement password ;
	
	@FindBy(id="login-button")
	WebElement LoginButton ;
	
	@FindBy(className="login_logo")
	WebElement loginlogo ;
	
	@FindBy( xpath = "//h3")
	WebElement errortext;
	
	//initializing your page factory 
	public loginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
    // Actions 
   
    public String validateTitle() {
    	return driver.getTitle();
    }
    public boolean validateLogo() {
    	return loginlogo.isDisplayed();
    }
    public String validateErrorText() {
    	return errortext.getText();                  
    }
    public inventoryPage crdentials(String a, String b ) throws IOException {
    	name.sendKeys(a);
    	password.sendKeys(b);		
    	LoginButton.click();
    	//rememberme.click();
    	//as soon as button is clicked we are landed on home page . THUS IT SHOULD RETURN HOMEPAGE CLASS OBJEC    	
    	return new inventoryPage();
    }
}
