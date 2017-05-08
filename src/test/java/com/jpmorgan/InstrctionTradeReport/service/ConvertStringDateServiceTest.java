/**
 * 
 */
package com.jpmorgan.InstrctionTradeReport.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jpmorgan.InstructionTradeReport.exception.MyOwnException;
import com.jpmorgan.InstructionTradeReport.service.ConvertStringDateService;

/**
 * @author it026633
 *
 */
public class ConvertStringDateServiceTest {

	/**
	 * Test method for {@link com.jpmorgna.test1.service.ConvertStringDateService#convertStringInDate(java.lang.String)}.
	 * @throws MyOwnException 
	 */
	@Test
	public void testConvertStringInDate_Negative() throws MyOwnException {
		String inputDate = "";
		ConvertStringDateService convertStrDate = new ConvertStringDateService();
		assertNull(convertStrDate.convertStringInDate(inputDate));
	}

	@Test(expected = MyOwnException.class)
	public void testConvertStringInDate_Exception() throws MyOwnException {
		String inputDate = "02 Jan 201";
		ConvertStringDateService convertStrDate = new ConvertStringDateService();
		assertNotNull(convertStrDate.convertStringInDate(inputDate));
	}
	
	@Test
	public void testConvertStringInDate_Positive() throws MyOwnException {
		String inputDate = "02 Jan 2016";
		ConvertStringDateService convertStrDate = new ConvertStringDateService();
		assertNotNull(convertStrDate.convertStringInDate(inputDate));
	}
}
