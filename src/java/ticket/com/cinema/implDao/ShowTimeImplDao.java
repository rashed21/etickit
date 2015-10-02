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
import ticket.com.cinema.pojo.ShowTime;

import ticket.com.connection.DBConnectionHandler;

/**
 *
 * @author Emrul
 */
public class ShowTimeImplDao {
     public boolean insert(ShowTime obj) {
//      
        String sql = "insert into show_time(hall_id,show_time,title) values (?,?,?)";
        try {
            PreparedStatement ps = DBConnectionHandler.getConnection().prepareStatement(sql);
            ps.setInt(1, obj.getHallId());
            ps.setString(2, obj.getShowTimeinHour());
            ps.setString(3, obj.getTitle());
           
            
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;

    }
   
  
  
  public List<SelectItem> getShowListForItems() {
        List<SelectItem> list = new ArrayList<SelectItem>();
        for (ShowTime catt : getAllShowTimeList()) {
            
            list.add(new SelectItem(catt.getShowId(), catt.getShowTimeinHour()));        
       
        }
        return list;
    }
  
  
  
   public List<ShowTime> getAllShowTimeList() {
        List<ShowTime> list = new ArrayList<ShowTime>();
        String sql = "SELECT hall_info.name,\n" +
"       show_time.show_time,\n" +
"       show_time.title,\n" +
"       show_time.show_id,\n" +
"       show_time.hall_id\n" +
"  FROM ticket.show_time show_time\n" +
"       INNER JOIN ticket.hall_info hall_info\n" +
"          ON (show_time.hall_id = hall_info.hall_id);";
        try {
            Statement st = DBConnectionHandler.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ShowTime ru = new ShowTime();
                ru.setShowId(rs.getInt("show_id"));
                ru.setHallId(rs.getInt("hall_id"));
                ru.setHallName(rs.getString("name"));
                ru.setShowTimeinHour(rs.getString("show_time"));
                ru.setTitle(rs.getString("title"));
               
                list.add(ru);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
   
   
}
