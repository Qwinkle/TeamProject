/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TeamProject;

/**
 *
 * @author JayBritt
 */
public class Badge {
    private String id;
    private String Desc;

    public Badge(String id, String Desc) {
        this.id = id;
        this.Desc = Desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String Desc) {
        this.Desc = Desc;
    }

    @Override
    public String toString(){
        return (Desc + "#" + id + " (" + Desc + ")");
    }
    
    
    
}
