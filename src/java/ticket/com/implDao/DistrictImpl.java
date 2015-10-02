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
import ticket.com.pojo.Districtinfo;
import ticket.com.pojo.Divisioninfo;


/**
 *
 * @author Robin Khan
 */
public class DistrictImpl {
    
    public boolean saveDistrictInfo(Districtinfo obj) {
        boolean returnValue = false;
        String sql = "insert into districtinfo(dis_id,dis_name,div_id) values(?,?,?)";

        try {
            Connection connection = DBConnectionHandler.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, obj.getDisId());
            ps.setString(2, obj.getDisName());
            ps.setInt(3, obj.getDivId());
           

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
    
    
    
    public List<Districtinfo> getDistrictInfo() {
        List<Districtinfo> data = new ArrayList<Districtinfo>();
        String sql = "select * from ticket.districtinfo;";

        try {
            Statement st = DBConnectionHandler.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                Districtinfo cinfo = new Districtinfo();
                
                  cinfo.setDisId(rs.getInt("dis_id"));
                cinfo.setDivId(rs.getInt("div_id"));
                cinfo.setDisName(rs.getString("dis_name"));
              
                data.add(cinfo);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
    
  
    
    
    public List<SelectItem> getDistrictID() {
        List<SelectItem> list = new ArrayList<SelectItem>();

//    Iterator itr = getList().iterator();
        for (Districtinfo catt : getDistrictInfo()) {
            list.add(new SelectItem(catt.getDisId(), catt.getDisName()));
            //list.add(new SelectItem(catt.getProductId(), catt.getProductName()));
        }

        return list;
    }
    
}
