/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.launch.controlloer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ticket.com.launch.implDao.LaunchAvailableSeatImplDao;
import ticket.com.launch.implDao.LaunchAvailableSeatOnSearchImplDao;
import ticket.com.launch.implDao.LaunchSalseSeatImplDao;
import ticket.com.launch.implDao.LaunchTimeSheduleImplDao;
import ticket.com.launch.pojo.LaunchAvailableSeat;
import ticket.com.launch.pojo.LaunchAvailableSeatOnSearch;
import ticket.com.launch.pojo.LaunchSalseSeat;
import ticket.com.launch.pojo.Launch_TimeSchedule;

/**
 *
 * @author Emrul
 */
public class LaunchSalseSeatController {

    public LaunchSalseSeat launchSalseSeat = new LaunchSalseSeat();
    public LaunchSalseSeatImplDao launchSalseSeatImplDao = new LaunchSalseSeatImplDao();
    public Launch_TimeSchedule launch_TimeSchedule = new Launch_TimeSchedule();
    public LaunchTimeSheduleImplDao launchTimeSheduleImplDao = new LaunchTimeSheduleImplDao();
    public LaunchAvailableSeatOnSearchImplDao availableSeatOnSearchImplDao = new LaunchAvailableSeatOnSearchImplDao();
    public LaunchAvailableSeatOnSearch availableSeatOnSearch = new LaunchAvailableSeatOnSearch();
    public LaunchAvailableSeat launchAvailableSeat = new LaunchAvailableSeat();
    public LaunchAvailableSeatImplDao launchAvailableSeatImplDao = new LaunchAvailableSeatImplDao();

    public int numberOFSeatForSeals = 0;
    public String seat = null;
    public String msgIfGetMoreThanReserve;

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getMsgIfGetMoreThanReserve() {
        return msgIfGetMoreThanReserve;
    }

    public void setMsgIfGetMoreThanReserve(String msgIfGetMoreThanReserve) {
        this.msgIfGetMoreThanReserve = msgIfGetMoreThanReserve;
    }

    public int getNumberOFSeatForSeals() {
        return numberOFSeatForSeals;
    }

    public void setNumberOFSeatForSeals(int numberOFSeatForSeals) {
        this.numberOFSeatForSeals = numberOFSeatForSeals;
    }

    public LaunchAvailableSeatOnSearchImplDao getAvailableSeatOnSearchImplDao() {
        return availableSeatOnSearchImplDao;
    }

    public void setAvailableSeatOnSearchImplDao(LaunchAvailableSeatOnSearchImplDao availableSeatOnSearchImplDao) {
        this.availableSeatOnSearchImplDao = availableSeatOnSearchImplDao;
    }

    public LaunchAvailableSeatOnSearch getAvailableSeatOnSearch() {
        return availableSeatOnSearch;
    }

    public void setAvailableSeatOnSearch(LaunchAvailableSeatOnSearch availableSeatOnSearch) {
        this.availableSeatOnSearch = availableSeatOnSearch;
    }

    public LaunchSalseSeat getLaunchSalseSeat() {
        return launchSalseSeat;
    }

    public void setLaunchSalseSeat(LaunchSalseSeat launchSalseSeat) {
        this.launchSalseSeat = launchSalseSeat;
    }

    public LaunchSalseSeatImplDao getLaunchSalseSeatImplDao() {
        return launchSalseSeatImplDao;
    }

    public void setLaunchSalseSeatImplDao(LaunchSalseSeatImplDao launchSalseSeatImplDao) {
        this.launchSalseSeatImplDao = launchSalseSeatImplDao;
    }

    public Launch_TimeSchedule getLaunch_TimeSchedule() {
        return launch_TimeSchedule;
    }

    public void setLaunch_TimeSchedule(Launch_TimeSchedule launch_TimeSchedule) {
        this.launch_TimeSchedule = launch_TimeSchedule;
    }

    public LaunchTimeSheduleImplDao getLaunchTimeSheduleImplDao() {
        return launchTimeSheduleImplDao;
    }

    public void setLaunchTimeSheduleImplDao(LaunchTimeSheduleImplDao launchTimeSheduleImplDao) {
        this.launchTimeSheduleImplDao = launchTimeSheduleImplDao;
    }

    public LaunchAvailableSeat getLaunchAvailableSeat() {
        return launchAvailableSeat;
    }

    public void setLaunchAvailableSeat(LaunchAvailableSeat launchAvailableSeat) {
        this.launchAvailableSeat = launchAvailableSeat;
    }

    public LaunchAvailableSeatImplDao getLaunchAvailableSeatImplDao() {
        return launchAvailableSeatImplDao;
    }

