package sef.module13.activity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {

	private Connection conn;
	private PreparedStatement statement;
	private ResultSet rows = null;
	
	private static final int EMPLOYEE_COLUMN_ID = 1;
	private static final int EMPLOYEE_COLUMN_FIRST_NAME = 2;
    private static final int EMPLOYEE_COLUMN_LAST_NAME = 3;
    private static final int EMPLOYEE_COLUMN_EMAIL = 4;
    
    
    private static final String GET_EMPLOYEES = "SELECT id, first_name, last_name, email FROM account";
	private static final String FIND_EMPLOYEE_ACCOUNT_BY_NAME = GET_EMPLOYEES + " WHERE first_name = ? AND last_name = ?";
	private static final String FIND_EMPLOYEE_ACCOUNT_BY_ID = GET_EMPLOYEES + " WHERE id = ?";
	private static final String INSERT_EMPLOYEE_DETAILS = "INSERT INTO account (id, first_name, last_name, email) VALUES (?,?,?,?)";
	
	
	public AccountDAOImpl(Connection conn) {
		this.conn = conn;

	}

	public List<Account> findAccount(String firstName, String lastName)
			throws AccountDAOException {
	    
	    List<Account> employeeAccountsFoundByName = new ArrayList<>();
	    AccountImpl accountImpl = null;
	    
	    try {
            statement = this.conn.prepareStatement(FIND_EMPLOYEE_ACCOUNT_BY_NAME);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            
            rows = statement.executeQuery();
            
            while(rows.next()) {
                accountImpl = this.toAccountImpl(rows);
                employeeAccountsFoundByName.add(accountImpl);
            }
            
            
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//	    finally{
//	        closeAll();
//	    }
	    
		
		return employeeAccountsFoundByName;
	}

	public Account findAccount(int id) throws AccountDAOException {
	    AccountImpl accountImpl = null;
	    
	    try {
            statement = this.conn.prepareStatement(FIND_EMPLOYEE_ACCOUNT_BY_ID);
            statement.setInt(1, id);
            
            rows = statement.executeQuery();
            
            while(rows.next()) {
                accountImpl = toAccountImpl(rows);
            }
            
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	    
//	    finally {
//	        closeAll();
//	    }
	    
		
		return accountImpl;
	}


	public boolean insertAccount(String firstName, String lastName, String email)
			throws AccountDAOException {
	    int counter = 0;
	    try {
            statement = this.conn.prepareStatement(INSERT_EMPLOYEE_DETAILS);
            statement.setString(EMPLOYEE_COLUMN_FIRST_NAME, firstName);
            statement.setString(EMPLOYEE_COLUMN_LAST_NAME, lastName);
            statement.setString(EMPLOYEE_COLUMN_EMAIL, email);
            
            rows = statement.executeQuery();
            
            while(rows.next()) {
                counter++;
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	    

		
		return counter == 0;
	}
	
	
	private void closeAll() {
	    if(statement != null)
            try {
                if(statement != null)
                    statement.close();
                if(rows != null)
                    rows.close();
                this.conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                System.out.println(String.format("Sql error: %s", e.getMessage()));
                System.out.println(String.format("Sql error code: ", e.getErrorCode()));
                
            }
	
	}
	
	private AccountImpl toAccountImpl(ResultSet t) throws SQLException {
	    AccountImpl accountImpl = new AccountImpl(t.getInt(EMPLOYEE_COLUMN_ID),
	                                              t.getString(EMPLOYEE_COLUMN_FIRST_NAME), 
	                                              t.getString(EMPLOYEE_COLUMN_LAST_NAME),
	                                              t.getString(EMPLOYEE_COLUMN_EMAIL));
	    
	    
	    
	    return accountImpl;
	}
	

}
