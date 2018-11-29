package teamproject;

import java.time.LocalTime;
import java.util.ArrayList;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author qwink
 */
public class TASLogic {
    
    public static int calculateTotalMinutes(ArrayList<Punch> dailypunchlist, Shift shift){
        int totalMins = 0;
        int dailyMins = 0;
        
        for(int i = 0; i < dailypunchlist.size(); i++){
            Punch p1 = dailypunchlist.get(i);
            Punch p2 = dailypunchlist.get(++i);
            //find if clock in and out pair
            if (p1.getPunchtypeid() == 1 && p2.getPunchtypeid() == 0){
                GregorianCalendar greCalp1 = new GregorianCalendar();
                GregorianCalendar greCalp2 = new GregorianCalendar();
                greCalp1.setTimeInMillis(p1.getAdjusttimestamp());
                greCalp2.setTimeInMillis(p2.getAdjusttimestamp());
                LocalTime p1Time = LocalTime.of(greCalp1.get(Calendar.HOUR_OF_DAY),greCalp1.get(Calendar.MINUTE));
                LocalTime p2Time = LocalTime.of(greCalp2.get(Calendar.HOUR_OF_DAY),greCalp2.get(Calendar.MINUTE));
                
                //find minutes between
                dailyMins = (int) ChronoUnit.MINUTES.between(p1Time, p2Time);
                
                //minimum mins to deduct lunch
                if (dailyMins >= shift.getLunchDeduct()){
                    
                    dailyMins -= ChronoUnit.MINUTES.between(shift.getLunchStart(), shift.getLunchStop());
                    
                }
                
                
            }
            totalMins += dailyMins;
            dailyMins = 0;
            
        }
        
        
        return totalMins;
        
    }

    
}
