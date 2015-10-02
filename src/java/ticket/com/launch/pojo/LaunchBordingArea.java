/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.launch.pojo;

import ticket.com.pojo.*;
import java.util.Date;

/**
 *
 * @author Emrul
 */
public class LaunchBordingArea {

    public int bo_area_id;
    public int launchTimeID;
    public Date bo_area_time;

    public LaunchBordingArea() {
    }

    public int getBo_area_id() {
        return bo_area_id;
    }

    public void setBo_area_id(int bo_area_id) {
        this.bo_area_id = bo_area_id;
    }

    public int getLaunchTimeID() {
        return launchTimeID;
    }

    public void setLaunchTimeID(int launchTimeID) {
        this.launchTimeID = launchTimeID;
    }

   

    public Date getBo_area_time() {
        return bo_area_time;
    }

    public void setBo_area_time(Date bo_area_time) {
        this.bo_area_time = bo_area_time;
    }


}
