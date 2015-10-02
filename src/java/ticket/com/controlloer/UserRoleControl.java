/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.controlloer;

import java.util.List;
import javax.faces.model.SelectItem;
import ticket.com.implDao.UserRoleDaoImpl;
import ticket.com.pojo.UserRole;

/**
 *
 * @author Emrul
 */
public class UserRoleControl {
 private UserRole userRole=new UserRole();
 private UserRoleDaoImpl userRoleDaoImpl=new UserRoleDaoImpl();

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public UserRoleDaoImpl getUserRoleDaoImpl() {
        return userRoleDaoImpl;
    }

    public void setUserRoleDaoImpl(UserRoleDaoImpl userRoleDaoImpl) {
        this.userRoleDaoImpl = userRoleDaoImpl;
    }
    
    public void insert(){
       userRoleDaoImpl.insert(userRole);
    }
      public List<UserRole> getAllUserRole(){
  
  return userRoleDaoImpl.getAllUserRole();
  }  
    
   public void delete(int i){
       
       userRoleDaoImpl.delete(i);
    }  
   
    public List<SelectItem> getUserRoleList(){
          return userRoleDaoImpl.getAllRoleID();
      }
   
   
}
