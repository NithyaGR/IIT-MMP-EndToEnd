package com.qa.iit.classAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
	
	/*
	 *Enter all the required fields to register a patient 
	 */
	
	public static WebDriver driver;
	public static WebElement we;
	//Page Elements *******************
	//Personal details
	static By firstNameTBox = By.id("firstname");
	static By LastNameTBox = By.id("lastname");
	static By licenseTBox = By.id("license");
	static By SSNTBox = By.id("ssn");
	static By stateTBox = By.id("state");
	static By cityTBox = By.id("city");
	static By addressTBox = By.id("address");
	static By zipTBox = By.id("zipcode");
	static By ageTBox = By.id("age");
	static By heightTBox = By.id("height");
	static By weightTBox = By.id("weight");
	static By PharmacyTBox = By.id("pharmacy");
	static By PharmacyAddressTBox = By.id("pharma_adress");
	//Account Details
	static By emailTBox = By.id("email");
	static By passwordTBox = By.id("password");
	static By userNameTBox = By.id("username");
	static By confirmPasswordTBox = By.id("password");
	static By securityQnDD = By.id("security");
	static By answerTBox = By.id("answer");
	static By saveBtn = By.id("save");
	
	/* page initialization ***************
	 * public Registration(){
	 * 
	 * }
	 */
	
	
	// page actions ***************************
	public static void getpersonalDetails(){
		
	}
	
	public static void getAccountDetails(){
		
	}
	
	public static void clickEdit(){
		
	}
	
	public static void clickSave(){
		
	}

}
