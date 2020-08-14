package aug11;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Explicit {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.navigate().to("https://www.icicidirect.com/");
		driver.manage().window().maximize();
		WebDriverWait wait= new WebDriverWait(driver, 300);
		//wait until my link is clicable
		wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Marke")));
		driver.findElement(By.partialLinkText("Marke")).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Market Sta")));	
		driver.findElement(By.partialLinkText("Market Sta")).click();
		//wait until element is present
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Daily Share Pric")));	
		driver.findElement(By.partialLinkText("Daily Share Pric")).click();	

	}

}
