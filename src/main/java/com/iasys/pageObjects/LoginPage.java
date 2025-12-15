package com.iasys.pageObjects;


import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
 
	Actions actions;
    public LoginPage(WebDriver driver) {
      super(driver);
      actions = new Actions(driver);
   
    }
	
	  // WebElements using PageFactory
	  
	  @FindBy(xpath = "//input[@placeholder='Username']") private WebElement
	  usernameInput;
	  
	  @FindBy(xpath = "//input[@placeholder='Password']") private WebElement
	  passwordInput;
	  
	  @FindBy(xpath = "//button[@class='btn btn-warning w-100']") private
	  WebElement loginBtn;
	  
	  @FindBy(id = "details-button") private WebElement proceedButton;
	  
	  @FindBy(id = "proceed-link") private WebElement proceedLink;
	  
	  @FindBy(xpath = "//img[@alt='logout']") private WebElement logoutButton;
	  
	  @FindBy(xpath="//span[@role='combobox']") private WebElement languageButton;
	  
	  @FindBy(xpath="//span[@data-testid='id_loader_loginform_view_license']")
	  private WebElement ViewLicenceLink;
	  
	  @FindBy(id="search") private WebElement serachBoxFromSessionStatus;
	  
	  @FindBy(xpath="//button[normalize-space()='Yes']") private WebElement
	  ConcurentLoginYesButton;
	 
    
 // Locators using By instead of PageFactory

   
    
        // Login Method
    public void login(String username, String password) {
        
       typeText(usernameInput, username);
       typeText(passwordInput, password);
        clickElement(loginBtn);
       handleConcurrentLoginPopupIfPresent();
       
    }
     
    public boolean isLogoutButtonDisplayed() {
    	
    	return logoutButton.isDisplayed();
    	
            }
    
    public boolean isLoginButtonDisplayed() {
    	return loginBtn.isDisplayed();
        
    }
    public  boolean isLanguageButtonDisplayed() {
        	return languageButton.isDisplayed();
    	  
        }
    
   public void keyBoardActionTest() throws InterruptedException {
	   usernameInput.sendKeys("Selenium");
	 //  usernameInput.sendKeys(Keys.ENTER);
	   actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
	   
	   Thread.sleep(5000);
   }
    
    private void handleConcurrentLoginPopupIfPresent() {
        try {
            wait.until(ExpectedConditions.visibilityOf(ConcurentLoginYesButton));
            if (ConcurentLoginYesButton.isDisplayed()) {
            	ConcurentLoginYesButton.click();
                System.out.println("Concurrent login popup appeared. Clicked 'Yes'.");
            }
        } catch (TimeoutException e) {
            System.out.println("Concurrent login popup not displayed — continuing normal flow.");
        }
    }
}
    

    
