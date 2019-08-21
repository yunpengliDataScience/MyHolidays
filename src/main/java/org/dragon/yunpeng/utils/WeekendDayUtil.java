package org.dragon.yunpeng.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class WeekendDayUtil {

  public static boolean isMatchedDayOfWeek(int year, int month, int day, int dayOfWeek) {
    boolean isMatched = false;

    GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);

    int dayOfWeekNumber = calendar.get(Calendar.DAY_OF_WEEK);

    if (dayOfWeekNumber == dayOfWeek) {
      isMatched = true;
    }
    return isMatched;
  }

  public static boolean isMatchedDayOfWeek(Date date, int dayOfWeek) {
    boolean isMatched = false;

    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);

    System.out.println(calendar.getTime());

    int dayOfWeekNumber = calendar.get(Calendar.DAY_OF_WEEK);

    if (dayOfWeekNumber == dayOfWeek) {
      isMatched = true;
    }
    return isMatched;
  }

  public static boolean isSaturday(int year, int month, int day) {
    boolean isSaturday = false;

    isSaturday = isMatchedDayOfWeek(year, month, day, Calendar.SATURDAY);

    return isSaturday;
  }

  public static boolean isSaturday(Date date) {
    boolean isSaturday = false;

    isSaturday = isMatchedDayOfWeek(date, Calendar.SATURDAY);

    return isSaturday;
  }

  public static boolean isSunday(int year, int month, int day) {
    boolean isSunday = false;

    isSunday = isMatchedDayOfWeek(year, month, day, Calendar.SUNDAY);

    return isSunday;
  }

  public static boolean isSunday(Date date) {
    boolean isSunday = false;

    isSunday = isMatchedDayOfWeek(date, Calendar.SUNDAY);

    return isSunday;
  }

  public static boolean isWeekend(Date date) {
    boolean isWeekend = false;

    isWeekend = isSaturday(date) || isSunday(date);

    return isWeekend;
  }

  public static void main(String[] args) {

    Date currentDate = new Date();

    System.out.println(isMatchedDayOfWeek(currentDate, Calendar.WEDNESDAY));
    
    //-------------------------------------------------------------------------
    try {

      String sDate1 = "08/24/2019";
      Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse(sDate1);

      System.out.println("Is " + sDate1 + " Weekend? " + isWeekend(date1));

    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
