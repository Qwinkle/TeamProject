package teamproject;

import java.sql.*;

/**
 *
 * @author qwink
 */
public class TASDatabase {
    
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    String query;
    Boolean hasResults;    
        
    public TASDatabase(){
            
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
            
            stmt = conn.createStatement();
        }
        
        catch (Exception e){
            System.err.println(e.toString());
        }
        
    }
    
    
    public Badge getBadge(String id) {
        String desc = null;
        try {
            //prepare
              query = "SELECT * FROM Badge b WHERE id = '" + id + "'";
            
              rs = stmt.executeQuery(query);

             if (rs != null){
                 rs.next();
                 desc = rs.getString("description");
             }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        
        Badge badge = new Badge(id, desc);
        
        return badge;
    }

    public Punch getPunch(int id) {
        int terminalId = 0,punchTypeId = 0,ID = 0;
        long origtimestamp = 0;
        Badge badge = null;
        try {
            //prepare
              query = "SELECT * FROM Punch p WHERE id = '" + id + "'";
            
              rs = stmt.executeQuery(query);

             if (rs != null){
                 rs.next();
                 terminalId = rs.getInt("terminalid");
                 punchTypeId = rs.getInt("punchtypeid");
                 badge = this.getBadge(rs.getString("badgeid"));
             }
             
              query = "SELECT UNIX_TIMESTAMP(originaltimestamp) FROM punch p WHERE id = '" + id + "';";
            
              rs = stmt.executeQuery(query);

             if (rs != null){
                 rs.next();
                 origtimestamp = rs.getInt(1);
             }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        Punch punch = new Punch(terminalId, punchTypeId, ID, badge, origtimestamp * 1000);
        return punch;
    }

    public Shift getShift(int id) {
        return null;
    }
    
    public Shift getShift(Badge badge){
        return null;
    }
    
    public void close(){
        
        try { conn.close();} catch (Exception e) {System.err.println(e.toString());}
        
    }
}
