/**
 * 
 */
package com.jpmorgan.InstructionTradeReport.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jpmorgan.InstructionTradeReport.exception.MyOwnException;

/**
 * @author it026633
 *
 */
public class ArabianWorkingDay {
	
	private static final String sourceClass = ArabianWorkingDay.class.getName();
	private Logger logger = Logger.getLogger(sourceClass);
	
	public boolean isArabianWorkingDay(LocalDate inputDate) {
		final String sourceMethod = "isArabianWorkingDay";
		DayOfWeek dow = inputDate.getDayOfWeek(); 
		if ((dow.getValue() == DayOfWeek.FRIDAY.getValue()) ||
				(dow.getValue() == DayOfWeek.SATURDAY.getValue())) {
			return false;					
		}
		return true;
	}

	public LocalDate getNextArabianWorkingDay(LocalDate inputDate) throws MyOwnException {
		final String sourceMethod = "getNextArabianWorkingDay";
		LocalDate resultDate = inputDate;
		try {
			DayOfWeek dow = inputDate.getDayOfWeek();
			if (dow.getValue() == DayOfWeek.SATURDAY.getValue()) {
				return resultDate.plusDays(2);
			}
			if (dow.getValue() == DayOfWeek.FRIDAY.getValue()) {
				return resultDate.plusDays(3);
			}
		} catch (Exception e){
			logger.logp(Level.SEVERE, sourceClass, sourceMethod, "Not Valid Input date:" +inputDate.toString());
			throw new MyOwnException("Exception during obtain nex Arabian working day");
		}
		return resultDate;
	}
}