    public void setLaunchAvailableSeatImplDao(LaunchAvailableSeatImplDao launchAvailableSeatImplDao) {
        this.launchAvailableSeatImplDao = launchAvailableSeatImplDao;
    }

   // This methods retrive unque value from launch available seat table on LaunchID, seatCatagory and SeatType
    public String getOnCriteriaSearching() {
        try {
            launchAvailableSeat.launchTimeID = launch_TimeSchedule.getLaunchTimeId();
            launchAvailableSeat = launchAvailableSeatImplDao.getAvailableSeatsOnTypeAndCatagoeryForSeals(launchAvailableSeat);
            launchSalseSeat.lauAvaiSeatId = launchAvailableSeat.getLau_ava_seatID();
            launchSalseSeat.lauSalseSeatNo = numberOFSeatForSeals;
            launchSalseSeat.totalFair = launchAvailableSeat.getPerSeatFair() * numberOFSeatForSeals;

        } catch (Exception e) {
            System.out.println("Criteria Does not match For this Exception is now printing " + e);
        } finally {

        }
        return null;
    }

 //This methods return unsolded seats on a launch.  
    public List<String> unsoldLaunchSeats() {
    
      List<String> soldedSeats = Arrays.asList(launchSalseSeatImplDao.getTotalSoldedSeatsOnLaunchiOnCritera(launchAvailableSeat.lau_ava_seatID).split(","));
        System.out.println("Solded seats size : "+soldedSeats.size() +" "+" velu from 0 positions "+soldedSeats.get(0));
        List<String> availableSeatList = Arrays.asList(launchAvailableSeat.seatName.split(","));

        List<String> unsold = new ArrayList<>();
        if (soldedSeats != null) {
            for (int i = 0; i < availableSeatList.size(); i++) {

                if (!soldedSeats.contains(availableSeatList.get(i))) {

                    unsold.add(availableSeatList.get(i));
                }
            }
        } else {
            unsold = availableSeatList;
        }

        return unsold;

    }

    public String returSeatName() {

        String seatNames[] = null;

        String storeSeatsForSeals = "";

        try {

            for (int i = 0; i < numberOFSeatForSeals; i++) {
                if (storeSeatsForSeals == "") {
                    storeSeatsForSeals += unsoldLaunchSeats().get(i);
                } else {
                    storeSeatsForSeals += "," + unsoldLaunchSeats().get(i);
                }
            }
        } catch (Exception e) {
            System.out.println(" Launch Available Seats Methods : " + e);
        } finally {

            System.out.println(" Solded Seats" + storeSeatsForSeals);

        }
        return storeSeatsForSeals;
    }

   //This methods only provide picked seat for buying from available seats 
//public String returSeatName(){  
//
//  String seatNames[]=null;  
//  
//  String storeSeatsForSeals=null;
//
// List<String> soldedSeats = Arrays.asList(launchSalseSeatImplDao.getTotalSoldedSeatsOnLaunchiOnCritera(launchAvailableSeat.lau_ava_seatID).split(","));
//  
//List<String> availableSeatList = Arrays.asList(launchAvailableSeat.seatName.split(","));
//  
//  
//  
//    try {  
//  
//        for(int i=0; i<numberOFSeatForSeals;i++){
//         if(storeSeatsForSeals==null){
//                storeSeatsForSeals+=availableSeatList.get(i); 
//         }else{
//              storeSeatsForSeals+=","+availableSeatList.get(i);
//         }
//        }
//    } catch (Exception e) {
//        System.out.println(" Launch Available Seats Methods : "+e);
//    }finally{    
//        
//        System.out.println(" Solded Seats"+storeSeatsForSeals); 
//        
//    }
//    return storeSeatsForSeals;
//}
//    
//
    public List<Launch_TimeSchedule> search() {

        return launchTimeSheduleImplDao.getAllLaunchTimeSheduleOnSearchList(launch_TimeSchedule);
    }

    public List<LaunchAvailableSeatOnSearch> viewAllSeatsOnSearch() {

        return availableSeatOnSearchImplDao.getAllLaunchTimeSheduleOnSearchList(launch_TimeSchedule);
    }

    
    
    
    
    
    public String insertSalseSeat() {

        getOnCriteriaSearching();
       
        launchSalseSeat.lauSalseSeatName = returSeatName();

        
        //Testing Code
//        LaunchSalseSeat salseSeat = new LaunchSalseSeat();
//        System.out.println("Total Solded Seats " + launchSalseSeatImplDao.
//                getTotalSoldedSeatsOnLaunchiOnCritera(launchAvailableSeat.lau_ava_seatID));

        
        launchSalseSeatImplDao.insert(launchSalseSeat);
        return msgIfGetMoreThanReserve;
    }

}
