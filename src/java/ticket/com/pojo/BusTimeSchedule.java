/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.pojo;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Emrul
 */
public class BusTimeSchedule  implements java.io.Serializable {


     private Integer busTimeId;
     private Integer busInfo;
     private Integer busType;
     private String departFrom;
     private int totSeatNo;
     private String availableSeat;
     private Date deptTime;
     private Date arrivTime;
     private String arriveTo;
     private String bus_type_name;
     private int value; 

    public String getBus_type_name() {
        return bus_type_name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    public void setBus_type_name(String bus_type_name) {
        this.bus_type_name = bus_type_name;
    }
     

    public BusTimeSchedule() {
    }

    public Integer getBusTimeId() {
        return busTimeId;
    }

    public void setBusTimeId(Integer busTimeId) {
        this.busTimeId = busTimeId;
    }

    public Integer getBusInfo() {
        return busInfo;
    }

    public void setBusInfo(Integer busInfo) {
        this.busInfo = busInfo;
    }

    public Integer getBusType() {
        return busType;
    }

    public void setBusType(Integer busType) {
        this.busType = busType;
    }

    public String getDepartFrom() {
        return departFrom;
    }

    public void setDepartFrom(String departFrom) {
        this.departFrom = departFrom;
    }

    public int getTotSeatNo() {
        return totSeatNo;
    }

    public void setTotSeatNo(int totSeatNo) {
        this.totSeatNo = totSeatNo;
    }

    public String getAvailableSeat() {
        return availableSeat;
    }

    public void setAvailableSeat(String availableSeat) {
        this.availableSeat = availableSeat;
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

    
     
}
