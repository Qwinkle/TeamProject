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
    private int interval, gracePeriod, dock, lunchDeduct;
    private String description;

    public Shift(int interval, int gracePeriod, int dock, int lunchDeduct, String description, int shiftStartHour, int shiftStartMin, int shiftStopHour, int shiftStopMin, int lunchStartHour, int lunchStartMin, int lunchStopHour, int lunchStopMin){
        this.shiftStart = LocalTime.of(shiftStartHour, shiftStartMin);
        this.shiftStop = LocalTime.of(shiftStopHour, shiftStopMin);
        this.lunchStart = LocalTime.of(lunchStartHour, lunchStartMin);
        this.lunchStop = LocalTime.of(lunchStopHour, lunchStopMin);
        this.interval = interval;
        this.gracePeriod = gracePeriod;
        this.dock = dock;
        this.lunchDeduct = lunchDeduct;
        this.description = description;
    }

    

    
    
    
    @Override
    public String toString(){
        return (description + ": " + shiftStart + " - " + shiftStop + " (" + ChronoUnit.MINUTES.between(shiftStart, shiftStop) + " minutes);" + " Lunch: " + lunchStart + " - " + lunchStop + " (" + ChronoUnit.MINUTES.between(lunchStart, lunchStop) + " minutes)");
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

    public int getShiftStartHour(){
        
        return shiftStart.getHour();
        
    }

    public int getShiftStartMinute(){
        return shiftStart.getMinute();
    }
    
    public int getShiftStopHour(){
        return shiftStop.getHour();
    }
    
    public int getShiftStopMinute(){
        return shiftStop.getMinute();
    }
    
    public int getLunchStartHour(){
        
        return lunchStart.getHour();
        
    }

    public int getLunchStartMinute(){
        return lunchStart.getMinute();
    }

    public int getLunchStopHour(){
        
        return lunchStop.getHour();
        
    }

    public int getLunchStopMinute(){
        return lunchStop.getMinute();
    }
    

    
    
    
}