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
public class Cinema {
    private int cinemaId;
    private int showCataId;
    private String cinemaName;
    private String duration;
    private String releaseDate;
    private String producer;
    private String  details;
    private String showCata;

    
    
    
    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }


    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getShowCata() {
        return showCata;
    }

    public void setShowCata(String showCata) {
        this.showCata = showCata;
    }

    public int getShowCataId() {
        return showCataId;
    }

    public void setShowCataId(int showCataId) {
        this.showCataId = showCataId;
    }
    
  
}