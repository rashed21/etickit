/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.implDao;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import ticket.com.connection.DBConnectionHandler;
import ticket.com.pojo.SealsInfo;

/**
 *
 * @author Emrul
 */
public class SealsInfoImplDao {
   public double todayesTotalSold;
    
    public boolean insert(SealsInfo obj) {
        String sql = "insert into seals_info(seats,total_price,seal_date,journny_date,bus_time_id) values (?,?,?,?,?)";
        try {
            PreparedStatement ps = DBConnectionHandler.getConnection().prepareStatement(sql);
            ps.setString(1, obj.getSelectedSeat());
            ps.setInt(2, obj.getPrice());             
            SimpleDateFormat salseDate = new SimpleDateFormat("yyyy/MM/dd");
            ps.setString(3, salseDate.format(new Date()));           
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            ps.setString(4, "" + format.format(obj.getJournyDate()));
            ps.setInt(5, obj.getTimeSheduleId());          
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;

    }
    
    
    
    
     String seat=null;
     public String getAvailableSeatsForSeal(SealsInfo obj) {
         
         SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            String da=  format.format(obj.getJournyDate());
            Connection con=DBConnectionHandler.getConnection();          
        String sql = "SELECT * FROM seals_info where bus_time_id='"+obj.getTimeSheduleId()+"' and journny_date='"+da+"';";
          seat=null;
        try {
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                 
               if(seat==null){
                 seat=rs.getString("seats");   
               }else{
                   seat+=","+rs.getString("seats"); 
               }              
            }
        } catch (Exception e) {
        }finally{
             try {
                 con.close();
                 
             } catch (SQLException ex) {
                 Logger.getLogger(SealsInfoImplDao.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        
        return seat;
    }
    
    
    
    
     public double toDayesTotalSold(SealsInfo obj) {
         todayesTotalSold=0;
         SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            String da=  format.format(obj.getJournyDate());
            Connection con=DBConnectionHandler.getConnection();          
        //String sql = "SELECT * FROM seals_info where bus_time_id='"+obj.getTimeSheduleId()+"' and journny_date='"+da+"';";
            String sql = "SELECT * FROM seals_info where journny_date='"+da+"';";
          
        try {
           
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                 todayesTotalSold+=rs.getInt("total_price");
                          
            }
        } catch (Exception e) {
        }finally{
             try {
                 con.close();
                 
             } catch (SQLException ex) {
                 Logger.getLogger(SealsInfoImplDao.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
         System.out.println("Total Solded amount is "+todayesTotalSold);
        return todayesTotalSold;
    }
    
     
    
    
    public double companyName(SealsInfo obj,String a) {
         todayesTotalSold=0;
         SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            String da=  format.format(obj.getJournyDate());
            Connection con=DBConnectionHandler.getConnection();          
   // String sql = "SELECT * FROM seals_info where bus_time_id=(select bus_time_id from bus_time_schedule where depart_from='Bogra')";
//       String sql = "SELECT * FROM seals_info where bus_time_id=(select bus_time_id from bus_time_schedule where"
//               + " bus_id=(select bus_id from bus_info where bus_name='Desh'))";
    String sql = "SELECT  seals_info.total_price,\n" +
"                bus_time_schedule.bus_id,\n" +
"                bus_info.bus_id,\n" +
"                company_info.company_id,\n" +
"                company_info.company_name\n" +
"  FROM ((ticket.bus_info bus_info\n" +
"         INNER JOIN ticket.company_info company_info\n" +
"            ON (bus_info.company_id = company_info.company_id))\n" +
"        INNER JOIN ticket.bus_time_schedule bus_time_schedule\n" +
"           ON (bus_time_schedule.bus_id = bus_info.bus_id))\n" +
"       INNER JOIN ticket.seals_info seals_info\n" +
"          ON (seals_info.bus_time_id = bus_time_schedule.bus_time_id)\n" +
"   WHERE     (seals_info.seal_date = '"+da+"')\n" +
"       AND (company_info.company_name = '"+a+"')";

            try {
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                 todayesTotalSold+=rs.getInt("total_price");
                          
            }
        } catch (Exception e) {
        }finally{
             try {
                 con.close();
                 
             } catch (SQLException ex) {
                 Logger.getLogger(SealsInfoImplDao.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
         System.out.println("Calling from subquery on Bogra "+todayesTotalSold);
        return todayesTotalSold;
    }
    
    
    
    public double betweenTwoDate(SealsInfo obj,String a) {
         todayesTotalSold=0;
         SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            String da=  format.format(obj.getJournyDate());
             String to=  format.format(obj.getFromDate());
            Connection con=DBConnectionHandler.getConnection();          
   // String sql = "SELECT * FROM seals_info where bus_time_id=(select bus_time_id from bus_time_schedule where depart_from='Bogra')";
//       String sql = "SELECT * FROM seals_info where bus_time_id=(select bus_time_id from bus_time_schedule where"
//               + " bus_id=(select bus_id from bus_info where bus_name='Desh'))";
    String sql = "SELECT  seals_info.total_price,\n" +
"                bus_time_schedule.bus_id,\n" +
"                bus_info.bus_id,\n" +
"                company_info.company_id,\n" +
"                company_info.company_name\n" +
"  FROM ((ticket.bus_info bus_info\n" +
"         INNER JOIN ticket.company_info company_info\n" +
"            ON (bus_info.company_id = company_info.company_id))\n" +
"        INNER JOIN ticket.bus_time_schedule bus_time_schedule\n" +
"           ON (bus_time_schedule.bus_id = bus_info.bus_id))\n" +
"       INNER JOIN ticket.seals_info seals_info\n" +
"          ON (seals_info.bus_time_id = bus_time_schedule.bus_time_id)\n" +
"   WHERE     (seals_info.seal_date BETWEEN  '"+da+"' AND '"+to+"')\n" +
"       AND (company_info.company_name = '"+a+"')";

            try {
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                 todayesTotalSold+=rs.getInt("total_price");
                          
            }
        } catch (Exception e) {
        }finally{
             try {
                 con.close();
                 
             } catch (SQLException ex) {
                 Logger.getLogger(SealsInfoImplDao.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
         System.out.println("Calling from subquery on Bogra "+todayesTotalSold);
        return todayesTotalSold;
    }
    
    
    
    
}
