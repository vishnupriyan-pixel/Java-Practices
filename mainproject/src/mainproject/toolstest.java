
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.SimpleScriptable;

import junit.framework.Assert;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@SuppressWarnings("unused")
public class toolsTest {
	public static WebDriver driver;
	public WebElement xpath_locator(String ele) {

			WebElement path= null;
			try{
			    path = driver.findElement(By.xpath(ele));
				if(path.isEnabled()) {
					return path;
				}
				else {
					System.out.println("\nElement is not enabled");
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
					System.out.println("\nElement is not enabled");
				}

			    }
			catch(AssertionError e) {
				System.out.println(e);

			  }
			return path;


			    }


	    @BeforeClass
		public static void url() {

			System.setProperty("webdriver.chrome.driver", "/home/zoho/Downloads/chromedriver-new");
			driver = new ChromeDriver();
	//		System.setProperty("webdriver.gecko.driver", "/home/zoho/Downloads/geckodriver");
	//		WebDriver driver = new  FirefoxDriver();		
	//		driver.manage().window().setSize(new Dimension(600, 720));
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

			///Empty Text Box
			@Test
			public  void txtBox_empty_check() throws InterruptedException {

			WebElement txt1 = this.xpath_locator("//*[@id=\"item-0\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			txt1.click();
			String act = "https://demoqa.com/text-box";
			assertEquals(act,driver.getCurrentUrl());

			WebElement sub1 = this.xpath_locator("//*[@id=\"submit\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", sub1);
			sub1.click();
			String sub2 = "button";
			assertEquals(sub2, sub1.getAttribute("type"));
			Thread.sleep(1000);
			}

			///minimum character check
			@Test
			public  void min_character_check() throws InterruptedException {
			WebElement txt1 = this.xpath_locator("//*[@id=\"item-0\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			txt1.click();
			String act = "https://demoqa.com/text-box";
			assertEquals(act,driver.getCurrentUrl());

			WebElement txt2 = this.xpath_locator("//*[@id=\"userName\"]");
			txt2.click();
			txt2.sendKeys("ry");
			String act1 = "ry";
			assertEquals(act1, txt2.getAttribute("value"));
			if(txt2.getText() != null) {
				System.out.println("First name will not be in minimum character.");
			}
			else {
				System.out.println("First name is in correct order.");
			}

			WebElement txt3 = this.xpath_locator("//*[@id=\"userEmail\"]");
			txt3.click();
			txt3.sendKeys("xhud");
			String act2 = "xhud";
			assertEquals(act2, txt3.getAttribute("value"));
			if(txt3.getText() != null) {
				System.out.println("Email will not be in minimum character.");
			}
			else {
				System.out.println("Email is in correct order.");
			}

			WebElement txt4 = this.xpath_locator("//*[@id=\"currentAddress\"]");
			txt4.click();
			txt4.sendKeys("u484");
			String act3 = "u484";
			assertEquals(act3, txt4.getAttribute("value"));
			if(txt4.getText() != null) {
				System.out.println("Current Address will not be in minimum character.");
			}
			else {
				System.out.println("Current Address is in correct order.");
			}

			WebElement txt5 = this.xpath_locator("//*[@id=\"permanentAddress\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			txt5.getText();
			txt5.sendKeys("u484");
			String act4 = "u484";
			assertEquals(act4, txt5.getAttribute("value"));
			if(txt5.getText() != null) {
				System.out.println("Permanent Address will not be in minimum character.");
			}
			else {
				System.out.println("Permanent Address is in correct order.");
			}
			Thread.sleep(1000);

			WebElement sub1 = this.xpath_locator("//*[@id=\"submit\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", sub1);
			sub1.click();
			String sub21 = "button";
			assertEquals(sub21, sub1.getAttribute("type"));
			Thread.sleep(1000);
			driver.navigate().refresh();
			Thread.sleep(1000);
			}
			///Maximum Characters check
			@Test
			public  void max_character_check() throws InterruptedException {

			WebElement txt2 = this.xpath_locator("//*[@id=\"userName\"]");
			txt2.click();
			txt2.sendKeys("ryhxhx412673889hxxxj73338121091981nxbxynxxnhxjdjue7nx9yn");
			String act1 = "ryhxhx412673889hxxxj73338121091981nxbxynxxnhxjdjue7nx9yn";
			assertEquals(act1, txt2.getAttribute("value"));
			if(txt2.getText() != null) {
				System.out.println("\nFirst name should not be in maximum length.");
			}
			else {
				System.out.println("First name is in correct order.");
			}

			WebElement txt3 = this.xpath_locator("//*[@id=\"userEmail\"]");
			txt3.click();
			txt3.sendKeys("xhud");
			String act2 = "xhud";
			assertEquals(act2, txt3.getAttribute("value"));
			if(txt3.getText() != null) {
				System.out.println("Email should not be in maximum length.");
			}
			else {
				System.out.println("Email is in correct order.");
			}

			WebElement txt4 = this.xpath_locator("//*[@id=\"currentAddress\"]");
			txt4.click();
			txt4.sendKeys("u484");
			String act3 = "u484";
			assertEquals(act3, txt4.getAttribute("value"));
			if(txt4.getText() != null) {
				System.out.println("Current Address should not be in Huge data.");
			}
			else {
				System.out.println("Current Address is in correct order.");
			}

			WebElement txt5 = this.xpath_locator("//*[@id=\"permanentAddress\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			txt5.getText();
			txt5.sendKeys("u484");
			String act4 = "u484";
			assertEquals(act4, txt5.getAttribute("value"));
			if(txt5.getText() != null) {
				System.out.println("Permanent Address should not be in Huge data.");
			}
			else {
				System.out.println("Permanent Address is in correct order.");
			}
			Thread.sleep(1000);

			WebElement sub1 = this.xpath_locator("//*[@id=\"submit\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", sub1);
			sub1.click();
			String sub21 = "button";
			assertEquals(sub21, sub1.getAttribute("type"));
			Thread.sleep(1000);
			driver.navigate().refresh();
			Thread.sleep(1000);
			}

			///Special Characters check
			@Test
			public  void special_character_check() throws InterruptedException {

			WebElement txt2 = this.xpath_locator("//*[@id=\"userName\"]");
			txt2.click();
			txt2.sendKeys("`~!@#$%^&*()_-+= {}[]|.,<>?/");
			String act1 = "`~!@#$%^&*()_-+= {}[]|.,<>?/";
			assertEquals(act1, txt2.getAttribute("value"));
			if(act1.contains("`~!@#$%^&*()_-+= {}[]|.,<>?/")) {
				System.out.println("\nFirst name should not be in special characters.");
			}
			else {
				System.out.println("First name is in correct order.");
			}

			WebElement txt3 = this.xpath_locator("//*[@id=\"userEmail\"]");
			txt3.click();
			txt3.sendKeys("`~!@#$%^&*()_-+= {}[]|.,<>?/");
			String act2 = "`~!@#$%^&*()_-+= {}[]|.,<>?/";
			assertEquals(act2, txt3.getAttribute("value"));
			if(act2.contains("`~!@#$%^&*()_-+= {}[]|.,<>?/")) {
				System.out.println("Email all characters should not be in special characters.");
			}
			else {
				System.out.println("Email is in correct order.");
			}

			WebElement txt4 = this.xpath_locator("//*[@id=\"currentAddress\"]");
			txt4.click();
			txt4.sendKeys("`~!@#$%^&*()_-+= {}[]|.,<>?/");
			String act3 = "`~!@#$%^&*()_-+= {}[]|.,<>?/";
			assertEquals(act3, txt4.getAttribute("value"));
			if(act3.contains("`~!@#$%^&*()_-+= {}[]|.,<>?/")) {
				System.out.println("Current Address should not be special characters.");
			}
			else {
				System.out.println("Current Address is in correct order.");
			}

			WebElement txt5 = this.xpath_locator("//*[@id=\"permanentAddress\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			txt5.getText();
			txt5.sendKeys("`~!@#$%^&*()_-+= {}[]|.,<>?/");
			String act4 = "`~!@#$%^&*()_-+= {}[]|.,<>?/";
			assertEquals(act4, txt5.getAttribute("value"));
			if(act4.contains("`~!@#$%^&*()_-+= {}[]|.,<>?/")) {
				System.out.println("Permanent Address should not be in special characters.");
			}
			else {
				System.out.println("Permanent Address is in correct order.");
			}
			Thread.sleep(1000);

			WebElement sub1 = this.xpath_locator("//*[@id=\"submit\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", sub1);
			sub1.click();
			String sub21 = "button";
			assertEquals(sub21, sub1.getAttribute("type"));
			Thread.sleep(1000);
			driver.navigate().refresh();
			Thread.sleep(1000);
			}

			///Invalid check
			@Test
			public  void Invalid_check() throws InterruptedException {

			WebElement txt2 = this.xpath_locator("//*[@id=\"userName\"]");
			txt2.click();
			txt2.sendKeys("1736378338490");
			String act1 = "1736378338490";
			assertEquals(act1, txt2.getAttribute("value"));
			if(act1.contains("1736378338490")) {
				System.out.println("\nFirst name should not be in numbers.");
			}
			else {
				System.out.println("First name is in correct order.");
			}

			WebElement txt3 = this.xpath_locator("//*[@id=\"userEmail\"]");
			txt3.click();
			txt3.sendKeys("6gtf6dut");
			String act2 = "6gtf6dut";
			assertEquals(act2, txt3.getAttribute("value"));
			if(act2.contains("6gtf6dut")) {
				System.out.println("Email should be in correct format.");
			}
			else {
				System.out.println("Email is in correct order.");
			}

			WebElement txt4 = this.xpath_locator("//*[@id=\"currentAddress\"]");
			txt4.click();
			txt4.sendKeys("tetebereteu@fgdhyu163738");
			String act3 = "tetebereteu@fgdhyu163738";
			assertEquals(act3, txt4.getAttribute("value"));
			if(act3.contains("tetebereteu@fgdhyu163738")) {
				System.out.println("Current Address should be valid one.");
			}
			else {
				System.out.println("Current Address is in correct order.");
			}
		
			WebElement txt5 = this.xpath_locator("//*[@id=\"permanentAddress\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			txt5.getText();
			txt5.sendKeys("tetebereteu@fgdhyu163738");
			String act4 = "tetebereteu@fgdhyu163738";
			assertEquals(act4, txt5.getAttribute("value"));
			if(act4.contains("tetebereteu@fgdhyu163738")) {
				System.out.println("Permanent Address should be valid one.");
			}
			else {
				System.out.println("Permanent Address is in correct order.");
			}
			Thread.sleep(1000);

			WebElement sub1 = this.xpath_locator("//*[@id=\"submit\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", sub1);
			sub1.click();
			String sub21 = "button";
			assertEquals(sub21, sub1.getAttribute("type"));
			Thread.sleep(1000);
			driver.navigate().refresh();
			Thread.sleep(1000);
			}
		
			///valid check
			@Test
			public  void valid_check() throws InterruptedException {
	
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
			String sub21 = "button";
			assertEquals(sub21, sub1.getAttribute("type"));
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
			
			WebElement chk2 = this.css_locator(".rct-option");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			chk2.click();
			String ckb2 = "button";
			assertEquals(ckb2,chk2.getAttribute("type"));
			Thread.sleep(1000);
			
			WebElement chk3 = this.xpath_locator("//label[@for='tree-node-angular']");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
//			WebElement chka = this.css_locator(chk3);
			chk3.click();
			boolean ckb3 = this.xpath_locator("//label[@for='tree-node-angular']").isDisplayed();
			boolean ckb4 = true;
			assertEquals(ckb3,ckb4);
			Thread.sleep(1000);
			
			WebElement chk4 = this.css_locator(".rct-option-collapse-all");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			chk4.click();
			String ckb41 = "button";
			assertEquals(ckb41,chk4.getAttribute("type"));
			String ckb42 = "angular";
			String ckb43 = this.css_locator(".text-success").getText();
			assertEquals(ckb42, ckb43);
			Thread.sleep(1000);
			
			
			WebElement chk5 = this.xpath_locator("//label[@for='tree-node-home']");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			chk5.click();
			boolean ckb51 = this.xpath_locator("//label[@for='tree-node-home']").isDisplayed();
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
			
			
			WebElement rd2 = this.xpath_locator("//label[@for='yesRadio']");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			rd2.click();
			String ybtn = "radio";
			WebElement rd21 = this.xpath_locator("//*[@id=\"yesRadio\"]");
			assertEquals(ybtn, rd21.getAttribute("type"));
			boolean rd22 = this.xpath_locator("//*[@id=\"yesRadio\"]").isSelected();
			boolean rd23 = true;
			assertEquals(rd22,rd23);
			String rd24 = "You have selected Yes";
			String rd25 = this.css_locator(".mt-3").getText();
			assertEquals(rd24, rd25);
			Thread.sleep(1000);
			
			WebElement rd3 = this.xpath_locator("//label[@for='impressiveRadio']");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			rd3.click();
			String impbtn = "radio";
			WebElement rd31 = this.xpath_locator("//*[@id=\"impressiveRadio\"]");
			assertEquals(impbtn, rd31.getAttribute("type"));
			boolean rd32 = this.xpath_locator("//*[@id=\"impressiveRadio\"]").isSelected();
			boolean rd33 = true;
			assertEquals(rd32,rd33);
			String rd34 = "You have selected Impressive";
			String rd35 = this.css_locator(".mt-3").getText();
			assertEquals(rd34, rd35);
			Thread.sleep(1000);
			
			WebElement rd4 = this.xpath_locator("//*[@id=\"noRadio\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
				if(rd4.isSelected()) {
						System.out.println("radio button is enabled");
					}
					else {
						System.out.println("radio button is not enabled");
					}
     			}
		
		///Web_tables add

        		@Test
			public void add_details() throws InterruptedException {
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
        		}
			/// Empty Check
       		 	@Test
			public void Empty_Details_check() throws InterruptedException {
			WebElement sbtn2 = this.xpath_locator("//*[@id=\"submit\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			sbtn2.click();
			Thread.sleep(300);
			
			WebElement inptem = this.css_locator("#firstName:invalid");
			assertTrue(inptem.isDisplayed());
			WebElement inptem1 = this.css_locator("#lastName:invalid");
			assertTrue(inptem1.isDisplayed());
			WebElement inptem2 = this.css_locator("#userEmail:invalid");
			assertTrue(inptem2.isDisplayed());
			WebElement inptem3 = this.css_locator("#age:invalid");
			assertTrue(inptem3.isDisplayed());
			WebElement inptem4 = this.css_locator("#salary:invalid");
			assertTrue(inptem4.isDisplayed());
			WebElement inptem5 = this.css_locator("#department:invalid");
			assertTrue(inptem5.isDisplayed());
        		}	
			/// Minimum Characters check 
        		@Test
			public void minimum_characters_details() throws InterruptedException {
			WebElement inpt = this.xpath_locator("//*[@id=\"firstName\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inpt.click();
			inpt.sendKeys("Vi");
			Thread.sleep(300);
			String inptbi2 = this.css_locator("#firstName:valid").getCssValue("border-color");
			String inptbi21 = "rgb(40, 167, 69)";
			assertEquals(inptbi2, inptbi21);
			boolean min1 = this.css_locator("#firstName:valid").isDisplayed();
			boolean min12 = true;
			assertEquals(min1,min12);
			String inpt12 = "Vi";
			assertEquals(inpt12, inpt.getAttribute("value"));
			Thread.sleep(500);
			
			WebElement inpt2 = this.xpath_locator("//*[@id=\"lastName\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inpt2.click();
			inpt2.sendKeys("rg");
			String min3 = "rg";
			assertEquals(min3, inpt2.getAttribute("value"));
			Thread.sleep(300);
			String minv1 = this.css_locator("#lastName:valid").getCssValue("border-color");
			String minv11 = "rgb(40, 167, 69)";
			assertEquals(minv1, minv11);
			
			boolean minv12 = this.css_locator("#lastName:valid").isDisplayed();
			boolean minv13 = true;
			assertEquals(minv12,minv13);
			Thread.sleep(200);
			
			WebElement inpt3 = this.xpath_locator("//*[@id=\"userEmail\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inpt3.click();
			inpt3.sendKeys("tr");
			String min4 = "tr";
			assertEquals(min4, inpt3.getAttribute("value"));
			Thread.sleep(300);
			String minv2 = this.css_locator("#userEmail:invalid").getCssValue("border-color");
			String minv21 = "rgb(220, 53, 69)";
			assertEquals(minv2, minv21);
			boolean minv22 = this.css_locator("#userEmail:invalid").isDisplayed();
			boolean minv23 = true;
			assertEquals(minv22,minv23);
			Thread.sleep(200);
			
			WebElement inpt4 = this.xpath_locator("//*[@id=\"age\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inpt4.click();
			inpt4.sendKeys(".,");
			String min5 = ".,";
			assertEquals(min5, inpt4.getAttribute("value"));
			Thread.sleep(300);
			String minv3 = this.css_locator("#age:invalid").getCssValue("border-color");
			String minv31 = "rgb(220, 53, 69)";
			assertEquals(minv3, minv31);
			boolean minv32 = this.css_locator("#age:invalid").isDisplayed();
			boolean minv33 = true;
			assertEquals(minv32,minv33);
			Thread.sleep(200);
			
			WebElement inpt5 = this.xpath_locator("//*[@id=\"salary\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inpt5.click();
			inpt5.sendKeys("01");
			String min6 = "01";
			assertEquals(min6, inpt5.getAttribute("value"));
			Thread.sleep(300);
			String minv6 = this.css_locator("#salary:valid").getCssValue("border-color");
			String minv61 = "rgb(40, 167, 69)";
			assertEquals(minv6, minv61);
			boolean minv62 = this.css_locator("#salary:valid").isDisplayed();
			boolean minv63 = true;
			assertEquals(minv62,minv63);
			Thread.sleep(500);
			
			WebElement inpt6 = this.xpath_locator("//*[@id=\"department\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inpt6.click();
			inpt6.sendKeys("rb");
			String min7 = "rb";
			assertEquals(min7, inpt6.getAttribute("value"));
			Thread.sleep(300);
			String minv7 = this.css_locator("#department:valid").getCssValue("border-color");
			String minv71 = "rgb(40, 167, 69)";
			assertEquals(minv7, minv71);
			boolean minv72 = this.css_locator("#department:valid").isDisplayed();
			boolean minv73 = true;
			assertEquals(minv72,minv73);
			Thread.sleep(500);
       			}	
			/// Maximum Characters check
        		@Test
			public void maximum_characters_details() throws InterruptedException {
        	
        		WebElement inpt = this.xpath_locator("//*[@id=\"firstName\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inpt.click();
			inpt.clear();
			inpt.sendKeys("ereeuruwigffffffffffffffe");
			String max1 = "ereeuruwigffffffffffffffe";
			assertEquals(max1, inpt.getAttribute("value"));
			
			Thread.sleep(500);
			String maxv1 = this.css_locator("#firstName:valid").getCssValue("border-color");
			String maxv11 = "rgb(40, 167, 69)";
			assertEquals(maxv1, maxv11);
			
			boolean maxv12 = this.css_locator("#firstName:valid").isDisplayed();
			boolean maxv13= true;
			assertEquals(maxv12,maxv13);
			Thread.sleep(300);
			
			WebElement inpt2 = this.xpath_locator("//*[@id=\"lastName\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inpt2.click();
			inpt2.clear();
			inpt2.sendKeys("dhgauoworyufajhfryuwrrooi");
			String max2 = "dhgauoworyufajhfryuwrrooi";
			assertEquals(max2, inpt2.getAttribute("value"));
			Thread.sleep(300);
			String maxv2 = this.css_locator("#lastName:valid").getCssValue("border-color");
			String maxv21 = "rgb(40, 167, 69)";
			assertEquals(maxv2, maxv21);
				
			boolean max22 = this.css_locator("#lastName:valid").isDisplayed();
			boolean max23 = true;
			assertEquals(max22,max23);
			Thread.sleep(200);
			
			WebElement inpt3 = this.xpath_locator("//*[@id=\"userEmail\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inpt3.click();
			inpt3.clear();
			inpt3.sendKeys("dshgDHRIjkfig124dsgu94@.,/");
			String max3 = "dshgDHRIjkfig124dsgu94@.,/";
			assertEquals(max3, inpt3.getAttribute("value"));
			Thread.sleep(300);
			String maxv3 = this.css_locator("#userEmail:invalid").getCssValue("border-color");
			String maxv31 = "rgb(220, 53, 69)";
			assertEquals(maxv3, maxv31);
			boolean maxv32 = this.css_locator("#userEmail:invalid").isDisplayed();
			boolean maxv33 = true;
			assertEquals(maxv32,maxv33);
			Thread.sleep(200);
			
			WebElement inpt5 = this.xpath_locator("//*[@id=\"salary\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inpt5.click();
			inpt5.clear();
			inpt5.sendKeys("2874494994");
			String max4 = "2874494994";
			assertEquals(max4, inpt5.getAttribute("value"));
			Thread.sleep(300);
			String maxv4 = this.css_locator("#salary:valid").getCssValue("border-color");
			String maxv41 = "rgb(40, 167, 69)";
			assertEquals(maxv4, maxv41);
			boolean maxv42 = this.css_locator("#salary:valid").isDisplayed();
			boolean maxv43 = true;
			assertEquals(maxv42,maxv43);
			Thread.sleep(500);
			
			WebElement inpt6 = this.xpath_locator("//*[@id=\"department\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inpt6.click();
			inpt6.clear();
			inpt6.sendKeys("ejgjdshfuisgiuritufvcbwtr");
			String max5 = "ejgjdshfuisgiuritufvcbwtr";
			assertEquals(max5, inpt6.getAttribute("value"));
			Thread.sleep(300);
			String maxv5 = this.css_locator("#department:valid").getCssValue("border-color");
			String maxv51 = "rgb(40, 167, 69)";
			assertEquals(maxv5, maxv51);
			boolean maxv52 = this.css_locator("#department:valid").isDisplayed();
			boolean maxv53 = true;
			assertEquals(maxv52,maxv53);
			Thread.sleep(500);
        		}
			///special characters check
        		@Test
        		public void special_characters_details() throws InterruptedException {
              	
            		WebElement inpt = this.xpath_locator("//*[@id=\"firstName\"]");
      			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inpt.click();
			inpt.clear();
			inpt.sendKeys("!@#$%^&*()_-+={}[]|?/.<>,");
			String spcl1 = "!@#$%^&*()_-+={}[]|?/.<>,";
			assertEquals(spcl1, inpt.getAttribute("value"));
			Thread.sleep(400);
			
			if(spcl1.contains("!@#$%^&*()_-+={}[]|?/.<>,")){
				System.out.println("\nFirst Name should not be Special Charcters");
			}
			else {
				System.out.println("\nFirst Name contains only valid Charcters");
			}
			
			WebElement inpt2 = this.xpath_locator("//*[@id=\"lastName\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inpt2.click();
			inpt2.clear();
			inpt2.sendKeys("!@#$%^&*()_-+={}[]|?/.<>,");
			String spcl2 = "!@#$%^&*()_-+={}[]|?/.<>,";
			assertEquals(spcl2, inpt2.getAttribute("value"));
			Thread.sleep(400);
			
			if(spcl2.contains("!@#$%^&*()_-+={}[]|?/.<>,")){
				System.out.println("\nLast Name should not be Special Charcters");
			}
			else {
				System.out.println("\nLast Name contains only valid Charcters");
			}
			
			WebElement inpt3 = this.xpath_locator("//*[@id=\"userEmail\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inpt3.click();
			inpt3.clear();
			inpt3.sendKeys("!@#$%^&*()_-+={}[]|?/.<>,");
			String spcl3 = "!@#$%^&*()_-+={}[]|?/.<>,";
			assertEquals(spcl3, inpt3.getAttribute("value"));
			Thread.sleep(300);

			if(spcl3.contains("!@#$%^&*()_-+={}[]|?/.<>,")){
				System.out.println("\nEmail all charcters should not be Special Charcters");
			}
			else {
				System.out.println("\nEmail contains only valid format");
			}
			
			WebElement inpt4 = this.xpath_locator("//*[@id=\"age\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inpt4.click();
			inpt4.clear();
			inpt4.sendKeys("@#");
			String spcl4 = "@#";
			assertEquals(spcl4, inpt4.getAttribute("value"));
			Thread.sleep(300);
			
			if(spcl4.contains("@#")){
				System.out.println("\nAge should not be Special Charcters");
			}
			else {
				System.out.println("\nAge contains only numbers");
			}
			
			WebElement inpt5 = this.xpath_locator("//*[@id=\"salary\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inpt5.click();
			inpt5.clear();
			inpt5.sendKeys("!@#$%^&*()");
			String spcl5 = "!@#$%^&*()";
			assertEquals(spcl5, inpt5.getAttribute("value"));
			Thread.sleep(300);
			
			if(spcl5.contains("!@#$%^&*()")){
				System.out.println("\nSalary should not be Special Charcters");
			}
			else {
				System.out.println("\nSalary contains only numbers");
			}
			
			WebElement inpt6 = this.xpath_locator("//*[@id=\"department\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inpt6.click();
			inpt6.clear();
			inpt6.sendKeys("!@#$%^&*()_-+={}[]|?/.<>,");
			String spcl6 = "!@#$%^&*()_-+={}[]|?/.<>,";
			assertEquals(spcl6, inpt6.getAttribute("value"));
			Thread.sleep(300);
			
			if(spcl6.contains("!@#$%^&*()_-+={}[]|?/.<>,")){
				System.out.println("\nDepartment should not be Special Charcters");
			}
			else {
				System.out.println("\nDepartment contains only Specified name");
			}
        		}
			///Invalid check
        		@Test
        		public void Invalid_details() throws InterruptedException {
        		WebElement inpt = this.xpath_locator("//*[@id=\"firstName\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inpt.click();
			inpt.clear();
			inpt.sendKeys("Vishnu");
			String inpt18 = "Vishnu";
			assertEquals(inpt18, inpt.getAttribute("value"));
			
			Thread.sleep(500);
			String inptbi = this.css_locator("#firstName:valid").getCssValue("border-color");
			String inptbi1 = "rgb(40, 167, 69)";
			assertEquals(inptbi, inptbi1);
			
			boolean inptv14 = this.css_locator("#firstName:valid").isDisplayed();
			boolean inptv15 = true;
			assertEquals(inptv14,inptv15);
			Thread.sleep(200);
			
			
			WebElement inpt2 = this.xpath_locator("//*[@id=\"lastName\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inpt2.click();
			inpt2.clear();
			inpt2.sendKeys("Priyan");
			String inpt21 = "Priyan";
			assertEquals(inpt21, inpt2.getAttribute("value"));
			Thread.sleep(300);
			String inptbi22 = this.css_locator("#lastName:valid").getCssValue("border-color");
			String inptbi23 = "rgb(40, 167, 69)";
			assertEquals(inptbi22, inptbi23);
			
			boolean inptl = this.css_locator("#lastName:valid").isDisplayed();
			boolean inptl1 = true;
			assertEquals(inptl,inptl1);
			Thread.sleep(200);
			
			WebElement sbtn2 = this.xpath_locator("//*[@id=\"submit\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			sbtn2.click();
			Thread.sleep(200);
			
			WebElement inpt3 = this.xpath_locator("//*[@id=\"userEmail\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inpt3.click();
			inpt3.clear();
			inpt3.sendKeys("vishnu1234");
			String inpt31 = "vishnu1234";
			assertEquals(inpt31, inpt3.getAttribute("value"));
			Thread.sleep(300);
			String inptbi3 = this.css_locator("#userEmail:invalid").getCssValue("border-color");
			String inptbi31 = "rgb(220, 53, 69)";
			assertEquals(inptbi3, inptbi31);
			boolean inptm = this.css_locator("#userEmail:invalid").isDisplayed();
			boolean m1 = true;
			assertEquals(inptm,m1);
			Thread.sleep(200);
			
			sbtn2 = this.xpath_locator("//*[@id=\"submit\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			sbtn2.click();
			Thread.sleep(200);
			
			WebElement inpt4 = this.xpath_locator("//*[@id=\"age\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inpt4.click();
			inpt4.clear();
			inpt4.sendKeys("vv");
			String inpt41 = "vv";
			assertEquals(inpt41, inpt4.getAttribute("value"));
			Thread.sleep(300);
			String inptbi4 = this.css_locator("#age:invalid").getCssValue("border-color");
			String inptbi41 = "rgb(220, 53, 69)";
			assertEquals(inptbi4, inptbi41);
			boolean inpta = this.css_locator("#age:invalid").isDisplayed();
			boolean inpta1 = true;
			assertEquals(inpta,inpta1);
			Thread.sleep(200);
			
			sbtn2 = this.xpath_locator("//*[@id=\"submit\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			sbtn2.click();
			Thread.sleep(200);
			
			WebElement inpt5 = this.xpath_locator("//*[@id=\"salary\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inpt5.click();
			inpt5.clear();
			inpt5.sendKeys("gdgyu");
			String inpt51 = "gdgyu";
			assertEquals(inpt51, inpt5.getAttribute("value"));
			Thread.sleep(300);
			String inptbi5 = this.css_locator("#salary:invalid").getCssValue("border-color");
			String inptbi51 = "rgb(220, 53, 69)";
			assertEquals(inptbi5, inptbi51);
			boolean inpts = this.css_locator("#salary:invalid").isDisplayed();
			boolean inpts1 = true;
			assertEquals(inpts,inpts1);
			Thread.sleep(500);
			
			sbtn2 = this.xpath_locator("//*[@id=\"submit\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			sbtn2.click();
			Thread.sleep(200);
			
			WebElement inpt6 = this.xpath_locator("//*[@id=\"department\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inpt6.click();
			inpt6.clear();
			inpt6.sendKeys("76748494");
			String inpt61 = "76748494";
			assertEquals(inpt61, inpt6.getAttribute("value"));
			Thread.sleep(300);
			String inptbi6 = this.css_locator("#department:valid").getCssValue("border-color");
			String inptbi61 = "rgb(40, 167, 69)";
			assertEquals(inptbi6, inptbi61);
			boolean inptd = this.css_locator("#department:valid").isDisplayed();
			boolean inptd1 = true;
			assertEquals(inptl,inptl1);
			Thread.sleep(500);
       			}	
			///Valid check
        		@Test
        		public void valid_details() throws InterruptedException {
        		
        		WebElement inpt = this.xpath_locator("//*[@id=\"firstName\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inpt.click();
			inpt.clear();
			inpt.sendKeys("Vishnu");
			String inpt13 = "Vishnu";
			assertEquals(inpt13, inpt.getAttribute("value"));
			Thread.sleep(300);
			String inptv= this.css_locator("#firstName:valid").getCssValue("border-color");
			String inptv1 = "rgb(40, 167, 69)";
			assertEquals(inptv, inptv1);
			boolean inptf = this.css_locator("#firstName:valid").isDisplayed();
			boolean inptf1 = true;
			assertEquals(inptf,inptf1);
			Thread.sleep(500);
			
			WebElement inpt2 = this.xpath_locator("//*[@id=\"lastName\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inpt2.click();
			inpt2.clear();
			inpt2.sendKeys("Priyan");
			String inpt22 = "Priyan";
			assertEquals(inpt22, inpt2.getAttribute("value"));
			Thread.sleep(300);
			String inptv2= this.css_locator("#lastName:valid").getCssValue("border-color");
			String inptv21 = "rgb(40, 167, 69)";
			assertEquals(inptv2, inptv21);
			boolean inptl2 = this.css_locator("#lastName:valid").isDisplayed();
			boolean inptl3 = true;
			assertEquals(inptl2,inptl3);
			Thread.sleep(200);
			
			WebElement inpt3 = this.xpath_locator("//*[@id=\"userEmail\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inpt3.click();
			inpt3.clear();
			inpt3.sendKeys("vishnu1234@gmail.com");
			String inpt32 = "vishnu1234@gmail.com";
			assertEquals(inpt32, inpt3.getAttribute("value"));
			Thread.sleep(300);
			String inptv3= this.css_locator("#userEmail:valid").getCssValue("border-color");
			String inptv31 = "rgb(40, 167, 69)";
			assertEquals(inptv3, inptv31);
			boolean inptm2 = this.css_locator("#userEmail:valid").isDisplayed();
			boolean inptm3 = true;
			assertEquals(inptm2,inptm3);
			Thread.sleep(200);
			
			WebElement inpt4 = this.xpath_locator("//*[@id=\"age\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inpt4.click();
			inpt4.clear();
			inpt4.sendKeys("23");
			String inpt42 = "23";
			assertEquals(inpt42, inpt4.getAttribute("value"));
			Thread.sleep(300);
			String inptv4= this.css_locator("#age:valid").getCssValue("border-color");
			String inptv41 = "rgb(40, 167, 69)";
			assertEquals(inptv4, inptv41);
			boolean inpta2 = this.css_locator("#age:valid").isDisplayed();
			boolean inpta3 = true;
			assertEquals(inpta2,inpta3);
			Thread.sleep(200);
			
			WebElement inpt5 = this.xpath_locator("//*[@id=\"salary\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inpt5.click();
			inpt5.clear();
			inpt5.sendKeys("15000");
			String inpt52 = "15000";
			assertEquals(inpt52, inpt5.getAttribute("value"));
			Thread.sleep(300);
			String inptv5= this.css_locator("#salary:valid").getCssValue("border-color");
			String inptv51 = "rgb(40, 167, 69)";
			assertEquals(inptv5, inptv51);
			boolean inpts2 = this.css_locator("#salary:valid").isDisplayed();
			boolean inpts3 = true;
			assertEquals(inpts2,inpts3);
			Thread.sleep(200);
			
			WebElement inpt6 = this.xpath_locator("//*[@id=\"department\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			inpt6.click();
			inpt6.clear();
			inpt6.sendKeys("Finance");
			String inpt62 = "Finance";
			assertEquals(inpt62, inpt6.getAttribute("value"));
			Thread.sleep(300);
			String inptv6= this.css_locator("#department:valid").getCssValue("border-color");
			String inptv61 = "rgb(40, 167, 69)";
			assertEquals(inptv6, inptv61);
			boolean inptd2 = this.css_locator("#department:valid").isDisplayed();
			boolean inptd3 = true;
			assertEquals(inptd2,inptd3);
			Thread.sleep(200);
			
			WebElement sbtn2 = this.xpath_locator("//*[@id=\"submit\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			sbtn2.click();
			String sbtn21 = "submit";
			assertEquals(sbtn21, sbtn2.getAttribute("type"));
			Thread.sleep(1000);
			Thread.sleep(200);
        	}
			///Another Data
			@Test
        		public void Another_new_data() throws InterruptedException {
        		
			WebElement wet1 = this.xpath_locator("//*[@id=\"addNewRecordButton\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
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
			
		    	WebElement sbtn3 = this.xpath_locator("//*[@id=\"submit\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			sbtn3.submit();
			Thread.sleep(800);
			}
			
			///searching the appended data
			@Test
        		public void searching_data() throws InterruptedException {
				
			WebElement srch = this.xpath_locator("//*[@id=\"searchBox\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			srch.click();
			srch.sendKeys("Vi");
			String srch1 = "Vi";
			assertEquals(srch1, srch.getAttribute("value"));
			String srch2 = "Vishnu";
			String srch21 = this.xpath_locator("//div[text()='Vishnu']").getText();
			assertEquals(srch2,srch21);
			Thread.sleep(1500);
		}
			
			////Deleting the data
			@Test
        		public void deleting_data() throws InterruptedException {
			
			WebElement del = this.xpath_locator("//*[@id=\"delete-record-4\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			boolean del1 = this.xpath_locator("//*[@id=\"delete-record-4\"]").isDisplayed();
			boolean del2 = true;
			assertEquals(del1,del2);
			del.click();
		
			WebElement srch = this.xpath_locator("//*[@id=\"searchBox\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			srch.click();
			srch.sendKeys(Keys.BACK_SPACE);
			srch.click();
			srch.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(1000);
		}
		
			////Deleting the data
			@Test
		    	public void editing_data() throws InterruptedException {
					
			WebElement edt = this.xpath_locator("//*[@id=\"edit-record-1\"]");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			edt.click();

			boolean edbt = this.css_locator("#edit-record-1").isDisplayed();
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
      
			 Select drp = new Select(this.xpath_locator("//select[@aria-label='rows per page']"));
			 drp.selectByVisibleText("10 rows");
			 driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			 boolean drpcon = this.xpath_locator("//option[@value='10']").isSelected();
			 boolean drpcon1 = true;
			 assertEquals(drpcon, drpcon1);
			 Thread.sleep(1000);
			 WebElement row_page = this.xpath_locator("//select[@aria-label='rows per page']");
			 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", row_page);
			 drp.selectByIndex(2);
			 driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			 
			 String drp1 = "20 rows";
			 String drp11 = drp.getFirstSelectedOption().getText();
			 assertEquals(drp1, drp11);
			 Thread.sleep(1000);
			 boolean drp12 = this.xpath_locator("//option[@value='20']").isSelected();
			 boolean drp13 = true;
			 assertEquals(drp12, drp13);
			 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", row_page);
			 drp.selectByIndex(3);
			 driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			 
			 String drp2 = "25 rows";
			 String drp21 = drp.getFirstSelectedOption().getText();
			 assertEquals(drp2, drp21);
			 Thread.sleep(1000);
			 boolean drp22 = this.xpath_locator("//option[@value='25']").isSelected();			 
			 boolean drp23 = true;
			 assertEquals(drp22, drp23);
			 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", row_page);
			 drp.selectByIndex(4);
			 driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			 
			 String drp3 = "50 rows";
			 String drp31 = drp.getFirstSelectedOption().getText();
			 assertEquals(drp3, drp31);
			 Thread.sleep(1000);
			 boolean drp32 = this.xpath_locator("//option[@value='50']").isSelected();
			 boolean drp33 = true;
			 assertEquals(drp32, drp33);
			 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", row_page);
			 drp.selectByIndex(5);
			 driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			 
			 String drp4 = "100 rows";
			 String drp41 = drp.getFirstSelectedOption().getText();
			 assertEquals(drp4, drp41);
			 Thread.sleep(1000);
			 boolean drp42 = this.xpath_locator("//option[@value='100']").isSelected();
			 boolean drp43 = true;
			 assertEquals(drp42, drp43);
			 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", row_page);
			 drp.selectByIndex(0);
			 driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			 String drp5 = "5 rows";
			 String drp51 = drp.getFirstSelectedOption().getText();
			 assertEquals(drp5, drp51);
			 Thread.sleep(1000);
			 boolean drp52 = this.xpath_locator("//option[@value='5']").isSelected();
			 boolean drp53 = true;
			 assertEquals(drp52, drp53);
//			 Thread.sleep(1000);
		}
        
        	///double click button
        	@Test
        	public void double_click_button() throws InterruptedException {
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
		}
		
		///rightclick_button
		@Test
        	public void right_click_button() throws InterruptedException {
		
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
		}
		
		///dynamic click
		@Test
       	 	public void dynamic_click_button() throws InterruptedException {
			WebElement dclk = this.xpath_locator("//button[text()='Click Me']");
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			dclk.click();
//			Thread.sleep(1000);
			String dclk1 = "You have done a dynamic click";
			String dclk12 = this.css_locator("#dynamicClickMessage").getText();
			assertEquals(dclk1, dclk12);
			String dclk13 = "button";
			assertEquals(dclk13, dclk.getAttribute("type"));
			Thread.sleep(1000);
        }
        
        	///simple_Links
        
       	 	@Test
        	public void simple_link() throws InterruptedException {
        	
        	WebElement lnk = this.xpath_locator("//*[@id=\"item-5\"]");
        	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", lnk);
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		    	lnk.click();
		    	String lnk_chk = "https://demoqa.com/links";
			assertEquals(lnk_chk, driver.getCurrentUrl());
			Thread.sleep(1000);
			
			WebElement simple_lnk =this.css_locator("#simpleLink");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", simple_lnk);
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
			simple_lnk.click();
			Thread.sleep(1000);
			String mainW = driver.getWindowHandle();
			Set<String> mainW1 = driver.getWindowHandles();
			ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			driver.close();
			driver.switchTo().window(tabs2.get(0));
			Thread.sleep(1500);
        }
        
        ///Dynamic_link
        @Test
        public void Dynamic_link() throws InterruptedException {
        	
        	WebElement lnk = this.xpath_locator("//*[@id=\"item-5\"]");
        	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", lnk);
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		    	lnk.click();
		    	String lnk_chk = "https://demoqa.com/links";
			assertEquals(lnk_chk, driver.getCurrentUrl());
			Thread.sleep(1000);
			
			WebElement lnk2 = this.xpath_locator("//*[@id=\"dynamicLink\"]");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", lnk2);
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		    	lnk2.click();
		    	Thread.sleep(3000);
		    	String mainW2 = driver.getWindowHandle();
	        	Set<String> mainW21 = driver.getWindowHandles();
	    		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			driver.close();
			driver.switchTo().window(tabs2.get(0));
			Thread.sleep(1500);
       }

        /// created API call
        @Test
        public void create_API_call() throws InterruptedException {
        	
        	WebElement lnk = this.xpath_locator("//*[@id=\"item-5\"]");
        	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", lnk);
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		    	lnk.click();
		    	String lnk_chk = "https://demoqa.com/links";
			assertEquals(lnk_chk, driver.getCurrentUrl());
			Thread.sleep(1000);
			WebElement api1 = this.xpath_locator("//*[@id=\"created\"]");
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		    	api1.click();
		    	String api11 = "201";
			String api12 = this.xpath_locator("//*[@id=\"linkResponse\"]/b[1]").getText();
			WebElement api13 = this.xpath_locator("//*[@id=\"linkResponse\"]/b[1]");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", api13);
			assertEquals(api11, api12);
			driver.navigate().refresh();
        }
        
        ///No-content API
        @Test
        public void no_content_call() throws InterruptedException {
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
        }
        
        ///moved API
        @Test
        public void moved_API_call() throws InterruptedException {
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
        }
        
        ///bad-request API call
        @Test
        public void bad_request_call() throws InterruptedException {
			
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
        }
        
        ///unauthorized API call
        @Test
        public void unauthorized_API_call() throws InterruptedException {
        	
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
        }
        
        ///forbidden API call
        @Test
        public void forbidden_API_call() throws InterruptedException {
			
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
        }
        
        ///invalid_url API call
        @Test
        public void invalid_url_API_call() throws InterruptedException {
        	
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
        
        ///valid-Image
        
        @Test
        public void valid_image() throws InterruptedException {
        	WebElement b_link = this.xpath_locator("//*[@id=\"item-6\"]");
        	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", b_link);
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		    b_link.click();
		    String blnk_chk = "https://demoqa.com/broken";
			assertEquals(blnk_chk, driver.getCurrentUrl());
			Thread.sleep(1000);
	
			WebElement img1 = this.xpath_locator("//img[@src='/images/Toolsqa.jpg']");
			Boolean img11 = (Boolean) ((JavascriptExecutor)driver) .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", img1);

				if (img11) {
					    	System.out.println("\nTools QA logo is present");
				} 	
				else {
							System.out.println("Tools QA logo is not present");
				     }
        }
		///Broken-image
			
			@Test
		    	public void broken_image() throws InterruptedException {
			WebElement img2 = this.xpath_locator("//img[@src='/images/Toolsqa_1.jpg']");
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
	
				if(img2.isSelected()) {
					System.out.println("Image is enabled");
				}
				else {
					System.out.println("\nImage is disabled");
				}
				
			Thread.sleep(1000);
			}
			
			///valid link
			@Test
		    	public void valid_link() throws InterruptedException {
				
			WebElement valid_lnk = this.xpath_locator("//a[text()='Click Here for Valid Link']");
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", valid_lnk);
			valid_lnk.click();
			Thread.sleep(1300);
			String valid_lnk1 = "https://demoqa.com/";
			
			assertEquals(valid_lnk1, driver.getCurrentUrl());
			Thread.sleep(1000);
			driver.navigate().back();  
			Thread.sleep(1500);
			}
			
			///broken link
			@Test
		    	public void broken_link() throws InterruptedException {
				
			WebElement brk_lnk = this.xpath_locator("//a[text()='Click Here for Broken Link']");
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", brk_lnk);
			brk_lnk.click();
			Thread.sleep(1700);
			String brk_lnk1 = "http://the-internet.herokuapp.com/status_codes/500";
			assertEquals(brk_lnk1, driver.getCurrentUrl());
			Thread.sleep(1000);
			String brk_lnk12 =   
				"This page returned a 500 status code.\n\nFor a definition and common list of HTTP status codes, go here";
			String brk_lnk13 = this.xpath_locator("//*[@id=\"content\"]/div/p").getText();
			assertEquals(brk_lnk12, brk_lnk13);
			Thread.sleep(1000);
			}
			
			///status code
			@Test
		    	public void status_code() throws InterruptedException {
				
			WebElement brk_lnk2 = this.xpath_locator("//a[@href='/status_codes']");
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			brk_lnk2.click();
			Thread.sleep(700);
			String brk_lnk21 = "http://the-internet.herokuapp.com/status_codes";
			assertEquals(brk_lnk21, driver.getCurrentUrl());
			driver.navigate().back();  
			driver.navigate().back();
        }
        
        //download
        
        @Test
        public void download() throws InterruptedException, IOException {
        	WebElement up = this.xpath_locator("//*[@id=\"item-7\"]");
        	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", up);
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		    	up.click();
		   	String up1 = "https://demoqa.com/upload-download";
			assertEquals(up1, driver.getCurrentUrl());
			Thread.sleep(1000);
			
			WebElement dwn = this.xpath_locator("//*[@id=\"downloadButton\"]");
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		    	dwn.click();
		    	String dwn1 = "sampleFile.jpeg";
			assertEquals(dwn1, dwn.getAttribute("download"));
			Thread.sleep(1000);
        }
        
        ///download
        @Test
        public void upload() throws InterruptedException, IOException {
        	
			WebElement up11  = this.xpath_locator("//*[@id=\"uploadFile\"]");
			up11.sendKeys("/home/zoho/Pictures/nature.jpg");
			assertEquals("C:\\fakepath\\nature.jpg",up11.getAttribute("value"));	
			Thread.sleep(1000);
			
        }
        
        ///dynamicProperties
        
        @Test
        
        public void dynamic_properties() throws InterruptedException {
        	WebElement prop = this.xpath_locator("//*[@id=\"item-8\"]");
        	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", prop);
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		    prop.click();
		    String prop1 = "https://demoqa.com/dynamic-properties";
			assertEquals(prop1, driver.getCurrentUrl());
			Thread.sleep(5000);
			
			WebElement prop2 = this.xpath_locator("//*[@id=\"visibleAfter\"]");
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		    	String prop21 = "Visible After 5 Seconds";
			assertEquals(prop21, prop2.getText());
			Thread.sleep(1000);
			WebElement prop3 = driver.findElement(By.className("text-danger"));
			String prop31 = "rgba(220, 53, 69, 1)";
			assertEquals(prop31, prop3.getCssValue("color"));
			driver.close();
        }
      
	    @AfterAll
	
	        public void clse() {
	    	driver.quit();
	    }
}
