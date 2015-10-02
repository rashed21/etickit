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
public class ShowTime {
    private int showId;
    private int hallId;
    private String hallName;
    private String showTimeinHour;
    private String title;

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public int getHallId() {
        return hallId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    public String getShowTimeinHour() {
        return showTimeinHour;
    }

    public void setShowTimeinHour(String showTimeinHour) {
        this.showTimeinHour = showTimeinHour;
    }

   

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }
    
    
}
