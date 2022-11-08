package sef.module8.activity;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Thsi class represents a simple representation of an account encapsulating
 * a name 
 * 
 * @author John Doe
 *
 */
public class Account {



	/**
	 * Creates an Account object with the specified name.  If the accout name
	 * given violates the minimum requirements, then an AccountException is thrown
	 * 
	 * @param accountName
	 * @throws AccountException
	 */
	String accountName;
	public  Account(String accountName) throws AccountException{
		
			if(accountName.length() <=4 ) {
				throw new AccountException(AccountException.NAME_TOO_SHORT, accountName );
			}
			
			String temp = accountName; 
			temp = temp.replaceAll("[0-9]", "");
			
			if(temp.length() == accountName.length()) {
				throw new AccountException(AccountException.NAME_TOO_SIMPLE, accountName );

			}
			else
				this.accountName = accountName;
			
	}
	
	
	/**
	 * Returns the account name
	 * 
	 * @return the account name
	 */
	public String getName(){
		return this.accountName;
	}
}
