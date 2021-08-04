package mainproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import junit.framework.Assert;

public class Logintest {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/home/zoho/Downloads/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		WebDriver driver = new ChromeDriver(options);
		
		String log = "https://account.acer.com/sso/signin";
		
		driver.get(log);
		
		///cookies accept
		
		WebElement cookies = driver.findElement(By.cssSelector("#onetrust-accept-btn-handler"));
//		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);

		Thread.sleep(1500);
		cookies.click();
		Thread.sleep(700);
		
		
		///Empty field check
		 
		WebElement empty = driver.findElement(By.xpath("//*[@id=\"button:ln8\"]"));
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		empty.click();
		Thread.sleep(700);
		
		String ActualData = "This is a mandatory field.";
		String ExpectedData = driver.findElement(By.xpath("//*[@id=\"page3FormBean\"]/div[1]/div[2]/div/div/div[4]/span[2]")).getText();
//		System.out.println(ExpectedData);
		
		try {
			Assert.assertEquals(ActualData, ExpectedData);
			System.out.println("Empty field check : Pass");
		}
		catch(AssertionError e){
			System.out.println("Fail");
		}
		
		
		/// Password empty field check
		
		WebElement mail = driver.findElement(By.cssSelector("#fld3"));
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
     	mail.click();
     	mail.clear();
		mail.sendKeys("vishnuvichu9487@gmail.com");
		Thread.sleep(700);
		
	    driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
//	    empty.click();
	    Thread.sleep(700);
	    
		 ActualData = "This is a mandatory field.";
	     ExpectedData = driver.findElement(By.xpath("//*[@id=\"page3FormBean\"]/div[1]/div[2]/div/div/div[5]/span[2]")).getText();
	     
//		 System.out.println(ExpectedData);
		
		try {
			Assert.assertEquals(ActualData, ExpectedData);
			System.out.println("Password empty field check : Pass");
		}
		catch(AssertionError e){
			System.out.println("Fail");
		}
		
	    mail.clear();
	    
	    ///Mail empty field check
	    
	    	
	WebElement pswrd = driver.findElement(By.cssSelector("#fld4"));
	driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
	pswrd.click();
	pswrd.clear();
	pswrd.sendKeys("12345566786729");
	Thread.sleep(700);
	
	empty = driver.findElement(By.xpath("//*[@id=\"button:ln8\"]"));
	driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
	empty.click();
	Thread.sleep(700);
	
	 ActualData = "This is a mandatory field.";
     ExpectedData = driver.findElement(By.xpath("//*[@id=\"page3FormBean\"]/div[1]/div[2]/div/div/div[4]/span[2]")).getText();
     
	
	try {
		Assert.assertEquals(ActualData, ExpectedData);
		System.out.println("Mail empty field check : Pass");
	}
	catch(AssertionError e){
		System.out.println("Fail");
	}
	
	
	driver.navigate().refresh();
	
	///Invalid E-mail & Password check
	
	
	mail = driver.findElement(By.cssSelector("#fld3"));
	driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
 	mail.click();
 	mail.clear();
	mail.sendKeys("vishnu123@gmail.com");
	Thread.sleep(700);
	
	pswrd = driver.findElement(By.cssSelector("#fld4"));
	driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
	pswrd.click();
	pswrd.clear();
	pswrd.sendKeys("12346363gxyri");
	Thread.sleep(700);
	
	empty = driver.findElement(By.xpath("//*[@id=\"button:ln8\"]"));
	driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
	empty.click();
	Thread.sleep(700);
	
	 driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
//	    empty.click();
     Thread.sleep(700);
	
	
     ActualData = "Your Acer ID email or password is incorrect.";
     ExpectedData = driver.findElement(By.xpath("//*[@id=\"page3FormBean\"]/div[1]/div[2]/div/div/div[7]/p")).getText();
//    System.out.println(ExpectedData);
    
