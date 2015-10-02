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
import ticket.com.cinema.pojo.ShowCatagory;

import ticket.com.connection.DBConnectionHandler;

/**
 *
 * @author Emrul
 */
public class ShowCatagoryImplDao {
     public boolean insert(ShowCatagory obj) {
//      
        String sql = "insert into show_catagory(show_name) values (?)";
        try {
            PreparedStatement ps = DBConnectionHandler.getConnection().prepareStatement(sql);
            ps.setString(1, obj.getShowName());
            
           
            
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;

    }
   
  
  
  public List<SelectItem> getShowCatagoryForListItems() {
        List<SelectItem> list = new ArrayList<SelectItem>();
        for (ShowCatagory catt : getAllShowCatagoryList()) {
            
            list.add(new SelectItem(catt.getShowId(), catt.getShowName()));        
       
        }
        return list;
    }
  
  
  
   public List<ShowCatagory> getAllShowCatagoryList() {
        List<ShowCatagory> list = new ArrayList<ShowCatagory>();
        String sql = "SELECT * FROM show_catagory;";
        try {
            Statement st = DBConnectionHandler.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ShowCatagory ru = new ShowCatagory();
                ru.setShowId(rs.getInt("show_cata_id"));
                ru.setShowName(rs.getString("show_name"));
                
                
                list.add(ru);
            }
        } catch (Exception e) {
        }
        return list;
    }
  
}
