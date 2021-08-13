
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
import org.openqa.selenium.interactions.Actions;
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
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", sub1);
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
			
			WebElement chk3 = this.xpath_locator("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[1]/ol/li/ol/li[2]/ol/li[1]/ol/li[2]/span/label/span[1]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			chk3.click();
			boolean ckb3 = driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(2) > ol > li:nth-child(1) > ol > li:nth-child(2) > span > label > span.rct-checkbox")).isDisplayed();
			boolean ckb4 = true;
			assertEquals(ckb3,ckb4);
			Thread.sleep(1000);
			
			WebElement chk4 = this.xpath_locator("//*[@id=\"tree-node\"]/div/button[2]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			chk4.click();
			String ckb41 = "button";
			assertEquals(ckb41,chk4.getAttribute("type"));
			String ckb42 = "angular";
			String ckb43 = this.xpath_locator("//*[@id=\"result\"]/span[2]").getText();
			assertEquals(ckb42, ckb43);
			Thread.sleep(1400);
			
			
			WebElement chk5 = this.xpath_locator("//*[@id=\"tree-node\"]/ol/li/span/label");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			chk5.click();
			boolean ckb51 = driver.findElement(By.cssSelector("#tree-node > ol > li > span > label")).isDisplayed();
			boolean ckb52 = true;
			assertEquals(ckb51,ckb52);
			String ckb53 = "You have selected :\n" + 
					"home\n" + 
					"desktop\n" + 
					"notes\n" + 
					"commands\n" + 
					"documents\n" + 
					"workspace\n" + 
					"react\n" + 
					"angular\n" + 
					"veu\n" + 
					"office\n" + 
					"public\n" + 
					"private\n" + 
					"classified\n" + 
					"general\n" + 
					"downloads\n" + 
					"wordFile\n" + 
					"excelFile";
			String ckb54 = this.xpath_locator("//*[@id=\"result\"]").getText();
			assertEquals(ckb53, ckb54);
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
			boolean rd22 = this.xpath_locator("//*[@id=\"yesRadio\"]").isSelected();
			boolean rd23 = true;
			assertEquals(rd22,rd23);
			String rd24 = "You have selected Yes";
			String rd25 = this.xpath_locator("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/p").getText();
			assertEquals(rd24, rd25);
			Thread.sleep(1000);
			
			WebElement rd3 = this.css_locator("#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div:nth-child(1) > div:nth-child(3) > label");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			rd3.click();
			String impbtn = "radio";
			WebElement rd31 = this.xpath_locator("//*[@id=\"impressiveRadio\"]");
			assertEquals(impbtn, rd31.getAttribute("type"));
			boolean rd32 = this.xpath_locator("//*[@id=\"impressiveRadio\"]").isSelected();
			boolean rd33 = true;
			assertEquals(rd32,rd33);
			String rd34 = "You have selected Impressive";
			String rd35 = this.xpath_locator("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/p").getText();
			assertEquals(rd34, rd35);
			Thread.sleep(1000);
			
			WebElement rd4 = this.xpath_locator("//*[@id=\"noRadio\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			
				try {
					if(rd4.isSelected()) {
						System.out.println("radio button is enabled");
					}
					else {
						System.out.println("radio button is not enabled");
					}
					}
			   catch(AssertionError e){
				   		System.out.println(e);
					}
     	}
		
		///Web_tables

        @Test
		public void webTables() throws InterruptedException {
			WebElement wet = this.css_locator("#item-3");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", wet);
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
			
			WebElement sbtn2 = this.xpath_locator("/html/body/div[4]/div/div/div[2]/form/div[7]/div/button");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			sbtn2.click();
//			String sbtn21 = "submit";
//			assertEquals(sbtn21, sbtn2.getAttribute("type"));
//			Thread.sleep(1000);
			Thread.sleep(800);
			
			wet1.click();
			WebElement inp_n = this.xpath_locator("//*[@id=\"firstName\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inp_n.click();
			inp_n.sendKeys("4748949");
			String ActualData = "4748949";	
		    String ExpectedData = "ram";
		    
		    try {
    	        Assert.assertEquals(ActualData, ExpectedData);
    	        System.out.println("Input First name is valid");
            }

		    catch(AssertionError e){
    	        System.out.println("\nInvalid First name.Must be in letters");
            }
		    
		    WebElement inp_n1 = this.xpath_locator("//*[@id=\"lastName\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inp_n1.click();
			inp_n1.sendKeys("90873");
			ActualData = "90873";	
		    ExpectedData = "kumar";
		    
		    try {
    	        Assert.assertEquals(ActualData, ExpectedData);
    	        System.out.println("Input Last name is valid");
            }

		    catch(AssertionError e){
    	        System.out.println("\nInvalid Last name.Must be in letters");
            }
		    
		    WebElement inp_n2 = this.xpath_locator("//*[@id=\"userEmail\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inp_n2.click();
		    inp_n2.sendKeys("ramkumar1234@gmail.com");
			String ast = "ramkumar1234@gmail.com";
			assertEquals(ast, inp_n2.getAttribute("value"));
			
			WebElement inp_n3 = this.xpath_locator("//*[@id=\"age\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inp_n3.click();
			inp_n3.sendKeys("27");
			String ast1 = "27";
			assertEquals(ast1, inp_n3.getAttribute("value"));
			
			WebElement inp_n4 = this.xpath_locator("//*[@id=\"salary\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inp_n4.click();
			inp_n4.sendKeys("18000");
			String ast2 = "18000";
			assertEquals(ast2, inp_n4.getAttribute("value"));
			
			WebElement inp_n5 = this.xpath_locator("//*[@id=\"department\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inp_n5.click();
			inp_n5.click();
			inp_n5.sendKeys("935369536");
			ActualData = "935369536";	
			ExpectedData = "Accountant";
		    
		    try {
    	        Assert.assertEquals(ActualData, ExpectedData);
    	        System.out.println("Department entered is valid");
            }

		    catch(AssertionError e){
    	        System.out.println("\nInvalid Department.Must be in letters");
            }
			
		    WebElement sbtn3 = this.xpath_locator("/html/body/div[4]/div/div/div[2]/form/div[7]/div/button");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			sbtn3.submit();
			Thread.sleep(800);
			
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
//			Thread.sleep(1000);
			
			 Select drp = new Select(this.xpath_locator("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/div[3]/div[2]/div/div[2]/span[2]/select"));
			 drp.selectByVisibleText("10 rows");
			 driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			 boolean drpcon = this.xpath_locator("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/div[3]/div[2]/div/div[2]/span[2]/select/option[2]").isSelected();
			 boolean drpcon1 = true;
			 assertEquals(drpcon, drpcon1);
			 Thread.sleep(1000);
			 WebElement row_page = this.xpath_locator("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/div[3]/div[2]/div/div[2]/span[2]/select");
			 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", row_page);
			 drp.selectByIndex(2);
			 driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			 
			 String drp1 = "20 rows";
			 String drp11 = drp.getFirstSelectedOption().getText();
			 assertEquals(drp1, drp11);
			 Thread.sleep(1000);
			 boolean drp12 = this.xpath_locator("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/div[3]/div[2]/div/div[2]/span[2]/select/option[3]").isSelected();
			 boolean drp13 = true;
			 assertEquals(drp12, drp13);
			 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", row_page);
			 drp.selectByIndex(3);
			 driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			 
			 String drp2 = "25 rows";
			 String drp21 = drp.getFirstSelectedOption().getText();
			 assertEquals(drp2, drp21);
			 Thread.sleep(1000);
			 boolean drp22 = this.xpath_locator("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/div[3]/div[2]/div/div[2]/span[2]/select/option[4]").isSelected();			 boolean drp23 = true;
			 assertEquals(drp22, drp23);
			 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", row_page);
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
			 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", row_page);
			 drp.selectByIndex(0);
			 driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			 
			 String drp5 = "5 rows";
			 String drp51 = drp.getFirstSelectedOption().getText();
			 assertEquals(drp5, drp51);
			 Thread.sleep(1000);
			 boolean drp52 = this.xpath_locator("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/div[3]/div[2]/div/div[2]/span[2]/select/option[1]").isSelected();
			 boolean drp53 = true;
			 assertEquals(drp52, drp53);
//			 Thread.sleep(1000);
		}
        
        ///buttons
        
        @Test
        public void buttons() throws InterruptedException {
        	WebElement btt = this.xpath_locator("//*[@id=\"item-4\"]");
        	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", btt);
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			btt.click();
			String btt1 = "https://demoqa.com/buttons";
			assertEquals(btt1, driver.getCurrentUrl());
			Thread.sleep(1000);
			
			Actions act = new Actions(driver);
			WebElement butt1 = this.xpath_locator("//*[@id=\"doubleClickBtn\"]");
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			act.doubleClick(butt1).perform();
			Thread.sleep(1000);
			String butt11 = "You have done a double click";
			String butt12 = this.xpath_locator("//*[@id=\"doubleClickMessage\"]").getText();
			assertEquals(butt11, butt12);
			String butt13 = "button";
			assertEquals(butt13,butt1.getAttribute("type"));
			
			Actions act1 = new Actions(driver);
			WebElement rclk = this.xpath_locator("//*[@id=\"rightClickBtn\"]");
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			act1.contextClick(rclk).perform();
			Thread.sleep(1000);
			String rclk1 = "You have done a right click";
			String rclk12 = this.xpath_locator("//*[@id=\"rightClickMessage\"]").getText();
			assertEquals(rclk1, rclk12);
			String rclk13 = "button";
			assertEquals(rclk13, rclk.getAttribute("type"));
//			Thread.sleep(1000);
			
			WebElement dclk = this.xpath_locator("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/button");
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			dclk.click();
//			Thread.sleep(1000);
			String dclk1 = "You have done a dynamic click";
			String dclk12 = this.xpath_locator("//*[@id=\"dynamicClickMessage\"]").getText();
			assertEquals(dclk1, dclk12);
			String dclk13 = "button";
			assertEquals(dclk13, dclk.getAttribute("type"));
			Thread.sleep(1000);
        }
        
        ///Links
        
        @Test
        public void links() throws InterruptedException {
        	
        	WebElement lnk = this.xpath_locator("//*[@id=\"item-5\"]");
        	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", lnk);
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		    lnk.click();
		    String lnk_chk = "https://demoqa.com/links";
			assertEquals(lnk_chk, driver.getCurrentUrl());
			Thread.sleep(1000);
			
//			WebElement lnk1 = this.xpath_locator("//*[@id=\"simpleLink\"]");
//			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
//		    lnk1.click();
//		    String lnk11 = "https://demoqa.com/";	
//		    assertEquals(lnk11, driver.getCurrentUrl());
//			Thread.sleep(1000);
//			driver.close();
//			
//			WebElement lnk2 = this.xpath_locator("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/p[2]/a");
//			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
//		    lnk2.click();
//		    String lnk21 = "https://demoqa.com/";	
//		    assertEquals(lnk21, driver.getCurrentUrl());
//			Thread.sleep(1000);
//			driver.close();
			
			WebElement api1 = this.xpath_locator("//*[@id=\"created\"]");
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		    api1.click();
		    String api11 = "201";
			String api12 = this.xpath_locator("//*[@id=\"linkResponse\"]/b[1]").getText();
			WebElement api13 = this.xpath_locator("//*[@id=\"linkResponse\"]/b[1]");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", api13);
			assertEquals(api11, api12);
			Thread.sleep(1000);
			driver.navigate().refresh();
			
			WebElement api2 = this.xpath_locator("//*[@id=\"no-content\"]");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", api2);
			Thread.sleep(1000);
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		    api2.click();
		    String api21 = "204";
			String api22 = this.xpath_locator("//*[@id=\"linkResponse\"]/b[1]").getText();
			WebElement api23 = this.xpath_locator("//*[@id=\"linkResponse\"]/b[1]");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", api23);
			assertEquals(api21, api22);
			Thread.sleep(1000);
			driver.navigate().refresh();
			
			WebElement api3 = this.xpath_locator("//*[@id=\"moved\"]");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", api3);
			Thread.sleep(1000);
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		    api3.click();
		    String api31 = "301";
			String api32 = this.xpath_locator("//*[@id=\"linkResponse\"]/b[1]").getText();
			WebElement api33 = this.xpath_locator("//*[@id=\"linkResponse\"]/b[1]");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", api33);
			assertEquals(api31, api32);
			Thread.sleep(1000);
            driver.navigate().refresh();
			
			WebElement api4 = this.xpath_locator("//*[@id=\"bad-request\"]");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", api4);
			Thread.sleep(1000);
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		    api4.click();
		    String api41 = "400";
			String api42 = this.xpath_locator("//*[@id=\"linkResponse\"]/b[1]").getText();
			WebElement api43 = this.xpath_locator("//*[@id=\"linkResponse\"]/b[1]");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", api43);
			assertEquals(api41, api42);
			Thread.sleep(1000);
			driver.navigate().refresh();
			
			WebElement api5 = this.xpath_locator("//*[@id=\"unauthorized\"]");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", api5);
			Thread.sleep(1000);
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		    api5.click();
		    String api51 = "401";
			String api52 = this.xpath_locator("//*[@id=\"linkResponse\"]/b[1]").getText();
			WebElement api53 = this.xpath_locator("//*[@id=\"linkResponse\"]/b[1]");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", api53);
			assertEquals(api51, api52);
			Thread.sleep(1000);
			driver.navigate().refresh();
			
			WebElement api6 = this.xpath_locator("//*[@id=\"forbidden\"]");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", api6);
			Thread.sleep(1000);
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		    api6.click();
		    String api61 = "403";
			String api62 = this.xpath_locator("//*[@id=\"linkResponse\"]/b[1]").getText();
			WebElement api63 = this.xpath_locator("//*[@id=\"linkResponse\"]/b[1]");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", api63);
			assertEquals(api61, api62);
			Thread.sleep(1000);
			driver.navigate().refresh();
			
			WebElement api7 = this.xpath_locator("//*[@id=\"invalid-url\"]");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", api7);
			Thread.sleep(1000);
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		    api7.click();
		    String api71 = "404";
			String api72 = this.xpath_locator("//*[@id=\"linkResponse\"]/b[1]").getText();
			WebElement api73 = this.xpath_locator("//*[@id=\"linkResponse\"]/b[1]");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", api73);
			assertEquals(api71, api72);
			Thread.sleep(1000);
			
        }
        
        ///Broken links-Images
        
        @Test
        public void brokenLinks() throws InterruptedException {
        	WebElement b_link = this.xpath_locator("//*[@id=\"item-6\"]");
        	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", b_link);
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		    b_link.click();
		    String blnk_chk = "https://demoqa.com/broken";
			assertEquals(blnk_chk, driver.getCurrentUrl());
			Thread.sleep(1000);
	
			WebElement img1 = this.xpath_locator("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/img[1]");
			Boolean img11 = (Boolean) ((JavascriptExecutor)driver) .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", img1);

				if (img11) {
					    	System.out.println("\nTools QA logo is present");
				} 	
				else {
							System.out.println("Tools QA logo is not present");
				     }
				
			WebElement img2 = this.xpath_locator("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/img[2]");
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			try {
				if(img2.isSelected()) {
					System.out.println("Image is enabled");
				}
				else {
					System.out.println("\nImage is disabled");
				}
				}
		   catch(AssertionError e){
			   		System.out.println(e);
				}
			Thread.sleep(1000);
			
			WebElement valid_lnk = this.xpath_locator("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/a[1]");
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", valid_lnk);
			valid_lnk.click();
			String valid_lnk1 = "https://demoqa.com/";
			assertEquals(valid_lnk1, driver.getCurrentUrl());
			Thread.sleep(1000);
			driver.navigate().back();  
			
			WebElement brk_lnk = this.xpath_locator("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/a[2]");
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", brk_lnk);
			brk_lnk.click();
			String brk_lnk1 = "http://the-internet.herokuapp.com/status_codes/500";
			assertEquals(brk_lnk1, driver.getCurrentUrl());
			Thread.sleep(1000);
//			String brk_lnk12 = "You have done a dynamic click";
//			String brk_lnk13 = this.xpath_locator("//*[@id=\"dynamicClickMessage\"]").getText();
//			assertEquals(brk_lnk12, brk_lnk12);
//			
//			driver.navigate().back();  
			
        }
        
        
        
	    @After
	
	        public void clse() {
	    	driver.quit();
	    }
}
