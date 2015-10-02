/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.launch.controlloer;

import java.util.List;
import javax.faces.model.SelectItem;
import ticket.com.launch.implDao.Launch_CompanyInfoImplDao;
import ticket.com.launch.pojo.Launch_CompanyInfo;



/**
 *
 * @author Robin Khan
 */
public class Launch_CompanyInfoController {
    
    public Launch_CompanyInfo launch_CompanyInfo=new Launch_CompanyInfo();
    
    public Launch_CompanyInfoImplDao companyInfoImpl=new Launch_CompanyInfoImplDao();

    public Launch_CompanyInfoController() {
    }

    public Launch_CompanyInfo getCi() {
        return launch_CompanyInfo;
    }

    public void setCi(Launch_CompanyInfo ci) {
        this.launch_CompanyInfo = ci;
    }

    public Launch_CompanyInfoImplDao getCompanyInfoImpl() {
        return companyInfoImpl;
    }

    public void setCompanyInfoImpl(Launch_CompanyInfoImplDao companyInfoImpl) {
        this.companyInfoImpl = companyInfoImpl;
    }
  
    public void insert(){
    
    companyInfoImpl.saveCompanyIngo(launch_CompanyInfo);
    }
     public List<SelectItem> getAllComanyList(){
          return companyInfoImpl.getCompanyID();
      }   
        
}
