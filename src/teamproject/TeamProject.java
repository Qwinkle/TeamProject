/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamproject;

/**
 *
 * @author qwink
 */
public class TeamProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TASDatabase db = null;
        
        try{
            db = new TASDatabase();
        }
        catch(Exception e){
            System.err.println(e.toString());
        }
        Badge badge = db.getBadge("021890c0");
        System.out.println(badge.toString());
    }
    
}
