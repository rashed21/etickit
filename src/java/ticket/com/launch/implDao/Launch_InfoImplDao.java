/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.launch.implDao;



import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import ticket.com.connection.DBConnectionHandler;
import ticket.com.launch.pojo.Launch_Info;


/**
 *
 * @author Robin Khan
 */
public class Launch_InfoImplDao implements  Serializable{
    
public boolean insert(Launch_Info obj) {
        String sql = "insert into launch_info(launch_name,launch_number,route_id,company_id) values (?,?,?,?)";
        try {
            PreparedStatement ps = DBConnectionHandler.getConnection().prepareStatement(sql);
            ps.setString(1, obj.getLaunchName());
            ps.setInt(2, obj.getLaunchNumber());
             ps.setInt(3, obj.getRouteId());
              ps.setInt(4, obj.getCompanyId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;

    }
    
    public List<SelectItem> getLaunchInfoID() {
        List<SelectItem> list = new ArrayList<SelectItem>();
        for (Launch_Info catt : getAllLaunchName()) {
            
            list.add(new SelectItem(catt.getLaunchId(), catt.getLaunchName()));        
       
        }
        return list;
    }
    
    
    
    
    public List<Launch_Info> getAllLaunchName() {
        List<Launch_Info> list = new ArrayList<Launch_Info>();
        String sql = "SELECT * FROM launch_info;";
        try {
            Statement st = DBConnectionHandler.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Launch_Info ru = new Launch_Info();
                ru.setLaunchId(rs.getInt("launch_id"));
                ru.setLaunchName(rs.getString("launch_name"));
                

                list.add(ru);
            }
        } catch (Exception e) {
        }
        return list;
    }

    
}
