/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.controlloer;

import ticket.com.implDao.VillageInfoImpDao;
import ticket.com.pojo.VillageInfo;

/**
 *
 * @author Emrul
 */
public class VillageInfoControl {
    private VillageInfoImpDao villageInfoImpDao=new VillageInfoImpDao();
    private VillageInfo villageInfo=new VillageInfo();

    public VillageInfoImpDao getVillageInfoImpDao() {
        return villageInfoImpDao;
    }

    public void setVillageInfoImpDao(VillageInfoImpDao villageInfoImpDao) {
        this.villageInfoImpDao = villageInfoImpDao;
    }

    public VillageInfo getVillageInfo() {
        return villageInfo;
    }

    public void setVillageInfo(VillageInfo villageInfo) {
        this.villageInfo = villageInfo;
    }
    
    
    public void insert(){
        villageInfoImpDao.insert(villageInfo);
    }
}
