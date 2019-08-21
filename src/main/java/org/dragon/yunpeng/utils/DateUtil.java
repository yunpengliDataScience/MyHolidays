package org.dragon.yunpeng.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

  // Test if a given date is a business day.
  public static boolean isNotBusinessDay(Date date) {

    boolean isNotBusinessDay = HolidayObserver.isHoliday(date) || WeekendDayUtil.isWeekend(date);

    return isNotBusinessDay;
  }

  // Get the preceding business date of a given date
  public static Date getPrecedingBusinessDay(Date givenDate) {

    Calendar calendar = Calendar.getInstance();
    calendar.setTime(givenDate);
    calendar.add(Calendar.DATE, -1);
    Date precedingDate = calendar.getTime();

    while (isNotBusinessDay(precedingDate)) {

      calendar.add(Calendar.DATE, -1);
      precedingDate = calendar.getTime();
    }

    return precedingDate;
  }

  // Get the succeeding business date of a given date
  public static Date getSucceedingBusinessDay(Date givenDate) {

    Calendar calendar = Calendar.getInstance();
    calendar.setTime(givenDate);
    calendar.add(Calendar.DATE, 1);
    Date succeedingDate = calendar.getTime();

    while (isNotBusinessDay(succeedingDate)) {

      calendar.add(Calendar.DATE, 1);
      succeedingDate = calendar.getTime();
    }

    return succeedingDate;
  }

  public static Date getDateBeforeToday(int daysBefore) {

    Date today = new Date();

    Calendar calendar = Calendar.getInstance();
    calendar.setTime(today);
    calendar.add(Calendar.DATE, -daysBefore);
    Date succeedingDate = calendar.getTime();

    System.out
        .println("\"" + succeedingDate + "\" is the date of " + daysBefore + " days ago of today.");

    return succeedingDate;
  }

  public static long getDaysBetween(Date d1, Date d2) {
    return (long) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
  }

  public static void main(String[] args) throws ParseException {

    // testPrecedingSucceedingBusinessDates();

    getDateBeforeToday(35);

    getDateBeforeToday(30);

    testDaysBetween();
  }

  private static void testDaysBetween() {

    Calendar cal1 = new GregorianCalendar();
    Calendar cal2 = new GregorianCalendar();

    cal1.set(2019, 7, 17);
    cal2.set(2019, 8, 21);

    System.out.println("Days= " + getDaysBetween(cal1.getTime(), cal2.getTime()));
  }

  private static void testPrecedingSucceedingBusinessDates() throws ParseException {
    String[] dates = {"11/12/2018", "01/22/2019", "08/01/2019", "10/11/2019"};

    for (String dateStr : dates) {

      Date date = new SimpleDateFormat("MM/dd/yyyy").parse(dateStr);

      Date precedingDate = getPrecedingBusinessDay(date);
      Date succeedingDate = getSucceedingBusinessDay(date);

      System.out.println("Preceding business day of " + date + " is " + precedingDate + ".");
      System.out.println("Succeeding business day of " + date + " is " + succeedingDate + ".");
    }
  }

}
