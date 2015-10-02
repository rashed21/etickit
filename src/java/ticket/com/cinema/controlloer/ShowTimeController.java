/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.cinema.controlloer;

import ticket.com.cinema.implDao.ShowTimeImplDao;
import ticket.com.cinema.pojo.ShowTime;

/**
 *
 * @author Emrul
 */
public class ShowTimeController {
    private ShowTimeImplDao showTimeImplDao=new ShowTimeImplDao();
    private  ShowTime showTime=new ShowTime();

    public ShowTimeImplDao getShowTimeImplDao() {
        return showTimeImplDao;
    }

    public void setShowTimeImplDao(ShowTimeImplDao showTimeImplDao) {
        this.showTimeImplDao = showTimeImplDao;
    }

    public ShowTime getShowTime() {
        return showTime;
    }

    public void setShowTime(ShowTime showTime) {
        this.showTime = showTime;
    }
    
    public void insert(){
        showTimeImplDao.insert(showTime);
    }
    
    
    
}
