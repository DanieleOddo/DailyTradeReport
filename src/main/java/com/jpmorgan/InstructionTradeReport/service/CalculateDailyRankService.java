/**
 * 
 */
package com.jpmorgan.InstructionTradeReport.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import com.jpmorgan.InstructionTradeReport.exception.MyOwnException;
import com.jpmorgan.InstructionTradeReport.model.OutgoingDetailEntity;
import com.jpmorgan.InstructionTradeReport.model.RankEntity;

/**
 * @author it026633
 *
 */
public class CalculateDailyRankService extends PredicateService {
	
	private static final String sourceClass = CalculateDailyRankService.class.getSimpleName();
	private Logger logger = Logger.getLogger(sourceClass);
	
	// Calculate Rank OutGoing By Date
	public Map<LocalDate, List<RankEntity>> dailyOutgoingRank(List<OutgoingDetailEntity> outDetailList) throws MyOwnException {
		return calculateDailyRanking(outDetailList, outgoingOutgoingPredicate);
	}
	 	
	// Calculate Rank Incoming By Date
	public Map<LocalDate, List<RankEntity>> dailyIncomingRank(List<OutgoingDetailEntity> outDetailList) throws MyOwnException {
		return calculateDailyRanking(outDetailList, incomingOutgoingPredicate);
	}

	// Genarate list of ranking by predicate
	private Map<LocalDate, List<RankEntity>> calculateDailyRanking (
			List<OutgoingDetailEntity> outList, Predicate<OutgoingDetailEntity> predicate) throws MyOwnException {
			
		final String sourceMethod = "calculateDailyRanking";
		try {
			Map<LocalDate, List<OutgoingDetailEntity>> streamDetail = (Map<LocalDate, List<OutgoingDetailEntity>>) outList.stream()
					.filter(predicate)
					.sorted(Comparator.comparing(OutgoingDetailEntity::getAmount).reversed())
					.collect(Collectors.groupingBy(OutgoingDetailEntity::getOutgoingDate));
			
			Map<LocalDate, List<RankEntity>> mapResult = new HashMap<LocalDate, List<RankEntity>>();
			
			for (LocalDate date : streamDetail.keySet()) {
				List<RankEntity> listRanks = new ArrayList<RankEntity>();
				int numRank = 0;
				for (OutgoingDetailEntity outDet : streamDetail.get(date)) {
	              	RankEntity rank = new RankEntity();
	    			rank.setDate(outDet.getOutgoingDate());
	    			rank.setEntity(outDet.getEntity());
	    			numRank = numRank + 1;
	    			rank.setRank(numRank);
	    			listRanks.add(rank);
	            }
				mapResult.put(date, listRanks);
	        }
			
			return mapResult;		
			
		} catch (Exception e) {
			logger.logp(Level.SEVERE, sourceClass, sourceMethod, "Exception create rank list : ", e.getClass().getSimpleName());
			throw new MyOwnException("Exception create rank list : " +e.getClass().getSimpleName());
		}
	}
}
