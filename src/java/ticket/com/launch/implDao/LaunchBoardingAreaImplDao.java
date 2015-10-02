/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.launch.implDao;

import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import ticket.com.connection.DBConnectionHandler;
import ticket.com.launch.pojo.LaunchBordingArea;

/**
 *
 * @author Emrul
 */
public class LaunchBoardingAreaImplDao {
    
     public boolean insert(LaunchBordingArea obj) {
          SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
        String sql = "insert into launch_bording_area(bo_area_time,launch_time_id) values (?,?)";
        try {
            PreparedStatement ps = DBConnectionHandler.getConnection().prepareStatement(sql);
             String dt=sdfTime.format( obj.getBo_area_time());
            ps.setString(1, dt);
            ps.setInt(2, obj.launchTimeID);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    
}
