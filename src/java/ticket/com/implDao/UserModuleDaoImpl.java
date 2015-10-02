/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.implDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import ticket.com.connection.DBConnectionHandler;
import ticket.com.pojo.UserModule;

/**
 *
 * @author Emrul
 */
public class UserModuleDaoImpl {
    public boolean insert(UserModule obj) {
        String sql = "insert into user_module(module_detail) values (?)";
        try {
            PreparedStatement ps = DBConnectionHandler.getConnection().prepareStatement(sql);
            ps.setString(1, obj.getModuleDetail());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;

    }

       public List<SelectItem> getUserModuleID() {
        List<SelectItem> list = new ArrayList<SelectItem>();
        for (UserModule catt : getAllUserModule()) {
            
            list.add(new SelectItem(catt.getModuleId(), catt.getModuleDetail()));        
       
        }
        return list;
    }
    
    
    
    
    public List<UserModule> getAllUserModule() {
        List<UserModule> list = new ArrayList<UserModule>();
        String sql = "SELECT * FROM user_module;";
        try {
            Statement st = DBConnectionHandler.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                UserModule ru = new UserModule();
                ru.setModuleId(rs.getInt("module_id"));
                ru.setModuleDetail(rs.getString("module_detail"));

                list.add(ru);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public boolean delete(int id) {

        String sql = "DELETE FROM user_module WHERE module_id=?;";
        try {
            PreparedStatement ps = DBConnectionHandler.getConnection().prepareStatement(sql);
            ps.setInt(1, id);

            int i = ps.executeUpdate();
        } catch (SQLException ex) {

        }

        return true;
    }
}
