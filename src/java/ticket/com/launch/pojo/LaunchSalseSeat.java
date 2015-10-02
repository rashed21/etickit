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
public class LaunchSalseSeat {
    public int lauSalseSeatId;
    public int lauAvaiSeatId;
    public String lauSalseSeatName;
    public int lauSalseSeatNo;
    public Date salseDate;
    public String customerName;
    public Double totalFair;

    
    public int getLauSalseSeatId() {
        return lauSalseSeatId;
    }

    public void setLauSalseSeatId(int lauSalseSeatId) {
        this.lauSalseSeatId = lauSalseSeatId;
    }

    public int getLauAvaiSeatId() {
        return lauAvaiSeatId;
    }

    public void setLauAvaiSeatId(int lauAvaiSeatId) {
        this.lauAvaiSeatId = lauAvaiSeatId;
    }

    public String getLauSalseSeatName() {
        return lauSalseSeatName;
    }

    public void setLauSalseSeatName(String lauSalseSeatName) {
        this.lauSalseSeatName = lauSalseSeatName;
    }

    public int getLauSalseSeatNo() {
        return lauSalseSeatNo;
    }

    public void setLauSalseSeatNo(int lauSalseSeatNo) {
        this.lauSalseSeatNo = lauSalseSeatNo;
    }

    public Date getSalseDate() {
        return salseDate;
    }

    public void setSalseDate(Date salseDate) {
        this.salseDate = salseDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getTotalFair() {
        return totalFair;
    }

    public void setTotalFair(Double totalFair) {
        this.totalFair = totalFair;
    }
    
    
}
