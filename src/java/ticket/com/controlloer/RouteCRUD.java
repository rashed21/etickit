/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.controlloer;

import com.mysql.jdbc.Connection;
import ticket.com.connection.DBConnectionHandler;
import ticket.com.pojo.Route;
import java.sql.PreparedStatement;
import java.util.List;
import javax.faces.model.SelectItem;
import ticket.com.implDao.RouteDaoImpl;

/**
 *
 * @author Emrul
 */
public class RouteCRUD {
    
    public Route route=new Route();
    public RouteDaoImpl routeDaoImpl=new RouteDaoImpl();
    public String edit;

    public String getEdit() {
        return edit;
    }

    public void setEdit(String edit) {
        this.edit = edit;
    }
    
    public RouteDaoImpl getRouteDaoImpl() {
        return routeDaoImpl;
    }

    public void setRouteDaoImpl(RouteDaoImpl routeDaoImpl) {
        this.routeDaoImpl = routeDaoImpl;
    }
    

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

  
    public void insert(){
        routeDaoImpl.insert(route);  
        
    }
    
    
    public List<Route> getAllRoute(){
  
  return routeDaoImpl.getAllRoute();
  }
    
    public void delete(int i){
       
       routeDaoImpl.delete(i);
    } 
    
     public void update(int i){
        
       routeDaoImpl.update(route, i);
       route=new Route();
       
    } 
     
      public void update(){
       
       routeDaoImpl.update(route, route.route_id);
       route=new Route();
    }
      
       public void getRoutebyId(){
         
            route=  (Route) routeDaoImpl.getRouteByID(route);
    }
       
       
     public List<SelectItem> getAllRouteList(){
          return routeDaoImpl.getRouteID();
      }   
       
       
}
