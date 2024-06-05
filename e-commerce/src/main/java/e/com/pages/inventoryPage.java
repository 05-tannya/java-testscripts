package e.com.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import e.com.base.DriverBase;

public class inventoryPage extends DriverBase  {
	
	@FindBy(css = ".btn.btn_primary.btn_small.btn_inventory ")
	List<WebElement> addToCartButton;// have a same locator for all the items present on an inventory page 
	
	@FindBy(className = "inventory_item_name" )
	List<WebElement> itemName;
	
	@FindBy(className = "inventory_item_img")
	List<WebElement> itemImage;
	
	@FindBy(className = "shopping_cart_link")
	WebElement cartIcon;
	
	@FindBy(className= "product_sort_container")
    WebElement filter;	
	
	@FindBy(className = "shopping_cart_badge")
	WebElement cartCounter;
	
	
	public inventoryPage()throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	
//Actions	
	
	public String InventoryPageUrl() {
		return driver.getCurrentUrl();
	}
	public List<WebElement> addItemsToCart() {
		return addToCartButton;
	}
	 
	public List<WebElement> ValidateItemName() {
		return itemName;
	}           
    
	public List<WebElement> ValidateImagePresence() {	                       
		return itemImage;
	}
	
	public boolean ValidatePresenceOfCartIcon() {
		return cartIcon.isDisplayed();
	}
	
	public cartPage MovingToCart() throws IOException {
		cartIcon.click();
		return new cartPage(); 
	}
	
    public String ValidateCartCounter(){
			return cartCounter.getText();	
		}
    
    public WebElement  ValidateFilterSorting() {
       filter.click();
       return filter;
    }}
		
		
	
