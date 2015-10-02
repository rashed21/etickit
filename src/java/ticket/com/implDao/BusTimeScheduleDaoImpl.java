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
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;
import ticket.com.connection.DBConnectionHandler;
import ticket.com.pojo.BusTimeSchedule;

/**
 *
 * @author Emrul
 */
public class BusTimeScheduleDaoImpl {

    public boolean insert(BusTimeSchedule obj) {

       SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
       
        String sql = "insert into bus_time_schedule(depart_from,tot_seat_no,arrive_to,available_seat,bus_type_id,arriv_time,dept_time,bus_id,value) values (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = DBConnectionHandler.getConnection().prepareStatement(sql);
            ps.setString(1, obj.getDepartFrom());
            ps.setInt(2, obj.getTotSeatNo());
            ps.setString(3, obj.getArriveTo());
            ps.setString(4, obj.getAvailableSeat());
            ps.setInt(5, obj.getBusType());
            
            String dt=sdfTime.format( obj.getArrivTime());
            ps.setString(6,dt); 
            
            String at=sdfTime.format( obj.getDeptTime());
            ps.setString(7,at); 
             ps.setInt(8,obj.getBusInfo());
            ps.setInt(9,obj.getValue());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;

    }

    public List<BusTimeSchedule> getAllBusTimeShedule() {
        List<BusTimeSchedule> list = new ArrayList<BusTimeSchedule>();
//        String sql = "SELECT * FROM bus_time_schedule;";
 
         String sql = "SELECT * FROM bus_time_schedule INNER JOIN bus_type on bus_time_schedule.bus_type_id=bus_type.bus_type_id;";
        
        try {
            Statement st = DBConnectionHandler.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                BusTimeSchedule ru = new BusTimeSchedule();
                ru.setBusTimeId(rs.getInt("bus_time_id"));
                ru.setBusInfo(rs.getInt("bus_id"));
                ru.setDepartFrom(rs.getString("depart_from"));
                ru.setBus_type_name(rs.getString("bus_type_name"));
                ru.setTotSeatNo(rs.getInt("tot_seat_no"));
                ru.setAvailableSeat(rs.getString("available_seat"));
                ru.setDeptTime((Time)rs.getTime("dept_time"));
                ru.setArrivTime((Time)rs.getTime("arriv_time"));
                ru.setArriveTo(rs.getString("arrive_to"));
                               
                list.add(ru);
                                
            }
        } catch (Exception e) {
        }
        return list;
    }

    public boolean delete(int id) {

        String sql = "DELETE FROM bus_time_schedule WHERE bus_time_id=?;";
        try {
            PreparedStatement ps = DBConnectionHandler.getConnection().prepareStatement(sql);
            ps.setInt(1, id);

            int i = ps.executeUpdate();
        } catch (SQLException ex) {

        }

        return true;
    }

    
    public List<SelectItem> getBusTimeSdeduleList() {
        List<SelectItem> list = new ArrayList<SelectItem>();
        for (BusTimeSchedule catt : getAllBusTimeShedule()) {
            
            list.add(new SelectItem(catt.getBusTimeId(), catt.getBus_type_name()));        
       
        }
        return list;
    }  
    
    //Available seats searching for that bus which bus has unsold seats.......
    
     public List<BusTimeSchedule> getAvailableSeatsBus(BusTimeSchedule obj) {
        List<BusTimeSchedule> list = new ArrayList<BusTimeSchedule>();
//        String sql = "SELECT * FROM bus_time_schedule;";
//         
 
//         String sql = "SELECT * FROM bus_time_schedule INNER JOIN bus_type on bus_time_schedule.bus_type_id=bus_type.bus_type_id;";
                 String sql = "SELECT * FROM bus_time_schedule  INNER JOIN bus_type on bus_time_schedule.bus_type_id=bus_type.bus_type_id where bus_time_schedule.depart_from='"+obj.getDepartFrom()+"' and bus_time_schedule.arrive_to='"+obj.getArriveTo()+"';";

        try {
            Statement st = DBConnectionHandler.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                BusTimeSchedule ru = new BusTimeSchedule();
                ru.setBusTimeId(rs.getInt("bus_time_id"));
                ru.setBusInfo(rs.getInt("bus_id"));
                ru.setDepartFrom(rs.getString("depart_from"));
                ru.setBus_type_name(rs.getString("bus_type_name"));
                ru.setTotSeatNo(rs.getInt("tot_seat_no"));
                ru.setAvailableSeat(rs.getString("available_seat"));
                ru.setDeptTime((Time)rs.getTime("dept_time"));
                ru.setArrivTime((Time)rs.getTime("arriv_time"));
                ru.setArriveTo(rs.getString("arrive_to"));
                ru.setValue(rs.getInt("value"));               
                list.add(ru);
                System.out.println(rs.getString("depart_from") +"From last of loop");                 
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    
    
     public BusTimeSchedule getAvailableSeatsForSeal(BusTimeSchedule obj) {
        List<BusTimeSchedule> list = new ArrayList<BusTimeSchedule>();
//        String sql = "SELECT * FROM bus_time_schedule;";
//         
 
//         String sql = "SELECT * FROM bus_time_schedule INNER JOIN bus_type on bus_time_schedule.bus_type_id=bus_type.bus_type_id;";
                 String sql = "SELECT * FROM bus_time_schedule  INNER JOIN bus_type on bus_time_schedule.bus_type_id=bus_type.bus_type_id where bus_time_schedule.bus_time_id='"+obj.getBusTimeId()+"';";
         BusTimeSchedule ru = new BusTimeSchedule();
        try {
            Statement st = DBConnectionHandler.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
               
                ru.setBusTimeId(rs.getInt("bus_time_id"));
                ru.setBusInfo(rs.getInt("bus_id"));
                ru.setDepartFrom(rs.getString("depart_from"));
                ru.setBus_type_name(rs.getString("bus_type_name"));
                ru.setTotSeatNo(rs.getInt("tot_seat_no"));
                ru.setAvailableSeat(rs.getString("available_seat"));
                ru.setDeptTime((Time)rs.getTime("dept_time"));
                ru.setArrivTime((Time)rs.getTime("arriv_time"));
                ru.setArriveTo(rs.getString("arrive_to"));
                ru.setValue(rs.getInt("value"));               
                list.add(ru);
                System.out.println(rs.getString("depart_from") +"From last of loop");                 
            }
        } catch (Exception e) {
        }
        return ru;
    }
    
    
    
}
