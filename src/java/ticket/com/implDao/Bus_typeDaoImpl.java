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
import javax.faces.model.SelectItem;
import ticket.com.connection.DBConnectionHandler;
import ticket.com.pojo.Bus_type;

/**
 *
 * @author Emrul
 */
public class Bus_typeDaoImpl implements Serializable {

    public boolean insert(Bus_type obj) {
        String sql = "insert into Bus_type(bus_type_name) values (?)";
        try {
            PreparedStatement ps = DBConnectionHandler.getConnection().prepareStatement(sql);
            ps.setString(1, obj.getBus_type_name());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;

    }

    
       public List<SelectItem> getBusTypeID() {
        List<SelectItem> list = new ArrayList<SelectItem>();
        for (Bus_type catt : getAllBus_type()) {
            
            list.add(new SelectItem(catt.getBus_type_id(), catt.getBus_type_name()));        
       
        }
        return list;
    }
    
    
    
    
    public List<Bus_type> getAllBus_type() {
        List<Bus_type> list = new ArrayList<Bus_type>();
        String sql = "SELECT * FROM Bus_type;";
        try {
            Statement st = DBConnectionHandler.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Bus_type ru = new Bus_type();
                ru.setBus_type_id(rs.getInt("bus_type_id"));
                ru.setBus_type_name(rs.getString("bus_type_name"));

                list.add(ru);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public boolean delete(int id) {

        String sql = "DELETE FROM Bus_type WHERE bus_type_id=?;";
        try {
            PreparedStatement ps = DBConnectionHandler.getConnection().prepareStatement(sql);
            ps.setInt(1, id);

            int i = ps.executeUpdate();
        } catch (SQLException ex) {

        }

        return true;
    }

}
