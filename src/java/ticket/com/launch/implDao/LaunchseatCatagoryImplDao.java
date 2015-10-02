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
import ticket.com.launch.pojo.LaunchSeatCatagory;

/**
 *
 * @author Emrul
 */
public class LaunchseatCatagoryImplDao {
 
  
public boolean insert(LaunchSeatCatagory obj) {
        String sql = "insert into seat_catagory(cata_name) values (?)";
        try {
            PreparedStatement ps = DBConnectionHandler.getConnection().prepareStatement(sql);
          ps.setString(1, obj.seatCataName);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;

    }


public List<SelectItem> getLaunchSeatCata() {
        List<SelectItem> list = new ArrayList<SelectItem>();
        for (LaunchSeatCatagory catt : getAllLaunchSeatCatagory()) {
            
            list.add(new SelectItem(catt.getSeatCatagoryId(), catt.getSeatCataName()));        
       
        }
        return list;
    }
    
    
    
    
    public List<LaunchSeatCatagory> getAllLaunchSeatCatagory() {
        List<LaunchSeatCatagory> list = new ArrayList<LaunchSeatCatagory>();
        String sql = "SELECT * FROM seat_catagory;";
        try {
            Statement st = DBConnectionHandler.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                LaunchSeatCatagory ru = new LaunchSeatCatagory();
                ru.setSeatCatagoryId(rs.getInt("cata_id"));
                ru.setSeatCataName(rs.getString("cata_name"));
                list.add(ru);
            }
        } catch (Exception e) {
        }
        return list;
    }





}
