package mainproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MainProject {

	public static void main(String[] args) {
		
//		System.setProperty("webdriver.chrome.driver", "/home/zoho/Downloads/chromedriver");
	System.setProperty("webdriver.gecko.driver", "/home/zoho/Downloads/geckodriver");
		
//		WebDriver driver = new ChromeDriver();
//		
//		String choclate =  "https://www.interviewcake.com/concept/java/bit-shift"; 
//		
//		driver.get(choclate);
	
	WebDriver driver = new FirefoxDriver();
	
	String choclate = "https://www.interviewcake.com/concept/java/bit-shift"; 
	
	driver.get(choclate);
	}

}
