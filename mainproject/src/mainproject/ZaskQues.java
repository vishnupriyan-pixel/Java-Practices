import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

@TestMethodOrder(OrderAnnotation.class)
public class ZaskQues {
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
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		log3.click();
		log3.clear();
		log3.sendKeys("testing1");

		nxt.click();
		Thread.sleep(2000);
	}

	/////Empty check 
	
	@Test
	@Order(2)
	public void Empty_check() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		WebElement ques = this.css_locator(".ask-question-container>zask-ui-button");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		ques.click();
		Thread.sleep(1000);
		WebElement pst = this.css_locator("#add-question-submit");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		pst.click();
		Thread.sleep(1000);
		String expected_data = "Enter a post title of at least 15 characters.";
		String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
		//		System.out.println(actual_data);
		assertEquals(expected_data, actual_data);
		Thread.sleep(1500);
		String url_check = "https://zask.localpali.io/zask/ask";
		assertEquals(url_check, driver.getCurrentUrl());
		driver.navigate().refresh();
	}

	////Invalid question title

	@Test
	@Order(3)
	public void Invalid_Title()throws InterruptedException {
		WebElement tit1 = this.css_locator("#add-question-title");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tit1);
		tit1.sendKeys("17688384848434");
		String val1 = "17688384848434";
		assertEquals(val1, tit1.getAttribute("value"));
		Thread.sleep(2000);
		WebElement pst = this.css_locator("#add-question-submit");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		pst.click();
		Thread.sleep(1000);
		String expected_data = "Enter a post title of at least 15 characters.";
		String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
		assertEquals(expected_data, actual_data);
		Thread.sleep(2000);
	}

	////Empty tag check

	@Test
	@Order(4)
	public void Empty_tag() throws InterruptedException {
		WebElement tit1 = this.css_locator("#add-question-title");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tit1);
		tit1.clear();
		tit1.sendKeys("1234556764484849854");
		String val1 = "1234556764484849854";
		assertEquals(val1, tit1.getAttribute("value"));
		Thread.sleep(1500);
		WebElement pst = this.css_locator("#add-question-submit");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		pst.click();
		Thread.sleep(1000);
		String expected_data = "Enter at least one tag to post.";
		String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
		assertEquals(expected_data, actual_data);
		Thread.sleep(2000);
	}

	////Empty tag with invalid characters in title

	@Test
	@Order(5)
	public void Empty_tag_invalid_title() throws InterruptedException {
		WebElement tit1 = this.css_locator("#add-question-title");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tit1);
		tit1.clear();
		tit1.sendKeys("!@#$$%%^^&*()__+<>?:+");
		String val1 = "!@#$$%%^^&*()__+<>?:+";
		assertEquals(val1, tit1.getAttribute("value"));
		Thread.sleep(2000);
		WebElement pst = this.css_locator("#add-question-submit");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		pst.click();
		Thread.sleep(1000);
		String expected_data = "Enter at least one tag to post.";
		String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
		assertEquals(expected_data, actual_data);
		Thread.sleep(3000);
		driver.navigate().refresh();
	}

	/////Empty in describe question
	
	@Test
	@Order(6)
	public void Empty_describe_question() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement tit1 = this.css_locator("#add-question-title");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tit1);
		tit1.clear();
		tit1.sendKeys("We may encounter the error - unable to locate element while working with Selenium webdriver.");
		String val1 = "We may encounter the error - unable to locate element while working with Selenium webdriver.";
		assertEquals(val1, tit1.getAttribute("value"));
		Thread.sleep(1000);
		WebElement pst = this.css_locator("#add-question-submit");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		pst.click();
		Thread.sleep(1500);
		String val4 = "java";
		WebElement tg2 = this.xpath_locator("//*[@id=\"outlet-zask-content-container\"]/zask-content-container/div[1]/zask-add-question/div/div[3]/zask-ui-tags-multi-selector/div/zask-ui-tag-closable[1]");
		assertEquals(val4, tg2.getAttribute("tagname"));
		String val5 = "selenium";
		WebElement tg3 = this.xpath_locator("//*[@id=\"outlet-zask-content-container\"]/zask-content-container/div[1]/zask-add-question/div/div[3]/zask-ui-tags-multi-selector/div/zask-ui-tag-closable[2]");
		assertEquals(val5, tg3.getAttribute("tagname"));
		Thread.sleep(3000);
		pst.click();
		String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
		String expected_data = "Enter valid post content of at least 15 characters";
		assertEquals(expected_data, actual_data);
		Thread.sleep(3000);
		driver.navigate().refresh();
	}

	////Title with less than 15 Characters

	@Test
	@Order(7)
	public void Title_lessthan_15characters() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement tit1 = this.css_locator("#add-question-title");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tit1);
		tit1.clear();
		tit1.sendKeys("It was fine");
		String val1 = "It was fine";
		assertEquals(val1, tit1.getAttribute("value"));
		Thread.sleep(1500);
		WebElement pst = this.css_locator("#add-question-submit");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		pst.click();
		Thread.sleep(1000);
		String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
		String expected_data = "Enter a post title of at least 15 characters.";
		assertEquals(expected_data, actual_data);
		Thread.sleep(3000);
		driver.navigate().refresh();
	}

	////describe question less than 15 characters

	@Test
	@Order(8)
	public void describe_question_below_15characters() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement tit1 = this.css_locator("#add-question-title");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tit1);
		tit1.clear();
		tit1.sendKeys("We may encounter the error - unable to locate element while working with Selenium webdriver.");
		String val1 = "We may encounter the error - unable to locate element while working with Selenium webdriver.";
		assertEquals(val1, tit1.getAttribute("value"));
		Thread.sleep(1500);
		WebElement ques1 = this.css_locator(".ql-editor");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", ques1);
		ques1.click();
		ques1.clear();
		ques1.sendKeys("Selenium is");
		WebElement ques2 = this.css_locator(".ql-editor>p");
		String val2 = "Selenium is";
		assertEquals(val2, ques2.getText());
		Thread.sleep(4000);
		WebElement tit2 = this.css_locator("#input");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tit1);
		tit2.click();
		tit2.sendKeys(Keys.BACK_SPACE);
		tit2.sendKeys(Keys.BACK_SPACE);
		tit2.sendKeys("test");
		Thread.sleep(1500);
		tit2.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		String val3 = "test";
		WebElement tg1 = this.xpath_locator("//*[@id=\"outlet-zask-content-container\"]/zask-content-container/div[1]/zask-add-question/div/div[3]/zask-ui-tags-multi-selector/div/zask-ui-tag-closable[1]");
		assertEquals(val3, tg1.getAttribute("tagname"));
		Thread.sleep(1000);
		WebElement pst = this.css_locator("#add-question-submit");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		pst.click();
		String expected_data = "Enter valid post content of at least 15 characters";
		String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
		assertEquals(expected_data, actual_data);
		Thread.sleep(2000);
		driver.navigate().refresh();
	}

	////Title content with more than 150 characters

	@Test
	@Order(9)
	public void title_morethan_150Characters() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement tit1 = this.css_locator("#add-question-title");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tit1);
		tit1.clear();
		tit1.sendKeys("We may enco It provides support for various data structures like arrays and objects which makes it easier to read7jhuerjitriteyquegdfeteuyyyyyyyyuuuehfhffhfhd");
		String val1 = "We may enco It provides support for various data structures like arrays and objects which makes it easier to read7jhuerjitriteyquegdfeteuyyyyyyyyuuuehfhffhfhd";
		assertEquals(val1, tit1.getAttribute("value"));
		Thread.sleep(1500);
		WebElement pst = this.css_locator("#add-question-submit");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		pst.click();
		Thread.sleep(1000);
		String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
		String expected_data = "Post title cannot exceed 150 characters.";
		assertEquals(expected_data, actual_data);
		Thread.sleep(3000);
		driver.navigate().refresh();
	}

	////Numbers in the post content less than 15 characters

	@Test
	@Order(10)
	public void describe_question_with_numbers_lessthan_15characters() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(4000,TimeUnit.MILLISECONDS);
		WebElement tit1 = this.css_locator("#add-question-title");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tit1);
		tit1.clear();
		tit1.sendKeys("Selenium provides drivers specific to each browser and without revealing the internal logic of browser functionality.");
		String val1 = "Selenium provides drivers specific to each browser and without revealing the internal logic of browser functionality.";
		assertEquals(val1, tit1.getAttribute("value"));
		Thread.sleep(2000);
		WebElement ques1 = this.css_locator(".ql-editor");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", ques1);
		ques1.click();
		ques1.clear();
		ques1.sendKeys("12345678901234");
		WebElement ques2 = this.css_locator(".ql-editor>p");
		String val2 = "12345678901234";
		assertEquals(val2, ques2.getText());
		Thread.sleep(4000);
		WebElement tit2 = this.css_locator("#input");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tit1);
		tit2.click();
		tit2.clear();
		tit2.sendKeys("test");
		Thread.sleep(1500);
		tit2.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		String val3 = "test";
		WebElement tg1 = this.xpath_locator("//*[@id=\"outlet-zask-content-container\"]/zask-content-container/div[1]/zask-add-question/div/div[3]/zask-ui-tags-multi-selector/div/zask-ui-tag-closable[1]");
		assertEquals(val3, tg1.getAttribute("tagname"));
		Thread.sleep(1000);
		WebElement pst = this.css_locator("#add-question-submit");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		pst.click();
		Thread.sleep(1500);
		String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
		String expected_data = "Enter valid post content of at least 15 characters";
		assertEquals(expected_data, actual_data);
		Thread.sleep(3000);
		driver.navigate().refresh();
	}

	/////Numbers in the post content more than 15 characters

	@Test
	@Order(11)
	public void describe_question_with_numbers_morethan_15characters() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(4000,TimeUnit.MILLISECONDS);
		WebElement tit1 = this.css_locator("#add-question-title");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tit1);
		tit1.clear();
		tit1.sendKeys("Selenium provides drivers specific to each browser and without revealing the internal logic of browser functionality.");
		String val1 = "Selenium provides drivers specific to each browser and without revealing the internal logic of browser functionality.";
		assertEquals(val1, tit1.getAttribute("value"));
		Thread.sleep(2000);
		WebElement ques1 = this.css_locator(".ql-editor");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", ques1);
		ques1.click();
		ques1.clear();
		ques1.sendKeys("12345678901234123");
		WebElement ques2 = this.css_locator(".ql-editor>p");
		String val2 = "12345678901234123";
		assertEquals(val2, ques2.getText());
		Thread.sleep(4000);
		WebElement tit2 = this.css_locator("#input");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tit1);
		tit2.click();
		tit2.clear();
		tit2.sendKeys("test");
		Thread.sleep(1500);
		tit2.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		String val3 = "test";
		WebElement tg1 = this.xpath_locator("//*[@id=\"outlet-zask-content-container\"]/zask-content-container/div[1]/zask-add-question/div/div[3]/zask-ui-tags-multi-selector/div/zask-ui-tag-closable[1]");
		assertEquals(val3, tg1.getAttribute("tagname"));
		Thread.sleep(1000);
		WebElement pst = this.css_locator("#add-question-submit");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		pst.click();
		Thread.sleep(1500);

		String actual_data1 = this.css_locator("#modal-desc").getText();
		String expected_data = "Your post will be sent for review.\nDo you want to proceed?";
		assertEquals(expected_data, actual_data1);
		Thread.sleep(1500);

		WebElement no1 = this.css_locator(".cancel");
		expected_data = ("No");
		assertEquals(expected_data, no1.getText());
		Thread.sleep(1000);
		no1.click();
		Thread.sleep(1500);
		driver.navigate().refresh();
	}

	////invalid characters in post content
	
	@Test
	@Order(12)
	public void Invalid_content() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(4000,TimeUnit.MILLISECONDS);
		WebElement tit1 = this.css_locator("#add-question-title");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tit1);
		tit1.clear();
		tit1.sendKeys("Selenium provides drivers specific to each browser and without revealing the internal logic of browser functionality.");
		String val1 = "Selenium provides drivers specific to each browser and without revealing the internal logic of browser functionality.";
		assertEquals(val1, tit1.getAttribute("value"));
		Thread.sleep(2000);

		WebElement ques1 = this.css_locator(".ql-editor");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", ques1);
		ques1.click();
		ques1.clear();
		ques1.sendKeys("qereyi");
		WebElement ques2 = this.css_locator(".ql-editor>p");
		String val2 = "qereyi";
		assertEquals(val2, ques2.getText());
		Thread.sleep(4000);
		WebElement tit2 = this.css_locator("#input");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tit1);
		tit2.click();
		tit2.clear();
		tit2.sendKeys("test");
		Thread.sleep(1500);
		tit2.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		WebElement pst2 = this.css_locator("#add-question-submit");
		Thread.sleep(5000);
		pst2.click();
		Thread.sleep(1500);
		String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
		String expected_data = "Enter valid post content of at least 15 characters";
		assertEquals(expected_data, actual_data);
		Thread.sleep(3000);

		ques1.click();
		ques1.clear();
		ques1.sendKeys("!@#$T^#&#*@@*#(#)*@&@*(##(*@&)_+=");
		Thread.sleep(1000);
		pst2.click();
		Thread.sleep(1500);

		String actual_data1 = this.css_locator("#modal-desc").getText();
		expected_data = "Your post will be sent for review.\nDo you want to proceed?";
		assertEquals(expected_data, actual_data1);
		Thread.sleep(1500);

		WebElement no1 = this.css_locator(".cancel");
		expected_data = ("No");
		assertEquals(expected_data, no1.getText());
		Thread.sleep(1000);
		no1.click();
		Thread.sleep(1500);
		driver.navigate().refresh();
	}

	///bold characters in post content
	
	@Test
	@Order(13)
	public void bold_font_post_content() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		WebElement tit2 = this.css_locator(".input-container>input");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		tit2.click();
		//		tit2.clear();
		tit2.sendKeys("test");
		Thread.sleep(5000);
		tit2.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(4000,TimeUnit.MILLISECONDS);
		WebElement tit1 = this.css_locator("#add-question-title");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tit1);
		driver.manage().timeouts().implicitlyWait(4000,TimeUnit.MILLISECONDS);
		tit1.clear();
		tit1.sendKeys("Selenium provides drivers specific to each browser and without revealing the internal logic of browser functionality.");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement bold_letter = this.css_locator(".ql-formats");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement bld = this.css_locator(".ql-bold");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		bld.click();

		String expected_data = "Bold";
		assertEquals(expected_data, bld.getAttribute("lt-prop-title"));
		Thread.sleep(1500);

		String bld_clr = this.css_locator(".ql-active").getCssValue("color");
		String bld_clr1 = "rgba(0, 102, 204, 1)"; 
		assertEquals(bld_clr,bld_clr1);
		Thread.sleep(1000);

		WebElement ques1 = this.css_locator(".ql-editor");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		ques1.click();
		ques1.sendKeys("Selenium provides support to multiple libraries such as Ruby, Python, Java, etc as language bindings have been developed by Selenium developers to provide compatibility for multiple languages.");
		WebElement ques2 = this.css_locator(".ql-editor>p");
		String val1 = "Selenium provides support to multiple libraries such as Ruby, Python, Java, etc as language bindings have been developed by Selenium developers to provide compatibility for multiple languages.";
		assertEquals(val1, ques2.getText());
		Thread.sleep(7000);


		WebElement pst1 = this.css_locator("#add-question-submit");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		pst1.click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement yes1 = this.css_locator("#modal-btn");
		expected_data = ("Yes");
		assertEquals(expected_data, yes1.getText());
		Thread.sleep(1000);
		yes1.click();
		Thread.sleep(4000);

		String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
		expected_data = "Your post has been sent for review";
		assertEquals(expected_data, actual_data);
		Thread.sleep(3000);

		actual_data = this.css_locator(".sp23").getText();
		expected_data = "Selenium provides drivers specific to each browser and without revealing the internal logic of browser functionality.";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);

		actual_data = this.css_locator("span[tagname='test']").getText();
		expected_data = "test";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);

		actual_data = this.css_locator(".z-content>p>strong").getTagName();
		expected_data = "strong";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);
		actual_data = this.css_locator(".z-content>p>strong").getText();
		expected_data = "Selenium provides support to multiple libraries such as Ruby, Python, Java, etc as language bindings have been developed by Selenium developers to provide compatibility for multiple languages.";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);
		driver.navigate().back();
	}

	//Italic font in post content

	@Test
	@Order(14)
	public void Italic_font_post_content() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		WebElement tit2 = this.css_locator(".input-container>input");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		tit2.click();
		//		tit2.clear();
		tit2.sendKeys("test");
		Thread.sleep(2000);
		tit2.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		WebElement bold_letter = this.css_locator(".ql-formats");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		WebElement bld = this.css_locator(".ql-italic");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		bld.click();

		String expected_data = "Italic";
		assertEquals(expected_data, bld.getAttribute("lt-prop-title"));
		Thread.sleep(1500);

		String bld_clr = this.css_locator(".ql-active").getCssValue("color");
		String bld_clr1 = "rgba(0, 102, 204, 1)"; 
		assertEquals(bld_clr,bld_clr1);
		Thread.sleep(1000);

		WebElement ques1 = this.css_locator(".ql-editor");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		ques1.click();
		ques1.sendKeys("Selenium provides support.");
		Thread.sleep(3000);
		//		WebElement ques2 = this.css_locator(".ql-editor>p");
		//		String val1 = "Selenium provides support.";
		//		assertEquals(val1, ques2.getText());
		//		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(4000,TimeUnit.MILLISECONDS);
		WebElement tit1 = this.css_locator("#add-question-title");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tit1);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		tit1.clear();
		tit1.sendKeys("Selenium provides drivers specific to each browser and without revealing the internal logic of browser functionality.");
		WebElement pst1 = this.css_locator("#add-question-submit");
		//		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		pst1.click();
		Thread.sleep(1000);
		WebElement yes1 = this.css_locator("#modal-btn");
		expected_data = ("Yes");
		assertEquals(expected_data, yes1.getText());
		Thread.sleep(1000);
		yes1.click();
		Thread.sleep(5000);

		String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
		expected_data = "Your post has been sent for review";
		assertEquals(expected_data, actual_data);
		Thread.sleep(3000);

		actual_data = this.css_locator(".sp23").getText();
		expected_data = "Selenium provides drivers specific to each browser and without revealing the internal logic of browser functionality.";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);
		actual_data = this.css_locator("span[tagname='test']").getText();
		expected_data = "test";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);

		actual_data = this.css_locator(".z-content>p>em").getTagName();
		expected_data = "em";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);
		actual_data = this.css_locator(".z-content>p>em").getText();
		expected_data = "Selenium provides support.";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);
		driver.navigate().back();
	}

	///Underlined

	@Test
	@Order(15)
	public void Underline_font_post_content() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		WebElement tit2 = this.css_locator(".input-container>input");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		tit2.click();
		//		tit2.clear();
		tit2.sendKeys("test");
		Thread.sleep(5000);
		tit2.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement bold_letter = this.css_locator(".ql-formats");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement bld = this.css_locator(".ql-underline");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		bld.click();

		String expected_data = "Underline";
		assertEquals(expected_data, bld.getAttribute("lt-prop-title"));
		Thread.sleep(1500);

		String bld_clr = this.css_locator(".ql-active").getCssValue("color");
		String bld_clr1 = "rgba(0, 102, 204, 1)"; 
		assertEquals(bld_clr,bld_clr1);
		Thread.sleep(1000);

		WebElement ques1 = this.css_locator(".ql-editor");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		ques1.click();
		ques1.sendKeys("Selenium provides support.");
		WebElement ques2 = this.css_locator(".ql-editor>p");
		String val1 = "Selenium provides support.";
		assertEquals(val1, ques2.getText());
		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(4000,TimeUnit.MILLISECONDS);
		WebElement tit1 = this.css_locator("#add-question-title");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tit1);
		driver.manage().timeouts().implicitlyWait(4000,TimeUnit.MILLISECONDS);
		tit1.clear();
		tit1.sendKeys("Selenium provides drivers specific to each browser and without revealing the internal logic of browser functionality.");
		Thread.sleep(1000);
		WebElement pst1 = this.css_locator("#add-question-submit");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		pst1.click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement yes1 = this.css_locator("#modal-btn");
		expected_data = ("Yes");
		assertEquals(expected_data, yes1.getText());
		Thread.sleep(1000);
		yes1.click();
		Thread.sleep(9000);

		String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
		expected_data = "Your post has been sent for review";
		assertEquals(expected_data, actual_data);
		Thread.sleep(3000);

		actual_data = this.css_locator(".sp23").getText();
		expected_data = "Selenium provides drivers specific to each browser and without revealing the internal logic of browser functionality.";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);
		actual_data = this.css_locator("span[tagname='test']").getText();
		expected_data = "test";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);

		actual_data = this.css_locator(".z-content>p>u").getTagName();
		expected_data = "u";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);
		actual_data = this.css_locator(".z-content>p>u").getText();
		expected_data = "Selenium provides support.";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);
		driver.navigate().back();
	}

	////Strike font in post content

	@Test
	@Order(16)

	public void Strike_font_post_content() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		WebElement tit2 = this.css_locator(".input-container>input");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		tit2.click();
		//		tit2.clear();
		tit2.sendKeys("test");
		Thread.sleep(5000);
		tit2.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement bold_letter = this.css_locator(".ql-formats");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement bld = this.css_locator(".ql-strike");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		bld.click();

		String expected_data = "Strike";
		assertEquals(expected_data, bld.getAttribute("lt-prop-title"));
		Thread.sleep(1500);

		String bld_clr = this.css_locator(".ql-active").getCssValue("color");
		String bld_clr1 = "rgba(0, 102, 204, 1)"; 
		assertEquals(bld_clr,bld_clr1);
		Thread.sleep(1000);

		WebElement ques1 = this.css_locator(".ql-editor");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		ques1.click();
		ques1.sendKeys("Selenium provides support.");
		WebElement ques2 = this.css_locator(".ql-editor>p");
		String val1 = "Selenium provides support.";
		assertEquals(val1, ques2.getText());
		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(4000,TimeUnit.MILLISECONDS);
		WebElement tit1 = this.css_locator("#add-question-title");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tit1);
		driver.manage().timeouts().implicitlyWait(4000,TimeUnit.MILLISECONDS);
		tit1.clear();
		tit1.sendKeys("Selenium provides drivers specific to each browser and without revealing the internal logic of browser functionality.");
		Thread.sleep(1000);
		WebElement pst1 = this.css_locator("#add-question-submit");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		pst1.click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement yes1 = this.css_locator("#modal-btn");
		expected_data = ("Yes");
		assertEquals(expected_data, yes1.getText());
		Thread.sleep(1000);
		yes1.click();
		Thread.sleep(5000);

		String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
		expected_data = "Your post has been sent for review";
		assertEquals(expected_data, actual_data);
		Thread.sleep(3000);

		actual_data = this.css_locator(".sp23").getText();
		expected_data = "Selenium provides drivers specific to each browser and without revealing the internal logic of browser functionality.";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);
		actual_data = this.css_locator("span[tagname='test']").getText();
		expected_data = "test";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);

		actual_data = this.css_locator(".z-content>p>s").getTagName();
		expected_data = "s";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);
		actual_data = this.css_locator(".z-content>p>s").getText();
		expected_data = "Selenium provides support.";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);
		driver.navigate().back();
	}
	
