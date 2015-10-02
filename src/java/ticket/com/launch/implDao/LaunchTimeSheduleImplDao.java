/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.launch.implDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import ticket.com.connection.DBConnectionHandler;
import ticket.com.launch.pojo.Launch_TimeSchedule;
import ticket.com.pojo.BusTimeSchedule;

/**
 *
 * @author Emrul
 */
public class LaunchTimeSheduleImplDao {

    public boolean insert(Launch_TimeSchedule obj) {

       SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
       
        String sql = "insert into launch_time_schedule(depart_from,arrive_to,arriv_time,dept_time,launch_id) values (?,?,?,?,?)";
        try {
            PreparedStatement ps = DBConnectionHandler.getConnection().prepareStatement(sql);
            ps.setString(1, obj.getDepartFrom());
           
            ps.setString(2, obj.getArriveTo());
            String dt=sdfTime.format( obj.getArrivTime());
            ps.setString(3,dt);           
            String at=sdfTime.format( obj.getDeptTime());
            ps.setString(4,at);  
            ps.setInt(5, obj.getLaunchId());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;

    }

    public List<Launch_TimeSchedule> getAllLaunchTimeShedule() {
        List<Launch_TimeSchedule> list = new ArrayList<Launch_TimeSchedule>();
        
         String sql = "SELECT * FROM launch_time_schedule;";
        
        try {
            Statement st = DBConnectionHandler.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Launch_TimeSchedule ru = new Launch_TimeSchedule();
                ru.setLaunchTimeId(rs.getInt("launch_time_id"));
                ru.setLaunchId(rs.getInt("launch_id"));
                ru.setDepartFrom(rs.getString("depart_from"));
                ru.setDeptTime((Time)rs.getTime("dept_time"));
                ru.setArrivTime((Time)rs.getTime("arriv_time"));
                ru.setArriveTo(rs.getString("arrive_to"));
                               
                list.add(ru);
                                
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Launch_TimeSchedule> getAllLaunchTimeSheduleForDisplayList() {
        List<Launch_TimeSchedule> list = new ArrayList<Launch_TimeSchedule>();
        
         String sql = "select l.launch_name, t.dept_time,t.arriv_time,t.depart_from,t.arrive_to\n" +
                        "FROM ticket.launch_time_schedule t\n" +
                        "INNER JOIN ticket.launch_info  l\n" +
                        "ON (t.launch_id = l.launch_id);";
        
        try {
            Statement st = DBConnectionHandler.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Launch_TimeSchedule ru = new Launch_TimeSchedule();               
                ru.setLaunchName(rs.getString("launch_name"));
                ru.setDepartFrom(rs.getString("depart_from"));
                ru.setDeptTime((Time)rs.getTime("dept_time"));
                ru.setArrivTime((Time)rs.getTime("arriv_time"));
                ru.setArriveTo(rs.getString("arrive_to"));
                               
                list.add(ru);
                                
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    
    
    
   //For searching on ticket Search arrival-depart place
            
            
        public List<Launch_TimeSchedule> getAllLaunchTimeSheduleOnSearchList(Launch_TimeSchedule obj) {
        List<Launch_TimeSchedule> list = new ArrayList<Launch_TimeSchedule>();
        
         String sql = "SELECT launch_info.launch_name,\n" +
                 "       launch_time_schedule.launch_time_id,\n" +
"       launch_time_schedule.dept_time,\n" +
"       launch_time_schedule.arriv_time,\n" +
"       launch_time_schedule.depart_from,\n" +
"       launch_time_schedule.arrive_to\n" +
"  FROM ticket.launch_time_schedule launch_time_schedule\n" +
"       INNER JOIN ticket.launch_info launch_info\n" +
"          ON (launch_time_schedule.launch_id = launch_info.launch_id)\n" +
" WHERE     (launch_time_schedule.depart_from = '"+obj.getDepartFrom()+"')\n" +
"       AND (launch_time_schedule.arrive_to = '"+obj.getArriveTo()+"');";
        
        try {
            Statement st = DBConnectionHandler.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Launch_TimeSchedule ru = new Launch_TimeSchedule();
                ru.setLaunchTimeId(rs.getInt("launch_time_id"));
                ru.setLaunchName(rs.getString("launch_name"));
                ru.setDepartFrom(rs.getString("depart_from"));
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

    
    public List<SelectItem> getLaunchTimeSdeduleList() {
        List<SelectItem> list = new ArrayList<SelectItem>();
        for (Launch_TimeSchedule catt : getAllLaunchTimeShedule()) {
            //In arrive to we have to set Launch name
            list.add(new SelectItem(catt.getLaunchTimeId(), catt.getArriveTo()));        
       
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
