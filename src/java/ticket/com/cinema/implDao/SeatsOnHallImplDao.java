/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.cinema.implDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import ticket.com.cinema.pojo.SeatsOnHall;
import ticket.com.connection.DBConnectionHandler;

/**
 *
 * @author Emrul
 */
public class SeatsOnHallImplDao {
    public boolean insert(SeatsOnHall obj) {
        String sql = "insert into seats_on_hall(hall_id,show_id,hall_seat_cata_id,seats_name,total_seats,price) values (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = DBConnectionHandler.getConnection().prepareStatement(sql);
            ps.setInt(1, obj.getHallId());
            ps.setInt(2, obj.getShowId()); 
             ps.setInt(3, obj.getHallSeatsCataId());
              ps.setString(4, obj.getSeatsName());
              ps.setInt(5, obj.getTotalSeats());
             
              
           
              ps.setDouble(6, obj.getPrice());
              
             
            
            
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;

    }
   
    
    
    
    
    
    
    
    
    
//     public List<SelectItem> getShowOnHallAndSeatsForListItems(int hallId) {
//        List<SelectItem> list = new ArrayList<SelectItem>();
//        for (SeatsOnHall catt : getAllSeatsListOnHallID(hallId)) {
//            
//            list.add(new SelectItem(catt.getShowIdOnHall(), catt.getSeatsName()));        
//       
//        }
//        return list;
//    }

     public int checkAfterInsert(SeatsOnHall obj) {
         int result=0;
        String sql = "SELECT seats_on_hall.seat_id_on_hall,\n" +
"       seats_on_hall.hall_id,\n" +
"       seats_on_hall.show_id,\n" +
"       seats_on_hall.hall_seat_cata_id,\n" +
"       seats_on_hall.seats_name,\n" +
"       seats_on_hall.total_seats,\n" +
"       seats_on_hall.price\n" +
"  FROM ticket.seats_on_hall seats_on_hall\n" +
" WHERE     (seats_on_hall.hall_id = '"+obj.getHallId()+"')\n" +
"       AND (seats_on_hall.show_id = '"+obj.getShowId()+"')\n" +
"       AND (seats_on_hall.hall_seat_cata_id = '"+obj.getHallSeatsCataId()+"')";
        try {
            Statement st = DBConnectionHandler.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
               result+=1;
            }
        } catch (Exception e) {
        }
        return result;
    }
    
    
    
   public List<SeatsOnHall> getAllSeatsListOnHallID(int hallId) {
        List<SeatsOnHall> list = new ArrayList<SeatsOnHall>();
        String sql = "SELECT s.seat_id_on_hall, s.seats_name, s.total_seats,s.price,\n" +
" h.name,sh.show_time, sc.cata_name\n" +
"FROM ticket.seats_on_hall s\n" +
"join ticket.hall_info h\n" +
"on s.hall_id=h.hall_id\n" +
"join ticket.show_time sh\n" +
"on s.show_id=sh.show_id\n" +
"join ticket.hall_seat_catagory sc\n" +
"on s.hall_seat_cata_id=sc.hall_seat_cata_id\n" +
";";
        try {
            Statement st = DBConnectionHandler.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                SeatsOnHall ru = new SeatsOnHall();
               
                ru.setShowIdOnHall(rs.getInt("seat_id_on_hall"));              
                ru.setHallName(rs.getString("name"));
                ru.setSeatsName(rs.getString("seats_name"));
                ru.setCataName(rs.getString("cata_name"));
                ru.setShowTimeOhHall(rs.getString("show_time"));
                ru.setPrice(rs.getDouble("price"));
                 ru.setTotalSeats(rs.getInt("total_seats"));
               
                
                
                
                
                list.add(ru);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    
    
    
//      public List<ShowOnHallAndSeats> getAllShowAndSeatsListOnHall() {
//        List<ShowOnHallAndSeats> list = new ArrayList<ShowOnHallAndSeats>();
//        String sql = "SELECT show_shed_al_seals.shed_id, show_shed_al_seals.show_start\n" +
////"  FROM ticket.show_shed_al_seals show_shed_al_seals\n" +
////" WHERE show_shed_al_seals.hall_id = '"+hallId+"'";
//        try {
//            Statement st = DBConnectionHandler.getConnection().createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            while (rs.next()) {
//                ShowOnHallAndSeats ru = new ShowOnHallAndSeats();
//               
//                ru.setShowIdOnHall(rs.getInt("shed_id"));
//                ru.setShowStart(rs.getString("show_start"));
//                
//                
//                list.add(ru);
//            }
//        } catch (Exception e) {
//        }
//        return list;
//    }
//    
    
    
}
