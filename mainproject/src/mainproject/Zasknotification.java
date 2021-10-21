package mainproject;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.BeforeClass;
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
public class Zasknotification {
	public static WebDriver driver;
	public static WebElement demo;
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
	
	public WebElement logout_account() throws InterruptedException {
		WebElement logout_new = this.css_locator(".user-profile-window");
		logout_new.click();
		Thread.sleep(1000);
		WebElement cld1 = this.css_locator(".sign-out-button");
		cld1.click();
		return cld1;
	}
	
	public WebElement login_account_admin() {
		WebElement login_test = this.xpath_locator("//a[text()='Login']");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		login_test.click();
		WebElement log2 = this.css_locator("#login_id");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		log2.click();
		log2.clear();
		log2.sendKeys("********************");
		WebElement nxt = this.css_locator("#nextbtn");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		nxt.click();
		WebElement log3 = this.css_locator("#password");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		log3.click();
		log3.clear();
		log3.sendKeys("**************");
		nxt.click();
		return log3;
	}
	
	public WebElement login_account_test() {
		WebElement login_test = this.xpath_locator("//a[text()='Login']");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		login_test.click();
		WebElement log2 = this.css_locator("#login_id");
		log2.click();
		log2.clear();
		log2.sendKeys("********************");
		WebElement nxt = this.css_locator("#nextbtn");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		nxt.click();
		WebElement log3 = this.css_locator("#password");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		log3.click();
		log3.clear();
		log3.sendKeys("**********");
		nxt.click();
		return log3;
	}
	
	public WebElement notifications_settings() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		WebElement profile = this.css_locator("#outlet > zask-container > zask-ui-header > div:nth-child(1) > div > zask-ui-user-panel > div.user-profile-container > div");
		profile.click();
		Thread.sleep(1000);
		WebElement profile_settings = this.css_locator("#outlet zask-ui-user-panel > zask-ui-user-profile > div.zask-user-profile > div:nth-child(2) > div:nth-child(3) > a:nth-child(2)");
		profile_settings.click();
		Thread.sleep(1000);
		return profile_settings;
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
		
