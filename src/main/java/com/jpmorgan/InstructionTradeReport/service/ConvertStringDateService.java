/**
 * 
 */
package com.jpmorgan.InstructionTradeReport.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jpmorgan.InstructionTradeReport.exception.MyOwnException;

/**
 * @author Daniele Oddo
 *
 */
public class ConvertStringDateService {
	
	private static final String sourceClass = ConvertStringDateService.class.getName();
	private Logger logger = Logger.getLogger(sourceClass);
	
	public LocalDate convertStringInDate(String inputDate) throws MyOwnException {
		final String sourceMethod = "convertStringInDate";
		try {
			if ((inputDate.isEmpty()) || (inputDate == null)) {
				return null;
			} else {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.US);
				LocalDate date = LocalDate.parse(inputDate, formatter);
				return date;
			}
		} catch (Exception e) {
			logger.logp(Level.SEVERE, sourceClass, sourceMethod, "Failed to Convert Date", e.getMessage());
			throw new MyOwnException("Exception during Convert Date");
		 
		}
	}
}

