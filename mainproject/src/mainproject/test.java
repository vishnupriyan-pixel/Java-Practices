package mainproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

@SuppressWarnings("unused")
public class test {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/home/zoho/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		
// 		System.setProperty("webdriver.gecko.driver", "/home/zoho/Downloads/geckodriver");
// 		WebDriver driver = new  FirefoxDriver();
		driver.manage().window().maximize();
		
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
	     
	           try{
	                   Assert.assertEquals(ActualData, ExpectedData);
	                   System.out.println("\nCurrent Url is: Pass");
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
//              System.out.println(ExpectedData);
        
                boolean txt2 = driver.findElement(By.xpath("//*[@id=\"fname\"]")).isEnabled();
                boolean txt3 = true;
        
                    try {
        	            Assert.assertEquals(txt2, txt3);
        	            System.out.println("\nA Textbox field is enabled");
                        }

                    catch(AssertionError e){
        	            System.out.println("\nA Textbox field is disabled");
                        }
        
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
//		Thread.sleep(1200);
		
		ActualData = "button";
	        ExpectedData = btn.getAttribute("type");
//	        System.out.println(ExpectedData);
	     
	             try {
	   		      Assert.assertEquals(ActualData, ExpectedData);
	   		      System.out.println("\nIt is a Submit button : Pass");
	   	         }
	   	     catch(AssertionError e) {
	   		      System.out.println("\nFail");
	   	         }
	       
	      btn.click();
	      ActualData = "Click me!!";
	      ExpectedData = btn.getAttribute("title");
//	      System.out.println(ExpectedData);
		     
                     try {
		   	      Assert.assertEquals(ActualData, ExpectedData);
		   	      System.out.println("A button is clicked : Pass");
		         }
		      catch(AssertionError e) {
		   		     System.out.println("Fail");
		   	 }
		       
	       boolean  btn1 = driver.findElement(By.xpath("//*[@id=\"idOfButton\"]")).isEnabled();
	       boolean btn2 = true;
		
		     try {
			       Assert.assertEquals(btn1, btn2);
			       System.out.println("The button is enabled");
			 }
		     catch(AssertionError e) {
			       System.out.println("The button is disabled");
			 }
		
	       driver.navigate().refresh();
		
		
	       ///radioButtonsCheck

	       WebElement rdbt = driver.findElement(By.xpath("//*[@value=\"male\"]"));
	       driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
	       rdbt.click();
//	       Thread.sleep(1000);
		
	       ActualData = "radio";
	       ExpectedData = rdbt.getAttribute("type");
//	       System.out.println(ExpectedData);
	       
	     
	       boolean rdbt11 = driver.findElement(By.xpath("//*[@value=\"male\"]")).isSelected();
	       boolean rdbt12 = true;
	     
	             try {
	    	              Assert.assertEquals(rdbt11,rdbt12);
	    	              System.out.println("\nMale is selected");
	                 }
	     
	             catch(AssertionError e) {
	    	         System.out.println("Male is unselected");
	                 }
	
	    	     try {
	   		       Assert.assertEquals(ActualData, ExpectedData);
	   		       System.out.println("A male radio button : Pass");
	   	         }
	   	     catch(AssertionError e) {
	   		       System.out.println("Fail");
	   		 }
	       
	      boolean rdbtm1 = driver.findElement(By.xpath("//*[@value=\"male\"]")).isEnabled();
	      boolean rdbtm2 = true;
	       
	            try {
		   	       Assert.assertEquals(rdbtm1, rdbtm2);
		   	       System.out.println("Male radio button is enabled");
		   	}
		    catch(AssertionError e) {
		   	       System.out.println("Male radio button is disabled");
		   		
		   	}
	       
	       
	      driver.navigate().refresh();
		
		
	      WebElement rdbt1 = driver.findElement(By.xpath("//*[@value=\"female\"]"));
	      driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
	      rdbt1.click();
//	      Thread.sleep(1200);
		
	      ActualData = "radio";
	      ExpectedData = rdbt1.getAttribute("type");
//	      System.out.println(ExpectedData);
	     
	      boolean rdbt13 = driver.findElement(By.xpath("//*[@value=\"female\"]")).isSelected();
	      boolean rdbt14 = true;
	     
	            try {
	        	      Assert.assertEquals(rdbt13, rdbt14);
	    	              System.out.println("\nFemale is selected");
	                }
	       
	            catch(AssertionError e) {
	          
	        	      System.out.println("Female is unselected");
	                }
	     
	            try {
	   		      Assert.assertEquals(ActualData, ExpectedData);
	   		      System.out.println("A female radio button : Pass");
	   	        }
	   	      catch(AssertionError e) {
	   		      System.out.println("Fail");
	   	        }
	       
	      boolean rdbtf1 = driver.findElement(By.xpath("//*[@value=\"female\"]")).isEnabled();
	      boolean rdbtf2 = true;
	    
	            try {
	   		       Assert.assertEquals(rdbtf1, rdbtf2);
	   		       System.out.println("A female radio button is enabled");
	   	        }
	   	    catch(AssertionError e) {
	   		       System.out.println("A female radio button is disabled");
	   	        }
		
	      driver.navigate().refresh();
		
	      ///checkBox
		
	      WebElement chck = driver.findElement(By.xpath("//*[@value=\"Automation\"]"));
	      driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
	      chck.click();
	      Thread.sleep(1200);
		
	      ActualData = "checkbox";
	      ExpectedData = chck.getAttribute("type");
//	      System.out.println(ExpectedData);
	     
	      boolean autchk = driver.findElement(By.xpath("//*[@value=\"Automation\"]")).isSelected();
	      boolean autchk1 = true;
	      
	           try {
	    	             Assert.assertEquals(autchk, autchk1);
	    	             System.out.println("\nAutomation is checked");
	               }
	     
	           catch(AssertionError e) {
	          
	    	             System.out.println("Automation is not checked");
	               }
	     
	           try {
	   		      Assert.assertEquals(ActualData, ExpectedData);
	   		      System.out.println("first checkbox : Pass");
	   	       }
	   	      catch(AssertionError e) {
	   		      System.out.println("Fail");
	   	       }
		
	       boolean fchck = driver.findElement(By.xpath("//*[@value=\"Automation\"]")).isEnabled();
	       boolean fchck1 = true;
	       
	           try {
		    	      Assert.assertEquals(fchck, fchck1);
		    	      System.out.println("Automation option is enabled");
		       }
		     
		   catch(AssertionError e) {
		    	      System.out.println("Automation option is disabled");
		       }
	        driver.navigate().refresh();
		
		
	        WebElement chck1 = driver.findElement(By.xpath("//*[@value=\"Performance\"]"));
	        driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
	        chck1.click();
	        Thread.sleep(1000);
		
	        ActualData = "checkbox";
	        ExpectedData = chck1.getAttribute("type");
//	        System.out.println(ExpectedData);
	     
                boolean pefchk = driver.findElement(By.xpath("//*[@value=\"Performance\"]")).isSelected();
                boolean pefchk1 = true;
	     
	           try {
	    	             Assert.assertEquals(pefchk, pefchk1);
	    	             System.out.println("\nPerformance is checked");
	               }
	     
	           catch(AssertionError e) { 
	    	         System.out.println("Performance is not checked");
	               }
	       
	           try {
	   		      Assert.assertEquals(ActualData, ExpectedData);
	   		      System.out.println("second checkbox : Pass");
	   	       }
	   	   catch(AssertionError e) {
	   		      System.out.println("Fail");
	   	       }
	       
	         boolean schck1 = driver.findElement(By.xpath("//*[@value=\"Performance\"]")).isEnabled();
	         boolean schck2 = true;
	       
	           try {
		   	      Assert.assertEquals(schck1, schck2);
		   	      System.out.println("Performance checkbox is enabled");
		       }
		   catch(AssertionError e) {
		   	      System.out.println("Performance checkbox is disabled");
		       }
	       
		 driver.navigate().refresh();
		
		 WebElement chck2 = driver.findElement(By.xpath("//*[@value=\"Automation\"]"));
		 chck2.click();
		 WebElement chck3 = driver.findElement(By.xpath("//*[@value=\"Performance\"]"));
	         chck3.click();   
	       
	         ActualData = "checkbox";
	         ExpectedData = chck2.getAttribute("type");
	    
	         boolean dbb = chck2.isSelected();
	         dbb = chck3.isSelected();
	         boolean dbb1 = true;
	    
	    
	           try {
	    	             Assert.assertEquals(dbb, dbb1);
	    	             System.out.println("\nBoth Automation and Peformance is checked");
	               }
	    
	         catch(AssertionError e) {
	    	             System.out.println("Both Automation and Peformance is not checked");
	               }
	    
	           try {
	    	             Assert.assertEquals(dbb, dbb1);
	    	             System.out.println("Both Automation and Peformance checkboxes : Pass ");
	               }
	    
	           catch(AssertionError e) {
	    	             System.out.println("Both Automation and Peformance is check : Pass");
	               }
		
	         boolean dbb2 = chck2.isEnabled();
	         dbb2 = chck3.isEnabled();
	         boolean dbb3 = true;
	    
	           try {
	    	            Assert.assertEquals(dbb2, dbb3);
	    	            System.out.println("Both Automation and Peformance checkboxes are enabled");
	               }
	    
	           catch(AssertionError e) {
	    	            System.out.println("Both Automation and Peformance checkboxes are disabled");
	               }
	    
	        driver.navigate().refresh();
		
	        //dropDown
		
	         Select drp = new Select(driver.findElement(By.xpath("//*[@id=\"testingDropdown\"]")));
	         drp.selectByVisibleText("Automation Testing");
	         driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		
	        ActualData = "Automation Testing";
                ExpectedData = drp.getFirstSelectedOption().getText();
//              System.out.println( ExpectedData);
     
                boolean drp_aut = driver.findElement(By.xpath("//*[@id=\"automation\"]")).isSelected();
                boolean drp_aut1 = true;
     
                  try {
    	                   Assert.assertEquals(drp_aut, drp_aut1);
    	                   System.out.println("\nAutomation Testing is selected");
                      }
                  catch(AssertionError e) {
    	                   System.out.println("Automation Testing is not selected");
                      }
	       
	          try {
	   		   Assert.assertEquals(ActualData, ExpectedData);
	   		   System.out.println("Dropdown option1 is selected : Pass");
	   	      }
	   	     catch(AssertionError e) {
	   		   System.out.println("Fail");
	   	      }
	       
	        boolean dpd1 = driver.findElement(By.xpath("//*[@id=\"automation\"]")).isEnabled();
	        boolean dpd2 = true;
	       
	          try {
		           Assert.assertEquals(dpd1, dpd2);
		   	   System.out.println("Automation Testing is enabled");
		      }
		  catch(AssertionError e) {
		   	   System.out.println("Automation Testing is disabled");
		      }
	  
		drp.selectByIndex(1);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			
		ActualData = "Performance Testing";
		ExpectedData = drp.getFirstSelectedOption().getText();
//		System.out.println(ExpectedData);
		     
		boolean drp_prf = driver.findElement(By.xpath("//*[@id=\"performance\"]")).isSelected();
		boolean drp_prf1 = true;
		     
		  try {
		    	    Assert.assertEquals(drp_prf, drp_prf1);
		    	    System.out.println("\nPerformance Testing is selected");
		      }
		  catch(AssertionError e) {
		    	    System.out.println("Performance Testing is not selected");
		      }
		       
		  try {
		            Assert.assertEquals(ActualData, ExpectedData);
		   	    System.out.println("Dropdown option2 is selected : Pass");
		      }
		  catch(AssertionError e) {
		   	    System.out.println("Fail");
		      }
		       
		  boolean drp_prf2 = driver.findElement(By.xpath("//*[@id=\"performance\"]")).isEnabled();
		  boolean drp_prf3 = true;
			     
	             try {
			      Assert.assertEquals(drp_prf2, drp_prf3);
			      System.out.println("Performance Testing is enabled");
		         }
			 catch(AssertionError e) {
			      System.out.println("Performance Testing is disabled");
			     }
		       
		   drp.selectByIndex(2);
		   driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
				
		   ActualData = "Manual Testing";
		   ExpectedData = drp.getFirstSelectedOption().getText();
//		   System.out.println(ExpectedData);
			     
		   boolean drp_man = driver.findElement(By.xpath("//*[@id=\"manual\"]")).isSelected();
		   boolean drp_man1 = true;
			     
			 try {
			    	 Assert.assertEquals(drp_man, drp_man1);
			    	 System.out.println("\nManual Testing is selected");
			     }
			 catch(AssertionError e) {
			    	 System.out.println("Manual Testing is not selected");
			     }
			       
			 try {
			   	  Assert.assertEquals(ActualData, ExpectedData);
			          System.out.println("Dropdown option3 is selected : Pass");
			     }
			 catch(AssertionError e) {
			   	  System.out.println("Fail");
			   	 }
			       
		    boolean drp_man2 = driver.findElement(By.xpath("//*[@id=\"manual\"]")).isEnabled();
		    boolean drp_man3 = true;
				     
			try {
				  Assert.assertEquals(drp_man2, drp_man3);
				  System.out.println("Manual Testing is enabled");
			    }
			catch(AssertionError e) {
				  System.out.println("Manual Testing is disabled");
		            }
			       
		    drp.selectByIndex(3);
		    driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
					
		    ActualData = "Database Testing";
		    ExpectedData = drp.getFirstSelectedOption().getText();
//		    System.out.println(ExpectedData);
				     
		    boolean drp_data = driver.findElement(By.xpath("//*[@id=\"database\"]")).isSelected();
		    boolean drp_data1 = true;
				     
			try {
				  Assert.assertEquals(drp_data, drp_data1);
				  System.out.println("\nDatabase Testing is selected");
		            }
			catch(AssertionError e) {
				  System.out.println("Database Testing is not selected");
		            }
				       
			try {
				  Assert.assertEquals(ActualData, ExpectedData);
				  System.out.println("Dropdown option4 is selected : Pass");
			    }
			catch(AssertionError e) {
				  System.out.println("Fail");
			    }
				       
		   boolean drp_data2 = driver.findElement(By.xpath("//*[@id=\"database\"]")).isEnabled();
		   boolean drp_data3 = true;
					     
			try {
				  Assert.assertEquals(drp_data2, drp_data3);
			          System.out.println("Database Testing is enabled");
		            }
			 catch(AssertionError e) {
				  System.out.println("Database Testing is disabled");
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
//	           System.out.println(ExpectedData);
	     
	           WebDriverWait ab1 = new WebDriverWait(driver, 5);
	     
	                if(ab1.until(ExpectedConditions.alertIsPresent())==null)
	                 System.out.println("\nDouble click Alert does not exists");
	                      else
	    	         System.out.println("\nDouble click Alert exists");
	       
	                            try {
	   		                Assert.assertEquals(ActualData, ExpectedData);
	   		                System.out.println("Double-click to generate alert box : Pass");
	   		                driver.switchTo().alert().accept();
                                        }
	   	                    catch(AssertionError e) {
	   		                 System.out.println("Fail");
	   	                        }
	       
	          //click button to generate alert box
	        
	        
		  WebElement alrt2 = driver.findElement(By.xpath("/html/body/div/div[11]/div/p/button"));
		  driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		  alrt2.click();
		  Thread.sleep(1000);
			
		   ActualData = "hi, JavaTpoint Testing";	
		   ExpectedData = driver.switchTo().alert().getText();
		   driver.switchTo().alert().accept();
//		   System.out.println(ExpectedData);
		     
		        try {
		   		  Assert.assertEquals(ActualData, ExpectedData);
		   		  System.out.println("\nclick to generate alert box : Pass");
		   	    }
		   	catch(AssertionError e) {
		   		  System.out.println("Fail");
		   	    }
		       
		    driver.navigate().refresh();
		       
		       
		    ////to generate confirm box 
		      
		     
		     WebElement alrt3 = driver.findElement(By.xpath("/html/body/div/div[12]/div/p[1]/button"));
		     driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		     alrt3.click();
		     Thread.sleep(1000);
				
		     ActualData = "Press a button!";	
		     ExpectedData = driver.switchTo().alert().getText();
//		     System.out.println(ExpectedData);
			       
		        try {
			          Assert.assertEquals(ActualData, ExpectedData);
			   	  System.out.println("\nclick to generate confirm box : Pass");
			   	  driver.switchTo().alert().accept();
			    }
			catch(AssertionError e) {
			   	  System.out.println("Fail");
			    }
			       
		      Thread.sleep(1000);
		       
		      driver.navigate().refresh();
		       
		      alrt3 = driver.findElement(By.xpath("/html/body/div/div[12]/div/p[1]/button"));
		      driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		      alrt3.click();
		      Thread.sleep(1000);
				
		      ActualData = "Press a button!";	
		      ExpectedData = driver.switchTo().alert().getText();
//		      System.out.println(ExpectedData);
			       
			 try {
			   	   Assert.assertEquals(ActualData, ExpectedData);
			   	   System.out.println("\nclick to generate cancel alert box : Pass");
			   	   driver.switchTo().alert().dismiss();
			     }
			   	 catch(AssertionError e) {
			           System.out.println("Fail");
			     }
		       
//		      ///drag and drop
//		       
//		      WebElement drag = driver.findElement(By.id("sourceImage"));		       
//		      WebElement drop = driver.findElement(By.id("targetDiv"));
//		      Actions wrk = new Actions(driver);
//		      wrk.dragAndDrop(drag, drop).build().perform();
//		      Thread.sleep(1000);
			
		      driver.quit();
		
	}



 
}