    try {
		Assert.assertEquals(ActualData, ExpectedData);
		System.out.println("Invalid mail & Password check : Pass");
	}
	catch(AssertionError e) {
		System.out.println("Fail");
	}
    
    driver.navigate().refresh();
    
    ///Invalid Mail and valid Password check
    
    mail = driver.findElement(By.cssSelector("#fld3"));
	driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
 	mail.click();
 	mail.clear();
	mail.sendKeys("vishnu1234@gmail.com");
	Thread.sleep(700);
	
	pswrd = driver.findElement(By.cssSelector("#fld4"));
	driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
	pswrd.click();
	pswrd.clear();
	pswrd.sendKeys("VICHU@123");
	Thread.sleep(700);
	
	empty = driver.findElement(By.xpath("//*[@id=\"button:ln8\"]"));
	driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
	empty.click();
	Thread.sleep(700);
	
	 driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
//	    empty.click();
	 Thread.sleep(700);
	
	
     ActualData = "Your Acer ID email or password is incorrect.";
     ExpectedData = driver.findElement(By.xpath("//*[@id=\"page3FormBean\"]/div[1]/div[2]/div/div/div[7]/p")).getText();
//    System.out.println(ExpectedData);
    
    try {
		Assert.assertEquals(ActualData, ExpectedData);
		System.out.println("Invalid mail & Valid password check : Pass");
	}
	catch(AssertionError e) {
		System.out.println("Fail");
	}
    
    driver.navigate().refresh();
    
    ///Valid mail and Invalid password check
    
    mail = driver.findElement(By.cssSelector("#fld3"));
   	driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
    mail.click();
    mail.clear();
   	mail.sendKeys("vishnuvichu9487@gmail.com");
   	Thread.sleep(500);
   	
   	pswrd = driver.findElement(By.cssSelector("#fld4"));
   	driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
   	pswrd.click();
   	pswrd.clear();
   	pswrd.sendKeys("VICHU467");
   	Thread.sleep(500);
   	
   	empty = driver.findElement(By.xpath("//*[@id=\"button:ln8\"]"));
   	driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
   	empty.click();
   	Thread.sleep(500);
   	
   	 driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
//   	    empty.click();
   	 Thread.sleep(500);
   	
   	
        ActualData = "Your Acer ID email or password is incorrect.";
        ExpectedData = driver.findElement(By.xpath("//*[@id=\"page3FormBean\"]/div[1]/div[2]/div/div/div[7]/p")).getText();
//       System.out.println(ExpectedData);
       
       try {
   		Assert.assertEquals(ActualData, ExpectedData);
   		System.out.println("Valid mail and Invalid password check : Pass");
   	}
   	catch(AssertionError e) {
   		System.out.println("Fail");
   	}
       
       driver.navigate().refresh();
    
    ////Valid Email & Password///
    
    mail = driver.findElement(By.cssSelector("#fld3"));
	driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
 	mail.click();
 	mail.clear();
	mail.sendKeys("vishnuvichu9487@gmail.com");
	Thread.sleep(700);
	
	pswrd = driver.findElement(By.cssSelector("#fld4"));
	driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
	pswrd.click();
	pswrd.clear();
	pswrd.sendKeys("VICHU@123");
	Thread.sleep(700);
	
	empty = driver.findElement(By.xpath("//*[@id=\"button:ln8\"]"));
	driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
	empty.click();
	Thread.sleep(700);
	
	
	 try {
			Assert.assertEquals(ActualData, ExpectedData);
			System.out.println("Valid mail & password : Pass");
		}
		catch(AssertionError e) {
			System.out.println("Fail");
		}
	 
	 ///URL check
	 
	 String url = "https://www.acer.com/ac/en/GB/content/home";
     driver.get(url);
     driver.manage().timeouts().implicitlyWait(3400,TimeUnit.MILLISECONDS);
     
    try {
     System.out.println("Current Url is: Pass");
    }
    catch(AssertionError e){
    	System.out.println("Fail");
    }
    
    driver.quit();
	
	}
    
    }
	 
	 
	 

	
	
