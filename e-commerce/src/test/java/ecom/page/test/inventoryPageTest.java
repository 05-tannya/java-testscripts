package ecom.page.test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import e.com.base.DriverBase;
import e.com.pages.cartPage;
import e.com.pages.inventoryPage;
import e.com.pages.loginPage;

public class inventoryPageTest extends DriverBase {
	
	 loginPage l; 
	 inventoryPage h;
	 cartPage c;
	 int i ;         
	
	
	public inventoryPageTest() throws Exception {
		super();
	}
	
	@BeforeMethod // calling the driver from parent class(DriverBase class)	
	public void setUp() throws IOException  {	
		initialization();
		l = new loginPage();// before going to inventory screen we have to login into the app 
		h =l.crdentials(p.getProperty("Username"), p.getProperty("Password"));		
	}
	
    @Test(priority=1)    
    public void ValidateHomePageUrlTest() {
    	String HomePageUrl=h.InventoryPageUrl();
    	Assert.assertEquals(HomePageUrl, "https://www.saucedemo.com/inventory.html", "incorrect URL");
    	Reporter.log(HomePageUrl);
    }
    
    @Test(priority =3)
    public void ValidateImagePresenceTest() {
    	List<WebElement> currentImages=  h.ValidateImagePresence();
    	for (WebElement currentImage : currentImages) {
    		
    	    if (((WebElement) currentImage).isDisplayed()) {
    	    	String imageSrc = currentImage.getAttribute("src");
                System.out.println("Image is present: " + imageSrc);
    		    Reporter.log("Image is present" + imageSrc);
    	    }
    	    else {Reporter.log("Image is missing");
    	    	System.out.println("Image is missing");}  	        
    	    }}
    
    @Test(priority= 6)   
    public void MoveToCartTest() throws IOException {
    	c=h.MovingToCart();   	
    	System.out.println("sucessfully moved to cart page" );  }
    
    
   @Test(priority =2 )    
    public void ValidataItemNameTest() {
    List<WebElement>ItemNames = h.ValidateItemName();	
    for (WebElement GetName : ItemNames) {
    	System.out.println("PRODUCT NAME BELOW");
    	System.out.println(GetName.getText());}}
   
    
  @Test(priority = 4)
    public void AddItemsToCartTest() {
	  System.out.println("inside the method ");
    	List<WebElement>CartButton = h.addItemsToCart();
    	System.out.println("able to call the method of inventory class");
    	for (WebElement button : CartButton) {
    		System.out.println(button.getText());
    		String actualText = button.getText();
    		String expectedText = "Add to cart";
    		assertEquals(actualText, expectedText, "String doesnot match");	
    		button.click();
    		String count =driver.findElement(By.className("shopping_cart_badge")).getText();
    		System.out.println(count + " item added to cart");
    		}}
  
  
  @Test(priority =5)
	  public void FilterSorting() {
	  WebElement n= h.ValidateFilterSorting();
	  Select s = new Select(n);
	  List<WebElement> options = s.getOptions();
	  
	  for (WebElement option : options) {		  
          System.out.println("Filter values that can be selected" + option.getText());		       
          s = new Select(n);         
          s.selectByVisibleText(option.getText());	  
	  }
	 
	  
	 
	  
			  
  }
    	

    	
    	
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	@AfterMethod
	public void tearDown() {
           
    }
}
