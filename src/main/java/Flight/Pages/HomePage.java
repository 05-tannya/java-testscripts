package Flight.Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.DriverSetup;

public class HomePage extends DriverSetup {

		
	@FindBy(xpath = "//div[@data-testid ='to-testID-destination']")
	WebElement destination;
	
	@FindBy(className = ".css-76zvg2.r-cqee49.r-ubezar.r-1kfrs79")
	List<WebElement> destdropdownvalues; 
	
	@FindBy(xpath ="//div[contains(@class, 'css-76zvg2 r-cqee49 r-ubezar r-1kfrs79')]")
	List<WebElement> Locations;
	
	@FindBy(xpath ="//div[@data-testid = 'return-date-dropdown-label-test-id']")
	WebElement returnDate;
	
	@FindBy(xpath = "//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79']")
	WebElement CalenderMonthndYear;
	
	@FindBy(xpath = "//divcontains(@class = 'css-1dbjc4n r-1awozwy r-1pi2tsx r-1777fci r-13qz1uu') and contains(@text(), + x +")
	WebElement CalenderDates;
	
	@FindBy(xpath ="//div[contains(@data-testid, 'return-date-dropdown-label-test-id') and contains(@class, 'r-14lw9ot')]")
	WebElement ActiveReturnDate;
	
	@FindBy(xpath = "//div[@data-testid ='round-trip-radio-button']")
	WebElement roundTrip;
	
	@FindBy(xpath = "//div[@data-testid='one-way-radio-button']")
	WebElement oneWayTrip;
	
	public HomePage()throws IOException {
		PageFactory.initElements(driver, this);}
	
	
	public void openDestDropDown() {
		destination.click();
	}
	
	public void  getLocationFromUser(String Destination) {
		driver.findElement(By.xpath("//div[contains(@class, 'css-76zvg2 r-cqee49 r-ubezar r-1kfrs79') and contains(text(),'"+ Destination +"')]")).click();	}	

	public List<WebElement> getAllLocations() {
		return Locations;
	}
	public boolean inactiveReturnDate() {
	   return !ActiveReturnDate.isEnabled();	
	} 
	
	public boolean OneWayTrip() {
		boolean onewayRadio = oneWayTrip.isSelected();
		return onewayRadio;	
	}
	
	public void roundTrip() {
		roundTrip.click();		
	}
	
	public boolean activerReturnDate(){
		return ActiveReturnDate.isEnabled();
	} 
	
	public void ClickOnReturnCalender() {	
		returnDate.click();		
	}
	
	public void returnCalendarDate(int x) {
	driver.findElement(By.xpath ( "//div[contains(@class ,'css-76zvg2 r-homxoj r-ubezar r-16dba41')and contains (text() , '"+x+"')]")).click();		
	}
	
	public void returnCalendarMonthandYear(String z) {
		driver.findElement(By.xpath("//div[contains(@class ,'css-76zvg2 r-homxoj r-adyw6z r-1kfrs79') and contains (text() , '"+z+"')]")).click();
	}
	
	
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	


