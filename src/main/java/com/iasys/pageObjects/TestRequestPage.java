package com.iasys.pageObjects;


import java.util.Set;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestRequestPage extends BasePage {
 
	Actions actions;
    public TestRequestPage(WebDriver driver) {
      super(driver);
      actions = new Actions(driver);
    }
	
	  // WebElements using PageFactory
	  
	  @FindBy(xpath = "//a[@id='testdatamanagement']") 
	  private WebElement testDataManagement;

	  @FindBy(xpath ="//div[@class='e-spinner-pane e-spin-show']//div[@class='e-spinner-inner']//*[name()='svg']")
	  private WebElement spinner;
	  
	  @FindBy(xpath="//span[@title='Visualization']")
	  private WebElement visualizationButton;
	  
	  @FindBy(xpath="//*[@title='Line Chart']")
	  private WebElement lineChart;
	  
	  @FindBy(className="gridContainer")
	  private WebElement gridContainerForDrop;
	
	  
    public void dragAndDropTest() throws InterruptedException {
    	waitForSpinnerDisappear(spinner);
        clickElement(testDataManagement);
        waitForSpinnerDisappear(spinner);
        clickElement(visualizationButton);
        actions.dragAndDrop(lineChart,gridContainerForDrop).build().perform();
  	   Thread.sleep(5000);
       
    }

}
   