///////combination of bold and italic font styles in post content
	
	@Test
	@Order(17)
	public void combination_of_bold_Italicfonts() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement tit2 = this.css_locator(".input-container>input");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		tit2.click();
		//		tit2.clear();
		tit2.sendKeys("test");
		Thread.sleep(5000);
		tit2.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement bold_letter = this.css_locator(".ql-formats");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement bld = this.css_locator(".ql-bold");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		bld.click();
		Thread.sleep(1000);
		WebElement italic_font = this.css_locator(".ql-italic");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		italic_font.click();
		Thread.sleep(1000);
		String expected_data = "Bold";
		assertEquals(expected_data, bld.getAttribute("lt-prop-title"));
		expected_data = "Italic";
		assertEquals(expected_data, italic_font.getAttribute("lt-prop-title"));
		Thread.sleep(1500);
		String bld_clr = this.css_locator(".ql-active").getCssValue("color");
		String bld_clr1 = "rgba(0, 102, 204, 1)"; 
		assertEquals(bld_clr,bld_clr1);
		Thread.sleep(1000);

		WebElement ques1 = this.css_locator(".ql-editor");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		ques1.click();
		ques1.sendKeys("Selenium provides support.");
		WebElement ques2 = this.css_locator(".ql-editor>p");
		String val1 = "Selenium provides support.";
		assertEquals(val1, ques2.getText());
		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(4000,TimeUnit.MILLISECONDS);
		WebElement tit1 = this.css_locator("#add-question-title");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tit1);
		driver.manage().timeouts().implicitlyWait(4000,TimeUnit.MILLISECONDS);
		tit1.clear();
		tit1.sendKeys("Selenium provides drivers specific to each browser and without revealing the internal logic of browser functionality.");
		Thread.sleep(1000);
		WebElement pst1 = this.css_locator("#add-question-submit");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		pst1.click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement yes1 = this.css_locator("#modal-btn");
		expected_data = ("Yes");
		assertEquals(expected_data, yes1.getText());
		Thread.sleep(1000);
		yes1.click();
		Thread.sleep(6000);

		String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
		expected_data = "Your post has been sent for review";
		assertEquals(expected_data, actual_data);
		Thread.sleep(3000);

		actual_data = this.css_locator(".sp23").getText();
		expected_data = "Selenium provides drivers specific to each browser and without revealing the internal logic of browser functionality.";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);
		actual_data = this.css_locator("span[tagname='test']").getText();
		expected_data = "test";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);

		actual_data = this.css_locator(".z-content>p>strong").getTagName();
		expected_data = "strong";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);
		actual_data = this.css_locator(".z-content>p>strong").getText();
		expected_data = "Selenium provides support.";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);
		driver.navigate().back();
	}
	
