package com.qa.iit.classAssignments;

import java.util.List;

import org.iit.mmp.helper.HelperClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchPatient {
	
	WebDriver driver;
	String SSN = "462379048";
	
	@Test
	public void searchPatient() {
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php");
		HelperClass helperObj = new HelperClass(driver);
		helperObj = new HelperClass(driver);
		helperObj.launchApplicationURL("http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php");
		helperObj.adminLogin("shak", "9ol.<KI*");
		helperObj.adminModuleNavigation("Patient");
		driver.findElement(By.id("search")).sendKeys("Ria");
		driver.findElement(By.xpath("//input[@value='search']")).click();
		List<WebElement> columnElements = driver.findElements(By.xpath("//div[@id='show']/table//tr/th"));
		System.out.println();
		System.out.println(columnElements.size());
		List<WebElement> rowElements = driver.findElements(By.xpath("//div[@id='show']/table/tbody/tr/td[1]"));
		//div[@id='show']/table/tbody/tr/td[1]
		System.out.println(rowElements.size());
		for (int i=0; i<rowElements.size(); i++) {
			//System.out.println(rowElements.get(i).getText());
			String s1 = driver.findElement(By.xpath("//div[@id='show']/table/tbody/tr["+i+"]/td[2]")).getText();
			
			if(((rowElements.get(i).getText()).equals("Ria"))&& ((s1).equals(SSN))){
				System.out.println(i);
				System.out.println(rowElements.get(i).getText());
				//String s1 = driver.findElement(By.xpath("//div[@id='show']/table/tbody/tr["+i+"]/td[2]")).getText();
				System.out.println("SSN is "+s1);
				rowElements.get(i).click();
				System.out.println("Clicked the patient link");
				/*if((s1).equals(SSN)){
					System.out.println(driver.findElement(By.xpath("//div[@id='show']/table/tbody/tr["+i+"]/td[2]")).getText());
					rowElements.get(i).click();
					System.out.println("Clicked the patient link");
				}*/	
			}
				
			
			
		}
		
		
	}

}
