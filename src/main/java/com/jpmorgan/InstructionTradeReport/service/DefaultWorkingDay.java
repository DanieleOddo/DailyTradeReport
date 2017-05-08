/**
 * 
 */
package com.jpmorgan.InstructionTradeReport.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jpmorgan.InstructionTradeReport.exception.MyOwnException;

/**
 * @author it026633
 *
 */
public class DefaultWorkingDay {
	
	private static final String sourceClass = DefaultWorkingDay.class.getName();
	private Logger logger = Logger.getLogger(sourceClass);
	
	public boolean isDefaultWorkingDay(LocalDate inputDate) {
		final String sourceMethod = "isDefaultWorkingDay";
		DayOfWeek dow = inputDate.getDayOfWeek(); 
		if ((dow.getValue() >= DayOfWeek.MONDAY.getValue()) ||
				(dow.getValue() <= DayOfWeek.SATURDAY.getValue())) {
			return true;					
		}
		return false;
	}

	public LocalDate getNextDefaultWorkingDay(LocalDate inputDate) throws MyOwnException {
		final String sourceMethod = "getNextDefaultWorkingDay";
		LocalDate resultDate = inputDate;
		try {
			DayOfWeek dow = inputDate.getDayOfWeek();
			if (dow.getValue() == DayOfWeek.SATURDAY.getValue()) {
				return resultDate.plusDays(2);
			}
			if (dow.getValue() == DayOfWeek.SUNDAY.getValue()) {
				return resultDate.plusDays(1);
			}
		} catch (Exception e){
			logger.logp(Level.SEVERE, sourceClass, sourceMethod, "Not Valid Input date:" +inputDate.toString());
			throw new MyOwnException("Exception during obtain nex Arabian working day");
		}
		return resultDate;
	}
	
	

}
