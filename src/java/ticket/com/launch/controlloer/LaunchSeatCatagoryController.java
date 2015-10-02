/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.launch.controlloer;

import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import ticket.com.launch.implDao.LaunchseatCatagoryImplDao;
import ticket.com.launch.pojo.LaunchAvailableSeat;
import ticket.com.launch.pojo.LaunchSeatCatagory;
import ticket.com.launch.pojo.LaunchSeatType;

/**
 *
 * @author Emrul
 */
public class LaunchSeatCatagoryController {

    public LaunchSeatCatagory launchSeatCatagory = new LaunchSeatCatagory();
    public LaunchseatCatagoryImplDao launchseatCatagoryImplDao = new LaunchseatCatagoryImplDao();
    public LaunchSeatType launchSeatType = new LaunchSeatType();
    public LaunchAvailableSeat launchAvailableSeat=new LaunchAvailableSeat();
    
    public int holdSeatCataID;

    
    
    
    
    
    public int getHoldSeatCataID() {
        return holdSeatCataID;
    }

    public void setHoldSeatCataID(int holdSeatCataID) {
        this.holdSeatCataID = holdSeatCataID;
    }

    public LaunchSeatType getLaunchSeatType() {
        return launchSeatType;
    }

    public void setLaunchSeatType(LaunchSeatType launchSeatType) {
        this.launchSeatType = launchSeatType;
    }

    public LaunchSeatCatagory getLaunchSeatCatagory() {
        return launchSeatCatagory;
    }

    public void setLaunchSeatCatagory(LaunchSeatCatagory launchSeatCatagory) {
        this.launchSeatCatagory = launchSeatCatagory;
    }

    public LaunchseatCatagoryImplDao getLaunchseatCatagoryImplDao() {
        return launchseatCatagoryImplDao;
    }

    public void setLaunchseatCatagoryImplDao(LaunchseatCatagoryImplDao launchseatCatagoryImplDao) {
        this.launchseatCatagoryImplDao = launchseatCatagoryImplDao;
    }

    public LaunchAvailableSeat getLaunchAvailableSeat() {
        return launchAvailableSeat;
    }

    public void setLaunchAvailableSeat(LaunchAvailableSeat launchAvailableSeat) {
        this.launchAvailableSeat = launchAvailableSeat;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public String insert() {

        launchseatCatagoryImplDao.insert(launchSeatCatagory);
        return null;
    }

    public List<SelectItem> getAllLaunchSeatCatagory() {
        return launchseatCatagoryImplDao.getLaunchSeatCata();

    }

    public List<SelectItem> getSeatCatagoryOnSelect() {
        return viewChangeOnSelect();

    }

    public List<SelectItem> viewChangeOnSelect() {
        List<SelectItem> list = new ArrayList<SelectItem>();

        try {
            if (launchSeatType.seatTypeID == 1 || launchSeatType.seatTypeID == 2) {
           
                holdSeatCataID=launchSeatType.getSeatTypeID();
                list.clear();

            } else {
                 holdSeatCataID=launchSeatType.getSeatTypeID();
                list = launchseatCatagoryImplDao.getLaunchSeatCata();

            }
        } catch (Exception e) {

            System.out.println(e);
        }

        return list;

    }
}
