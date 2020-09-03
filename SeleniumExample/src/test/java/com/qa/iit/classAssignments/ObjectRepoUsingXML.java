package com.qa.iit.classAssignments;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ObjectRepoUsingXML {
	
	String mobTestingText;
	String email;
	String signup;

	@Test
	public void objectRepoUsingXML() throws DocumentException, Exception{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/guru99home/");
		driver.manage().window().maximize();
		readXML();
		driver.findElement(By.xpath(mobTestingText)).click();
		driver.navigate().back();
		Thread.sleep(5000);
		driver.findElement(By.xpath(email)).sendKeys("testingmail@gmail.com");
		driver.findElement(By.xpath(signup)).click();
	}
	public void readXML() throws DocumentException{
		File file = new File(System.getProperty("user.dir")+"\\properties.xml");
		SAXReader saxReader = new SAXReader();
		Document doc = saxReader.read(file);
		mobTestingText = doc.selectSingleNode("//menu/mobiletesting").getText();
		email = doc.selectSingleNode("//menu/email").getText();
		signup = doc.selectSingleNode("//menu/signup").getText();
	}

}
