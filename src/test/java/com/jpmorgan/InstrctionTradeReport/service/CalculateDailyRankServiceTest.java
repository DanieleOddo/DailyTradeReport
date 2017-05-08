package com.jpmorgan.InstrctionTradeReport.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.jpmorgan.InstructionTradeReport.exception.MyOwnException;
import com.jpmorgan.InstructionTradeReport.model.BuySellActionEnum;
import com.jpmorgan.InstructionTradeReport.model.OutgoingDetailEntity;
import com.jpmorgan.InstructionTradeReport.model.RankEntity;
import com.jpmorgan.InstructionTradeReport.service.CalculateDailyRankService;

public class CalculateDailyRankServiceTest {
	
	private static final LocalDate MONDAY    = LocalDate.of(2017, 5, 8);
    private static final LocalDate TUESDAY   = LocalDate.of(2017, 5, 9);
    private static final LocalDate WEDNESDAY = LocalDate.of(2017, 5, 10);
    private static final LocalDate SATURDAY  = LocalDate.of(2017, 5, 11);
    private static final LocalDate SUNDAY    = LocalDate.of(2017, 5, 12);

	@Test
	public void testDailyOutgoingRank() throws MyOwnException {
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
		outDetail1.setOutgoingDate(LocalDate.of(2017, 5, 9));  
		outDetail1.setAmount(new BigDecimal("200"));
		lista.add(outDetail1);
		
		CalculateDailyRankService rankIncoming = new CalculateDailyRankService();
		Map<LocalDate, List<RankEntity>> dailyIncomingRank = rankIncoming.dailyIncomingRank(lista);
		for (LocalDate date : dailyIncomingRank.keySet()) {
			 for (RankEntity rank : dailyIncomingRank.get(date)) {
				 System.out.println(" Date : " + date.toString() + " | Rank : " + rank.getRank() + " | Entity : " + rank.getEntity());
			 }			
		}
		assertEquals(2, rankIncoming.dailyOutgoingRank(lista).size());
	}

	@Test
	public void testDailyIncomingRank() throws MyOwnException {
		List<OutgoingDetailEntity> lista = new ArrayList<OutgoingDetailEntity>();
		OutgoingDetailEntity outDetail = new OutgoingDetailEntity();
		outDetail.setAction(BuySellActionEnum.SELL);
		outDetail.setEntity("Bar1");
		outDetail.setOutgoingDate(LocalDate.of(2017, 5, 8));  // Monday
		outDetail.setAmount(new BigDecimal("100"));
		lista.add(outDetail);
		
		OutgoingDetailEntity outDetail1 = new OutgoingDetailEntity();
		outDetail1.setAction(BuySellActionEnum.SELL);
		outDetail1.setEntity("Bar2");
		outDetail1.setOutgoingDate(LocalDate.of(2017, 5, 8));  
		outDetail1.setAmount(new BigDecimal("200"));
		lista.add(outDetail1);
		
		CalculateDailyRankService rankOutgoing = new CalculateDailyRankService();
		Map<LocalDate, List<RankEntity>> dailyOutcomingRank = rankOutgoing.dailyOutgoingRank(lista);
		for (LocalDate date : dailyOutcomingRank.keySet()) {
			 for (RankEntity rank : dailyOutcomingRank.get(date)) {
				 System.out.println(" Date : " + date.toString() + " | Rank : " + rank.getRank() + " | Entity : " + rank.getEntity());
			 }			
		}
		assertEquals(1, rankOutgoing.dailyOutgoingRank(lista).size());
	}

}
