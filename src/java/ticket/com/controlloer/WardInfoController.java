/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.controlloer;

import java.util.List;
import javax.faces.model.SelectItem;
import ticket.com.implDao.UnionInfoImpl;
import ticket.com.implDao.WardInfoImpl;
import ticket.com.pojo.Unioninfo;
import ticket.com.pojo.Wardinfo;

/**
 *
 * @author Robin Khan
 */
public class WardInfoController {
    
   public Wardinfo w=new Wardinfo();
  public WardInfoImpl wardInfoImpl=new WardInfoImpl();
  
  public Unioninfo uni=new Unioninfo();
  
  public UnionInfoImpl uniimpl=new UnionInfoImpl();

    public WardInfoController() {
        
    }

    public Wardinfo getW() {
        return w;
    }

    public void setW(Wardinfo w) {
        this.w = w;
    }

    public WardInfoImpl getWardInfoImpl() {
        return wardInfoImpl;
    }

    public void setWardInfoImpl(WardInfoImpl wardInfoImpl) {
        this.wardInfoImpl = wardInfoImpl;
    }

    public Unioninfo getUni() {
        return uni;
    }

    public void setUni(Unioninfo uni) {
        this.uni = uni;
    }

    public UnionInfoImpl getUniimpl() {
        return uniimpl;
    }

    public void setUniimpl(UnionInfoImpl uniimpl) {
        this.uniimpl = uniimpl;
    }
          
    
       public void insertWard(){
    
    wardInfoImpl.saveWardInfo(w);
    }
   
    
           
     public List<SelectItem> getUnionInfoList() {
        return uniimpl.getUnionID();
    }
       public List<SelectItem> getWardInfo() {
        return wardInfoImpl.getWardID();
    }
}
