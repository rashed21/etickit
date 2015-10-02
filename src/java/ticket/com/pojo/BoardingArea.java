/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.pojo;

import java.util.Date;

/**
 *
 * @author Emrul
 */
public class BoardingArea {

    public int bo_area_id;
    public int bus_time_id;
    public Date bo_area_time;

    public BoardingArea() {
    }

    public int getBo_area_id() {
        return bo_area_id;
    }

    public void setBo_area_id(int bo_area_id) {
        this.bo_area_id = bo_area_id;
    }

    public int getBus_time_id() {
        return bus_time_id;
    }

    public void setBus_time_id(int bus_time_id) {
        this.bus_time_id = bus_time_id;
    }

    public Date getBo_area_time() {
        return bo_area_time;
    }

    public void setBo_area_time(Date bo_area_time) {
        this.bo_area_time = bo_area_time;
    }


}
