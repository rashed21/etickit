/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.launch.controlloer;

import java.util.Arrays;
import java.util.List;
import ticket.com.launch.implDao.LaunchAvailableSeatImplDao;
import ticket.com.launch.pojo.LaunchAvailableSeat;

/**
 *
 * @author Emrul
 */
public class LaunchAvailableSeatController {

    public LaunchAvailableSeat launchAvailableSeat = new LaunchAvailableSeat();
    public LaunchAvailableSeatImplDao availableSeatImplDao = new LaunchAvailableSeatImplDao();
    public String msgForCountOnInput, msgFormInputMethod;

    public String getMsgForCountOnInput() {
        return msgForCountOnInput;
    }

    public void setMsgForCountOnInput(String msgForCountOnInput) {
        this.msgForCountOnInput = msgForCountOnInput;
    }

    public String getMsgFormInputMethod() {
        return msgFormInputMethod;
    }

    public void setMsgFormInputMethod(String msgFormInputMethod) {
        this.msgFormInputMethod = msgFormInputMethod;
    }

    public LaunchAvailableSeat getLaunchAvailableSeat() {
        return launchAvailableSeat;
    }

    public void setLaunchAvailableSeat(LaunchAvailableSeat launchAvailableSeat) {
        this.launchAvailableSeat = launchAvailableSeat;
    }

    public LaunchAvailableSeatImplDao getAvailableSeatImplDao() {
        return availableSeatImplDao;
    }

    public void setAvailableSeatImplDao(LaunchAvailableSeatImplDao availableSeatImplDao) {
        this.availableSeatImplDao = availableSeatImplDao;
    }

    public String insert() {

        if (msgForCountOnInput != null) {
            msgFormInputMethod = "Insert Faield please Match allocated seat with Total Seat";
        } else {
            availableSeatImplDao.insert(launchAvailableSeat);
            msgFormInputMethod = "Insert SuccessFull";
        }

        return msgFormInputMethod;
    }

    public void totalSeat() {

        System.out.println("Total Seat No : " + launchAvailableSeat.availableSeat);
    }

    public String countOnInpute() {

        if (launchAvailableSeat.seatName != null) {
            List<String> elephantList = Arrays.asList(launchAvailableSeat.seatName.split(","));
            System.out.println("Total Seat from input String :" + elephantList.size());
            if (elephantList.size() == launchAvailableSeat.availableSeat) {
                msgForCountOnInput = null;
            } else {
                msgForCountOnInput = "Your Seat Input Does Not Match With Allocated Seat";
            }

        }

        System.out.println("Total Seat Name : " + launchAvailableSeat.seatName);
        return msgForCountOnInput;

    }

}
