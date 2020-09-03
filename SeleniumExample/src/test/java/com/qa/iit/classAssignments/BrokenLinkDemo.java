package com.qa.iit.classAssignments;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinkDemo {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.yahoo.com/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for(int i=0; i<links.size(); i++) {
			WebElement element = links.get(i);
			String urlLink=element.getAttribute("href");
			System.out.println(urlLink);
			URL url = new URL(urlLink);
			URLConnection urlConn = url.openConnection();
			HttpURLConnection httpConn =(HttpURLConnection)urlConn;
			//HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();
			System.out.println(httpConn.getResponseCode());
			if(httpConn.getResponseCode()!= 200){
				System.out.println("Broken Link");
			}
		}
	}	
		
}
