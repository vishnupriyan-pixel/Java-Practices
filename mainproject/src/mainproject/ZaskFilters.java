package mainproject;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@TestMethodOrder(OrderAnnotation.class)
public class ZaskFilters {
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
		System.setProperty("webdriver.chrome.driver", "/home/zoho/Downloads/chromedriver-new1");
		driver = new ChromeDriver();
		//		System.setProperty("webdriver.gecko.driver", "/home/zoho/Downloads/geckodriver");
		//		WebDriver driver = new  FirefoxDriver();		
		//		driver.manage().window().setSize(new Dimension(600, 720));
		driver.manage().window().maximize();

		String link = "https://zask.localpali.io/zask/";
		driver.get(link);
	}
	
////Login into the Zask 
	@Test 
	@Order(1)
	public void login() throws InterruptedException {
		WebElement url1 = this.css_locator("#details-button");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		url1.click();
		WebElement url2 = this.css_locator("#proceed-link");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		url2.click();
		WebElement log1 = this.xpath_locator("//a[@class='btn opc-text']");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		log1.click();
		WebElement log2 = this.css_locator("#login_id");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		log2.click();
		log2.clear();
		log2.sendKeys("esakkivash.n+testt0@zohocorp.com");
		WebElement nxt = this.css_locator("#nextbtn");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		nxt.click();
		WebElement log3 = this.css_locator("#password");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		log3.click();
		log3.clear();
		log3.sendKeys("testing1");

		nxt.click();
		Thread.sleep(2000);
	}
	
