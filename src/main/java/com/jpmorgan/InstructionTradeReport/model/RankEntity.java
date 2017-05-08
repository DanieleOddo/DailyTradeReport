/**
 * 
 */
package com.jpmorgan.InstructionTradeReport.model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author it026633
 *
 */
public class RankEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8397746267687914487L;
	private int rank;
    private String entity;
    private LocalDate date;
	/**
	 * 
	 */
	public RankEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param rank
	 * @param entity
	 * @param date
	 */
	public RankEntity(int rank, String entity, LocalDate date) {
		super();
		this.rank = rank;
		this.entity = entity;
		this.date = date;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((entity == null) ? 0 : entity.hashCode());
		result = prime * result + rank;
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RankEntity other = (RankEntity) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (entity == null) {
			if (other.entity != null)
				return false;
		} else if (!entity.equals(other.entity))
			return false;
		if (rank != other.rank)
			return false;
		return true;
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
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RankEntity [rank=" + rank + ", entity=" + entity + ", date=" + date + "]";
	}
    
}
