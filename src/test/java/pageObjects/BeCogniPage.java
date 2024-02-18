package pageObjects;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilityMethods.ExcelUtilityFile;
import utilityMethods.ScreenshotTaker;

public class BeCogniPage {
	public WebDriver driver;
	public static String path = System.getProperty("user.dir") + ".\\ExcelFile\\OutputData.xlsx";
//	Constructor
	
	public BeCogniPage(WebDriver driver){
		this.driver = driver;

	}
	
//	Locators
	
	By settingLogo = By.xpath("//button[@title = 'Settings']/div/span");
	By accManagerLogo = By.xpath("//div[@class='ohcfXYh6LUBy5DS5kNUjRQ==']");
	By nameElement = By.id("mectrl_currentAccount_primary");
	By emailElement = By.id("mectrl_currentAccount_secondary");
	By join = By.xpath("//div[@id=\"4f7e87d5-f184-4501-8008-0ee4b0a38fcf\"]");
	By oneCogniApp = By.xpath("//div[@title='OneCognizant']");
	
	
//	Method to perform click action on user profile
	
	public void clickAccDetails() throws InterruptedException {
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(settingLogo));
		Thread.sleep(5000);
		WebElement btn= driver.findElement(accManagerLogo);
		btn.click();
		
		ScreenshotTaker.beCogniScreenshot(driver);
	}
 
//	Method to capture user name
	
	public String getAccManagerName() throws InterruptedException, IOException {
		WebElement txtName = null;
		try{
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
		txtName= wait2.until(ExpectedConditions.visibilityOfElementLocated(nameElement));

		}catch(TimeoutException e) {
			try{
				WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
				txtName= wait2.until(ExpectedConditions.visibilityOfElementLocated(nameElement));
			} catch(NoSuchElementException v) {
				v.getMessage();
			}
		}
		ExcelUtilityFile.setCellData(path, "Sheet1", 0, 0, txtName.getText());
		return txtName.getText();
	}
	
//	Method to capture user email
	
	public String getAccManagerEmail() throws InterruptedException, IOException {
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement txtEmail= wait3.until(ExpectedConditions.visibilityOfElementLocated(emailElement));
		Thread.sleep(9000);
		
		ExcelUtilityFile.setCellData(path, "Sheet1", 1, 0, txtEmail.getText());
		return txtEmail.getText();
	}
	
//	Method to get One Cognizant present
	
	public String verifyOneCogni() throws InterruptedException {
		
		WebElement AroundCogni = driver.findElement(join);
		JavascriptExecutor js = (JavascriptExecutor)driver ;
		js.executeScript("arguments[0].scrollIntoView(true);", AroundCogni);
		Thread.sleep(5000); 
		WebElement webapp = driver.findElement(oneCogniApp);
		return webapp.getText();
	}
	
//	If One Cognizant is present click on it
	
	public void clickOnOneCogni() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(oneCogniApp).click();
	}	
}
