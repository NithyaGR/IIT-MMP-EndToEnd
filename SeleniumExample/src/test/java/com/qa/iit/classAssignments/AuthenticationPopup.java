package com.qa.iit.classAssignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthenticationPopup {
	
	@Test
	public void popupAuthentication(){
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		System.getProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		
		String userName = "admin";//"usq\\govingo";
	    String password = "admin";//"234sDrg@qw!";
	    String URL = "http://"+userName+":"+password+"@the-internet.herokuapp.com/basic_auth";
	    driver.get(URL);
		/*//driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		//driver.get("http://"+"admin"+":admin"+"@the-internet.herokuapp.com/basic_auth");
	    WebDriverWait wait = new WebDriverWait(driver, 10);

	    Alert alert = wait.until(ExpectedConditions.alertIsPresent()); 
	    //UserAndPassword uAp = new UserAndPassword(userName, password);
	    //driver.switchTo().alert().authenticateUsing(uAp);
	    driver.switchTo().alert();
	    alert.authenticateUsing(new UserAndPassword(userName, password));*/
				
	}
	
}
