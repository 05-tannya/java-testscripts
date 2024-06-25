package orange.hr.employeeMng;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import orange.hr.baseClass.Driversetup;


	public class Dashboard extends Driversetup{
	 


		@FindBy(id = "menu_item_128")
		WebElement empMng;
		@FindBy(className= "punch-icons-wrapper")
		WebElement clockIcon;
			
		//initializing your page factory 
			public Dashboard() throws IOException {
				PageFactory.initElements(driver, this);
			}
				
		// actions 
			public employeeMngPage employmentModule() throws IOException {
		    empMng.click();
	        return new employeeMngPage();
	        }
			
			public Attendance_in_out clockIcon() throws IOException {
				clockIcon.click();
				return new Attendance_in_out();
			}
			
}

