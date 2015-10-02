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
import ticket.com.connection.DBConnectionHandler;
import ticket.com.launch.pojo.LaunchAvailableSeat;

/**
 *
 * @author Emrul
 */
public class LaunchAvailableSeatImplDao {
   public boolean insert(LaunchAvailableSeat obj) {
//      
        String sql = "insert into launch_available_seat(launch_time_id,availableSeat,seat_names,cata_id,seat_type_id) values (?,?,?,?,?)";
        try {
            PreparedStatement ps = DBConnectionHandler.getConnection().prepareStatement(sql);
            ps.setInt(1, obj.getLaunchTimeID());
            ps.setInt(2, obj.getAvailableSeat());
            ps.setString(3, obj.getSeatName());
            ps.setInt(4, obj.getSeatCataID());
            ps.setInt(5, obj.getSeatTypeID());
           

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;

    }
   
 
   
   
   
   
   public LaunchAvailableSeat getAvailableSeatsOnTypeAndCatagoeryForSeals(LaunchAvailableSeat obj) {
       System.out.println("Launch seat cataId : "+obj.getSeatCataID() );
        System.out.println("Launch Launch ID : "+obj.getLaunchTimeID());
         System.out.println("Launch seat Type ID : "+obj.getSeatTypeID());
        List<LaunchAvailableSeat> list = new ArrayList<LaunchAvailableSeat>();

        String sql = "SELECT launch_available_seat.launch_time_id,\n" +
"       launch_available_seat.cata_id,\n" +
"       launch_available_seat.seat_type_id,\n" +
"       launch_available_seat.availableSeat,\n" +
"       launch_available_seat.seat_names,\n" +
"       launch_available_seat.per_seat_fair,\n" +
"       launch_available_seat.lau_ava_seat_id\n" +
"  FROM ticket.launch_available_seat launch_available_seat\n" +
" WHERE     (launch_available_seat.launch_time_id = '"+obj.launchTimeID+"')\n" +
"       AND (launch_available_seat.cata_id = '"+obj.seatCataID+"')\n" +
"       AND (launch_available_seat.seat_type_id = '"+obj.seatTypeID+"')";

        try {
            Statement st = DBConnectionHandler.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                LaunchAvailableSeat ru = new LaunchAvailableSeat();

                ru.setAvailableSeat(rs.getInt("availableSeat"));
                ru.setSeatCataID(rs.getInt("cata_id"));
                ru.setSeatTypeID(rs.getInt("seat_type_id"));
                ru.setSeatName(rs.getString("seat_names"));
               
                ru.setLau_ava_seatID(rs.getInt("lau_ava_seat_id"));
                ru.setPerSeatFair(rs.getDouble("per_seat_fair"));
               
                list.add(ru);

            }
        } catch (Exception e) {
        }
        return list.get(0);
    }

   
   
   
    
}
