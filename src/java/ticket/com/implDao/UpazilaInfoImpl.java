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
import ticket.com.pojo.Upazilainfo;

/**
 *
 * @author Robin Khan
 */
public class UpazilaInfoImpl {
    
    
     public boolean saveUpazilaInfo(Upazilainfo obj) {
        boolean returnValue = false;
        String sql = "insert into upazilainfo(uzid,dis_id,uzname) values(?,?,?)";

        try {
            Connection connection = DBConnectionHandler.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, obj.getUzid());
            ps.setInt(2, obj.getDisId());
            ps.setString(3, obj.getUzname());
           

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
    
     
     
     
     
     
      public List<Upazilainfo> getUpazilaInfo() {
        List<Upazilainfo> data = new ArrayList<Upazilainfo>();
        String sql = "select * from ticket.upazilainfo;";

        try {
            Statement st = DBConnectionHandler.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                Upazilainfo cinfo = new Upazilainfo();
                
                  cinfo.setDisId(rs.getInt("dis_id"));
                cinfo.setUzid(rs.getInt("uzid"));
                cinfo.setUzname(rs.getString("uzname"));
              
                data.add(cinfo);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
      
      
      
      
            public List<SelectItem> getUpazilaID() {
        List<SelectItem> list = new ArrayList<SelectItem>();

//    Iterator itr = getList().iterator();
        for (Upazilainfo catt :  getUpazilaInfo()) {
            list.add(new SelectItem(catt.getUzid(), catt.getUzname()));
            //list.add(new SelectItem(catt.getProductId(), catt.getProductName()));
        }

        return list;
    }
    
}
