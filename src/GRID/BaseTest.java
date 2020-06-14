package GRID;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseTest {
	
	@Parameters("browser")
	@Test()
	public void login(String browser) throws MalformedURLException
	{   
		System.out.println("The browser is :"+browser);
		DesiredCapabilities cap=null;
		WebDriver driver=null;

		
		if(browser.equalsIgnoreCase("chrome"))
		{
			cap=new DesiredCapabilities().chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
		}
		else
			if(browser.equalsIgnoreCase("firefox"))
		{
			cap=new DesiredCapabilities().firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.WINDOWS);
		}
		
		driver=new RemoteWebDriver(new URL("http://192.168.1.50:4444/wd/hub"), cap);
		driver.get("http://facebook.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("email")).sendKeys("shubhamsinha2310@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("shubh@8560");
		driver.findElement(By.id("u_0_b")).click();
		
		driver.quit();
		
	}

}
