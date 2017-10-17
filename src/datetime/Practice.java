package datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

/**
 * Java8新日期时间API的使用示例
 * 
 * @author zhang_jin[zhang_jin@suixingpay.com]
 *
 */
public class Practice {
	@Test
	public void today() {
		// 1.获取当天的日期
		LocalDate today = LocalDate.now();
		System.out.println(today);
	}

	@Test
	public void YearMonthDay() {
		// 2.获取当前的年月日
		LocalDate today = LocalDate.now();
		System.out.println("year:" + today.getYear());
		System.out.println("month:" + today.getMonthValue());
		System.out.println("day:" + today.getDayOfMonth());
	}

	@Test
	public void specialDate() {
		// 3.获取当天的日期
		LocalDate specialDate = LocalDate.of(2017, 10, 16);
		System.out.println(specialDate);
	}

	@Test
	public void isEqual() {
		// 4.检查两个日期是否相等
		LocalDate specialDate = LocalDate.of(2017, 10, 17);
		LocalDate today = LocalDate.now();
		if (today.equals(specialDate)) {
			System.out.println("日期为同一天");
		} else {
			System.out.println("日期不是同一天");
		}

	}

	@Test
	public void checkMonthDay() {
		// 5.检查重复事件，比如说生日
		// 使用MonthDay类。这个类由月日组合，不包含年信息，也就是说你可以用它来代表每年重复出现的一些日子。
		LocalDate dateOfBirth = LocalDate.of(1994, 10, 24);
		MonthDay birthDay = MonthDay.of(dateOfBirth.getMonthValue(), dateOfBirth.getDayOfMonth());
		LocalDate today = LocalDate.now();
		MonthDay currentMonthDay = MonthDay.from(today);
		if (currentMonthDay.equals(birthDay)) {
			System.out.println("今天是生日");
		} else {
			System.out.println("今天不是生日");
		}

	}

	@Test
	public void time() {
		// 6.获取当前时间
		LocalTime now = LocalTime.now();
		System.out.println(now);

	}

	@Test
	public void plusHours() {
		// 7.增加时间里面的小时数
		LocalTime now = LocalTime.now();
		LocalTime after2h = now.plusHours(2);
		System.out.println(after2h);

	}

	@Test
	public void nextWeek() {
		// 8.获取1周后的日期
		LocalDate today = LocalDate.now();
		// LocalDate nextWeek = today.plusWeeks(1);
		LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
		System.out.println(nextWeek);

	}

	@Test
	public void beforeOrAfter() {
		// 9.判断某个日期是在另一个日期的前面还是后面
		LocalDate today = LocalDate.now();
		// LocalDate nextWeek = today.plusWeeks(1);
		LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);

		if (today.isBefore(nextWeek)) {
			System.out.println("今天早于下周");
		}

	}

	@Test
	public void fixedDate() {
		// 10.表示固定的日期，比如信用卡过期时间
		// YearMonth yearMonth = YearMonth.parse("2018-09");
		YearMonth yearMonth = YearMonth.of(2018, Month.JANUARY);
		System.out.println(yearMonth);

	}

	@Test
	public void isLeapYear() {
		// 11.检查闰年
		if (LocalDate.now().isLeapYear()) {
			System.out.println("今年是闰年");
		} else {
			System.out.println("今年不是闰年");
		}

	}

	@Test
	public void period() {
		// 12.两个日期之间包含多少天，多少个月
		LocalDate today = LocalDate.now();
		LocalDate before = LocalDate.parse("2016-07-19", DateTimeFormatter.ISO_LOCAL_DATE);
		Period period = Period.between(before, today);
		System.out.println("period of days:" + period.getDays());
		System.out.println("period of years:" + period.getYears());
		System.out.println("period of months:" + period.toTotalMonths());
	}
	
	@Test
	public void date2Str() {
		// 13.日期转换为字符串，并且格式化
		LocalDateTime now = LocalDateTime.now();
		String formatedDateTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		System.out.println(formatedDateTime);
	}
	
	@Test
	public void str2Date() {
		// 14.字符串转换为日期
		String dateStr = "20170907";
		LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyyMMdd"));
		LocalDate minusDays = date.minusDays(1);
		String format = minusDays.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		System.out.println(format);
	}
}
