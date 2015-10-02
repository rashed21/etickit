/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.implDao;

import java.sql.PreparedStatement;
import ticket.com.connection.DBConnectionHandler;
import ticket.com.pojo.UserAccessModule;

/**
 *
 * @author Emrul
 */
public class UserAccessModuleImplDao {
    
     public boolean insert(UserAccessModule obj) {
        String sql = "insert into user_access_module(module_id,role_id) values (?,?)";
        try {
            PreparedStatement ps = DBConnectionHandler.getConnection().prepareStatement(sql);
            ps.setInt(1, obj.getUserModule());
            ps.setInt(2, obj.getUserRole());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;

    }
}
