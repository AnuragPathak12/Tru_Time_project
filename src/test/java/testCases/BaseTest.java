package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {
	public static WebDriver driver;
	
	@BeforeTest
	@Parameters({"browser"})
	public void setup(String br) {
		
		if(br.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx");
		}
		else if(br.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			driver.get("https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx");
		}
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
