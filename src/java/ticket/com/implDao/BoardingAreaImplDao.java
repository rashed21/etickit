/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.implDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            // String dt=sdfTime.format( obj.getBo_area_time());
            ps.setString(1, obj.place+"("+obj.bo_area_time+")");
            ps.setInt(2, obj.bus_time_id);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
              try {
                  DBConnectionHandler.getConnection().close();
              } catch (SQLException ex) {
                  Logger.getLogger(BoardingAreaImplDao.class.getName()).log(Level.SEVERE, null, ex);
              }
        }
        return true;
    }
   
     
     
       public List<BoardingArea> getAllBoardingArea() {
        List<BoardingArea> list = new ArrayList<BoardingArea>();
        String sql = "SELECT bording_area.bo_area_time,\n" +
"       bus_info.bus_name,\n" +
"       bording_area.bus_time_id,\n" +
"       bording_area.bo_area_id\n" +
"  FROM (ticket.bus_time_schedule bus_time_schedule\n" +
"        INNER JOIN ticket.bus_info bus_info\n" +
"           ON (bus_time_schedule.bus_id = bus_info.bus_id))\n" +
"       INNER JOIN ticket.bording_area bording_area\n" +
"          ON (bording_area.bus_time_id = bus_time_schedule.bus_time_id);";
        try {
            Statement st = DBConnectionHandler.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                BoardingArea ru = new BoardingArea();
                ru.setBo_area_id(rs.getInt("bo_area_id"));
                ru.setBus_time_id(rs.getInt("bus_time_id"));
                 ru.setBoard_bus_name(rs.getString("bus_name"));
                ru.setBo_area_time(rs.getString("bo_area_time"));
                list.add(ru);
            }
        } catch (Exception e) {
        }
        return list;
    }
}
