/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.launch.implDao;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import ticket.com.connection.DBConnectionHandler;
import ticket.com.launch.pojo.Launch_Route;


/**
 *
 * @author Emrul
 */
public class Launch_RouteImplDao implements Serializable {

    public boolean insert(Launch_Route obj) {
        String sql = "insert into launch_route(route_name) values (?)";
        try {
            PreparedStatement ps = DBConnectionHandler.getConnection().prepareStatement(sql);
            ps.setString(1, obj.getRoute_name());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;

    }

    public boolean delete(int id) {

        String sql = "DELETE FROM lauch_Route WHERE route_id=?;";
        try {
            PreparedStatement ps = DBConnectionHandler.getConnection().prepareStatement(sql);
            ps.setInt(1, id);

            int i = ps.executeUpdate();
        } catch (SQLException ex) {

        }

        return true;
    }

    public boolean update(Launch_Route r, int i) {
        String sql = "UPDATE lauch_Route SET route_name=? WHERE route_id=?;";
        System.out.println("Calling update");
        try {
            PreparedStatement ps = DBConnectionHandler.getConnection().prepareStatement(sql);
            ps.setString(1, r.getRoute_name());
            ps.setInt(2, i);
            ps.executeUpdate();

          
        } catch (SQLException ex) {

        }
        return true;
    }

    public List<Launch_Route> getAllRoute() {
        List<Launch_Route> list = new ArrayList<Launch_Route>();
        String sql = "SELECT * FROM launch_route;";
        try {
            Statement st = DBConnectionHandler.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Launch_Route ru = new Launch_Route();
                ru.setRoute_id(rs.getInt("route_id"));
                ru.setRoute_name(rs.getString("route_name"));
                ru.setStatus(rs.getString("status"));
                list.add(ru);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Launch_Route> getRouteByID(Launch_Route r) {
        List<Launch_Route> list = new ArrayList<Launch_Route>();
//  String sql = "SELECT route_name FROM ROUTE where route_id='1';";
        String sql = "SELECT * FROM lauch_Route where route_id='" + r.route_id + "';";
        try {
            Statement st = DBConnectionHandler.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Launch_Route ru = new Launch_Route();
                ru.setRoute_id(rs.getInt("route_id"));
                ru.setRoute_name(rs.getString("route_name"));
                ru.setStatus(rs.getString("status"));
                list.add(ru);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<SelectItem> getRouteID() {
        List<SelectItem> list = new ArrayList<>();
        getAllRoute().stream().forEach((catt) -> {
            list.add(new SelectItem(catt.getRoute_id(), catt.getRoute_name()));
        });
        return list;
    }

}
