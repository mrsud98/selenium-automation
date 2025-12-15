package com.iasys.pageObjects;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	    WebDriver driver;
	    protected WebDriverWait wait;
	    Wait<WebDriver> fWait;
	    
		public BasePage(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(100))
				.ignoring(NoSuchElementException.class);
		PageFactory.initElements(driver, this);
		
		}
		
		protected void clickElement(WebElement element) {
			
			try {
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector("div.e-spinner-pane.e-spin-show"))));
			}
			
			catch(NoSuchElementException e){
				
				System.out.println("No spinner here");
				
			}
			
			finally {
			
			
		  wait.until(ExpectedConditions.elementToBeClickable(element)).click();

	    }}
		
		protected void typeText(WebElement element, String text) {
		    WebElement el = wait.until(ExpectedConditions.visibilityOf(element));
		    el.clear(); // Clear any existing text
		    el.sendKeys(text); // Type the new text
		}


	    protected String getPageTitle() {
	        return driver.getTitle();
	    }

	    protected void waitForVisibility(WebElement element) {
	        wait.until(ExpectedConditions.visibilityOf(element));
	    }
	    
	    
	    protected void waitForSpinnerDisappear(WebElement element) {
	    	wait.until(ExpectedConditions.invisibilityOf(element));
	    	
	    }
	    
	}
		
		
	
	

	

