package teamproject;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
/**
 *
 * @author ADAM_
 */
public class Shift {
    private LocalTime shiftStart;
    private LocalTime shiftStop;
    private LocalTime lunchStart;
    private LocalTime lunchStop;
    private int interval;
    private int gracePeriod;
    private int dock;
    private int lunchDeduct;
    String description;
    
    public Shift(int interval, int gracePeriod, int dock, int lunchDeduct, String description, LocalTime shiftStart, LocalTime shiftStop, LocalTime lunchStart, LocalTime lunchStop){
        
        this.interval = interval;
        this.gracePeriod = gracePeriod;
        this.dock = dock;
        this.lunchDeduct = lunchDeduct;
        this.description = description;
        
        this.shiftStart = shiftStart;
        this.shiftStop = shiftStop;
        this.lunchStart = lunchStart;
        this.lunchStop = lunchStop;
        
    }
    
    @Override
    public String toString(){
        return (description + ": " + shiftStart + " - " + shiftStop + "(" + ChronoUnit.MINUTES.between(shiftStart, shiftStop) + " minutes);" + "Lunch: " + lunchStart + " - " + lunchStop + "(" + ChronoUnit.MINUTES.between(lunchStart, lunchStop) + " minutes)");
    }
    
    public LocalTime getShiftStart() {
        return shiftStart;
    }

    public LocalTime getShiftStop() {
        return shiftStop;
    }

    public LocalTime getLunchStart() {
        return lunchStart;
    }

    public LocalTime getLunchStop() {
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

    public void setShiftStart(LocalTime shiftStart) {
        this.shiftStart = shiftStart;
    }

    public void setShiftStop(LocalTime shiftStop) {
        this.shiftStop = shiftStop;
    }

    public void setLunchStart(LocalTime lunchStart) {
        this.lunchStart = lunchStart;
    }

    public void setLunchStop(LocalTime lunchStop) {
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