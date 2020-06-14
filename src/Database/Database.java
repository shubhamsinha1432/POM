package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Database {

	WebDriver driver= null;
	public void setup() 
	{

		System.setProperty("webdriver.chrome.driver", "C://Users//Dell//Desktop//POM//Driver Files//chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://newtors.demoaut.com");
		
	}
	
	@Test(enabled=false)
	public void login() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/database1","root","Shubh@1432");
		Statement stmt=conn.createStatement();
		java.sql.ResultSet rs=stmt.executeQuery("Select * from data");
		while(rs.next())
		{
			driver.findElement(By.name("userName")).sendKeys(rs.getString(1));
			driver.findElement(By.name("password")).sendKeys(rs.getString(2));
			driver.findElement(By.name("login")).click();
			driver.navigate().back();
		}
		
	}

	
	

}
