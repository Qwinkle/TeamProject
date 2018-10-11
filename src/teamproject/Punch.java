package teamproject;


import java.util.GregorianCalendar;
public class Punch {
    private int terminalId, punchTypeId;
    private Badge badge;
    private long timestamp;
    private GregorianCalendar cal = new GregorianCalendar();
    

    public Punch(int terminalId, int punchTypeId, Badge badge, long timestamp) {
        this.terminalId = terminalId;
        this.punchTypeId = punchTypeId;
        this.badge = badge;
        this.timestamp = timestamp;
        cal.setTimeInMillis(timestamp);
        
    }
    public String printOriginalTimeStamp(){
        return null;
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

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public GregorianCalendar getCal() {
        return cal;
    }

    public void setCal(GregorianCalendar cal) {
        this.cal = cal;
    }
    
  
  
}