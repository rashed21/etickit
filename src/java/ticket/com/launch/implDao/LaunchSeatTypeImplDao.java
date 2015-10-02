/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.launch.implDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import ticket.com.connection.DBConnectionHandler;
import ticket.com.launch.pojo.LaunchSeatType;

/**
 *
 * @author Emrul
 */
public class LaunchSeatTypeImplDao {
 public boolean insert(LaunchSeatType obj) {
        String sql = "insert into seat_type(type_name) values (?)";
        try {
            PreparedStatement ps = DBConnectionHandler.getConnection().prepareStatement(sql);
           
            
             ps.setString(1, obj.getTypeName());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;

    }
    
 public List<SelectItem> getLaunchSeatType() {
        List<SelectItem> list = new ArrayList<SelectItem>();
        for (LaunchSeatType catt : getAllLaunchSeatType()) {
            
            list.add(new SelectItem(catt.getSeatTypeID(), catt.getTypeName()));        
       
        }
        return list;
    }
    
    
    
    
    public List<LaunchSeatType> getAllLaunchSeatType() {
        List<LaunchSeatType> list = new ArrayList<LaunchSeatType>();
        String sql = "SELECT * FROM seat_type;";
        try {
            Statement st = DBConnectionHandler.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                LaunchSeatType ru = new LaunchSeatType();
                ru.setSeatTypeID(rs.getInt("seat_type_id"));
                ru.setTypeName(rs.getString("type_name"));
                list.add(ru);
            }
        } catch (Exception e) {
        }
        return list;
    }
 
 
}
