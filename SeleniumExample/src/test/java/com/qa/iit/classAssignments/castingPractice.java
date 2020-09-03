package com.qa.iit.classAssignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class castingPractice {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "C:\\workspace\\LiveProjectWales\\Browsers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Thread.sleep(3000);
		//driver.get("");
		System.out.println("Printing the driver "+driver);
		System.out.println("Printing the hashcode "+driver.hashCode());
		//downcasting - Super type to subtype
		ChromeDriver driver1 = (ChromeDriver) driver;
		System.out.println(driver1);
		System.out.println(driver1.hashCode());
		/* driver. gives 22 methods ---> means there are 22 methods in WebDriver interface which are implemented 
		 * ChromeDriver
		 * driver1. gives 62 methods out of which 8 are unique from chromedriver. some from OBject class and 
		 * most are from RemoteWebdriver.
		 * 
		 */
		if(driver1 instanceof ChromeDriver){
			System.out.println("driver 1 is instanc of Chrome Driver");
		}
		else if(driver1 instanceof WebDriver){
			System.out.println("driver 1 is instanc of Web Driver");
		}
		if(driver instanceof ChromeDriver){
			System.out.println("driver  is instanc of Chrome Driver");
		}
		else if(driver instanceof WebDriver){
			System.out.println("driver is instanc of Web Driver");
		}
		
		
		//Upcasting - subtype to super type
		ChromeDriver cd = new ChromeDriver();
		System.out.println(cd);
		WebDriver wd = (WebDriver) cd;
		System.out.println(wd);
		

	}

}
