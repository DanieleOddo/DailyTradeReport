/**
 * 
 */
package com.jpmorgan.InstructionTradeReport.service;

import java.util.function.Predicate;

import com.jpmorgan.InstructionTradeReport.model.BuySellActionEnum;
import com.jpmorgan.InstructionTradeReport.model.OutgoingDetailEntity;

/**
 * @author it026633
 *
 */
public class PredicateService {
	
		// Create Predicate for Incoming
		protected static Predicate<OutgoingDetailEntity> incomingOutgoingPredicate = 
				outgoingDetailEntity -> outgoingDetailEntity.getAction().equals(BuySellActionEnum.BUY);
		// Create Predicate for Incoming
		protected static Predicate<OutgoingDetailEntity> outgoingOutgoingPredicate = 
				outgoingDetailEntity -> outgoingDetailEntity.getAction().equals(BuySellActionEnum.SELL);


}
