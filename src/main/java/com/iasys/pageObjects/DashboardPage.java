package com.iasys.pageObjects;


import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {
 
	Actions actions;
    public DashboardPage(WebDriver driver) {
      super(driver);
      actions = new Actions(driver);
    }
	
	  // WebElements using PageFactory
	  
	  @FindBy(xpath = "//a[@id='administrator']") 
	  private WebElement administartorApp;

	  
	  @FindBy(xpath = "//button[@title='Notifications']") 
	  private WebElement notificationButton;
	  
	  @FindBy(xpath = "//a[contains(text(),'TestRequest') and contains(text(),'Approve')]") 
	  private WebElement testRequestLink;
	  
	  @FindBy(xpath ="//div[@class='e-spinner-pane e-spin-show']//div[@class='e-spinner-inner']//*[name()='svg']")
	  private WebElement spinner;
	  
	  @FindBy(xpath="//img[@data-testid=\"id_admin_dashboard_export_btn\"]")
	  private WebElement downloadBrixUsageTrend;
	  
	  @FindBy(xpath="//*[@id=\"appUtilization_Series_0_Point_7\"]")
	  private WebElement appUtilizationToolTip;
	  
    public void dashboradTest() throws InterruptedException {
    	 waitForSpinnerDisappear(spinner);
    
        clickElement(administartorApp);
        String mainWindow = driver.getWindowHandle();
        waitForSpinnerDisappear(spinner);
        clickElement(notificationButton);
        clickElement(testRequestLink);
        waitForSpinnerDisappear(spinner);
        
       Set<String> allWindow =driver.getWindowHandles();
        
        for(String window :allWindow)
        	
        {
        	 if (window.equals(mainWindow)) {
        	       driver.switchTo().window(window);
        	       System.out.println(driver.getCurrentUrl());
        }
       // driver.switchTo().window(mainWindow);
        Thread.sleep(5000);
            }
    }
        
      public void verifyContextClick() throws InterruptedException {
    	  waitForSpinnerDisappear(spinner);
    	  clickElement(administartorApp);
    	  waitForSpinnerDisappear(spinner);
    	  
    	  actions.contextClick(notificationButton).build().perform();
    	  Thread.sleep(5000);
    
}
      public void verifyDoubleClick() throws InterruptedException {
    	  waitForSpinnerDisappear(spinner);
    	  clickElement(administartorApp);
    	  waitForSpinnerDisappear(spinner);
    	  
    	  actions.doubleClick(downloadBrixUsageTrend).build().perform();
    	  Thread.sleep(5000);
    
}
      
      public void verifyMousehover() throws InterruptedException {
    	  waitForSpinnerDisappear(spinner);
    	  clickElement(administartorApp);
    	  waitForSpinnerDisappear(spinner);
    	 actions.moveToElement(downloadBrixUsageTrend).build().perform();
    	 Thread.sleep(5000);
    
}  
      
      public void scrollToElement() throws InterruptedException {
    	  waitForSpinnerDisappear(spinner);
    	  clickElement(administartorApp);
    	  waitForSpinnerDisappear(spinner);
    	 actions.scrollToElement(appUtilizationToolTip).perform();
    	 actions.moveToElement(appUtilizationToolTip).perform();
    	 Thread.sleep(5000);
}  
 
}
   