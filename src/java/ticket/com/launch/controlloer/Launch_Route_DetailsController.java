/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.launch.controlloer;

import java.util.List;
import ticket.com.launch.implDao.Launch_Route_ImplDao;
import ticket.com.launch.pojo.Launch_Route_Details;

/**
 *
 * @author Emrul
 */
public class Launch_Route_DetailsController {

    private Launch_Route_ImplDao route_DetailsDaoImpl = new Launch_Route_ImplDao();
    private Launch_Route_Details route_Details = new Launch_Route_Details();

    public Launch_Route_ImplDao getRoute_DetailsDaoImpl() {
        return route_DetailsDaoImpl;
    }

    public void setRoute_DetailsDaoImpl(Launch_Route_ImplDao route_DetailsDaoImpl) {
        this.route_DetailsDaoImpl = route_DetailsDaoImpl;
    }

    public Launch_Route_Details getRoute_Details() {
        return route_Details;
    }

    public void setRoute_Details(Launch_Route_Details route_Details) {
        this.route_Details = route_Details;
    }


    public void insert() {

        route_DetailsDaoImpl.insert(route_Details);
    }

    public List<Launch_Route_Details> getAllRoute_Details() {

        return route_DetailsDaoImpl.getAllRoute_Details();
    }

    public void delete(int i) {
        route_DetailsDaoImpl.delete(i);
    }
}
