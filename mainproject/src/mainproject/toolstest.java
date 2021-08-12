package mainproject;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@SuppressWarnings("unused")
public class toolsTest {
	static WebDriver driver;
	
//	mainproject.toolstest my = new toolstest();
	
	public WebElement xpath_locator(String ele) {

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
	
	public WebElement css_locator(String ele) {

		WebElement path= null;
		try{
		    path = driver.findElement(By.cssSelector(ele));
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


    @BeforeClass
	public static void url() {

		System.setProperty("webdriver.chrome.driver", "/home/zoho/Downloads/chromedriver");
		driver = new ChromeDriver();
//		System.setProperty("webdriver.gecko.driver", "/home/zoho/Downloads/geckodriver");
//		WebDriver driver = new  FirefoxDriver();
		
        driver.manage().window().maximize();
		
		String link = "https://demoqa.com/elements";
		
		driver.get(link);
		
		String ActualData = "https://demoqa.com/elements";
	    String ExpectedData = driver.getCurrentUrl();
	    driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
	     
	        try{
	                Assert.assertEquals(ActualData, ExpectedData);
//	                System.out.println("\nCurrent Url is: Pass");
	           }
	        catch(AssertionError e){
	    	        System.out.println("Fail");	
	           }
		}	
	
	///Text Box
	
	@Test
	
	public  void txtBox() throws InterruptedException {
			
			WebElement txt1 = this.xpath_locator("//*[@id=\"item-0\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			txt1.click();
			
			String act = "https://demoqa.com/text-box";
			assertEquals(act,driver.getCurrentUrl());
		
		        
			WebElement txt2 = this.xpath_locator("//*[@id=\"userName\"]");
			txt2.click();
			txt2.sendKeys("Vishnu");
			String act1 = "Vishnu";
			assertEquals(act1, txt2.getAttribute("value"));
			
			WebElement txt3 = this.xpath_locator("//*[@id=\"userEmail\"]");
			txt3.click();
			txt3.sendKeys("vishnu1234@gmail.com");
			String act2 = "vishnu1234@gmail.com";
			assertEquals(act2, txt3.getAttribute("value"));
			
			WebElement txt4 = this.xpath_locator("//*[@id=\"currentAddress\"]");
			txt4.click();
			txt4.sendKeys("12/North car street,\nTenkasi,\nTenkasi District.");
			String act3 = "12/North car street,\nTenkasi,\nTenkasi District.";
			assertEquals(act3, txt4.getAttribute("value"));
			
			WebElement txt5 = this.xpath_locator("//*[@id=\"permanentAddress\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			txt5.getText();
			txt5.sendKeys("12/North car street,\nTenkasi,\nTenkasi District.");
			String act4 = "12/North car street,\nTenkasi,\nTenkasi District.";
			assertEquals(act4, txt5.getAttribute("value"));
			Thread.sleep(1000);
			
			WebElement sub1 = this.xpath_locator("//*[@id=\"submit\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			 JavascriptExecutor jse6 = (JavascriptExecutor)driver;
			 jse6.executeScript("window.scrollBy(0,530)");
			sub1.click();
			String sub2 = "button";
			assertEquals(sub2, sub1.getAttribute("type"));
			Thread.sleep(1000);
			
		}	
		
	///Check Box

        @Test
	      public void chckBox() throws InterruptedException {
			
			WebElement chk1 = this.xpath_locator("//*[@id=\"item-1\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			chk1.click();
			String ckb1 = "https://demoqa.com/checkbox";
			assertEquals(ckb1, driver.getCurrentUrl());
			
			WebElement chk2 = this.xpath_locator("//*[@id=\"tree-node\"]/div/button[1]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			chk2.click();
			String ckb2 = "button";
			assertEquals(ckb2,chk2.getAttribute("type"));
			Thread.sleep(1000);
			
			WebElement chk3 = this.xpath_locator("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/ol/li[2]/span/label/span[1]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			chk3.click();
			boolean ckb3 = driver.findElement(By.cssSelector("#tree-node-angular")).isSelected();
			boolean ckb4 = true;
			assertEquals(ckb3,ckb4);
			Thread.sleep(1000);
		}
	
		///radio_button
		@Test
		
		public void radio1() throws InterruptedException {
			WebElement rd1 = this.xpath_locator("//*[@id=\"item-2\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			rd1.click();
			String rbtn1 = "https://demoqa.com/radio-button";
			assertEquals(rbtn1, driver.getCurrentUrl());
			
			
			WebElement rd2 = this.css_locator("#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div:nth-child(1) > div:nth-child(2) > label");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			rd2.click();
			String ybtn = "radio";
			WebElement rd21 = this.xpath_locator("//*[@id=\"yesRadio\"]");
			assertEquals(ybtn, rd21.getAttribute("type"));
			Thread.sleep(1000);
			
			WebElement rd3 = this.css_locator("#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div:nth-child(1) > div:nth-child(3) > label");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			rd3.click();
			String impbtn = "radio";
			WebElement rd31 = this.xpath_locator("//*[@id=\"impressiveRadio\"]");
			assertEquals(impbtn, rd31.getAttribute("type"));
			Thread.sleep(1000);
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,250)");
		}
		
		///Web_tables

        @Test
		public void webTables() throws InterruptedException {
			WebElement wet = this.css_locator("#item-3");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			wet.click();
			String wb1 = "https://demoqa.com/webtables";
			assertEquals(wb1, driver.getCurrentUrl());
			Thread.sleep(1000);
			
			WebElement wet1 = this.xpath_locator("//*[@id=\"addNewRecordButton\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			wet1.click();
			String addbtn = "button";
			assertEquals(addbtn, wet1.getAttribute("type"));
			
			WebElement inpt = this.xpath_locator("//*[@id=\"firstName\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inpt.click();
			inpt.sendKeys("Vishnu");
			String inpt12 = "Vishnu";
			assertEquals(inpt12, inpt.getAttribute("value"));
			
			WebElement inpt2 = this.xpath_locator("//*[@id=\"lastName\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inpt2.click();
			inpt2.sendKeys("Priyan");
			String inpt21 = "Priyan";
			assertEquals(inpt21, inpt2.getAttribute("value"));
			
			WebElement inpt3 = this.xpath_locator("//*[@id=\"userEmail\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inpt3.click();
			inpt3.sendKeys("vishnu1234@gmail.com");
			String inpt31 = "vishnu1234@gmail.com";
			assertEquals(inpt31, inpt3.getAttribute("value"));
			
			WebElement inpt4 = this.xpath_locator("//*[@id=\"age\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inpt4.click();
			inpt4.sendKeys("23");
			String inpt41 = "23";
			assertEquals(inpt41, inpt4.getAttribute("value"));
			
			WebElement inpt5 = this.xpath_locator("//*[@id=\"salary\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inpt5.click();
			inpt5.sendKeys("15000");
			String inpt51 = "15000";
			assertEquals(inpt51, inpt5.getAttribute("value"));
			
			WebElement inpt6 = this.xpath_locator("//*[@id=\"department\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inpt6.click();
			inpt6.sendKeys("Finance");
			String inpt61 = "Finance";
			assertEquals(inpt61, inpt6.getAttribute("value"));
			
			WebElement sbtn2 = this.xpath_locator("//*[@id=\"submit\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			sbtn2.click();
//			String sbtn21 = "submit";
//			assertEquals(sbtn21, sbtn2.getAttribute("type"));
			Thread.sleep(1000);
			
			WebElement srch = this.xpath_locator("//*[@id=\"searchBox\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			srch.click();
			srch.sendKeys("Vi");
			String srch1 = "Vi";
			assertEquals(srch1, srch.getAttribute("value"));
			Thread.sleep(1500);
			
			WebElement del = this.xpath_locator("//*[@id=\"delete-record-4\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			del.click();
//			boolean del1 = this.css_locator("#delete-record-4 svg").isDisplayed();
//			boolean del2 = true;
//			assertEquals(del1, del2);
			Thread.sleep(1000);
			
			srch.click();
			srch.sendKeys(Keys.BACK_SPACE);
			srch.click();
			srch.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(1000);
			
			WebElement edt = this.xpath_locator("//*[@id=\"edit-record-1\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			edt.click();

			boolean edbt = this.xpath_locator("/html/body/div[4]/div/div").isDisplayed();
			boolean edbt1 = true;
			assertEquals(edbt, edbt1);
			Thread.sleep(1000);
			
			WebElement edt2 = this.css_locator("#salary");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			edt2.click();
			edt2.clear();
            edt2.sendKeys(Keys.BACK_SPACE);
			edt2.sendKeys("20000");
			String edt21 = "text";
			assertEquals(edt21, edt2.getAttribute("type"));
			Thread.sleep(1000);
			
			WebElement sbdt4 = this.xpath_locator("//*[@id=\"submit\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			sbdt4.click();
			String sbdt41 = "submit";
			assertEquals(sbdt41, sbdt4.getAttribute("type"));
			Thread.sleep(1000);
			
			 Select drp = new Select(this.xpath_locator("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/div[3]/div[2]/div/div[2]/span[2]/select"));
			 drp.selectByVisibleText("10 rows");
			 driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			 boolean drpcon = this.xpath_locator("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/div[3]/div[2]/div/div[2]/span[2]/select/option[2]").isSelected();
			 boolean drpcon1 = true;
			 assertEquals(drpcon, drpcon1);
			 Thread.sleep(1000);
			 JavascriptExecutor jse2 = (JavascriptExecutor)driver;
			 jse2.executeScript("window.scrollBy(0,700)");
			 drp.selectByIndex(2);
			 driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			 
			 String drp1 = "20 rows";
			 String drp11 = drp.getFirstSelectedOption().getText();
			 assertEquals(drp1, drp11);
			 Thread.sleep(1000);
			 boolean drp12 = this.xpath_locator("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/div[3]/div[2]/div/div[2]/span[2]/select/option[3]").isSelected();
			 boolean drp13 = true;
			 assertEquals(drp12, drp13);
			 JavascriptExecutor jse3 = (JavascriptExecutor)driver;
			 jse3.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			 drp.selectByIndex(3);
			 driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			 
			 String drp2 = "25 rows";
			 String drp21 = drp.getFirstSelectedOption().getText();
			 assertEquals(drp2, drp21);
			 Thread.sleep(1000);
			 boolean drp22 = this.xpath_locator("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/div[3]/div[2]/div/div[2]/span[2]/select/option[4]").isSelected();			 boolean drp23 = true;
			 assertEquals(drp22, drp23);
			 JavascriptExecutor jse4 = (JavascriptExecutor)driver;
			 jse4.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			 drp.selectByIndex(4);
			 driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			 
			 String drp3 = "50 rows";
			 String drp31 = drp.getFirstSelectedOption().getText();
			 assertEquals(drp3, drp31);
			 Thread.sleep(1000);
			 boolean drp32 = this.xpath_locator("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/div[3]/div[2]/div/div[2]/span[2]/select/option[5]").isSelected();
			 boolean drp33 = true;
			 assertEquals(drp32, drp33);
			 
			 drp.selectByIndex(5);
			 driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			 
			 String drp4 = "100 rows";
			 String drp41 = drp.getFirstSelectedOption().getText();
			 assertEquals(drp4, drp41);
			 Thread.sleep(1000);
			 boolean drp42 = this.xpath_locator("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/div[3]/div[2]/div/div[2]/span[2]/select/option[6]").isSelected();
			 boolean drp43 = true;
			 assertEquals(drp42, drp43);
			 JavascriptExecutor jse7 = (JavascriptExecutor)driver;
			 jse7.executeScript("window.scrollBy(0,-400)");
			 drp.selectByIndex(0);
			 driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			 
			 String drp5 = "5 rows";
			 String drp51 = drp.getFirstSelectedOption().getText();
			 assertEquals(drp5, drp51);
			 Thread.sleep(1000);
			 boolean drp52 = this.xpath_locator("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/div[3]/div[2]/div/div[2]/span[2]/select/option[1]").isSelected();
			 boolean drp53 = true;
			 assertEquals(drp52, drp53);
			 JavascriptExecutor jse1 = (JavascriptExecutor)driver;
			 jse1.executeScript("window.scrollBy(0,-400)");
			 
			 
		}
	    @AfterAll	
	
	        public void clse() {
	    	driver.quit();
	    }
}

		
	