///////combination of underline and strike font styles in post content
	
	@Test
	@Order(18)
	public void combination_of_underline_Strikefonts() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		WebElement tit2 = this.css_locator(".input-container>input");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		tit2.click();
		//		tit2.clear();
		tit2.sendKeys("test");
		Thread.sleep(5000);
		tit2.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement bold_letter = this.css_locator(".ql-formats");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement underline_font = this.css_locator(".ql-underline");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		underline_font.click();
		Thread.sleep(1000);
		WebElement strike_font = this.css_locator(".ql-strike");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		strike_font.click();
		String expected_data = "Underline";
		assertEquals(expected_data, underline_font.getAttribute("lt-prop-title"));
		expected_data = "Strike";
		assertEquals(expected_data, strike_font.getAttribute("lt-prop-title"));
		Thread.sleep(1500);

		String bld_clr = this.css_locator(".ql-active").getCssValue("color");
		String bld_clr1 = "rgba(0, 102, 204, 1)"; 
		assertEquals(bld_clr,bld_clr1);
		Thread.sleep(1000);

		WebElement ques1 = this.css_locator(".ql-editor");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		ques1.click();
		ques1.sendKeys("Selenium provides support.");
		WebElement ques2 = this.css_locator(".ql-editor>p");
		String val1 = "Selenium provides support.";
		assertEquals(val1, ques2.getText());
		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(4000,TimeUnit.MILLISECONDS);
		WebElement tit1 = this.css_locator("#add-question-title");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tit1);
		driver.manage().timeouts().implicitlyWait(4000,TimeUnit.MILLISECONDS);
		tit1.clear();
		tit1.sendKeys("Selenium provides drivers specific to each browser and without revealing the internal logic of browser functionality.");
		Thread.sleep(1000);
		WebElement pst1 = this.css_locator("#add-question-submit");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		pst1.click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement yes1 = this.css_locator("#modal-btn");
		expected_data = ("Yes");
		assertEquals(expected_data, yes1.getText());
		Thread.sleep(1000);
		yes1.click();
		Thread.sleep(10000);

		String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
		expected_data = "Your post has been sent for review";
		assertEquals(expected_data, actual_data);
		Thread.sleep(2000);

		actual_data = this.css_locator(".sp23").getText();
		expected_data = "Selenium provides drivers specific to each browser and without revealing the internal logic of browser functionality.";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);
		actual_data = this.css_locator("span[tagname='test']").getText();
		expected_data = "test"; 
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);

		actual_data = this.css_locator(".z-content>p>s").getTagName();
		expected_data = "s";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);
		actual_data = this.css_locator(".z-content>p>s").getText();
		expected_data = "Selenium provides support.";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);
		driver.navigate().back();
	}
	
