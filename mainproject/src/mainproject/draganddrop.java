package mainproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class draganddrop {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/home/zoho/Downloads/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		WebDriver driver = new ChromeDriver(options);
		
		String web = "https://the-internet.herokuapp.com/drag_and_drop";
		
		driver.get(web);
		
		WebElement drag = driver.findElement(By.xpath("//*[@id=\"column-a\"]"));
//		Thread.sleep(1000);
		
		WebElement drop = driver.findElement(By.xpath("//*[@id=\"column-b\"]"));
//		Thread.sleep(1000);
		
		Actions wrk = new Actions(driver);
		wrk.dragAndDrop(drag, drop).build().perform();
		Thread.sleep(2000);
		
		
		
		///
			
		
		
		driver.quit();
		
	}

	
}
		