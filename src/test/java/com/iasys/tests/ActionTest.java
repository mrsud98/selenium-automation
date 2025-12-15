package com.iasys.tests;

import org.testng.annotations.Test;

import com.iasys.base.BaseTest;
import com.iasys.pageObjects.DashboardPage;
import com.iasys.pageObjects.LoginPage;
import com.iasys.pageObjects.TestRequestPage;

//@Listeners({ExtentTestListener.class})
public class ActionTest extends BaseTest {
	
	@Test(priority=1, groups={"smoke","regresion"})
    public void actionTest() throws InterruptedException  {
		
		logger.info("************************Login Test start*****************************");
		LoginPage loginPage = new LoginPage(getDriver());
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        loginPage.login(username, password);
        DashboardPage dashboardPage =new DashboardPage(getDriver());
       // dashboardPage.verifyContextClick();
      //  dashboardPage.verifyDoubleClick();
        dashboardPage.verifyMousehover();
              
	}
  
	@Test(priority=2, groups={"smoke","regresion"})
    public void dragAndDropTest() throws InterruptedException  {
		
		logger.info("************************Login Test start*****************************");
		LoginPage loginPage = new LoginPage(getDriver());
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        loginPage.login(username, password);
        TestRequestPage testRequestPage = new TestRequestPage(getDriver());
        testRequestPage.dragAndDropTest();
	}	
	
	@Test(priority=3, groups={"smoke","regresion"})
    public void keyboardActionTest() throws InterruptedException  {
		
		logger.info("************************Login Test start*****************************");
		LoginPage loginPage = new LoginPage(getDriver());
        loginPage.keyBoardActionTest();
      
	}	

	

@Test(priority=1, groups={"smoke","regresion"})
public void scrollTest() throws InterruptedException  {
	
	logger.info("************************Login Test start*****************************");
	LoginPage loginPage = new LoginPage(getDriver());
    String username = properties.getProperty("username");
    String password = properties.getProperty("password");
    loginPage.login(username, password);
    DashboardPage dashboardPage =new DashboardPage(getDriver());
  
    dashboardPage.scrollToElement();
            
}



}


