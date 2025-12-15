package com.iasys.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.iasys.base.BaseTest;
import com.iasys.pageObjects.DashboardPage;
import com.iasys.pageObjects.LoginPage;

//@Listeners({ExtentTestListener.class})
public class HandlingMultipleWindow extends BaseTest {
	
	@Test(priority=3, groups={"smoke","regresion"})
    public void windowNavigationTest() throws InterruptedException  {
		
		logger.info("************************Login Test start*****************************");
		LoginPage loginPage = new LoginPage(getDriver());
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        loginPage.login(username, password);
        
        DashboardPage dashboardPage =new DashboardPage(getDriver());
        dashboardPage.dashboradTest(); 
        String currentUrl =getDriver().getCurrentUrl();
        String requireURL ="https://172.16.48.133:9086/brix/platform/administrator/dashboard";
        Assert.assertEquals(currentUrl, requireURL);
        
	}
		
}
	













