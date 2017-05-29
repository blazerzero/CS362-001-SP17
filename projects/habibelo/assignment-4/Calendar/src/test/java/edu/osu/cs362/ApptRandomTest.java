package edu.osu.cs362;

import java.util.Calendar;
import java.util.Random;
import java.util.*;
import java.lang.*;

import org.junit.Test;


import static org.junit.Assert.*;



/**
* Random Test Generator  for Appt class.
*/

public class ApptRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	* Return a randomly selected method to be tests !.
	*/
	public static String RandomSelectMethod(Random random){
		String[] methodArray = new String[] {"isValid","setStartHour","setStartMinute","setStartDay",
		"setStartMonth","setStartYear","setTitle",
		"setDescription","getStartHour","getStartMinute",
		"getStartDay","getStartMonth","getStartYear",
		"getTitle","getDescription","getValid","toString"};// The list of the of methods to be tested in the Appt class

		int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

		return methodArray[n] ; // return the method name
	}

	/**
	* Generate Random Tests that tests Appt Class.
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
			//Construct a new Appointment object with the initial data

			for (int i = 0; i < NUM_TESTS; i++) {
				int startHour = (int) ValuesGenerator.getRandomIntBetween(random, -24, 47);
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
				String methodName = ApptRandomTest.RandomSelectMethod(random);
				String newString = (((int) ValuesGenerator.getRandomIntBetween(random, 0, 2)) == 1)
									  ? (String) ValuesGenerator.getString(random)
									  : null;
				int newInt;
				String resultString;
				int resultInt;
				boolean resultValid;
				if (methodName.equals("setStartHour")) {
					newInt = (int) ValuesGenerator.getRandomIntBetween(random, -24, 47);
					appt.setStartHour(newInt);
				}
				else if (methodName.equals("setStartMinute")) {
					newInt = (int) ValuesGenerator.getRandomIntBetween(random, -60, 119);
					appt.setStartMinute(newInt);
				}
				else if (methodName.equals("setStartDay")) {
					newInt = (int) ValuesGenerator.getRandomIntBetween(random, -30, 62);
					appt.setStartDay(newInt);
				}
				else if (methodName.equals("setStartMonth")) {
					newInt = (int) ValuesGenerator.getRandomIntBetween(random, -11, 24);
					appt.setStartMonth(newInt);
				}
				else if (methodName.equals("setStartYear")) {
					newInt = (int) ValuesGenerator.getRandomIntBetween(random, -2017, 2017);
					appt.setStartYear(newInt);
				}
				else if (methodName.equals("setTitle")){
					appt.setTitle(newString);
				}
				else if (methodName.equals("setDescription")) {
					appt.setDescription(newString);
				}
				else if (methodName.equals("getStartHour")) {
					resultInt = appt.getStartHour();
				}
				else if (methodName.equals("getStartMinute")) {
					resultInt = appt.getStartMinute();
				}
				else if (methodName.equals("getStartDay")) {
					resultInt = appt.getStartDay();
				}
				else if (methodName.equals("getStartMonth")) {
					resultInt = appt.getStartMonth();
				}
				else if (methodName.equals("getStartYear")) {
					resultInt = appt.getStartYear();
				}
				else if (methodName.equals("getTitle")) {
					resultString = appt.getTitle();
				}
				else if (methodName.equals("getDescription")) {
					resultString = appt.getDescription();
				}
				else if (methodName.equals("getValid")) {
					resultValid = appt.getValid();
				}
				else if (methodName.equals("toString")) {
					resultString = appt.toString();
				}
				else {}
				}

				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if((iteration%10000)==0 && iteration!=0 )
					System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			}


			System.out.println("Done testing...");
		}

	}
