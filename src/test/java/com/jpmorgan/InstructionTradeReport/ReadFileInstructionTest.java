/**
 * 
 */
package com.jpmorgan.InstructionTradeReport;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jpmorgan.InstructionTradeReport.exception.MyOwnException;

/**
 * @author it026633
 *
 */
public class ReadFileInstructionTest {

	/**
	 * Test method for {@link com.jpmorgan.InstructionTradeReport.ReadFileInstruction#readFileInput(java.lang.String)}.
	 */
	@Test(expected = MyOwnException.class)
	public void testReadFileInput_Exception() throws MyOwnException {
		ReadFileInstruction read = new ReadFileInstruction();
		assertNotNull(read.readFileInput("instruction.txt"));
	}

	@Test
	public void testReadFileInput_Positive() throws MyOwnException {
		ReadFileInstruction read = new ReadFileInstruction();
		assertNotNull(read.readFileInput("instruction.csv"));
	}

}