///////All combination numbers letters special characters of all the font styles in post content
	
	@Test
	@Order(19)
	public void Mixed_combination_all_fonts() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		WebElement tit2 = this.css_locator(".input-container>input");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		tit2.click();
		//		tit2.clear();
		tit2.sendKeys("test");
		Thread.sleep(5000);
		tit2.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		////-------------------------bold-------------------------------/////
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement bold_letter = this.css_locator(".ql-formats");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement bld = this.css_locator(".ql-bold");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		bld.click();
		String expected_data = "Bold";
		assertEquals(expected_data, bld.getAttribute("lt-prop-title"));
		Thread.sleep(1000);
		WebElement ques1 = this.css_locator(".ql-editor");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		ques1.click();
		ques1.sendKeys("Selenium provides support.");
		WebElement ques2 = this.css_locator(".ql-editor>p");
		String val1 = "Selenium provides support.";
		assertEquals(val1, ques2.getText());
		Thread.sleep(2000);
		/////--------------------------Italic----------------------------/////
		WebElement italic_font = this.css_locator(".ql-italic");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		italic_font.click();
		expected_data = "Italic";
		assertEquals(expected_data, italic_font.getAttribute("lt-prop-title"));
		Thread.sleep(1000);
		ques1 = this.css_locator(".ql-editor");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		ques1.click();
		ques1.sendKeys("Selenium provides support.");
		ques2 = this.css_locator(".ql-editor>p");
		val1 = "Selenium provides support.Selenium provides support.";
		assertEquals(val1, ques2.getText());
		Thread.sleep(2000);
		/////-----------------------Underline---------------------------/////
		WebElement underline_font = this.css_locator(".ql-underline");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		underline_font.click();
		expected_data = "Underline";
		assertEquals(expected_data, underline_font.getAttribute("lt-prop-title"));
		Thread.sleep(1000);
		ques1 = this.css_locator(".ql-editor");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		ques1.click();
		ques1.sendKeys("Selenium provides support.");
		ques2 = this.css_locator(".ql-editor>p");
		val1 = "Selenium provides support.Selenium provides support.Selenium provides support.";
		assertEquals(val1, ques2.getText());
		Thread.sleep(2000);
		/////--------------------------Strike-----------------------------/////
		WebElement strike_font = this.css_locator(".ql-strike");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		strike_font.click();
		expected_data = "Strike";
		assertEquals(expected_data, strike_font.getAttribute("lt-prop-title"));
		Thread.sleep(1500);
		String bld_clr = this.css_locator(".ql-active").getCssValue("color");
		String bld_clr1 = "rgba(0, 102, 204, 1)"; 
		assertEquals(bld_clr,bld_clr1);
		Thread.sleep(1000);

		ques1 = this.css_locator(".ql-editor");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		ques1.click();
		ques1.sendKeys("Selenium provides support.");
		ques2 = this.css_locator(".ql-editor>p");
		val1 = "Selenium provides support.Selenium provides support.Selenium provides support.Selenium provides support.";
		assertEquals(val1, ques2.getText());
		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(4000,TimeUnit.MILLISECONDS);
		WebElement tit1 = this.css_locator("#add-question-title");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tit1);
		driver.manage().timeouts().implicitlyWait(4000,TimeUnit.MILLISECONDS);
		tit1.clear();
		tit1.sendKeys("Selenium provides drivers specific to each browser and without revealing the internal logic of browser functionality.");
		Thread.sleep(1000);
		WebElement pst1 = this.css_locator("#add-question-submit");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		pst1.click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement yes1 = this.css_locator("#modal-btn");
		expected_data = ("Yes");
		assertEquals(expected_data, yes1.getText());
		Thread.sleep(1000);
		yes1.click();
		Thread.sleep(3000);

		String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
		expected_data = "Your post has been sent for review";
		assertEquals(expected_data, actual_data);
		Thread.sleep(3000);

		actual_data = this.css_locator(".sp23").getText();
		expected_data = "Selenium provides drivers specific to each browser and without revealing the internal logic of browser functionality.";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);
		actual_data = this.css_locator("span[tagname='test']").getText();
		expected_data = "test";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);

		actual_data = this.css_locator(".z-content>p>strong").getTagName();
		expected_data = "strong";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);
		actual_data = this.css_locator(".z-content>p>strong").getText();
		expected_data = "Selenium provides support.";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);
		driver.navigate().back();
	}
	
	///////combination of all the font styles in post content
	
	@Test
	@Order(20)
	public void combination_all_fonts() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		WebElement tit2 = this.css_locator(".input-container>input");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		tit2.click();
		//		tit2.clear();
		tit2.sendKeys("test");
		Thread.sleep(5000);
		tit2.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement bold_letter = this.css_locator(".ql-formats");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement bld = this.css_locator(".ql-bold");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		bld.click();
		Thread.sleep(1000);
		WebElement italic_font = this.css_locator(".ql-italic");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		italic_font.click();
		Thread.sleep(1000);
		WebElement underline_font = this.css_locator(".ql-underline");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		underline_font.click();
		Thread.sleep(1000);
		WebElement strike_font = this.css_locator(".ql-strike");
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		strike_font.click();
		String expected_data = "Bold";
		assertEquals(expected_data, bld.getAttribute("lt-prop-title"));
		expected_data = "Italic";
		assertEquals(expected_data, italic_font.getAttribute("lt-prop-title"));
		expected_data = "Underline";
		assertEquals(expected_data, underline_font.getAttribute("lt-prop-title"));
		expected_data = "Strike";
		assertEquals(expected_data, strike_font.getAttribute("lt-prop-title"));
		Thread.sleep(1500);

		String bld_clr = this.css_locator(".ql-active").getCssValue("color");
		String bld_clr1 = "rgba(0, 102, 204, 1)"; 
		assertEquals(bld_clr,bld_clr1);
		Thread.sleep(1000);

		WebElement ques1 = this.css_locator(".ql-editor");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		ques1.click();
		ques1.sendKeys("Selenium provides support.");
		WebElement ques2 = this.css_locator(".ql-editor>p");
		String val1 = "Selenium provides support.";
		assertEquals(val1, ques2.getText());
		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(4000,TimeUnit.MILLISECONDS);
		WebElement tit1 = this.css_locator("#add-question-title");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tit1);
		driver.manage().timeouts().implicitlyWait(4000,TimeUnit.MILLISECONDS);
		tit1.clear();
		tit1.sendKeys("Selenium provides drivers specific to each browser and without revealing the internal logic of browser functionality.");
		Thread.sleep(1000);
		WebElement pst1 = this.css_locator("#add-question-submit");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		pst1.click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement yes1 = this.css_locator("#modal-btn");
		expected_data = ("Yes");
		assertEquals(expected_data, yes1.getText());
		Thread.sleep(1000);
		yes1.click();
		Thread.sleep(7000);

		String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
		expected_data = "Your post has been sent for review";
		assertEquals(expected_data, actual_data);
		Thread.sleep(3000);

		actual_data = this.css_locator(".sp23").getText();
		expected_data = "Selenium provides drivers specific to each browser and without revealing the internal logic of browser functionality.";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);
		actual_data = this.css_locator("span[tagname='test']").getText();
		expected_data = "test";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);

		actual_data = this.css_locator(".z-content>p>strong").getTagName();
		expected_data = "strong";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);
		actual_data = this.css_locator(".z-content>p>strong").getText();
		expected_data = "Selenium provides support.";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);
		driver.navigate().back();
	}
	
