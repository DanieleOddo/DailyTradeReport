package com.jpmorgan.InstructionTradeReport;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.jpmorgan.InstructionTradeReport.exception.MyOwnException;
import com.jpmorgan.InstructionTradeReport.model.InstructionEntity;

public class CreateListOutgoingDetailsTest {

	@Test
	public void testListOutDetail_Positive() throws MyOwnException {
		List<InstructionEntity> lista = new ArrayList<InstructionEntity>();
		InstructionEntity instruct = new InstructionEntity();
		instruct.setAgreedFx("0.50");
		instruct.setCurrency("AED");
		instruct.setEntity("foo1");
		instruct.setFlgAction("B");
		instruct.setInstructionDate("07 May 2017");
		instruct.setPricePerUnit("100.10");
		instruct.setSettlementDate("08 May 2017");
		instruct.setUnits("10");
		lista.add(instruct);
		CreateListOutgoingDetails listOut = new CreateListOutgoingDetails();
		assertEquals(1, listOut.listOutDetail(lista).size());
	}
	@Test(expected = MyOwnException.class)
	public void testListOutDetail_Exception() throws MyOwnException {
		List<InstructionEntity> lista = new ArrayList<InstructionEntity>();
		InstructionEntity instruct = new InstructionEntity();
		instruct.setAgreedFx("0.50");
		instruct.setCurrency("EUR");
		instruct.setEntity("foo1");
		instruct.setFlgAction("C");
		instruct.setInstructionDate("07 May 2017");
		instruct.setPricePerUnit("100.10");
		instruct.setSettlementDate("08 May 2017");
		instruct.setUnits("10");
		lista.add(instruct);
		CreateListOutgoingDetails listOut = new CreateListOutgoingDetails();
		assertEquals(1, listOut.listOutDetail(lista).size());
	}

	@Test
	public void testGetWorkingDay() throws MyOwnException {
		String currency = "EUR";
		String inputDate = "08 May 2017";
		CreateListOutgoingDetails listOut = new CreateListOutgoingDetails();
		assertEquals(LocalDate.of(2017, 5, 8), listOut.getWorkingDay(inputDate, currency));
	}

}
