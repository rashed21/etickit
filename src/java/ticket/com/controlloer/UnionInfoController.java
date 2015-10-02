/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.controlloer;

import java.util.List;
import javax.faces.model.SelectItem;
import ticket.com.implDao.UnionInfoImpl;
import ticket.com.implDao.UpazilaInfoImpl;
import ticket.com.pojo.Unioninfo;
import ticket.com.pojo.Upazilainfo;

/**
 *
 * @author Robin Khan
 */
public class UnionInfoController {
    
    public Unioninfo u=new Unioninfo();
    
    public UnionInfoImpl uii=new UnionInfoImpl();
    
    public Upazilainfo u1=new Upazilainfo();
    public UpazilaInfoImpl uii1=new UpazilaInfoImpl();

    public Unioninfo getU() {
        return u;
    }

    public void setU(Unioninfo u) {
        this.u = u;
    }

    public UnionInfoImpl getUii() {
        return uii;
    }

    public void setUii(UnionInfoImpl uii) {
        this.uii = uii;
    }

    public Upazilainfo getU1() {
        return u1;
    }

    public void setU1(Upazilainfo u1) {
        this.u1 = u1;
    }

    public UnionInfoController() {
    }

    public UpazilaInfoImpl getUii1() {
        return uii1;
    }

    public void setUii1(UpazilaInfoImpl uii1) {
        this.uii1 = uii1;
    }
    
      public void insertUnion() {

        uii.saveUnionInfo(u);
    }
    
    
       public List<SelectItem> getUpazilaInfoList() {
        return uii1.getUpazilaID();
    }

}
