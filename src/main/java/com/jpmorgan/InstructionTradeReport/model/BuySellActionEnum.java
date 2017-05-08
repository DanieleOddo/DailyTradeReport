/**
 * 
 */
package com.jpmorgan.InstructionTradeReport.model;

/**
 * @author Daniele Oddo
 *
 */
public enum BuySellActionEnum {
	
	BUY("B"),
    SELL("S");

    private String action;

    BuySellActionEnum(String action) {
        this.action = action;
    }

    public String getText() {
        return this.action;
    }

    public static BuySellActionEnum fromString(String action) {

        if (action != null) {
            for (BuySellActionEnum tmp : BuySellActionEnum.values()) {
                if (action.equalsIgnoreCase(tmp.action)) {
                    return tmp;
                }
            }
            throw new IllegalArgumentException("No valid action:" + action + " found");
        } else {
            throw new NullPointerException("NullPointException for Trade Action");
        }
    }

}
