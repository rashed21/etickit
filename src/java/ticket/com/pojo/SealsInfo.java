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
public class SealsInfo {
    private int sealsID;
    private int timeSheduleId;
    private int user;
    private String departFrom;
    private String departTo;
    private Date sealsDate;
    private Date journyDate;
    private int price;
    private int totalPrice;
    private String selectedSeat;
    private String seats;
    private Date fromDate;

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public String getSelectedSeat() {
        return selectedSeat;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSelectedSeat(String selectedSeat) {
        this.selectedSeat = selectedSeat;
    }

    public SealsInfo() {
    }

    public int getSealsID() {
        return sealsID;
    }

    public void setSealsID(int sealsID) {
        this.sealsID = sealsID;
    }

    public int getTimeSheduleId() {
        return timeSheduleId;
    }

    public void setTimeSheduleId(int timeSheduleId) {
        this.timeSheduleId = timeSheduleId;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String getDepartFrom() {
        return departFrom;
    }

    public void setDepartFrom(String departFrom) {
        this.departFrom = departFrom;
    }

    public String getDepartTo() {
        return departTo;
    }

    public void setDepartTo(String departTo) {
        this.departTo = departTo;
    }

    public Date getSealsDate() {
        return sealsDate;
    }

    public void setSealsDate(Date sealsDate) {
        this.sealsDate = sealsDate;
    }

    public Date getJournyDate() {
        return journyDate;
    }

    public void setJournyDate(Date journyDate) {
        this.journyDate = journyDate;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getSeats() {
        return seats;
    }

    
    
    public void setSeats(String seats) {
        this.seats = seats;
    }

}
