package teamproject;
import java.sql.Timestamp;
import java.sql.Time;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.time.temporal.ChronoUnit;
import java.time.LocalTime;
import java.util.Calendar;
public class Punch {
    
    public static final int CLOCKED_IN = 1;
    public static final int CLOCKED_OUT = 0;
    public static final int TIMED_OUT=2;
    
    private int terminalId, punchTypeId, ID;
    private Badge badge;
    private long origtimestamp, adjusttimestamp;
    

    public Punch(int terminalId, int punchTypeId, int ID, Badge badge, long origtimestamp) {
        this.terminalId = terminalId;
        this.punchTypeId = punchTypeId;
        this.ID = ID;
        this.badge = badge;
        this.origtimestamp = origtimestamp;
        this.adjusttimestamp = origtimestamp;
        
       
       
    }
        public String printOriginalTimeStamp(){
            
            GregorianCalendar greCal = new GregorianCalendar();
            greCal.setTimeInMillis(origtimestamp);
            
            SimpleDateFormat sdf = new SimpleDateFormat("EEE mm/dd/yyyy HH:mm:ss");
            
            StringBuilder s = new StringBuilder();
            
            s.append("#");
            s.append(badge.getId());
            s.append(" ");
            //punchtypes here
            switch(punchTypeId){
                case CLOCKED_IN: s.append("CLOCKED IN");
                    break;
                case CLOCKED_OUT: s.append("CLOCKED OUT");
                    break;
                default: s.append("TIMED OUT");
            }
            s.append(" ");
            
            s.append (sdf.format(greCal.getTime()).toUpperCase());
            
            return(s.toString());
            
        }
        
    
      public String printAdjustedTimeStamp(){
            
            GregorianCalendar greCal = new GregorianCalendar();
            greCal.setTimeInMillis(origtimestamp);
            
            SimpleDateFormat sdf = new SimpleDateFormat("EEE MM/dd/yyyy HH:mm:ss");
            
            StringBuilder s = new StringBuilder();
            
            s.append("#");
            s.append(badge.getId());
            s.append(" ");
            //punchtypes here
            switch(punchTypeId){
                case CLOCKED_IN: s.append("CLOCKED IN");
                    break;
                case CLOCKED_OUT: s.append("CLOCKED OUT");
                    break;
                default: s.append("TIMED OUT");
            }
            s.append(" ");
            
            s.append (sdf.format(greCal.getTime()).toUpperCase());
            
            return(s.toString());
            
        }
      
      public void adjust (Shift s){
          
          GregorianCalendar shiftStart = new GregorianCalendar();
          shiftStart.setTimeInMillis(origtimestamp);
          shiftStart.set(Calendar.HOUR, s.getShiftStartHour());
          shiftStart.set(Calendar.MINUTE, s.getShiftStartMinute());
          shiftStart.set(Calendar.SECOND, 0);
          long shiftStartLong = shiftStart.getTimeInMillis();
          
          GregorianCalendar shiftStop = new GregorianCalendar();
          shiftStop.setTimeInMillis(origtimestamp);
          shiftStop.set(Calendar.HOUR, s.getShiftStopHour());
          shiftStop.set(Calendar.MINUTE, s.getShiftStartMinute());
          shiftStop.set(Calendar.SECOND, 0);
          
          
          
      }
    
        
                        
                    
    

    public int getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(int terminalId) {
        this.terminalId = terminalId;
    }

    public int getPunchTypeId() {
        return punchTypeId;
    }

    public void setPunchTypeId(int punchTypeId) {
        this.punchTypeId = punchTypeId;
    }

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }

    public long getOrigtimestamp() {
        return origtimestamp;
    }

    public void setOrigtimestamp(long origtimestamp) {
        this.origtimestamp = origtimestamp;
    }

    public long getAdjusttimestamp() {
        return adjusttimestamp;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    

    
    

    
        
    
    
  
  
}