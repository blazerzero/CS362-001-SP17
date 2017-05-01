package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


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

}
