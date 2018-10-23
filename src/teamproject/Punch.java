package teamproject;
import java.sql.Timestamp;
import java.sql.Time;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
public class Punch {
    private int terminalId, punchTypeId;
    private Badge badge;
    private long origtimestamp, adjustts;
    GregorianCalendar greCal = new GregorianCalendar();

    public Punch(int terminalId, int punchTypeId, Badge badge, long origtimestamp, long adjustts) {
        this.terminalId = terminalId;
        this.punchTypeId = punchTypeId;
        this.badge = badge;
        this.origtimestamp = origtimestamp;
        this.adjustts = adjustts;
        greCal.setTimeInMillis(origtimestamp);
    }
    public long OriginalTimeStamp(){
      System.out.println(greCal.get(GregorianCalendar.YEAR)); 
      System.out.println(greCal.get(GregorianCalendar.MONTH)); 
      System.out.println(greCal.get(GregorianCalendar.DAY_OF_WEEK));
      System.out.println(greCal.);
          
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

    public long getAdjustts() {
        return adjustts;
    }

    
    

    
        
    
    
  
  
}