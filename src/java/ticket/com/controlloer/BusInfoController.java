/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.controlloer;


import java.util.List;
import javax.faces.model.SelectItem;
import ticket.com.implDao.BusInfoImpl;
import ticket.com.implDao.CompanyInfoImpl;
import ticket.com.pojo.BusInfo;
import ticket.com.pojo.CompanyInfo;

/**
 *
 * @author Robin Khan
 */
public class BusInfoController {
    
    public BusInfo busInfo=new BusInfo(); 
    public BusInfoImpl busInfoImpl=new BusInfoImpl();

    public BusInfo getBusInfo() {
        return busInfo;
    }

    public void setBusInfo(BusInfo busInfo) {
        this.busInfo = busInfo;
    }

    public BusInfoImpl getBusInfoImpl() {
        return busInfoImpl;
    }

    public void setBusInfoImpl(BusInfoImpl busInfoImpl) {
        this.busInfoImpl = busInfoImpl;
    }

    
    
    public void insert(){
        
        busInfoImpl.insert(busInfo);
        
    }
    
    public List<SelectItem> getAllBusInfoList(){
      return busInfoImpl.getBusInfoID();
    }
}
