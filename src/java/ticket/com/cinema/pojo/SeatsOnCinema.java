/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.cinema.pojo;

import java.util.Date;

/**
 *
 * @author Emrul
 */
public class SeatsOnCinema {
private int seatsIdOnCinema;
private int hallId;
private String hallName;
private int cinId;
private String cinemaName;
private int showId;
private String showTime;
private int hallSeatCataId;
private String hallSeatCataName;
private Date startDate;
private Date endDate;
private String seatsName;
private int allocatedAmount;
private double  price;
private double discount;
private String blockSeats;

    public int getSeatsIdOnCinema() {
        return seatsIdOnCinema;
    }

    public void setSeatsIdOnCinema(int seatsIdOnCinema) {
        this.seatsIdOnCinema = seatsIdOnCinema;
    }

    public int getHallId() {
        return hallId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public int getCinId() {
        return cinId;
    }

    public void setCinId(int cinId) {
        this.cinId = cinId;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public int getHallSeatCataId() {
        return hallSeatCataId;
    }

    public void setHallSeatCataId(int hallSeatCataId) {
        this.hallSeatCataId = hallSeatCataId;
    }

    public String getHallSeatCataName() {
        return hallSeatCataName;
    }

    public void setHallSeatCataName(String hallSeatCataName) {
        this.hallSeatCataName = hallSeatCataName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getSeatsName() {
        return seatsName;
    }

    public void setSeatsName(String seatsName) {
        this.seatsName = seatsName;
    }

    public int getAllocatedAmount() {
        return allocatedAmount;
    }

    public void setAllocatedAmount(int allocatedAmount) {
        this.allocatedAmount = allocatedAmount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getBlockSeats() {
        return blockSeats;
    }

    public void setBlockSeats(String blockSeats) {
        this.blockSeats = blockSeats;
    }
  
}
