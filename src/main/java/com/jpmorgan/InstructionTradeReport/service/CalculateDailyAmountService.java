/**
 * 
 */
package com.jpmorgan.InstructionTradeReport.service;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.reducing;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.jpmorgan.InstructionTradeReport.CreateListOutgoingDetails;
import com.jpmorgan.InstructionTradeReport.model.BuySellActionEnum;
import com.jpmorgan.InstructionTradeReport.model.OutgoingDetailEntity;
import com.jpmorgan.InstructionTradeReport.model.RankEntity;

/**
 * @author it026633
 *
 */
public class CalculateDailyAmountService extends PredicateService {
	
	private static final String sourceClass = CalculateDailyAmountService.class.getSimpleName();
	private Logger logger = Logger.getLogger(sourceClass);
	
	// Calculate Incoming Amount By Date
	public Map<LocalDate, BigDecimal> calculateDailyIncomingAmount(List<OutgoingDetailEntity> outDetailList) {
		        return calculateDailyAmount(outDetailList, incomingOutgoingPredicate);
    }
	
	// Calculate OutGoing Amount By Date
	public Map<LocalDate, BigDecimal> calculateDailyOutgoingAmount(List<OutgoingDetailEntity> outDetailList) {
			        return calculateDailyAmount(outDetailList, outgoingOutgoingPredicate);
	}

    private Map<LocalDate, BigDecimal> calculateDailyAmount(
	            List<OutgoingDetailEntity> outDetailList, Predicate<OutgoingDetailEntity> predicate) {
	        return outDetailList.stream()
	                .filter(predicate)
	                .collect(groupingBy(OutgoingDetailEntity::getOutgoingDate,
	                    mapping(OutgoingDetailEntity::getAmount,
	                        reducing(BigDecimal.ZERO, BigDecimal::add))));
	}
    
    	
}    		

