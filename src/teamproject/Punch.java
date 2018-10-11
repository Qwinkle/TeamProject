package teamproject;


import java.util.GregorianCalendar;
public class Punch {
    private int terminalId, punchTypeId;
    private Badge badge;
    private long origtimestamp, adjustts;

    public Punch(int terminalId, int punchTypeId, Badge badge, long origtimestamp, long adjustts) {
        this.terminalId = terminalId;
        this.punchTypeId = punchTypeId;
        this.badge = badge;
        this.origtimestamp = origtimestamp;
        this.adjustts = adjustts;
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

    public void setAdjustts(long adjustts) {
        this.adjustts = adjustts;
    }
    

    
        
    
    
  
  
}