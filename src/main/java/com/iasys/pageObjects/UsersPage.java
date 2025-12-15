package com.iasys.pageObjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class UsersPage extends BasePage {
 
	Actions actions;
    public UsersPage(WebDriver driver) {
      super(driver);
      actions = new Actions(driver);
    }
	  // WebElements using PageFactory
	  
	  @FindBy(xpath = "//a[@id='administrator']") 
	  private WebElement administartorApp;
	  
	  @FindBy(xpath ="//div[@class='e-spinner-pane e-spin-show']//div[@class='e-spinner-inner']//*[name()='svg']")
	  private WebElement spinner;
	  
	  @FindBy(xpath = "//a[normalize-space()='User management']") 
	  private WebElement userMNGMNT;
	  
	  @FindBy(id = "adduser-target") 
	  private WebElement createUser;
	  
	  @FindBy(xpath = "//span[contains(@class,'userDropDown')]") 
	  private WebElement userTypeDropdown;
	  
	  @FindBy(xpath = "//li[text()='LDAP']") 
	  private WebElement ldapUser	;
	  
	  @FindBy(xpath = "//li[@class='e-list-item' and text()='LDAP']") 
	  private WebElement ldapUser2	;
		
	  @FindBy(xpath="//tr[@role='row']") 
	  private WebElement tableContent;
	  
	  @FindBy(xpath="//a[text()='Roles']") 
	  private WebElement roles;
	  
	  @FindBy(xpath="//a[@id='scheduler']") 
	  private WebElement scheduler;
	  
	  @FindBy(xpath="//i[@data-test-id='id_admin_usermgmt_users_usercardview']") 
	  private WebElement userCard;
	  
	  
	  
	public void createUserTest() {
		
	     clickElement(administartorApp);
	     clickElement(userMNGMNT);
	    // clickElement(createUser);
	     clickElement(administartorApp);
	     clickElement(userMNGMNT);
	     clickElement(userCard);
	     clickElement(administartorApp);
	     clickElement(userMNGMNT);
	     clickElement(userCard);
	    
	}
	 
    public void userDropdownTest() throws InterruptedException {
    	 waitForSpinnerDisappear(spinner);
        clickElement(administartorApp);
        waitForSpinnerDisappear(spinner);
        clickElement(userMNGMNT);
        waitForSpinnerDisappear(spinner);
        clickElement(createUser);
        waitForSpinnerDisappear(spinner);
        clickElement(userTypeDropdown);
        Thread.sleep(5000);
        clickElement(ldapUser2);
        
        Thread.sleep(5000);
        
        }
    
    
    public void verifyTableRaed()throws InterruptedException {
   	 waitForSpinnerDisappear(spinner);
     clickElement(administartorApp);
     waitForSpinnerDisappear(spinner);
     clickElement(userMNGMNT);
     waitForSpinnerDisappear(spinner);
     clickElement(roles);
     
     WebElement table = driver.findElement(By.id("roleMainGridContent_content_table"));

     List<WebElement> rows = table.findElements(By.cssSelector("tbody tr.e-row, tbody tr.e-altrow"));
     
     System.out.println("Total Rows: " + rows.size());
    
     for (int i = 0; i < rows.size(); i++) {
    	    WebElement row = rows.get(i);
    	    
    	 // Get all cells except the action column (last <td>)
    	    List<WebElement> cells = row.findElements(By.cssSelector("td.e-rowcell"));

    	    System.out.print("Row " + (i + 1) + ": ");
    	    
    	    
    	    for (WebElement cell : cells) {
    	        System.out.print(cell.getText().trim() + " | ");
    	    }

    	    System.out.println();
    
    Thread.sleep(5000);
    
}
    
}}
   