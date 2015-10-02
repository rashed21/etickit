/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.controlloer;

import ticket.com.implDao.DivisionInfoImpl;
import ticket.com.pojo.Divisioninfo;

/**
 *
 * @author Robin Khan
 */
public class DivisionInfoController {
    
    public Divisioninfo divisioninfo=new Divisioninfo();
    public DivisionInfoImpl divisionInfoImpl=new DivisionInfoImpl();

    public DivisionInfoController() {
        
    }

    public Divisioninfo getDivisioninfo() {
        return divisioninfo;
    }

    public void setDivisioninfo(Divisioninfo divisioninfo) {
        this.divisioninfo = divisioninfo;
    }

    public DivisionInfoImpl getDivisionInfoImpl() {
        return divisionInfoImpl;
    }

    public void setDivisionInfoImpl(DivisionInfoImpl divisionInfoImpl) {
        this.divisionInfoImpl = divisionInfoImpl;
    }
    
    
      public void insertDivision(){
    
    divisionInfoImpl.saveDivisionInfo(divisioninfo);
    }
    
    
}