		////------------------Login into the Zask--------------------////
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
			log2.sendKeys("*********************");
			WebElement nxt = this.css_locator("#nextbtn");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			nxt.click();
			WebElement log3 = this.css_locator("#password");
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			log3.click();
			log3.clear();
			log3.sendKeys("*********");
			nxt.click();
			Thread.sleep(2000);
		}
		
		////-----------------profile and settings page----------------////
		@Test
		public void profile_settings_page() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			WebElement profile = this.css_locator("#outlet > zask-container > zask-ui-header > div:nth-child(1) > div > zask-ui-user-panel > div.user-profile-container > div");
			profile.click();
			Thread.sleep(1000);
			WebElement profile_settings = this.css_locator("#outlet zask-ui-user-panel > zask-ui-user-profile > div.zask-user-profile > div:nth-child(2) > div:nth-child(3) > a:nth-child(2)");
			String text_expected = "Profile & Settings";
			assertEquals(profile_settings.getText(),text_expected);
			profile_settings.click();
			Thread.sleep(1000);
			String expected_link = "https://zask.localpali.io/zask/settings";
			assertEquals(expected_link,driver.getCurrentUrl());
			Thread.sleep(2000);
		}
		
		@Test
		public void disable_to_enable_notification() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			boolean notification_state = this.xpath_locator("//*[@id=\"all-notification-checkbox\"]").isSelected();
			WebElement all_notify = this.css_locator("label[mouseup='lyte-checkbox => mup(event)']");
			if(notification_state) {
				assertTrue(notification_state);
			}
			else {
				all_notify.click();
			}
			Thread.sleep(1000);
			boolean question_state = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected > div:nth-child(1) > lyte-checkbox input").isSelected();
			WebElement question_change = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(1) > lyte-checkbox label");
			if(question_state) {
				assertTrue(question_state);
			}
			else {
				question_change.click();
			}
			Thread.sleep(1000);
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			boolean article_state = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected > div:nth-child(2) > lyte-checkbox input").isSelected();
			WebElement article_change = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(2) > lyte-checkbox label");
			if(article_state) {
				assertTrue(article_state);
			}
			else {
				article_change.click();
			}
			Thread.sleep(1000);
			boolean answer_state = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(3) > lyte-checkbox input").isSelected();
			WebElement answer_change = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(3) > lyte-checkbox label");
			if(answer_state) {
				assertTrue(answer_state);
			}
			else {
				answer_change.click();
			}
			Thread.sleep(1000);
			boolean comment_state = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(4) > lyte-checkbox input").isSelected();
			WebElement comment_change = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(4) > lyte-checkbox label");
			if(comment_state) {
				assertTrue(comment_state);
			}
			else {
				comment_change.click();
			}
			Thread.sleep(1000);
			boolean review_state = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(5) > lyte-checkbox input").isSelected();
			WebElement review_change = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(5) > lyte-checkbox label");
			if(review_state) {
				assertTrue(review_state);
			}
			else {
				review_change.click();
			}
			Thread.sleep(1000);
			boolean vote_state = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(6) > lyte-checkbox input").isSelected();
			WebElement vote_change = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(6) > lyte-checkbox label");
			if(vote_state) {
				assertTrue(vote_state);
			}
			else {
				vote_change.click();
			}
		}
		
		////---------------Questions all notifications---------------////
		@Test
		public void disable_to_enable_notification_Test() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_test();
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			WebElement profile = this.css_locator("#outlet > zask-container > zask-ui-header > div:nth-child(1) > div > zask-ui-user-panel > div.user-profile-container > div");
			profile.click();
			Thread.sleep(1000);
			WebElement profile_settings = this.css_locator("#outlet zask-ui-user-panel > zask-ui-user-profile > div.zask-user-profile > div:nth-child(2) > div:nth-child(3) > a:nth-child(2)");
			String text_expected = "Profile & Settings";
			assertEquals(profile_settings.getText(),text_expected);
			profile_settings.click();
			Thread.sleep(1000);
			boolean notification_state = this.xpath_locator("//*[@id=\"all-notification-checkbox\"]").isSelected();
			WebElement all_notify = this.css_locator("label[mouseup='lyte-checkbox => mup(event)']");
			if(notification_state) {
				assertTrue(notification_state);
			}
			else {
				all_notify.click();
			}
			Thread.sleep(1000);
			boolean question_state = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected > div:nth-child(1) > lyte-checkbox input").isSelected();
			WebElement question_change = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(1) > lyte-checkbox label");
			if(question_state) {
				assertTrue(question_state);
			}
			else {
				question_change.click();
			}
			Thread.sleep(1000);
			boolean article_state = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected > div:nth-child(2) > lyte-checkbox input").isSelected();
			WebElement article_change = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(2) > lyte-checkbox label");
			if(article_state) {
				assertTrue(article_state);
			}
			else {
				article_change.click();
			}
			Thread.sleep(1000);
			boolean answer_state = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(3) > lyte-checkbox input").isSelected();
			WebElement answer_change = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(3) > lyte-checkbox label");
			if(answer_state) {
				assertTrue(answer_state);
			}
			else {
				answer_change.click();
			}
			Thread.sleep(1000);
			boolean comment_state = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(4) > lyte-checkbox input").isSelected();
			WebElement comment_change = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(4) > lyte-checkbox label");
			if(comment_state) {
				assertTrue(comment_state);
			}
			else {
				comment_change.click();
			}
			Thread.sleep(1000);
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			boolean review_state = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(5) > lyte-checkbox input").isSelected();
			WebElement review_change = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(5) > lyte-checkbox label");
			if(review_state) {
				assertTrue(review_state);
			}
			else {
				review_change.click();
			}
			Thread.sleep(1000);
			boolean vote_state = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(6) > lyte-checkbox input").isSelected();
			WebElement vote_change = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(6) > lyte-checkbox label");
			if(vote_state) {
				assertTrue(vote_state);
			}
			else {
				vote_change.click();
			}
			Thread.sleep(2000);
		}
		
		////----------questions notifications check(bounty)----------////
		@Test
		public void questions_notification_bounty() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_admin();
			Thread.sleep(2000);
			WebElement test_question = this.css_locator("a[href='/zask/questions/8239830252']");
			test_question.click();
			String question_link = "https://zask.localpali.io/zask/questions/8239830252";
			assertEquals(question_link,driver.getCurrentUrl());
			Thread.sleep(1000);
			driver.navigate().refresh(); 
			Thread.sleep(3000);
			WebElement bounty_check = this.css_locator("zask-ui-button[lt-prop-title='Give 50-500 reputation for an answer']");
			bounty_check.click();
			Thread.sleep(1000);
			WebElement selecting_bounty = this.xpath_locator("//div[text()='50']");
			selecting_bounty.click();
			Thread.sleep(2000);
			String bounty_alert = "Bounty Placed Successfully";
			String bounty_actual = this.css_locator(".lyteMessageBoxContent").getText();
			assertEquals(bounty_alert,bounty_actual);
			Thread.sleep(2000);
		}
		
		////-----------checking bounty notifications shown-----------////
		@Test
		public void bounty_notification_check() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(1000);
			demo = this.login_account_test();
			Thread.sleep(2000);
			WebElement notification_check = this.css_locator("span[lt-prop-title='Notifications']");
			notification_check.click();
			Thread.sleep(2000);
			boolean notify_count = this.xpath_locator("//*[@id=\"notification-count\"]").isDisplayed();
			Assert.assertTrue(notify_count);
			Thread.sleep(1000);
			String expected_value = "1";
			String notify_count_value = this.xpath_locator("//*[@id=\"notification-count\"]").getText();
			assertEquals(expected_value,notify_count_value);
			boolean notify_found = driver.getPageSource().contains("has placed a bounty on your question");
			assertTrue(notify_found);
			Thread.sleep(2000);
			WebElement read_notify = this.xpath_locator("//span[text()='Mark all as read']");
			read_notify.click();
			Thread.sleep(2000);
			String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
			String expected_data = "1 Notification(s) marked read successfully.";
			assertEquals(expected_data, actual_data);
			Thread.sleep(2000);
		}
		
		////-------------Disabling question notifications------------////
		@Test
		public void disabling_question_notification() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.notifications_settings();
			boolean question_notification = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(1) > lyte-checkbox input").isSelected();
			assertTrue(question_notification);
			Thread.sleep(1000);
			WebElement disabling_question_notify = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(1) > lyte-checkbox label");
			disabling_question_notify.click();
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			question_notification = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(6) > lyte-checkbox input").isSelected();
			assertTrue(question_notification);
			Thread.sleep(1000);
			disabling_question_notify = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(6) > lyte-checkbox label");
			disabling_question_notify.click();
			Thread.sleep(2000);
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_admin();
			Thread.sleep(2000);
			WebElement test_question = this.css_locator("a[href='/zask/questions/8239830252']");
			test_question.click();
			String question_link = "https://zask.localpali.io/zask/questions/8239830252";
			assertEquals(question_link,driver.getCurrentUrl());
			Thread.sleep(1000);
			driver.navigate().refresh();
			Thread.sleep(3000);
			WebElement bounty_check = this.css_locator("zask-ui-button[lt-prop-title='Give 50-500 reputation for an answer']");
			bounty_check.click(); 
			Thread.sleep(1000);
			WebElement selecting_bounty = this.xpath_locator("//div[text()='50']");
			selecting_bounty.click();
			Thread.sleep(3000);
			String bounty_alert = "Bounty Placed Successfully";
			String bounty_actual = this.css_locator(".lyteMessageBoxContent").getText();
			assertEquals(bounty_alert,bounty_actual);
			Thread.sleep(2000);
		}
		
		////-----------Bounty disabling notificaation check----------////
		@Test
		public void bounty_disabling_notification() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_test();
			Thread.sleep(2000);
			WebElement notification_check = this.css_locator("span[lt-prop-title='Notifications']");
			notification_check.click();
			Thread.sleep(2000);
		}
		
		////----------Flagging a question in admin account---------////
		@Test
		public void flag_question_notification_check() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_admin();
			Thread.sleep(2000);
			WebElement test_question = this.css_locator("a[href='/zask/questions/8239830252']");
			test_question.click();
			String question_link = "https://zask.localpali.io/zask/questions/8239830252";
			assertEquals(question_link,driver.getCurrentUrl());
			Thread.sleep(1000);
			driver.navigate().refresh();
			Thread.sleep(3000);
			WebElement flag_icon = this.css_locator("#flag-8239830252");
			flag_icon.click();
			Thread.sleep(1000);
			String flag_type = "Spam";
			WebElement flag_type1 = this.css_locator(".flag-r:nth-child(1)");
			assertEquals(flag_type,flag_type1.getText());
			flag_type1.click();
			Thread.sleep(4000);	
			boolean flag = driver.getPageSource().contains("Flagged!");
			assertTrue(flag);
			Thread.sleep(2000);
		}
		
		////-------------flag notification shows in test-------------////
		@Test
		public void flag_notification_check() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_test();
			Thread.sleep(2000);
			WebElement notification_check = this.css_locator("span[lt-prop-title='Notifications']");
			notification_check.click();
			Thread.sleep(2000);
			boolean notify_count = this.xpath_locator("//*[@id=\"notification-count\"]").isDisplayed();
			Assert.assertTrue(notify_count);
			Thread.sleep(1000);
			String expected_value = "1";
			String notify_count_value = this.xpath_locator("//*[@id=\"notification-count\"]").getText();
			assertEquals(expected_value,notify_count_value);
			boolean notify_found = driver.getPageSource().contains("Your question: How to ask a good question? has been flagged and removed.");
			assertTrue(notify_found);
			Thread.sleep(2000);
			WebElement read_notify = this.xpath_locator("//span[text()='Mark all as read']");
			read_notify.click();
			Thread.sleep(2000);
			String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
			String expected_data = "1 Notification(s) marked read successfully.";
			assertEquals(expected_data, actual_data);
			Thread.sleep(2000);
		}
		
		////-----------disabling flag question notification----------////
		@Test
		public void disabling_flag_question_notification() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.notifications_settings();
			boolean question_notification = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(1) > lyte-checkbox input").isSelected();
			assertTrue(question_notification);
			Thread.sleep(1000);
			WebElement disabling_question_notify = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(1) > lyte-checkbox label");
			disabling_question_notify.click();
			Thread.sleep(2000);
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_admin();
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			WebElement test_question = this.css_locator("a[href='/zask/questions/8239830252']");
			test_question.click();
			String question_link = "https://zask.localpali.io/zask/questions/8239830252";
			assertEquals(question_link,driver.getCurrentUrl());
			Thread.sleep(1000);
			WebElement portal_move = this.css_locator(".overflowMenu");
			portal_move.click();
			Thread.sleep(1000);
			WebElement option_view = this.xpath_locator("//div[text()='Move to portal']");
			option_view.click();
			Thread.sleep(2000);
			WebElement accept_portal = this.xpath_locator("//*[@id=\"modal-btn\"]");
			accept_portal.click();
			Thread.sleep(2000);
			WebElement flag_icon = this.css_locator("#flag-8239830252");
			flag_icon.click();
			Thread.sleep(1000);
			String flag_type = "Spam";
			WebElement flag_type1 = this.css_locator(".flag-r:nth-child(1)");
			assertEquals(flag_type,flag_type1.getText());
			flag_type1.click();
			Thread.sleep(4000);	
			boolean flag = driver.getPageSource().contains("Flagged!");
			assertTrue(flag);
			Thread.sleep(2000);
		}
		
		////------------flag disabling notification check------------////
		@Test
		public void flag_disabling_notification() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_test();
			Thread.sleep(2000);
			WebElement notification_check = this.css_locator("span[lt-prop-title='Notifications']");
			notification_check.click();
			Thread.sleep(2000);
		}
		
		////---------Editing the question notification check---------////
		@Test
		public void edit_question() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_admin();
			Thread.sleep(2000);
			WebElement question_new = this.css_locator("a[href='/zask/questions/8239830252']");
			question_new.click();
			Thread.sleep(1000);
			String expected_link = "https://zask.localpali.io/zask/questions/8239830252";
			assertEquals(expected_link,driver.getCurrentUrl());
			WebElement question_edit = this.css_locator("span[lt-prop-title='Edit']");
			question_edit.click();
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			WebElement edit_reason = this.xpath_locator("//*[@id=\"add-question-edit-summary\"]");
			edit_reason.click();
			edit_reason.clear();
			edit_reason.sendKeys("Provide details");
			Thread.sleep(1000);
			String expected_text = "Provide details";
			assertEquals(expected_text,edit_reason.getAttribute("value"));
			Thread.sleep(2000);
			WebElement submit_btn = this.xpath_locator("//*[@id=\"add-question-submit\"]");
			submit_btn.click();
			Thread.sleep(3000);
			String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
			expected_text = "Your post has been sent for review";
			assertEquals(expected_text, actual_data);
			Thread.sleep(2000);
		}
		
		////------checking edited question notification shows-------////
		@Test
		public void question_notification_check() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_test();
			Thread.sleep(2000);
			WebElement notification_check = this.css_locator("span[lt-prop-title='Notifications']");
			notification_check.click();
			Thread.sleep(2000);
			boolean notify_count = this.xpath_locator("//*[@id=\"notification-count\"]").isDisplayed();
			Assert.assertTrue(notify_count);
			Thread.sleep(1000);
			String expected_value = "1";
			String notify_count_value = this.xpath_locator("//*[@id=\"notification-count\"]").getText();
			assertEquals(expected_value,notify_count_value);
			boolean notify_found = driver.getPageSource().contains("esakkivash.n has edited your question: How to ask a good question?");
			assertTrue(notify_found);
			Thread.sleep(1000);
			WebElement read_notify = this.xpath_locator("//span[text()='Mark all as read']");
			read_notify.click();
			Thread.sleep(2000);
			String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
			String expected_data = "1 Notification(s) marked read successfully.";
			assertEquals(expected_data, actual_data);
			Thread.sleep(2000);
		}
		
		////----------disabling questions notification check---------////
		@Test
		public void disabling_editQuestion_notification() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.notifications_settings();
			Thread.sleep(2000);
			boolean question_notification = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(1) > lyte-checkbox input").isSelected();
			assertTrue(question_notification);
			Thread.sleep(1000);
			WebElement disabling_question_notify = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(1) > lyte-checkbox label");
			disabling_question_notify.click();
			Thread.sleep(2000);
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_admin();
			Thread.sleep(2000);
			WebElement question_new = this.css_locator("a[href='/zask/questions/8239830252']");
			question_new.click();
			Thread.sleep(1000);
			String expected_link = "https://zask.localpali.io/zask/questions/8239830252";
			assertEquals(expected_link,driver.getCurrentUrl());
			WebElement question_edit = this.css_locator("span[lt-prop-title='Edit']");
			question_edit.click();
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			WebElement edit_reason = this.xpath_locator("//*[@id=\"add-question-edit-summary\"]");
			edit_reason.click();
			edit_reason.clear();
			edit_reason.sendKeys("Provide details");
			Thread.sleep(1000);
			String expected_text = "Provide details";
			assertEquals(expected_text,edit_reason.getAttribute("value"));
			Thread.sleep(2000);
			WebElement submit_btn = this.xpath_locator("//*[@id=\"add-question-submit\"]");
			submit_btn.click();
			Thread.sleep(3000);
			String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
			expected_text = "Your post has been sent for review";
			assertEquals(expected_text, actual_data);
			Thread.sleep(2000);
		}
		
		////-----------disable question notification check-----------////
		@Test
		public void disable_question_notification() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_test();
			Thread.sleep(2000);
			WebElement notification_check = this.css_locator("span[lt-prop-title='Notifications']");
			notification_check.click();
			Thread.sleep(2000);
			boolean notify_count = this.xpath_locator("//*[@id=\"notification-count\"]").isDisplayed();
			Assert.assertTrue(notify_count);
			Thread.sleep(1000);
			String expected_value = "1";
			String notify_count_value = this.xpath_locator("//*[@id=\"notification-count\"]").getText();
			assertEquals(expected_value,notify_count_value);
			boolean notify_found = driver.getPageSource().contains("esakkivash.n has edited your question: How to ask a good question?");
			assertTrue(notify_found);
			Thread.sleep(1000);
			WebElement read_notify = this.xpath_locator("//span[text()='Mark all as read']");
			read_notify.click();
			Thread.sleep(2000);
			String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
			String expected_data = "1 Notification(s) marked read successfully.";
			assertEquals(expected_data, actual_data);
			Thread.sleep(2000);
		}
		
		////---------------favouriting the question------------------////
		@Test
		public void favouriting_the_question() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.notifications_settings();
			Thread.sleep(2000);
			boolean question_notification = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(1) > lyte-checkbox input").isSelected();
			assertFalse(question_notification);
			Thread.sleep(1000); 
			WebElement disabling_question_notify = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(1) > lyte-checkbox label");
			disabling_question_notify.click();
			Thread.sleep(2000);
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_admin();
			Thread.sleep(2000);
			WebElement question_new = this.css_locator("a[href='/zask/questions/8239830252']");
			question_new.click();
			Thread.sleep(1000);
			String expected_link = "https://zask.localpali.io/zask/questions/8239830252";
			assertEquals(expected_link,driver.getCurrentUrl());
			Thread.sleep(1000);
			WebElement favour_question = this.css_locator("#vote-8239830252 > div.fav > div");
			favour_question.click();
			Thread.sleep(2000);
		}
		
		////----------checking favourite notification shows----------////
		@Test
		public void favourite_notification_check() throws InterruptedException {
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_test();
			Thread.sleep(2000);
			WebElement notification_check = this.css_locator("span[lt-prop-title='Notifications']");
			notification_check.click();
			Thread.sleep(2000);
			boolean notify_count = this.xpath_locator("//*[@id=\"notification-count\"]").isDisplayed();
			Assert.assertTrue(notify_count);
			Thread.sleep(1000);
			String expected_value = "1";
			String notify_count_value = this.xpath_locator("//*[@id=\"notification-count\"]").getText();
			assertEquals(expected_value,notify_count_value);
			boolean notify_found = driver.getPageSource().contains("Your question: How to ask a good question? has been marked favourite by esakkivash.n.");
			assertTrue(notify_found);
			Thread.sleep(1000);
			WebElement read_notify = this.xpath_locator("//span[text()='Mark all as read']");
			read_notify.click();
			Thread.sleep(2000);
			String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
			String expected_data = "1 Notification(s) marked read successfully.";
			assertEquals(expected_data, actual_data);
			Thread.sleep(2000);
		}
		
		////-----------disabling question,vote notification----------////
		@Test
		public void disabling_favourite_question_notification() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.notifications_settings();
			Thread.sleep(2000);
			boolean question_notification = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(1) > lyte-checkbox input").isSelected();
			assertTrue(question_notification);
			Thread.sleep(1000);
			WebElement disabling_question_notify = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(1) > lyte-checkbox label");
			disabling_question_notify.click();
			Thread.sleep(2000);
			disabling_question_notify = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(6) > lyte-checkbox label");
			disabling_question_notify.click();
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_admin();
			Thread.sleep(2000);
			WebElement question_new = this.css_locator("a[href='/zask/questions/8239830252']");
			question_new.click();
			Thread.sleep(1000);
			String expected_link = "https://zask.localpali.io/zask/questions/8239830252";
			assertEquals(expected_link,driver.getCurrentUrl());
			Thread.sleep(1000);
			WebElement favour_question = this.css_locator("#vote-8239830252 > div.fav > div");
			favour_question.click();
			Thread.sleep(2000);
		}
		
		////-----------disable notification favourite check----------////
		@Test
		public void favourite_disable_notification_check() throws InterruptedException {
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_test();
			Thread.sleep(2000);
			WebElement notification_check = this.css_locator("span[lt-prop-title='Notifications']");
			notification_check.click();
			Thread.sleep(2000);
			boolean notify_count = this.xpath_locator("//*[@id=\"notification-count\"]").isDisplayed();
			Assert.assertTrue(notify_count);
			Thread.sleep(1000);
			String expected_value = "1";
			String notify_count_value = this.xpath_locator("//*[@id=\"notification-count\"]").getText();
			assertEquals(expected_value,notify_count_value);
			boolean notify_found = driver.getPageSource().contains("Your question: How to ask a good question? has been marked favourite by esakkivash.n.");
			assertTrue(notify_found);
			Thread.sleep(1000);
			WebElement read_notify = this.xpath_locator("//span[text()='Mark all as read']");
			read_notify.click();
			Thread.sleep(2000);
			String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
			String expected_data = "1 Notification(s) marked read successfully.";
			assertEquals(expected_data, actual_data);
			Thread.sleep(2000);
		}
		
		////---------Editing the article notification check----------////
		@Test
		public void edit_article() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			WebElement article_link = this.css_locator("link-to[lt-prop-route='index.articles']");
			article_link.click();
			String expected_link = "https://zask.localpali.io/zask/articles?sort=New&filter=All";
			assertEquals(expected_link,driver.getCurrentUrl());
			WebElement article_new = this.css_locator("a[href='/zask/articles/8147130582']");
			article_new.click();
			Thread.sleep(1000);
			expected_link = "https://zask.localpali.io/zask/articles/8147130582";
			assertEquals(expected_link,driver.getCurrentUrl());
			Thread.sleep(1000);
			WebElement article_edit = this.css_locator("span[lt-prop-title='Edit']");
			article_edit.click();
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			WebElement edit_reason = this.xpath_locator("//*[@id=\"add-question-edit-summary\"]");
			edit_reason.click();
			edit_reason.clear();
			edit_reason.sendKeys("Provide relevant repository links");
			Thread.sleep(1000);
			String expected_text = "Provide relevant repository links";
			assertEquals(expected_text,edit_reason.getAttribute("value"));
			Thread.sleep(2000);
			WebElement submit_btn = this.xpath_locator("//*[@id=\"add-question-submit\"]");
			submit_btn.click();
			Thread.sleep(3000);
			String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
			expected_text = "Your post has been sent for review";
			assertEquals(expected_text, actual_data);
			Thread.sleep(2000);
		}
		
		////---------checking article edit notification shows----------////
		@Test
		public void article_notification_check() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_admin();
			Thread.sleep(2000);
			WebElement notification_check = this.css_locator("span[lt-prop-title='Notifications']");
			notification_check.click();
			Thread.sleep(2000);
			boolean notify_count = this.xpath_locator("//*[@id=\"notification-count\"]").isDisplayed();
			Assert.assertTrue(notify_count);
			Thread.sleep(1000);
			String expected_value = "1";
			String notify_count_value = this.xpath_locator("//*[@id=\"notification-count\"]").getText();
			assertEquals(expected_value,notify_count_value);
			boolean notify_found = driver.getPageSource().contains("easkkivash.n+testt0 has edited your article: What does a good article look like?");
			assertTrue(notify_found);
			Thread.sleep(1000);
			WebElement read_notify = this.xpath_locator("//span[text()='Mark all as read']");
			read_notify.click();
			Thread.sleep(2000);
			String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
			String expected_data = "1 Notification(s) marked read successfully.";
			assertEquals(expected_data, actual_data);
			Thread.sleep(2000);
		}
		
		////----------Disabling article notification check----------////
		@Test
		public void disable_article_notification() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.notifications_settings();
			Thread.sleep(2000);
			boolean article_notification = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(2) > lyte-checkbox input").isSelected();
			assertTrue(article_notification);
			Thread.sleep(1000);
			WebElement disabling_article_notify = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(2) > lyte-checkbox label");
			disabling_article_notify.click();
			Thread.sleep(2000);
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_test();
			Thread.sleep(2000);
			WebElement article_link = this.css_locator("link-to[lt-prop-route='index.articles']");
			article_link.click();
			String expected_link = "https://zask.localpali.io/zask/articles?sort=New&filter=All";
			assertEquals(expected_link,driver.getCurrentUrl());
			WebElement article_new = this.css_locator("a[href='/zask/articles/8147130582']");
			article_new.click();
			Thread.sleep(1000);
			expected_link = "https://zask.localpali.io/zask/articles/8147130582";
			assertEquals(expected_link,driver.getCurrentUrl());
			Thread.sleep(1000);
			WebElement article_edit = this.css_locator("span[lt-prop-title='Edit']");
			article_edit.click();
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			WebElement edit_reason = this.xpath_locator("//*[@id=\"add-question-edit-summary\"]");
			edit_reason.click();
			edit_reason.clear();
			edit_reason.sendKeys("Provide relevant repository links");
			Thread.sleep(1000);
			String expected_text = "Provide relevant repository links";
			assertEquals(expected_text,edit_reason.getAttribute("value"));
			Thread.sleep(2000);
			WebElement submit_btn = this.xpath_locator("//*[@id=\"add-question-submit\"]");
			submit_btn.click();
			Thread.sleep(3000);
			String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
			expected_text = "Your post has been sent for review";
			assertEquals(expected_text, actual_data);
			Thread.sleep(2000);
		}
		
		////-----------checking disable notification shows-----------////
		@Test
		public void disable_article_notification_check() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_admin();
			Thread.sleep(2000);
			WebElement notification_check = this.css_locator("span[lt-prop-title='Notifications']");
			notification_check.click();
			Thread.sleep(2000);
			boolean notify_count = this.xpath_locator("//*[@id=\"notification-count\"]").isDisplayed();
			Assert.assertTrue(notify_count);
			Thread.sleep(1000);
			String expected_value = "1";
			String notify_count_value = this.xpath_locator("//*[@id=\"notification-count\"]").getText();
			assertEquals(expected_value,notify_count_value);
			boolean notify_found = driver.getPageSource().contains("easkkivash.n+testt0 has edited your article: What does a good article look like?");
			assertTrue(notify_found);
			Thread.sleep(1000);
			WebElement read_notify = this.xpath_locator("//span[text()='Mark all as read']");
			read_notify.click();
			Thread.sleep(2000);
			String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
			String expected_data = "1 Notification(s) marked read successfully.";
			assertEquals(expected_data, actual_data);
			Thread.sleep(2000);
		}
		
	
		
		////--------Posting a new question(review notifiction)-------////
		@Test
		public void posting_question() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_test();
			Thread.sleep(2000);
			String expected_link = "https://zask.localpali.io/zask/questions?sort=New&filter=All";
			assertEquals(expected_link,driver.getCurrentUrl());
			Thread.sleep(1000);
			driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
			WebElement question_post = this.css_locator(".ask-question-container>zask-ui-button");
			question_post.click();
			Thread.sleep(1000);
			WebElement title1 = this.css_locator("#add-question-title");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", title1);
			title1.sendKeys("How to ask a good question?");
			Thread.sleep(1000);
			String val1 = "How to ask a good question?";
			assertEquals(val1, title1.getAttribute("value"));
			Thread.sleep(2000);
			WebElement ques1 = this.css_locator(".ql-editor");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", ques1);
			ques1.click();
			ques1.clear();
			ques1.sendKeys("How to ask a good question?");
			WebElement ques2 = this.css_locator(".ql-editor>p");
			String val2 = "How to ask a good question?";
			assertEquals(val2, ques2.getText());
			WebElement tags = this.css_locator("#input");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tags);
			tags.click();
			tags.sendKeys(Keys.BACK_SPACE);
			tags.sendKeys(Keys.BACK_SPACE);
			tags.sendKeys("test");
			Thread.sleep(1500);
			tags.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			String val3 = "test";
			WebElement tg1 = this.xpath_locator("//*[@id=\"outlet-zask-content-container\"]/zask-content-container/div[1]/zask-add-question/div/div[3]/zask-ui-tags-multi-selector/div/zask-ui-tag-closable[1]");
			assertEquals(val3, tg1.getAttribute("tagname"));
			Thread.sleep(1000);
			WebElement post_submit = this.css_locator("#add-question-submit");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			post_submit.click();
			Thread.sleep(2000);
			WebElement yes1 = this.css_locator("#modal-btn");
			String expected_data = ("Yes");
			assertEquals(expected_data, yes1.getText());
			Thread.sleep(1000);
			yes1.click();
			Thread.sleep(3000);
			String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
			expected_data = "Your post has been sent for review";
			assertEquals(expected_data, actual_data);
			Thread.sleep(2000);
		}
		
		////-----Checking the question review  notifications has appeared-----////
		@Test
		public void questions_notifications() throws InterruptedException {
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_admin();
			Thread.sleep(2000);
			WebElement notification_check = this.css_locator("span[lt-prop-title='Notifications']");
			notification_check.click();
			Thread.sleep(2000);
			boolean notify_count = this.xpath_locator("//*[@id=\"notification-count\"]").isDisplayed();
			Assert.assertTrue(notify_count);
			Thread.sleep(1000);
			String expected_value = "1";
			String notify_count_value = this.xpath_locator("//*[@id=\"notification-count\"]").getText();
			assertEquals(expected_value,notify_count_value);
			boolean notify_found = driver.getPageSource().contains("You have a new question");
			assertTrue(notify_found);
			Thread.sleep(1000);
			WebElement read_notify = this.xpath_locator("//span[text()='Mark all as read']");
			read_notify.click();
			Thread.sleep(2000);
			String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
			String expected_data = "1 Notification(s) marked read successfully.";
			assertEquals(expected_data, actual_data);
			Thread.sleep(2000);
		}
		
		////-------Turning off the questions review notifications check------////
		@Test
		public void question_notifications_disable() throws InterruptedException {
			demo = this.logout_account();
			Thread.sleep(1000);
			demo = this.login_account_admin();
			Thread.sleep(2000);
			demo = this.notifications_settings();
			Thread.sleep(1000);
			boolean question_notification = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(5) > lyte-checkbox input").isSelected();
			assertTrue(question_notification);
			Thread.sleep(1000);
			WebElement disabling_question_notify = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(5) > lyte-checkbox label");
			disabling_question_notify.click();
			Thread.sleep(1000);
			String expected_data = "Notification profile has been updated.";
			String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
			assertEquals(expected_data, actual_data);
			boolean question_notification1 = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(5) > lyte-checkbox input").isSelected();
			assertFalse(question_notification1);
			Thread.sleep(1000);
		}
		
		////---Posting the same question with notification disable----////
		@Test
		public void same_question_notification_disable() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_test();
			Thread.sleep(2000);
			WebElement question_page = this.css_locator("link-to[lt-prop-route='index.questions']");
			question_page.click();
			String expected_link = "https://zask.localpali.io/zask/questions?sort=New&filter=All";
			assertEquals(expected_link,driver.getCurrentUrl());
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
			WebElement question_post = this.css_locator(".ask-question-container>zask-ui-button");
			question_post.click();
			Thread.sleep(1000);
			WebElement title1 = this.css_locator("#add-question-title");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", title1);
			title1.sendKeys("How to ask a good question?");
			Thread.sleep(1000);
			String val1 = "How to ask a good question?";
			assertEquals(val1, title1.getAttribute("value"));
			Thread.sleep(2000);
			WebElement ques1 = this.css_locator(".ql-editor");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", ques1);
			ques1.click();
			ques1.clear();
			ques1.sendKeys("How to ask a good question?");
			WebElement ques2 = this.css_locator(".ql-editor>p");
			String val2 = "How to ask a good question?";
			assertEquals(val2, ques2.getText());
			WebElement tags = this.css_locator("#input");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tags);
			tags.click();
			tags.sendKeys(Keys.BACK_SPACE);
			tags.sendKeys(Keys.BACK_SPACE);
			tags.sendKeys("test");
			Thread.sleep(1500);
			tags.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			String val3 = "test";
			WebElement tg1 = this.xpath_locator("//*[@id=\"outlet-zask-content-container\"]/zask-content-container/div[1]/zask-add-question/div/div[3]/zask-ui-tags-multi-selector/div/zask-ui-tag-closable[1]");
			assertEquals(val3, tg1.getAttribute("tagname"));
			Thread.sleep(1000);
			WebElement post_submit = this.css_locator("#add-question-submit");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			post_submit.click();
			Thread.sleep(2000);
			WebElement yes1 = this.css_locator("#modal-btn");
			String expected_data = ("Yes");
			assertEquals(expected_data, yes1.getText());
			Thread.sleep(1000);
			yes1.click();
			Thread.sleep(3000);
			String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
			expected_data = "Your post has been sent for review";
			assertEquals(expected_data, actual_data);
			Thread.sleep(2000);
		}
		
		////--Checking the question notifications has not appeared--////
		
		@Test
		public void questions_notifications_notFound() throws InterruptedException {
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_admin();
			Thread.sleep(2000);
			WebElement notification_check = this.css_locator("span[lt-prop-title='Notifications']");
			notification_check.click();
			Thread.sleep(2000);
			boolean notify_count = this.xpath_locator("//*[@id=\"notification-count\"]").isDisplayed();
			Assert.assertTrue(notify_count);
			Thread.sleep(1000);
			String expected_value = "1";
			String notify_count_value = this.xpath_locator("//*[@id=\"notification-count\"]").getText();
			assertEquals(expected_value,notify_count_value);
			boolean notify_found = driver.getPageSource().contains("You have a new question");
			assertTrue(notify_found);
			Thread.sleep(1000);
			WebElement read_notify = this.xpath_locator("//span[text()='Mark all as read']");
			read_notify.click();
			Thread.sleep(2000);
			String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
			String expected_data = "1 Notification(s) marked read successfully.";
			assertEquals(expected_data, actual_data);
			Thread.sleep(2000);
		}
		
		////----posting the question and accepting it notification---////
		@Test
		public void posting_question_accept_notification() throws InterruptedException {
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_test();
			Thread.sleep(2000);
			WebElement question_page = this.css_locator("link-to[lt-prop-route='index.questions']");
			question_page.click();
			String expected_link = "https://zask.localpali.io/zask/questions?sort=New&filter=All";
			assertEquals(expected_link,driver.getCurrentUrl());
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
			WebElement question_post = this.css_locator(".ask-question-container>zask-ui-button");
			question_post.click();
			Thread.sleep(1000);
			WebElement title1 = this.css_locator("#add-question-title");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", title1);
			title1.sendKeys("How to ask a good question?");
			Thread.sleep(1000);
			String val1 = "How to ask a good question?";
			assertEquals(val1, title1.getAttribute("value"));
			Thread.sleep(2000);
			WebElement ques1 = this.css_locator(".ql-editor");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", ques1);
			ques1.click();
			ques1.clear();
			ques1.sendKeys("To know more on how to ask a good question");
			WebElement ques2 = this.css_locator(".ql-editor>p");
			String val2 = "To know more on how to ask a good question";
			assertEquals(val2, ques2.getText());
			WebElement tags = this.css_locator("#input");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tags);
			tags.click();
			tags.sendKeys(Keys.BACK_SPACE);
			tags.sendKeys(Keys.BACK_SPACE);
			tags.sendKeys("test");
			Thread.sleep(1500);
			tags.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			String val3 = "test";
			WebElement tg1 = this.xpath_locator("//*[@id=\"outlet-zask-content-container\"]/zask-content-container/div[1]/zask-add-question/div/div[3]/zask-ui-tags-multi-selector/div/zask-ui-tag-closable[1]");
			assertEquals(val3, tg1.getAttribute("tagname"));
			Thread.sleep(1000);
			WebElement post_submit = this.css_locator("#add-question-submit");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			post_submit.click();
			Thread.sleep(2000);
			WebElement yes1 = this.css_locator("#modal-btn");
			String expected_data = ("Yes");
			assertEquals(expected_data, yes1.getText());
			Thread.sleep(1000);
			yes1.click();
			Thread.sleep(3000);
			String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
			expected_data = "Your post has been sent for review";
			assertEquals(expected_data, actual_data);
			Thread.sleep(2000);
		}
		
		////-------------accepting the in-review question------------////
		@Test
		public void accepting_the_question() throws InterruptedException {
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_admin();
			Thread.sleep(2000);
			WebElement notification_check = this.css_locator("span[lt-prop-title='Notifications']");
			notification_check.click();
			Thread.sleep(2000);
			boolean notify_count = this.xpath_locator("//*[@id=\"notification-count\"]").isDisplayed();
			Assert.assertTrue(notify_count);
			Thread.sleep(1000);
			String expected_value = "1";
			String notify_count_value = this.xpath_locator("//*[@id=\"notification-count\"]").getText();
			assertEquals(expected_value,notify_count_value);
			Thread.sleep(2000);
			boolean notify_found = driver.getPageSource().contains("You have a new question: How to ask a good question? waiting for review.");
			assertTrue(notify_found);
			Thread.sleep(2000);
			notification_check = this.xpath_locator("//p[text()='You have a new question: How to ask a good question? waiting for review.']");
			notification_check.click();
			Thread.sleep(1000);
			WebElement question_accept = this.xpath_locator("//*[@id=\"accept\"]");
			question_accept.click(); 
			Thread.sleep(1000);
			question_accept = this.xpath_locator("//zask-ui-button[text()='Accept']");
			question_accept.click();
			Thread.sleep(2000);
			notification_check = this.css_locator("link-to[lt-prop-route='index.questions']");
			notification_check.click();
			Thread.sleep(2000);
			boolean question_present = driver.getPageSource().contains("How to ask a good question?");
			assertTrue(question_present);
			Thread.sleep(2000);
		}
		
		////-------checking question accept notification shows-------////
		@Test
		public void checking_question_accept_notificatio() throws InterruptedException {
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_test();
			Thread.sleep(2000);
			WebElement notification_check = this.css_locator("span[lt-prop-title='Notifications']");
			notification_check.click();
			Thread.sleep(2000);
			boolean notify_count = this.xpath_locator("//*[@id=\"notification-count\"]").isDisplayed();
			Assert.assertTrue(notify_count);
			Thread.sleep(1000);
			String expected_value = "1";
			String notify_count_value = this.xpath_locator("//*[@id=\"notification-count\"]").getText();
			assertEquals(expected_value,notify_count_value);
			boolean notify_found = driver.getPageSource().contains("Your question: How to ask a good question? has been accepted.");
			assertTrue(notify_found);
			Thread.sleep(2000);
			WebElement read_notify = this.xpath_locator("//span[text()='Mark all as read']");
			read_notify.click();
			Thread.sleep(2000);
			String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
			String expected_data = "1 Notification(s) marked read successfully.";
			assertEquals(expected_data, actual_data);
			Thread.sleep(2000);
		}
		
		////---posting question with question notification disable---////
		@Test
		public void posting_question_with_disable_notification() throws InterruptedException {
			demo = this.notifications_settings();
			Thread.sleep(2000);
			boolean question_notification = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(1) > lyte-checkbox input").isSelected();
			assertTrue(question_notification);
			Thread.sleep(1000);
			WebElement disabling_question_notify = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(1) > lyte-checkbox label");
			disabling_question_notify.click();
			Thread.sleep(2000);
			WebElement question_page = this.css_locator("link-to[lt-prop-route='index.questions']");
			question_page.click();
			driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
			WebElement question_post = this.css_locator(".ask-question-container>zask-ui-button");
			question_post.click();
			Thread.sleep(1000);
			WebElement title1 = this.css_locator("#add-question-title");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", title1);
			title1.sendKeys("How to ask a good question?");
			Thread.sleep(1000);
			String val1 = "How to ask a good question?";
			assertEquals(val1, title1.getAttribute("value"));
			Thread.sleep(2000);
			WebElement ques1 = this.css_locator(".ql-editor");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", ques1);
			ques1.click();
			ques1.clear();
			ques1.sendKeys("How to ask a good question?");
			WebElement ques2 = this.css_locator(".ql-editor>p");
			String val2 = "How to ask a good question?";
			assertEquals(val2, ques2.getText());
			WebElement tags = this.css_locator("#input");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tags);
			tags.click();
			tags.sendKeys(Keys.BACK_SPACE);
			tags.sendKeys(Keys.BACK_SPACE);
			tags.sendKeys("test");
			Thread.sleep(1500);
			tags.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			String val3 = "test";
			WebElement tg1 = this.xpath_locator("//*[@id=\"outlet-zask-content-container\"]/zask-content-container/div[1]/zask-add-question/div/div[3]/zask-ui-tags-multi-selector/div/zask-ui-tag-closable[1]");
			assertEquals(val3, tg1.getAttribute("tagname"));
			Thread.sleep(1000);
			WebElement post_submit = this.css_locator("#add-question-submit");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			post_submit.click();
			Thread.sleep(2000);
			WebElement yes1 = this.css_locator("#modal-btn");
			String expected_data = ("Yes");
			assertEquals(expected_data, yes1.getText());
			Thread.sleep(1000);
			yes1.click();
			Thread.sleep(3000);
			String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
			expected_data = "Your post has been sent for review";
			assertEquals(expected_data, actual_data);
			Thread.sleep(2000);
		}
		
		////---------accepting question notification disable---------////
		@Test
		public  void checking_question_notification_disable() throws InterruptedException {
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_admin();
			Thread.sleep(2000);
			WebElement notification_check = this.css_locator("span[lt-prop-title='Notifications']");
			notification_check.click();
			Thread.sleep(2000);
			boolean notify_count = this.xpath_locator("//*[@id=\"notification-count\"]").isDisplayed();
			Assert.assertTrue(notify_count);
			Thread.sleep(1000);
			String expected_value = "1";
			String notify_count_value = this.xpath_locator("//*[@id=\"notification-count\"]").getText();
			assertEquals(expected_value,notify_count_value);
			boolean notify_found = driver.getPageSource().contains("You have a new question: How to ask a good question? waiting for review.");
			assertTrue(notify_found);
			Thread.sleep(2000);
			notification_check = this.xpath_locator("//p[text()='You have a new question: How to ask a good question? waiting for review.']");
			notification_check.click();
			Thread.sleep(1000);
			WebElement question_accept = this.xpath_locator("//*[@id=\"accept\"]");
			question_accept.click(); 
			Thread.sleep(1000);
			question_accept = this.xpath_locator("//zask-ui-button[text()='Accept']");
			question_accept.click();
			Thread.sleep(2000);
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_test();
			Thread.sleep(2000);
			notification_check = this.css_locator("span[lt-prop-title='Notifications']");
			notification_check.click();
			Thread.sleep(2000);
		}
		
		////--creating a article and posting the article for review--////
		@Test
		public void creating_article_posting() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_test();
			Thread.sleep(2000);
			WebElement article_page = this.css_locator("link-to[lt-prop-route='index.articles']");
			article_page.click();
			String expected_link = "https://zask.localpali.io/zask/articles?sort=New&filter=All";
			assertEquals(expected_link,driver.getCurrentUrl());
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
			WebElement question_post = this.css_locator(".ask-question-container>zask-ui-button");
			question_post.click();
			Thread.sleep(1000);
			WebElement title1 = this.css_locator("#add-question-title");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", title1);
			title1.sendKeys("How to ask a good question?");
			Thread.sleep(1000);
			String val1 = "How to ask a good question?";
			assertEquals(val1, title1.getAttribute("value"));
			Thread.sleep(2000);
			WebElement ques1 = this.css_locator(".ql-editor");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", ques1);
			ques1.click();
			ques1.sendKeys(Keys.CONTROL,"A");
			ques1.sendKeys(Keys.BACK_SPACE);
			ques1.sendKeys("How to ask a good question?");
			WebElement ques2 = this.css_locator(".ql-editor>p");
			String val2 = "How to ask a good question?";
			assertEquals(val2, ques2.getText());
			WebElement tags = this.css_locator("#outlet-zask-content-container div.add-tags > zask-ui-tags-multi-selector > div > div > input");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tags);
			tags.click();
			tags.clear();
			tags.sendKeys("test");
			Thread.sleep(1500);
			tags.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			WebElement post_submit = this.css_locator("#add-question-submit");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			post_submit.click();
			Thread.sleep(2000);
			WebElement yes1 = this.css_locator("#modal-btn");
			String expected_data = ("Yes");
			assertEquals(expected_data, yes1.getText());
			Thread.sleep(1000);
			yes1.click();
			Thread.sleep(3000);
			String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
			expected_data = "Your post has been sent for review";
			assertEquals(expected_data, actual_data);
			Thread.sleep(2000);
		}
		
		////----------checking article notifications appeared---------////
		@Test
		public void article_notifications() throws InterruptedException {
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_admin();
			Thread.sleep(2000);
			WebElement notification_check = this.css_locator("span[lt-prop-title='Notifications']");
			notification_check.click();
			Thread.sleep(2000);
			boolean notify_count = this.xpath_locator("//*[@id=\"notification-count\"]").isDisplayed();
			Assert.assertTrue(notify_count);
			Thread.sleep(1000);
			String expected_value = "1";
			String notify_count_value = this.xpath_locator("//*[@id=\"notification-count\"]").getText();
			assertEquals(expected_value,notify_count_value);
			boolean notify_found = driver.getPageSource().contains("You have a new question");
			assertTrue(notify_found);
			Thread.sleep(2000);
		}
		
		////-------------Accepting the article in review-------------////
		@Test
		public void accepting_the_article() throws InterruptedException {
			boolean notify_found = driver.getPageSource().contains("You have a new article: How to ask a good question? waiting for review.");
			assertTrue(notify_found);
			Thread.sleep(2000);
			WebElement notification_check = this.xpath_locator("//p[text()='You have a new article: How to ask a good question? waiting for review.']");
			notification_check.click();
			Thread.sleep(1000);
			WebElement question_accept = this.xpath_locator("//*[@id=\"accept\"]");
			question_accept.click(); 
			Thread.sleep(2000);
			notification_check = this.css_locator("link-to[lt-prop-route='index.articles']");
			notification_check.click();
			Thread.sleep(2000);
			boolean question_present = driver.getPageSource().contains("How to ask a good question?");
			assertTrue(question_present);
			Thread.sleep(2000);
		}
		
		////-------article Accept notification present in test-------////
		@Test
		public void accept_notification_present_check() throws InterruptedException {
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_test();
			Thread.sleep(2000);
			WebElement notification_check = this.css_locator("span[lt-prop-title='Notifications']");
			notification_check.click();
			Thread.sleep(2000);
			boolean notify_count = this.xpath_locator("//*[@id=\"notification-count\"]").isDisplayed();
			Assert.assertTrue(notify_count);
			Thread.sleep(1000);
			String expected_value = "1";
			String notify_count_value = this.xpath_locator("//*[@id=\"notification-count\"]").getText();
			assertEquals(expected_value,notify_count_value);
			boolean notify_found = driver.getPageSource().contains("Your article: How to ask a good question? has been accepted.");
			assertTrue(notify_found);
			Thread.sleep(1000);
			WebElement read_notify = this.xpath_locator("//span[text()='Mark all as read']");
			read_notify.click();
			Thread.sleep(2000);
			String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
			String expected_data = "1 Notification(s) marked read successfully.";
			assertEquals(expected_data, actual_data);
			Thread.sleep(2000);
		}
		
		////-------Turning off the article review notifications check------////
		@Test
		public void article_notifications_disable() throws InterruptedException {
			demo = this.notifications_settings();
			Thread.sleep(1000);
			boolean question_notification = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(5) > lyte-checkbox input").isSelected();
			assertTrue(question_notification);
			Thread.sleep(1000);
			WebElement disabling_question_notify = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(5) > lyte-checkbox label");
			disabling_question_notify.click();
			Thread.sleep(1000);
			String expected_data = "Notification profile has been updated.";
			String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
			assertEquals(expected_data, actual_data);
			boolean question_notification1 = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(5) > lyte-checkbox input").isSelected();
			assertFalse(question_notification1);
			Thread.sleep(1000);
		}
			
		////creating a article and posting the same article with notification disable////
		@Test
		public void same_article_notification_disable() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_test();
			Thread.sleep(2000);
			WebElement article_page = this.css_locator("link-to[lt-prop-route='index.articles']");
			article_page.click();
			String expected_link = "https://zask.localpali.io/zask/articles?sort=New&filter=All";
			assertEquals(expected_link,driver.getCurrentUrl());
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
			WebElement question_post = this.css_locator(".ask-question-container>zask-ui-button");
			question_post.click();
			Thread.sleep(1000);
			WebElement title1 = this.css_locator("#add-question-title");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", title1);
			title1.sendKeys("How to ask a good question?");
			Thread.sleep(1000);
			String val1 = "How to ask a good question?";
			assertEquals(val1, title1.getAttribute("value"));
			Thread.sleep(2000);
			WebElement ques1 = this.css_locator(".ql-editor");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", ques1);
			ques1.click();
			ques1.sendKeys(Keys.CONTROL,"A");
			ques1.sendKeys(Keys.BACK_SPACE);
			ques1.sendKeys("How to ask a good question?");
			WebElement ques2 = this.css_locator(".ql-editor>p");
			String val2 = "How to ask a good question?";
			assertEquals(val2, ques2.getText());
			WebElement tags = this.css_locator("#outlet-zask-content-container div.add-tags > zask-ui-tags-multi-selector > div > div > input");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tags);
			tags.click();
			tags.sendKeys(Keys.BACK_SPACE);
			tags.sendKeys(Keys.BACK_SPACE);
			tags.sendKeys("test");
			Thread.sleep(1500);
			tags.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			WebElement post_submit = this.css_locator("#add-question-submit");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			post_submit.click();
			Thread.sleep(2000);
			WebElement yes1 = this.css_locator("#modal-btn");
			String expected_data = ("Yes");
			assertEquals(expected_data, yes1.getText());
			Thread.sleep(1000);
			yes1.click();
			Thread.sleep(3000);
			String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
			expected_data = "Your post has been sent for review";
			assertEquals(expected_data, actual_data);
			Thread.sleep(2000);
		}
		
		////---Checking the articles notifications has not appeared---////
		@Test
		public void article_notifications_notFound() throws InterruptedException {
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_admin();
			Thread.sleep(2000);
			WebElement notification_check = this.css_locator("span[lt-prop-title='Notifications']");
			notification_check.click();
			Thread.sleep(2000);
		}
		
		////------------like in questions of test account------------////
		@Test
		public void performing_liking_questions_test() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_admin();
			Thread.sleep(2000);
			WebElement test_question = this.css_locator("a[href='/zask/questions/8239830252']");
			test_question.click();
			String question_link = "https://zask.localpali.io/zask/questions/8239830252";
			assertEquals(question_link,driver.getCurrentUrl());
			Thread.sleep(1000);
			WebElement like_button = this.css_locator("#vote-8239830252 > div.up.info-ico.icon.like.vote");
			like_button.click();
			Thread.sleep(1000);
		}
		
		////----------checking like notification in question---------////
		@Test
		public void like_notification_check() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_test();
			Thread.sleep(2000);
			WebElement notification_check = this.css_locator("span[lt-prop-title='Notifications']");
			notification_check.click();
			Thread.sleep(1000);
			boolean notify_count = this.xpath_locator("//*[@id=\"notification-count\"]").isDisplayed();
			Assert.assertTrue(notify_count);
			Thread.sleep(1000);
			String expected_value = "1";
			String notify_count_value = this.xpath_locator("//*[@id=\"notification-count\"]").getText();
			assertEquals(expected_value,notify_count_value);
			boolean notify_found = driver.getPageSource().contains("You have earned 10 reputation for your question");
			boolean notify_found1 = driver.getPageSource().contains("You have lost 10 reputation for your question");
				if(notify_found || notify_found1) {
					assertTrue(notify_found);
				}
				else {
					assertTrue(notify_found1);
				}
			Thread.sleep(1000);
			WebElement read_notify = this.xpath_locator("//span[text()='Mark all as read']");
			read_notify.click();
			Thread.sleep(2000);
			String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
			String expected_data = "1 Notification(s) marked read successfully.";
			assertEquals(expected_data, actual_data);
			Thread.sleep(2000);
		}
		
		////----------disabling question notification(like)----------////
		@Test
		public void disable_question_notification_vote() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.notifications_settings();
			WebElement disabling_question_notify = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(6) > lyte-checkbox label");
			disabling_question_notify.click();
			Thread.sleep(1000);
			boolean question_notification = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(6) > lyte-checkbox input").isSelected();
			assertFalse(question_notification);
			Thread.sleep(1000);
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_admin();
			Thread.sleep(2000);
			WebElement test_question = this.css_locator("a[href='/zask/questions/8239830252']");
			test_question.click();
			String question_link = "https://zask.localpali.io/zask/questions/8239830252";
			assertEquals(question_link,driver.getCurrentUrl());
			Thread.sleep(1000);
			WebElement like_button = this.css_locator("#vote-8239830252 > div.up.info-ico.icon.like.vote");
			like_button.click();
			Thread.sleep(1000);
		}
		
		////-------------checking disable notifications--------------////
		@Test
		public void question_notifications_check() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(1000);
			demo = this.login_account_test();
			Thread.sleep(1000);
			WebElement notification_check = this.css_locator("span[lt-prop-title='Notifications']");
			notification_check.click();
			Thread.sleep(1000);
		}
		
		////------------------answering a question------------------////
		@Test
		public void answering_a_question() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(1000);
			demo = this.login_account_admin();
			Thread.sleep(2000);
			WebElement test_question = this.css_locator("a[href='/zask/questions/8239830252']");
			test_question.click();
			String question_link = "https://zask.localpali.io/zask/questions/8239830252";
			assertEquals(question_link,driver.getCurrentUrl());
			Thread.sleep(2000);
			WebElement answer_tab = this.css_locator("#editor-outlet > div.ql-editor");
			answer_tab.click();
			answer_tab.clear();
			answer_tab.sendKeys("Do you have an answer?");
			String expected_text = "Do you have an answer?";
			String actual_text = this.css_locator("#editor-outlet > div.ql-editor > p").getText();
			assertEquals(expected_text,actual_text);
			Thread.sleep(1000);
			WebElement answer_post = this.xpath_locator("//*[@id=\"add-answer-submit\"]");
			answer_post.click();
			Thread.sleep(2000);
			expected_text = "Your answer has been posted.";
			actual_text = this.css_locator(".lyteMessageBoxContent").getText();
			assertEquals(expected_text,actual_text);
			Thread.sleep(2000);
		}
		
		////-------answering the question notification check--------////
		@Test
		public void answering_question_notification_check() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(1000);
			demo = this.login_account_test();
			Thread.sleep(2000);
			WebElement notification_check = this.css_locator("span[lt-prop-title='Notifications']");
			notification_check.click();
			Thread.sleep(2000);
			boolean notify_count = this.xpath_locator("//*[@id=\"notification-count\"]").isDisplayed();
			Assert.assertTrue(notify_count);
			Thread.sleep(1000);
			String expected_value = "1";
			String notify_count_value = this.xpath_locator("//*[@id=\"notification-count\"]").getText();
			assertEquals(expected_value,notify_count_value);
			boolean notify_found = driver.getPageSource().contains("esakkivash.n has answered your question: How to ask a good question?");
			assertTrue(notify_found);
			Thread.sleep(1000);
			WebElement read_notify = this.xpath_locator("//span[text()='Mark all as read']");
			read_notify.click();
			Thread.sleep(2000);
			String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
			String expected_data = "1 Notification(s) marked read successfully.";
			assertEquals(expected_data, actual_data);
			Thread.sleep(2000);
		}
		
		////-------disabling answer notification in questions-------////
		@Test
		public void disabling_answer_notification_question() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.notifications_settings();
			WebElement disabling_question_notify = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(3) > lyte-checkbox label");
			disabling_question_notify.click();
			Thread.sleep(1000);
			boolean question_notification = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(3) > lyte-checkbox input").isSelected();
			assertFalse(question_notification);
			Thread.sleep(1000);
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_admin();
			Thread.sleep(2000);
			WebElement test_question = this.css_locator("a[href='/zask/questions/8239830252']");
			test_question.click();
			String question_link = "https://zask.localpali.io/zask/questions/8239830252";
			assertEquals(question_link,driver.getCurrentUrl());
			Thread.sleep(2000);
			WebElement answer_tab = this.css_locator("#editor-outlet > div.ql-editor");
			answer_tab.click();
			answer_tab.clear();
			answer_tab.sendKeys("Do you have an answer?");
			String expected_text = "Do you have an answer?";
			String actual_text = this.css_locator("#editor-outlet > div.ql-editor > p").getText();
			assertEquals(expected_text,actual_text);
			Thread.sleep(1000);
			WebElement answer_post = this.xpath_locator("//*[@id=\"add-answer-submit\"]");
			answer_post.click();
			Thread.sleep(2000);
			expected_text = "Your answer has been posted.";
			actual_text = this.css_locator(".lyteMessageBoxContent").getText();
			assertEquals(expected_text,actual_text);
			Thread.sleep(2000);
		}
		
		////-----------disabled answer notification check-----------////
		@Test
		public void disable_answer_notification_check() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(1000);
			demo = this.login_account_test();
			Thread.sleep(1000);
			WebElement notification_check = this.css_locator("span[lt-prop-title='Notifications']");
			notification_check.click();
			Thread.sleep(2000);
		}
		
		////-------------adding a comment on a question-------------////
		@Test
		public void adding_comment_question() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(1000);
			demo = this.login_account_admin();
			Thread.sleep(2000);
			WebElement test_question = this.css_locator("a[href='/zask/questions/8239830252']");
			test_question.click();
			String question_link = "https://zask.localpali.io/zask/questions/8239830252";
			assertEquals(question_link,driver.getCurrentUrl());
			Thread.sleep(2000);
			WebElement comment_add = this.css_locator("#\\38 239830252 > div.question-detail > div.comments-container > div > span");
			comment_add.click();
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			boolean comment_area = this.xpath_locator("//*[@id=\"comment-box-8239830252\"]").isDisplayed();
			assertTrue(comment_area);
			WebElement text_add = this.css_locator("#comment-box-8239830252 > div.container > textarea");
			text_add.click();
			text_add.clear();
			text_add.sendKeys("test comment");
			Thread.sleep(1000);
			text_add = this.css_locator("#comment-box-8239830252 > div.container > div");
			text_add.click();
			Thread.sleep(3000);
			String actual_text = this.css_locator(".lyteMessageBoxContent").getText();
			String expected_text = "Your comment has been posted.";
			assertEquals(actual_text,expected_text);
		}
		
		////----------comment notification check(question)----------////
		@Test
		public void comment_notification_question() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(1000);
			demo = this.login_account_test();
			Thread.sleep(1000);
			WebElement notification_check = this.css_locator("span[lt-prop-title='Notifications']");
			notification_check.click();
			Thread.sleep(2000);
			boolean notify_count = this.xpath_locator("//*[@id=\"notification-count\"]").isDisplayed();
			Assert.assertTrue(notify_count);
			Thread.sleep(1000);
			String expected_value = "1";
			String notify_count_value = this.xpath_locator("//*[@id=\"notification-count\"]").getText();
			assertEquals(expected_value,notify_count_value);
			boolean notify_found = driver.getPageSource().contains("esakkivash.n has commented on your question: How to ask a good question?");
			assertTrue(notify_found);
			Thread.sleep(1000);
			WebElement read_notify = this.xpath_locator("//span[text()='Mark all as read']");
			read_notify.click();
			Thread.sleep(2000);
			String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
			String expected_data = "1 Notification(s) marked read successfully.";
			assertEquals(expected_data, actual_data);
			Thread.sleep(2000);
		}
		
		////--------disabling comment notification(question)--------////
		@Test
		public void disable_comment_notification_question() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.notifications_settings();
			WebElement disabling_question_notify = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(4) > lyte-checkbox label");
			disabling_question_notify.click();
			Thread.sleep(1000);
			boolean question_notification = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(4) > lyte-checkbox input").isSelected();
			assertFalse(question_notification);
			Thread.sleep(1000);
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_admin();
			Thread.sleep(2000);
			WebElement test_question = this.css_locator("a[href='/zask/questions/8239830252']");
			test_question.click();
			String question_link = "https://zask.localpali.io/zask/questions/8239830252";
			assertEquals(question_link,driver.getCurrentUrl());
			Thread.sleep(2000);
			WebElement comment_add = this.css_locator("#\\38 239830252 > div.question-detail > div.comments-container > div > span");
			comment_add.click();
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			boolean comment_area = this.xpath_locator("//*[@id=\"comment-box-8239830252\"]").isDisplayed();
			assertTrue(comment_area);
			WebElement text_add = this.css_locator("#comment-box-8239830252 > div.container > textarea");
			text_add.click();
			text_add.clear();
			text_add.sendKeys("test comment");
			Thread.sleep(1000);
			text_add = this.css_locator("#comment-box-8239830252 > div.container > div");
			text_add.click();
			Thread.sleep(3000);
			String actual_text = this.css_locator(".lyteMessageBoxContent").getText();
			String expected_text = "Your comment has been posted.";
			assertEquals(actual_text,expected_text);
			Thread.sleep(1000);
		}
		
		////------disabled notifications question comment check-----////
		@Test
		public void question_comment_disable_notification_check() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(1000);
			demo = this.login_account_test();
			Thread.sleep(1000);
			WebElement notification_check = this.css_locator("span[lt-prop-title='Notifications']");
			notification_check.click();
			Thread.sleep(2000);
		}
		
		////-----------------Disliking the question-----------------////
		@Test
		public void disliking_the_question() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(1000);
			demo = this.login_account_admin();
			Thread.sleep(2000);
			WebElement test_question = this.css_locator("a[href='/zask/questions/8239830252']");
			test_question.click();
			String question_link = "https://zask.localpali.io/zask/questions/8239830252";
			assertEquals(question_link,driver.getCurrentUrl());
			Thread.sleep(2000);
			WebElement dislike_btn = this.css_locator("#vote-8239830252 > div.down.info-ico.icon.dislike.vote");
			dislike_btn.click();
			Thread.sleep(2500);
			String vote_value = this.css_locator("#vote-8239830252 > span").getText();
			String vote_count2 = "0";
			String vote_count3 = "-1";
				if(vote_value != null) {
					assertEquals(vote_count3,vote_value);
				}
				else {
					assertEquals(vote_count2,vote_value);
				}
			Thread.sleep(2000);
		}
		 
		////----------disliking notification present check----------////
		@Test
		public void disliking_question_notification_check() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(1000);
			demo = this.login_account_test();
			Thread.sleep(1000);
			WebElement notification_check = this.css_locator("span[lt-prop-title='Notifications']");
			notification_check.click();
			Thread.sleep(2000);
			boolean notify_count = this.xpath_locator("//*[@id=\"notification-count\"]").isDisplayed();
			Assert.assertTrue(notify_count);
			Thread.sleep(1000);
			String expected_value = "1";
			String notify_count_value = this.xpath_locator("//*[@id=\"notification-count\"]").getText();
			assertEquals(expected_value,notify_count_value);
			boolean notify_found = driver.getPageSource().contains("You have lost -5 reputation for your question: How to ask a good question?");
			assertTrue(notify_found);
			Thread.sleep(1000);
			WebElement read_notify = this.xpath_locator("//span[text()='Mark all as read']");
			read_notify.click();
			Thread.sleep(2000);
			String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
			String expected_data = "1 Notification(s) marked read successfully.";
			assertEquals(expected_data, actual_data);
			Thread.sleep(2000);
		}
		
		////-----------disabling question vote notification---------////
		@Test
		public void disabling_question_vote_notification() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.notifications_settings();
			WebElement disabling_question_notify = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(6) > lyte-checkbox label");
			disabling_question_notify.click();
			Thread.sleep(1000);
			boolean question_notification = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(6) > lyte-checkbox input").isSelected();
			assertFalse(question_notification);
			Thread.sleep(1000);
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_admin();
			Thread.sleep(2000);
			WebElement test_question = this.css_locator("a[href='/zask/questions/8239830252']");
			test_question.click();
			String question_link = "https://zask.localpali.io/zask/questions/8239830252";
			assertEquals(question_link,driver.getCurrentUrl());
			Thread.sleep(2000);
			WebElement dislike_btn = this.css_locator("#vote-8239830252 > div.down.info-ico.icon.dislike.vote");
			dislike_btn.click();
			Thread.sleep(2500);
			String vote_value = this.css_locator("#vote-8239830252 > span").getText();
			String vote_count2 = "0";
			String vote_count3 = "-1";
				if(vote_value != null) {
					assertEquals(vote_count2,vote_value);
				}
				else {
					assertEquals(vote_count3,vote_value);
				}
			Thread.sleep(2000);
		}
		
		////--------------disable question vote(unlike)--------------////
		@Test
		public void disable_question_notification_unlikevote() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(1000);
			demo = this.login_account_test();
			Thread.sleep(1000);
			WebElement notification_check = this.css_locator("span[lt-prop-title='Notifications']");
			notification_check.click();
			Thread.sleep(2000);
			String notification_list = this.css_locator("#notificationsBody > zask-ui-notification-body:nth-child(1) > div").getCssValue("background");
			String notification_color = "rgb(255, 255, 255)";
			assertNotEquals(notification_list,notification_color);
		}
		
		////------------------liking the article--------------------////
		@Test
		public void liking_the_article() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(1000);
			demo = this.login_account_admin();
			Thread.sleep(1000);
			WebElement article_link = this.css_locator("link-to[lt-prop-route='index.articles']");
			article_link.click();
			Thread.sleep(2000);
			WebElement article_new = this.css_locator("a[href='/zask/articles/6106029327']");
			article_new.click();
			Thread.sleep(1000);
			String expected_link = "https://zask.localpali.io/zask/articles/6106029327";
			assertEquals(expected_link,driver.getCurrentUrl());
			Thread.sleep(1000);
			WebElement like_article = this.css_locator("#vote-6106029327 > div.up.info-ico.icon.like.vote");
			like_article.click();
			Thread.sleep(2000);
			String vote_count = "1";
			String count_list = this.css_locator("#vote-6106029327 > span").getText();
			assertEquals(vote_count,count_list);
			Thread.sleep(2000);
		}
		
		////-------------vote notification article check-------------////
		@Test
		public void article_vote_notification() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_test();
			Thread.sleep(2000);
			WebElement notification_check = this.css_locator("span[lt-prop-title='Notifications']");
			notification_check.click();
			Thread.sleep(2000);
			boolean notify_count = this.xpath_locator("//*[@id=\"notification-count\"]").isDisplayed();
			Assert.assertTrue(notify_count);
			Thread.sleep(1000);
			String expected_value = "1";
			String notify_count_value = this.xpath_locator("//*[@id=\"notification-count\"]").getText();
			assertEquals(expected_value,notify_count_value);
			boolean notify_found = driver.getPageSource().contains("You have earned 10 reputation for your article: What does a good article look like?");
			boolean notify_found1 = driver.getPageSource().contains("You have earned 15 reputation for your article: What does a good article look like?");
				if(notify_found) {
					assertTrue(notify_found);
				}
				else {
					assertTrue(notify_found1);
				}
			
			Thread.sleep(1000);
			WebElement read_notify = this.xpath_locator("//span[text()='Mark all as read']");
			read_notify.click();
			Thread.sleep(2000);
			String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
			String expected_data = "1 Notification(s) marked read successfully.";
			assertEquals(expected_data, actual_data);
			Thread.sleep(2000);
		}
		
		////------------------unliking the article--------------------////
		@Test
		public void unliking_the_article() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(1000);
			demo = this.login_account_admin();
			Thread.sleep(1000);
			WebElement article_link = this.css_locator("link-to[lt-prop-route='index.articles']");
			article_link.click();
			Thread.sleep(2000);
			WebElement article_new = this.css_locator("a[href='/zask/articles/6106029327']");
			article_new.click();
			Thread.sleep(1000);
			String expected_link = "https://zask.localpali.io/zask/articles/6106029327";
			assertEquals(expected_link,driver.getCurrentUrl());
			Thread.sleep(1000);
			WebElement unlike_article = this.css_locator("#vote-6106029327 > div.down.info-ico.icon.dislike.vote");
			unlike_article.click();
			Thread.sleep(2000);
			String vote_count = "-1";
			String count_list = this.css_locator("#vote-6106029327 > span").getText();
			assertEquals(vote_count,count_list);
			Thread.sleep(2000);
		}
		
		////------------unlike_notification_check article------------////
		@Test
		public void unlike_notification_article_check() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_test();
			Thread.sleep(2000);
			WebElement notification_check = this.css_locator("span[lt-prop-title='Notifications']");
			notification_check.click();
			Thread.sleep(2000);
			boolean notify_count = this.xpath_locator("//*[@id=\"notification-count\"]").isDisplayed();
			Assert.assertTrue(notify_count);
			Thread.sleep(1000);
			String expected_value = "1";
			String notify_count_value = this.xpath_locator("//*[@id=\"notification-count\"]").getText();
			assertEquals(expected_value,notify_count_value);
			boolean notify_found1 = driver.getPageSource().contains("You have lost -15 reputation for your article: What does a good article look like?");
			assertTrue(notify_found1);
			Thread.sleep(1000);
			WebElement read_notify = this.xpath_locator("//span[text()='Mark all as read']");
			read_notify.click();
			Thread.sleep(2000);
			String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
			String expected_data = "1 Notification(s) marked read successfully.";
			assertEquals(expected_data, actual_data);
			Thread.sleep(2000);
		}
		
		////------------disabling notification article vote----------////
		@Test
		public void disabling_article_vote() throws InterruptedException {
			demo = this.notifications_settings();
			Thread.sleep(1000);
			boolean article_notification = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(6) > lyte-checkbox input").isSelected();
			assertTrue(article_notification);
			Thread.sleep(1000);
			WebElement disabling_article_notify = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(6) > lyte-checkbox label");
			disabling_article_notify.click();
			Thread.sleep(2000);
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_admin();
			Thread.sleep(2000);
			WebElement article_link = this.css_locator("link-to[lt-prop-route='index.articles']");
			article_link.click();
			Thread.sleep(2000);
			WebElement article_new = this.css_locator("a[href='/zask/articles/6106029327']");
			article_new.click();
			Thread.sleep(1000);
			String expected_link = "https://zask.localpali.io/zask/articles/6106029327";
			assertEquals(expected_link,driver.getCurrentUrl());
			Thread.sleep(1000);
			WebElement like_article = this.css_locator("#vote-6106029327 > div.up.info-ico.icon.like.vote");
			like_article.click();
			Thread.sleep(1000);
			String vote_count = "1";
			String count_list = this.css_locator("#vote-6106029327 > span").getText();
			assertEquals(vote_count,count_list);
			Thread.sleep(2000);
		}
		
		////------------disable notification article vote------------////
		@Test
		public void disable_vote_article_check() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_test();
			Thread.sleep(2000);
			WebElement notification_check = this.css_locator("span[lt-prop-title='Notifications']");
			notification_check.click();
			Thread.sleep(2000);
			String notification_list = this.css_locator("#notificationsBody > zask-ui-notification-body:nth-child(1) > div").getCssValue("background");
			String notification_color = "rgb(255, 255, 255)";
			assertNotEquals(notification_list,notification_color);
		}
		
		////--------------disable unlike vote article------------------////
		@Test
		public void disable_unlike_article_check() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(1000);
			demo = this.login_account_admin();
			Thread.sleep(1000);
			WebElement article_link = this.css_locator("link-to[lt-prop-route='index.articles']");
			article_link.click();
			Thread.sleep(2000);
			WebElement article_new = this.css_locator("a[href='/zask/articles/6106029327']");
			article_new.click();
			Thread.sleep(1000);
			String expected_link = "https://zask.localpali.io/zask/articles/6106029327";
			assertEquals(expected_link,driver.getCurrentUrl());
			Thread.sleep(1000);
			WebElement unlike_article = this.css_locator("#vote-6106029327 > div.down.info-ico.icon.dislike.vote");
			unlike_article.click();
			Thread.sleep(2000);
			String vote_count = "-1";
			String count_list = this.css_locator("#vote-6106029327 > span").getText();
			assertEquals(vote_count,count_list);
			Thread.sleep(2000);
		}
		
		////----------disabled unlike vote notification check---------////
		@Test
		public void disabled_article_dislike_notification_check() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_test();
			Thread.sleep(2000);
			WebElement notification_check = this.css_locator("span[lt-prop-title='Notifications']");
			notification_check.click();
			Thread.sleep(2000);
			String notification_list = this.css_locator("#notificationsBody > zask-ui-notification-body:nth-child(1) > div").getCssValue("background");
			String notification_color = "rgb(255, 255, 255)";
			assertNotEquals(notification_list,notification_color);
		}
		
		////------------giving favourite list to the article-----------////
		@Test
		public void giving_favourite_list_article() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(1000);
			demo = this.login_account_admin();
			Thread.sleep(1000);
			WebElement article_link = this.css_locator("link-to[lt-prop-route='index.articles']");
			article_link.click();
			Thread.sleep(2000);
			WebElement article_new = this.css_locator("a[href='/zask/articles/6106029327']");
			article_new.click();
			Thread.sleep(1000);
			String expected_link = "https://zask.localpali.io/zask/articles/6106029327";
			assertEquals(expected_link,driver.getCurrentUrl());
			Thread.sleep(1000);
			WebElement favour_list = this.css_locator("div[lt-prop-title='Favourite']");
			favour_list.click();
			Thread.sleep(2000);
			String actual_value = this.css_locator("#vote-6106029327 > div.fav > span").getText();
			String expected_value = "1";
			assertEquals(actual_value,expected_value);
			Thread.sleep(1000);
		}
		
		////-----------article favourite notification check------------////
		@Test
		public void article_favourite_notification_check() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_test();
			Thread.sleep(2000);
			WebElement notification_check = this.css_locator("span[lt-prop-title='Notifications']");
			notification_check.click();
			Thread.sleep(2000);
			boolean notify_count = this.xpath_locator("//*[@id=\"notification-count\"]").isDisplayed();
			Assert.assertTrue(notify_count);
			Thread.sleep(1000);
			String expected_value = "2";
			String notify_count_value = this.xpath_locator("//*[@id=\"notification-count\"]").getText();
			assertEquals(expected_value,notify_count_value);
			boolean notify_found1 = driver.getPageSource().contains("Your article: What does a good article look like? has been marked favourite by esakkivash.n.");
			assertTrue(notify_found1);
			Thread.sleep(1000);
			WebElement read_notify = this.xpath_locator("//span[text()='Mark all as read']");
			read_notify.click();
			Thread.sleep(2000);
			String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
			String expected_data = "2 Notification(s) marked read successfully.";
			assertEquals(expected_data, actual_data);
			Thread.sleep(2000);
		}
		
		////-------disabling favourite notification in article--------////
		@Test
		public void disabling_favouite_article_notification() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.notifications_settings();
			Thread.sleep(2000);
			boolean question_notification = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(2) > lyte-checkbox input").isSelected();
			assertTrue(question_notification);
			Thread.sleep(1000);
			WebElement disabling_question_notify = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(2) > lyte-checkbox label");
			disabling_question_notify.click();
			Thread.sleep(2000);
			disabling_question_notify = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(6) > lyte-checkbox label");
			disabling_question_notify.click();
			demo = this.logout_account();
			Thread.sleep(1000);
			demo = this.login_account_admin();
			Thread.sleep(1000);
			WebElement article_link = this.css_locator("link-to[lt-prop-route='index.articles']");
			article_link.click();
			Thread.sleep(2000);
			WebElement article_new = this.css_locator("a[href='/zask/articles/5894964703']");
			article_new.click();
			Thread.sleep(1000);
			String expected_link = "https://zask.localpali.io/zask/articles/5894964703";
			assertEquals(expected_link,driver.getCurrentUrl());
			Thread.sleep(1000);
			WebElement favour_list = this.css_locator("div[lt-prop-title='Favourite']");
			favour_list.click();
			Thread.sleep(2000);
			String actual_value = this.css_locator("#vote-5894964703 > div.fav > span").getText();
			String expected_value = "1";
			assertEquals(actual_value,expected_value);
			Thread.sleep(1000);
		}
		
		////---------disabled article favourite notification----------////
		@Test
		public void disabled_article_favourite_notification_check() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_test();
			Thread.sleep(2000);
			WebElement notification_check = this.css_locator("span[lt-prop-title='Notifications']");
			notification_check.click();
			Thread.sleep(2000);
			boolean notify_count = this.xpath_locator("//*[@id=\"notification-count\"]").isDisplayed();
			Assert.assertTrue(notify_count);
			Thread.sleep(1000);
			String expected_value = "1";
			String notify_count_value = this.xpath_locator("//*[@id=\"notification-count\"]").getText();
			assertEquals(expected_value,notify_count_value);
			boolean notify_found1 = driver.getPageSource().contains("Your article: What does a good article look like? has been marked favourite by esakkivash.n.");
			assertTrue(notify_found1);
			Thread.sleep(1000);
			WebElement read_notify = this.xpath_locator("//span[text()='Mark all as read']");
			read_notify.click();
			Thread.sleep(2000);
			String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
			String expected_data = "1 Notification(s) marked read successfully.";
			assertEquals(expected_data, actual_data);
			Thread.sleep(2000);
		}
		
		////--------putting anyone of the flag to the article---------////
		@Test
		public void  flagging_a_article() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(1000);
			demo = this.login_account_admin();
			Thread.sleep(1000);
			WebElement article_link = this.css_locator("link-to[lt-prop-route='index.articles']");
			article_link.click();
			Thread.sleep(2000);
			WebElement article_new = this.css_locator("a[href='/zask/articles/5894964703']");
			article_new.click();
			Thread.sleep(1000);
			String expected_link = "https://zask.localpali.io/zask/articles/5894964703";
			assertEquals(expected_link,driver.getCurrentUrl());
			Thread.sleep(1000);
			driver.navigate().refresh();
			Thread.sleep(3000);
			WebElement flag_icon = this.css_locator("#flag-5894964703");
			flag_icon.click();
			String flag_type = "Very low quality";
			WebElement flag_type1 = this.css_locator(".flag-r:nth-child(3)");
			assertEquals(flag_type,flag_type1.getText());
			flag_type1.click();
			Thread.sleep(4000);	
			boolean flag = driver.getPageSource().contains("Flagged!");
			assertTrue(flag);
			Thread.sleep(2000);
		}
		
		////-------------article flagged notification check-----------////
		@Test
		public void article_flagged_notification_check() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_test();
			Thread.sleep(2000);
			WebElement notification_check = this.css_locator("span[lt-prop-title='Notifications']");
			notification_check.click();
			Thread.sleep(2000);
			boolean notify_count = this.xpath_locator("//*[@id=\"notification-count\"]").isDisplayed();
			Assert.assertTrue(notify_count);
			Thread.sleep(1000);
			String expected_value = "1";
			String notify_count_value = this.xpath_locator("//*[@id=\"notification-count\"]").getText();
			assertEquals(expected_value,notify_count_value);
			boolean notify_found1 = driver.getPageSource().contains("Your article: What does a good article look like? has been flagged and removed.");
			assertTrue(notify_found1);
			Thread.sleep(1000);
			WebElement read_notify = this.xpath_locator("//span[text()='Mark all as read']");
			read_notify.click();
			Thread.sleep(2000);
			String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
			String expected_data = "1 Notification(s) marked read successfully.";
			assertEquals(expected_data, actual_data);
			Thread.sleep(2000);
		}
		
		////----------------disabling article flag--------------------////
		public void disabling_article_flag_notification() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.notifications_settings();
			boolean question_notification = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(2) > lyte-checkbox input").isSelected();
			assertTrue(question_notification);
			Thread.sleep(1000);
			WebElement disabling_question_notify = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(2) > lyte-checkbox label");
			disabling_question_notify.click();
			disabling_question_notify = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(6) > lyte-checkbox label");
			disabling_question_notify.click();
			Thread.sleep(2000);
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_admin();
			Thread.sleep(1000);
			WebElement article_link = this.css_locator("link-to[lt-prop-route='index.articles']");
			article_link.click();
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			WebElement test_question = this.css_locator("a[href='/zask/articles/5894964703']");
			test_question.click();
			String question_link = "https://zask.localpali.io/zask/articles/5894964703";
			assertEquals(question_link,driver.getCurrentUrl());
			Thread.sleep(1000);
			WebElement portal_move = this.css_locator(".overflowMenu");
			portal_move.click();
			Thread.sleep(1000);
			WebElement option_view = this.xpath_locator("//div[text()='Move to portal']");
			option_view.click();
			Thread.sleep(2000);
			WebElement accept_portal = this.xpath_locator("//*[@id=\"modal-btn\"]");
			accept_portal.click();
			Thread.sleep(2000);
			WebElement flag_icon = this.css_locator("#flag-5894964703");
			flag_icon.click();
			Thread.sleep(1000);
			String flag_type = "Very low quality";
			WebElement flag_type1 = this.css_locator(".flag-r:nth-child(3)");
			assertEquals(flag_type,flag_type1.getText());
			flag_type1.click();
			Thread.sleep(4000);	
			boolean flag = driver.getPageSource().contains("Flagged!");
			assertTrue(flag);
			Thread.sleep(2000);
		}
		
		////------------flag disabling notification check------------////
		@Test
		public void flag_disabling_notification_article() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_test();
			Thread.sleep(2000);
			WebElement notification_check = this.css_locator("span[lt-prop-title='Notifications']");
			notification_check.click();
			Thread.sleep(2000);
			String notification_list = this.css_locator("#notificationsBody > zask-ui-notification-body:nth-child(1) > div").getCssValue("background");
			String notification_color = "rgb(255, 255, 255)";
			assertNotEquals(notification_list,notification_color);
		}
		
		////---------------adding comment to the article--------------////
		@Test
		public void adding_comment_article() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(1000);
			demo = this.login_account_admin();
			Thread.sleep(1000);
			WebElement article_link = this.css_locator("link-to[lt-prop-route='index.articles']");
			article_link.click();
			Thread.sleep(2000);
			WebElement article_new = this.css_locator("a[href='/zask/articles/5894964703']");
			article_new.click();
			Thread.sleep(1000);
			String expected_link = "https://zask.localpali.io/zask/articles/5894964703";
			assertEquals(expected_link,driver.getCurrentUrl());
			Thread.sleep(1000);
			WebElement comment_add = this.css_locator("#\\35 894964703 > div.question-detail > div.comments-container > div > span");
			comment_add.click();
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			boolean comment_area = this.xpath_locator("//*[@id=\"comment-box-5894964703\"]").isDisplayed();
			assertTrue(comment_area);
			WebElement text_add = this.css_locator("#comment-box-5894964703 > div.container > textarea");
			text_add.click();
			text_add.clear();
			text_add.sendKeys("test comment");
			Thread.sleep(1000);
			text_add = this.css_locator("#comment-box-5894964703 > div.container > div");
			text_add.click();
			Thread.sleep(3000);
			String actual_text = this.css_locator(".lyteMessageBoxContent").getText();
			String expected_text = "Your comment has been posted.";
			assertEquals(actual_text,expected_text);
		}
		
		////------------article comment notification check------------////
		@Test
		public void article_comment_notification_check() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(1000);
			demo = this.login_account_test();
			Thread.sleep(1000);
			WebElement notification_check = this.css_locator("span[lt-prop-title='Notifications']");
			notification_check.click();
			Thread.sleep(2000);
			boolean notify_count = this.xpath_locator("//*[@id=\"notification-count\"]").isDisplayed();
			Assert.assertTrue(notify_count);
			Thread.sleep(1000);
			String expected_value = "1";
			String notify_count_value = this.xpath_locator("//*[@id=\"notification-count\"]").getText();
			assertEquals(expected_value,notify_count_value);
			boolean notify_found = driver.getPageSource().contains("esakkivash.n has commented on your article: What does a good article look like?");
			assertTrue(notify_found);
			Thread.sleep(1000);
			WebElement read_notify = this.xpath_locator("//span[text()='Mark all as read']");
			read_notify.click();
			Thread.sleep(2000);
			String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
			String expected_data = "1 Notification(s) marked read successfully.";
			assertEquals(expected_data, actual_data);
			Thread.sleep(2000);
		}
		
		////----------disabling article comment notification----------////
		@Test
		public void disabling_article_comment_notification() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.notifications_settings();
			WebElement disabling_question_notify = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(4) > lyte-checkbox label");
			disabling_question_notify.click();
			Thread.sleep(1000);
			boolean question_notification = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(4) > lyte-checkbox input").isSelected();
			assertFalse(question_notification);
			Thread.sleep(1000);
			demo = this.logout_account();
			Thread.sleep(2000);
			demo = this.login_account_admin();
			Thread.sleep(2000);
			WebElement article_link = this.css_locator("link-to[lt-prop-route='index.articles']");
			article_link.click();
			Thread.sleep(2000);
			WebElement article_new = this.css_locator("a[href='/zask/articles/5894964703']");
			article_new.click();
			Thread.sleep(1000);
			String expected_link = "https://zask.localpali.io/zask/articles/5894964703";
			assertEquals(expected_link,driver.getCurrentUrl());
			Thread.sleep(1000);
			WebElement comment_add = this.css_locator("#\\35 894964703 > div.question-detail > div.comments-container > div > span");
			comment_add.click();
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			boolean comment_area = this.xpath_locator("//*[@id=\"comment-box-5894964703\"]").isDisplayed();
			assertTrue(comment_area);
			WebElement text_add = this.css_locator("#comment-box-5894964703 > div.container > textarea");
			text_add.click();
			text_add.clear();
			text_add.sendKeys("test comment");
			Thread.sleep(1000);
			text_add = this.css_locator("#comment-box-5894964703 > div.container > div");
			text_add.click();
			Thread.sleep(3000);
			String actual_text = this.css_locator(".lyteMessageBoxContent").getText();
			String expected_text = "Your comment has been posted.";
			assertEquals(actual_text,expected_text);
		}
		
		////-----------disabled article comment notification----------////
		@Test
		public void disable_article_comment_notification_check() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(1000);
			demo = this.login_account_test();
			Thread.sleep(1000);
			WebElement notification_check = this.css_locator("span[lt-prop-title='Notifications']");
			notification_check.click();
			Thread.sleep(2000);
			String notification_list = this.css_locator("#notificationsBody > zask-ui-notification-body:nth-child(1) > div").getCssValue("background");
			String notification_color = "rgb(255, 255, 255)";
			assertNotEquals(notification_list,notification_color);
		}
		
		////---------------whole notifications disable----------------////
		@Test
		public void overall_notifications_disable() throws InterruptedException {
			demo = this.logout_account();
			Thread.sleep(1000);
			demo = this.login_account_admin();
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.notifications_settings();
			String actual_data = "1px solid rgb(47, 175, 249)";
			String notification_active = this.css_locator("label[for='notification-setting']").getCssValue("border-bottom");
			assertEquals(notification_active,actual_data);
			actual_data = "rgba(47, 175, 249, 1)";
			notification_active = this.css_locator("label[for='notification-setting']").getCssValue("color");
			assertEquals(notification_active,actual_data);
			Thread.sleep(1500);
			WebElement all_notify = this.css_locator("label[mouseup='lyte-checkbox => mup(event)']");
			boolean notification_state = this.xpath_locator("//*[@id=\"all-notification-checkbox\"]").isSelected();
			assertTrue(notification_state);
			Thread.sleep(1000);
				if(notification_state) {
					all_notify.click();
				}
				else {
					assertFalse(notification_state);
				}
			Thread.sleep(2000);
			boolean question_notification = this.css_locator("#desktop-notification-checkbox").isEnabled();
			assertFalse(question_notification);
			boolean article_notification = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(2) > lyte-checkbox input").isEnabled();
			assertFalse(article_notification);
			boolean answer_notification = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(3) > lyte-checkbox input").isEnabled();
			assertFalse(answer_notification);
			boolean comment_notification = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(4) > lyte-checkbox input").isEnabled();
			assertFalse(comment_notification);
			boolean review_notification = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(5) > lyte-checkbox input").isEnabled();
			assertFalse(review_notification);
			boolean vote_notification = this.css_locator("#outlet-zask-content-container div.desktop-notifications.selected  div:nth-child(6) > lyte-checkbox input").isEnabled();
			assertFalse(vote_notification);
			Thread.sleep(1000);
		}
		
		////--------all actions with whole notification disable-------////
		@Test
		public void all_actions_with_whole_notification_disable() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(1000);
			demo = this.login_account_test();
			Thread.sleep(1000);
			String expected_link = "https://zask.localpali.io/zask";
			assertEquals(expected_link,driver.getCurrentUrl());
			Thread.sleep(1000);
			driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
			WebElement question_post = this.css_locator(".ask-question-container>zask-ui-button");
			question_post.click();
			Thread.sleep(1000);
			WebElement title1 = this.css_locator("#add-question-title");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", title1);
			title1.sendKeys("How to ask a good question?");
			Thread.sleep(1000);
			String val1 = "How to ask a good question?";
			assertEquals(val1, title1.getAttribute("value"));
			Thread.sleep(2000);
			WebElement ques1 = this.css_locator(".ql-editor");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", ques1);
			ques1.click();
			ques1.clear();
			ques1.sendKeys("How to ask a good question?");
			WebElement ques2 = this.css_locator(".ql-editor>p");
			String val2 = "How to ask a good question?";
			assertEquals(val2, ques2.getText());
			WebElement tags = this.css_locator("#input");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tags);
			tags.click();
			tags.sendKeys(Keys.BACK_SPACE);
			tags.sendKeys(Keys.BACK_SPACE);
			tags.sendKeys("test");
			Thread.sleep(1500);
			tags.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			String val3 = "test";
			WebElement tg1 = this.xpath_locator("//*[@id=\"outlet-zask-content-container\"]/zask-content-container/div[1]/zask-add-question/div/div[3]/zask-ui-tags-multi-selector/div/zask-ui-tag-closable[1]");
			assertEquals(val3, tg1.getAttribute("tagname"));
			Thread.sleep(1000);
			WebElement post_submit = this.css_locator("#add-question-submit");
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
			post_submit.click();
			Thread.sleep(2000);
			WebElement yes1 = this.css_locator("#modal-btn");
			String expected_data = ("Yes");
			assertEquals(expected_data, yes1.getText());
			Thread.sleep(1000);
			yes1.click();
			Thread.sleep(3000);
			String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
			expected_data = "Your post has been sent for review";
			assertEquals(expected_data, actual_data);
			Thread.sleep(2000);
			WebElement article_link = this.css_locator("link-to[lt-prop-route='index.questions']");
			article_link.click();
			Thread.sleep(2000);
			
			////-------liking,comment,answering, the question-------////
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			WebElement test_question = this.css_locator("a[href='/zask/questions/8592725907']");
			test_question.click();
			Thread.sleep(3000);
			String question_link = "https://zask.localpali.io/zask/questions/8592725907";
			assertEquals(question_link,driver.getCurrentUrl());
			Thread.sleep(1000);
			WebElement like_button = this.css_locator("#vote-8592725907 > div.up.info-ico.icon.like.vote");
			like_button.click();
			Thread.sleep(1000);
			WebElement favour_question = this.css_locator("#vote-8592725907 > div.fav > div");
			favour_question.click();
			Thread.sleep(2000);
			WebElement bounty_check = this.css_locator("zask-ui-button[lt-prop-title='Give 50-500 reputation for an answer']");
			bounty_check.click();
			Thread.sleep(1000);
			WebElement selecting_bounty = this.xpath_locator("//div[text()='50']");
			selecting_bounty.click();
			Thread.sleep(3000);
			String bounty_alert = "Bounty Placed Successfully";
			String bounty_actual = this.css_locator(".lyteMessageBoxContent").getText();
			assertEquals(bounty_alert,bounty_actual);
			Thread.sleep(4000);
			WebElement comment_add = this.css_locator("#\\38 592725907 > div.question-detail > div.comments-container > div > span");
			driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
			comment_add.click();
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			boolean comment_area = this.xpath_locator("//*[@id=\"comment-box-8592725907\"]").isDisplayed();
			assertTrue(comment_area);
			WebElement text_add = this.css_locator("#comment-box-8592725907 > div.container > textarea");
			text_add.click();
			text_add.clear();
			text_add.sendKeys("test comment");
			Thread.sleep(1000);
			text_add = this.css_locator("#comment-box-8592725907 > div.container > div");
			text_add.click();	
			Thread.sleep(3000);
			String actual_text = this.css_locator(".lyteMessageBoxContent").getText();
			String expected_text = "Your comment has been posted.";
			assertEquals(actual_text,expected_text);
			driver.navigate().refresh();
			Thread.sleep(2000);
			WebElement question_edit = this.css_locator("span[lt-prop-title='Edit']");
			question_edit.click();
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			WebElement edit_reason = this.xpath_locator("//*[@id=\"add-question-edit-summary\"]");
			edit_reason.click();
			edit_reason.clear();
			edit_reason.sendKeys("Provide details");
			Thread.sleep(1000);
			expected_text = "Provide details";
			assertEquals(expected_text,edit_reason.getAttribute("value"));
			Thread.sleep(2000);
			WebElement submit_btn = this.xpath_locator("//*[@id=\"add-question-submit\"]");
			submit_btn.click();
			Thread.sleep(3000);
			actual_data = this.css_locator(".lyteMessageBoxContent").getText();
			expected_text = "Your post has been sent for review";
			assertEquals(expected_text, actual_data);
			Thread.sleep(2000);
			WebElement answer_tab = this.css_locator("#editor-outlet > div.ql-editor");
			answer_tab.click();
			answer_tab.clear();
			answer_tab.sendKeys("Do you have an answer?");
			expected_text = "Do you have an answer?";
			actual_text = this.css_locator("#editor-outlet > div.ql-editor > p").getText();
			assertEquals(expected_text,actual_text);
			Thread.sleep(1000);
			WebElement answer_post = this.xpath_locator("//*[@id=\"add-answer-submit\"]");
			answer_post.click();
			Thread.sleep(3000);
			expected_text = "Your answer has been posted.";
			actual_text = this.css_locator(".lyteMessageBoxContent").getText();
			assertEquals(expected_text,actual_text);
			Thread.sleep(2000);
		}
		
		////----------all notification check in admin account---------////
		@Test
		public void all_notification_check() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			demo = this.logout_account();
			Thread.sleep(1000);
			demo = this.login_account_admin();
			Thread.sleep(1000);
			WebElement notification_check = this.css_locator("span[lt-prop-title='Notifications']");
			notification_check.click();
			Thread.sleep(2000);
			boolean notify_count = this.xpath_locator("//*[@id=\"notification-count\"]").isDisplayed();
			Assert.assertTrue(notify_count);
			Thread.sleep(1000);
			String expected_value = "1";
			String notify_count_value = this.xpath_locator("//*[@id=\"notification-count\"]").getText();
			assertEquals(expected_value,notify_count_value);
			boolean notify_found = driver.getPageSource().contains("You have earned 10 reputation for your question: How to ask a good question?");
			boolean notify_found1 = driver.getPageSource().contains("You have lost -10 reputation for your question: How to ask a good question?");
				if(notify_found) {
					assertTrue(notify_found);
				}
				else {
					assertTrue(notify_found1);
				}
			
			Thread.sleep(1000);
			WebElement read_notify = this.xpath_locator("//span[text()='Mark all as read']");
			read_notify.click();
			Thread.sleep(2000);
			String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
			String expected_data = "1 Notification(s) marked read successfully.";
			assertEquals(expected_data, actual_data);
			Thread.sleep(2000);
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
