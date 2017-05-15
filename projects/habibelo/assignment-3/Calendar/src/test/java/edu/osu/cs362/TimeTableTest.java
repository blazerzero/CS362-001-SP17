package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.*;
import java.lang.reflect.*;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {


   /*TEST 1*/
   @Test
   public void test01()  throws Throwable  {
      TimeTable timetable = new TimeTable();
      Calendar rightnow = Calendar.getInstance();
      int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
      int thisMonth = rightnow.get(Calendar.MONTH)+1;
      int thisYear = rightnow.get(Calendar.YEAR);
      GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
      GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
      tomorrow.add(Calendar.DAY_OF_MONTH,1);
      CalDay calday = new CalDay(today);
      int startHour=1;
      int startMinute=0;
      int startDay=thisDay;
      int startMonth=thisMonth;
      int startYear=thisYear;
      String title="DAM JAM 2017";
      String description=null;
      //CONSTRUCT NEW APPOINTMENT
      Appt appt = new Appt(startHour,
	    startMinute,
	    startDay,
	    startMonth,
	    startYear,
	    title,
	    description);
      startHour=2;
      startMinute=0;
      startDay=thisDay;
      startMonth=thisMonth;
      startYear=thisYear;
      title="DAM JAM 2017 #2";
      description=null;
      //CONSTRUCT NEW APPOINTMENT
      Appt appt2 = new Appt(startHour,
	    startMinute,
	    startDay,
	    startMonth,
	    startYear,
	    title,
	    description);
      calday.addAppt(appt);
      calday.addAppt(appt2);
      assertFalse(timetable.getApptRange(calday.appts, today, tomorrow) == null);
   }

   /*TEST 2*/
   @Test
   public void test02()  throws Throwable  {
      TimeTable timetable = new TimeTable();
      Calendar rightnow = Calendar.getInstance();
      int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
      int thisMonth = rightnow.get(Calendar.MONTH)+1;
      int thisYear = rightnow.get(Calendar.YEAR);
      GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
      GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
      tomorrow.add(Calendar.DAY_OF_MONTH,1);
      CalDay calday = new CalDay(today);
      int startHour=1;
      int startMinute=0;
      int startDay=thisDay;
      int startMonth=thisMonth;
      int startYear=thisYear;
      String title="DAM JAM 2017";
      String description=null;
      //CONSTRUCT NEW APPOINTMENT
      Appt appt = new Appt(startHour,
	    startMinute,
	    startDay,
	    startMonth,
	    startYear,
	    title,
	    description);
      startHour=2;
      startMinute=0;
      startDay=thisDay-1;
      startMonth=thisMonth;
      startYear=thisYear;
      title="DAM JAM 2017 #2";
      description=null;
      //CONSTRUCT NEW APPOINTMENT
      Appt appt2 = new Appt(startHour,
	    startMinute,
	    startDay,
	    startMonth,
	    startYear,
	    title,
	    description);
      try {
	 assertFalse(timetable.getApptRange(calday.appts, tomorrow, today) == null);
      }
      catch (IllegalArgumentException e) {
	 System.out.println(e);
      }
      calday.addAppt(appt2);
      calday.addAppt(appt);
      assertFalse(timetable.getApptRange(calday.appts, today, tomorrow) == null);
   }

   /*TEST 3*/
   @Test
   public void test03() throws Throwable {
      TimeTable timetable = new TimeTable();
      Calendar rightnow = Calendar.getInstance();
      int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
      int thisMonth = rightnow.get(Calendar.MONTH)+1;
      int thisYear = rightnow.get(Calendar.YEAR);
      GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
      GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
      tomorrow.add(Calendar.DAY_OF_MONTH,1);
      CalDay calday = new CalDay(today);
      int startHour=1;
      int startMinute=0;
      int startDay=thisDay;
      int startMonth=thisMonth;
      int startYear=thisYear;
      String title="DAM JAM 2017";
      String description=null;
      //CONSTRUCT NEW APPOINTMENT
      Appt appt = null;
      assertTrue(timetable.deleteAppt(calday.appts, appt) == null);
      appt = new Appt(startHour,
	    startMinute,
	    startDay,
	    startMonth,
	    startYear,
	    title,
	    description);
      assertTrue(timetable.deleteAppt(calday.appts, appt) == null);
      calday.addAppt(appt);
      assertFalse(timetable.deleteAppt(calday.appts, appt) == null);
      assertTrue(timetable.deleteAppt(calday.appts, null) == null);
   }

   /*TEST 4*/
   @Test
   public void test04() throws Throwable {
      TimeTable timetable = new TimeTable();
      Calendar rightnow = Calendar.getInstance();
      int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
      int thisMonth = rightnow.get(Calendar.MONTH)+1;
      int thisYear = rightnow.get(Calendar.YEAR);
      GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
      GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
      tomorrow.add(Calendar.DAY_OF_MONTH,1);
      CalDay calday = new CalDay(today);
      int startHour=-1;
      int startMinute=0;
      int startDay=thisDay;
      int startMonth=thisMonth;
      int startYear=thisYear;
      String title="DAM JAM 2017";
      String description=null;
      //CONSTRUCT NEW APPOINTMENT
      Appt appt = new Appt(startHour,
	    startMinute,
	    startDay,
	    startMonth,
	    startYear,
	    title,
	    description);
      assertTrue(timetable.deleteAppt(calday.appts, appt) == null);
   }

   /***********
   new Appt format: new Appt(hour, minute, day, month, year)
   ***********/

   /*TEST 5*/
   @Test
   public void test05() throws Throwable {
      TimeTable timetable = new TimeTable();
      Calendar rightnow = Calendar.getInstance();
      int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
      int thisMonth = rightnow.get(Calendar.MONTH)+1;
      int thisYear = rightnow.get(Calendar.YEAR);
      GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
      GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
      tomorrow.add(Calendar.DAY_OF_MONTH,1);
      CalDay calday = new CalDay(today);
      //CONSTRUCT NEW APPOINTMENTS
      Appt appt = new Appt(1, 0, thisDay, thisMonth, thisYear, "DAM JAM 2017", null);
      Appt appt2 = new Appt(2, 0, thisDay, thisMonth, thisYear, "DAM JAM 2017", null);
      calday.addAppt(appt);
      calday.addAppt(appt2);
      timetable.deleteAppt(calday.getAppts(), appt2);
      assertFalse(calday.getSizeAppts() == 2);
   }

   /*TEST 6*/
   @Test
   public void test06() throws Throwable {
      TimeTable timetable = new TimeTable();
      Calendar rightnow = Calendar.getInstance();
      int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
      int thisMonth = rightnow.get(Calendar.MONTH)+1;
      int thisYear = rightnow.get(Calendar.YEAR);
      GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
      GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
      tomorrow.add(Calendar.DAY_OF_MONTH,1);
      CalDay calday = new CalDay(today);
      //CONSTRUCT NEW APPOINTMENT
      Appt appt = new Appt(1, 0, 3, 6, 2017, "DAM JAM 2017", null);
      Method m = timetable.getClass().getDeclaredMethod("getApptOccurences", Appt.class, GregorianCalendar.class, GregorianCalendar.class);
      m.setAccessible(true);
      assertFalse(m.invoke(timetable, appt, today, tomorrow) == null);
   }

   /*TEST 7*/
   @Test
   public void test07() throws Throwable {
      TimeTable timetable = new TimeTable();
      Calendar rightnow = Calendar.getInstance();
      int thisDay = 2;
      int thisMonth = 6;
      int thisYear = 2017;
      GregorianCalendar firstday = new GregorianCalendar(thisYear, thisMonth, thisDay);
      GregorianCalendar lastday = new GregorianCalendar(thisYear, thisMonth, thisDay+4);
      CalDay calday = new CalDay();
      //CONSTRUCT NEW APPOINTMENT
      Appt appt = new Appt(1, 0, 3, 6, 2017, "DAM JAM 2017", null);
      LinkedList<GregorianCalendar> result = new LinkedList<GregorianCalendar>();
      Method m = timetable.getClass().getDeclaredMethod("getApptOccurences", Appt.class, GregorianCalendar.class, GregorianCalendar.class);
      m.setAccessible(true);
      assertFalse(m.invoke(timetable, appt, firstday, lastday) == result);
   }

   /*TEST 8*/
   @Test
   public void test08() throws Throwable {
      TimeTable timetable = new TimeTable();
      Calendar rightnow = Calendar.getInstance();
      int thisDay = 6;
      int thisMonth = 6;
      int thisYear = 2017;
      GregorianCalendar firstday = new GregorianCalendar(thisYear, thisMonth, thisDay);
      GregorianCalendar lastday = new GregorianCalendar(thisYear, thisMonth, thisDay-4);
      CalDay calday = new CalDay();
      //CONSTRUCT NEW APPOINTMENT
      Appt appt = new Appt(1, 0, 3, 6, 2017, "DAM JAM 2017", null);
      LinkedList<GregorianCalendar> result = new LinkedList<GregorianCalendar>();
      Method m = timetable.getClass().getDeclaredMethod("getApptOccurences", Appt.class, GregorianCalendar.class, GregorianCalendar.class);
      m.setAccessible(true);
      assertFalse(m.invoke(timetable, appt, firstday, lastday) == result);
   }
}
