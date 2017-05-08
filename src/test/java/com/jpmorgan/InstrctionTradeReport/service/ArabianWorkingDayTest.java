/**
 * 
 */
package com.jpmorgan.InstrctionTradeReport.service;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import com.jpmorgan.InstructionTradeReport.exception.MyOwnException;
import com.jpmorgan.InstructionTradeReport.service.ArabianWorkingDay;

/**
 * @author it026633
 *
 */
public class ArabianWorkingDayTest {

	/**
	 * Test method for {@link com.jpmorgan.InstructionTradeReport.service.ArabianWorkingDay#isArabianWorkingDay(java.time.LocalDate)}.
	 * @throws MyOwnException 
	 */
	@Test
	public void testIsArabianWorkingDay_Positive() throws MyOwnException {
		LocalDate inputDate = LocalDate.of(2017, 5, 8);
		ArabianWorkingDay awd = new ArabianWorkingDay();
		assertTrue(awd.isArabianWorkingDay(inputDate));
	}
	
	@Test
	public void testIsArabianWorkingDay_Negative() throws MyOwnException {
		LocalDate inputDate = LocalDate.of(2017, 5, 5);
		ArabianWorkingDay awd = new ArabianWorkingDay();
		assertTrue(!awd.isArabianWorkingDay(inputDate));
	}

	/**
	 * Test method for {@link com.jpmorgan.InstructionTradeReport.service.ArabianWorkingDay#getNextArabianWorkingDay(java.time.LocalDate)}.
	 * @throws MyOwnException 
	 */
	@Test
	public void testGetNextArabianWorkingDay_gotMonday() throws MyOwnException {
		LocalDate inputDate = LocalDate.of(2017, 5, 5);
		ArabianWorkingDay awd = new ArabianWorkingDay();
		LocalDate expecteds = LocalDate.of(2017, 5, 8);
		assertEquals(expecteds, awd.getNextArabianWorkingDay(inputDate));
	}
	
	/**
	 * Test method for {@link com.jpmorgan.InstructionTradeReport.service.ArabianWorkingDay#getNextArabianWorkingDay(java.time.LocalDate)}.
	 * @throws MyOwnException 
	 */
	@Test
	public void testGetNextArabianWorkingDay_gotTheSame() throws MyOwnException {
		LocalDate inputDate = LocalDate.of(2017, 5, 9);
		ArabianWorkingDay awd = new ArabianWorkingDay();
		LocalDate expecteds = LocalDate.of(2017, 5, 9);
		assertEquals(expecteds, awd.getNextArabianWorkingDay(inputDate));
	}


}
