package utilityMethods;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotTaker {
	
	public static void beCogniScreenshot(WebDriver driver) {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File homeSRC = ts.getScreenshotAs(OutputType.FILE);
		File homePageLOC = new File(System.getProperty("user.dir") + "//ScreenShots//beCogniSC.png");
		try {

			FileUtils.copyFile(homeSRC, homePageLOC);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	public static void oneCogniScreenshot(WebDriver driver) {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File homeSRC = ts.getScreenshotAs(OutputType.FILE);
		File homePageLOC = new File(System.getProperty("user.dir") + "//ScreenShots//oneCogniSC.png");
		try {

			FileUtils.copyFile(homeSRC, homePageLOC);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void truTimeScreenshot(WebDriver driver) {
	
		TakesScreenshot ts = (TakesScreenshot) driver;
		File homeSRC = ts.getScreenshotAs(OutputType.FILE);
		File homePageLOC = new File(System.getProperty("user.dir") + "//ScreenShots//truTimerSC.png");
		try {

			FileUtils.copyFile(homeSRC, homePageLOC);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}