////-------------------------------Tags page---------------------------------////
	@Test 
	public void tags_page() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement tags_link = this.css_locator("link-to[lt-prop-route='index.tags']");
		tags_link.click();
		String expected_link = "https://zask.localpali.io/zask/tags?sort=Popular&page=1";
		assertEquals(expected_link, driver.getCurrentUrl());
		Thread.sleep(2000);
		WebElement tags_active = this.xpath_locator("//a[text()='Tags']");
		String tags_presence = "active";
		assertEquals(tags_active.getAttribute("class"),tags_presence);
		String active_color = "rgb(47, 175, 249) none repeat scroll 0% 0% / auto padding-box border-box";
		String tags_active1 = this.xpath_locator("//a[text()='Tags']").getCssValue("background");
		assertEquals(active_color, tags_active1);
		Thread.sleep(1000);
	}
	@Ignore
	////--------------------------Filter button with none applied-----------------------////
	@Test
	public void filter_page() throws InterruptedException {
		WebElement filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		boolean filter_tab = this.xpath_locator("//*[@id=\"outlet-zask-content-container\"]/zask-content-container/div[1]/zask-tags-filters/div[2]").isDisplayed();
		boolean filter_tab1 = true;
		assertEquals(filter_tab, filter_tab1);
		filter_button = this.xpath_locator("//*[@id=\"outlet-zask-content-container\"]/zask-content-container/div[1]/zask-tags-filters/div[2]");
		String filter_button1  = "left: 0%;";
		assertEquals(filter_button.getAttribute("style"),filter_button1);
		Thread.sleep(2000);
		
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(2000);
	}
	
	////--------------------Filter button categories------------------////
	@Test
	public void categories_filter() throws InterruptedException {
		WebElement filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(1000);
		WebElement category_list = this.css_locator("#filter > lyte-accordion:nth-child(1)");
		category_list.click();	
		boolean category_list1 = driver.getPageSource().contains("CATEGORIES");
		assertTrue(category_list1);
		Thread.sleep(1000);
		WebElement clearAll_option = this.css_locator("#outlet-zask-content-container div.clear-filter>div");
		clearAll_option.click();
		Thread.sleep(1000);
		WebElement particular_clear = this.css_locator("div[lt-prop-title_a='Clear']");
		driver.manage().timeouts().implicitlyWait(4000,TimeUnit.MILLISECONDS);
		boolean clr1 = driver.getPageSource().contains("Clear");
		assertTrue(clr1);
		String clr_opt = "Clear";
		assertEquals(particular_clear.getAttribute("lt-prop-title"),clr_opt);
		particular_clear.click();
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
	}

	////--------------------All option in categories------------------////
	@Test
	public void All_option_categories() throws InterruptedException {
		WebElement filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(1000);
		WebElement category_list = this.css_locator("#filter > lyte-accordion:nth-child(1)");
		category_list.click();	
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		boolean all_option = this.css_locator("input[value='All']").isSelected();
		Assert.assertTrue(all_option);
		Thread.sleep(1000);
		String all_text_presence = "All";
		String all_text_presence1 = this.css_locator("#filter lyte-radiobutton > label").getText();
		assertEquals(all_text_presence,all_text_presence1);
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(2000);
		WebElement follow_button = this.css_locator("#outlet-zask-content-container zask-ui-button");
		Thread.sleep(3000);
		follow_button.click();
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		WebElement follow_button1 = this.css_locator("#outlet-zask-content-container zask-ui-card:nth-child(3) zask-ui-button");
		follow_button1.click();
		Thread.sleep(1000);
		follow_button1 = this.css_locator("#outlet-zask-content-container zask-ui-card:nth-child(3) zask-ui-button");
		follow_button1.click();
		boolean follow = driver.getPageSource().contains("following");
		assertTrue(follow);
		Thread.sleep(2000);
		WebElement next_button = this.xpath_locator("//*[@id=\"tags-next-page\"]");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", next_button);
		Thread.sleep(1000);
		next_button.click();
		Thread.sleep(2000);
		next_button = this.xpath_locator("//*[@id=\"tags-next-page\"]");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", next_button);
		next_button.click();
		Thread.sleep(1000);
		WebElement prev_button = this.xpath_locator("//*[@id=\"tags-prev-page\"]");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", prev_button);
		prev_button.click();
		Thread.sleep(2000);
		prev_button = this.xpath_locator("//*[@id=\"tags-prev-page\"]");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", prev_button);
		prev_button.click();
		Thread.sleep(1000);
	}

	////------------------------Technology Tags------------------------////
	@Test
	public void technology_tags() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		WebElement filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(1000);
		WebElement category_list = this.css_locator("#filter > lyte-accordion:nth-child(1)");
		category_list.click();	
		Thread.sleep(1000);
		WebElement tech_radio_btn = this.xpath_locator("//span[text()='Technology Tags']");
		tech_radio_btn.click();
		Thread.sleep(2000);
		boolean tech_option = this.css_locator("input[value='TechnologyTags']").isSelected();
		boolean tech_option1 = true;
		assertEquals(tech_option,tech_option1);
		Thread.sleep(1000);
		String all_text_presence = "Technology Tags";
		String all_text_presence1 = this.css_locator("#filter div div:nth-child(2) label").getText();
		assertEquals(all_text_presence,all_text_presence1);
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(4000,TimeUnit.MILLISECONDS);
		boolean filter_dot = this.css_locator("#tag-filter > span.applied-filter-dot").isDisplayed();
		Assert.assertTrue(filter_dot);
		Thread.sleep(2000);
		filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		boolean category_dot = this.css_locator("#filter > lyte-accordion:nth-child(1) div > span:nth-child(2)").isDisplayed();
		Assert.assertTrue(category_dot);
		Thread.sleep(1000);
		 category_list = this.css_locator("#filter > lyte-accordion:nth-child(1)");
		category_list.click();	
		WebElement particular_clear = this.css_locator("div[lt-prop-title_a='Clear']");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		particular_clear.click();
		Thread.sleep(2000);
		boolean all_option = this.css_locator("input[value='All']").isSelected();
		Assert.assertTrue(all_option);
		Thread.sleep(2000);
		apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(1000);
	}

	////--------------------Administrated Tags------------------------////
	@Test
	public void administrated_tags() throws InterruptedException {
		WebElement filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(1000);
		WebElement category_list = this.css_locator("#filter > lyte-accordion:nth-child(1)");
		category_list.click();	
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		WebElement Administrated_option = this.xpath_locator("//span[text()='Administrated Tags']");
		Administrated_option.click();
		Thread.sleep(2000);
		boolean administrated_option = this.css_locator("input[value='TeamTags']").isSelected();
		boolean administrated_option1 = true;
		assertEquals(administrated_option,administrated_option1);
		Thread.sleep(1000);
		String all_text_presence = "Administrated Tags";
		String all_text_presence1 = this.css_locator("#filter div div:nth-child(3) label").getText();
		assertEquals(all_text_presence,all_text_presence1);
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(4000,TimeUnit.MILLISECONDS);
		boolean filter_dot = this.css_locator("#tag-filter > span.applied-filter-dot").isDisplayed();
		Assert.assertTrue(filter_dot);
		Thread.sleep(2000);
		filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		boolean category_dot = this.css_locator("#filter > lyte-accordion:nth-child(1) div > span:nth-child(2)").isDisplayed();
		Assert.assertTrue(category_dot);
		Thread.sleep(1000);
		category_list = this.css_locator("#filter > lyte-accordion:nth-child(1)");
		category_list.click();	
		WebElement particular_clear = this.css_locator("div[lt-prop-title_a='Clear']");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		particular_clear.click();
		Thread.sleep(2000);
		boolean all_option = this.css_locator("input[value='All']").isSelected();
		Assert.assertTrue(all_option);
		Thread.sleep(2000);
		apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(1000);
	}
	
	////--------------------Filter button status------------------////
	@Test
	public void status_filter() throws InterruptedException {
		WebElement filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(1000);
		WebElement status_list = this.css_locator("#filter > lyte-accordion:nth-child(3)");
		status_list.click();	
		boolean category_list1 = driver.getPageSource().contains("STATUS");
		assertTrue(category_list1);
		Thread.sleep(1000);
		WebElement clearAll_option = this.css_locator("#outlet-zask-content-container div.clear-filter>div");
		clearAll_option.click();
		Thread.sleep(1000);
		WebElement particular_clear = this.css_locator("div[lt-prop-title_a='Clear']");
		driver.manage().timeouts().implicitlyWait(4000,TimeUnit.MILLISECONDS);
		boolean clr1 = driver.getPageSource().contains("Clear");
		assertTrue(clr1);
		String clr_opt = "Clear";
		assertEquals(particular_clear.getAttribute("lt-prop-title"),clr_opt);
		particular_clear.click();
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
	}
	
	////---------------------All option in status---------------------////
	@Test
	public void all_option_status() throws InterruptedException {
		WebElement filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(1000);
		WebElement category_list = this.css_locator("#filter > lyte-accordion:nth-child(3)");
		category_list.click();	
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		boolean all_option = this.css_locator("input[value='All']").isSelected();
		Assert.assertTrue(all_option);
		Thread.sleep(1000);
		String all_text_presence = "All";
		String all_text_presence1 = this.css_locator("#filter lyte-radiobutton > label > span.tag-status-button").getText();
		assertEquals(all_text_presence,all_text_presence1);
		Thread.sleep(1000);
	}
	
	////------------------Following option in status------------------////
	@Test
	public void following_status() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement following_radio_btn = this.css_locator("#filter div div:nth-child(2) label span.tag-status-button");
		following_radio_btn.click();
		Thread.sleep(2000);
		boolean following_option = this.css_locator("input[value='Following']").isSelected();
		boolean following_option1 = true;
		assertEquals(following_option,following_option1);
		Thread.sleep(1000);
		String following_text_presence = "Following";
		String following_text_presence1 = this.css_locator("#filter div div:nth-child(2) label span.tag-status-button").getText();
		assertEquals(following_text_presence,following_text_presence1);
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(2000);
		boolean listings_following = driver.getPageSource().contains("pali");
		boolean listings_following1 = driver.getPageSource().contains("No tags found");
		if(listings_following || listings_following1) {
			assertTrue(listings_following);
		}
		else {
			assertTrue(listings_following1);
		}
		driver.manage().timeouts().implicitlyWait(4000,TimeUnit.MILLISECONDS);
		boolean filter_dot = this.css_locator("#tag-filter > span.applied-filter-dot").isDisplayed();
		Assert.assertTrue(filter_dot);
		Thread.sleep(2000);
		WebElement filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		boolean status_dot = this.css_locator("#filter > lyte-accordion:nth-child(3) div > span:nth-child(2)").isDisplayed();
		Assert.assertTrue(status_dot);
		Thread.sleep(1000);
		WebElement status_list = this.css_locator("#filter > lyte-accordion:nth-child(3)");
		status_list.click();	
		WebElement particular_clear = this.css_locator("#filter > lyte-accordion:nth-child(3) div.clear-filter > div");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		particular_clear.click();
		Thread.sleep(2000);
		boolean all_option = this.css_locator("input[value='All']").isSelected();
		Assert.assertTrue(all_option);
		Thread.sleep(2000);
		apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(1000);
	}

	////--------------------Ignoring option in status-----------------////
	@Test
	public void ignoring_status() throws InterruptedException {
		WebElement filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(1000);
		WebElement status_list = this.css_locator("#filter > lyte-accordion:nth-child(3)");
		status_list.click();	
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		WebElement ignore_option = this.xpath_locator("//span[text()='Ignoring']");
		ignore_option.click();
		Thread.sleep(2000);
		boolean ignoring_option = this.css_locator("input[value='Ignoring']").isSelected();
		boolean ignoring_option1 = true;
		assertEquals(ignoring_option,ignoring_option1);
		Thread.sleep(1000);
		String all_text_presence = "Ignoring";
		String all_text_presence1 = this.css_locator("#filter div div:nth-child(3) label > span.tag-status-button").getText();
		assertEquals(all_text_presence,all_text_presence1);
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(2000);
		boolean listings_ignoring = driver.getPageSource().contains("No tags found");
		assertTrue(listings_ignoring);
		driver.manage().timeouts().implicitlyWait(4000,TimeUnit.MILLISECONDS);
		boolean filter_dot = this.css_locator("#tag-filter > span.applied-filter-dot").isDisplayed();
		Assert.assertTrue(filter_dot);
		Thread.sleep(2000);
		filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		boolean category_dot = this.css_locator("#filter > lyte-accordion:nth-child(3) div > span.status.applied-filter-dot").isDisplayed();
		Assert.assertTrue(category_dot);
		Thread.sleep(1000);
		status_list = this.css_locator("#filter > lyte-accordion:nth-child(3)");
		status_list.click();	
		Thread.sleep(2000);
		WebElement particular_clear = this.css_locator("#filter > lyte-accordion:nth-child(3) div.clear-filter > div");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		particular_clear.click();
		Thread.sleep(2000);
		boolean all_option = this.css_locator("input[value='All']").isSelected();
		Assert.assertTrue(all_option);
		Thread.sleep(2000);
		apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(1000);
	}
	
	////--------------------Filter button privilege------------------////
	@Test
	public void privilege_filter() throws InterruptedException {
		WebElement filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(1000);
		WebElement status_list = this.css_locator("#filter > lyte-accordion:nth-child(5)");
		status_list.click();	
		boolean category_list1 = driver.getPageSource().contains("STATUS");
		assertTrue(category_list1);
		Thread.sleep(1000);
		WebElement clearAll_option = this.css_locator("#outlet-zask-content-container div.clear-filter>div");
		clearAll_option.click();
		Thread.sleep(1000);
		WebElement particular_clear = this.css_locator("div[lt-prop-title_a='Clear']");
		driver.manage().timeouts().implicitlyWait(4000,TimeUnit.MILLISECONDS);
		boolean clr1 = driver.getPageSource().contains("Clear");
		assertTrue(clr1);
		String clr_opt = "Clear";
		assertEquals(particular_clear.getAttribute("lt-prop-title"),clr_opt);
		particular_clear.click();
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
	}
	
	////----------------------administrated tag_checkbox-----------------------////
	@Test
	public void administrated_tags_checkbox() throws InterruptedException {
		WebElement filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(1000);
		WebElement category_list = this.css_locator("#filter > lyte-accordion:nth-child(5)");
		category_list.click();	
		Thread.sleep(2000);
		String all_text_presence = "My Administrated Tags";
		String all_text_presence1 = this.css_locator("#filter lyte-checkbox > label > span").getText();
		assertEquals(all_text_presence,all_text_presence1);
		Thread.sleep(1000);
		WebElement administrated_checkbox = this.css_locator("#filter > lyte-accordion:nth-child(5) lyte-checkbox label>span>span");
		administrated_checkbox.click();
		Thread.sleep(2000);
		boolean checkbox_appear = this.css_locator("input[type='checkbox']").isSelected();
		Assert.assertTrue(checkbox_appear);
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(2000);
		boolean listings_ignoring = driver.getPageSource().contains("To test tags and see if they add");
		assertTrue(listings_ignoring);
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(4000,TimeUnit.MILLISECONDS);
		boolean filter_dot = this.css_locator("#tag-filter > span.applied-filter-dot").isDisplayed();
		Assert.assertTrue(filter_dot);
		Thread.sleep(2000);
		filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		boolean category_dot = this.css_locator("#filter > lyte-accordion:nth-child(5) div > span.privilege.applied-filter-dot").isDisplayed();
		Assert.assertTrue(category_dot);
		Thread.sleep(1000);
		category_list = this.css_locator("#filter > lyte-accordion:nth-child(5)");
		category_list.click();	
		Thread.sleep(2000);
		WebElement particular_clear = this.css_locator("#filter > lyte-accordion:nth-child(5) div.clear-filter > div");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		particular_clear.click();
		Thread.sleep(2000);
		boolean all_option = this.css_locator("input[value='All']").isSelected();
		Assert.assertTrue(all_option);
		Thread.sleep(2000);
		apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(1000);
	}

	////----------------------number of questions---------------------////
	@Test
	public void number_of_questions() throws InterruptedException {
		WebElement filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(1000);
		WebElement questions_list = this.css_locator("#filter > lyte-accordion:nth-child(9)");
		questions_list.click();	
		boolean questions_list1 = driver.getPageSource().contains("NUMBER OF QUESTIONS");
		assertTrue(questions_list1);
		Thread.sleep(1000);
		WebElement clearAll_option = this.css_locator("#outlet-zask-content-container div.clear-filter>div");
		clearAll_option.click();
		Thread.sleep(1000);
		WebElement particular_clear = this.css_locator("div[lt-prop-title_a='Clear']");
		driver.manage().timeouts().implicitlyWait(4000,TimeUnit.MILLISECONDS);
		boolean clr1 = driver.getPageSource().contains("Clear");
		assertTrue(clr1);
		String clr_opt = "Clear";
		assertEquals(particular_clear.getAttribute("lt-prop-title"),clr_opt);
		particular_clear.click();
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
	}
	
	////--------------Invalid format in from & to range--------------////
	@Test
	public void invalid_from_to_range() throws InterruptedException {
		WebElement filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(1000);
		WebElement questions_list = this.css_locator("#filter > lyte-accordion:nth-child(9)");
		questions_list.click();	
		WebElement from_range = this.xpath_locator("//*[@id=\"filter\"]/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[1]/div/input");
		from_range.click();
		from_range.clear();
		String input_field = "Range";
		assertEquals(input_field,from_range.getAttribute("placeholder"));
		Thread.sleep(1000);
		from_range.sendKeys("++.");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		WebElement to_range = this.xpath_locator("//*[@id=\"filter\"]/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[2]/div/input");
		to_range.click();
		to_range.clear();
		input_field = "Range";
		assertEquals(input_field,to_range.getAttribute("placeholder"));
		Thread.sleep(1000);
		to_range.sendKeys(".++");
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(1000);
	}
	
	////---------------decimal values in from & to ranges--------------////
	@Test
	public void decimal_values_from_to_ranges() throws InterruptedException {
		WebElement filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(1000);
		WebElement questions_list = this.css_locator("#filter > lyte-accordion:nth-child(9)");
		questions_list.click();	
		WebElement from_range = this.xpath_locator("//*[@id=\"filter\"]/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[1]/div/input");
		from_range.click();
		from_range.clear();
		from_range.sendKeys(".135");
		Thread.sleep(1000);
		WebElement to_range = this.xpath_locator("//*[@id=\"filter\"]/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[2]/div/input");
		to_range.click();
		to_range.clear();
		to_range.sendKeys(".500");
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(1000);
		String question_page = "https://zask.localpali.io/zask/questions?sort=New&filter=All";
		assertEquals(question_page,driver.getCurrentUrl());
		Thread.sleep(1000);
	}
	
	////------------giving '0' in both from and to ranges------------////

	@Test
	public void zero_values_from_to_ranges() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement tags_link = this.css_locator("link-to[lt-prop-route='index.tags']");
		tags_link.click();
		Thread.sleep(2000);
		WebElement filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(1000);
		WebElement questions_list = this.css_locator("#filter > lyte-accordion:nth-child(9)");
		questions_list.click();	
		WebElement from_range = this.xpath_locator("//*[@id=\"filter\"]/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[1]/div/input");
		from_range.click();
		from_range.clear();
		from_range.sendKeys("0");
		Thread.sleep(1000);
		WebElement to_range = this.xpath_locator("//*[@id=\"filter\"]/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[2]/div/input");
		to_range.click();
		to_range.clear();
		to_range.sendKeys("0");
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(2000);
		String range_values = "https://zask.localpali.io/zask/tags?sort=Popular&quesRangeFrom=0&quesRangeTo=0&administeredTag=&tag=&searchIndex=2&page=1";
		assertEquals(range_values,driver.getCurrentUrl());
		driver.manage().timeouts().implicitlyWait(4000,TimeUnit.MILLISECONDS);
		boolean filter_dot = this.css_locator("#tag-filter > span.applied-filter-dot").isDisplayed();
		Assert.assertTrue(filter_dot);
		Thread.sleep(2000);
		boolean question_tags_header = driver.getPageSource().contains("0 question(s)");
		WebElement question_tags_header1 = this.css_locator("#outlet-zask-content-container .zask-tags-container");
		if(question_tags_header1 != null) {
			Assert.assertTrue(question_tags_header);
		}
		else {
			Assert.assertFalse(question_tags_header);
		}
		Thread.sleep(1000);
		filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		boolean questions_dot = this.css_locator("#filter > lyte-accordion:nth-child(9) div > span.questions.applied-filter-dot").isDisplayed();
		Assert.assertTrue(questions_dot);
		Thread.sleep(1000);
		questions_list = this.css_locator("#filter > lyte-accordion:nth-child(9)");
		questions_list.click();	
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		WebElement particular_clear = this.css_locator("#filter > lyte-accordion:nth-child(9) div.clear-filter > div");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		particular_clear.click();
		Thread.sleep(1000);
		apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(1000);
	}
	
	////-------------Negative values in from and to ranges------------////
	@Test
	public void negative_values_from_to_ranges() throws InterruptedException {
		WebElement filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(1000);
		WebElement questions_list = this.css_locator("#filter > lyte-accordion:nth-child(9)");
		questions_list.click();	
		WebElement from_range = this.xpath_locator("//*[@id=\"filter\"]/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[1]/div/input");
		from_range.click();
		from_range.clear();
		from_range.sendKeys("-100");
		Thread.sleep(1000);
		WebElement to_range = this.xpath_locator("//*[@id=\"filter\"]/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[2]/div/input");
		to_range.click();
		to_range.clear();
		to_range.sendKeys("-300");
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(1000);
		String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
		String expected_data = "Please enter valid filter(s)";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);
	}
	
	////------------invalid negative format in the from and to ranges-----------////
	@Test
	public void invalid_format_ranges() throws InterruptedException {
		WebElement from_range = this.xpath_locator("//*[@id=\"filter\"]/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[1]/div/input");
		from_range.click();
		from_range.clear();
		from_range.sendKeys("--e50");
		Thread.sleep(1000);
		WebElement to_range = this.xpath_locator("//*[@id=\"filter\"]/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[2]/div/input");
		to_range.click();
		to_range.clear();
		to_range.sendKeys("--e100");
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(1000);
		boolean all_tags = this.xpath_locator("//*[@id=\"outlet-zask-content-container\"]/zask-content-container/div[2]/zask-tags/div[2]").isDisplayed();
		assertTrue(all_tags);
		Thread.sleep(2000);
	}
	
	////-----------Range value in from only and Empty in to-----------////
	@Test
	public void range_value_in_from_only() throws InterruptedException {
		WebElement filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(1000);
		WebElement questions_list = this.css_locator("#filter > lyte-accordion:nth-child(9)");
		questions_list.click();	
		WebElement from_range = this.xpath_locator("//*[@id=\"filter\"]/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[1]/div/input");
		from_range.click();
		from_range.clear();
		from_range.sendKeys("7");
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(4000);
		boolean question_tags_header = driver.getPageSource().contains("7 question(s)");
		WebElement question_tags_header1 = this.css_locator("#outlet-zask-content-container .zask-tags-container");
		if(question_tags_header1 != null) {
			Assert.assertTrue(question_tags_header);
		}
		else {
			Assert.assertFalse(question_tags_header);
		}
		Thread.sleep(2000);
		filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(1000);
		questions_list = this.css_locator("#filter > lyte-accordion:nth-child(9)");
		questions_list.click();	
		WebElement particular_clear = this.css_locator("#filter > lyte-accordion:nth-child(9) div.clear-filter > div");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		particular_clear.click();
		Thread.sleep(2000);
		apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(1000);
	}
	
	////-----------Range value in to only and Empty in from-----------////
	@Test
	public void range_value_in_to_only() throws InterruptedException {
		WebElement filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(1000);
		WebElement questions_list = this.css_locator("#filter > lyte-accordion:nth-child(9)");
		questions_list.click();	
		WebElement to_range = this.xpath_locator("//*[@id=\"filter\"]/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[2]/div/input");
		to_range.click();
		to_range.clear();
		to_range.sendKeys("100");
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(2000);
		WebElement next_button = this.xpath_locator("//*[@id=\"tags-next-page\"]");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", next_button);
		Thread.sleep(1000);
		next_button.click();
		Thread.sleep(5000);
		boolean question_tags_header = driver.getPageSource().contains("1 question(s)");
		WebElement question_tags_header1 = this.css_locator("#outlet-zask-content-container .zask-tags-container");
		if(question_tags_header1 != null) {
			Assert.assertTrue(question_tags_header);
		}
		else {
			Assert.assertFalse(question_tags_header);
		}
		Thread.sleep(2000);
		filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(1000);
		questions_list = this.css_locator("#filter > lyte-accordion:nth-child(9)");
		questions_list.click();	
		WebElement particular_clear = this.css_locator("#filter > lyte-accordion:nth-child(9) div.clear-filter > div");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		particular_clear.click();
		Thread.sleep(1000);
		apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(2000);
	}
	
	////---------large value in from and low value in to ranges--------////
	@Test
	public void large_value_in_from_low_in_to() throws InterruptedException {
		WebElement filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(1000);
		WebElement questions_list = this.css_locator("#filter > lyte-accordion:nth-child(9)");
		questions_list.click();	
		WebElement from_range = this.xpath_locator("//*[@id=\"filter\"]/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[1]/div/input");
		from_range.click();
		from_range.clear();
		from_range.sendKeys("200");
		Thread.sleep(1000);
		WebElement to_range = this.xpath_locator("//*[@id=\"filter\"]/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[2]/div/input");
		to_range.click();
		to_range.clear();
		to_range.sendKeys("0");
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(2000);
		boolean tags_found = driver.getPageSource().contains("No tags found");
		assertTrue(tags_found);
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(4000,TimeUnit.MILLISECONDS);
		boolean filter_dot = this.css_locator("#tag-filter > span.applied-filter-dot").isDisplayed();
		Assert.assertTrue(filter_dot);
		Thread.sleep(2000);
		filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		boolean category_dot = this.css_locator("#filter > lyte-accordion:nth-child(9) div > span.questions.applied-filter-dot").isDisplayed();
		Assert.assertTrue(category_dot);
		Thread.sleep(1000);
		WebElement particular_clear = this.css_locator("#filter > lyte-accordion:nth-child(9) div.clear-filter > div");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		particular_clear.click();
		Thread.sleep(1000);
		apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(1000);
	}
	
	////-----------------valid values in both ranges------------------////
	@Test
	public void valid_values_in_ranges() throws InterruptedException {
		WebElement filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(1000);
		WebElement questions_list = this.css_locator("#filter > lyte-accordion:nth-child(9)");
		questions_list.click();	
		WebElement from_range = this.xpath_locator("//*[@id=\"filter\"]/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[1]/div/input");
		from_range.click();
		from_range.clear();
		from_range.sendKeys("100");
		Thread.sleep(1000);
		WebElement to_range = this.xpath_locator("//*[@id=\"filter\"]/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[2]/div/input");
		to_range.click();
		to_range.clear();
		to_range.sendKeys("300");
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(2000);
		boolean tags_found = driver.getPageSource().contains("123 question(s)");
		assertTrue(tags_found);
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(4000,TimeUnit.MILLISECONDS);
		boolean filter_dot = this.css_locator("#tag-filter > span.applied-filter-dot").isDisplayed();
		Assert.assertTrue(filter_dot);
		Thread.sleep(2000);
		filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		boolean category_dot = this.css_locator("#filter > lyte-accordion:nth-child(9) div > span.questions.applied-filter-dot").isDisplayed();
		Assert.assertTrue(category_dot);
		Thread.sleep(1000);
		WebElement particular_clear = this.css_locator("#filter > lyte-accordion:nth-child(9) div.clear-filter > div");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		particular_clear.click();
		Thread.sleep(1000);
		apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(2000);
	}
	
	////----------------huge amount of values in ranges---------------////
	@Test
	public void huge_values_ranges() throws InterruptedException {
		WebElement filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(1000);
		WebElement questions_list = this.css_locator("#filter > lyte-accordion:nth-child(9)");
		questions_list.click();	
		WebElement from_range = this.xpath_locator("//*[@id=\"filter\"]/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[1]/div/input");
		from_range.click();
		from_range.clear();
		from_range.sendKeys("345272829010172635389890");
		Thread.sleep(1000);
		WebElement to_range = this.xpath_locator("//*[@id=\"filter\"]/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[2]/div/input");
		to_range.click();
		to_range.clear();
		to_range.sendKeys("6782900172627788190018676");
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(2000);
		String question_page = "https://zask.localpali.io/zask/questions?sort=New&filter=All";
		assertEquals(question_page,driver.getCurrentUrl());
		Thread.sleep(1000);
	}
	
	////----------Highest value check in ranges with arrow key---------////
	@Test
	public void highest_value_check() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement tags_link = this.css_locator("link-to[lt-prop-route='index.tags']");
		tags_link.click();
		Thread.sleep(2000);
		WebElement filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(1000);
		WebElement questions_list = this.css_locator("#filter > lyte-accordion:nth-child(9)");
		questions_list.click();	
		WebElement from_range = this.xpath_locator("//*[@id=\"filter\"]/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[1]/div/input");
		from_range.click();
		from_range.clear();
		from_range.sendKeys("5500");
		Thread.sleep(2000);
		from_range.sendKeys(Keys.ARROW_DOWN);
		from_range.sendKeys(Keys.ARROW_DOWN);
		from_range.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		WebElement to_range = this.xpath_locator("//*[@id=\"filter\"]/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[2]/div/input");
		to_range.click();
		to_range.clear();
		to_range.sendKeys("9860");
		Thread.sleep(2000);
		to_range.sendKeys(Keys.ARROW_DOWN);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(2000);
		boolean tags_found = driver.getPageSource().contains("No tags found");
		assertTrue(tags_found);
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(4000,TimeUnit.MILLISECONDS);
		boolean filter_dot = this.css_locator("#tag-filter > span.applied-filter-dot").isDisplayed();
		Assert.assertTrue(filter_dot);
		Thread.sleep(2000);
		filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		boolean questions_dot = this.css_locator("#filter > lyte-accordion:nth-child(9) div > span.questions.applied-filter-dot").isDisplayed();
		Assert.assertTrue(questions_dot);
		Thread.sleep(1000);
		WebElement particular_clear = this.css_locator("#filter > lyte-accordion:nth-child(9) div.clear-filter > div");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		particular_clear.click();
		Thread.sleep(1000);
		apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(1000);
	}

	////----------------Combination of all filter options-------------////
	@Test
	public void all_combined_filter_options() throws InterruptedException {
		WebElement filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(1000);
		WebElement category_list = this.css_locator("#filter > lyte-accordion:nth-child(1)");
		category_list.click();	
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		WebElement Administrated_option = this.xpath_locator("//span[text()='Administrated Tags']");
		Administrated_option.click();
		Thread.sleep(2000);
		boolean administrated_option = this.css_locator("input[value='TeamTags']").isSelected();
		boolean administrated_option1 = true;
		assertEquals(administrated_option,administrated_option1);
		Thread.sleep(1000);
		String all_text_presence = "Administrated Tags";
		String all_text_presence1 = this.css_locator("#filter div div:nth-child(3) label").getText();
		assertEquals(all_text_presence,all_text_presence1);
		Thread.sleep(2000);
		WebElement status_list = this.css_locator("#filter > lyte-accordion:nth-child(3)");
		status_list.click();	
		Thread.sleep(2000);
		WebElement following_radio_btn = this.css_locator("#filter div div:nth-child(2) label span.tag-status-button");
		following_radio_btn.click();
		Thread.sleep(2000);
		boolean following_option = this.css_locator("input[value='Following']").isSelected();
		boolean following_option1 = true;
		assertEquals(following_option,following_option1);
		Thread.sleep(1000);
		String following_text_presence = "Following";
		String following_text_presence1 = this.css_locator("#filter div div:nth-child(2) label span.tag-status-button").getText();
		assertEquals(following_text_presence,following_text_presence1);
		Thread.sleep(2000);
		WebElement privilege_list = this.css_locator("#filter > lyte-accordion:nth-child(5)");
		privilege_list.click();	
		boolean category_list1 = driver.getPageSource().contains("PRIVILEGE");
		assertTrue(category_list1);
		Thread.sleep(1000);
		WebElement administrated_checkbox = this.css_locator("#filter > lyte-accordion:nth-child(5) lyte-checkbox label>span>span");
		administrated_checkbox.click();
		Thread.sleep(2000);
		boolean checkbox_appear = this.css_locator("input[type='checkbox']").isSelected();
		Assert.assertTrue(checkbox_appear);
		Thread.sleep(2000);
		privilege_list = this.css_locator("#filter > lyte-accordion:nth-child(5)");
		privilege_list.click();	
		Thread.sleep(4000);
		WebElement questions_list = this.css_locator("#filter > lyte-accordion:nth-child(9)");
		questions_list.click();	
		Thread.sleep(2000);
		WebElement from_range = this.xpath_locator("//*[@id=\"filter\"]/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[1]/div/input");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", from_range);
		from_range.click();
		from_range.clear();
		from_range.sendKeys("100");
		Thread.sleep(1000);
		WebElement to_range = this.xpath_locator("//*[@id=\"filter\"]/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[2]/div/input");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", to_range);
		to_range.click();
		to_range.clear();
		to_range.sendKeys("200");
		Thread.sleep(2000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(2000);
		boolean tags_lists = driver.getPageSource().contains("No tags found");
		assertTrue(tags_lists);
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		boolean filter_dot = this.css_locator("#tag-filter > span.applied-filter-dot").isDisplayed();
		Assert.assertTrue(filter_dot);
		Thread.sleep(1000);
		filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(1000);
		boolean category_dot = this.css_locator("#filter > lyte-accordion:nth-child(1) div > span:nth-child(2)").isDisplayed();
		Assert.assertTrue(category_dot);
		Thread.sleep(1000);
		WebElement categories_clear = this.css_locator("#filter > lyte-accordion:nth-child(1) > lyte-yield > lyte-accordion-item > lyte-accordion-header > div.clear-filter > div");
		categories_clear.click();
		Thread.sleep(1000);
		apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(2000);
		
	}

	////------------All filters without categories choosen------------////
	@Test
	public void clearing_status_filter() throws InterruptedException {
		WebElement filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(1000);
		boolean status_dot = this.css_locator("#filter > lyte-accordion:nth-child(3) div > span:nth-child(2)").isDisplayed();
		Assert.assertTrue(status_dot);
		Thread.sleep(1000);
		WebElement status_clear = this.css_locator("#filter > lyte-accordion:nth-child(3) > lyte-yield > lyte-accordion-item > lyte-accordion-header > div.clear-filter > div");
		status_clear.click();
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(2000);
		boolean tags_lists = driver.getPageSource().contains("123 question(s)");
		assertTrue(tags_lists);
		Thread.sleep(2000);
	}
	////------------without categories and status filter--------------////

	@Test
	public void clearing_privilege_filter() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		boolean filter_dot = this.css_locator("#tag-filter > span.applied-filter-dot").isDisplayed();
		Assert.assertTrue(filter_dot);
		WebElement filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(1000);
		boolean privilege_dot = this.css_locator("#filter > lyte-accordion:nth-child(5) div > span.privilege.applied-filter-dot").isDisplayed();
		Assert.assertTrue(privilege_dot);
		Thread.sleep(1000);
		WebElement privilege_clear = this.css_locator("#filter > lyte-accordion:nth-child(5) > lyte-yield > lyte-accordion-item > lyte-accordion-header > div.clear-filter > div");
		privilege_clear.click();
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(2000);
		boolean tags_lists = driver.getPageSource().contains("123 question(s)");
		assertTrue(tags_lists);
		Thread.sleep(2000);
	}
	@Ignore
	////--------without categories,status and privilege filter-------////
	@Test
	public void clearing_number_of_questions_filter() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		boolean filter_dot = this.css_locator("#tag-filter > span.applied-filter-dot").isDisplayed();
		Assert.assertTrue(filter_dot);
		WebElement filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(1000);
		boolean questions_dot = this.css_locator("#filter > lyte-accordion:nth-child(9) div > span.questions.applied-filter-dot").isDisplayed();
		Assert.assertTrue(questions_dot);
		Thread.sleep(1000);
		WebElement questions_clear = this.css_locator("#filter > lyte-accordion:nth-child(9) > lyte-yield > lyte-accordion-item > lyte-accordion-header > div.clear-filter > div");
		questions_clear.click();
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(2000);
	}

	////------------clearing all filters in clearall button-----------////
	@Test
	public void clearall_click_remove_allFilters() throws InterruptedException {
		WebElement filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(1000);
		WebElement category_list = this.css_locator("#filter > lyte-accordion:nth-child(1)");
		category_list.click();	
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		WebElement Administrated_option = this.xpath_locator("//span[text()='Administrated Tags']");
		Administrated_option.click();
		Thread.sleep(2000);
		boolean administrated_option = this.css_locator("input[value='TeamTags']").isSelected();
		boolean administrated_option1 = true;
		assertEquals(administrated_option,administrated_option1);
		Thread.sleep(1000);
		String all_text_presence = "Administrated Tags";
		String all_text_presence1 = this.css_locator("#filter div div:nth-child(3) label").getText();
		assertEquals(all_text_presence,all_text_presence1);
		Thread.sleep(2000);
		category_list = this.css_locator("#filter > lyte-accordion:nth-child(1)");
		category_list.click();	
		Thread.sleep(2000);
		WebElement status_list = this.css_locator("#filter > lyte-accordion:nth-child(3)");
		status_list.click();	
		Thread.sleep(2000);
		WebElement following_radio_btn = this.css_locator("#filter div div:nth-child(2) label span.tag-status-button");
		following_radio_btn.click();
		Thread.sleep(2000);
		boolean following_option = this.css_locator("input[value='Following']").isSelected();
		boolean following_option1 = true;
		assertEquals(following_option,following_option1);
		Thread.sleep(1000);
		String following_text_presence = "Following";
		String following_text_presence1 = this.css_locator("#filter div div:nth-child(2) label span.tag-status-button").getText();
		assertEquals(following_text_presence,following_text_presence1);
		Thread.sleep(2000);
		status_list = this.css_locator("#filter > lyte-accordion:nth-child(3)");
		status_list.click();
		Thread.sleep(2000);
		WebElement privilege_list = this.css_locator("#filter > lyte-accordion:nth-child(5)");
		privilege_list.click();	
		boolean category_list1 = driver.getPageSource().contains("PRIVILEGE");
		assertTrue(category_list1);
		Thread.sleep(1000);
		WebElement administrated_checkbox = this.css_locator("#filter > lyte-accordion:nth-child(5) lyte-checkbox label>span>span");
		administrated_checkbox.click();
		Thread.sleep(2000);
		boolean checkbox_appear = this.css_locator("input[type='checkbox']").isSelected();
		Assert.assertTrue(checkbox_appear);
		Thread.sleep(2000);
		privilege_list = this.css_locator("#filter > lyte-accordion:nth-child(5)");
		privilege_list.click();	
		Thread.sleep(2000);
		WebElement questions_list = this.css_locator("#filter > lyte-accordion:nth-child(9)");
		questions_list.click();	
		WebElement from_range = this.xpath_locator("//*[@id=\"filter\"]/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[1]/div/input");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", from_range);
		from_range.click();
		from_range.clear();
		from_range.sendKeys("100");
		Thread.sleep(1000);
		WebElement to_range = this.xpath_locator("//*[@id=\"filter\"]/lyte-accordion[5]/lyte-yield/lyte-accordion-item/lyte-accordion-body/div/lyte-input[2]/div/input");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", to_range);
		to_range.click();
		to_range.clear();
		to_range.sendKeys("200");
		Thread.sleep(3000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		boolean filter_dot = this.css_locator("#tag-filter > span.applied-filter-dot").isDisplayed();
		Assert.assertTrue(filter_dot);
		Thread.sleep(1000);
		filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(1000);
		boolean category_dot = this.css_locator("#filter > lyte-accordion:nth-child(1) div > span:nth-child(2)").isDisplayed();
		Assert.assertTrue(category_dot);
		Thread.sleep(1000);
		boolean status_dot = this.css_locator("#filter > lyte-accordion:nth-child(3) div > span:nth-child(2)").isDisplayed();
		Assert.assertTrue(status_dot);
		Thread.sleep(1000);
		boolean privilege_dot = this.css_locator("#filter > lyte-accordion:nth-child(5) div > span.privilege.applied-filter-dot").isDisplayed();
		Assert.assertTrue(privilege_dot);
		Thread.sleep(1000);
		boolean questions_dot = this.css_locator("#filter > lyte-accordion:nth-child(9) div > span.questions.applied-filter-dot").isDisplayed();
		Assert.assertTrue(questions_dot);
		Thread.sleep(1000);
		WebElement all_clear = this.css_locator("#outlet-zask-content-container > zask-content-container > div.zask-content-filter > zask-tags-filters > div.tags-filter-tab > div:nth-child(2) > div.clear-filter > div");
		all_clear.click();
		Thread.sleep(2000);
		apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(2000);
	}

	////---------------special characters in search box---------------////
	@Test
	public void special_characters_search_box() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		WebElement search_box = this.css_locator("#search-tags > div:nth-child(1) > input");
		search_box.click();
		search_box.clear();
		search_box.sendKeys("#");
		Thread.sleep(1500);
		search_box.sendKeys(Keys.ARROW_DOWN);
		search_box.sendKeys(Keys.ARROW_DOWN);
		search_box.sendKeys(Keys.ARROW_DOWN);
		search_box.sendKeys(Keys.ARROW_DOWN);
		search_box.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		String pali_tag = "https://zask.localpali.io/zask/questions?filter=All&sort=New&tags=.pali%23";
		assertEquals(pali_tag,driver.getCurrentUrl());
		Thread.sleep(1000);
		boolean tags_questions = driver.getPageSource().contains("No Questions");
		assertTrue(tags_questions);
		Thread.sleep(2000);
		boolean filter_dot = this.xpath_locator("//*[@id=\"question-filter\"]/span[3]").isDisplayed();
		Assert.assertTrue(filter_dot);
		Thread.sleep(1000);
		WebElement filter_button = this.css_locator("#question-filter");
		filter_button.click();
		Thread.sleep(1000);
		boolean tags_dot = this.css_locator("#filter > div > lyte-accordion:nth-child(3) span.tags.applied-filter-dot").isDisplayed();
		assertTrue(tags_dot);
		Thread.sleep(1000);
		WebElement tags_list = this.css_locator("#filter > div > lyte-accordion:nth-child(3) lyte-accordion-header");
		tags_list.click();
		String all_text_presence = "TAGS";
		String all_text_presence1 = this.css_locator("#filter > div > lyte-accordion:nth-child(3) lyte-accordion-header span").getText();
		assertEquals(all_text_presence,all_text_presence1);
		Thread.sleep(1000);
		boolean pali_tag_present = this.css_locator("input[value='.pali#']").isSelected();
		assertTrue(pali_tag_present);
		Thread.sleep(1000);
		String pali_tag_present1 = this.css_locator("#tag-filter-checkbox > label > span > span").getText();
		String tag_value = ".pali#";
		assertEquals(tag_value, pali_tag_present1);
		Thread.sleep(2000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(2000);
	}

	////---------------giving single space in search box--------------////
	@Test
	public void space_in_searchbox() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		WebElement tags_link = this.css_locator("link-to[lt-prop-route='index.tags']");
		tags_link.click();
		Thread.sleep(2000);
		WebElement search_box = this.css_locator("#search-tags > div:nth-child(1) > input");
		search_box.click();
		search_box.clear();
		search_box.sendKeys(" ");
		Thread.sleep(1500);
		search_box.sendKeys(Keys.ARROW_DOWN);
		search_box.sendKeys(Keys.ARROW_DOWN);
		search_box.sendKeys(Keys.ARROW_DOWN);
		search_box.sendKeys(Keys.ARROW_DOWN);
		search_box.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		String pali_tag = "https://zask.localpali.io/zask/questions?filter=All&sort=New&tags=.pali%20%20";
		assertEquals(pali_tag,driver.getCurrentUrl());
		Thread.sleep(1000);
		boolean filter_dot = this.xpath_locator("//*[@id=\"question-filter\"]/span[3]").isDisplayed();
		Assert.assertTrue(filter_dot);
		Thread.sleep(1000);
		WebElement filter_button = this.css_locator("#question-filter");
		filter_button.click();
		Thread.sleep(1000);
		boolean tags_dot = this.css_locator("#filter > div > lyte-accordion:nth-child(3) span.tags.applied-filter-dot").isDisplayed();
		assertTrue(tags_dot);
		Thread.sleep(1000);
		WebElement tags_list = this.css_locator("#filter > div > lyte-accordion:nth-child(3) lyte-accordion-header");
		tags_list.click();
		String all_text_presence = "TAGS";
		String all_text_presence1 = this.css_locator("#filter > div > lyte-accordion:nth-child(3) lyte-accordion-header span").getText();
		assertEquals(all_text_presence,all_text_presence1);
		Thread.sleep(1000);
		boolean pali_tag_present = this.css_locator("input[value='.pali  ']").isSelected();
		assertTrue(pali_tag_present);
		Thread.sleep(1000);
		String pali_tag_present1 = this.css_locator("#tag-filter-checkbox > label > span > span").getText();
		String tag_value = ".pali";
		assertEquals(tag_value, pali_tag_present1);
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(2000);
	}
	
	////---------------giving single number in search box--------------////
	@Test
	public void singleNumber_in_searchbox() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		WebElement tags_link = this.css_locator("link-to[lt-prop-route='index.tags']");
		tags_link.click();
		Thread.sleep(2000);
		WebElement search_box = this.css_locator("#search-tags > div:nth-child(1) > input");
		search_box.click();
		search_box.clear();
		search_box.sendKeys("1");
		Thread.sleep(1500);
		search_box.sendKeys(Keys.ARROW_DOWN);
		search_box.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		String pali_tag = "https://zask.localpali.io/zask/questions?filter=All&sort=New&tags=1";
		assertEquals(pali_tag,driver.getCurrentUrl());
		Thread.sleep(1000);
		boolean filter_dot = this.xpath_locator("//*[@id=\"question-filter\"]/span[3]").isDisplayed();
		Assert.assertTrue(filter_dot);
		Thread.sleep(1000);
		WebElement filter_button = this.css_locator("#question-filter");
		filter_button.click();
		Thread.sleep(1000);
		boolean tags_dot = this.css_locator("#filter > div > lyte-accordion:nth-child(3) span.tags.applied-filter-dot").isDisplayed();
		assertTrue(tags_dot);
		Thread.sleep(1000);
		WebElement tags_list = this.css_locator("#filter > div > lyte-accordion:nth-child(3) lyte-accordion-header");
		tags_list.click();
		String all_text_presence = "TAGS";
		String all_text_presence1 = this.css_locator("#filter > div > lyte-accordion:nth-child(3) lyte-accordion-header span").getText();
		assertEquals(all_text_presence,all_text_presence1);
		Thread.sleep(1000);
		boolean pali_tag_present = this.css_locator("input[value='1']").isSelected();
		assertTrue(pali_tag_present);
		Thread.sleep(1000);
		String pali_tag_present1 = this.css_locator("#tag-filter-checkbox > label > span > span").getText();
		String tag_value = "1";
		assertEquals(tag_value, pali_tag_present1);
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(2000);
	}

	////---------------giving single letter in search box--------------////
	@Test
	public void singleLetter_in_searchbox() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		WebElement tags_link = this.css_locator("link-to[lt-prop-route='index.tags']");
		tags_link.click();
		Thread.sleep(2000);
		WebElement search_box = this.css_locator("#search-tags > div:nth-child(1) > input");
		search_box.click();
		search_box.clear();
		search_box.sendKeys("a");
		Thread.sleep(1500);
		search_box.sendKeys(Keys.ARROW_DOWN);
		search_box.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		String pali_tag = "https://zask.localpali.io/zask/questions?filter=All&sort=New&tags=abuse-desk";
		assertEquals(pali_tag,driver.getCurrentUrl());
		Thread.sleep(1000);
		boolean filter_dot = this.xpath_locator("//*[@id=\"question-filter\"]/span[3]").isDisplayed();
		Assert.assertTrue(filter_dot);
		Thread.sleep(1000);
		WebElement filter_button = this.css_locator("#question-filter");
		filter_button.click();
		Thread.sleep(1000);
		boolean tags_dot = this.css_locator("#filter > div > lyte-accordion:nth-child(3) span.tags.applied-filter-dot").isDisplayed();
		assertTrue(tags_dot);
		Thread.sleep(1000);
		WebElement tags_list = this.css_locator("#filter > div > lyte-accordion:nth-child(3) lyte-accordion-header");
		tags_list.click();
		String all_text_presence = "TAGS";
		String all_text_presence1 = this.css_locator("#filter > div > lyte-accordion:nth-child(3) lyte-accordion-header span").getText();
		assertEquals(all_text_presence,all_text_presence1);
		Thread.sleep(1000);
		boolean abuse_tag_present = this.css_locator("input[value='abuse-desk']").isSelected();
		assertTrue(abuse_tag_present);
		Thread.sleep(1000);
		String abuse_tag_present1 = this.css_locator("#tag-filter-checkbox > label > span > span").getText();
		String tag_value = "abuse-desk";
		assertEquals(tag_value, abuse_tag_present1);
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(2000);
	}
	
	////---------------Empty click & enter on searchbox---------------////
	@Test
	public void empty_click_enter_searchbox() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		WebElement tags_link = this.css_locator("link-to[lt-prop-route='index.tags']");
		tags_link.click();
		Thread.sleep(2000);
		WebElement search_box = this.css_locator("#search-tags > div:nth-child(1) > input");
		String search_box_value = "Search tags";
		assertEquals(search_box_value,search_box.getAttribute("placeholder"));
		search_box.click();
		search_box.clear();
		Thread.sleep(1000);
		search_box.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		String pali_tag = "https://zask.localpali.io/zask/tags?sort=Popular&tag=*&page=1";
		assertEquals(pali_tag,driver.getCurrentUrl());
		Thread.sleep(2000);
	}
	
	////---------------Invalid type of special characters-------------////
	@Test
	public void invalid_type_special_characters() throws InterruptedException {
		WebElement search_box = this.css_locator("#search-tags > div:nth-child(1) > input");
		String search_box_value = "Search tags";
		assertEquals(search_box_value,search_box.getAttribute("placeholder"));
		search_box.click();
		search_box.clear();
		search_box.sendKeys("!@#$%^&*()_+=");
		Thread.sleep(1500);
		search_box.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		String pali_tag = "https://zask.localpali.io/zask/tags?sort=Popular&tag=!%40%23%24%25%5E%26*()_%2B%3D&page=1";
		assertEquals(pali_tag,driver.getCurrentUrl());
		Thread.sleep(1000);
		boolean tags_questions = driver.getPageSource().contains("No tags found");
		assertTrue(tags_questions);
		Thread.sleep(1000);
		boolean filter_dot = this.css_locator("#tag-filter > span.applied-filter-dot").isDisplayed();
		Assert.assertTrue(filter_dot);
		Thread.sleep(2000);
		WebElement filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(1000);
		WebElement all_clear = this.css_locator("#outlet-zask-content-container > zask-content-container > div.zask-content-filter > zask-tags-filters > div.tags-filter-tab > div:nth-child(2) > div.clear-filter > div");
		all_clear.click();
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(2000);
	}

	////----------------Invalid numbers in search tag-----------------////
	@Test
	public void invalid_numbers_searchbox() throws InterruptedException {
		WebElement search_box = this.css_locator("#search-tags > div:nth-child(1) > input");
		String search_box_value = "Search tags";
		assertEquals(search_box_value,search_box.getAttribute("placeholder"));
		search_box.click();
		search_box.clear();
		search_box.sendKeys("256382929018");
		Thread.sleep(1500);
		search_box.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		String pali_tag = "https://zask.localpali.io/zask/tags?sort=Popular&tag=256382929018&page=1";
		assertEquals(pali_tag,driver.getCurrentUrl());
		Thread.sleep(1000);
		boolean tags_questions = driver.getPageSource().contains("No tags found");
		assertTrue(tags_questions);
		Thread.sleep(1000);
		boolean filter_dot = this.css_locator("#tag-filter > span.applied-filter-dot").isDisplayed();
		Assert.assertTrue(filter_dot);
		Thread.sleep(2000);
		WebElement filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(1000);
		WebElement all_clear = this.css_locator("#outlet-zask-content-container > zask-content-container > div.zask-content-filter > zask-tags-filters > div.tags-filter-tab > div:nth-child(2) > div.clear-filter > div");
		all_clear.click();
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(2000);
	}

	////----------------Invalid numbers&characters in search tag-----------------////
	@Test
	public void invalid_largeCharacters_searchbox() throws InterruptedException {
		WebElement search_box = this.css_locator("#search-tags > div:nth-child(1) > input");
		String search_box_value = "Search tags";
		assertEquals(search_box_value,search_box.getAttribute("placeholder"));
		search_box.click();
		search_box.clear();
		search_box.sendKeys("2653263632653263632653263632653263632653263632653263632653263632653263632653263632653263632653263632");
		Thread.sleep(1500);
		String expected_result = "No Results found.";
		String actual_result = this.css_locator("#search-tags > div.results-container").getText();
		assertEquals(expected_result,actual_result);
		search_box.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		String pali_tag = "https://zask.localpali.io/zask/tags?sort=Popular&tag=2653263632653263632653263632653263632653263632653263632653263632653263632653263632653263632653263632&page=1";
		assertEquals(pali_tag,driver.getCurrentUrl());
		Thread.sleep(1000);
		boolean tags_questions = driver.getPageSource().contains("No tags found");
		assertTrue(tags_questions);
		Thread.sleep(1000);
		boolean filter_dot = this.css_locator("#tag-filter > span.applied-filter-dot").isDisplayed();
		Assert.assertTrue(filter_dot);
		Thread.sleep(2000);
		WebElement filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(2000);
		WebElement all_clear = this.css_locator("#outlet-zask-content-container > zask-content-container > div.zask-content-filter > zask-tags-filters > div.tags-filter-tab > div:nth-child(2) > div.clear-filter > div");
		all_clear.click();
		Thread.sleep(2000);
		WebElement cancel_button = this.xpath_locator("//button[text()='Cancel']");
		cancel_button.click();
		Thread.sleep(2000);
		search_box = this.css_locator("#search-tags > div:nth-child(1) > input");
		search_box_value = "Search tags";
		assertEquals(search_box_value,search_box.getAttribute("placeholder"));
		search_box.click();
		search_box.sendKeys(Keys.CONTROL,"A");
		search_box.sendKeys(Keys.BACK_SPACE);
		search_box.sendKeys("rqrwtueiowooiwinucueeururubcbcuvbnzmslakaowpqpiqvnxehuqqwiopaljxnmdhzjkcliowiwiieinxmjsqiizzzzzzzzzz");
		Thread.sleep(1500);
		expected_result = "No Results found.";
		actual_result = this.css_locator("#search-tags > div.results-container").getText();
		assertEquals(expected_result,actual_result);
		search_box.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		pali_tag = "https://zask.localpali.io/zask/tags?sort=Popular&tag=rqrwtueiowooiwinucueeururubcbcuvbnzmslakaowpqpiqvnxehuqqwiopaljxnmdhzjkcliowiwiieinxmjsqiizzzzzzzzzz&page=1";
		assertEquals(pali_tag,driver.getCurrentUrl());
		Thread.sleep(1000);
		tags_questions = driver.getPageSource().contains("No tags found");
		assertTrue(tags_questions);
		Thread.sleep(1000);
		filter_dot = this.css_locator("#tag-filter > span.applied-filter-dot").isDisplayed();
		Assert.assertTrue(filter_dot);
		Thread.sleep(2000);
		filter_button = this.css_locator("#tag-filter");
		filter_button.click();
		Thread.sleep(1000);
		all_clear = this.css_locator(".clear-filter>div");
		all_clear.click();
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(2000);
	}

	////-----------------valid character in search box----------------////
	@Test
	public void valid_characters_searchBox() throws InterruptedException {
		WebElement search_box = this.css_locator("#search-tags > div:nth-child(1) > input");
		search_box.click();
		search_box.clear();
		search_box.sendKeys("pali");
		Thread.sleep(1500);
		String search_box_value = "Search tags";
		assertEquals(search_box_value,search_box.getAttribute("placeholder"));
		search_box.sendKeys(Keys.ARROW_DOWN);
		search_box.sendKeys(Keys.ARROW_DOWN);
		search_box.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		String pali_tag = "https://zask.localpali.io/zask/questions?filter=All&sort=New&tags=pali-client";
		assertEquals(pali_tag,driver.getCurrentUrl());
		Thread.sleep(1000);
		boolean filter_dot = this.xpath_locator("//*[@id=\"question-filter\"]/span[3]").isDisplayed();
		Assert.assertTrue(filter_dot);
		Thread.sleep(1000);
		WebElement filter_button = this.css_locator("#question-filter");
		filter_button.click();
		Thread.sleep(1000);
		boolean tags_dot = this.css_locator("#filter > div > lyte-accordion:nth-child(3) span.tags.applied-filter-dot").isDisplayed();
		assertTrue(tags_dot);
		Thread.sleep(1000);
		WebElement tags_list = this.css_locator("#filter > div > lyte-accordion:nth-child(3) lyte-accordion-header");
		tags_list.click();
		String all_text_presence = "TAGS";
		String all_text_presence1 = this.css_locator("#filter > div > lyte-accordion:nth-child(3) lyte-accordion-header span").getText();
		assertEquals(all_text_presence,all_text_presence1);
		Thread.sleep(1000);
		boolean abuse_tag_present = this.css_locator("input[value='pali-client']").isSelected();
		assertTrue(abuse_tag_present);
		Thread.sleep(1000);
		String abuse_tag_present1 = this.css_locator("#tag-filter-checkbox > label > span > span").getText();
		String tag_value = "pali-client";
		assertEquals(tag_value, abuse_tag_present1);
		Thread.sleep(1500);
		WebElement all_clear = this.css_locator(".clear-filter>div");
		all_clear.click();
		Thread.sleep(2000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(2000);
	}
	
	////-------------------------filter dropdown----------------------////
	@Test
	public void filter_dropdown() throws InterruptedException {
		 driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		 WebElement tags_link = this.css_locator("link-to[lt-prop-route='index.tags']");
		 tags_link.click();
		 WebElement dropdown_filter = this.xpath_locator("//*[@id=\"zask-sort-tags-dropdown\"]/div[1]/lyte-drop-button");
		 dropdown_filter.click();
		 Thread.sleep(2000);
		 WebElement popular_filter = this.css_locator("lyte-drop-item.zask-drop-down-item.sp16.lyteDropdownSelection");
		 popular_filter.click();
		 Thread.sleep(2000);
		 String popular_value = "Popular";
		 String filter_present = this.css_locator("#zask-sort-tags-dropdown > div.lyteDummyEventContainer > lyte-drop-button > span").getText();
		 assertEquals(popular_value,filter_present);
		 Thread.sleep(1000);
		 String popular_page = "https://zask.localpali.io/zask/tags?sort=Popular&administeredTag=&page=1";
		 assertEquals(popular_page,driver.getCurrentUrl());
		 Thread.sleep(2000);
		 dropdown_filter = this.css_locator("#zask-sort-tags-dropdown > div.lyteDummyEventContainer");
		 dropdown_filter.click();
		 Thread.sleep(2000);
		 WebElement new_filter = this.css_locator("lyte-drop-item[data-value='New']");
		 new_filter.click();
		 Thread.sleep(2000);
		 popular_value = "New";
		 filter_present = this.css_locator("#zask-sort-tags-dropdown > div.lyteDummyEventContainer > lyte-drop-button > span").getText();
		 assertEquals(popular_value,filter_present);
		 Thread.sleep(1000);
		 String new_page = "https://zask.localpali.io/zask/tags?sort=New&administeredTag=&page=1";
		 assertEquals(new_page,driver.getCurrentUrl());
		 Thread.sleep(2000);
		 dropdown_filter = this.css_locator("#zask-sort-tags-dropdown > div.lyteDummyEventContainer");
		 dropdown_filter.click();
		 Thread.sleep(1000);
		 WebElement name_filter = this.css_locator("lyte-drop-item[data-value='Name']");
		 name_filter.click();
		 Thread.sleep(2000);
		 popular_value = "Name";
		 filter_present = this.css_locator("#zask-sort-tags-dropdown > div.lyteDummyEventContainer > lyte-drop-button > span").getText();
		 assertEquals(popular_value,filter_present);
		 Thread.sleep(1000);
		 String name_page = "https://zask.localpali.io/zask/tags?sort=Name&administeredTag=&page=1";
		 assertEquals(name_page,driver.getCurrentUrl());
		 Thread.sleep(2000);
	}
	
	////-------------------------Users page---------------------------////
	@Test
	public void user_page() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement user_link = this.css_locator("link-to[lt-prop-route='index.users']");
		user_link.click();
		String expected_link = "https://zask.localpali.io/zask/users?choice=Name&time=All&page=1";
		assertEquals(expected_link, driver.getCurrentUrl());
		Thread.sleep(2000);
		WebElement tags_active = this.xpath_locator("//a[text()='Users']");
		String tags_presence = "active";
		assertEquals(tags_active.getAttribute("class"),tags_presence);
		String active_color = "rgb(47, 175, 249) none repeat scroll 0% 0% / auto padding-box border-box";
		String tags_active1 = this.xpath_locator("//a[text()='Users']").getCssValue("background");
		assertEquals(active_color, tags_active1);
		Thread.sleep(2000);
	}
	
	////---------------users filter button none applied---------------////
	@Test
	public void user_filter_none_applied() throws InterruptedException {
		WebElement filter_button = this.css_locator("#user-filter");
		filter_button.click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		boolean filter_tab = this.xpath_locator("//*[@id=\"outlet-zask-content-container\"]/zask-content-container/div[1]/zask-users-filters/div[2]").isDisplayed();
		boolean filter_tab1 = true;
		assertEquals(filter_tab, filter_tab1);
		filter_button = this.xpath_locator("//*[@id=\"outlet-zask-content-container\"]/zask-content-container/div[1]/zask-users-filters/div[2]");
		String filter_button1  = "left: 0%;";
		assertEquals(filter_button.getAttribute("style"),filter_button1);
		Thread.sleep(2000);
		
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(2000);
		String users_link = "https://zask.localpali.io/zask/users?sort=Name&user=&tags=&searchIndex=2&choice=Name&time=All&page=1";
		assertEquals(users_link,driver.getCurrentUrl());
		Thread.sleep(1000);
	}
	@Ignore
	////--------------------Filter button categories------------------////
	@Test
	public void users_categories_filter() throws InterruptedException {
		WebElement filter_button = this.css_locator("#user-filter");
		filter_button.click();
		Thread.sleep(1000);
		WebElement category_list = this.css_locator("#filter > lyte-accordion:nth-child(1)");
		category_list.click();	
		boolean category_list1 = driver.getPageSource().contains("CATEGORIES");
		assertTrue(category_list1);
		Thread.sleep(1000);
		WebElement clearAll_option = this.css_locator("#outlet-zask-content-container div.clear-filter>div");
		clearAll_option.click();
		Thread.sleep(1000);
		WebElement particular_clear = this.css_locator("div[lt-prop-title_a='Clear']");
		driver.manage().timeouts().implicitlyWait(4000,TimeUnit.MILLISECONDS);
		boolean clr1 = driver.getPageSource().contains("Clear");
		assertTrue(clr1);
		String clr_opt = "Clear";
		assertEquals(particular_clear.getAttribute("lt-prop-title"),clr_opt);
		particular_clear.click();
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
	}
	
