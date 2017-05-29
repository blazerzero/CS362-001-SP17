package edu.osu.cs362;

import java.util.Calendar;
import java.util.Random;
import java.util.*;
import java.lang.*;

import org.junit.Test;


import static org.junit.Assert.*;



/**
* Random Test Generator  for CalDay class.
*/

public class CalDayRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	* Generate Random Tests that tests CalDay Class.
	*/
	@Test
	public void randomtest()  throws Throwable  {

		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		System.out.println("Start testing...");


		for (int iteration = 0; elapsed < TestTimeout; iteration++) {
			long randomseed = 10;//System.currentTimeMillis();
			//			System.out.println(" Seed:"+randomseed );
			Random random = new Random(randomseed);

			for (int i = 0; i < NUM_TESTS; i++) {
				GregorianCalendar gcal = new GregorianCalendar(2017, 3, 6);

				if ((int) ValuesGenerator.getRandomIntBetween(random, 0, 2) == 1) {
					CalDay calday = new CalDay(gcal);
					int addcount = random.nextInt(100)+1;

					for (int j = 0; j < addcount; j++) {
						int startHour = (int) ValuesGenerator.getRandomIntBetween(random, -12, 23);
						int startMinute = (int) ValuesGenerator.getRandomIntBetween(random, -60, 119);
						int startDay = (int) ValuesGenerator.getRandomIntBetween(random, -30, 62);
						int startMonth = (int) ValuesGenerator.getRandomIntBetween(random, -11, 24);
						int startYear = (int) ValuesGenerator.getRandomIntBetween(random, -2017, 2017);
						String title = (((int) ValuesGenerator.getRandomIntBetween(random, 0, 2)) == 1)
						? (String) ValuesGenerator.getString(random)
						: null;
						String description = (((int) ValuesGenerator.getRandomIntBetween(random, 0, 2)) == 1)
						? (String) ValuesGenerator.getString(random)
						: null;

						Appt appt = new Appt(startHour,
						startMinute,
						startDay,
						startMonth,
						startYear,
						title,
						description);
						calday.addAppt(appt);
					}
				}
				else {
					CalDay calday = new CalDay();
				}

			}

			elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			if((iteration%10000)==0 && iteration!=0 )
			System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

		}

		System.out.println("Done testing...");

	}

}
