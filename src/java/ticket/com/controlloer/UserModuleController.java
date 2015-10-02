/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.controlloer;

import java.util.List;
import javax.faces.model.SelectItem;
import ticket.com.implDao.UserModuleDaoImpl;
import ticket.com.pojo.UserModule;

/**
 *
 * @author Emrul
 */
public class UserModuleController {
    private UserModule userModule=new UserModule();
    private UserModuleDaoImpl userModuleDaoImpl=new UserModuleDaoImpl();

    public UserModule getUserModule() {
        return userModule;
    }

    public void setUserModule(UserModule userModule) {
        this.userModule = userModule;
    }

    public UserModuleDaoImpl getUserModuleDaoImpl() {
        return userModuleDaoImpl;
    }

    public void setUserModuleDaoImpl(UserModuleDaoImpl userModuleDaoImpl) {
        this.userModuleDaoImpl = userModuleDaoImpl;
    }
    
   public void insert(){
       userModuleDaoImpl.insert(userModule);
   } 
    
    public List<UserModule> getAllUserModule() {

        return userModuleDaoImpl.getAllUserModule();
    }

    public void delete(int i) {
        userModuleDaoImpl.delete(i);
    } 
   public List<SelectItem> getAllModuleList(){
       return userModuleDaoImpl.getUserModuleID();
   }
}
