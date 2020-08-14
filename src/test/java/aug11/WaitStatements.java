package aug11;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WaitStatements {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.navigate().to("https://www.icicidirect.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.partialLinkText("Marke")).click();
		driver.findElement(By.partialLinkText("Market Sta")).click();
		driver.findElement(By.partialLinkText("Daily Share Pric")).click();

	}

}
