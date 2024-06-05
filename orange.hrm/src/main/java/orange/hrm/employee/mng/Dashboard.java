package orange.hrm.employee.mng;

	
	import java.io.IOException;

	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import orange.hrm.baseclass.Driversetup;
	
	public class Dashboard extends Driversetup{

	 
		public Dashboard() throws IOException {
			super();
			// TODO Auto-generated constructor stub
		}


		@FindBy(id = "menu_item_128")
		WebElement empMng;
			
		//initializing your page factory 
			public void Dashborad() throws IOException {
				PageFactory.initElements(driver, this);
			}
				
		// actions 
			
			public employeeMngPage employmentModule() throws IOException {
				empMng.click();
	        return new employeeMngPage();
			}
			
}
	
