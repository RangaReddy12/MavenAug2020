package aug10;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class CrossBrowser {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
@Parameters({"Browser"})	
@BeforeTest
public void beforeTest(String brw) 
{
report= new ExtentReports("./ExtentReports/Reports.html");	
if(brw.equalsIgnoreCase("chrome"))
{
	System.out.println("Executing on chrome");
driver= new ChromeDriver();
}
else if(brw.equalsIgnoreCase("firefox"))
{
	System.out.println("Executing on firefox");
	driver= new FirefoxDriver();
}
else
{
	System.out.println("Browser value is not matching");
}
 }
  @Test(dataProvider = "supplydata")
  public void validatelogin(String username,String password) throws Throwable
  {
	test=report.startTest("Login Test");
	driver.get("http://orangehrm.qedgetech.com/");
	driver.manage().window().maximize();
	driver.findElement(By.name("txtUsername")).sendKeys(username);
	driver.findElement(By.name("txtPassword")).sendKeys(password);
	driver.findElement(By.name("Submit")).click();
	Thread.sleep(3000);
	if(driver.getCurrentUrl().contains("dash"))
	{
		Reporter.log("Login success",true);
		test.log(LogStatus.PASS, "Login Success");
	}
	else
	{
	String mesage=driver.findElement(By.id("spanMessage")).getText();
	Reporter.log(mesage,true);
	test.log(LogStatus.FAIL, mesage);
	}
  }
  @DataProvider
  public Object[][] supplydata() {
   Object login[][]= new Object[4][2];
   login[0][0]="Admin";
   login[0][1]="Qedge123!@#";
   login[1][0]="test";
   login[1][1]="Qedge123!@#";
   login[2][0]="Admin";
   login[2][1]="Qedge123!@#";
   login[3][0]="Admin";
   login[3][1]="test";
   return login;
  }
  @AfterTest
  public void afterTest()
  {
	  report.endTest(test);
	  report.flush();
	  driver.close();
  }

}
