package orange.hr.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import orange.hr.baseClass.Driversetup;

import orange.hr.employeeMng.Dashboard;
import orange.hr.employeeMng.LoginPage;


public class LoginTestClass extends Driversetup {
	
	Dashboard d;
	LoginPage l ;

	public LoginTestClass() throws IOException {
		super();
	}
	 
	
	@BeforeMethod
	public void setUp() throws IOException  {	
		initialization();
		l = new LoginPage();
		//d=new Dashboard();
	}
	
	@DataProvider(name= "credentails-dataprovider")
	public static Object[][] crdentials(){
		return TestData.crdentials();
	}
	
	@Test( priority= 2)
	public void VerifyLogo() {
		Assert.assertEquals(l.Logo(), true );		
	}
	
	@Test(priority = 1)
	public void VerifyTitle() {
		Assert.assertEquals(l.getTitle(), "OrangeHRM");
	}
	
	@Test(priority = 3, dataProvider = "credentails-dataprovider")
	public void VerifyLoginProcess(String Cred1 , String Cred2) throws IOException {
		d= l.login(Cred1, Cred2);
	}
	

}
