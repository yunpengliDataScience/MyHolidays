/**
 * Idea borrowed from:
 * https://www.javaworld.com/article/2077543/java-tip-44--calculating-holidays-and-their-observances.html
 * 
 */
package org.dragon.yunpeng.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class HolidayObserver {


  // New Year's Day. If it is on Sunday, the following Monday will be observed. If it is on
  // Saturday, the Friday of the previous year will be observed.
  public static GregorianCalendar getNewYearsDay(int nYear) {

    int nMonth = Calendar.JANUARY; // January
    int nMonthDecember = Calendar.DECEMBER; // December

    GregorianCalendar dtD = new GregorianCalendar(nYear, nMonth, 1);
    int nX = dtD.get(Calendar.DAY_OF_WEEK);

    switch (nX) {
      case Calendar.SUNDAY: // Sunday
        return new GregorianCalendar(nYear, nMonth, 2);
      case Calendar.MONDAY: // Monday
      case Calendar.TUESDAY: // Tuesday
      case Calendar.WEDNESDAY: // Wednesday
      case Calendar.THURSDAY: // Thursday
      case Calendar.FRIDAY: // Friday
        return new GregorianCalendar(nYear, nMonth, 1);
      default:
        // Saturday, then observe on friday of previous year
        return new GregorianCalendar(--nYear, nMonthDecember, 31);
    }
  }

  // Martin Luther King Day is observed on the third Monday in January.
  public static GregorianCalendar getMartinLutherKingDay(int nYear) {
    // Third Monday in January
    int nMonth = Calendar.JANUARY; // January

    GregorianCalendar dtD = new GregorianCalendar(nYear, nMonth, 1);
    int nX = dtD.get(Calendar.DAY_OF_WEEK);

    switch (nX) {
      case Calendar.SUNDAY: // Sunday
        return new GregorianCalendar(nYear, nMonth, 16);
      case Calendar.MONDAY: // Monday
        return new GregorianCalendar(nYear, nMonth, 15);
      case Calendar.TUESDAY: // Tuesday
        return new GregorianCalendar(nYear, nMonth, 21);
      case Calendar.WEDNESDAY: // Wednesday
        return new GregorianCalendar(nYear, nMonth, 20);
      case Calendar.THURSDAY: // Thursday
        return new GregorianCalendar(nYear, nMonth, 19);
      case Calendar.FRIDAY: // Friday
        return new GregorianCalendar(nYear, nMonth, 18);
      default: // Saturday
        return new GregorianCalendar(nYear, nMonth, 17);
    }
  }

  // President's Day, formerly Washington and Lincoln's birthday, is celebrated on the third Monday
  // in February.
  public static GregorianCalendar getPresidentsDay(int nYear) {
    // Third Monday in February
    int nMonth = Calendar.FEBRUARY; // February

    GregorianCalendar dtD = new GregorianCalendar(nYear, nMonth, 1);
    int nX = dtD.get(Calendar.DAY_OF_WEEK);

    switch (nX) {
      case Calendar.SUNDAY: // Sunday
        return new GregorianCalendar(nYear, nMonth, 16);
      case Calendar.MONDAY: // Monday
        return new GregorianCalendar(nYear, nMonth, 15);
      case Calendar.TUESDAY: // Tuesday
        return new GregorianCalendar(nYear, nMonth, 21);
      case Calendar.WEDNESDAY: // Wednesday
        return new GregorianCalendar(nYear, nMonth, 20);
      case Calendar.THURSDAY: // Thursday
        return new GregorianCalendar(nYear, nMonth, 19);
      case Calendar.FRIDAY: // Friday
        return new GregorianCalendar(nYear, nMonth, 18);
      default: // Saturday
        return new GregorianCalendar(nYear, nMonth, 17);
    }
  }

  // Memorial Day, the last Monday in May
  public static GregorianCalendar getMemorialDay(int nYear) {
    // Last Monday in May
    int nMonth = Calendar.MAY; // May

    GregorianCalendar dtD = new GregorianCalendar(nYear, nMonth, 31);
    int nX = dtD.get(Calendar.DAY_OF_WEEK);

    switch (nX) {
      case Calendar.SUNDAY: // Sunday
        return new GregorianCalendar(nYear, nMonth, 25);
      case Calendar.MONDAY: // Monday
        return new GregorianCalendar(nYear, nMonth, 31);
      case Calendar.TUESDAY: // Tuesday
        return new GregorianCalendar(nYear, nMonth, 30);
      case Calendar.WEDNESDAY: // Wednesday
        return new GregorianCalendar(nYear, nMonth, 29);
      case Calendar.THURSDAY: // Thursday
        return new GregorianCalendar(nYear, nMonth, 28);
      case Calendar.FRIDAY: // Friday
        return new GregorianCalendar(nYear, nMonth, 27);
      default: // Saturday
        return new GregorianCalendar(nYear, nMonth, 26);
    }
  }

  // Independence Day, July 4th. If it is on Saturday, the preceding Friday will be observed. If
  // it is on Sunday, the following Monday will be observed.
  public static GregorianCalendar getIndependenceDay(int nYear) {

    int nMonth = Calendar.JULY; // July
    GregorianCalendar dtD = new GregorianCalendar(nYear, nMonth, 4);

    int nX = dtD.get(Calendar.DAY_OF_WEEK);

    switch (nX) {
      case Calendar.SUNDAY: // Sunday
        return new GregorianCalendar(nYear, nMonth, 5);
      case Calendar.MONDAY: // Monday
      case Calendar.TUESDAY: // Tuesday
      case Calendar.WEDNESDAY: // Wednesday
      case Calendar.THURSDAY: // Thursday
      case Calendar.FRIDAY: // Friday
        return new GregorianCalendar(nYear, nMonth, 4);
      default:
        // Saturday
        return new GregorianCalendar(nYear, nMonth, 3);
    }
  }

  // Labor Day is the first Monday in September.
  public static GregorianCalendar getLaborDay(int nYear) {
    // The first Monday in September
    int nMonth = Calendar.SEPTEMBER; // September
    GregorianCalendar dtD = new GregorianCalendar(nYear, nMonth, 1);

    int nX = dtD.get(Calendar.DAY_OF_WEEK);

    switch (nX) {
      case Calendar.SUNDAY: // Sunday
        return new GregorianCalendar(nYear, nMonth, 2);
      case Calendar.MONDAY: // Monday
        return new GregorianCalendar(nYear, nMonth, 1);
      case Calendar.TUESDAY: // Tuesday
        return new GregorianCalendar(nYear, nMonth, 7);
      case Calendar.WEDNESDAY: // Wednesday
        return new GregorianCalendar(nYear, nMonth, 6);
      case Calendar.THURSDAY: // Thursday
        return new GregorianCalendar(nYear, nMonth, 5);
      case Calendar.FRIDAY: // Friday
        return new GregorianCalendar(nYear, nMonth, 4);
      default: // Saturday
        return new GregorianCalendar(nYear, nMonth, 3);
    }
  }

  // Columbus Day is the second Monday in October.
  public static GregorianCalendar getColumbusDay(int nYear) {
    // Second Monday in October
    int nMonth = Calendar.OCTOBER; // October
    GregorianCalendar dtD = new GregorianCalendar(nYear, nMonth, 1);

    int nX = dtD.get(Calendar.DAY_OF_WEEK);

    switch (nX) {
      case Calendar.SUNDAY: // Sunday
        return new GregorianCalendar(nYear, nMonth, 9);
      case Calendar.MONDAY: // Monday
        return new GregorianCalendar(nYear, nMonth, 8);
      case Calendar.TUESDAY: // Tuesday
        return new GregorianCalendar(nYear, nMonth, 14);
      case Calendar.WEDNESDAY: // Wednesday
        return new GregorianCalendar(nYear, nMonth, 13);
      case Calendar.THURSDAY: // Thursday
        return new GregorianCalendar(nYear, nMonth, 12);
      case Calendar.FRIDAY: // Friday
        return new GregorianCalendar(nYear, nMonth, 11);
      default: // Saturday
        return new GregorianCalendar(nYear, nMonth, 10);
    }
  }

  // Federal Government offices are closed on November 11. If Veterans Day falls on a Saturday, they
  // are closed on Friday November 10. If Veterans Day falls on a Sunday, they are closed on Monday
  // November 12.
  public static GregorianCalendar getVeteransDay(int nYear) {
    // November 11th
    int nMonth = Calendar.NOVEMBER; // November

    GregorianCalendar dtD = new GregorianCalendar(nYear, nMonth, 11);
    int nX = dtD.get(Calendar.DAY_OF_WEEK);

    switch (nX) {
      case Calendar.SUNDAY: // Sunday
        return new GregorianCalendar(nYear, nMonth, 12);
      case Calendar.MONDAY: // Monday
      case Calendar.TUESDAY: // Tuesday
      case Calendar.WEDNESDAY: // Wednesday
      case Calendar.THURSDAY: // Thursday
      case Calendar.FRIDAY: // Friday
        return dtD;
      default: // Saturday
        return new GregorianCalendar(nYear, nMonth, 10);
    }
  }

  public static GregorianCalendar getThanksgivingDay(int nYear) {

    int nMonth = Calendar.NOVEMBER; // November
    GregorianCalendar dtD = new GregorianCalendar(nYear, nMonth, 1);

    int nX = dtD.get(Calendar.DAY_OF_WEEK);

    switch (nX) {
      case Calendar.SUNDAY: // Sunday
        return new GregorianCalendar(nYear, nMonth, 26);
      case Calendar.MONDAY: // Monday
        return new GregorianCalendar(nYear, nMonth, 25);
      case Calendar.TUESDAY: // Tuesday
        return new GregorianCalendar(nYear, nMonth, 24);
      case Calendar.WEDNESDAY: // Wednesday
        return new GregorianCalendar(nYear, nMonth, 23);
      case Calendar.THURSDAY: // Thursday
        return new GregorianCalendar(nYear, nMonth, 22);
      case Calendar.FRIDAY: // Friday
        return new GregorianCalendar(nYear, nMonth, 28);
      default: // Saturday
        return new GregorianCalendar(nYear, nMonth, 27);
    }
  }

  // Christmas Day is December 25th, and if the 25th falls on a Saturday, Christmas is observed by
  // businesses on Christmas Eve, December 24th. If December 25th falls on a Sunday, then it will be
  // observed by businesses in the United States on the 26th.
  public static GregorianCalendar getChristmasDay(int nYear) {

    int nMonth = Calendar.DECEMBER; // December
    GregorianCalendar dtD = new GregorianCalendar(nYear, nMonth, 25);

    int nX = dtD.get(Calendar.DAY_OF_WEEK);

    switch (nX) {
      case Calendar.SUNDAY: // Sunday
        return new GregorianCalendar(nYear, nMonth, 26);
      case Calendar.MONDAY: // Monday
      case Calendar.TUESDAY: // Tuesday
      case Calendar.WEDNESDAY: // Wednesday
      case Calendar.THURSDAY: // Thursday
      case Calendar.FRIDAY: // Friday
        return new GregorianCalendar(nYear, nMonth, 25);
      default:
        // Saturday
        return new GregorianCalendar(nYear, nMonth, 24);
    }
  }

  public static List<Date> getHolidays(int year) {
    List<Date> holidays = new ArrayList<Date>();

    holidays.add(getNewYearsDay(year).getTime());
    holidays.add(getMartinLutherKingDay(year).getTime());
    holidays.add(getPresidentsDay(year).getTime());
    holidays.add(getMemorialDay(year).getTime());
    holidays.add(getIndependenceDay(year).getTime());
    holidays.add(getLaborDay(year).getTime());
    holidays.add(getColumbusDay(year).getTime());
    holidays.add(getVeteransDay(year).getTime());
    holidays.add(getThanksgivingDay(year).getTime());
    holidays.add(getChristmasDay(year).getTime());

    return holidays;
  }

  private static String printDate(Date date) {
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    String strDate = dateFormat.format(date);

    return strDate;
  }

  public static List<String> getHolidayStringList(int year) {

    List<String> holidayStringList = new ArrayList<String>();

    List<Date> holidays = getHolidays(year);

    for (Date date : holidays) {

      String strDate = printDate(date);

      holidayStringList.add(strDate);
    }

    return holidayStringList;
  }

  public static boolean isHoliday(Date date) {
    boolean isHoliday = false;

    String dateString = printDate(date);

    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);

    int year = calendar.get(Calendar.YEAR);

    System.out.println("date: " + dateString);
    System.out.println("year: " + year);

    List<String> holidays = getHolidayStringList(year);

    for (String holiday : holidays) {
      System.out.println(holiday);
    }

    if (holidays.contains(dateString)) {
      isHoliday = true;
    }

    return isHoliday;
  }

  public static void main(String[] args) {

    int year = 2019;

    GregorianCalendar newYearDate = getNewYearsDay(year);
    System.out.println("newYearDate: " + newYearDate.getTime());

    GregorianCalendar mlkDate = getMartinLutherKingDay(year);
    System.out.println("mlkDate: " + mlkDate.getTime());

    GregorianCalendar presidentDate = getPresidentsDay(year);
    System.out.println("presidentDate: " + presidentDate.getTime());

    GregorianCalendar memDate = getMemorialDay(year);
    System.out.println("memDate: " + memDate.getTime());

    GregorianCalendar independenceDate = getIndependenceDay(year);
    System.out.println("independenceDate: " + independenceDate.getTime());

    GregorianCalendar laborDate = getLaborDay(year);
    System.out.println("laborDate: " + laborDate.getTime());

    GregorianCalendar columbusDate = getColumbusDay(year);
    System.out.println("columbusDate: " + columbusDate.getTime());

    GregorianCalendar veteransDate = getVeteransDay(year);
    System.out.println("veteransDate: " + veteransDate.getTime());

    GregorianCalendar thanksGivingDate = getThanksgivingDay(year);
    System.out.println("thanksGivingDate: " + thanksGivingDate.getTime());

    GregorianCalendar xmasDate = getChristmasDay(year);
    System.out.println("xmasDate: " + xmasDate.getTime());

    List<Date> holidays = getHolidays(year);

    for (Date date : holidays) {
      System.out.println(date);
    }


    try {

      String sDate1 = "11/12/2018";
      Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse(sDate1);

      System.out.println("Is " + sDate1 + " Holiday? " + isHoliday(date1));

    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }



    // test();
  }

  private static void test() {
    GregorianCalendar calendar = new GregorianCalendar(2018, 0, 1);
    System.out.println("Day of Week = " + calendar.get(GregorianCalendar.DAY_OF_WEEK));
    System.out.println("Date = " + calendar.get(GregorianCalendar.DATE));
    System.out.println("Month = " + calendar.get(GregorianCalendar.MONTH));
    System.out.println("Year = " + calendar.get(GregorianCalendar.YEAR));
  }

}
