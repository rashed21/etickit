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
import ticket.com.launch.pojo.LaunchSalseSeat;

/**
 *
 * @author Emrul
 */
public class LaunchSalseSeatImplDao {

    public boolean insert(LaunchSalseSeat obj) {
//      
        String sql = "insert into launch_seat_salse(lau_ava_seat_id,salse_seat_no,total_fair,salse_seat_name) values (?,?,?,?)";
        try {
            PreparedStatement ps = DBConnectionHandler.getConnection().prepareStatement(sql);
            ps.setInt(1, obj.getLauAvaiSeatId());
            ps.setInt(2, obj.getLauSalseSeatNo());
            ps.setDouble(3, obj.getTotalFair());
            ps.setString(4, obj.getLauSalseSeatName());
           // ps.setInt(5, obj.getSeatTypeID());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;

    }

    public String getTotalSoldedSeatsOnLaunchiOnCritera(int obj) {
     
String totalSeat=null;
        String sql = "SELECT lau_ava_seat_id,\n" +
"        GROUP_CONCAT(DISTINCT salse_seat_name\n" +
"                  ORDER BY salse_seat_name DESC SEPARATOR ', ') as seats\n" +
"       FROM ticket.launch_seat_salse\n" +
"        where lau_ava_seat_id='"+obj+"'\n" +
"       GROUP BY lau_ava_seat_id ;";

        try {
            Statement st = DBConnectionHandler.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
           System.out.println("Total Seats for soldes table : ");
           if(rs.wasNull()){
               totalSeat=null;
                System.out.println("Total Seats from  soldes table : ");
           }else{
              while (rs.next()) {                   
                totalSeat=rs.getString("seats");
                System.out.println("Total Seats for soldes table : "+totalSeat);
            } 
           }
//            while (rs.next()) {                   
//                totalSeat=rs.getString("seats");
//                System.out.println("Total Seats for soldes table : "+totalSeat);
//            }
        } catch (Exception e) {
            System.out.println("SQL Exception :"+e);
        }
        return totalSeat;
    }

}
