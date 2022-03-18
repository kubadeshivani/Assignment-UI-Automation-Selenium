package com.assignment.ui.automation;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchProductTest {

	
	private static final String ASSERT_ERRORASSERT_ERROR_MESSAGE = "Page title not matched or Problem in loading url page";
	private static final String USER_DIR = "user.dir";
	private static final String CHROMEDRIVER_EXE_DIR = "\\src\\test\\resources\\executable\\chromedriver.exe";
	private static final String HTTPS_WWW_AMAZON_COM = "https://www.amazon.com/";
	private static final String EXPECTED_PAGE_TITLE = "Amazon.com : Lenovo Thinkpad Laptop";
	private static final String LENOVO_THINKPAD_LAPTOP = "Lenovo Thinkpad Laptop";
	private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
	

	@Test
	void search_product_on_Amazon() throws InterruptedException {

		System.setProperty(WEBDRIVER_CHROME_DRIVER, System.getProperty(USER_DIR) + CHROMEDRIVER_EXE_DIR);
		WebDriver driver = new ChromeDriver();

		// Launch browser
		driver.get(HTTPS_WWW_AMAZON_COM);
		driver.manage().window().maximize();

		// Search product
		WebElement element = driver.findElement(By.id("twotabsearchtextbox"));
		element.sendKeys(LENOVO_THINKPAD_LAPTOP);
		element = driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]"));
		element.submit();

		String actualPageTitlte = driver.getTitle();
		
		assertTrue(actualPageTitlte.equalsIgnoreCase(EXPECTED_PAGE_TITLE), ASSERT_ERRORASSERT_ERROR_MESSAGE);

		driver.close();

	}
}
