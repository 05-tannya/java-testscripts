package orange.hr.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import orange.hr.baseClass.Driversetup;
import orange.hr.employeeMng.Attendance_in_out;
import orange.hr.employeeMng.Dashboard;
import orange.hr.employeeMng.employeeMngPage;

public class dashboardtestclass extends Driversetup {
	Dashboard d;
	employeeMngPage emp;
	Attendance_in_out att;

	public dashboardtestclass() throws IOException {
		super();}
	@BeforeMethod
	public void setUp() throws IOException  {	
		initialization();
		d = new Dashboard();// 
		emp = new employeeMngPage();
		att = new Attendance_in_out();			}
	
	@Test 
	public void navigationOfClockIcon() throws IOException {
		att = d.clockIcon();
		System.out.println("naviagte to attendance page");
		
	}
	

}
