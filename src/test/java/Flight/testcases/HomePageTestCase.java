package Flight.testcases;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import BaseClass.DriverSetup;
import Flight.Pages.HomePage;
import Flight.Pages.TestData;
import Flight.testdata.utilityTestData;


public class HomePageTestCase extends DriverSetup {
	
	 HomePage h;
	 
	 ExtentReports extent = new ExtentReports();
	 // want to change the view order of my report and also want to remove some of the tabs . Use viewconfigure()
	 ExtentSparkReporter spark = new ExtentSparkReporter("ExtentTest.html").viewConfigurer().viewOrder().as(new ViewName[] {ViewName.DASHBOARD, ViewName.TEST, ViewName.LOG, ViewName.CATEGORY}).apply();
	 // Filtering out the failed and skipped test cases || generating multiple reports in one go 
//	 ExtentSparkReporter FailSpark = new ExtentSparkReporter("FailTestCases.html").filter().statusFilter()
//		.as(new Status[] {Status.PASS}).apply();
	 	
	public HomePageTestCase() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod // calling the driver from parent class(DriverBase class)	
	public void setUp() throws IOException  {	
		initialization();
		h = new HomePage();     
		extent.attachReporter(spark);   		
		ExtentReports extent = new ExtentReports();
        

		
//		FailSpark.config().setDocumentTitle("Title-failed& skipped ");
//		FailSpark.config().setReportName("EXTENT REPORT TESTCASES");
	}
	
	
	/*@Test (priority =1)
	public void dropdownValueInputtedByUser() {
		ExtentTest test = extent.createTest("destination value inputted by user").assignAuthor("tester 1").assignDevice("desktop");
		test.info("opening the dropdown");
		h.openDestDropDown();
		test.info("getting data from user");
		String destlocat = TestData.destlocation;
		h.getLocationFromUser(destlocat);
		test.pass(destlocat + " is selected as destination");
		//changing the color of log item using MARKUPHELPER class
		test.pass(MarkupHelper.createLabel("destination value is selected", ExtentColor.GREEN));
	    test.pass(MarkupHelper.createTable(TestData.data));
	
	} */
	
	
	
/*	@Test	(priority=2)
	public void getAllDestinationDropdownValues() {
		ExtentTest test = extent.createTest("get all destination dropdown values ").assignAuthor("tannya").assignDevice("desktop");
		h.openDestDropDown();
		List<WebElement> locations = h.getAllLocations();
		for (WebElement location : locations) {
			test.pass("the location is " + location.getText() + "+++++");			
		//making a table in extent report using MARKUP HELPER class  
		 test.pass(MarkupHelper.createTable(TestData.data));
	
		 
		}}
	*/
  
  /* @Test (priority=2)
    public void VerifyOneWayTrip() {
	   ExtentTest test = extent.createTest("verify return date for one way trip");	
	   test.info("select the one way radio button");
	   h.OneWayTrip();	 
	   test.info("verify the return date");
	   Assert.assertFalse(h.inactiveReturnDate(), "return date should be inactive for ONE WAY TRIP"); 
	   test.log(Status.FAIL, "return date is inactive"); 
	   }  */
    
 /*        @Test
   public void VerifyRoundTrip() {
       ExtentTest test = extent.createTest("verify the active return date for round trip");
       test.info("click on the radio button");
	   h.roundTrip();
	   test.info("check the presence of return date");
	   Assert.assertTrue(h.activerReturnDate(), "user should be able to select the return date for ROUND TRIP"); 
	   test.pass("user able to select the return date");
	   test.log(Status.PASS, "status pass");
	   
         } */
	
	/*@DataProvider (name ="getdatafromExcel")
	public Object [][] getdatafromExcel(){
		
		Object[][] data = utilityTestData.getTestData("FlightData");
		return data;	
	}
	
	@Test(dataProvider ="getdatafromExcel")
	public void UsingDataProvider(String Destination , String currency) {
		
		ExtentTest test = extent.createTest("verify the data coming from the excel sheet");	
		//open destination dropdown 
		h.openDestDropDown();
		//select the destination value from the excel 
		h.getLocationFromUser(Destination);
		System.out.println("the selected destination is" + Destination);
		test.pass("test case passed , data is added from the excel to the application");
	
	}*/
	
	@Test
	public void returnCalenderUsingDataProvider() throws ParseException {
		Calendar c =  Calendar.getInstance();
		String Date = TestData.date;
/*		SimpleDateFormat s = new SimpleDateFormat("DD-MMMM-YYYY");
		s.setLenient(false);*/
		
		Date date = c.getTime();
		String formattedDate = new SimpleDateFormat("DD-MMMM-YYYY").format(date);
		System.out.println(formattedDate);
		
		
int formattedDay	=c.get(Calendar.DAY_OF_MONTH);
int formattedMonth	=c.get(Calendar.MONTH);
int formattedYear	=c.get(Calendar.YEAR);
System.out.println(formattedDay);
System.out.println(formattedMonth);
System.out.println(formattedYear);
    h.ClickOnReturnCalender();
//    h.returnCalendarMonthandYear("formattedMonth");
	h.returnCalendarDate(formattedDay);

		
	}
  
   @AfterMethod
   public void teardown() throws IOException {
       extent.flush();
    /*   Desktop.getDesktop().browse(new File("ExtentTest.html").toURI());
    //   Desktop.getDesktop().browse(new File("FailTestCases.html").toURI()); */
      /* driver.quit();*/
	   
   } 
  
}
