package com.vidushi.takshila.DateAndTime;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 * /*
 * @(#) DateAndTimeUtils.java
 *
 * Copyright (c) tvidushi
 * 
 * All rights reserved.
 *
 * This software can be used for learning purpose
 */


/**
 * This class contains contains the common date utility methods for various/lookup/reference purposes(work in progress)
 * 
 * The purpose is have look up for var
 * P.S These have  been purposefully not declared static
 * @author takshila vidushi 
 */


public class DateAndTimeUtils {

	/**
	 * @param num 
	 * calculates factorial of a number
	 */
	private static Clock clockUTC = Clock.systemUTC();
	private static Clock defaultZoneClock = Clock.systemUTC();
    private static LocalDate today ;
	private static DayOfWeek dayOfWeek ;
	private static Instant instant ;
	
	/**
	 * 
	 * Gets instant value
	 */
	
	public Instant getInstant(){
		   return defaultZoneClock.instant();
	}
	
	
	/**
	 * 
	 * Gets instant value
	 */
	public ZoneId getZone(){
		   return defaultZoneClock.getZone();
	}
	
	
	/**
	 * 
	 * Gets instant value
	 */
	public LocalDate getToday(){
		   return today.now();
	}
	
	
	/**
	 * 
	 * Gets instant value
	 */
	public LocalDate getTommorow(){
	       return today.now().plusDays(1);
    }

	
	/**
	 * 
	 * Gets instant value
	 */
	public LocalDate getYesterday(){
	       return today.now().minusDays(1);
    }

	/**
	 * 
	 * Gets day of the month 
	 */
	public int getDayOfMonth(){
	       return today.now().getDayOfMonth();
    }

	/**
	 * 
	 * Gets date from string
	 */
	
	public LocalDate getDateFromString(String date){
		//eg. date ="2017-02-20");
	    return LocalDate.parse(date);
    }
	
	/**
	 * 
	 * Gets day of the week
	 */
	public int getDayOfWeek(){
		return dayOfWeek.getValue();
	}
	/**
	 * 
	 * Gets instant value
	 */
	
	public Instant get(){
		return Instant.now();
	}
	
	
	/**
	 * 
	 * Gets instant value
	 */
	
	public Instant getCurrenTime(){
		return Instant.now();
	}
	/**
	 * 
	 * Gets instant value
	 */
	public LocalDate   FormattingDate(){
		 DateTimeFormatter  canadianFormat =  DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(Locale.CANADA);	
		 return LocalDate.parse("Nov 03, 2014", canadianFormat);
      
	   }

	  
	/**
	 * 
	 * Gets current time
	 */
	
	public LocalTime getCurrentTime(){
		return LocalTime.now();

	}
	
	
	/**
	 * 
	 * Get time from string
	 */
	
	public LocalTime getTimeFromStr(String time){
		return LocalTime.parse(time); // can throw parse exception

	}
	
	
	
	public static void main(String[] args) {
		

		}
	
	

	
	

}