/////Invalid checks of same numbers in title and post content

	@Test
	@Order(21)
	public void invalid_checks_multiplenumbers() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		WebElement tit2 = this.css_locator(".input-container>input");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		tit2.click();
		String tag_placeholder = "Add tags.";
		assertEquals(tag_placeholder, tit2.getAttribute("placeholder"));
		tit2.sendKeys("12366");
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		WebElement tit1 = this.css_locator("#add-question-title");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tit1);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		tit1.clear();
		String placeholder_title = "Ask your question here!";
		assertEquals(placeholder_title, tit1.getAttribute("placeholder"));
		tit1.sendKeys("155556555655555555555");
		String val1 = "155556555655555555555";
		assertEquals(val1, tit1.getAttribute("value"));
		Thread.sleep(1500);
		WebElement ques1 = this.css_locator(".ql-editor");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		ques1.click();
		String content_placeholder = "Describe your question..";
		assertEquals(content_placeholder,ques1.getAttribute("data-placeholder"));
		ques1.sendKeys("144444444444444444444444444");
		WebElement ques2 = this.css_locator(".ql-editor>p");
		String text1 = "144444444444444444444444444";
		assertEquals(text1, ques2.getText());
		Thread.sleep(2000);
		WebElement pst1 = this.css_locator("#add-question-submit");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		pst1.click();
		Thread.sleep(2000);
		String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
		String expected_data = "Enter a post title of at least 15 characters.";
		assertEquals(expected_data, actual_data);
		Thread.sleep(2000);
		driver.navigate().refresh();
	}
	
	/////Invalid checks of different numbers in title and post content

	@Test
	@Order(22)
	public void invalid_checks_numbers() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		WebElement tit2 = this.css_locator(".input-container>input");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		tit2.click();
		String tag_placeholder = "Add tags.";
		assertEquals(tag_placeholder, tit2.getAttribute("placeholder"));
		tit2.sendKeys("test");
		Thread.sleep(3000);
		tit2.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		WebElement tit1 = this.css_locator("#add-question-title");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tit1);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		tit1.clear();
		String placeholder_title = "Ask your question here!";
		assertEquals(placeholder_title, tit1.getAttribute("placeholder"));
		tit1.sendKeys("14256363784949909827380");
		String val1 = "14256363784949909827380";
		assertEquals(val1, tit1.getAttribute("value"));
		Thread.sleep(1500);
		WebElement ques1 = this.css_locator(".ql-editor");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		ques1.click();
		String content_placeholder = "Describe your question..";
		assertEquals(content_placeholder,ques1.getAttribute("data-placeholder"));
		ques1.sendKeys("14256363784949909827380");
		WebElement ques2 = this.css_locator(".ql-editor>p");
		String text1 = "14256363784949909827380";
		assertEquals(text1, ques2.getText());
		Thread.sleep(2000);
		
		WebElement pst1 = this.css_locator("#add-question-submit");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		pst1.click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement yes1 = this.css_locator("#modal-btn");
		String expected_data = ("Yes");
		assertEquals(expected_data, yes1.getText());
		Thread.sleep(1000);
		yes1.click();
		Thread.sleep(4000);

		String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
		expected_data = "Your post has been sent for review";
		assertEquals(expected_data, actual_data);
		Thread.sleep(3000);

		actual_data = this.css_locator(".sp23").getText();
		expected_data = "14256363784949909827380";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);

		actual_data = this.css_locator("span[tagname='test']").getText();
		expected_data = "test";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);
		actual_data = this.css_locator(".z-content>p").getText();
		expected_data = "14256363784949909827380";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);
		driver.navigate().back();
		
	}
	
