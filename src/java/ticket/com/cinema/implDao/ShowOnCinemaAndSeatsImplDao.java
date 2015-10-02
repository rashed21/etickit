/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.cinema.implDao;

import java.sql.PreparedStatement;
import ticket.com.cinema.pojo.ShowOnCinemaAndSeats;
import ticket.com.connection.DBConnectionHandler;

/**
 *
 * @author Emrul
 */
public class ShowOnCinemaAndSeatsImplDao {
     public boolean insert(ShowOnCinemaAndSeats obj) {
        String sql = "insert into show_shed_al_seats_on_cinema(shed_id,show_start,hall_seat_cata_id_1,allocated_1,price_1,hall_seat_cata_id_2,allocated_2,price_2,hall_seat_cata_id_3,allocated_3,price_3) values (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = DBConnectionHandler.getConnection().prepareStatement(sql);
            ps.setInt(1, obj.getShowIdOnHall());
            ps.setString(2, obj.getShowDate()); 
             ps.setInt(3, obj.getSeatCata_1());
              ps.setString(4, obj.getAllocated_1());
              ps.setDouble(5, obj.getPrice_1());
             
              
              ps.setInt(6, obj.getSeatCata_2());
              ps.setString(7, obj.getAllocated_2());
              ps.setDouble(8, obj.getPrice_2());
              
              ps.setInt(9, obj.getSeatCata_3());
              ps.setString(10, obj.getAllocated_3());
              ps.setDouble(11, obj.getPrice_3());
            
            
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;

    } 
}
