/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.launch.pojo;

/**
 *
 * @author Emrul
 */
public class Launch_Route implements java.io.Serializable{
    public int  route_id;
    public String Route_name;
    public String status;

    public Launch_Route() {
    }

    public int getRoute_id() {
        return route_id;
    }

    public void setRoute_id(int route_id) {
        this.route_id = route_id;
    }

    public String getRoute_name() {
        return Route_name;
    }

    public void setRoute_name(String Route_name) {
        this.Route_name = Route_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

    
}
