/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.implDao;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ticket.com.connection.DBConnectionHandler;
import ticket.com.dao.TicketInterface;
import ticket.com.pojo.Route_Details;

/**
 *
 * @author Emrul
 */
public class Route_DetailsDaoImpl implements  Serializable {

      public boolean insert(Route_Details obj) {
        String sql = "insert into route_details(route_del_name) values (?)";
        try {
            PreparedStatement ps = DBConnectionHandler.getConnection().prepareStatement(sql);
           
             ps.setString(1, obj.getRoute_del_name());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;

    }
    
    public List<Route_Details> getAllRoute_Details(){
  List<Route_Details> list = new ArrayList<Route_Details>();
  String sql = "SELECT * FROM route_details;";
  try {
      Statement st = DBConnectionHandler.getConnection().createStatement();
      ResultSet rs = st.executeQuery(sql);
      while (rs.next()) {
        Route_Details ru = new Route_Details();
        ru.setRoute_del_id(rs.getInt("route_details_id"));         
        ru.setRoute_del_name(rs.getString("route_del_name"));       
        list.add(ru);
      }
    } catch (Exception e) {
    }
  return list;
  }  
      
    public boolean delete(int id) {
       
          String sql = "DELETE FROM route_details WHERE route_details_id=?;";
    try {
      PreparedStatement ps = DBConnectionHandler.getConnection().prepareStatement(sql);
      ps.setInt(1, id);
     
      int i = ps.executeUpdate();
    } catch (SQLException ex) {
     
    }    
    return true;
    }  
}
