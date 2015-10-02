/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.controlloer;

import java.util.List;
import javax.faces.model.SelectItem;
import ticket.com.implDao.DistrictImpl;
import ticket.com.implDao.UpazilaInfoImpl;
import ticket.com.pojo.Districtinfo;
import ticket.com.pojo.Upazilainfo;

/**
 *
 * @author Robin Khan
 */
public class UpazilaInfoController {
    
  public  Upazilainfo u=new Upazilainfo();
  public UpazilaInfoImpl uii=new UpazilaInfoImpl();
  
  public Districtinfo d=new Districtinfo();
   public DistrictImpl di=new DistrictImpl();

    public UpazilaInfoController() {
    }

    public Upazilainfo getU() {
        return u;
    }

    public void setU(Upazilainfo u) {
        this.u = u;
    }

    public UpazilaInfoImpl getUii() {
        return uii;
    }

    public void setUii(UpazilaInfoImpl uii) {
        this.uii = uii;
    }

    public Districtinfo getD() {
        return d;
    }

    public void setD(Districtinfo d) {
        this.d = d;
    }

    public DistrictImpl getDi() {
        return di;
    }

    public void setDi(DistrictImpl di) {
        this.di = di;
    }
 
    
    
       public void insertUpazila(){
    
    uii.saveUpazilaInfo(u);
    }
    
       
     public List<SelectItem> getDistrictInfoList() {
        return di.getDistrictID();
    }
    
    
}
