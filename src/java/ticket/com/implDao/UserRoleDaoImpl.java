/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.implDao;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.model.SelectItem;
import ticket.com.connection.DBConnectionHandler;
import ticket.com.pojo.UserRole;

/**
 *
 * @author Emrul
 */
public class UserRoleDaoImpl implements Serializable{
    
     public boolean insert(UserRole obj) {
        String sql = "insert into user_role(role_name) values (?)";
        try {
            PreparedStatement ps = DBConnectionHandler.getConnection().prepareStatement(sql);
            ps.setString(1, obj.getRoleName());
           

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                DBConnectionHandler.getConnection().close();
            } catch (SQLException ex) {
                Logger.getLogger(UserRoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

        return true;

    }
    
    public boolean delete(int id) {
       
          String sql = "DELETE FROM user_role WHERE role_id=?;";
   
    try {
      PreparedStatement ps = DBConnectionHandler.getConnection().prepareStatement(sql);
      ps.setInt(1, id);
     
      int i = ps.executeUpdate();
    } catch (SQLException ex) {
     
    }  finally{
              try {
                  DBConnectionHandler.getConnection().close();
              } catch (SQLException ex) {
                  Logger.getLogger(UserRoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
              }
    }
        
      return true;
     }
    
    
       public List<SelectItem> getAllRoleID() {
        List<SelectItem> list = new ArrayList<SelectItem>();


        for (UserRole catt : getAllUserRole()) {
            list.add(new SelectItem(catt.getRoleId(), catt.getRoleName()));
          
        }

        return list;
    }
    
    
    
    
    
    
    public List<UserRole> getAllUserRole(){
  List<UserRole> list = new ArrayList<UserRole>();
  String sql = "SELECT * FROM user_role;";
  try {
      Statement st = DBConnectionHandler.getConnection().createStatement();
      ResultSet rs = st.executeQuery(sql);
      while (rs.next()) {
        UserRole ru = new UserRole();
        ru.setRoleId(rs.getInt("role_id"));
        ru.setRoleName(rs.getString("role_name"));
       
        list.add(ru);
      }
    } catch (Exception e) {
    } finally{
      try {
          DBConnectionHandler.getConnection().close();
      } catch (SQLException ex) {
          Logger.getLogger(UserRoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  return list;
  }
    
 
    

      
    
    
}
