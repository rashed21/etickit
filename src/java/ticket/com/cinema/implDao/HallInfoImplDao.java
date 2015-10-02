/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.cinema.implDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import ticket.com.cinema.pojo.HallInfo;
import ticket.com.connection.DBConnectionHandler;
import ticket.com.launch.pojo.LaunchSeatType;

/**
 *
 * @author Emrul
 */
public class HallInfoImplDao {
    
    
  public boolean insert(HallInfo obj) {
//      
        String sql = "insert into hall_info(name,location,details,address) values (?,?,?,?)";
        try {
            PreparedStatement ps = DBConnectionHandler.getConnection().prepareStatement(sql);
            ps.setString(1, obj.getHallName());
            ps.setString(2, obj.getLocation());
            ps.setString(3, obj.getDetails());
            ps.setString(4, obj.getAddress());
            
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;

    }
   
  
  
  public List<SelectItem> getHallInfListForListItems() {
        List<SelectItem> list = new ArrayList<SelectItem>();
        for (HallInfo catt : getAllHallInfoList()) {
            
            list.add(new SelectItem(catt.getHallId(), catt.getHallName()));        
       
        }
        return list;
    }
  
  
  
   public List<HallInfo> getAllHallInfoList() {
        List<HallInfo> list = new ArrayList<HallInfo>();
        String sql = "SELECT * FROM hall_info;";
        try {
            Statement st = DBConnectionHandler.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                HallInfo ru = new HallInfo();
                ru.setHallId(rs.getInt("hall_id"));
                ru.setHallName(rs.getString("name"));
                ru.setLocation(rs.getString("location"));
                ru.setDetails(rs.getString("details"));
                ru.setAddress(rs.getString("address"));
                
                list.add(ru);
            }
        } catch (Exception e) {
        }
        return list;
    }
  
}
