/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.implDao;

import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import ticket.com.connection.DBConnectionHandler;
import ticket.com.pojo.BoardingArea;
import ticket.com.pojo.Bus_type;

/**
 *
 * @author Emrul
 */
public class BoardingAreaImplDao {
    
     public boolean insert(BoardingArea obj) {
          SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
        String sql = "insert into bording_area(bo_area_time,bus_time_id) values (?,?)";
        try {
            
            
            PreparedStatement ps = DBConnectionHandler.getConnection().prepareStatement(sql);
             String dt=sdfTime.format( obj.getBo_area_time());
            ps.setString(1, dt);
            ps.setInt(2, obj.bus_time_id);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    
}
