/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamproject;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.text.DecimalFormat;
import java.util.Calendar;

/**
 *
 * @author ADAM_
 */
public class Absenteeism {
    
    DecimalFormat f = new DecimalFormat("##.00");
    String badgeid;
    long ts;
    double percentage;
    GregorianCalendar greCal;
    
    public Absenteeism(String badgeid, long ts, double percentage){
        
        this.badgeid = badgeid;
        this.ts = ts;
        this.percentage = percentage;
        
        //set time to sunday of the week at midnight
        greCal = new GregorianCalendar();
        greCal.setTimeInMillis(ts);
        greCal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        greCal.set(Calendar.HOUR_OF_DAY, 0);
        greCal.set(Calendar.MINUTE, 0);
        greCal.set(Calendar.SECOND, 0);
        
    }

    public String getBadgeid() {
        return badgeid;
    }

    public void setBadgeid(String badgeid) {
        this.badgeid = badgeid;
    }

    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
    
    @Override
    public String toString(){
        
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        
        return "#" + badgeid + " (Pay Period Starting " + sdf.format(greCal.getTime()) + "): " + f.format(percentage) + "%";
    }
    
    
}
