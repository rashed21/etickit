/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.launch.implDao;


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
import ticket.com.launch.pojo.Launch_CompanyInfo;


/**
 *
 * @author Robin Khan
 */
public class Launch_CompanyInfoImplDao implements Serializable {

    public boolean saveCompanyIngo(Launch_CompanyInfo obj) {
        boolean returnValue = false;
        String sql = "insert into launch_company_info(company_name,head_office,contact_person,contact_no)values(?,?,?,?)";

        try {
            Connection connection = DBConnectionHandler.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);

            
            ps.setString(1, obj.getCompanyName());
            
            ps.setString(2, obj.getHeadOffice());
            ps.setString(3, obj.getContactPerson());
            ps.setString(4, obj.getContactNo());

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
        for (Launch_CompanyInfo catt : getCompanyinfo()) {
            list.add(new SelectItem(catt.getCompanyId(), catt.getCompanyName()));        
        }
        return list;
    }
    
    public List<Launch_CompanyInfo> getCompanyinfo() {
        List<Launch_CompanyInfo> data = new ArrayList<Launch_CompanyInfo>();
        String sql = "select * from ticket.launch_company_info;";

        try {
            Statement st = DBConnectionHandler.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                Launch_CompanyInfo cinfo = new Launch_CompanyInfo();
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
