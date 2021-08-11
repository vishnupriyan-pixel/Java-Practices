package mainproject;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@SuppressWarnings("unused")
public class toolstest {
	WebDriver driver;
	
//	mainproject.toolstest my = new toolstest();
	
	public WebElement enable(String ele) {

		WebElement path= null;
		try{
		    path = driver.findElement(By.xpath(ele));
			if(path.isEnabled()) {
				return path;
			}
			else {
				System.out.println("Element is not enabled");
			}
			
		    }
		catch(AssertionError e) {
			System.out.println(e);
			
		  }
		return path;
		
		
		    }


	

	@Before
	public void url() {

		System.setProperty("webdriver.chrome.driver", "/home/zoho/Downloads/chromedriver");
		driver = new ChromeDriver();
//		System.setProperty("webdriver.gecko.driver", "/home/zoho/Downloads/geckodriver");
//		WebDriver driver = new  FirefoxDriver();
		
        driver.manage().window().maximize();
		
		String link = "https://demoqa.com/elements";
		
		driver.get(link);
		
		String ActualData = "https://demoqa.com/elements";
	    String ExpectedData = driver.getCurrentUrl();
	    driver.manage().timeouts().implicitlyWait(1500,TimeUnit.MILLISECONDS);
	     
	        try{
	                Assert.assertEquals(ActualData, ExpectedData);
	                System.out.println("\nCurrent Url is: Pass");
	           }
	        catch(AssertionError e){
	    	        System.out.println("Fail");	
	           }
		
	}	
	
	///Text Box
	
	@Test
	
	public void txt() {
			
			WebElement txt1 = this.enable("//*[@id=\"item-0\"]");
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			txt1.click();
			
			String act = "https://demoqa.com/text-box";
			assertEquals(act,driver.getCurrentUrl());
			
		        
			WebElement txt2 = this.enable("//*[@id=\"userName\"]");
			txt2.click();
			txt2.sendKeys("Vishnu");
			
			String act1 = "Vishnu";
			assertEquals(act1, txt2.getText());
//			System.out.println(txt2.getText());
			
			WebElement txt3 = this.enable("//*[@id=\"userEmail\"]");
			txt3.click();
			txt3.sendKeys("vishnu1234@gmail.com");
			
			String act2 = "vishnu1234@gmail.com";
			assertEquals(act2, txt3.getText());
			
			WebElement txt4 = this.enable("//*[@id=\"currentAddress\"]");
			txt4.click();
			txt4.sendKeys("12/North car street,\nTenkasi,\nTenkasi District.");
			
			String act3 = "12/North car street,\\nTenkasi,\\nTenkasi District.";
			assertEquals(act3, txt4.getText());
			
			WebElement txt5 = this.enable("//*[@id=\"permanentAddress\"]");
			txt5.getText();
			txt5.sendKeys("12/North car street,\nTenkasi,\nTenkasi District.");
			
			String act4 = "12/North car street,\\nTenkasi,\\nTenkasi District.";
			assertEquals(act4, txt5.getText());
			
			
			WebElement sub1 = this.enable("//*[@id=\"submit\"]");
			sub1.submit();
			
			
			
	}	
		
		
		///Check Box




		@Test
	
	
		public void chck() {
			
			WebElement chk1 = this.enable("//*[@id=\"item-1\"]");
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			chk1.click();
			
			WebElement chk2 = this.enable("//*[@id=\"tree-node\"]/div/button[1]");
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			chk2.click();
			
			WebElement chk3 = this.enable("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/ol/li[2]/span/label/span[1]");
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			chk3.click();
			
			
		}
	
		@Test
		
		public void radio1() {
			WebElement rd1 = this.enable("//*[@id=\"item-2\"]");
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			rd1.click();
			
			WebElement rd2 = this.enable("//*[@id=\"yesRadio\"]");
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			rd2.click();
			
			WebElement rd3 = this.enable("//*[@id=\"impressiveRadio\"]");
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			rd3.click();
		}
		

	    @After
	
	        public void clse() {
	    	driver.quit();
	    }
}


	
		
		
	
	




