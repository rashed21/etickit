/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.launch.pojo;

/**
 *
 * @author Emrul
 */
public class LaunchAvailableSeat {
 public int  lau_ava_seatID;
 public int launchTimeID;
 public int seatCataID;
 public int seatTypeID;
 public int availableSeat;
 public String  seatName;
 public Double perSeatFair;

    public int getLau_ava_seatID() {
        return lau_ava_seatID;
    }

    public void setLau_ava_seatID(int lau_ava_seatID) {
        this.lau_ava_seatID = lau_ava_seatID;
    }

    public int getLaunchTimeID() {
        return launchTimeID;
    }

    public void setLaunchTimeID(int launchTimeID) {
        this.launchTimeID = launchTimeID;
    }

    public int getSeatCataID() {
        return seatCataID;
    }

    public void setSeatCataID(int seatCataID) {
        this.seatCataID = seatCataID;
    }

    public int getSeatTypeID() {
        return seatTypeID;
    }

    public void setSeatTypeID(int seatTypeID) {
        this.seatTypeID = seatTypeID;
    }

    public int getAvailableSeat() {
        return availableSeat;
    }

    public void setAvailableSeat(int availableSeat) {
        this.availableSeat = availableSeat;
    }

    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }

    public Double getPerSeatFair() {
        return perSeatFair;
    }

    public void setPerSeatFair(Double perSeatFair) {
        this.perSeatFair = perSeatFair;
    }

    
    
    
}
