package com.ups.winappdriver;

import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;

import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

public class NotepadTest {
	
	public static WindowsDriver driver = null;
	
	
	@BeforeClass
	public void setUP(){
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("app", "C:\\Windows\\System32\\notepad.exe");
		cap.setCapability("platformName", "windows");
		cap.setCapability("deviceName", "windows10");
		
		try {
			driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
	}
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
  }
  
  @Test
  public void testNotepad(){
	  driver.findElementByName("Text Editor").sendKeys("This is helllo world");
	  String s = driver.findElementByName("Text Editor").getText();
	  System.out.println("text entered .............."+s);
	  driver.findElement(By.name("Help")).click();
	  driver.findElementByName("About Notepad").click();
	  driver.findElementByName("OK").click();
	  driver.findElementByName("Close").click();
	  driver.findElementByName("Don't Save").click();
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
}
