/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.launch.controlloer;


import java.util.List;
import javax.faces.model.SelectItem;
import ticket.com.implDao.BusInfoImpl;
import ticket.com.launch.implDao.Launch_InfoImplDao;
import ticket.com.launch.pojo.Launch_Info;
import ticket.com.pojo.BusInfo;

/**
 *
 * @author Robin Khan
 */
public class Launch_InfoController {
    
    public Launch_Info launch_Info=new Launch_Info(); 
    public Launch_InfoImplDao infoImplDao=new Launch_InfoImplDao();

    public Launch_Info getLaunch_Info() {
        return launch_Info;
    }

    public void setLaunch_Info(Launch_Info launch_Info) {
        this.launch_Info = launch_Info;
    }

    public Launch_InfoImplDao getInfoImplDao() {
        return infoImplDao;
    }

    public void setInfoImplDao(Launch_InfoImplDao infoImplDao) {
        this.infoImplDao = infoImplDao;
    }

  

    
    
    public void insert(){
        
        infoImplDao.insert(launch_Info);
        
    }
    
    public List<SelectItem> getAllLaunchInfoList(){
      return infoImplDao.getLaunchInfoID();
    }
    
    
    
}
