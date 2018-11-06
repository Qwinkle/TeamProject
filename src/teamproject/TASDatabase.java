package teamproject;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author qwink
 */
public class TASDatabase {
    
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pst = null;
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
        int terminalId = 0,punchTypeId = 0;
        long originaltimestamp = 0;
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
                 originaltimestamp = rs.getInt(1);
             }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        Punch punch = new Punch(terminalId, punchTypeId, id, badge, originaltimestamp * 1000);
        return punch;
    }

    public Shift getShift(int id) {
        int interval = 0, gracePeriod = 0, dock = 0, lunchDeduct = 0, shiftStartHour = 0, shiftStartMin = 0, shiftStopHour = 0, shiftStopMin = 0, lunchStartHour = 0, lunchStartMin = 0, lunchStopHour = 0, lunchStopMin = 0;
        String description = null;
        
        try {
            //prepare
              query = "SELECT * FROM Shift s WHERE id = '" + id + "'";
            
              rs = stmt.executeQuery(query);
              //get int fields and description
             if (rs != null){
                 rs.next();
                 description = rs.getString("description");
                 interval = rs.getInt("interval");
                 gracePeriod = rs.getInt("graceperiod");
                 dock = rs.getInt("dock");
                 lunchDeduct = rs.getInt("lunchdeduct");
             }
             
             //get time in hours
             query = "SELECT HOUR(start), HOUR(stop), HOUR(lunchstart), HOUR(lunchstop) FROM Shift s WHERE id = '" + id + "'";
             
             rs = stmt.executeQuery(query);
             
             if (rs != null){
                 rs.next();
                 shiftStartHour = rs.getInt("HOUR(start)");
                 shiftStopHour = rs.getInt("HOUR(stop)");
                 lunchStartHour = rs.getInt("HOUR(lunchstart)");
                 lunchStopHour = rs.getInt("HOUR(lunchstop)");
             }
             
             //get time in mins
             query = "SELECT MINUTE(start), MINUTE(stop), MINUTE(lunchstart), MINUTE(lunchstop) FROM Shift s WHERE id = '" + id + "'";
             
             rs = stmt.executeQuery(query);
             
             if (rs != null){
                 rs.next();
                 shiftStartMin = rs.getInt("MINUTE(start)");
                 shiftStopMin = rs.getInt("MINUTE(stop)");
                 lunchStartMin = rs.getInt("MINUTE(lunchstart)");
                 lunchStopMin = rs.getInt("MINUTE(lunchstop)");
             }
             
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        
        Shift shift = new Shift(interval, gracePeriod, dock, lunchDeduct, description, shiftStartHour, shiftStartMin, shiftStopHour, shiftStopMin, lunchStartHour, lunchStartMin, lunchStopHour, lunchStopMin);
        
        return shift;
    }
    
    public Shift getShift(Badge badge){
        String badgeid = badge.getId();
        int shiftid = 0;
        
        try{
            
            query = "SELECT shiftid FROM employee e WHERE badgeid = '" + badgeid + "'";
            
            rs = stmt.executeQuery(query);
            
            if (rs != null){
                rs.next();
                shiftid = rs.getInt("shiftid");
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        
        return getShift(shiftid);
    }
    
    public void insertPunch(Punch p){
        
        
        try{
            
            query = "INSERT INTO punch (terminalid, badgeid, originaltimestamp, punchtypeid) VALUES (?, ?, FROM_UNIXTIME(?), ?)";
            
            pst = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, Integer.toString(p.getTerminalid()));
            pst.setString(2,p.getBadge().getId());
            pst.setString(3, Long.toString(p.getOriginaltimestamp()/1000));
            pst.setString(4, Integer.toString(p.getPunchtypeid()));
            
            pst.executeUpdate();
            
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        
    }
    
    public ArrayList getDailyPunchList(Badge b, long ts){
        ArrayList<Punch> punches = new ArrayList<Punch>();
        
        return punches;
    }
    
    public void close(){
        
        try { conn.close();} catch (Exception e) {System.err.println(e.toString());}
        
    }
}
