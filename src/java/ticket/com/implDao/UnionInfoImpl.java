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
import ticket.com.pojo.Districtinfo;
import ticket.com.pojo.Unioninfo;

/**
 *
 * @author Robin Khan
 */
public class UnionInfoImpl {
    
    public boolean saveUnionInfo(Unioninfo obj) {
        boolean returnValue = false;
        String sql = "insert into unioninfo(up_id,uzid,upname) values(?,?,?)";

        try {
            Connection connection = DBConnectionHandler.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, obj.getUpId());
           
            ps.setInt(2, obj.getUzid());
             ps.setString(3, obj.getUpname());
           

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
    
    
    
    
    
      public List<Unioninfo> getUnionInfo() {
        List<Unioninfo> data = new ArrayList<Unioninfo>();
        String sql = "select * from ticket.unioninfo;";

        try {
            Statement st = DBConnectionHandler.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                Unioninfo cinfo = new Unioninfo();
                
                  cinfo.setUpId(rs.getInt("up_id"));
                cinfo.setUzid(rs.getInt("uzid"));
                cinfo.setUpname(rs.getString("upname"));
              
                data.add(cinfo);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
    
      
      
      
      
      
      
          public List<SelectItem> getUnionID() {
        List<SelectItem> list = new ArrayList<SelectItem>();

//    Iterator itr = getList().iterator();
        for (Unioninfo catt : getUnionInfo()) {
            list.add(new SelectItem(catt.getUpId(), catt.getUpname()));
            //list.add(new SelectItem(catt.getProductId(), catt.getProductName()));
        }

        return list;
    }
    
}
