/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.cinema.controlloer;

import ticket.com.cinema.implDao.CinemaImplDao;
import ticket.com.cinema.pojo.Cinema;

/**
 *
 * @author Emrul
 */
public class CinemaController {
 private Cinema cinema=new Cinema();
 private CinemaImplDao cinemaImplDao=new CinemaImplDao();

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public CinemaImplDao getCinemaImplDao() {
        return cinemaImplDao;
    }

    public void setCinemaImplDao(CinemaImplDao cinemaImplDao) {
        this.cinemaImplDao = cinemaImplDao;
    }
 
 public void insert(){
     try {
         cinemaImplDao.insert(cinema);
     } catch (Exception e) {
     }finally{
        // cinema=null;
     }
     
 }
 
}
