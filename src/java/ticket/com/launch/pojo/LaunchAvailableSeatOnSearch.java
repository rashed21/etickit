/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.launch.pojo;

import java.util.Date;

/**
 *
 * @author Emrul
 */
public class LaunchAvailableSeatOnSearch {

    public String launchName;
    public String departFrom;
    public Date deptTime;
    public Date arrivTime;
    public String arriveTo;
    public int availableSeat;
    public String seatName;
    public int lau_ava_seatID;
    public int launchTimeID;
    public String typeName;
    public String seatCataName;
    public Double fair;
    
    

    public String getLaunchName() {
        return launchName;
    }

    public void setLaunchName(String launchName) {
        this.launchName = launchName;
    }

    public String getDepartFrom() {
        return departFrom;
    }

    public void setDepartFrom(String departFrom) {
        this.departFrom = departFrom;
    }

    public Date getDeptTime() {
        return deptTime;
    }

    public void setDeptTime(Date deptTime) {
        this.deptTime = deptTime;
    }

    public Date getArrivTime() {
        return arrivTime;
    }

    public void setArrivTime(Date arrivTime) {
        this.arrivTime = arrivTime;
    }

    public String getArriveTo() {
        return arriveTo;
    }

    public void setArriveTo(String arriveTo) {
        this.arriveTo = arriveTo;
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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getSeatCataName() {
        return seatCataName;
    }

    public void setSeatCataName(String seatCataName) {
        this.seatCataName = seatCataName;
    }

    public Double getFair() {
        return fair;
    }

    public void setFair(Double fair) {
        this.fair = fair;
    }
    
    
    
}
