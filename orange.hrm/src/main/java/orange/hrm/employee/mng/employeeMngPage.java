package orange.hrm.employee.mng;

import java.io.IOException;
import java.time.Month;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import orange.hrm.baseclass.Driversetup;

public class employeeMngPage extends Driversetup {
	

	@FindBy(xpath = "//a[@id='addEmployeeButton']/i")
	WebElement AddIcon; 
	
	@FindBy (id = "first-name-box")
	WebElement FirstName;
	
	@FindBy (id = "middle-name-box")
	WebElement MiddleName;
	
	@FindBy (id = "last-name-box")
	WebElement LastName;
	
	@FindBy (css = ".dropdown-toggle")
	WebElement locationDropdown;
	
	@FindBy(xpath="//div[@class ='filter-option-inner-inner']")
	WebElement placeholder;
	
	@FindBy ( css = ".btn.date-picker-button")
	WebElement Calender;
	
	@FindBy(xpath = "//span[@class='text']")
	List<WebElement> dropdownValues;
	
	@FindBy (id= "modal-save-button")
	WebElement NextButton;
	
	@FindBy(className ="btn btn-ghost")
	WebElement CancelButton;
	
/*	@FindBy(xpath = "//div[contains(@class, 'picker__day picker__day--infocus') and contains(text(),'" + formattedDay + "')]")
	WebElement dynamicDateValue;//dynamic values in the xpath for the current month */
	
	@FindBy(xpath= "//tbody/tr/td/div[not(contains(@class,\"pickadate--weekend\"))]")// written the xpath for weekend dates , then negated it to get the weekdays
	List<WebElement> datesOfSelectedMonth;
	
	@FindBy(xpath= "//select[@title ='Select a year']")
	WebElement YearDropdown;
	
	@FindBy (xpath = "//a[contains(@id, 'bs-select-8')]")
	List<WebElement> YearDrodpdownValues;
	
	@FindBy(xpath = "//select[@title ='Select a month']")
	WebElement MonthDRopdown;
	
	@FindBy(xpath= "//select/option[@value = '+ TestData.dynamicvalue +']")//adding dynamic value to the xpath 
	List<WebElement> MonthDropDownValues;
	
	@FindBy(xpath = "//span[contains( text(), 'Required')]")
	WebElement Required;
	
	
	public employeeMngPage()throws IOException {
		PageFactory.initElements(driver, this);}
	
    public employeeMngPage openForm() throws IOException {
    	AddIcon.click();
		return new employeeMngPage();
    }
    
	public void addNewEmployee() {
    	FirstName.sendKeys("Tannya");
    	MiddleName.sendKeys("Mittal");
    	LastName.sendKeys("test");       	
	    }

    public String Firstname() {// method created to validate mandatory filed 
    	FirstName.sendKeys("test121");
    	String value = FirstName.getText();
    	return value ;
    }
    public String LastName() {// method created to validate mandatory field 
    	LastName.sendKeys("   ");
    	String value2 = FirstName.getText();
    	return value2 ;
    }
    public String Location() {
       String value3 =locationDropdown.getText();
    	return value3;
    }
    
    public String getPlaceholders() {
    	String Holder = "element1"+ FirstName.getAttribute("placeholder") + "Element2" +MiddleName.getAttribute("placeholder")+ "element3"+LastName.getAttribute("placeholder");
    	return Holder;} 

	public String DrodpdownPlaceholder() {	
    	locationDropdown.click();
    	return placeholder.getText(); 	
    }
    
    public List<WebElement> validateDropdownValues(){
        return dropdownValues;
    }
    
    public void opencalendar() {
     	Calender.click();
    }
    
    public List<WebElement> currentMonthDates() {// get current month dates excluding weekends  	
    	return datesOfSelectedMonth;
    }
    
    public List<WebElement> selectYear(){
        YearDropdown.click();
        return YearDrodpdownValues;
    }
    
    public List<WebElement> selectMonth(){
        MonthDRopdown.click();
        return MonthDropDownValues;
    }
    
    public static void dynamicDateXpath(int x) {//wanted to use formatted date varaible in xpath == created static parameterized method with xpath in it , then called the method in testclass using classname.method name 
        driver.findElement(By.xpath("//div[contains(@class, 'picker__day picker__day--infocus') and contains(text(),'" +x+ "')]")).click();      
    }
    
    public void SubmitForm() {
    	NextButton.click();
    }

	public String GetRequiredText() {
		String errortext = Required.getText();
		return errortext ;// for the mandatory fields 
		
	}
	
}
