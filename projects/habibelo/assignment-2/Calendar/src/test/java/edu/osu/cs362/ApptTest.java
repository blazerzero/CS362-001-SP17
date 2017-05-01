package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;

public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=13;
		 int startMinute=30;
		 int startDay=10;
		 int startMonth=4;
		 int startYear=2017;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(13, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(10, appt.getStartDay());
		 assertEquals(04, appt.getStartMonth());
		 assertEquals(2017, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
	 }


	/*TEST 2*/
	@Test
	public void test02() throws Throwable {
	   int startHour=1;
	   int startMinute=0;
   	   int startDay=3;
	   int startMonth=6;
	   int startYear=2017;
	   String title="DAMJAM 2017";
	   String description=null;
	   //CONSTRUCT NEW APPOINTMENT
	   Appt appt = new Appt(startHour,
   		 startMinute,
		 startDay,
		 startMonth,
		 startYear,
		 title,
		 description);
	   String result = appt.toString();

	   //assertions
	   assertTrue(appt.getValid());
   	   assertFalse(appt.getStartHour() == 0);
	   assertTrue(appt.getStartHour() == 1);
	   assertFalse(appt.getStartDay() == 4);
	   assertEquals(3, appt.getStartDay());
	   assertEquals("DAMJAM 2017", appt.getTitle());
	   assertEquals("", appt.getDescription());
	   assertTrue(appt.getStartYear() == 2017);
	   assertTrue(result != null);
	   assertTrue(result.contains("am"));
	}


	/*TEST 3*/
	@Test
	public void test03() throws Throwable {
	   //String result;
	   int startHour=-1;
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

	   //assertions and tests
	   assertFalse(appt.getValid());
	   assertEquals(-1, appt.getStartHour());
	   appt.setStartHour(-2);
	   assertFalse(appt.getValid());
	   assertEquals(-2, appt.getStartHour());
	   assertTrue(appt.toString() == null);
	   
	}


	/*TEST 4*/
	@Test
	public void test04() throws Throwable {
	   int startHour=0;
	   int startMinute=-1;
	   int startDay=3;
	   int startMonth=6;
	   int startYear=2017;
	   String title="New Event";
	   String description=null;
	   Appt appt = new Appt(startHour,
		 startMinute,
		 startDay,
		 startMonth,
		 startYear,
		 title,
		 description);

	   //assertions and tests
	   assertFalse(appt.getValid());
	   assertEquals(-1, appt.getStartMinute());
	   appt.setStartMinute(-2);
	   assertFalse(appt.getValid());
	   assertEquals(-2, appt.getStartMinute());
	}


	/*TEST 5*/
	@Test
	public void test05() throws Throwable {
	   int startHour=0;
	   int startMinute=0;
	   int startDay=-1;
	   int startMonth=6;
	   int startYear=2017;
	   String title="New Event";
	   String description=null;
	   Appt appt = new Appt(startHour,
		 startMinute,
		 startDay,
		 startMonth,
		 startYear,
		 title,
		 description);

	   //assertions and tests
	   assertFalse(appt.getValid());
	   assertEquals(-1, appt.getStartDay());
	   appt.setStartDay(0);
	   assertFalse(appt.getValid());
	   assertEquals(0, appt.getStartDay());
	}


	/*TEST 6*/
	@Test
	public void test06() throws Throwable {
	   int startHour=0;
	   int startMinute=0;
	   int startDay=3;
	   int startMonth=-1;
	   int startYear=2017;
	   String title="New Event";
	   String description=null;
	   Appt appt = new Appt(startHour,
		 startMinute,
		 startDay,
		 startMonth,
		 startYear,
		 title,
		 description);

	   //assertions and tests
	   assertFalse(appt.getValid());
	   assertEquals(-1, appt.getStartMonth());
	   appt.setStartMonth(0);
	   assertFalse(appt.getValid());
	   assertEquals(0, appt.getStartMonth());
	}

	/*TEST 7*/
	@Test
	public void test07() throws Throwable {
	   int startHour = 1;
	   int startMinute = 1;
	   int startDay = 1;
	   int startMonth = 1;
	   int startYear = 2017;
	   String title = "New Event";
	   String description = null;
	   Appt appt = new Appt(startHour,
		 startMinute,
		 startDay,
		 startMonth,
		 startYear,
		 title,
		 description);

	   //assertions and tests
	   appt.setTitle(null);
	   assertTrue(appt.getValid());
	   assertEquals("", appt.getTitle());
	   appt.setDescription(null);
	   assertTrue(appt.getValid());
	   assertEquals("", appt.getDescription());
	}

}
