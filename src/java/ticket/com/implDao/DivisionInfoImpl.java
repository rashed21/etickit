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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import ticket.com.connection.DBConnectionHandler;
import ticket.com.pojo.CompanyInfo;
import ticket.com.pojo.Districtinfo;
import ticket.com.pojo.Divisioninfo;

/**
 *
 * @author Robin Khan
 */
public class DivisionInfoImpl {
    
    
     public boolean saveDivisionInfo(Divisioninfo obj) {
        boolean returnValue = false;
        String sql = "insert into divisioninfo(div_id,div_name) values(?,?)";

        try {
            Connection connection = DBConnectionHandler.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, obj.getDivId());
            ps.setString(2, obj.getDivName());
           

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
     
     
     
     public List<Divisioninfo> getDivisionInfo() {
        List<Divisioninfo> data = new ArrayList<Divisioninfo>();
        String sql = "select * from ticket.divisioninfo;";

        try {
            Statement st = DBConnectionHandler.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                Divisioninfo cinfo = new Divisioninfo();
                
                
                cinfo.setDivId(rs.getInt("div_id"));
                cinfo.setDivName(rs.getString("div_name"));
              
                data.add(cinfo);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
     
     
     
      public List<SelectItem> getDivisionID() {
        List<SelectItem> list = new ArrayList<SelectItem>();

//    Iterator itr = getList().iterator();
        for (Divisioninfo catt : getDivisionInfo()) {
            list.add(new SelectItem(catt.getDivId(), catt.getDivName()));
            //list.add(new SelectItem(catt.getProductId(), catt.getProductName()));
        }

        return list;
    }

   
    
}
