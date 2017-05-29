package edu.osu.cs362;

import java.util.Calendar;
import java.util.Random;
import java.util.*;
import java.lang.*;

import org.junit.Test;


import static org.junit.Assert.*;



/**
* Random Test Generator  for TimeTable class.
*/

public class TimeTableRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	* Generate Random Tests that tests TimeTable Class.
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
				/*int gcalday = (int) ValuesGenerator.getRandomIntBetween(random, -14, 45);
				int gcalmonth = (int) ValuesGenerator.getRandomIntBetween(random, -5, 18);
				int gcalyear = (int) ValuesGenerator.getRandomIntBetween(random, 1, 2017);*/
				GregorianCalendar gcal = new GregorianCalendar(2017, 3, 6);
				TimeTable timetable = new TimeTable();

				if ((int) ValuesGenerator.getRandomIntBetween(random, 0, 2) == 1) {
					CalDay calday = new CalDay(gcal);
					int addcount = random.nextInt(100)+1;

					for (int j = 0; j < addcount; j++) {
						int startHour = (int) ValuesGenerator.getRandomIntBetween(random, 0, 23);
						int startMinute = (int) ValuesGenerator.getRandomIntBetween(random, 0, 59);
						int startDay = 3;
						int startMonth = 6;
						int startYear = 2017;
						String title = (((int) ValuesGenerator.getRandomIntBetween(random, 0, 2)) == 1)
										 ? (String) ValuesGenerator.getString(random)
										 : null;
						String description = (((int) ValuesGenerator.getRandomIntBetween(random, 0, 2)) == 1)
												 ? (String) ValuesGenerator.getString(random)
												 : null;

						Appt newAppt = new Appt(startHour,
														startMinute,
														startDay,
														startMonth,
														startYear,
														title,
														description);
						calday.addAppt(newAppt);
					}
					LinkedList<Appt> appts = calday.getAppts();
					int limit = random.nextInt(calday.getSizeAppts())+1;
					//for (int j = 0; j < limit; j++) {
					/*Appt appt = (((int) ValuesGenerator.getRandomIntBetween(random, 0, 2)) == 1)
								 ? appts.get(random.nextInt(appts.size()))
								 : null;
					if (appt != null) {
						appt = ((int) ValuesGenerator.getRandomIntBetween(random, -24, -1))
					}*/
					Appt appt;
					int badStartHour = (int) ValuesGenerator.getRandomIntBetween(random, -24, 47);
					//int badStartHour2 = (int) ValuesGenerator.getRandomIntBetween(random, 24, 47);
					int badStartMinute = (int) ValuesGenerator.getRandomIntBetween(random, -60, 119);
					//int badStartMinute2 = (int) ValuesGenerator.getRandomIntBetween(random, 60, 119);

					int newStartHour = (int) ValuesGenerator.getRandomIntBetween(random, -1, 24);
					int newStartMinute = (int) ValuesGenerator.getRandomIntBetween(random, -1, 60);
					int newStartDay = (int) ValuesGenerator.getRandomIntBetween(random, 0, 32);
					int newStartMonth = (int) ValuesGenerator.getRandomIntBetween(random, 0, 13);
					int newStartYear = (int) ValuesGenerator.getRandomIntBetween(random, 2016, 2018);
					String newTitle = (((int) ValuesGenerator.getRandomIntBetween(random, 0, 2)) == 1)
									    ? (String) ValuesGenerator.getString(random)
									    : null;
					String newDescription = (((int) ValuesGenerator.getRandomIntBetween(random, 0, 2)) == 1)
	 										    ? (String) ValuesGenerator.getString(random)
											 	 : null;

					int randomizer = random.nextInt(4)+1;

					if (randomizer == 1) appt = appts.get(random.nextInt(appts.size()));
					else if (randomizer == 2) appt = new Appt(badStartHour,
																			badStartMinute,
																			3,
																			6,
																			2017,
																			null,
																			null);
					else if (randomizer == 3) appt = new Appt(newStartHour,
																			newStartMinute,
																			newStartDay,
																			newStartMinute,
																			newStartYear,
																			newTitle,
																			newDescription);
					else appt = null;

					appts = (((int) ValuesGenerator.getRandomIntBetween(random, 0, 2)) == 1)
								 ? appts
								 : null;

					appts = timetable.deleteAppt(appts, appt);
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