/////Invalid checks of same letters in title and post content
	
	@Test
	@Order(23)
	public void invalid_checks_multipleletters() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		WebElement tit2 = this.css_locator(".input-container>input");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		tit2.click();
		String tag_placeholder = "Add tags.";
		assertEquals(tag_placeholder, tit2.getAttribute("placeholder"));
		tit2.sendKeys("ghghgh");
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		WebElement tit1 = this.css_locator("#add-question-title");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tit1);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		tit1.clear();
		String placeholder_title = "Ask your question here!";
		assertEquals(placeholder_title, tit1.getAttribute("placeholder"));
		tit1.sendKeys("abcgggggggggghghggggggggggg");
		String val1 = "abcgggggggggghghggggggggggg";
		assertEquals(val1, tit1.getAttribute("value"));
		Thread.sleep(1500);
		WebElement ques1 = this.css_locator(".ql-editor");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		ques1.click();
		String content_placeholder = "Describe your question..";
		assertEquals(content_placeholder,ques1.getAttribute("data-placeholder"));
		ques1.sendKeys("cdhhhhhhhhhhhhjjkkkkkkkkkk");
		WebElement ques2 = this.css_locator(".ql-editor>p");
		String text1 = "cdhhhhhhhhhhhhjjkkkkkkkkkk";
		assertEquals(text1, ques2.getText());
		Thread.sleep(2000);
		WebElement pst1 = this.css_locator("#add-question-submit");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		pst1.click();
		Thread.sleep(2000);
		String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
		String expected_data = "Enter a post title of at least 15 characters.";
		assertEquals(expected_data, actual_data);
		Thread.sleep(2000);
		driver.navigate().refresh();
	}
	
	/////Invalid checks of different letters in title and post content
	
	@Test
	@Order(24)
	public void invalid_checks_characters() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		WebElement tit2 = this.css_locator(".input-container>input");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		tit2.click();
		String tag_placeholder = "Add tags.";
		assertEquals(tag_placeholder, tit2.getAttribute("placeholder"));
		tit2.sendKeys("test");
		Thread.sleep(3000);
		tit2.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		WebElement tit1 = this.css_locator("#add-question-title");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tit1);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		tit1.clear();
		String placeholder_title = "Ask your question here!";
		assertEquals(placeholder_title, tit1.getAttribute("placeholder"));
		tit1.sendKeys("abcdefgetyuioplmhjl");
		String val1 = "abcdefgetyuioplmhjl";
		assertEquals(val1, tit1.getAttribute("value"));
		Thread.sleep(1500);
		WebElement ques1 = this.css_locator(".ql-editor");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		ques1.click();
		String content_placeholder = "Describe your question..";
		assertEquals(content_placeholder,ques1.getAttribute("data-placeholder"));
		ques1.sendKeys("zxcvdgdbdhytqrwteuoplmn");
		WebElement ques2 = this.css_locator(".ql-editor>p");
		String text1 = "zxcvdgdbdhytqrwteuoplmn";
		assertEquals(text1, ques2.getText());
		Thread.sleep(2000);
		
		WebElement pst1 = this.css_locator("#add-question-submit");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		pst1.click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement yes1 = this.css_locator("#modal-btn");
		String expected_data = ("Yes");
		assertEquals(expected_data, yes1.getText());
		Thread.sleep(1000);
		yes1.click();
		Thread.sleep(4000);

		String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
		expected_data = "Your post has been sent for review";
		assertEquals(expected_data, actual_data);
		Thread.sleep(3000);

		actual_data = this.css_locator(".sp23").getText();
		expected_data = "abcdefgetyuioplmhjl";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);

		actual_data = this.css_locator("span[tagname='test']").getText();
		expected_data = "test";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);
		actual_data = this.css_locator(".z-content>p").getText();
		expected_data = "zxcvdgdbdhytqrwteuoplmn";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);
		driver.navigate().back();
		
	}
	
/////Invalid checks of same Special characters in title and post content

	@Test
	@Order(25)
	public void invalid_checks_multipleSpecialcharacters() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		WebElement tit2 = this.css_locator(".input-container>input");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		tit2.click();
		String tag_placeholder = "Add tags.";
		assertEquals(tag_placeholder, tit2.getAttribute("placeholder"));
		tit2.sendKeys("^^&&&");
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		WebElement tit1 = this.css_locator("#add-question-title");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tit1);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		tit1.clear();
		String placeholder_title = "Ask your question here!";
		assertEquals(placeholder_title, tit1.getAttribute("placeholder"));
		tit1.sendKeys("!#@@@@@@@@@@@@@@@@@@@@@@@@@@");
		String val1 = "!#@@@@@@@@@@@@@@@@@@@@@@@@@@";
		assertEquals(val1, tit1.getAttribute("value"));
		Thread.sleep(1500);
		WebElement ques1 = this.css_locator(".ql-editor");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		ques1.click();
		String content_placeholder = "Describe your question..";
		assertEquals(content_placeholder,ques1.getAttribute("data-placeholder"));
		ques1.sendKeys("$%&&&&&&&&&&&&&&&&&&&&&&&&&&");
		WebElement ques2 = this.css_locator(".ql-editor>p");
		String text1 = "$%&&&&&&&&&&&&&&&&&&&&&&&&&&";
		assertEquals(text1, ques2.getText());
		Thread.sleep(2000);
		WebElement pst1 = this.css_locator("#add-question-submit");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		pst1.click();
		Thread.sleep(2000);
		String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
		String expected_data = "Enter a post title of at least 15 characters.";
		assertEquals(expected_data, actual_data);
		Thread.sleep(2000);
		driver.navigate().refresh();
	}
	
