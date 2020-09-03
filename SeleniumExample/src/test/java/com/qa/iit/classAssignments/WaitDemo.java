package com.qa.iit.classAssignments;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
//import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitDemo {

	public static void main(String[] args) {
		
			
		WebDriverManager.chromedriver().setup();
		//System.getProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		//System.getProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.yahoo.com/");
		String xpath = "//div[contains(@id,'stream-item-publisher')]/preceding::div[text()='Sports']";
		
	    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	    	    .withTimeout(Duration.ofSeconds(60))
	    	    .pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
	    
			WebElement foo=wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					//return driver.findElement(By.id("stream-item-publisher_48"));
					return driver.findElement(By.xpath(xpath));
				}
				});
			foo.click();
	}
	
}
