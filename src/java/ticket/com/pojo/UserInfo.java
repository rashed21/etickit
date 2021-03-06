/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.pojo;

import java.util.Date;

/**
 *
 * @author Emrul
 */
public class UserInfo  implements java.io.Serializable {


     private Integer userId;
     private Integer userRole;
     private String uname;
     private String pass;
     private String mobileNo;
     private String secQuestion;
     private String secAnswer;
     private Date regDate;
     private String isactivea;
    private Integer userRoleId;
    private Integer addressId;
    private String name;
    private String email;
    private String presentAddress;
    private String gender;
    

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

  
    
    public UserInfo() {
    }

    public UserInfo(Integer userId, Integer userRole, String uname, String pass, String mobileNo, String secQuestion, String secAnswer, Date regDate, String isactivea, Integer userRoleId, Integer addressId, String name, String email, String presentAddress, String gender) {
        this.userId = userId;
        this.userRole = userRole;
        this.uname = uname;
        this.pass = pass;
        this.mobileNo = mobileNo;
        this.secQuestion = secQuestion;
        this.secAnswer = secAnswer;
        this.regDate = regDate;
        this.isactivea = isactivea;
        this.userRoleId = userRoleId;
        this.addressId = addressId;
        this.name = name;
        this.email = email;
        this.presentAddress = presentAddress;
        this.gender = gender;
    }

  

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

 

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
   
    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public int getUserRole() {
        return this.userRole;
    }
    
    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }
    public String getUname() {
        return this.uname;
    }
    
    public void setUname(String uname) {
        this.uname = uname;
    }
    public String getPass() {
        return this.pass;
    }
    
    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getMobileNo() {
        return this.mobileNo;
    }
    
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
    public String getSecQuestion() {
        return this.secQuestion;
    }
    
    public void setSecQuestion(String secQuestion) {
        this.secQuestion = secQuestion;
    }
    public String getSecAnswer() {
        return this.secAnswer;
    }
    
    public void setSecAnswer(String secAnswer) {
        this.secAnswer = secAnswer;
    }
    public Date getRegDate() {
        return this.regDate;
    }
    
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
    public String getIsactivea() {
        return this.isactivea;
    }
    
    public void setIsactivea(String isactivea) {
        this.isactivea = isactivea;
    }




}


