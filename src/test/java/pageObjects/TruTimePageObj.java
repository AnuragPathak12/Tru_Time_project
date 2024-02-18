package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilityMethods.CalenderDDMMYYY;
import utilityMethods.ExcelUtilityFile;
import utilityMethods.WritingPattern;

public class TruTimePageObj {
	
	public WebDriver driver;
	public static String path = System.getProperty("user.dir") + ".\\ExcelFile\\OutputData.xlsx";

//	Constructor
	
	public TruTimePageObj(WebDriver driver){
		this.driver = driver;

	}
	
//	Locators
	
	ArrayList<String> legendAl = new ArrayList<String>();
	ArrayList<String> truTimeDates = new ArrayList<String>();
	CalenderDDMMYYY myCalender = new CalenderDDMMYYY();
	String[] legendsArray = new String[15];
	String[] trutimeDateArray = new String[7];
	By truTimeMonth = By.xpath("//div[@class = 'ui-datepicker-title']/span[1]");
	By truTimeYear = By.xpath("//div[@class = 'ui-datepicker-title']/span[2]");
	By txtBackdated = By.cssSelector("span.topupavailablefromDate");
	By legends = By.xpath("//ul[@class = 'legend-labels']/li");
	By txtHighlighted = By.xpath("//div[@ng-if = 'item.Date==activeDate']");
	
	
//	Get current month mentioned on TruTime page
	public String getMonth() {
		String mon = driver.findElement(truTimeMonth).getText();
		System.out.println(mon);
		return mon;
	}
	
	
//	Get current year mentioned on TruTime page
	
	public String getYear() {
		String year = driver.findElement(truTimeYear).getText();
		System.out.println(year);
		return year;
	}
	
//	Get mentioned backdated TopUp date on TruTime page
	
	public String backDatedTopUp() throws IOException {
		
		String backdateTopUp = driver.findElement(txtBackdated).getText();
		ExcelUtilityFile.setCellData(path, "Sheet1", 2, 0, backdateTopUp);
		return backdateTopUp;
	}
	
//	Get the size of the Lengends present and print them
	
	public int getLegends() {
		
		int j=0;
		for(int i =2; i<=30; i+=2) {
			WebElement legends = driver.findElement(By.xpath("//ul[@class = 'legend-labels']/li["+i+"]"));
			String txtLegend = legends.getText();
			legendsArray[j] = legends.getText();
			j++;
			legendAl.add(txtLegend);
			System.out.println(txtLegend);
		}
		System.out.println(legendAl.size());
		
		WritingPattern.writingLegends(legendsArray);
		
		return legendAl.size();
		
	}
	
//	Getting current highlighted date
	
	public String getCurrentHighlightedDay() {
		System.out.println(driver.findElement(txtHighlighted).getText());
		
		return driver.findElement(txtHighlighted).getText();
	}
	
	
//	Comparing current week TruTime dates with the Local dates
	
	public boolean getCurrentWeekDatesInTruTime() throws IOException {
		
		
		List<WebElement> currentTruTimeDates = driver.findElements(By.xpath("//div[@class='weekContainer']//div[contains(@class,'dayHeadr')]"));
	   	
		for(int i=0;i<7;i++) {
	   		truTimeDates.add(currentTruTimeDates.get(i).getText());
	   	 }
		
		System.out.println("TruTime Dates size "+truTimeDates.size());
		
		boolean flag = true;
		for(int j=0; j<7; j++) {
			if(truTimeDates.get(j).equals(myCalender.localWeekDates().get(j))) {
				
				System.out.println(truTimeDates.get(j));
				trutimeDateArray[j] = truTimeDates.get(j);
				
			} else {
				flag = false;
			}
		}
		WritingPattern.writingTruTimeDates(trutimeDateArray);
		return flag;
	}
}
