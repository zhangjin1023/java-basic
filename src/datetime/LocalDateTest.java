package datetime;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;

public class LocalDateTest {
	
	public static void main(String[] args) {
		//1.current date,默认格式为"yyyy-MM-dd"
		LocalDate now = LocalDate.now();
		System.out.println("current date: " + now);
		
		//2.creating localdate by providing input args
		LocalDate date = LocalDate.of(2017, Month.JANUARY, 1);
		System.out.println(date);
		
		//3.try creating date by providing invalid args
		/**
		 * Exception in thread "main" java.time.DateTimeException: Invalid date 'FEBRUARY 30'
		 */
//		LocalDate date2 = LocalDate.of(2017, Month.FEBRUARY , 30);
//		System.out.println(date2);
		
		//4.current date in America/Chicago
		LocalDate date3 = LocalDate.now(ZoneId.of("America/Chicago"));
		System.out.println(date3);
		
		//5.getting days from the base date 1970-01-01
		LocalDate ofEpochDay = LocalDate.ofEpochDay(365);
		System.out.println(ofEpochDay);
		
		//N days of year
		LocalDate ofYearDay = LocalDate.ofYearDay(2017, 280);
		System.out.println(ofYearDay);
		
	}

}
