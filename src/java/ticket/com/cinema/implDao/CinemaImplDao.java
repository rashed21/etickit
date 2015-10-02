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
import ticket.com.cinema.pojo.Cinema;


import ticket.com.connection.DBConnectionHandler;

/**
 *
 * @author Emrul
 */
public class CinemaImplDao {
    
    public boolean insert(Cinema obj) {
//      
        String sql = "insert into cinema(cinema_name,duration,release_date,producer,details,show_cata_id) values (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = DBConnectionHandler.getConnection().prepareStatement(sql);
            ps.setString(1, obj.getCinemaName());
            ps.setString(2, obj.getDuration());
            ps.setString(3, obj.getReleaseDate());
            ps.setString(4, obj.getProducer());
            ps.setString(5, obj.getDetails());
            ps.setInt(6, obj.getShowCataId());
            
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;

    }
   
  
  
  public List<SelectItem> getCinemaListForListItems() {
        List<SelectItem> list = new ArrayList<SelectItem>();
        for (Cinema catt : getAllHallInfoList()) {
            
            list.add(new SelectItem(catt.getCinemaId(), catt.getCinemaName()));        
       
        }
        return list;
    }
  
  
  
   public List<Cinema> getAllHallInfoList() {
        List<Cinema> list = new ArrayList<Cinema>();
        String sql = "SELECT cinema.cinema_name,\n" +
"       cinema.cinema_id,\n" +
"       cinema.duration,\n" +
"       cinema.release_date,\n" +
"       cinema.producer,\n" +
"       cinema.details,\n" +
"       cinema.show_catagory,\n" +
"       cinema.show_cata_id,\n" +
"       show_catagory.show_name\n" +
"  FROM ticket.cinema cinema\n" +
"    JOIN ticket.show_catagory show_catagory\n" +
"          ON (cinema.show_cata_id = show_catagory.show_cata_id);";
        try {
            Statement st = DBConnectionHandler.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Cinema ru = new Cinema();
                ru.setCinemaId(rs.getInt("cinema_id"));
                ru.setCinemaName(rs.getString("cinema_name"));
                ru.setDuration(rs.getString("duration"));
                ru.setReleaseDate(rs.getString("release_date"));
                ru.setProducer(rs.getString("producer"));
                ru.setDetails(rs.getString("details"));
                ru.setShowCata(rs.getString("show_catagory"));
                list.add(ru);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    
}
