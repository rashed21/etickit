/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.cinema.pojo;

/**
 *
 * @author Emrul
 */
public class SeatsOnHall {
    private String massage;
    private int showIdOnHall;
    private int hallId;
    private String hallName;
    private int showId;
    private String showTimeOhHall;
    private int hallSeatsCataId;
    private String cataName;
    private String seatsName;
    private int totalSeats;
    private double price;

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public int getShowIdOnHall() {
        return showIdOnHall;
    }

    public void setShowIdOnHall(int showIdOnHall) {
        this.showIdOnHall = showIdOnHall;
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

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public String getShowTimeOhHall() {
        return showTimeOhHall;
    }

    public void setShowTimeOhHall(String showTimeOhHall) {
        this.showTimeOhHall = showTimeOhHall;
    }

    public int getHallSeatsCataId() {
        return hallSeatsCataId;
    }

    public void setHallSeatsCataId(int hallSeatsCataId) {
        this.hallSeatsCataId = hallSeatsCataId;
    }

    public String getCataName() {
        return cataName;
    }

    public void setCataName(String cataName) {
        this.cataName = cataName;
    }

    public String getSeatsName() {
        return seatsName;
    }

    public void setSeatsName(String seatsName) {
        this.seatsName = seatsName;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

   
}
