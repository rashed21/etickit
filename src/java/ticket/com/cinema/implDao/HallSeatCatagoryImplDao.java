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

import ticket.com.cinema.pojo.HallSeatCatagory;
import ticket.com.connection.DBConnectionHandler;

/**
 *
 * @author Emrul
 */
public class HallSeatCatagoryImplDao {
      public boolean insert(HallSeatCatagory obj) {
        String sql = "insert into hall_seat_catagory(hall_id,cata_name) values (?,?)";
        try {
            PreparedStatement ps = DBConnectionHandler.getConnection().prepareStatement(sql);
            ps.setInt(1, obj.getHallId());
            ps.setString(2, obj.getCataName());   
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;

    }
    public List<SelectItem> getHallSeatCatagorForListItems(int hallId) {
        List<SelectItem> list = new ArrayList<SelectItem>();
        for (HallSeatCatagory catt : getAllHallSeatCataListOnHallID(hallId)) {
            
            list.add(new SelectItem(catt.getHallSeatCataId(), catt.getCataName()));        
       
        }
        return list;
    }

    
    
    
   public List<HallSeatCatagory> getAllHallSeatCataListOnHallID(int hallId) {
        List<HallSeatCatagory> list = new ArrayList<HallSeatCatagory>();
        String sql = "SELECT hall_seat_catagory.cata_name, hall_seat_catagory.hall_seat_cata_id\n" +
"  FROM ticket.hall_seat_catagory hall_seat_catagory\n" +
" WHERE hall_seat_catagory.hall_id = '"+hallId+"'";
        try {
            Statement st = DBConnectionHandler.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                HallSeatCatagory ru = new HallSeatCatagory();
               
                ru.setHallSeatCataId(rs.getInt("hall_seat_cata_id"));
                ru.setCataName(rs.getString("cata_name"));
                
                
                list.add(ru);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    
    
    
    
    
    
    
    
  
   public List<HallSeatCatagory> getAllHallSeatCatagoryList() {
        List<HallSeatCatagory> list = new ArrayList<HallSeatCatagory>();
        String sql = "SELECT hall_info.name, hall_seat_catagory.cata_name\n" +
"  FROM ticket.hall_seat_catagory hall_seat_catagory\n" +
"       INNER JOIN ticket.hall_info hall_info\n" +
"          ON (hall_seat_catagory.hall_id = hall_info.hall_id)\n" +
" WHERE hall_info.hall_id = hall_seat_catagory.hall_id";
        try {
            Statement st = DBConnectionHandler.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                HallSeatCatagory ru = new HallSeatCatagory();
               
                ru.setHallName(rs.getString("name"));
                ru.setCataName(rs.getString("cata_name"));
                
                
                list.add(ru);
            }
        } catch (Exception e) {
        }
        return list;
    }
  
   
   
}
