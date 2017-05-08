/**
 * 
 */
package com.jpmorgan.InstructionTradeReport;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jpmorgan.InstructionTradeReport.exception.MyOwnException;
import com.jpmorgan.InstructionTradeReport.model.BuySellActionEnum;
import com.jpmorgan.InstructionTradeReport.model.InstructionEntity;
import com.jpmorgan.InstructionTradeReport.model.OutgoingDetailEntity;
import com.jpmorgan.InstructionTradeReport.service.ArabianWorkingDay;
import com.jpmorgan.InstructionTradeReport.service.ConvertStringDateService;
import com.jpmorgan.InstructionTradeReport.service.DefaultWorkingDay;

/**
 * @author Daniele Oddo
 *
 */
public class CreateListOutgoingDetails {
	
	private static final String sourceClass = CreateListOutgoingDetails.class.getSimpleName();
	private Logger logger = Logger.getLogger(sourceClass);
	
	public List<OutgoingDetailEntity> listOutDetail(List<InstructionEntity> list) throws MyOwnException {
		
		final String sourceMethod = "readFileInput";
		List<OutgoingDetailEntity> listOutDetails = new ArrayList<OutgoingDetailEntity>();
		try {
			// Check SattlemenDate & Currency for Know The right Date of Outgoing (First WorkDay)
			Iterator itr = list.iterator();
			while(itr.hasNext()) {
				InstructionEntity instruction = (InstructionEntity) itr.next();
				OutgoingDetailEntity outDetail = new OutgoingDetailEntity();
				
				LocalDate outgoingDate = getWorkingDay(instruction.getSettlementDate(), instruction.getCurrency());
				instruction.getAgreedFx();
				BigDecimal units = new BigDecimal(instruction.getUnits());
				units = units.setScale(2, BigDecimal.ROUND_HALF_UP);
				BigDecimal pricePerUnits = new BigDecimal(instruction.getPricePerUnit());
				pricePerUnits = pricePerUnits.setScale(2, BigDecimal.ROUND_HALF_UP);
				BigDecimal tmpAmount = pricePerUnits.multiply(units);
				BigDecimal agreedFx = new BigDecimal(instruction.getAgreedFx());
				agreedFx = agreedFx.setScale(2, BigDecimal.ROUND_HALF_UP);
				BigDecimal finalAmount = agreedFx.multiply(tmpAmount);
				outDetail.setAction(BuySellActionEnum.fromString(instruction.getFlgAction()));
				outDetail.setEntity(instruction.getEntity());
				outDetail.setAmount(finalAmount);
				outDetail.setOutgoingDate(outgoingDate);
				listOutDetails.add(outDetail);
			}
			return listOutDetails;
		} catch (Exception e) {
			logger.logp(Level.SEVERE, sourceClass, sourceMethod, "Exception creating outgoing detail: ", e.getClass().getSimpleName());
			throw new MyOwnException("Exception creating outgoing detail:" +e.getClass().getSimpleName());
		}
	}
	
	public LocalDate getWorkingDay(String inputDate, String currency) throws MyOwnException {
		final String sourceMethod = "getWorkingDay";	
		try {
			ConvertStringDateService convertDate = new ConvertStringDateService();
			if (((Currency.getInstance("AED").toString().equals(currency))) ||
					(Currency.getInstance("SAR").toString().equals(currency))) {
				ArabianWorkingDay awd = new ArabianWorkingDay();
				if (!awd.isArabianWorkingDay(convertDate.convertStringInDate(inputDate))) {
					return awd.getNextArabianWorkingDay(convertDate.convertStringInDate(inputDate));
				} else {
					return convertDate.convertStringInDate(inputDate); 
				}
			} else {
				DefaultWorkingDay dwd = new DefaultWorkingDay();
				if (!dwd.isDefaultWorkingDay(convertDate.convertStringInDate(inputDate))) {
					return dwd.getNextDefaultWorkingDay(convertDate.convertStringInDate(inputDate));
				} else {
					return convertDate.convertStringInDate(inputDate);
				}
			}
		} catch (Exception e) {
			logger.logp(Level.SEVERE, sourceClass, sourceMethod, "Exception getting Workingday : ", e.getClass().getSimpleName());
			throw new MyOwnException("Exception getting Workingday : " +e.getClass().getSimpleName());
		}
	}

}
