/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.cinema.controlloer;

import java.util.List;
import ticket.com.cinema.implDao.HallInfoImplDao;
import ticket.com.cinema.pojo.HallInfo;

/**
 *
 * @author Emrul
 */
public class HallInfoController {
   private HallInfo hallInfo=new HallInfo();
   private HallInfoImplDao hallInfoImplDao=new HallInfoImplDao();

    public HallInfo getHallInfo() {
        return hallInfo;
    }

    public void setHallInfo(HallInfo hallInfo) {
        this.hallInfo = hallInfo;
    }

    public HallInfoImplDao getHallInfoImplDao() {
        return hallInfoImplDao;
    }

    public void setHallInfoImplDao(HallInfoImplDao hallInfoImplDao) {
        this.hallInfoImplDao = hallInfoImplDao;
    }
   
   
   public void insert(){
       try {
            hallInfoImplDao.insert(hallInfo);
       } catch (Exception e) {
       }finally{
           hallInfo=null;
       }
      
   }
   
   public List<HallInfo> getHallInfoList(){
       return hallInfoImplDao.getAllHallInfoList();
   }
}
