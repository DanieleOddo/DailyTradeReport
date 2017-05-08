/**
 * 
 */
package com.jpmorgan.InstructionTradeReport;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import com.jpmorgan.InstructionTradeReport.exception.MyOwnException;
import com.jpmorgan.InstructionTradeReport.model.OutgoingDetailEntity;
import com.jpmorgan.InstructionTradeReport.model.RankEntity;
import com.jpmorgan.InstructionTradeReport.service.CalculateDailyAmountService;
import com.jpmorgan.InstructionTradeReport.service.CalculateDailyRankService;

/**
 * @author it026633 Daniele Oddo
 *
 */
public class DailyTradeReportGenerator {
	
	public void inConsoleReport(List<OutgoingDetailEntity> lista) throws MyOwnException {
		
		CalculateDailyAmountService report = new CalculateDailyAmountService();
		
		Map<LocalDate, BigDecimal> dailyIncomingAmount = report.calculateDailyIncomingAmount(lista);
				
		System.out.println("---------------------------------------------------");
		System.out.println(" Daily Incoming Amoung in USD                     -");
		System.out.println("---------------------------------------------------");
		for (LocalDate date : dailyIncomingAmount.keySet()) {
			System.out.println(" Date : " + date.toString() + " | Amount : " + dailyIncomingAmount.get(date));
		}
		System.out.println("---------------------------------------------------");
		System.out.println("");
		
		Map<LocalDate, BigDecimal> dailyOutcomingAmount = report.calculateDailyOutgoingAmount(lista);
		
		System.out.println("---------------------------------------------------");
		System.out.println(" Daily Outcoming Amoung in USD                    -");
		System.out.println("---------------------------------------------------");
		for (LocalDate date : dailyOutcomingAmount.keySet()) {
			System.out.println(" Date : " + date.toString() + " | Amount : " + dailyOutcomingAmount.get(date));
		}
		
		System.out.println("---------------------------------------------------");
		System.out.println("");
		
		CalculateDailyRankService reportRank = new CalculateDailyRankService();
		Map<LocalDate, List<RankEntity>> dailyIncomingRank = reportRank.dailyIncomingRank(lista);
		
		System.out.println("---------------------------------------------------");
		System.out.println(" Daily Incoming Rank                              -");
		System.out.println("---------------------------------------------------");
		for (LocalDate date : dailyIncomingRank.keySet()) {
			 for (RankEntity rank : dailyIncomingRank.get(date)) {
				 System.out.println(" Date : " + date.toString() + " | Rank : " + rank.getRank() + " | Entity : " + rank.getEntity());
			 }			
		}
		
		System.out.println("---------------------------------------------------");
		System.out.println("");
		
		Map<LocalDate, List<RankEntity>> dailyOutgoingRank = reportRank.dailyOutgoingRank(lista);
		
		System.out.println("---------------------------------------------------");
		System.out.println(" Daily Outcoming Rank                             -");
		System.out.println("---------------------------------------------------");
		for (LocalDate date : dailyOutgoingRank.keySet()) {
			 for (RankEntity rank : dailyOutgoingRank.get(date)) {
				 System.out.println(" Date : " + date.toString() + " | Rank : " + rank.getRank() + " | Entity : " + rank.getEntity());
			 }			
		}
		
		System.out.println("---------------------------------------------------");
		System.out.println("");
		
	}
}