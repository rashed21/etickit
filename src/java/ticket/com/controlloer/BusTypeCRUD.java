/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.controlloer;

import java.util.List;
import javax.faces.model.SelectItem;
import ticket.com.implDao.Bus_typeDaoImpl;
import ticket.com.pojo.Bus_type;

/**
 *
 * @author Emrul
 */
public class BusTypeCRUD {
    private Bus_typeDaoImpl bus_typeDaoImpl=new Bus_typeDaoImpl();
    private Bus_type bus_type=new Bus_type();

    public Bus_typeDaoImpl getBus_typeDaoImpl() {
        return bus_typeDaoImpl;
    }

    public void setBus_typeDaoImpl(Bus_typeDaoImpl bus_typeDaoImpl) {
        this.bus_typeDaoImpl = bus_typeDaoImpl;
    }

    public Bus_type getBus_type() {
        return bus_type;
    }

    public void setBus_type(Bus_type bus_type) {
        this.bus_type = bus_type;
    }
    
     public void insert(){
        bus_typeDaoImpl.insert(bus_type);
    }
    
       public List<Bus_type> getAllBus_type(){
         
  return bus_typeDaoImpl.getAllBus_type();
  }
   
       public void delete(int i){
           bus_typeDaoImpl.delete(i);
       }
      public List<SelectItem> getbusTypeInfoList(){
          return bus_typeDaoImpl.getBusTypeID();
      }
     
}



