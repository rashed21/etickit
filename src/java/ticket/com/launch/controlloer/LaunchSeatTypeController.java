/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.launch.controlloer;

import java.util.List;
import javax.faces.model.SelectItem;
import ticket.com.launch.implDao.LaunchSeatTypeImplDao;
import ticket.com.launch.pojo.LaunchSeatType;

/**
 *
 * @author Emrul
 */
public class LaunchSeatTypeController {

    private LaunchSeatType launchSeatType = new LaunchSeatType();
    private LaunchSeatTypeImplDao launchSeatTypeImplDao = new LaunchSeatTypeImplDao();

    public LaunchSeatType getLaunchSeatType() {
        return launchSeatType;
    }

    public void setLaunchSeatType(LaunchSeatType launchSeatType) {
        this.launchSeatType = launchSeatType;
    }

    public LaunchSeatTypeImplDao getLaunchSeatTypeImplDao() {
        return launchSeatTypeImplDao;
    }

    public void setLaunchSeatTypeImplDao(LaunchSeatTypeImplDao launchSeatTypeImplDao) {
        this.launchSeatTypeImplDao = launchSeatTypeImplDao;
    }

    public String insert() {
        launchSeatTypeImplDao.insert(launchSeatType);
        return null;
    }

    public List<SelectItem> getAllLaunchSeatType() {
        return launchSeatTypeImplDao.getLaunchSeatType();

    }

}
