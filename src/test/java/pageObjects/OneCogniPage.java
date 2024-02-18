package pageObjects;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilityMethods.ScreenshotTaker;

public class OneCogniPage {
	public WebDriver driver;
	public static String beHandle, oneCogniHandle;
	
//	Constructor
	
	public OneCogniPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
//	Locators
	
	By inpSearch = By.id("oneC_searchAutoComplete");
	By btnSearch = By.xpath("//li[@class = 'oneC_searchbar']/div");
	By btnTruTime = By.xpath("//div[@id = 'newSearchAppsLST']/div[1]/div//div[contains(text(), 'TruTime ')]");
	By txtTruTime = By.linkText("My TruTime");
	
	
//	Method to handle One Cognizant page and switching to it
	
	public void switchToOneCogniHandle() {
		Set<String> handles = driver.getWindowHandles();
		for(String handle: handles) {
			
			driver.switchTo().window(handle);
			if(driver.getTitle() == "Be.Cognizant - Home") {
				continue;
			} else {
				oneCogniHandle = handle;
			}
			
		}
	}
	
//	Click on Search button 
	
	public void clickOnSearch() {
		
		ScreenshotTaker.oneCogniScreenshot(driver);
		driver.findElement(inpSearch).click();
	}
	
//	Search for TruTime
	
	public void searchTruTime(String txt) throws InterruptedException {
		driver.findElement(inpSearch).sendKeys(txt);
		Thread.sleep(5000);
		driver.findElement(btnSearch).click();
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.elementToBeClickable(btnTruTime));
		driver.findElement(btnTruTime).click();
		Thread.sleep(5000);
		
	}
	
//	Method to verify TruTime opened or not
	
	public boolean verifyTruTimePage() {
	
		ScreenshotTaker.truTimeScreenshot(driver);
		driver.switchTo().frame("appFrame");
		
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement truTimeEle = wait2.until(ExpectedConditions.visibilityOfElementLocated(txtTruTime));
		return truTimeEle.isDisplayed();
	}
	
	
}
