package com.iasys.tests;

import org.testng.annotations.Test;

import com.iasys.base.BaseTest;
import com.iasys.pageObjects.LoginPage;
import com.iasys.pageObjects.UsersPage;

//@Listeners({ExtentTestListener.class})
public class UsersTest extends BaseTest {
	
	@Test()
    public void verifyLoginUserTest() throws InterruptedException  {
		
		logger.info("************************Login Test start*****************************");
		LoginPage loginPage = new LoginPage(getDriver());
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        loginPage.login(username, password);
        
        UsersPage usersPage =new UsersPage(getDriver());
        usersPage.createUserTest();
        
	}
		
}
	













