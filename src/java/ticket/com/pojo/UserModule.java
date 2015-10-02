/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.pojo;

/**
 *
 * @author Emrul
 */
public class UserModule  implements java.io.Serializable {


     private Integer moduleId;
     private String moduleDetail;

     
    public UserModule() {
    }

    
    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleDetail() {
        return moduleDetail;
    }

    public void setModuleDetail(String moduleDetail) {
        this.moduleDetail = moduleDetail;
    }
     
     
}
