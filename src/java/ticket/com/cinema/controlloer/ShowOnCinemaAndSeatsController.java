/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.cinema.controlloer;

import ticket.com.cinema.implDao.ShowOnCinemaAndSeatsImplDao;
import ticket.com.cinema.pojo.ShowOnCinemaAndSeats;

/**
 *
 * @author Emrul
 */
public class ShowOnCinemaAndSeatsController {
    
    
    private ShowOnCinemaAndSeatsImplDao showOnCinemaAndSeatsImplDao=new ShowOnCinemaAndSeatsImplDao();
    
    private ShowOnCinemaAndSeats showOnCinemaAndSeats=new ShowOnCinemaAndSeats();

    public ShowOnCinemaAndSeatsImplDao getShowOnCinemaAndSeatsImplDao() {
        return showOnCinemaAndSeatsImplDao;
    }

    public void setShowOnCinemaAndSeatsImplDao(ShowOnCinemaAndSeatsImplDao showOnCinemaAndSeatsImplDao) {
        this.showOnCinemaAndSeatsImplDao = showOnCinemaAndSeatsImplDao;
    }

    public ShowOnCinemaAndSeats getShowOnCinemaAndSeats() {
        return showOnCinemaAndSeats;
    }

    public void setShowOnCinemaAndSeats(ShowOnCinemaAndSeats showOnCinemaAndSeats) {
        this.showOnCinemaAndSeats = showOnCinemaAndSeats;
    }

    
}
