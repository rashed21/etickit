/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.implDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import ticket.com.connection.DBConnectionHandler;
import ticket.com.pojo.Upazilainfo;
import ticket.com.pojo.Wardinfo;

/**
 *
 * @author Robin Khan
 */
public class WardInfoImpl {
    
     public boolean saveWardInfo(Wardinfo obj) {
        boolean returnValue = false;
        String sql = "insert into wardinfo(wd_id,up_id,wdName) values(?,?,?)";

        try {
            Connection connection = DBConnectionHandler.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, obj.getWdId());
            ps.setInt(2, obj.getUpId());
            ps.setString(3, obj.getWdName());
           

            int i = ps.executeUpdate();

            if (i > 0) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Information", "New User add Successfully");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                returnValue = true;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return returnValue;

    }
     
     
     
     
     
      public List<Wardinfo> getWardInfo() {
        List<Wardinfo> data = new ArrayList<Wardinfo>();
        String sql = "select * from ticket.wardinfo;";

        try {
            Statement st = DBConnectionHandler.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                Wardinfo cinfo = new Wardinfo();
                
                  cinfo.setUpId(rs.getInt("up_id"));
                cinfo.setWdId(rs.getInt("wd_id"));
                cinfo.setWdName(rs.getString("wdName"));
              
                data.add(cinfo);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
      
      
      
               public List<SelectItem> getWardID() {
        List<SelectItem> list = new ArrayList<SelectItem>();

//    Iterator itr = getList().iterator();
        for (Wardinfo catt :  getWardInfo()) {
            list.add(new SelectItem(catt.getWdId(), catt.getWdName()));
            //list.add(new SelectItem(catt.getProductId(), catt.getProductName()));
        }

        return list;
    }
    
}
