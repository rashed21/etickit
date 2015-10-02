/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.cinema.controlloer;

import java.sql.SQLException;
import ticket.com.cinema.implDao.SeatsOnHallImplDao;
import ticket.com.cinema.pojo.SeatsOnHall;

/**
 *
 * @author Emrul
 */

public class SeatsOnHallController{
    private SeatsOnHall seatsOnHall=new SeatsOnHall();
    private SeatsOnHallImplDao seatsOnHallImplDao=new SeatsOnHallImplDao();

    public SeatsOnHall getSeatsOnHall() {
        return seatsOnHall;
    }

    public void setSeatsOnHall(SeatsOnHall seatsOnHall) {
        this.seatsOnHall = seatsOnHall;
    }

    public SeatsOnHallImplDao getSeatsOnHallImplDao() {
        return seatsOnHallImplDao;
    }

    public void setSeatsOnHallImplDao(SeatsOnHallImplDao seatsOnHallImplDao) {
        this.seatsOnHallImplDao = seatsOnHallImplDao;
    }
    
    public String  insert(){
        
        if(seatsOnHallImplDao.checkAfterInsert(seatsOnHall)>0){
            seatsOnHall.setMassage("Already you have Add Seats This Catagory");
        }else{
            seatsOnHall.setMassage(null);
        seatsOnHallImplDao.insert(seatsOnHall);
    }
     // System.out.println(" ckeck  .."+seatsOnHallImplDao.checkAfterInsert(seatsOnHall));
        return  seatsOnHall.getMassage();
    }
    
    
}
