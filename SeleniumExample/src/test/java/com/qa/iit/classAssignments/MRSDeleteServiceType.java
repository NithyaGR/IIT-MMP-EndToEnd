package com.qa.iit.classAssignments;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MRSDeleteServiceType {

	static WebDriver driver;
	static String sName = "Pediatrics";
	static String action = "Search";


	public static void openWebPage(){

		//System.setProperty("webdriver.chrome.driver", "C:\\workspace\\LiveProjectWales\\Browsers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.openmrs.org/openmrs/login.htm");

	}

	public static void login(){

		driver.findElement(By.id("username")).sendKeys("Admin");
		driver.findElement(By.id("password")).sendKeys("Admin123");
		driver.findElement(By.id("Inpatient Ward")).click();
		driver.findElement(By.id("loginButton")).click();
	}

	public static void logout(){

	}

	public static void selectOptionsHomePage(){

		driver.findElement(By.id("appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension")).click();
		//driver.findElement(By.xpath("//a[contains(@id,'appointmentRequests')]")).click();
		driver.findElement(By.id("appointmentschedulingui-manageAppointmentTypes-app")).click();

		//a[contains(@id,'appointmentRequests')]
		//a[contains(@id,'manageAppointmentTypes')]
	}
	public static int getPageCounts(){
		List <WebElement> pageList = driver.findElements(By.xpath("//div[@id='appointmentTypesTable_paginate']/span/a"));
		int pageCount = pageList.size();
		return pageCount;
	}
	public static boolean deleteServiceType(String sType){
		
		boolean result = false;
		int pageCount = getPageCounts();
		System.out.println("Total No. Of Pages is "+pageCount);
		outerloop:
		for (int i=1; i<=pageCount; i++){
			System.out.println("The current page is :"+i);
			// Getting the list of service Types in the current page
			List <WebElement> sTypes = driver.findElements(By.xpath("//table[@id='appointmentTypesTable']/tbody/tr/td[1]"));
			       for (int j=0;j<sTypes.size(); j++){
			    	   // select the matching service type from the list
			    	   if ((sTypes.get(j).getText()).equals(sType)){
			    		   System.out.println("Service Type Found: "+sType);
			    		   String xpath = "//td[text()='"+sType+"']/following-sibling::td[3]/descendant::i[@title='Delete']";
			    		   driver.findElement(By.xpath(xpath)).click();
			    		   //Storing the buttons in the list
			    		   List<WebElement> buttonList = driver.findElements(By.xpath(".//*[@id='delete-appointment-type-dialog']/div[2]/button[@class='confirm right']"));
			   			   System.out.println("Number of Buttons" + buttonList.size());
			   			   		for(int k=0; k<buttonList.size(); k++){
			   				
			   			   				try{
			   			   					if(buttonList.get(k).isDisplayed() || buttonList.get(i).isEnabled()){
							
			   			   						buttonList.get(k).click();
			   			   						//System.out.println("The button to be clicked is :"+buttonList.get(k).getText());
			   			   						result= true;
			   			   						break outerloop;
			   			   					}
			   			   				}
			   			   				catch(Exception e){
						
			   			   					System.out.println("Element is not visible|| enabled"+e.getMessage());
			   			   				}
			   			   		}
			   			}
			    	   
			       }
			       driver.findElement(By.linkText("Next")).click();	
				   System.out.println("Next button clicked");
 		}
		return result;
		
	}


	@Test
	public static void CheckAvailability() throws Exception{

		openWebPage();
		login();
		selectOptionsHomePage();
		boolean result = deleteServiceType(sName);
		System.out.println("The result of the deleteServiceType is "+result);
		
	}




}

