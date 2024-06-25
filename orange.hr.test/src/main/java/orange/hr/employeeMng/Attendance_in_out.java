package orange.hr.employeeMng;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import orange.hr.baseClass.Driversetup;

public class Attendance_in_out extends Driversetup {
	
	

	public Attendance_in_out() throws IOException {
			PageFactory.initElements(driver, this);
			}

}
