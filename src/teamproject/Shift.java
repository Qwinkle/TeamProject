package teamproject;

import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 *
 * @author ADAM_
 */
public class Shift {
    private GregorianCalendar shiftStart;
    private GregorianCalendar shiftStop;
    private GregorianCalendar lunchStart;
    private GregorianCalendar lunchStop;
    private int interval;
    private int gracePeriod;
    private int dock;
    private int lunchDeduct;
    String description;
    
    public Shift(int interval, int gracePeriod, int dock, int lunchDeduct, String description){
        
        this.interval = interval;
        this.gracePeriod = gracePeriod;
        this.dock = dock;
        this.lunchDeduct = lunchDeduct;
        this.description = description;
        
        shiftStart = new GregorianCalendar();
        shiftStop = new GregorianCalendar();
        lunchStart = new GregorianCalendar();
        lunchStop = new GregorianCalendar();
        
    }
    
    @Override
    public String toString(){
        return (description + ": ");
    }
    
    public GregorianCalendar getShiftStart() {
        return shiftStart;
    }

    public GregorianCalendar getShiftStop() {
        return shiftStop;
    }

    public GregorianCalendar getLunchStart() {
        return lunchStart;
    }

    public GregorianCalendar getLunchStop() {
        return lunchStop;
    }

    public int getInterval() {
        return interval;
    }

    public int getGracePeriod() {
        return gracePeriod;
    }

    public int getDock() {
        return dock;
    }

    public int getLunchDeduct() {
        return lunchDeduct;
    }

    public String getDescription() {
        return description;
    }

    public void setShiftStart(GregorianCalendar shiftStart) {
        this.shiftStart = shiftStart;
    }

    public void setShiftStop(GregorianCalendar shiftStop) {
        this.shiftStop = shiftStop;
    }

    public void setLunchStart(GregorianCalendar lunchStart) {
        this.lunchStart = lunchStart;
    }

    public void setLunchStop(GregorianCalendar lunchStop) {
        this.lunchStop = lunchStop;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public void setGracePeriod(int gracePeriod) {
        this.gracePeriod = gracePeriod;
    }

    public void setDock(int dock) {
        this.dock = dock;
    }

    public void setLunchDeduct(int lunchDeduct) {
        this.lunchDeduct = lunchDeduct;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}