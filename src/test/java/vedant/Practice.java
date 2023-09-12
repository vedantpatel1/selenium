package vedant;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Practice {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		
		WebDriver driver= new FirefoxDriver();
		/*
		 * //Button 1 driver.get("https://demoqa.com/alerts");
		 * 
		 * driver.findElement(By.id("alertButton")).click(); //alertButton click
		 * 
		 * Alert a= driver.switchTo().alert();
		 * 
		 * a.accept();
		 * 
		 * 
		 * 
		 * //Button 2
		 * 
		 * driver.findElement(By.id("timerAlertButton")).click(); //alertButton click
		 * 
		 * WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		 * 
		 * wait.until(ExpectedConditions.alertIsPresent()); // Wait until the alert is
		 * present
		 * 
		 * Alert b= driver.switchTo().alert();
		 * 
		 * b.accept();
		 * 
		 * 
		 * //Button 3 driver.findElement(By.id("confirmButton")).click(); //alertButton
		 * click
		 * 
		 * WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
		 * 
		 * wait1.until(ExpectedConditions.alertIsPresent()); // Wait until the alert is
		 * present
		 * 
		 * Alert a3= driver.switchTo().alert();
		 * 
		 * a3.accept();
		 * 
		 * 
		 * 
		 * //Button 4 driver.findElement(By.id("promtButton")).click(); //alertButton
		 * click
		 * 
		 * WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(10));
		 * 
		 * wait2.until(ExpectedConditions.alertIsPresent()); // Wait until the alert is
		 * present
		 * 
		 * Alert a2= driver.switchTo().alert();
		 * 
		 * a2.sendKeys("vedant");
		 * 
		 * a2.accept();
		 */
			
		//drag and drop
			driver.get("https://demoqa.com/droppable");
			Actions a5= new Actions(driver);
			a5.dragAndDrop(driver.findElement(By.id("draggable")), 
					driver.findElement(By.id("droppable"))).build().perform();
			
			
			
	}

	
}
