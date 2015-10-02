/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.cinema.controlloer;

import java.util.List;
import javax.faces.model.SelectItem;
import ticket.com.cinema.implDao.HallSeatCatagoryImplDao;
import ticket.com.cinema.pojo.HallSeatCatagory;

/**
 *
 * @author Emrul
 */
public class HallSeatCatagoryController {
   
    public  HallSeatCatagory hallSeatCatagory=new HallSeatCatagory();
    public HallSeatCatagoryImplDao hallSeatCatagoryImplDao=new HallSeatCatagoryImplDao();
    public static int hallIdStoreForShowOnhall;

   
    
    
    
    
    public HallSeatCatagory getHallSeatCatagory() {
        return hallSeatCatagory;
    }

    public void setHallSeatCatagory(HallSeatCatagory hallSeatCatagory) {
        this.hallSeatCatagory = hallSeatCatagory;
    }

    public HallSeatCatagoryImplDao getHallSeatCatagoryImplDao() {
        return hallSeatCatagoryImplDao;
    }

    public void setHallSeatCatagoryImplDao(HallSeatCatagoryImplDao hallSeatCatagoryImplDao) {
        this.hallSeatCatagoryImplDao = hallSeatCatagoryImplDao;
    }

    public void insert(){
        hallSeatCatagoryImplDao.insert(hallSeatCatagory);
    }
    
    
    public List<SelectItem> getHallSeatCatagorForListItems() {
        hallIdStoreForShowOnhall=hallSeatCatagory.getHallId();
      
       return hallSeatCatagoryImplDao.getHallSeatCatagorForListItems(1);
    }
    
    
}
