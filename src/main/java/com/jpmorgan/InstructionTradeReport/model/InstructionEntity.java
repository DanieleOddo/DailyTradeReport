/**
 * 
 */
package com.jpmorgan.InstructionTradeReport.model;

import java.io.Serializable;

/**
 * @author it026633
 *
 */
public class InstructionEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7462615511881668422L;
	private String entity;
	private String flgAction;
	private String agreedFx;
	private String currency;
	private String instructionDate;
	private String settlementDate;
	private String units;
	private String pricePerUnit;
	/**
	 * 
	 */
	public InstructionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param entity
	 * @param flgAction
	 * @param agreedFx
	 * @param currency
	 * @param instructionDate
	 * @param settlementDate
	 * @param units
	 * @param pricePerUnit
	 */
	public InstructionEntity(String entity, String flgAction, String agreedFx, String currency, String instructionDate,
			String settlementDate, String units, String pricePerUnit) {
		super();
		this.entity = entity;
		this.flgAction = flgAction;
		this.agreedFx = agreedFx;
		this.currency = currency;
		this.instructionDate = instructionDate;
		this.settlementDate = settlementDate;
		this.units = units;
		this.pricePerUnit = pricePerUnit;
	}
	/**
	 * @return the entity
	 */
	public String getEntity() {
		return entity;
	}
	/**
	 * @param entity the entity to set
	 */
	public void setEntity(String entity) {
		this.entity = entity;
	}
	/**
	 * @return the flgAction
	 */
	public String getFlgAction() {
		return flgAction;
	}
	/**
	 * @param flgAction the flgAction to set
	 */
	public void setFlgAction(String flgAction) {
		this.flgAction = flgAction;
	}
	/**
	 * @return the agreedFx
	 */
	public String getAgreedFx() {
		return agreedFx;
	}
	/**
	 * @param agreedFx the agreedFx to set
	 */
	public void setAgreedFx(String agreedFx) {
		this.agreedFx = agreedFx;
	}
	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	/**
	 * @return the instructionDate
	 */
	public String getInstructionDate() {
		return instructionDate;
	}
	/**
	 * @param instructionDate the instructionDate to set
	 */
	public void setInstructionDate(String instructionDate) {
		this.instructionDate = instructionDate;
	}
	/**
	 * @return the settlementDate
	 */
	public String getSettlementDate() {
		return settlementDate;
	}
	/**
	 * @param settlementDate the settlementDate to set
	 */
	public void setSettlementDate(String settlementDate) {
		this.settlementDate = settlementDate;
	}
	/**
	 * @return the units
	 */
	public String getUnits() {
		return units;
	}
	/**
	 * @param units the units to set
	 */
	public void setUnits(String units) {
		this.units = units;
	}
	/**
	 * @return the pricePerUnit
	 */
	public String getPricePerUnit() {
		return pricePerUnit;
	}
	/**
	 * @param pricePerUnit the pricePerUnit to set
	 */
	public void setPricePerUnit(String pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	
	

}
