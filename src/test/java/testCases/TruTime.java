package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.TruTimePageObj;
import utilityMethods.CalenderDDMMYYY;

public class TruTime extends BaseTest{
	
	TruTimePageObj ttpo;
	CalenderDDMMYYY my = new CalenderDDMMYYY();
	
	@Test(priority = 1)
	public void validateCurrentMonthAndYear() {
		ttpo = new TruTimePageObj(driver);
		SoftAssert as1 = new SoftAssert();
		as1.assertEquals(ttpo.getMonth(), my.localCurrentMonth());
		as1.assertEquals(ttpo.getYear(), my.localCurrentYear());
		as1.assertAll();
	}
	
	@Test(priority = 2)
	public void validateBackDatedTopUp() throws IOException {
		Assert.assertEquals(ttpo.backDatedTopUp(), my.date15DaysBefore());
	}
	
	@Test(priority = 3)
	public void printLegends() {
//		ttpo.getLegends();
//		System.out.println(ttpo.getLegends().size());
		Assert.assertEquals(ttpo.getLegends(),15);
	}
	
	@Test(priority = 4)
	public void validateCurrentHighlightedDate() {
		Assert.assertEquals(ttpo.getCurrentHighlightedDay(), my.localHighlightedDayDateFormat());
	}
	
	@Test(priority = 5)
	public void validateTruTimeDates() throws IOException {
		
		Assert.assertEquals(ttpo.getCurrentWeekDatesInTruTime(), true);
	}
}
