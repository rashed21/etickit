/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.launch.controlloer;

import java.util.List;
import javax.faces.model.SelectItem;
import ticket.com.launch.implDao.LaunchTimeSheduleImplDao;
import ticket.com.launch.pojo.Launch_TimeSchedule;

/**
 *
 * @author Emrul
 */
public class LaunchTimeScheduleController {

    private LaunchTimeSheduleImplDao launchTimeSheduleImplDao = new LaunchTimeSheduleImplDao();
    private Launch_TimeSchedule launch_TimeSchedule = new Launch_TimeSchedule();

    public LaunchTimeSheduleImplDao getLaunchTimeSheduleImplDao() {
        return launchTimeSheduleImplDao;
    }

    public void setLaunchTimeSheduleImplDao(LaunchTimeSheduleImplDao launchTimeSheduleImplDao) {
        this.launchTimeSheduleImplDao = launchTimeSheduleImplDao;
    }

    public Launch_TimeSchedule getLaunch_TimeSchedule() {
        return launch_TimeSchedule;
    }

    public void setLaunch_TimeSchedule(Launch_TimeSchedule launch_TimeSchedule) {
        this.launch_TimeSchedule = launch_TimeSchedule;
    }
   
public  String insert(){
    
    launchTimeSheduleImplDao.insert(launch_TimeSchedule);
    return null;
}

public List<SelectItem> getAllLaunchTimeOnShedule(){
    
    
    return launchTimeSheduleImplDao.getLaunchTimeSdeduleList();
}


public List<Launch_TimeSchedule> getAllLaunchTimeForDispalyList(){
  
    return launchTimeSheduleImplDao.getAllLaunchTimeSheduleForDisplayList();
}

}
