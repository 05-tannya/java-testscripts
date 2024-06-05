package e.com.testdata;

public class testData  {
	
	public static Object[][] provideCredentials() {
	    return new Object[][] {
        {"standard_user", "secret_sauce" }, // validateCredentialsTest
        {"locked_out_user", "secret_sauce"}, // locked user test 
        {""  , "secret_sauce"},              //missingCredentialTest
        {"standard_user" , ""},              //missingCredentialTest

        };}
}