/////Invalid checks of different special characters in title and post content

	@Test
	@Order(26)
	public void invalid_checks_specialCharacters() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		WebElement tit2 = this.css_locator(".input-container>input");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		tit2.click();
		String tag_placeholder = "Add tags.";
		assertEquals(tag_placeholder, tit2.getAttribute("placeholder"));
		tit2.sendKeys("test");
		Thread.sleep(3000);
		tit2.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		WebElement tit1 = this.css_locator("#add-question-title");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tit1);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		tit1.clear();
		String placeholder_title = "Ask your question here!";
		assertEquals(placeholder_title, tit1.getAttribute("placeholder"));
		tit1.sendKeys("!@#$%^&*()_+#@%^!");
		String val1 = "!@#$%^&*()_+#@%^!";
		assertEquals(val1, tit1.getAttribute("value"));
		Thread.sleep(1500);
		WebElement ques1 = this.css_locator(".ql-editor");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		ques1.click();
		String content_placeholder = "Describe your question..";
		assertEquals(content_placeholder,ques1.getAttribute("data-placeholder"));
		ques1.sendKeys("/><.,;:''{}[]|#$%*())");
		WebElement ques2 = this.css_locator(".ql-editor>p");
		String text1 = "/><.,;:''{}[]|#$%*())";
		assertEquals(text1, ques2.getText());
		Thread.sleep(2000);
		
		WebElement pst1 = this.css_locator("#add-question-submit");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		pst1.click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement yes1 = this.css_locator("#modal-btn");
		String expected_data = ("Yes");
		assertEquals(expected_data, yes1.getText());
		Thread.sleep(1000);
		yes1.click();
		Thread.sleep(4000);

		String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
		expected_data = "Your post has been sent for review";
		assertEquals(expected_data, actual_data);
		Thread.sleep(3000);

		actual_data = this.css_locator(".sp23").getText();
		expected_data = "!@#$%^&*()_+#@%^!";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);

		actual_data = this.css_locator("span[tagname='test']").getText();
		expected_data = "test";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);
		actual_data = this.css_locator(".z-content>p").getText();
		expected_data = "/><.,;:''{}[]|#$%*())";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);
		driver.navigate().back();
		
	}
	
/////Invalid checks of repeated Special characters functions in title and post content

	@Test
	@Order(27)
	public void invalid_checks_repeatedSpecialFunctions() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		WebElement tit2 = this.css_locator(".input-container>input");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		tit2.click();
		String tag_placeholder = "Add tags.";
		assertEquals(tag_placeholder, tit2.getAttribute("placeholder"));
		tit2.sendKeys("  @hc9");
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		WebElement tit1 = this.css_locator("#add-question-title");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tit1);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		tit1.clear();
		String placeholder_title = "Ask your question here!";
		assertEquals(placeholder_title, tit1.getAttribute("placeholder"));
		tit1.sendKeys("               !n1,>0.     p");
		String val1 = "               !n1,>0.     p";
		assertEquals(val1, tit1.getAttribute("value"));
		Thread.sleep(1500);
		WebElement ques1 = this.css_locator(".ql-editor");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		ques1.click();
		String content_placeholder = "Describe your question..";
		assertEquals(content_placeholder,ques1.getAttribute("data-placeholder"));
		ques1.sendKeys("~6 p 0 = hdjuw6zx     l");
		WebElement ques2 = this.css_locator(".ql-editor>p");
		String text1 = "~6 p 0 = hdjuw6zx     l";
		assertEquals(text1, ques2.getText());
		Thread.sleep(2000);
		WebElement pst1 = this.css_locator("#add-question-submit");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		pst1.click();
		Thread.sleep(2000);
		String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
		String expected_data = "Enter a post title of at least 15 characters.";
		assertEquals(expected_data, actual_data);
		Thread.sleep(2000);
		driver.navigate().refresh();
	}
	
/////Invalid checks of different special characters functions in title and post content

	@Test
	@Order(28)
	public void invalid_checks_specialCharactersFunctions() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		WebElement tit2 = this.css_locator(".input-container>input");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		tit2.click();
		String tag_placeholder = "Add tags.";
		assertEquals(tag_placeholder, tit2.getAttribute("placeholder"));
		tit2.sendKeys("test");
		Thread.sleep(3000);
		tit2.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		WebElement tit1 = this.css_locator("#add-question-title");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tit1);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		tit1.clear();
		String placeholder_title = "Ask your question here!";
		assertEquals(placeholder_title, tit1.getAttribute("placeholder"));
		tit1.sendKeys(" S e l e n i u m @1290-=");
		String val1 = " S e l e n i u m @1290-=";
		assertEquals(val1, tit1.getAttribute("value"));
		Thread.sleep(1500);
		WebElement ques1 = this.css_locator(".ql-editor");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		ques1.click();
		String content_placeholder = "Describe your question..";
		assertEquals(content_placeholder,ques1.getAttribute("data-placeholder"));
		ques1.sendKeys("I t@% ./u se d Fo r tes@ $t iNG .,");
		WebElement ques2 = this.css_locator(".ql-editor>p");
		String text1 = "I t@% ./u se d Fo r tes@ $t iNG .,";
		assertEquals(text1, ques2.getText());
		Thread.sleep(2000);
		
		WebElement pst1 = this.css_locator("#add-question-submit");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		pst1.click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement yes1 = this.css_locator("#modal-btn");
		String expected_data = ("Yes");
		assertEquals(expected_data, yes1.getText());
		Thread.sleep(1000);
		yes1.click();
		Thread.sleep(4000);

		String actual_data = this.css_locator(".lyteMessageBoxContent").getText();
		expected_data = "Your post has been sent for review";
		assertEquals(expected_data, actual_data);
		Thread.sleep(3000);

		actual_data = this.css_locator(".sp23").getText();
		expected_data = "S e l e n i u m @1290-=";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);

		actual_data = this.css_locator("span[tagname='test']").getText();
		expected_data = "test";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);
		actual_data = this.css_locator(".z-content>p").getText();
		expected_data = "I t@% ./u se d Fo r tes@ $t iNG .,";
		assertEquals(expected_data, actual_data);
		Thread.sleep(1000);
		driver.navigate().back();
		
	}
	
