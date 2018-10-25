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
    private int ShiftStartHour, ShiftStartMinute, ShiftStartSecond;
    private int ShiftStopHour, ShiftStopMinute, ShiftStopSecond;
    private int interval, gracePeriod, dock, lunchDeduct;
    private String description;

    public Shift(LocalTime shiftStart, LocalTime shiftStop, LocalTime lunchStart, LocalTime lunchStop, int ShiftStartHour, int ShiftStartMinute, int ShiftStartSecond, int ShiftStopHour, int ShiftStopMinute, int ShiftStopSecond, int interval, int gracePeriod, int dock, int lunchDeduct, String description) {
        this.shiftStart = shiftStart;
        this.shiftStop = shiftStop;
        this.lunchStart = lunchStart;
        this.lunchStop = lunchStop;
        this.ShiftStartHour = ShiftStartHour;
        this.ShiftStartMinute = ShiftStartMinute;
        this.ShiftStartSecond = ShiftStartSecond;
        this.ShiftStopHour = ShiftStopHour;
        this.ShiftStopMinute = ShiftStopMinute;
        this.ShiftStopSecond = ShiftStopSecond;
        this.interval = interval;
        this.gracePeriod = gracePeriod;
        this.dock = dock;
        this.lunchDeduct = lunchDeduct;
        this.description = description;
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

    public int getShiftStartHour() {
        return ShiftStartHour;
    }

    public void setShiftStartHour(int ShiftStartHour) {
        this.ShiftStartHour = ShiftStartHour;
    }

    public int getShiftStartMinute() {
        return ShiftStartMinute;
    }

    public void setShiftStartMinute(int ShiftStartMinute) {
        this.ShiftStartMinute = ShiftStartMinute;
    }

    public int getShiftStartSecond() {
        return ShiftStartSecond;
    }

    public void setShiftStartSecond(int ShiftStartSecond) {
        this.ShiftStartSecond = ShiftStartSecond;
    }

    public int getShiftStopHour() {
        return ShiftStopHour;
    }

    public void setShiftStopHour(int ShiftStopHour) {
        this.ShiftStopHour = ShiftStopHour;
    }

    public int getShiftStopMinute() {
        return ShiftStopMinute;
    }

    public void setShiftStopMinute(int ShiftStopMinute) {
        this.ShiftStopMinute = ShiftStopMinute;
    }

    public int getShiftStopSecond() {
        return ShiftStopSecond;
    }

    public void setShiftStopSecond(int ShiftStopSecond) {
        this.ShiftStopSecond = ShiftStopSecond;
    }

    

    
    

    
    
    
}