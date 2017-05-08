package com.jpmorgan.InstrctionTradeReport.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.jpmorgan.InstructionTradeReport.model.BuySellActionEnum;
import com.jpmorgan.InstructionTradeReport.model.OutgoingDetailEntity;
import com.jpmorgan.InstructionTradeReport.service.CalculateDailyAmountService;

public class CalculateDailyAmountServiceTest {
	
	private static final LocalDate MONDAY    = LocalDate.of(2017, 5, 8);
    private static final LocalDate TUESDAY   = LocalDate.of(2017, 5, 9);
    private static final LocalDate WEDNESDAY = LocalDate.of(2017, 5, 10);
    private static final LocalDate SATURDAY  = LocalDate.of(2017, 5, 11);
    private static final LocalDate SUNDAY    = LocalDate.of(2017, 5, 12);


	@Test
	public void testCalculateDailyIncomingAmount_Positive() {
		List<OutgoingDetailEntity> lista = new ArrayList<OutgoingDetailEntity>();
		OutgoingDetailEntity outDetail = new OutgoingDetailEntity();
		outDetail.setAction(BuySellActionEnum.BUY);
		outDetail.setEntity("foo1");
		outDetail.setOutgoingDate(LocalDate.of(2017, 5, 8));  // Monday
		outDetail.setAmount(new BigDecimal("100"));
		lista.add(outDetail);
		
		OutgoingDetailEntity outDetail1 = new OutgoingDetailEntity();
		outDetail1.setAction(BuySellActionEnum.BUY);
		outDetail1.setEntity("foo2");
		outDetail1.setOutgoingDate(LocalDate.of(2017, 5, 8));  // Monday
		outDetail1.setAmount(new BigDecimal("200"));
		lista.add(outDetail1);
		
		CalculateDailyAmountService calcIncoming = new CalculateDailyAmountService();
		BigDecimal expected = BigDecimal.valueOf(300.00).setScale(2, BigDecimal.ROUND_HALF_UP);
		Map<LocalDate, BigDecimal> mapResult = calcIncoming.calculateDailyIncomingAmount(lista);
	
		assertEquals(expected, mapResult.get(MONDAY).setScale(2, BigDecimal.ROUND_HALF_UP));
		
	}

	
	@Test
	public void testCalculateDailyOutgoingAmount_Positive() {
		List<OutgoingDetailEntity> lista = new ArrayList<OutgoingDetailEntity>();
		OutgoingDetailEntity outDetail = new OutgoingDetailEntity();
		outDetail.setAction(BuySellActionEnum.SELL);
		outDetail.setEntity("foo1");
		outDetail.setOutgoingDate(LocalDate.of(2017, 5, 9));  
		outDetail.setAmount(new BigDecimal("150"));
		lista.add(outDetail);
		
		OutgoingDetailEntity outDetail1 = new OutgoingDetailEntity();
		outDetail1.setAction(BuySellActionEnum.SELL);
		outDetail1.setEntity("foo2");
		outDetail1.setOutgoingDate(LocalDate.of(2017, 5, 9));  
		outDetail1.setAmount(new BigDecimal("200"));
		lista.add(outDetail1);
		
		CalculateDailyAmountService calcIncoming = new CalculateDailyAmountService();
		BigDecimal expected = BigDecimal.valueOf(350.00).setScale(2, BigDecimal.ROUND_HALF_UP);
		Map<LocalDate, BigDecimal> mapResult = calcIncoming.calculateDailyOutgoingAmount(lista);
	
		assertEquals(expected, mapResult.get(TUESDAY).setScale(2, BigDecimal.ROUND_HALF_UP));
	
	}

}
