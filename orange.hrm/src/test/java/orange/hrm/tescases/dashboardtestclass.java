package orange.hrm.tescases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import e.com.testdata.testData;
import orange.hrm.baseclass.Driversetup;
import orange.hrm.employee.mng.Dashboard;
import orange.hrm.employee.mng.employeeMngPage;

public class dashboardtestclass extends Driversetup{
	
	Dashboard d;
	employeeMngPage emp;
	loginPage l;
	
	public dashboardtestclass() throws IOException {
		super();
	}
	
	
	@BeforeMethod // calling the driver from parent class(DriverBase class)	
	public void setUp() throws IOException  {	
		
		initialization();
		d = new Dashboard();// before going to inventory screen we have to login into the app 
		emp = new employeeMngPage();
		h =l.crdentials(p.getProperty("Username"), p.getProperty("Password"));		
	}
	
/*	@DataProvider(name = "employeeInfo")
	public Object[][] employeeInfo() {
		return testData.employeeInfo();
	    }
*/
	@Test(priority =2 )// Handling light box 
	public void moveToEmployeeMngPage() {
		emp =d.employmentModule();
	}

}
