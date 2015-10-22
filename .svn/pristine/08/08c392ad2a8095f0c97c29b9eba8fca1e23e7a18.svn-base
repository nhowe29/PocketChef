package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.CallableStatement;

public class DataAccess
{
	private static final String url = "jdbc:mysql://mysql.cs.iastate.edu/db30910";
    private static final String user = "u30910";
    private static final String pass = "YSBGwKwZN";
    private static Connection con;
    
    public DataAccess()
    {
    	 
    }
    
    public static String getUserByID(int userID)
    {
    	try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, user, pass);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    	
    	ResultSet rs = null;
    	String ret = null;
    	try {
    		CallableStatement cs = null;
        	cs = (CallableStatement) con.prepareCall("{call Users_GetUserByID(?)}");
        	cs.setInt(1, userID);
        	rs = cs.executeQuery();
        	rs.next();
        	ret = rs.getString(2);
        	con.close();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	return ret;
    }
}
