package com.iasys.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.iasys.base.BaseTest;
import com.iasys.pageObjects.LoginPage;
import com.iasys.utilities.DataProviders;

//@Listeners({ExtentTestListener.class})
public class LoginTest extends BaseTest {
	
	@Test(priority=3, groups={"smoke","regresion"})
    public void loginWithValidCredentials()  {
		
		logger.info("************************Login Test start*****************************");
		 LoginPage loginPage = new LoginPage(getDriver());
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        loginPage.login(username, password);

        // Assertion or next step
        Assert.assertFalse(loginPage.isLogoutButtonDisplayed(), "Logout button should be visible after login");
        String title =getDriver().getTitle();
        System.out.println(title);
              
      //  ExtentReportManager.pass("Login test executed successfully");
    }
    
    
	@Test(priority=2, groups={"sanity"})
	public void loginWithInValidCredentials() throws InterruptedException {
		 LoginPage loginPage = new LoginPage(getDriver());
        String url = properties.getProperty("baseUrl");
        String username = properties.getProperty("invalidUserName");
        String password = properties.getProperty("password");
        loginPage.login(username, password);
	
        Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "Login button should be visible if login not possible");
	}

	@Test(dataProvider = "loginData", dataProviderClass = DataProviders.class,priority = 3)
	          
	    public void loginWithMultipleUsers(String username, String password, String expectedResult) {

	        logger.info("************************Login Test start*****************************");
	        LoginPage loginPage = new LoginPage(getDriver());
	        loginPage.login(username, password);

	        if(expectedResult.equalsIgnoreCase("success")) {
	            Assert.assertFalse(loginPage.isLogoutButtonDisplayed(), "Logout button should be visible after login");
	        } else {
	            Assert.assertFalse(loginPage.isLogoutButtonDisplayed(), "Login should fail for invalid credentials");
	        }

	        String title = getDriver().getTitle();
	        System.out.println("Page title: " + title);
	    }
		
}
	













