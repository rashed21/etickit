/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.controlloer;

import ticket.com.implDao.UserAccessModuleImplDao;
import ticket.com.pojo.UserAccessModule;

/**
 *
 * @author Emrul
 */
public class UserAccessModuleControl {
    
   private UserAccessModuleImplDao accessModuleImplDao=new UserAccessModuleImplDao();
   private UserAccessModule userAccessModule=new UserAccessModule();

    public UserAccessModuleImplDao getAccessModuleImplDao() {
        return accessModuleImplDao;
    }

    public void setAccessModuleImplDao(UserAccessModuleImplDao accessModuleImplDao) {
        this.accessModuleImplDao = accessModuleImplDao;
    }

    public UserAccessModule getUserAccessModule() {
        return userAccessModule;
    }

    public void setUserAccessModule(UserAccessModule userAccessModule) {
        this.userAccessModule = userAccessModule;
    }
   
    public void insert(){
        accessModuleImplDao.insert(userAccessModule);
    }
    
}