////--------------------All user option in categories------------------////

	@Test
	public void All_users_categories() throws InterruptedException {
		WebElement filter_button = this.css_locator("#user-filter");
		filter_button.click();
		Thread.sleep(1000);
		WebElement category_list = this.css_locator("#filter > lyte-accordion:nth-child(1)");
		category_list.click();	
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		boolean all_option = this.css_locator("input[value='All']").isSelected();
		Assert.assertTrue(all_option);
		Thread.sleep(1000);
		String all_text_presence = "All";
		String all_text_presence1 = this.css_locator("#filter lyte-radiobutton > label").getText();
		assertEquals(all_text_presence,all_text_presence1);
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(2000);
		WebElement user1 = this.css_locator("#outlet-zask-content-container zask-users > div.zask-users-list-container > zask-ui-card:nth-child(30)");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", user1);
		user1 = this.css_locator("a[href='/zask/users/57554778']");
		user1.click();
		Thread.sleep(3000);
		String user_link = "https://zask.localpali.io/zask/users/57554778";
		assertEquals(user_link,driver.getCurrentUrl());
		Thread.sleep(1000);
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement next_button = this.xpath_locator("//*[@id=\"users-next-page\"]");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", next_button);
		Thread.sleep(1000);
		next_button.click();
		Thread.sleep(2000);
		next_button = this.xpath_locator("//*[@id=\"users-next-page\"]");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", next_button);
		next_button.click();
		Thread.sleep(1000);
		WebElement prev_button = this.xpath_locator("//*[@id=\"users-prev-page\"]");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", prev_button);
		prev_button.click();
		Thread.sleep(1000);
		prev_button = this.xpath_locator("//*[@id=\"users-prev-page\"]");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", prev_button);
		prev_button.click();
		Thread.sleep(2000);
	}
	
	////------------------Reviewers users categories------------------////
	@Test
	public void reviewers_categories() throws InterruptedException {
		WebElement filter_button = this.css_locator("#user-filter");
		filter_button.click();
		Thread.sleep(1000);
		WebElement category_list = this.css_locator("#filter > lyte-accordion:nth-child(1)");
		category_list.click();	
		Thread.sleep(2000);
		WebElement review_radio_btn = this.xpath_locator("//span[text()='Reviewers']");
		review_radio_btn.click();
		Thread.sleep(1000);
		boolean review_option = this.css_locator("input[value='Reviewers']").isSelected();
		boolean review_option1 = true;
		assertEquals(review_option,review_option1);
		Thread.sleep(1000);
		String all_text_presence = "Reviewers";
		String all_text_presence1 = this.css_locator("#filter div div:nth-child(2) label").getText();
		assertEquals(all_text_presence,all_text_presence1);
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(2000);
		String reviewers_link = "https://zask.localpali.io/zask/users?sort=Name&category=Reviewers&user=&tags=&searchIndex=2&choice=Name&time=All&page=1";
		assertEquals(reviewers_link,driver.getCurrentUrl());
		driver.manage().timeouts().implicitlyWait(4000,TimeUnit.MILLISECONDS);
		boolean filter_dot = this.css_locator("#user-filter > span.applied-filter-dot").isDisplayed();
		Assert.assertTrue(filter_dot);
		Thread.sleep(2000);
		filter_button = this.css_locator("#user-filter");
		filter_button.click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		boolean category_dot = this.css_locator("#filter > lyte-accordion:nth-child(1) div > span:nth-child(2)").isDisplayed();
		Assert.assertTrue(category_dot);
		Thread.sleep(1000);
		category_list = this.css_locator("#filter > lyte-accordion:nth-child(1)");
		category_list.click();	
		WebElement particular_clear = this.css_locator("div[lt-prop-title_a='Clear']");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		particular_clear.click();
		Thread.sleep(2000);
		boolean all_option = this.css_locator("input[value='All']").isSelected();
		Assert.assertTrue(all_option);
		Thread.sleep(2000);
		apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(2000);
	}
	
	////-----------------moderators categories filter-----------------////
	@Test
	public void moderators_filter() throws InterruptedException {
		WebElement filter_button = this.css_locator("#user-filter");
		filter_button.click();
		Thread.sleep(1000);
		WebElement category_list = this.css_locator("#filter > lyte-accordion:nth-child(1)");
		category_list.click();	
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		WebElement Administrated_option = this.xpath_locator("//span[text()='Moderators']");
		Administrated_option.click();
		Thread.sleep(2000);
		boolean administrated_option = this.css_locator("input[value='Moderators']").isSelected();
		boolean administrated_option1 = true;
		assertEquals(administrated_option,administrated_option1);
		Thread.sleep(1000);
		String all_text_presence = "Moderators";
		String all_text_presence1 = this.css_locator("#filter div div:nth-child(3) label").getText();
		assertEquals(all_text_presence,all_text_presence1);
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(2000);
		String moderator_link = "https://zask.localpali.io/zask/users?sort=Name&category=Moderators&user=&tags=&searchIndex=4&choice=Name&time=All&page=1";
		assertEquals(moderator_link,driver.getCurrentUrl());
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		boolean filter_dot = this.css_locator("#user-filter > span.applied-filter-dot").isDisplayed();
		Assert.assertTrue(filter_dot);
		Thread.sleep(1000);
		filter_button = this.css_locator("#user-filter");
		filter_button.click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		boolean category_dot = this.css_locator("#filter > lyte-accordion:nth-child(1) div > span:nth-child(2)").isDisplayed();
		Assert.assertTrue(category_dot);
		Thread.sleep(1000);
		category_list = this.css_locator("#filter > lyte-accordion:nth-child(1)");
		category_list.click();	
		WebElement particular_clear = this.css_locator("div[lt-prop-title_a='Clear']");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		particular_clear.click();
		Thread.sleep(1000);
		boolean all_option = this.css_locator("input[value='All']").isSelected();
		Assert.assertTrue(all_option);
		Thread.sleep(1000);
		apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(1000);
	}
	
	////---------------------Tags followed filter---------------------////
	@Test
	public void tags_filter() throws InterruptedException {
		WebElement filter_button = this.css_locator("#user-filter");
		filter_button.click();
		Thread.sleep(1000);
		WebElement tagsfollow_list = this.css_locator("#filter > lyte-accordion:nth-child(5)");
		tagsfollow_list.click();
		boolean tagfollow_list1 = driver.getPageSource().contains("Tags Followed");
		assertTrue(tagfollow_list1);
		Thread.sleep(1000);
		WebElement clearAll_option = this.css_locator("#outlet-zask-content-container div.clear-filter>div");
		clearAll_option.click();
		Thread.sleep(1000);
		WebElement particular_clear = this.css_locator("div[lt-prop-title_a='Clear']");
		driver.manage().timeouts().implicitlyWait(4000,TimeUnit.MILLISECONDS);
		boolean clr1 = driver.getPageSource().contains("Clear");
		assertTrue(clr1);
		String clr_opt = "Clear";
		assertEquals(particular_clear.getAttribute("lt-prop-title"),clr_opt);
		particular_clear.click();
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(1000);
	}

	////--------------------selecting tags shown----------------------////
	@Test
	public void tags_shown() throws InterruptedException {
		WebElement filter_button = this.css_locator("#user-filter");
		filter_button.click();
		Thread.sleep(1000);
		WebElement tagsfollow_list = this.css_locator("#filter > lyte-accordion:nth-child(5)");
		tagsfollow_list.click();
		boolean tagfollow_list1 = driver.getPageSource().contains("Tags Followed");
		assertTrue(tagfollow_list1);
		Thread.sleep(1000);
		WebElement tags_all_lists = this.css_locator("#tag-filter-checkbox > label > span");
		tags_all_lists.click();
		String access_tag_all = this.css_locator("#tag-filter-checkbox > label > span > span").getText();
		String tag_text_present = ".htaccess";
		assertEquals(access_tag_all,tag_text_present);
		boolean checkbox_appear = this.css_locator("input[type='checkbox']").isSelected();
		Assert.assertTrue(checkbox_appear);
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(1000);
		tagfollow_list1 = driver.getPageSource().contains("No users found");
		assertTrue(tagfollow_list1);
		Thread.sleep(1000);
		filter_button = this.css_locator("#user-filter");
		filter_button.click();
		Thread.sleep(1000);
		boolean tagfollow_dot = this.css_locator("#filter > lyte-accordion:nth-child(5) div > span.tags.applied-filter-dot").isDisplayed();
		Assert.assertTrue(tagfollow_dot);
		tagsfollow_list = this.css_locator("#filter > lyte-accordion:nth-child(5)");
		tagsfollow_list.click();
		Thread.sleep(1000);
		WebElement particular_clear = this.css_locator("#filter > lyte-accordion:nth-child(5) div.clear-filter > div");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		particular_clear.click();
		Thread.sleep(1000);
		apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(1000);
		////--------selecting next tag---------////
		filter_button = this.css_locator("#user-filter");
		filter_button.click();
		Thread.sleep(1000);
		tagsfollow_list = this.css_locator("#filter > lyte-accordion:nth-child(5)");
		tagsfollow_list.click();
		tags_all_lists = this.xpath_locator("//span[text()='.net']");
		tags_all_lists.click();
		String net_tag_all = this.css_locator("#tag-filter-checkbox:nth-child(3) > label > span > span").getText();
		String net_text_present = ".net";
		assertEquals(net_tag_all,net_text_present);
		Thread.sleep(2000);
		boolean checkbox_appear2 = this.css_locator("#tag-filter-checkbox:nth-child(3) input").isSelected();
		Assert.assertTrue(checkbox_appear2);
		Thread.sleep(1000);
		apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(1000);
		tagfollow_list1 = driver.getPageSource().contains("No users found");
		assertTrue(tagfollow_list1);
		Thread.sleep(1000);
		filter_button = this.css_locator("#user-filter");
		filter_button.click();
		Thread.sleep(1000);
		tagfollow_dot = this.css_locator("#filter > lyte-accordion:nth-child(5) div > span.tags.applied-filter-dot").isDisplayed();
		Assert.assertTrue(tagfollow_dot);
		tagsfollow_list = this.css_locator("#filter > lyte-accordion:nth-child(5)");
		tagsfollow_list.click();
		Thread.sleep(1000);
		particular_clear = this.css_locator("#filter > lyte-accordion:nth-child(5) div.clear-filter > div");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		particular_clear.click();
		Thread.sleep(1000);
		apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(1000);
		////--------------selecting another tag---------------////
		filter_button = this.css_locator("#user-filter");
		filter_button.click();
		Thread.sleep(1000);
		tagsfollow_list = this.css_locator("#filter > lyte-accordion:nth-child(5)");
		tagsfollow_list.click();
		tags_all_lists = this.xpath_locator("//span[text()='.pali  ']");
		tags_all_lists.click();
		String pali_tag_all = this.css_locator("#tag-filter-checkbox:nth-child(4) > label > span > span").getText();
		String pali_text_present = ".pali";
		assertEquals(pali_tag_all, pali_text_present);
		Thread.sleep(2000);
		boolean checkbox_appear3 = this.css_locator("#tag-filter-checkbox:nth-child(4) input").isSelected();
		Assert.assertTrue(checkbox_appear3);
		Thread.sleep(1000);
		apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(1000);
		tagfollow_list1 = driver.getPageSource().contains("No users found");
		assertTrue(tagfollow_list1);
		Thread.sleep(1000);
		filter_button = this.css_locator("#user-filter");
		filter_button.click();
		Thread.sleep(1000);
		tagfollow_dot = this.css_locator("#filter > lyte-accordion:nth-child(5) div > span.tags.applied-filter-dot").isDisplayed();
		Assert.assertTrue(tagfollow_dot);
		tagsfollow_list = this.css_locator("#filter > lyte-accordion:nth-child(5)");
		tagsfollow_list.click();
		Thread.sleep(1000);
		particular_clear = this.css_locator("#filter > lyte-accordion:nth-child(5) div.clear-filter > div");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		particular_clear.click();
		Thread.sleep(1000);
		apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(1000);
	}

	////-------------selecting all checkboxes tagfollowed-------------////
	@Test
	public void selecting_all_checkboxes() throws InterruptedException {
		WebElement filter_button = this.css_locator("#user-filter");
		filter_button.click();
		Thread.sleep(1000);
		WebElement tagsfollow_list = this.css_locator("#filter > lyte-accordion:nth-child(5)");
		tagsfollow_list.click();
		boolean tagfollow_list1 = driver.getPageSource().contains("Tags Followed");
		assertTrue(tagfollow_list1);
		Thread.sleep(1000);
		WebElement tags_all_lists = this.css_locator("#tag-filter-checkbox > label > span");
		tags_all_lists.click();
		boolean checkbox_appear = this.css_locator("input[type='checkbox']").isSelected();
		Assert.assertTrue(checkbox_appear);
		Thread.sleep(1000);
		tags_all_lists = this.xpath_locator("//span[text()='.net']");
		tags_all_lists.click();
		String net_tag_all = this.css_locator("#tag-filter-checkbox:nth-child(3) > label > span > span").getText();
		String net_text_present = ".net";
		assertEquals(net_tag_all,net_text_present);
		Thread.sleep(1000);
		boolean checkbox_appear2 = this.css_locator("#tag-filter-checkbox:nth-child(3) input").isSelected();
		Assert.assertTrue(checkbox_appear2);
		tags_all_lists = this.xpath_locator("//span[text()='.pali  ']");
		tags_all_lists.click();
		String pali_tag_all = this.css_locator("#tag-filter-checkbox:nth-child(4) > label > span > span").getText();
		String pali_text_present = ".pali";
		assertEquals(pali_tag_all, pali_text_present);
		Thread.sleep(2000);
		boolean checkbox_appear3 = this.css_locator("#tag-filter-checkbox:nth-child(4) input").isSelected();
		Assert.assertTrue(checkbox_appear3);
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(1000);
		tagfollow_list1 = driver.getPageSource().contains("No users found");
		assertTrue(tagfollow_list1);
		filter_button = this.css_locator("#user-filter");
		filter_button.click();
		Thread.sleep(1000);
		boolean tagfollow_dot = this.css_locator("#filter > lyte-accordion:nth-child(5) div > span.tags.applied-filter-dot").isDisplayed();
		Assert.assertTrue(tagfollow_dot);
		tagsfollow_list = this.css_locator("#filter > lyte-accordion:nth-child(5)");
		tagsfollow_list.click();
		Thread.sleep(1000);
		WebElement all_clear = this.xpath_locator("//div[text()='Clear All']");
		all_clear.click();
		Thread.sleep(1000);
		apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(1000);
	}
	
	////---------------searching a tag in all followed----------------////
	@Test
	public void searching_tag_in_all() throws InterruptedException {
		WebElement filter_button = this.css_locator("#user-filter");
		filter_button.click();
		Thread.sleep(1000);
		WebElement tagsfollow_list = this.css_locator("#filter > lyte-accordion:nth-child(5)");
		tagsfollow_list.click();
		boolean tagfollow_list1 = driver.getPageSource().contains("Tags Followed");
		assertTrue(tagfollow_list1);
		Thread.sleep(1000);
		WebElement select_all_dropdown = this.css_locator("#user-tag-category-filter > div.lyteDummyEventContainer > lyte-drop-button");
		select_all_dropdown.click();
		WebElement all_option = this.xpath_locator("//lyte-drop-item[text()=' All ']");
		all_option.click();
		Thread.sleep(1000);
		WebElement search_tags = this.css_locator("#search-users-followed-tags > div:nth-child(1) > input");
		search_tags.click();
		search_tags.clear();
		Thread.sleep(1000);
		String search_tags1 = "Search tags";
		assertEquals(search_tags1,search_tags.getAttribute("placeholder"));
		search_tags.sendKeys("#");
		WebElement tags_choose = this.css_locator("#tag-filter-checkbox:nth-child(4) > label > span > span");
		tags_choose.click();
		String pali_tag_all = this.css_locator("#tag-filter-checkbox:nth-child(4) > label > span > span").getText();
		String pali_text_present = "c#v1";
		assertEquals(pali_tag_all, pali_text_present);
		Thread.sleep(2000);
		boolean checkbox_appear3 = this.css_locator("#tag-filter-checkbox:nth-child(4) input").isSelected();
		Assert.assertTrue(checkbox_appear3);
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(1000);
		tagfollow_list1 = driver.getPageSource().contains("No users found");
		assertTrue(tagfollow_list1);
		Thread.sleep(1000);
		filter_button = this.css_locator("#user-filter");
		filter_button.click();
		Thread.sleep(1000);
		boolean tagfollow_dot = this.css_locator("#filter > lyte-accordion:nth-child(5) div > span.tags.applied-filter-dot").isDisplayed();
		Assert.assertTrue(tagfollow_dot);
		tagsfollow_list = this.css_locator("#filter > lyte-accordion:nth-child(5)");
		tagsfollow_list.click();
		Thread.sleep(1000);
		WebElement particular_clear = this.css_locator("#filter > lyte-accordion:nth-child(5) div.clear-filter > div");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		particular_clear.click();
		Thread.sleep(1000);
		search_tags = this.css_locator("#search-users-followed-tags > div:nth-child(1) > input");
		search_tags.click();
		search_tags.clear();
		search_tags.sendKeys("zask");
		Thread.sleep(1000);
		WebElement zask_tag = this.xpath_locator("//span[text()='zask']");
		zask_tag.click();
		Thread.sleep(2000);
		boolean checkbox_appear = this.css_locator("#tag-filter-checkbox:nth-child(3) input").isSelected();
		Assert.assertTrue(checkbox_appear);
		Thread.sleep(1000);
		apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(1000);
		WebElement user_data = this.css_locator("a[href='/zask/users/54356533']");
		user_data.click();
		Thread.sleep(2000);
		String user_link = "https://zask.localpali.io/zask/users/54356533";
		assertEquals(user_link,driver.getCurrentUrl());
		Thread.sleep(1000);
		driver.navigate().back();
		filter_button = this.css_locator("#user-filter");
		filter_button.click();
		Thread.sleep(1000);
		tagfollow_dot = this.css_locator("#filter > lyte-accordion:nth-child(5) div > span.tags.applied-filter-dot").isDisplayed();
		Assert.assertTrue(tagfollow_dot);
		tagsfollow_list = this.css_locator("#filter > lyte-accordion:nth-child(5)");
		tagsfollow_list.click();
		Thread.sleep(1000);
		particular_clear = this.css_locator("#filter > lyte-accordion:nth-child(5) div.clear-filter > div");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		particular_clear.click();
		Thread.sleep(1000);
		apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(1000);
	}
	
	////----------------------team tag followed-----------------------////
	@Test
	public void team_tags_followed() throws InterruptedException {
		WebElement filter_button = this.css_locator("#user-filter");
		filter_button.click();
		Thread.sleep(1000);
		WebElement tagsfollow_list = this.css_locator("#filter > lyte-accordion:nth-child(5)");
		tagsfollow_list.click();
		boolean tagfollow_list1 = driver.getPageSource().contains("Tags Followed");
		assertTrue(tagfollow_list1);
		Thread.sleep(1000);
		WebElement select_all_dropdown = this.css_locator("#user-tag-category-filter > div.lyteDummyEventContainer > lyte-drop-button");
		select_all_dropdown.click();
		WebElement all_option = this.xpath_locator("//lyte-drop-item[text()=' Team ']");
		all_option.click();
		Thread.sleep(1000);
		WebElement tags_all_lists = this.xpath_locator("//span[text()='actionscript-3']");
		tags_all_lists.click();
		String pali_tag_all = this.css_locator("#tag-filter-checkbox:nth-child(4) > label > span > span").getText();
		String pali_text_present = "actionscript-3";
		assertEquals(pali_tag_all, pali_text_present);
		Thread.sleep(2000);
		boolean checkbox_appear3 = this.css_locator("#tag-filter-checkbox:nth-child(4) input").isSelected();
		Assert.assertTrue(checkbox_appear3);
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(1000);
		tagfollow_list1 = driver.getPageSource().contains("baradhan.v");
		assertTrue(tagfollow_list1);
		Thread.sleep(1000);
		boolean user_present = this.css_locator("a[href='/zask/users/54356267']").isDisplayed();
		Assert.assertTrue(user_present);
		filter_button = this.css_locator("#user-filter");
		filter_button.click();
		Thread.sleep(1000);
		boolean tagfollow_dot = this.css_locator("#filter > lyte-accordion:nth-child(5) div > span.tags.applied-filter-dot").isDisplayed();
		Assert.assertTrue(tagfollow_dot);
		tagsfollow_list = this.css_locator("#filter > lyte-accordion:nth-child(5)");
		tagsfollow_list.click();
		Thread.sleep(1000);
		WebElement particular_clear = this.css_locator("#filter > lyte-accordion:nth-child(5) div.clear-filter > div");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		particular_clear.click();
		Thread.sleep(2000);
		apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(1000);
	}

	////--------------------Tag followed in search-------------------////
	@Test
	public void team_tags_search() throws InterruptedException {
		WebElement filter_button = this.css_locator("#user-filter");
		filter_button.click();
		Thread.sleep(1000);
		WebElement tagsfollow_list = this.css_locator("#filter > lyte-accordion:nth-child(5)");
		tagsfollow_list.click();
		boolean tagfollow_list1 = driver.getPageSource().contains("Tags Followed");
		assertTrue(tagfollow_list1);
		Thread.sleep(1000);
		WebElement select_all_dropdown = this.css_locator("#user-tag-category-filter > div.lyteDummyEventContainer > lyte-drop-button");
		select_all_dropdown.click();
		WebElement all_option = this.xpath_locator("//lyte-drop-item[text()=' Team ']");
		all_option.click();
		Thread.sleep(1000);
		WebElement search_tags = this.css_locator("#search-users-followed-tags > div:nth-child(1) > input");
		search_tags.click();
		search_tags.clear();
		Thread.sleep(1000);
		String search_tags1 = "Search tags";
		assertEquals(search_tags1,search_tags.getAttribute("placeholder"));
		search_tags.sendKeys("andro");
		WebElement tags_choose = this.css_locator("#tag-filter-checkbox:nth-child(2) > label > span > span");
		tags_choose.click();
		Thread.sleep(2000);
		boolean checkbox_appear3 = this.css_locator("#tag-filter-checkbox:nth-child(2) input").isSelected();
		Assert.assertTrue(checkbox_appear3);
		Thread.sleep(2000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(1000);
		boolean user1 = driver.getPageSource().contains("esakkivash.n+testt50");
		assertTrue(user1);
		boolean user2 = driver.getPageSource().contains("santhoshbalaji.s");
		assertTrue(user2);
		Thread.sleep(2000);
		filter_button = this.css_locator("#user-filter");
		filter_button.click();
		Thread.sleep(1000);
		boolean tagfollow_dot = this.css_locator("#filter > lyte-accordion:nth-child(5) div > span.tags.applied-filter-dot").isDisplayed();
		Assert.assertTrue(tagfollow_dot);
		tagsfollow_list = this.css_locator("#filter > lyte-accordion:nth-child(5)");
		tagsfollow_list.click();
		Thread.sleep(1000);
		WebElement particular_clear = this.css_locator("#filter > lyte-accordion:nth-child(5) div.clear-filter > div");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		particular_clear.click();
		Thread.sleep(1000);
		apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(1000);
	}

	////------------------selecting technology tags-------------------////
	@Test
	public void selecting_technology_tags() throws InterruptedException {
		WebElement filter_button = this.css_locator("#user-filter");
		filter_button.click();
		Thread.sleep(1000);
		WebElement tagsfollow_list = this.css_locator("#filter > lyte-accordion:nth-child(5)");
		tagsfollow_list.click();
		boolean tagfollow_list1 = driver.getPageSource().contains("Tags Followed");
		assertTrue(tagfollow_list1);
		Thread.sleep(1000);
		WebElement select_all_dropdown = this.css_locator("#user-tag-category-filter > div.lyteDummyEventContainer > lyte-drop-button");
		select_all_dropdown.click();
		WebElement all_option = this.xpath_locator("//lyte-drop-item[text()=' Technology ']");
		all_option.click();
		Thread.sleep(2000);
		WebElement tag_selection = this.xpath_locator("//span[text()='Test+Tag']");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tag_selection);
		tag_selection.click();
		Thread.sleep(2000);
		boolean checkbox_appear = this.css_locator("#tag-filter-checkbox:nth-child(7) input").isSelected();
		Assert.assertTrue(checkbox_appear);
		Thread.sleep(2000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(1000);
		String expected_link = "https://zask.localpali.io/zask/users?sort=Name&category=All&user=&tags=Test%2BTag&searchIndex=22&choice=Name&time=All&page=1";
		assertEquals(expected_link,driver.getCurrentUrl());
		Thread.sleep(1000);
		boolean user1 = driver.getPageSource().contains("easkkivash.n+testt0");
		assertTrue(user1);
		boolean user2 = driver.getPageSource().contains("prabhakaran");
		assertTrue(user2);
		Thread.sleep(1000);
		WebElement user2_details = this.css_locator("a[href='/zask/users/10524002']");
		user2_details.click();
		Thread.sleep(3000);
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		filter_button = this.css_locator("#user-filter");
		filter_button.click();
		tagsfollow_list = this.css_locator("#filter > lyte-accordion:nth-child(5)");
		tagsfollow_list.click();
		Thread.sleep(1000);
		WebElement particular_clear = this.css_locator("#filter > lyte-accordion:nth-child(5) div.clear-filter > div");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		particular_clear.click();
		Thread.sleep(1000);
		apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(2000);
	}
////-----------------numbers in technologys search----------------////
	@Test
	public void numbers_technology_search() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement filter_button = this.css_locator("#user-filter");
		Thread.sleep(2000);
		filter_button.click();
		Thread.sleep(1000);
		WebElement tagsfollow_list = this.css_locator("#filter > lyte-accordion:nth-child(5)");
		tagsfollow_list.click();
		boolean tagfollow_list1 = driver.getPageSource().contains("Tags Followed");
		assertTrue(tagfollow_list1);
		Thread.sleep(1000);
		WebElement select_all_dropdown = this.css_locator("#user-tag-category-filter > div.lyteDummyEventContainer > lyte-drop-button");
		select_all_dropdown.click();
		WebElement all_option = this.xpath_locator("//lyte-drop-item[text()=' Technology ']");
		all_option.click();
		Thread.sleep(1000);
		WebElement search_tags = this.css_locator("#search-users-followed-tags > div:nth-child(1) > input");
		search_tags.click();
		search_tags.clear();
		Thread.sleep(1000);
		String search_tags1 = "Search tags";
		assertEquals(search_tags1,search_tags.getAttribute("placeholder"));
		search_tags.sendKeys("3");
		WebElement tags_choose = this.css_locator("#tag-filter-checkbox:nth-child(2) > label > span > span");
		tags_choose.click();
		Thread.sleep(2000);
		boolean checkbox_appear3 = this.css_locator("#tag-filter-checkbox:nth-child(2) input").isSelected();
		Assert.assertTrue(checkbox_appear3);
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(1000);
		boolean user1 = this.css_locator("a[href='/zask/users/1480161']").isDisplayed();
		Assert.assertTrue(user1);
		filter_button = this.css_locator("#user-filter");
		filter_button.click();
		Thread.sleep(1000);
		tagsfollow_list = this.css_locator("#filter > lyte-accordion:nth-child(5)");
		tagsfollow_list.click();
		Thread.sleep(2000);
		WebElement particular_clear = this.css_locator("#filter > lyte-accordion:nth-child(5) div.clear-filter > div");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		particular_clear.click();
		Thread.sleep(1000);
		apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(2000);
	}
	////------All Invalid characters,numbers...in technology tag------////
	@Test
	public void invalid_characters_technology_tag() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement filter_button = this.css_locator("#user-filter");
		Thread.sleep(2000);
		filter_button.click();
		Thread.sleep(1000);
		WebElement tagsfollow_list = this.css_locator("#filter > lyte-accordion:nth-child(5)");
		tagsfollow_list.click();
		boolean tagfollow_list1 = driver.getPageSource().contains("Tags Followed");
		assertTrue(tagfollow_list1);
		Thread.sleep(1000);
		WebElement select_all_dropdown = this.css_locator("#user-tag-category-filter > div.lyteDummyEventContainer > lyte-drop-button");
		select_all_dropdown.click();
		WebElement all_option = this.xpath_locator("//lyte-drop-item[text()=' Technology ']");
		all_option.click();
		Thread.sleep(1000);
		WebElement search_tags = this.css_locator("#search-users-followed-tags > div:nth-child(1) > input");
		search_tags.click();
		search_tags.clear();
		Thread.sleep(1000);
		String search_tags1 = "Search tags";
		assertEquals(search_tags1,search_tags.getAttribute("placeholder"));
		search_tags.sendKeys("!@#$$%^%*duuejcg51529103./");
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(1000);
		filter_button = this.css_locator("#user-filter");
		filter_button.click();
		Thread.sleep(2000);
		tagsfollow_list = this.css_locator("#filter > lyte-accordion:nth-child(5)");
		tagsfollow_list.click();
		Thread.sleep(1000);
		WebElement particular_clear = this.css_locator("#filter > lyte-accordion:nth-child(5) div.clear-filter > div");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		particular_clear.click();
		Thread.sleep(1000);
		apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(2000);
	}
	////----------------searching the technology tags-----------------////
	@Test
	public void searching_technology_tags() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement filter_button = this.css_locator("#user-filter");
		Thread.sleep(2000);
		filter_button.click();
		Thread.sleep(1000);
		WebElement tagsfollow_list = this.css_locator("#filter > lyte-accordion:nth-child(5)");
		tagsfollow_list.click();
		boolean tagfollow_list1 = driver.getPageSource().contains("Tags Followed");
		assertTrue(tagfollow_list1);
		Thread.sleep(1000);
		WebElement select_all_dropdown = this.css_locator("#user-tag-category-filter > div.lyteDummyEventContainer > lyte-drop-button");
		select_all_dropdown.click();
		WebElement all_option = this.xpath_locator("//lyte-drop-item[text()=' Technology ']");
		all_option.click();
		Thread.sleep(1000);
		WebElement search_tags = this.css_locator("#search-users-followed-tags > div:nth-child(1) > input");
		search_tags.click();
		search_tags.clear();
		Thread.sleep(1000);
		String search_tags1 = "Search tags";
		assertEquals(search_tags1,search_tags.getAttribute("placeholder"));
		search_tags.sendKeys("asp");
		WebElement tags_choose = this.css_locator("#tag-filter-checkbox:nth-child(3) > label > span > span");
		tags_choose.click();
		Thread.sleep(2000);
		boolean checkbox_appear3 = this.css_locator("#tag-filter-checkbox:nth-child(3) input").isSelected();
		Assert.assertTrue(checkbox_appear3);
		Thread.sleep(1000);
		WebElement apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(1000);
		boolean user1 = this.css_locator("a[href='/zask/users/58265424']").isDisplayed();
		Assert.assertTrue(user1);
		filter_button = this.css_locator("#user-filter");
		filter_button.click();
		Thread.sleep(2000);
		boolean tagfollow_dot = this.css_locator("#filter > lyte-accordion:nth-child(5) div > span.tags.applied-filter-dot").isDisplayed();
		Assert.assertTrue(tagfollow_dot);
		tagsfollow_list = this.css_locator("#filter > lyte-accordion:nth-child(5)");
		tagsfollow_list.click();
		Thread.sleep(1000);
		WebElement all_clear = this.xpath_locator("//div[text()='Clear All']");
		all_clear.click();
		Thread.sleep(1000);
		apply_button = this.xpath_locator("//button[text()='Apply']");
		apply_button.click();
		Thread.sleep(1000);
	}
	
	@Test
	public void logout() throws InterruptedException {
		WebElement cld = this.css_locator(".user-profile-window");
		cld.click();
		Thread.sleep(1000);
		WebElement cld1 = this.css_locator(".sign-out-button");
		cld1.click();
	}

	@AfterAll

	public void end_clse() {
		driver.quit();
	}
	

}