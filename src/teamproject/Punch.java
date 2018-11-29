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
    
    private int terminalid, Punchtypeid, id;
    private Badge badge;
    private long originaltimestamp, adjustedtimestamp;

    public Punch(int terminalid, int Punchtypeid, int id, Badge badge, long originaltimestamp, long adjusttimestamp) {
        this.terminalid = terminalid;
        this.Punchtypeid = Punchtypeid;
        this.id = id;
        this.badge = badge;
        this.originaltimestamp = originaltimestamp;
        this.adjustedtimestamp = adjusttimestamp;
    }
    public Punch(Badge Badge, int terminalid, int Punchtypeid){
        this.badge = Badge;
        this.terminalid=terminalid;
        this.Punchtypeid=Punchtypeid;
        
        GregorianCalendar greCal = new GregorianCalendar();
        
        originaltimestamp = greCal.getTimeInMillis();
    }

   
        
       
       
    
    public Punch (int terminalid, int Punchtypeid, int id, Badge badge, long originaltimestamp){
        this.badge = badge;
        this.terminalid = terminalid;
        this.Punchtypeid = Punchtypeid;
        this.id = id;
        this.originaltimestamp = originaltimestamp;
        
        
        
    }
        public String printOriginalTimestamp(){
            
            GregorianCalendar greCal = new GregorianCalendar();
            greCal.setTimeInMillis(originaltimestamp);
            
            SimpleDateFormat sdf = new SimpleDateFormat("EEE MM/dd/yyyy HH:mm:ss");
            
            StringBuilder s = new StringBuilder();
            
            s.append("#");
            s.append(badge.getId());
            s.append(" ");
            //punchtypes here
            switch(Punchtypeid){
                case CLOCKED_IN: s.append("CLOCKED IN:");
                    break;
                case CLOCKED_OUT: s.append("CLOCKED OUT:");
                    break;
                default: s.append("TIMED OUT:");
            }
            s.append(" ");
            
            s.append (sdf.format(greCal.getTime()).toUpperCase());
            
            return(s.toString());
            
        }
        
    
      public String printAdjustedTimeStamp(){
            
            GregorianCalendar greCal = new GregorianCalendar();
            greCal.setTimeInMillis(originaltimestamp);
            
            SimpleDateFormat sdf = new SimpleDateFormat("EEE MM/dd/yyyy HH:mm:ss");
            
            StringBuilder s = new StringBuilder();
            
            s.append("#");
            s.append(badge.getId());
            s.append(" ");
            //punchtypes here
            switch(Punchtypeid){
                case CLOCKED_IN: s.append("CLOCKED IN:");
                    break;
                case CLOCKED_OUT: s.append("CLOCKED OUT:");
                    break;
                default: s.append("TIMED OUT:");
            }
            s.append(" ");
            
            s.append (sdf.format(greCal.getTime()).toUpperCase());
            
            return(s.toString());
            
        }
      
      public void adjust (Shift s){
          
          GregorianCalendar shiftStart = new GregorianCalendar();
          shiftStart.setTimeInMillis(originaltimestamp);
          shiftStart.set(Calendar.HOUR, s.getShiftStartHour());
          shiftStart.set(Calendar.MINUTE, s.getShiftStartMinute());
          shiftStart.set(Calendar.SECOND, 0);
          long shiftStartLong = shiftStart.getTimeInMillis();
          
          
          GregorianCalendar shiftStop = new GregorianCalendar();
          shiftStop.setTimeInMillis(originaltimestamp);
          shiftStop.set(Calendar.HOUR, s.getShiftStopHour());
          shiftStop.set(Calendar.MINUTE, s.getShiftStopMinute());
          shiftStop.set(Calendar.SECOND, 0);
          long shiftStopLong = shiftStop.getTimeInMillis();
          
          GregorianCalendar lunchStart = new GregorianCalendar();
          lunchStart.setTimeInMillis(originaltimestamp);
          lunchStart.set(Calendar.HOUR, s.getLunchStartHour());
          lunchStart.set(Calendar.MINUTE, s.getLunchStartMinute());
          long luchStartLong = lunchStart.getTimeInMillis();
          
          GregorianCalendar lunchStop = new GregorianCalendar();
          lunchStop.setTimeInMillis(originaltimestamp);
          lunchStop.set(Calendar.HOUR, s.getLunchStopHour());
          lunchStop.set(Calendar.MINUTE, s.getLunchStopMinute());
          long luchStopLong = lunchStop.getTimeInMillis();
          
          
          GregorianCalendar interval = new GregorianCalendar();
          interval.setTimeInMillis(originaltimestamp);
          interval.set(Calendar.MINUTE, s.getInterval());
          long intervalLong = interval.getTimeInMillis();
          
          GregorianCalendar gracePeriod = new GregorianCalendar();
          gracePeriod.setTimeInMillis(originaltimestamp);
          gracePeriod.set(Calendar.MINUTE, s.getGracePeriod());
          long gracePeriodLong = gracePeriod.getTimeInMillis();
          
          GregorianCalendar dock = new GregorianCalendar();
          dock.setTimeInMillis(originaltimestamp);
          dock.set(Calendar.MINUTE, s.getDock());
          long dockLong = dock.getTimeInMillis();
          
          GregorianCalendar ots = new GregorianCalendar();
          ots.setTimeInMillis(originaltimestamp);
          int otsDay = ots.get(Calendar.DAY_OF_WEEK);
          int otsMin = ots.get(Calendar.MINUTE);
          int otsHour = ots.get(Calendar.HOUR);
          if (otsDay != Calendar.SATURDAY || otsDay != Calendar.SUNDAY){
             if (otsHour == shiftStart.get(Calendar.HOUR)&&otsMin <= interval.get(Calendar.MINUTE)|| otsMin != shiftStart.get(Calendar.MINUTE)){
                 System.out.print(adjustedtimestamp + "interval round" );
             }
             else if (otsHour == shiftStart.get(Calendar.HOUR)&&otsMin >= dock.get(Calendar.MINUTE)||otsMin != shiftStart.get(Calendar.MINUTE)){
                 System.out.println(adjustedtimestamp + "dock");
             }
             else if (otsHour == shiftStop.get(Calendar.HOUR)&&otsHour == lunchStart.get(Calendar.HOUR)){
                 System.out.println(adjustedtimestamp + "Lunch Start");
                 }
             else if (otsHour == lunchStop.get(Calendar.HOUR)&&otsHour == shiftStart.get(Calendar.HOUR)){
                System.out.println(adjustedtimestamp + "Lunch Stop");
             }
             else if (otsHour == shiftStart.get(Calendar.HOUR)&& otsMin == shiftStart.get(Calendar.MINUTE)&&otsMin <= gracePeriod.get(Calendar.MINUTE)||otsHour == shiftStop.get(Calendar.HOUR)&&otsMin == shiftStop.get(Calendar.MINUTE)&&otsMin >= gracePeriod.get(Calendar.MINUTE)){
                 System.out.println(adjustedtimestamp + "grace period");
          }
             else {
                 System.out.println("None");
             }
          }
      }
      public String getBadgeid(){
          String Badgeid = badge.getId();
          return Badgeid;
      }
      
      
    public int getTerminalid() {
        return terminalid;
    }

    public void setTerminalid(int terminalid) {
        this.terminalid = terminalid;
    }

    public int getPunchtypeid() {
        return Punchtypeid;
    }

    public void setPunchtypeid(int Punchtypeid) {
        this.Punchtypeid = Punchtypeid;
    }

    public int getID() {
        return id;
    }

    public void setID(int ID) {
        this.id = ID;
    }

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }

    public long getOriginaltimestamp() {
        return originaltimestamp;
    }

    public void setOriginaltimestamp(long originaltimestamp) {
        this.originaltimestamp = originaltimestamp;
    }

    public long getAdjusttimestamp() {
        return adjustedtimestamp;
    }

    public void setAdjusttimestamp(long adjusttimestamp) {
        this.adjustedtimestamp = adjusttimestamp;
    }

    
   

    
    

    
        
    
    
  
  
}