/////Maximum no.of.tags fields check

	@Test
	@Order(29)
	public void max_no_of_tagsFields() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		WebElement tit2 = this.css_locator(".input-container>input");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		tit2.click();
		String tag_placeholder = "Add tags.";
		assertEquals(tag_placeholder, tit2.getAttribute("placeholder"));
		tit2.sendKeys("test");
		Thread.sleep(2000);
		tit2.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		String val3 = "test";
		WebElement tag1 = this.xpath_locator("//*[@id=\"outlet-zask-content-container\"]/zask-content-container/div[1]/zask-add-question/div/div[3]/zask-ui-tags-multi-selector/div/zask-ui-tag-closable[1]");
		assertEquals(val3, tag1.getAttribute("tagname"));
		Thread.sleep(1000);
		tit2.sendKeys("test");
		Thread.sleep(2000);
		tit2.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		String val4 = "testing";
		WebElement tag2 = this.xpath_locator("//*[@id=\"outlet-zask-content-container\"]/zask-content-container/div[1]/zask-add-question/div/div[3]/zask-ui-tags-multi-selector/div/zask-ui-tag-closable[2]");
		assertEquals(val4, tag2.getAttribute("tagname"));
		Thread.sleep(1000);
		tit2.sendKeys("test");
		Thread.sleep(2000);
		tit2.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		String val5 = "testtag1";
		WebElement tag3 = this.xpath_locator("//*[@id=\"outlet-zask-content-container\"]/zask-content-container/div[1]/zask-add-question/div/div[3]/zask-ui-tags-multi-selector/div/zask-ui-tag-closable[3]");
		assertEquals(val5, tag3.getAttribute("tagname"));
		Thread.sleep(1000);
		tit2.sendKeys("test");
		Thread.sleep(2000);
		tit2.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		String val6 = "unit-testing";
		WebElement tag4 = this.xpath_locator("//*[@id=\"outlet-zask-content-container\"]/zask-content-container/div[1]/zask-add-question/div/div[3]/zask-ui-tags-multi-selector/div/zask-ui-tag-closable[4]");
		assertEquals(val6, tag4.getAttribute("tagname"));
		Thread.sleep(1000);
		tit2.sendKeys("test+");
		Thread.sleep(2000);
		tit2.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		String val7 = "Test+Tag";
		WebElement tag5 = this.xpath_locator("//*[@id=\"outlet-zask-content-container\"]/zask-content-container/div[1]/zask-add-question/div/div[3]/zask-ui-tags-multi-selector/div/zask-ui-tag-closable[5]");
		assertEquals(val7, tag5.getAttribute("tagname"));
		Thread.sleep(1000);
		
		String max_tag = "display: none;";
		assertEquals(max_tag, tit2.getAttribute("style"));
		driver.navigate().refresh();
	}
	
	////post content box resizing

	@Test
	@Order(30)
	
	public void post_content_resize() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement content_box = driver.findElement(By.id("editor-outlet"));
		String content_box1 = "396px";
		assertEquals(content_box1, content_box.getCssValue("height"));
		js.executeScript("arguments[0].setAttribute('style', 'height:200px')", content_box);
		Thread.sleep(2000);
		String content_size = "height: 200px;";
		String content_minimum = this.css_locator("#editor-outlet").getAttribute("style");
		assertEquals(content_size, content_minimum);
		Thread.sleep(2000);
		js.executeScript("arguments[0].setAttribute('style', 'height:496px')", content_box);
		Thread.sleep(2000);
		String content_size1 = "height: 496px;";
		String content_minimum1 = this.css_locator("#editor-outlet").getAttribute("style");
		assertEquals(content_size1, content_minimum1);
		Thread.sleep(2000);
		js.executeScript("arguments[0].setAttribute('style', 'height:600px')", content_box);
		Thread.sleep(2000);
		String content_size2 = "height: 600px;";
		String content_minimum2 = this.css_locator("#editor-outlet").getAttribute("style");
		assertEquals(content_size2, content_minimum2);
		Thread.sleep(5000);
		driver.navigate().back();
	}
	
	////bounty flag
	@SuppressWarnings("unlikely-arg-type")
	@Test
	@Order(31)
	
	public void bounty_flag() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement question1 = this.css_locator("a[href='/zask/questions/4177811000']");
		question1.click();
		Thread.sleep(2000);
		String ques1_link = "https://zask.localpali.io/zask/questions/4177811000";
		assertEquals(ques1_link ,driver.getCurrentUrl());
		Thread.sleep(2000);
		/////------------selecting SPAM under the flag----------------------/////
		WebElement flag_icon = this.css_locator("#flag-4177811000");
		flag_icon.click();
		String flag_icon_color = this.css_locator(".icon.flag:hover").getCssValue("background-position");
		String flag_icon_edited = "-169px -96px";
		assertEquals(flag_icon_color,flag_icon_edited);
		Thread.sleep(1000);
		String flag_type = "Spam";
		WebElement flag_type1 = this.css_locator(".flag-r:nth-child(1)");
		assertEquals(flag_type,flag_type1.getText());
		Thread.sleep(1000);
		flag_type1.click();
		flag_icon_edited = "rgba(253, 17, 111, 1)";
		flag_type = "rgba(78, 82, 84, 1)";
		
		if(flag_type1.getCssValue("color") != null){
			equals(flag_icon_edited);
		}
		else {
			equals(flag_type);
		}
		Thread.sleep(1500);	
		flag_icon.click();
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		flag_type1.click();
		boolean flag = driver.getPageSource().contains("Flagged!");
		boolean flag1 = driver.getPageSource().contains("Flag Removed");
		
		if(flag) {
			assertTrue(flag);
		}
		else {
			assertTrue(flag1);
		}
		
		Thread.sleep(1000);
	/////------------selecting Rude or abusive under the flag----------------------/////
		
		flag_icon.click();
		flag_icon_color = this.css_locator(".icon.flag:hover").getCssValue("background-position");
		flag_icon_edited = "-169px -96px";
		assertEquals(flag_icon_color,flag_icon_edited);
		Thread.sleep(1700);
		flag_type = "Rude or abusive";
		flag_type1 = this.css_locator(".flag-r:nth-child(2)");
		assertEquals(flag_type,flag_type1.getText());
		flag_type1.click();
		flag_icon_edited = "rgba(253, 17, 111, 1)";
		flag_type = "rgba(78, 82, 84, 1)";
		
		if(flag_type1.getCssValue("color") != null){
			equals(flag_icon_edited);
		}
		else {
			equals(flag_type);
		}
		Thread.sleep(1000);	
		flag_icon.click();
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		flag_type1.click();
		flag = driver.getPageSource().contains("Flagged!");
		flag1 = driver.getPageSource().contains("Flag Removed");
		
		if(flag) {
			assertTrue(flag);
		}
		else {
			assertTrue(flag1);
		}
		
		Thread.sleep(1000);
		
	////------------------selecting Very low quality---------------------/////
		flag_icon.click();
		flag_icon_color = this.css_locator(".icon.flag:hover").getCssValue("background-position");
		flag_icon_edited = "-169px -96px";
		assertEquals(flag_icon_color,flag_icon_edited);
		Thread.sleep(1700);
		flag_type = "Very low quality";
		flag_type1 = this.css_locator(".flag-r:nth-child(3)");
		assertEquals(flag_type,flag_type1.getText());
		flag_type1.click();
		flag_icon_edited = "rgba(253, 17, 111, 1)";
		flag_type = "rgba(78, 82, 84, 1)";
		
		if(flag_type1.getCssValue("color") != null){
			equals(flag_icon_edited);
		}
		else {
			equals(flag_type);
		}
		Thread.sleep(1000);	
		flag_icon.click();
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		flag_type1.click();		
		flag = driver.getPageSource().contains("Flagged!");
		flag1 = driver.getPageSource().contains("Flag Removed");
		
		if(flag) {
			assertTrue(flag);
		}
		else {
			assertTrue(flag1);
		}
		
		Thread.sleep(1000);
	}
	
	//////bounty link

	@Test
	@Order(32)
	
	public void bounty_link() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement link_icon = this.css_locator(".link>span");
		Actions link_action = new Actions(driver);
		link_action.moveToElement(link_icon);
		  String tooltip_menu = "Link";
	      assertEquals(tooltip_menu, link_icon.getAttribute("lt-prop-title"));
		WebElement question_url = this.css_locator(".copy-text");
		link_action.moveToElement(question_url);
		
		String copy_text_color = "rgba(249, 163, 47, 1)";
		assertEquals(copy_text_color, question_url.getCssValue("color"));
		link_action.click().build().perform();
	
		String copy_text = "Copied";
		assertEquals(copy_text, question_url.getText());
		String url_present = "https://zask.localpali.io/zask/questions/4177811000";
		String url_present1 = this.css_locator(".copy-link").getText();
		assertEquals(url_present, url_present1);
		
		Thread.sleep(2000);   
	}
	
	@Test
	@Order(33)

	public void zclse() throws InterruptedException {
		WebElement cld = this.css_locator(".user-profile-window");
		cld.click();
		Thread.sleep(1000);
		WebElement cld1 = this.css_locator(".sign-out-button");
		cld1.click();
		Thread.sleep(1000);
	}

	@AfterAll

	public void end_clse() {
		driver.quit();
	}



}
