package orange.hr.testcases;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import orange.hr.baseClass.Driversetup;
import orange.hr.employeeMng.Dashboard;
import orange.hr.employeeMng.employeeMngPage;


public class employeeMngtestclass extends Driversetup {
	
	Dashboard d;
	employeeMngPage emp;

	public employeeMngtestclass() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod // calling the driver from parent class(DriverBase class)	
	public void setUp() throws IOException  {	
		initialization();
		d = new Dashboard();// 
		emp = new employeeMngPage();
//		h =l.crdentials(p.getProperty("Username"), p.getProperty("Password"));		
	}
	
	@Test(priority =1)
	
	public void ValidateformOpening() throws IOException, InterruptedException{
		emp =emp.openForm();
		Thread.sleep(3000);
		System.out.println("opening the form");
	}
	
	@Test(priority = 2)
	public void validateNameFeilds() {
		
		emp.addNewEmployee();
		System.out.println(emp.getPlaceholders());
	}
	
	@Test(priority=3)
	public void ValidateDrodpdown() {
		emp.DrodpdownPlaceholder();// click and get the placeholder value 
		List<WebElement> Values = emp.validateDropdownValues();
		for( WebElement Value : Values ) {
			Value.click();
            System.out.println(Value.getText());
		}}
	
	@Test(priority =4)
	public void selectAllDatesFromCalendar() throws InterruptedException{
		emp.opencalendar();
		System.out.println("calenderopened");
		Thread.sleep(2000);
		List<WebElement> years= emp.selectYear();
		List<WebElement> months= emp.selectMonth();
		List<WebElement> dates = emp.currentMonthDates();
		for ( WebElement year : years ) {
		   year.click();
           System.out.println(year.getText());
           for(WebElement month : months) {
        	   month.click();
               System.out.println(month.getText());
               for(WebElement date: dates) {
            	  date.click();
                  System.out.println(date.getText());
               }
           }}
		}
		
	@Test(priority = 5)	
	private void selectSpecificDateFromCalendar() throws ParseException {
		Calendar c = Calendar.getInstance();
		
		String date =  TestData.inputDate;// get date from testData class 
		SimpleDateFormat a = new SimpleDateFormat("DD-MMMM-YYYY"); //converting that date from string format to date format 
	    a.setLenient(false);
		Date formattedDate= a.parse(date);
	    System.out.println(formattedDate);
// extracting day , month and year from formatted date , creating calendar class instance
	    c.setTime(formattedDate);
	    int formattedDay = c.get(Calendar.DAY_OF_MONTH);
	    int formattedMonth = c.get(Calendar.MONTH);
	    int formattedYear= c.get(Calendar.YEAR);
// select the parsed date in calendar
	    emp.opencalendar();//open the calendar
	    employeeMngPage.dynamicDateXpath(formattedDay);
	}
	
	@Test 
	public void validateMnadatoryFeild() {
	// softassert object for checking if the mandatory feilds are filled or not 
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(emp.Firstname().isBlank(), "True", "Firstname is required");
		softAssert.assertEquals(emp.LastName().isBlank(), "True",  "LastName is required");
		softAssert.assertEquals(emp.Location().isBlank(), "True",  "Location is required");
		softAssert.assertAll();
 }
	
}


