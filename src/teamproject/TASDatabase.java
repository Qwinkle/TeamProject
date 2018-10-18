package teamproject;

import java.sql.*;

/**
 *
 * @author qwink
 */
public class TASDatabase {
    public TASDatabase(){
       
        Connection conn = null;
        PreparedStatement stmt = null, pstUpdate = null;
        ResultSet rs = null;
        
        try{
            
            String server = ("jdbc:mysql://localhost/tas");
            String username = "tasuser";
            String password = "cs310";
            System.out.println("Connecting to " + server + "...");
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            conn = DriverManager.getConnection(server, username, password);
            
            if (conn.isValid(0)){
                System.out.println("Connected Succesfully");
            }
            
        }
        
        catch (Exception e){
            System.err.println(e.toString());
        }
        
    }
    
    
    public Badge getBadge() {
        return null;
    }

    public Punch getPush() {
        return null;
    }

    public Shift getShift(int id) {
        return null;
    }
    
    public Shift getShift(Badge badge){
        return null;
    }
    
}
