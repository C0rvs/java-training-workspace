package sef.module7.activity;

import java.util.*;



/**
 * Represents an implementation of the Currency interface.  The equality test for
 * this currency implementation requires that the value and the name of the denomination
 * must be true in order to be considered equal.
 * 
 * @author John Doe
 *
 */
public class CurrencyImpl implements Currency {


	/**
	 * Creates an instance of the of the Currency class with the specified
	 * value and denomination
	 * 
	 * @param value the value of the currency 
	 * @param denomination the denomination of the currency
	 * 
	 */
	float value;
	Denomination denomination; 
	
	public CurrencyImpl(float value, Denomination denomination) {
	    System.out.println(String.format("Value = %s,%s,%s ", denomination.getDescription(),denomination.getName(),denomination.getSymbol() ));
		this.denomination = denomination;
		
		this.value = value;
        System.out.println(String.format("Value = %s,%s,%s ", this.denomination.getDescription(),this.denomination.getName(),this.denomination.getSymbol() ));

		
	}

	/* (non-Javadoc)
	 * @see sef.module6.activity.Currency#getValue()
	 */
	public float getValue() {
	    float temp = this.value;
		return temp;
	}

	/* (non-Javadoc)
	 * @see sef.module6.activity.Currency#getDenomination()
	 */
	public Denomination getDenomination() {
	    Denomination denomination = this.denomination;
		return denomination;
	}

	/* (non-Javadoc)
	 * @see sef.module6.activity.Currency#getCreateDate()
	 */
	public Calendar getCreateDate() {
        TimeZone today = TimeZone.getTimeZone("America/North_Dakota/New_Salem\r\n"
                + "");
        Calendar calendar = Calendar.getInstance(today);
	    return calendar;
       //return null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		//
		return this.toString();

	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	
	/*
	 *
	 * ((Currency) o).getValue() == this.value && 
                    ((Currency)o).getDenomination().
                    getName().
                    equals(this.getDenomination().getName()) &&
                    ((Currency)o).getDenomination().
                    getDescription().
                    equals(this.getDenomination().getDescription()) 
                    &&
                    ((Currency)o).getDenomination().
                    getSymbol().
                    
                    equals(this.getDenomination().getSymbol())
                    */
	public boolean equals(Object o) {
		if(o instanceof Currency) {
			if(   !((Currency)o).getDenomination().
                    getSymbol().
                    
                    equals(this.getDenomination().getSymbol()) &&
                    ((Currency)o).getValue() != this.getValue()
			        ) {
				return false;
			}
		}
		return true;
	}

}
