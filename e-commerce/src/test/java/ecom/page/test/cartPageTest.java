package ecom.page.test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import e.com.base.DriverBase;
import e.com.pages.cartPage;
import e.com.pages.checkoutPage;
import e.com.pages.inventoryPage;
import e.com.pages.loginPage;

public class cartPageTest extends DriverBase {
	
	loginPage l ;
	inventoryPage h ;
	cartPage c;
	checkoutPage ch;
	
	public cartPageTest() throws Exception {
		super();
	}
	
	
	@BeforeMethod // calling the driver from parent class(DriverBase class)	
	public void setUp() throws IOException  {	
		initialization();
		l = new loginPage();// before going to inventory screen we have to login into the app 
		h = new inventoryPage();
		c= new cartPage();
		h =l.crdentials(p.getProperty("Username"), p.getProperty("Password"));		
	}
	
	@Test 
	public void  checkoutWithItemsTest() throws IOException{
		List<WebElement> element = h.addItemsToCart();
		for (WebElement button : element) {
    		System.out.println(button.getText());
    		String actualText = button.getText();
    		String expectedText = "Add to cart";
    		assertEquals(actualText, expectedText, "String doesnot match");	
    		button.click();}
		c=h.MovingToCart();
		ch=c.ValidateCheckoutButton();
		System.out.println("check out is performed WITH ITEMS");		
	}
	
	public void checkoutwithoutItemsTest() throws IOException {
		c= h.MovingToCart();
		ch = c.ValidateCheckoutButton();
		System.out.println("check out is performed WITHOUT ITEMS  ");
	}

	public void ItemRetainIncart() throws IOException {  // after addition of items in cart and moving to checkout screen , when we hit continue shopping the items should stay in the cart 
		
		List<WebElement> element = h.addItemsToCart();
		for (WebElement button : element) {
    		System.out.println(button.getText());
    		String actualText = button.getText();
    		String expectedText = "Add to cart";
    		assertEquals(actualText, expectedText, "String doesnot match");	
    		button.click();}
		c=h.MovingToCart();
		ch=c.ValidateCheckoutButton();
		System.out.println("check out is performed WITH ITEMS");	
		 h = c.ValidateContinueShoppingButton();
		
	
	}
}

