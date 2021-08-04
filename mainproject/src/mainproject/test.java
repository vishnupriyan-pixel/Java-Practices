package mainproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class test {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/home/zoho/Downloads/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		WebDriver driver = new ChromeDriver(options);
		
		String sample = "https://www.testandquiz.com/selenium/testing.html";
		
		driver.get(sample);
		
		///URL check
		
		WebElement link1 = driver.findElement(By.cssSelector(".col-md-12 a"));
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		link1.click();
		Thread.sleep(1000);
		
		
		
		 String ActualData = "https://www.javatpoint.com/";
	     String ExpectedData = driver.getCurrentUrl();
	     driver.manage().timeouts().implicitlyWait(1500,TimeUnit.MILLISECONDS);
	     
	    try {
	    Assert.assertEquals(ActualData, ExpectedData);
	     System.out.println("Current Url is: Pass");
	    }
	    catch(AssertionError e){
	    	System.out.println("Fail");	
	    }
	    
	    driver.navigate().back();  
		
		///textBox check
		
		WebElement txt1 = driver.findElement(By.xpath("//*[@id=\"fname\"]"));
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		txt1.click();
		txt1.clear();
		txt1.sendKeys("testCase");
		Thread.sleep(1200);
		
	    ActualData = "testCase";	
        ExpectedData = txt1.getAttribute("value");
//       System.out.println(ExpectedData);
       
       try {
   		Assert.assertEquals(ActualData, ExpectedData);
   		System.out.println("A Text Written in the Textbox : Pass");
   	}
   	catch(AssertionError e) {
   		System.out.println("Fail");
   	}
		
		driver.navigate().refresh();
		
		///buttonCheck
		
		WebElement btn = driver.findElement(By.xpath("//*[@id=\"idOfButton\"]"));
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		btn.click();
		Thread.sleep(1200);
		
		 ActualData = "button";
	     ExpectedData = btn.getAttribute("type");
//	       System.out.println(ExpectedData);
	       
	       try {
	   		Assert.assertEquals(ActualData, ExpectedData);
	   		System.out.println("A button is clicked : Pass");
	   	}
	   	catch(AssertionError e) {
	   		System.out.println("Fail");
	   	}
	       
		
		
		
		driver.navigate().refresh();
		
		
		///radioButtonsCheck
	
		WebElement rdbt = driver.findElement(By.xpath("//*[@value=\"male\"]"));
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		rdbt.click();
		Thread.sleep(1200);
		
		 ActualData = "radio";
	     ExpectedData = rdbt.getAttribute("type");
//	       System.out.println(ExpectedData);
	       
	       try {
	   		Assert.assertEquals(ActualData, ExpectedData);
	   		System.out.println("A male radio button clicked : Pass");
	   	}
	   	catch(AssertionError e) {
	   		System.out.println("Fail");
	   	}
	       
		driver.navigate().refresh();
		
		
		WebElement rdbt1 = driver.findElement(By.xpath("//*[@value=\"female\"]"));
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		rdbt1.click();
		Thread.sleep(1200);
		
		ActualData = "radio";
	     ExpectedData = rdbt1.getAttribute("type");
//	       System.out.println(ExpectedData);
	       
	       try {
	   		Assert.assertEquals(ActualData, ExpectedData);
	   		System.out.println("A female radio button clicked : Pass");
	   	}
	   	catch(AssertionError e) {
	   		System.out.println("Fail");
	   	}
		
		driver.navigate().refresh();
		
		///checkBox
		
		WebElement chck = driver.findElement(By.xpath("//*[@value=\"Automation\"]"));
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		chck.click();
		Thread.sleep(1200);
		
		ActualData = "checkbox";
	     ExpectedData = chck.getAttribute("type");
//	       System.out.println(ExpectedData);
	       
	       try {
	   		Assert.assertEquals(ActualData, ExpectedData);
	   		System.out.println("first checkbox : Pass");
	   	}
	   	catch(AssertionError e) {
	   		System.out.println("Fail");
	   	}
		
		driver.navigate().refresh();
		
		
		WebElement chck1 = driver.findElement(By.xpath("//*[@value=\"Performance\"]"));
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		chck1.click();
		Thread.sleep(1200);
		
		ActualData = "checkbox";
	     ExpectedData = chck1.getAttribute("type");
//	       System.out.println(ExpectedData);
	       
	       try {
	   		Assert.assertEquals(ActualData, ExpectedData);
	   		System.out.println("second checkbox : Pass");
	   	}
	   	catch(AssertionError e) {
	   		System.out.println("Fail");
	   	}
		
		driver.navigate().refresh();
		
		//dropDown
		

		 Select drp = new Select(driver.findElement(By.xpath("//*[@id=\"testingDropdown\"]")));
		    drp.selectByVisibleText("Automation Testing");
		   
				driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		

	 ActualData = "Automation Testing";
     ExpectedData = drp.getFirstSelectedOption().getText();
//     System.out.println( ExpectedData);
	       
	       try {
	   		Assert.assertEquals(ActualData, ExpectedData);
	   		System.out.println("Dropdown option1 is selected : Pass");
	   	}
	   	catch(AssertionError e) {
	   		System.out.println("Fail");
	   	}
	       
	    
	  
		drp.selectByIndex(1);
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			
			
			ActualData = "Performance Testing";
		     ExpectedData = drp.getFirstSelectedOption().getText();
//		       System.out.println(ExpectedData);
		       
		       try {
		   		Assert.assertEquals(ActualData, ExpectedData);
		   		System.out.println("Dropdown option2 is selected : Pass");
		   	}
		   	catch(AssertionError e) {
		   		System.out.println("Fail");
		   	}
		       
		   
		       drp.selectByIndex(2);
				driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
				
				
				ActualData = "Manual Testing";
			     ExpectedData = drp.getFirstSelectedOption().getText();
//			      System.out.println(ExpectedData);
			       
			       try {
			   		Assert.assertEquals(ActualData, ExpectedData);
			   		System.out.println("Dropdown option3 is selected : Pass");
			   	}
			   	catch(AssertionError e) {
			   		System.out.println("Fail");
			   	}
			       
			   
			       drp.selectByIndex(3);
					driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
					
					
					ActualData = "Database Testing";
				     ExpectedData = drp.getFirstSelectedOption().getText();
//				       System.out.println(ExpectedData);
				       
				       try {
				   		Assert.assertEquals(ActualData, ExpectedData);
				   		System.out.println("Dropdown option4 is selected : Pass");
				   	}
				   	catch(AssertionError e) {
				   		System.out.println("Fail");
				   	}
		
		
		driver.navigate().refresh();
		
		
		///double click alert box
		
		
		Actions act = new Actions(driver);
		WebElement alrt1 = driver.findElement(By.xpath("//*[@id=\"dblClkBtn\"]"));
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		act.doubleClick(alrt1).perform();
		Thread.sleep(1000);
		
		ActualData = "hi, JavaTpoint Testing";	
	     ExpectedData = driver.switchTo().alert().getText();
//	       System.out.println(ExpectedData);
	       
	       try {
	   		Assert.assertEquals(ActualData, ExpectedData);
	   		System.out.println("Double-click to generate alert box : Pass");
	   		driver.switchTo().alert().accept();

	   	}
	   	catch(AssertionError e) {
	   		System.out.println("Fail");
	   	}
	       
	       
	       
	       
	       
	       //click button to generate alert box
	       
	       
	       Actions act1 = new Actions(driver);
			WebElement alrt2 = driver.findElement(By.xpath("/html/body/div/div[11]/div/p/button"));
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			act1.click(alrt2).perform();
			Thread.sleep(1000);
			
			ActualData = "hi, JavaTpoint Testing";	
		     ExpectedData = driver.switchTo().alert().getText();
		     driver.switchTo().alert().accept();
//		       System.out.println(ExpectedData);
		       
		       try {
		   		Assert.assertEquals(ActualData, ExpectedData);
		   		System.out.println("click to generate alert box : Pass");
		   	}
		   	catch(AssertionError e) {
		   		System.out.println("Fail");
		   	}
		       
		       driver.navigate().refresh();
		       
		       
		       ////to generate confirm box 
		       
		       
		       Actions act2 = new Actions(driver);
				WebElement alrt3 = driver.findElement(By.xpath("/html/body/div/div[12]/div/p[1]/button"));
				driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
				act2.click(alrt3).perform();
				Thread.sleep(1000);
				
				ActualData = "Press a button!";	
			     ExpectedData = driver.switchTo().alert().getText();
//			       System.out.println(ExpectedData);
			       
			       try {
			   		Assert.assertEquals(ActualData, ExpectedData);
			   		System.out.println("click to generate confirm box : Pass");
			   		driver.switchTo().alert().accept();
			   		
			       }
			   	catch(AssertionError e) {
			   		System.out.println("Fail");
			   	}
			       
		       Thread.sleep(1000);
		       
		       driver.navigate().refresh();
		       
		       
		       
		       act2 = new Actions(driver);
			   alrt3 = driver.findElement(By.xpath("/html/body/div/div[12]/div/p[1]/button"));
				driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		       act2.click(alrt3).perform();
				Thread.sleep(1000);
				
				ActualData = "Press a button!";	
			     ExpectedData = driver.switchTo().alert().getText();
//			       System.out.println(ExpectedData);
			       
			       try {
			   		Assert.assertEquals(ActualData, ExpectedData);
			   		System.out.println("click to generate confirm box : Pass");
			   		driver.switchTo().alert().dismiss();
			   		
			       }
			   	catch(AssertionError e) {
			   		System.out.println("Fail");
			   	}
		       
		       ///drag and drop
		       
		       WebElement drag = driver.findElement(By.xpath("//*[@id=\"sourceImage\"]"));
		       
		       WebElement drop = driver.findElement(By.xpath("//*[@id=\"targetDiv\"]"));
		       
		      Actions wrk = new Actions(driver);
		      wrk.dragAndDrop(drag, drop).build().perform();
			Thread.sleep(1300);
			
				
		       
		    
		
		
		
		driver.quit();
		
	}

	
}