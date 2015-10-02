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

/**
 *
 * @author Robin Khan
 */
public class CompanyInfoImpl implements Serializable {

    public boolean saveCompanyIngo(CompanyInfo obj) {
        boolean returnValue = false;
        String sql = "insert into company_info(company_id,company_name,head_office,contact_person,contact_no)values(?,?,?,?,?)";

        try {
            Connection connection = DBConnectionHandler.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, obj.getCompanyId());
            ps.setString(2, obj.getCompanyName());
            
            ps.setString(3, obj.getHeadOffice());
            ps.setString(4, obj.getContactPerson());
            ps.setString(5, obj.getContactNo());

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

    public List<SelectItem> getCompanyID() {
        List<SelectItem> list = new ArrayList<SelectItem>();
        for (CompanyInfo catt : getCompanyinfo()) {
            list.add(new SelectItem(catt.getCompanyId(), catt.getCompanyName()));        
        }
        return list;
    }
    
    public List<CompanyInfo> getCompanyinfo() {
        List<CompanyInfo> data = new ArrayList<CompanyInfo>();
        String sql = "select * from ticket.company_info;";

        try {
            Statement st = DBConnectionHandler.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                CompanyInfo cinfo = new CompanyInfo();
                cinfo.setCompanyId(rs.getInt("company_id"));
                cinfo.setCompanyName(rs.getString("company_name"));
                cinfo.setContactPerson(rs.getString("contact_person"));
                cinfo.setHeadOffice(rs.getString("head_office"));
                cinfo.setContactNo(rs.getString("contact_no"));
                data.add(cinfo);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

        
    

    
   

}
