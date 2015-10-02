/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.implDao;



import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import ticket.com.connection.DBConnectionHandler;
import ticket.com.pojo.BusInfo;

/**
 *
 * @author Robin Khan
 */
public class BusInfoImpl implements  Serializable{
    
public boolean insert(BusInfo obj) {
        String sql = "insert into bus_info(bus_name,bus_number,route_id,company_id) values (?,?,?,?)";
        try {
            PreparedStatement ps = DBConnectionHandler.getConnection().prepareStatement(sql);
            ps.setString(1, obj.getBusName());
            ps.setInt(2, obj.getBusNumber());
             ps.setInt(3, obj.getRoute());
              ps.setInt(4, obj.getCompanyInfo());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;

    }
    
    public List<SelectItem> getBusInfoID() {
        List<SelectItem> list = new ArrayList<SelectItem>();
        for (BusInfo catt : getAllBus_type()) {
            
            list.add(new SelectItem(catt.getBusId(), catt.getBusName()));        
       
        }
        return list;
    }
    
    
    
    
    public List<BusInfo> getAllBus_type() {
        List<BusInfo> list = new ArrayList<BusInfo>();
        String sql = "SELECT * FROM bus_info;";
        try {
            Statement st = DBConnectionHandler.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                BusInfo ru = new BusInfo();
                ru.setBusId(rs.getInt("bus_id"));
                ru.setBusName(rs.getString("bus_name"));
                

                list.add(ru);
            }
        } catch (Exception e) {
        }
        return list;
    }

    
}
