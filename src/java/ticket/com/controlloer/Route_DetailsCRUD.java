/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.controlloer;

import java.util.List;
import ticket.com.implDao.Route_DetailsDaoImpl;
import ticket.com.pojo.Route_Details;

/**
 *
 * @author Emrul
 */
public class Route_DetailsCRUD {

    private Route_DetailsDaoImpl route_DetailsDaoImpl = new Route_DetailsDaoImpl();
    private Route_Details route_Details = new Route_Details();

    public Route_DetailsDaoImpl getRoute_DetailsDaoImpl() {
        return route_DetailsDaoImpl;
    }

    public void setRoute_DetailsDaoImpl(Route_DetailsDaoImpl route_DetailsDaoImpl) {
        this.route_DetailsDaoImpl = route_DetailsDaoImpl;
    }

    public Route_Details getRoute_Details() {
        return route_Details;
    }

    public void setRoute_Details(Route_Details route_Details) {
        this.route_Details = route_Details;
    }

    public void insert() {

        route_DetailsDaoImpl.insert(route_Details);
    }

    public List<Route_Details> getAllRoute_Details() {

        return route_DetailsDaoImpl.getAllRoute_Details();
    }

    public void delete(int i) {
        route_DetailsDaoImpl.delete(i);
    }
}
