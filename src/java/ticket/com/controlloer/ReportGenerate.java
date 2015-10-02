/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.controlloer;

import ticket.com.implDao.BusTimeScheduleDaoImpl;
import ticket.com.implDao.SealsInfoImplDao;
import ticket.com.pojo.BusTimeSchedule;
import ticket.com.pojo.SealsInfo;

/**
 *
 * @author Emrul
 */
public class ReportGenerate {
     private SealsInfoImplDao sealsInfoImplDao = new SealsInfoImplDao();
    private SealsInfo sealsInfo = new SealsInfo();
    private BusTimeSchedule busTimeSchedule = new BusTimeSchedule();
    private BusTimeScheduleDaoImpl timeScheduleDaoImpl = new BusTimeScheduleDaoImpl();
    private double todayesTotalSold;
    public String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
    
    
    
    public double getTodayesTotalSold() {
        return todayesTotalSold;
    }

    public void setTodayesTotalSold(double todayesTotalSold) {
        this.todayesTotalSold = todayesTotalSold;
    } 
       
    public SealsInfoImplDao getSealsInfoImplDao() {
        return sealsInfoImplDao;
    }

    public void setSealsInfoImplDao(SealsInfoImplDao sealsInfoImplDao) {
        this.sealsInfoImplDao = sealsInfoImplDao;
    }

    public SealsInfo getSealsInfo() {
        return sealsInfo;
    }

    public void setSealsInfo(SealsInfo sealsInfo) {
        this.sealsInfo = sealsInfo;
    }

    public BusTimeSchedule getBusTimeSchedule() {
        return busTimeSchedule;
    }

    public void setBusTimeSchedule(BusTimeSchedule busTimeSchedule) {
        this.busTimeSchedule = busTimeSchedule;
    }

    public BusTimeScheduleDaoImpl getTimeScheduleDaoImpl() {
        return timeScheduleDaoImpl;
    }

    public void setTimeScheduleDaoImpl(BusTimeScheduleDaoImpl timeScheduleDaoImpl) {
        this.timeScheduleDaoImpl = timeScheduleDaoImpl;
    }
    
   public void searchOnDate(){
      
   // todayesTotalSold= sealsInfoImplDao.toDayesTotalSold(sealsInfo);
 
       todayesTotalSold= sealsInfoImplDao.companyName(sealsInfo,companyName);
 
   //  todayesTotalSold= sealsInfoImplDao.betweenTwoDate(sealsInfo,companyName);
   } 
   
   
     public void searchOnCompany(){
      
      todayesTotalSold= sealsInfoImplDao.toDayesTotalSold(sealsInfo);
       
   } 
}
