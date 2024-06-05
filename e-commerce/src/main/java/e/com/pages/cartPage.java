package e.com.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import e.com.base.DriverBase;

public class cartPage extends DriverBase{

	loginPage l; 
	inventoryPage h;
	cartPage c;
    checkoutPage ch;
    
    @FindBy(id = "checkout")
    WebElement checkoutButton;
    
    @FindBy(id = "continue-shopping")
    WebElement continueShoppingButton;
    
  //initializing your page factory 
  	public cartPage() throws IOException {
  		PageFactory.initElements(driver, this);
  	}
    
    public checkoutPage ValidateCheckoutButton() {
    	checkoutButton.click();   	
    	return new checkoutPage();
    }
   
    public inventoryPage ValidateContinueShoppingButton() throws IOException { 
    	continueShoppingButton.click();
        return new inventoryPage();
    	
    }
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }
    
    

