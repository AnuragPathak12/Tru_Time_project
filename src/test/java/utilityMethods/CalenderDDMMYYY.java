package utilityMethods;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;

public class CalenderDDMMYYY {
	
//	Getting current Month from system
	
	public String localCurrentMonth() {

		int monthNumber = YearMonth.now().getMonthValue();
        String monthName = Month.of(monthNumber).name();
        
        monthName = monthName.toLowerCase();

        // Capitalize the first letter of the month
        monthName = monthName.substring(0, 1).toUpperCase() + monthName.substring(1);
 
        return monthName;
	}
	
//	Getting current Year from system
	
	public String localCurrentYear() {
		String currentYear = Integer.toString(YearMonth.now().getYear());
		return currentYear;
	}
	

//	Getting current date in {Tue, 13 Feb} format
	
	public String localHighlightedDayDateFormat() {
		
		LocalDate currentDate = LocalDate.now();

        // Format the date as "Fri, 09 Feb"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd MMM", Locale.ENGLISH);
        String formattedDate = currentDate.format(formatter);

        System.out.println(formattedDate);
        return formattedDate;
	}
	
//	Getting all current week dates in {Tue, 13 Feb} format
	
	public ArrayList<String> localWeekDates() {
		
		ArrayList<String> myDates = new ArrayList<String>();
		LocalDate currentDate = LocalDate.now();
        int dayOfWeek = currentDate.getDayOfWeek().getValue();
        LocalDate sundayOfCurrentWeek = currentDate.minusDays((dayOfWeek)%7);
        
        for(int i=0;i<7;i++) {
        	LocalDate currentDateInWeek = sundayOfCurrentWeek.plusDays(i);
        	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd MMM");
        	String formattedDate = currentDateInWeek.format(formatter);
        	myDates.add(formattedDate);
        }
        
        return myDates;
	}
	
//	Getting date 15 days before
	
	public String date15DaysBefore() {
		
		LocalDate today = LocalDate.now();
		
        LocalDate dateBefore15Days = today.minusDays(15);
        DateTimeFormatter formatterr = DateTimeFormatter.ofPattern("E, dd MMM", Locale.ENGLISH);
        String formatteddDate = dateBefore15Days.format(formatterr);
        System.out.println("Date 15 days before today: " + formatteddDate);
		
		return formatteddDate;
	}
	
}
