package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.*;
import java.lang.reflect.*;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

   /*TEST 1*/
   @Test
   public void test01() throws Throwable {
      CalDay calday = new CalDay();
      assertFalse(calday.isValid());
   }

   /*TEST 2*/
   @Test
   public void test02() throws Throwable {
      Calendar rightnow = Calendar.getInstance();
      int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
      int thisMonth = rightnow.get(Calendar.MONTH)+1;
      int thisYear = rightnow.get(Calendar.YEAR);
      GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
      CalDay calday = new CalDay(today);
      assertTrue(calday.isValid());
   }

   /*TEST 3*/
   @Test
   public void test03() throws Throwable {
      int startHour=1;
      int startMinute=0;
      int startDay=3;
      int startMonth=6;
      int startYear=2017;
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
      int thisDay = 3;
      int thisMonth = 6;
      int thisYear = 2017;
      GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
      CalDay calday = new CalDay(today);
      calday.addAppt(appt);
      assertEquals(1, calday.getSizeAppts());
   }

   /*TEST 4*/
   @Test
   public void test04() throws Throwable {
      Calendar rightnow = Calendar.getInstance();
      int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
      int thisMonth = rightnow.get(Calendar.MONTH)+1;
      int thisYear = rightnow.get(Calendar.YEAR);
      GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
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
      calday.addAppt(appt);
      String result = calday.toString();
      assertFalse(result == null);
   }

   /*TEST 5*/
   @Test
   public void test05() throws Throwable {
      Calendar rightnow = Calendar.getInstance();
      int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
      int thisMonth = rightnow.get(Calendar.MONTH)+1;
      int thisYear = rightnow.get(Calendar.YEAR);
      GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
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
      String result = calday.toString();
      assertFalse(result == null);
   }

   /*TEST 6*/
   @Test
   public void test06() throws Throwable {
      Calendar rightnow = Calendar.getInstance();
      int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
      int thisMonth = rightnow.get(Calendar.MONTH)+1;
      int thisYear = rightnow.get(Calendar.YEAR);
      GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
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
      calday.addAppt(appt2);
      calday.addAppt(appt);
      String result = calday.toString();
      assertFalse(result == null);
   }

   /*TEST 7*/
   @Test
   public void test07() throws Throwable {
      Calendar rightnow = Calendar.getInstance();
      int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
      int thisMonth = rightnow.get(Calendar.MONTH)+1;
      int thisYear = rightnow.get(Calendar.YEAR);
      GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
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
      calday.addAppt(appt);
      assertFalse(calday.iterator() == null);
   }

   /*TEST 8*/
   @Test
   public void test08() throws Throwable {
      Calendar rightnow = Calendar.getInstance();
      int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
      int thisMonth = rightnow.get(Calendar.MONTH)+1;
      int thisYear = rightnow.get(Calendar.YEAR);
      CalDay calday = new CalDay();
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
      calday.addAppt(appt);
      assertTrue(calday.iterator() == null);
      assertEquals("", calday.toString());
   }

   /*TEST 9*/
   @Test
   public void test09() throws Throwable {
      Calendar rightnow = Calendar.getInstance();
      int thisDay = 9;
      int thisMonth = 5;
      int thisYear = 2017;
      GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
      CalDay calday = new CalDay(today);
      assertEquals(9, calday.getDay());
      assertEquals(5, calday.getMonth());
      assertEquals(2017, calday.getYear());
   }

   /*TEST 10*/
   @Test
   public void test10() throws Throwable {
      Calendar rightnow = Calendar.getInstance();
      int thisDay = 9;
      int thisMonth = 5;
      int thisYear = 2017;
      GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
      CalDay calday = new CalDay(today);
      LinkedList<Appt> llappt = new LinkedList<Appt>();
      llappt = null;
      Method m = calday.getClass().getDeclaredMethod("setAppts", LinkedList.class);
      m.setAccessible(true);
      m.invoke(calday, llappt);
      assertFalse(calday.getAppts() == null);
   }

   /*TEST 11*/
   @Test
   public void test11() throws Throwable {
      Calendar rightnow = Calendar.getInstance();
      int thisDay = 9;
      int thisMonth = 5;
      int thisYear = 2017;
      GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
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
      //CONSTRUCT NEW APPOINTMENT
      Appt appt2 = new Appt(startHour,
	    startMinute,
	    startDay,
	    startMonth,
	    startYear,
	    title,
	    description);
      calday.addAppt(appt2);
      calday.addAppt(appt);
      assertEquals(2, calday.getSizeAppts());

   }

   /*TEST 12*/
   @Test
   public void test12() throws Throwable {
      Calendar rightnow = Calendar.getInstance();
      int thisDay = 9;
      int thisMonth = 5;
      int thisYear = 2017;
      GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
      CalDay calday = new CalDay(today);
      int startHour=1;
      int startMinute=0;
      int startDay=1;
      int startMonth=1;
      int startYear=2017;
      String title="null";
      String description=null;
      //CONSTRUCT NEW APPOINTMENT
      Appt appt = new Appt(startHour,
	    startMinute,
	    startDay,
	    startMonth,
	    startYear,
	    title,
	    description);
      startHour=3;
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
      assertFalse(((Appt)calday.getAppts().get(0)).toString().contains("3"));
      String calstring = calday.toString();
      assertTrue(calstring.contains("3"));

   }

   /*TEST 13*/
   @Test
   public void test13() throws Throwable {
      Calendar rightnow = Calendar.getInstance();
      int thisDay = 9;
      int thisMonth = 5;
      int thisYear = 2017;
      GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
      CalDay calday = new CalDay(today);
      int startHour=1;
      int startMinute=0;
      int startDay=1;
      int startMonth=1;
      int startYear=2017;
      String title="null";
      String description=null;
      //CONSTRUCT NEW APPOINTMENT
      Appt appt = new Appt(startHour,
	    startMinute,
	    startDay,
	    startMonth,
	    startYear,
	    title,
	    description);
      startMinute=3;
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
      assertFalse(((Appt)calday.getAppts().get(0)).toString().contains("3"));

   }
}
