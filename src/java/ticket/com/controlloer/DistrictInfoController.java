/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.controlloer;

import java.util.List;
import javax.faces.model.SelectItem;
import ticket.com.implDao.DistrictImpl;
import ticket.com.implDao.DivisionInfoImpl;
import ticket.com.pojo.Districtinfo;
import ticket.com.pojo.Divisioninfo;

/**
 *
 * @author Robin Khan
 */
public class DistrictInfoController {
    public Districtinfo disinfo=new Districtinfo();
    
    public DistrictImpl disImpl=new DistrictImpl();
    
    public Divisioninfo d=new Divisioninfo();
    public DivisionInfoImpl dii=new DivisionInfoImpl();

    public DistrictImpl getDisImpl() {
        return disImpl;
    }

    public void setDisImpl(DistrictImpl disImpl) {
        this.disImpl = disImpl;
    }

    public DistrictInfoController() {
        
        
    }

    public Districtinfo getDisinfo() {
        return disinfo;
    }

    public void setDisinfo(Districtinfo disinfo) {
        this.disinfo = disinfo;
    }

 

   
       public void insertDistrict(){
    
    disImpl.saveDistrictInfo(disinfo);
    }
    
       
         public List<SelectItem> getDivisionInfoList(){
          return dii.getDivisionID();
      }
    
    
}
