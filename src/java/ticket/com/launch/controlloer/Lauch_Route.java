/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.launch.controlloer;

import java.util.List;
import javax.faces.model.SelectItem;
import ticket.com.launch.implDao.Launch_RouteImplDao;
import ticket.com.launch.pojo.Launch_Route;

/**
 *
 * @author Emrul
 */
public class Lauch_Route {
    
    public Launch_Route route=new Launch_Route();
    public Launch_RouteImplDao routeDaoImpl=new Launch_RouteImplDao();
    public String edit;

    public String getEdit() {
        return edit;
    }

    public void setEdit(String edit) {
        this.edit = edit;
    }

    public Launch_Route getRoute() {
        return route;
    }

    public void setRoute(Launch_Route route) {
        this.route = route;
    }

    public Launch_RouteImplDao getRouteDaoImpl() {
        return routeDaoImpl;
    }

    public void setRouteDaoImpl(Launch_RouteImplDao routeDaoImpl) {
        this.routeDaoImpl = routeDaoImpl;
    }
    
    

  
    public void insert(){
        routeDaoImpl.insert(route);  
        
    }
    
    
    public List<Launch_Route> getAllRoute(){
  
  return routeDaoImpl.getAllRoute();
  }
    
    public void delete(int i){
       
       routeDaoImpl.delete(i);
    } 
    
     public void update(int i){
        
       routeDaoImpl.update(route, i);
       route=new Launch_Route();
       
    } 
     
      public void update(){
       
       routeDaoImpl.update(route, route.route_id);
       route=new Launch_Route();
    }
      
       public void getRoutebyId(){
         
            route=  (Launch_Route) routeDaoImpl.getRouteByID(route);
    }
       
       
     public List<SelectItem> getAllRouteList(){
          return routeDaoImpl.getRouteID();
      }   
       
       
}
