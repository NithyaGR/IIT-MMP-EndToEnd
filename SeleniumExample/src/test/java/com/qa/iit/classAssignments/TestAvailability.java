package com.qa.iit.classAssignments;
import java.util.List;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestAvailability {

	static WebDriver driver;
	static String sName = "Oncology";
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
	public static List<WebElement> getList(){
		List <WebElement> list = driver.findElements(By.xpath("//table[@id='appointmentTypesTable']/tbody/tr/td[1]"));
		System.out.println(list.size());
		return list;
	}
	public static int getPageCounts(){
		List <WebElement> pageList = driver.findElements(By.xpath("//div[@id='appointmentTypesTable_paginate']/span/a"));
		int pageCount = pageList.size();
		return pageCount;
	}

	public static boolean searchServiceType(String text){

		boolean result = false;
		int pageCount = getPageCounts();
		outerloop:
			for(int i=1;i<=pageCount;i++){
				List <WebElement> serviceType = driver.findElements(By.xpath("//table[@id='appointmentTypesTable']/tbody/tr/td[1]"));

				System.out.println(serviceType.size());

				for(int j=0;j<serviceType.size();j++){

					System.out.println(serviceType.get(j).getText());

					if((serviceType.get(j).getText()).equals(text)){
						System.out.println("Service Type Found");
						result = true;
						break outerloop;
					}
				} 
				driver.findElement(By.linkText("Next")).click();
			}
		return result;
	}

	public static boolean getServiceType(String sType, String action){

		boolean result = false;
		int pageCount = getPageCounts();
		int index=1;
		outerloop:
			for(int i=1;i<=pageCount;i++){
				System.out.println(pageCount);
				//In the current page storing all the service types in List
				List <WebElement> serviceType = driver.findElements(By.xpath("//table[@id='appointmentTypesTable']/tbody/tr/td[1]"));

				// To print the total no. of service types in the current page
				System.out.println(serviceType.size());

				for(int j=0;j<serviceType.size();j++){
					//To print all the service types in the current page
					System.out.println(serviceType.get(j).getText());

					if((serviceType.get(j).getText()).equals(sType)&& (action.equals("Search"))){
						System.out.println("Service Type Found");
						result = true;
						break outerloop;
					}
					else if((serviceType.get(j).getText()).equals(sType)&& (action.equals("Delete"))){
						String temp = serviceType.get(j).getText();
						System.out.println(temp);
						//i[contains(@id,'appointmentschedulingui-delete-Mental Health') and (@data-appointment-type-id='9')]
						if (i==1){ index = 1+j;}
						if (i==2){ index = 11+j;}
						if (i==3){ index = 21+j;}
						String xpath = "//i[contains(@id,'delete-"+temp+"') and (@data-appointment-type-id='"+(index)+"')]";
						System.out.println(xpath);
						driver.findElement(By.xpath(xpath)).click();
						
						/*if (i==1){ index = 1+j;}
						if (i==2){ index = 11+j;}
						if (i==3){ index = 21+j;}*/
						
						xpath = "(//div[@id='delete-appointment-type-dialog']/following::button[contains(@class,'confirm')]//i)["+index+"]";
						System.out.println(xpath);
						try{
						driver.findElement(By.xpath(xpath)).click();
						}
						catch (Exception e){
							System.out.println(e.getMessage()+" The button is not clickable");
						}
						System.out.println("Service Type "+sType+"deleted");
						result = true;
						break outerloop;
					}
				} 
				driver.findElement(By.linkText("Next")).click();
			}
		return result;
	}
	public static boolean deleteServiceType(String serviceType){
		
		boolean result = false;
		int index =1;
		int pageCount = getPageCounts();
		outerloop:
			for(int i=1;i<=pageCount;i++){
				//In the current page storing all the service types in List
				List <WebElement> sType = driver.findElements(By.xpath("//table[@id='appointmentTypesTable']/tbody/tr/td[1]"));

				// To print the total no. of service types in the current page
				System.out.println("Total no. of service types in this page "+i+ " is "+sType.size());

				for(int j=0;j<sType.size();j++){
					//To print all the service types in the current page
					System.out.println(sType.get(j).getText());

					if((sType.get(j).getText()).equals(serviceType)){
						
						//String temp = sType.get(j).getText();
						//Printing the found service type 
						System.out.println("Service Type "+serviceType+" Found");
						//i[contains(@id,'appointmentschedulingui-delete-Mental Health') and (@data-appointment-type-id='9')]
						// Assigning the correct index value for selecting the correct delete button
						if (i==1){ index = 1+j;} // for page 1 -> serrviceTypes's indices
						if (i==2){ index = 11+j;} // for page 2 -> service Type's indices
						if (i==3){ index = 21+j;} // for page 3 -> service type's indices

						//finding the delete element corresponding to the service type which is stored in temp 
						//String xpath = "//i[contains(@id,'delete-"+temp+"') and (@data-appointment-type-id='"+(index)+"')]";
						String xpath = "//td[text()='"+serviceType+"']/following-sibling::td[3]/descendant::i[@title='Delete']";
						System.out.println(xpath);
						driver.findElement(By.xpath(xpath)).click();

						//finding the yes button with the same above index corresponding to the temp - above						
						//xpath = "(//div[@id='delete-appointment-type-dialog']/following::button[contains(@class,'confirm')]//i)["+index+"]";
						xpath = "(.//*[@id='delete-appointment-type-dialog']/div[2]/button[@class='confirm right'])["+index+"]";
						System.out.println(xpath);

						try{
							driver.findElement(By.xpath(xpath)).click();
							System.out.println("Service Type "+sType+" deleted");

							}
							catch (Exception e){
								System.out.println(e.getMessage()+" The button is not clickable");
							}
						result = true;
						break outerloop;
					
					}
				driver.findElement(By.linkText("Next")).click();	
				}
			} 
			return result;
				
			
	}
	
	public static boolean deleteServiceType2(String serviceName) throws InterruptedException{
	
		boolean result = false;
		int pageCount = getPageCounts();

		for (int i=1;i<=pageCount; i++){

			//In the current page storing all the service types in List
			List <WebElement> sType = driver.findElements(By.xpath("//table[@id='appointmentTypesTable']/tbody/tr/td[1]"));

			// To print the total no. of service types in the current page
			System.out.println("Total no. of service types in this page "+i+ " is "+sType.size());
		
			//Thread.sleep(3000);
			driver.findElement(By.xpath("//td[text()='"+serviceName+"']/following-sibling::td[3]/descendant::i[@title='Delete']")).click();
			List<WebElement> buttonList = driver.findElements(By.xpath(".//*[@id='delete-appointment-type-dialog']/div[2]/button[@class='confirm right']"));
			System.out.println("Number of Buttons" + buttonList.size());
			for(int j=0; j<buttonList.size(); i++){
		
				try{
					if(buttonList.get(j).isDisplayed() || buttonList.get(i).isEnabled()){
				
						buttonList.get(j).click();
						System.out.println(buttonList.get(j).getText());
						result= true;
						break;
					}
				}
				catch(Exception e){
			
					System.out.println("Element is not visible|| enabled"+e.getMessage());
				}
			}
			driver.findElement(By.linkText("Next")).click();
		}	
		return result;
	}

	@Test
	public static void CheckAvailability() throws Exception{

		openWebPage();
		login();
		selectOptionsHomePage();
		System.out.println(searchServiceType(sName));
//		action = "Search";
//		System.out.println(getServiceType(sName, action));
//		sName = "Surgery";
//		action = "Delete";
//		System.out.println(getServiceType(sName,action));
		boolean result = deleteServiceType(sName);
		System.out.println("The result of the deleteServiceType is "+result);
		
	}

}
