/**
 * 
 */
package com.jpmorgan.InstructionTradeReport.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author it026633
 *
 */
public class OutgoingDetailEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 268764021391224257L;
	private String entity;
	private BuySellActionEnum action;
	private LocalDate outgoingDate;
	private BigDecimal amount;
	private int rank;
	/**
	 * 
	 */
	public OutgoingDetailEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param entity
	 * @param action
	 * @param outgoingDate
	 * @param amount
	 * @param rank
	 */
	public OutgoingDetailEntity(String entity, BuySellActionEnum action, LocalDate outgoingDate, BigDecimal amount,
			int rank) {
		super();
		this.entity = entity;
		this.action = action;
		this.outgoingDate = outgoingDate;
		this.amount = amount;
		this.rank = rank;
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
	 * @return the action
	 */
	public BuySellActionEnum getAction() {
		return action;
	}
	/**
	 * @param action the action to set
	 */
	public void setAction(BuySellActionEnum action) {
		this.action = action;
	}
	/**
	 * @return the outgoingDate
	 */
	public LocalDate getOutgoingDate() {
		return outgoingDate;
	}
	/**
	 * @param outgoingDate the outgoingDate to set
	 */
	public void setOutgoingDate(LocalDate outgoingDate) {
		this.outgoingDate = outgoingDate;
	}
	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	/**
	 * @return the rank
	 */
	public int getRank() {
		return rank;
	}
	/**
	 * @param rank the rank to set
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	
}
