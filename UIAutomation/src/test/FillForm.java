/**
 * 
 */
package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * @author Fredrick
 *
 */
@Test
public class FillForm {
	WebDriver driver;
	    //Set driver		
		@Test(priority = 1)
		public void OpenBrowser() throws InterruptedException{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.ultimateqa.com/filling-out-forms/");
			driver.manage().window().maximize();
			Thread.sleep(100);
		}
		//Verify Homepage Title
		@Test(priority = 2)
		public void VerifyHomepageTitle() throws InterruptedException {
			String expectedPageTitle = "Filling Out Forms - Ultimate QA";
			String actualPageTitle = "";
			System.out.println(expectedPageTitle);
			actualPageTitle = driver.getTitle();
			System.out.println(actualPageTitle);
			if (actualPageTitle.contains(expectedPageTitle)){
				System.out.println("Test Pass");
				}
			else {
				System.out.println("Test Fail");		
			}
			Thread.sleep(10);
		}
		//Fill Form
			@Test(priority = 3)
			public void FillForms() throws InterruptedException
			{
				//Name
				driver.findElement(By.xpath("//*[@id='et_pb_contact_name_0']")).sendKeys("Fredrick");
				//Message
				driver.findElement(By.xpath("//*[@id='et_pb_contact_message_0']")).sendKeys("Testing UI");
				//Submit
				driver.findElement(By.xpath("//*[@id='et_pb_contact_form_0']/div[2]/form/div/button")).click();
				Thread.sleep(2000);
				//WebDriverWait wait = new WebDriverWait(driver, 15);
				//wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='et_pb_contact_form_0']/div/p"), "Time left: 7 seconds"));
			}
			
			//Verify success text message
			@Test(priority = 4)
			public void VerifySuccessMessage() throws InterruptedException {
				//WebDriverWait wait = new WebDriverWait(driver, 15);
				//wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='et_pb_contact_form_0']/div/p"), "Time left: 7 seconds"));
			WebElement element=driver.findElement(By.xpath("//*[@id='et_pb_contact_form_0']/div/p"));
			//To store the text of a WebElement in a string
			String text = element.getText();
			//For printing the text in console output
			System.out.println("Text obtained is  "+ text);
			if(text.contains("Form filled out successfully"))
					{
			System.out.println("Expected text is obtained");
			}else{
			System.out.println("Expected text is not obtained");

			}
		}}
