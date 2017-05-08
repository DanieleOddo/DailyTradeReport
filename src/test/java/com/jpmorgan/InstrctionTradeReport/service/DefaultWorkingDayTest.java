/**
 * 
 */
package com.jpmorgan.InstrctionTradeReport.service;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import com.jpmorgan.InstructionTradeReport.exception.MyOwnException;
import com.jpmorgan.InstructionTradeReport.service.ArabianWorkingDay;
import com.jpmorgan.InstructionTradeReport.service.DefaultWorkingDay;

/**
 * @author it026633
 *
 */
public class DefaultWorkingDayTest {

	/**
	 * Test method for {@link com.jpmorgan.InstructionTradeReport.service.DefaultWorkingDay#isDefaultWorkingDay(java.time.LocalDate)}.
	 */
	@Test
	public void testIsDefaultWorkingDay_Positive() {
		LocalDate inputDate = LocalDate.of(2017, 5, 8);
		DefaultWorkingDay dwd = new DefaultWorkingDay();
		assertTrue(dwd.isDefaultWorkingDay(inputDate));
	}
	
	/**
	 * Test method for {@link com.jpmorgan.InstructionTradeReport.service.DefaultWorkingDay#isDefaultWorkingDay(java.time.LocalDate)}.
	 */
	@Test
	public void testIsDefaultWorkingDay_Negative() {
		LocalDate inputDate = LocalDate.of(2017, 5, 7);
		DefaultWorkingDay dwd = new DefaultWorkingDay();
		assertTrue(dwd.isDefaultWorkingDay(inputDate));
	}

	/**
	 * Test method for {@link com.jpmorgan.InstructionTradeReport.service.DefaultWorkingDay#getNextDefaultWorkingDay(java.time.LocalDate)}.
	 * @throws MyOwnException 
	 */
	@Test
	public void testGetNextDefaultWorkingDay_gotMonday() throws MyOwnException {
		LocalDate inputDate = LocalDate.of(2017, 5, 6);
		DefaultWorkingDay dwd = new DefaultWorkingDay();
		LocalDate expecteds = LocalDate.of(2017, 5, 8);
		assertEquals(expecteds, dwd.getNextDefaultWorkingDay(inputDate));
	}

	/**
	 * Test method for {@link com.jpmorgan.InstructionTradeReport.service.DefaultWorkingDay#getNextDefaultWorkingDay(java.time.LocalDate)}.
	 * @throws MyOwnException 
	 */
	@Test
	public void testGetNextDefaultWorkingDay_gotTheSame() throws MyOwnException {
		LocalDate inputDate = LocalDate.of(2017, 5, 8);
		DefaultWorkingDay dwd = new DefaultWorkingDay();
		LocalDate expecteds = LocalDate.of(2017, 5, 8);
		assertEquals(expecteds, dwd.getNextDefaultWorkingDay(inputDate));
	}
}
