package ecom.page.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import e.com.base.DriverBase;
import e.com.pages.inventoryPage;
import e.com.pages.loginPage;
import e.com.testdata.testData;



public class loginPageTest extends DriverBase {

	inventoryPage h;
	loginPage l;
	
	//the initialtization method in base class is calling for properties file , thus creating a constructor and calling the properties with help of SUPER 	
	public loginPageTest() throws Exception {
		super();
	}
	
	@BeforeMethod // calling the driver from parent class(DriverBase class)	
	public void setup() throws IOException  {	
		initialization();
		l = new loginPage(); //creating the object of login page class , so that we can access the locaters and actions of all the elements present there 
	}

	@Test(priority =1)
	public void validatePageTitleTest() {
		String titleName =l.validateTitle();// login page class method
		Assert.assertEquals(titleName, "Swag Labs");
	}
	
	@Test(priority=2)
	public void validateLogoPresenceTest() {
		boolean logo =l.validateLogo();
		Assert.assertEquals(logo, true);
	}
	
	@DataProvider(name = "credentialsProvider")
	public Object[][] provideCredentials() {
	//	testData m = new testData();
	return testData.provideCredentials();
//	    return testData.provideCredentials();
    }
      	                         
	@Test(priority=3 , dataProvider = "credentialsProvider")
	public void validateCredentialsTest(String username , String password ) throws IOException {
		// h=l.crdentials(p.getProperty("Username"), p.getProperty("Password"));//method is returning home page class object (check from loginpage), thus saving it's value in homepage datatype 
		 h=l.crdentials(username , password );       
		 System.out.println("sucessful login with valid credentials");
	}
	@Test(priority= 4 , dataProvider = "credentialsProvider" )
	public void missingCredentialTest(String username , String password) throws IOException {
		h= l.crdentials(username, password);
		String z = l.validateErrorText();
		if(username.isBlank()|| password.isBlank()) {
		 System.out.println(" unable to login due to missing credentials");	
		    if (username.isBlank()) {
		    	Assert.assertEquals(z, "Epic sadface: Username is required");
		     }
		    else { Assert.assertEquals(z, "Epic sadface: Password is required");}
		}
		else {
			System.out.println("sucessful login ");
		}		
	}
	
	@AfterMethod
		public void tearDown() {
	    driver.close();
	   
	}

	

}
