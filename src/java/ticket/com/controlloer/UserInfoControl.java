/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.controlloer;

import ticket.com.implDao.UserInfoImplDao;
import ticket.com.implDao.UserRoleDaoImpl;
import ticket.com.pojo.UserInfo;
import ticket.com.pojo.UserRole;

/**
 *
 * @author Emrul
 */
public class UserInfoControl {
private UserInfoImplDao userInfoImplDao=new UserInfoImplDao();
private UserInfo userInfo=new UserInfo();
private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public UserInfoImplDao getUserInfoImplDao() {
        return userInfoImplDao;
    }

    public void setUserInfoImplDao(UserInfoImplDao userInfoImplDao) {
        this.userInfoImplDao = userInfoImplDao;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
 
   public void insert(){
       userInfoImplDao.insert(userInfo);
   } 
   
 public String nameCheck(){ 
     System.out.println("Founction is calling.................."+userInfo.getUname());
    msg= userInfoImplDao.UserNamecheck(userInfo);
     return msg;
 }
   
   
}
