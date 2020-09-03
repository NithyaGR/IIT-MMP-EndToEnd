package com.qa.iit.classAssignments;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.FindBy;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginOrRegisterPatientPage {
	
	/**
	 * This NAMTG (North American Medical Tech Group) lets their patients to register 
	 * in to the NAMTG's web application - called Manage My Patient
	 * In this patient portal, to automate a test case of registering a patient we create a separate class
	 * LoginOrRegisterPatientPage - 
	 * In the developed frame work, this class will be stored in a package com.qa.NAMTGMMP.pages
	 * This class will have 3 parts page elements, page initialization, page actions - while using
	 * the frameworks concepts.
	 * The elements will be - Patient Login, Office Login, Login, Register, Login for Admin.
	 * Page actions will be - verification of title, verification of the above elements' enabled and
	 * displayed status
	 * 
	 * 
	 */
	public static WebDriver driver;
	public static WebElement we;
	public static JavascriptExecutor js;
	public static Actions act;
	
	// Page Elements ************
	  static By patientLoginMenu = By.linkText("Patient Login");
	  static By officeLoginMenu = By.linkText("Office Login");
	  static By patientLoginBtn = By.xpath("//div[contains(@class,'col-md-4')]//following-sibling::a[text()='Login']");
	  static By patientRegisterBtn = By.xpath("//div[contains(@class,'col-md-4')]//following-sibling::a[text()='Register']");
	  static By officeLoginBtn = By.xpath("//div[contains(@class,'col-md-4')]//following-sibling::a[@href='admin/login.php']");
	 //static @FindBy(linkText="Patient Login") WebElement patientLoginMenu;
	 //static @FindBy(linkText="Register") WebElement patientRegisterBtn;
	 //static @FindBy(linkText="Login") WebElement patientLoginBtn;
	 //static @FindBy(linkText="Office Login") WebElement officeLoginMenu;
	 //static @FindBy(xpath="(//a[text()='Login'])[2]") WebElement officeLoginBtn;
	  
	
	/*page initialization*******
	 * public LoginOrRegisterPatientPage(){
	 * PageFactory.initElements(driver.this);
	 * }
	 *
	 */
	  
	  //page actions ***********
	public static void openApplication(){
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	public static String verifyTitle(){
		
		return driver.getTitle();
		
	}
	
	public static boolean clickPatientLoginMenu(){
		
		boolean result = false;
		we = driver.findElement(patientLoginMenu);
		if((we.isDisplayed()) && (we.isEnabled())){
			result = true;
			we.click();
		}
		result = true;
		return result;
		
	}
	
	public static boolean clickPatientRegisterBtn(){
		
		boolean result = false;
		we = driver.findElement(patientRegisterBtn);
		if(we.isDisplayed() && we.isEnabled()){
			result = true;
			ScrollToView(we);
			System.out.println("patientRegisterBtn is clicked");
		}
		
		return result;
	}
	
	public static boolean clickPatientLoginBtn(){
		
		boolean result = false;
		we = driver.findElement(patientLoginBtn);
		if(we.isDisplayed() && we.isEnabled()){
			result = true;
			we.click();
			System.out.println("patientLoginBtn is clicked");
		}
		return result;
	}
	
	public static boolean clickOfficeLoginMenu(){
		
		boolean result = false;
		we = driver.findElement(officeLoginMenu);
		if((we.isDisplayed())&& (we.isEnabled())){
			result = true;
			we.click();
		}
		return result;
	}
	
	public static boolean clickOfficeLoginBtn(){
		
		boolean result = false;
		we = driver.findElement(officeLoginBtn);
		if((we.isDisplayed())&& (we.isEnabled())){
			result = true;
			//act = new Actions(driver);
			//act.moveToElement(we).click().build().perform();
			ScrollToView(we);
			System.out.println("OfficeLogin is clicked" );
		}
		return result;
	}
	
	public static void ScrollToView(WebElement we){
		
	 js = (JavascriptExecutor)driver;
	 js.executeScript("arguments[0].click();", we);
	 //js.executeScript("arguments[0].scrollIntoView(true);",we);
	 //we.click(); - Stale ElementReference Exception
		
	}
	public static void main(String[] args) {
		
		//LoginOrRegisterPatientPage LRPage = new LoginOrRegisterPatientPage();
		openApplication();
		System.out.println(verifyTitle());
		//System.out.println(clickPatientLoginMenu());
		System.out.println(clickOfficeLoginMenu());
		//System.out.println(clickPatientRegisterBtn());
		//System.out.println(clickPatientLoginBtn());
		System.out.println(clickOfficeLoginBtn());
	}
	
	
	

}
