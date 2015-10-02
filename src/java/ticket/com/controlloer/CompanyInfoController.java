/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.controlloer;

import java.util.List;
import javax.faces.model.SelectItem;
import ticket.com.implDao.CompanyInfoImpl;
import ticket.com.pojo.CompanyInfo;



/**
 *
 * @author Robin Khan
 */
public class CompanyInfoController {
    
    public CompanyInfo ci=new CompanyInfo();
    
    public CompanyInfoImpl companyInfoImpl=new CompanyInfoImpl();

    public CompanyInfoController() {
    }

    public CompanyInfo getCi() {
        return ci;
    }

    public void setCi(CompanyInfo ci) {
        this.ci = ci;
    }

    public CompanyInfoImpl getCompanyInfoImpl() {
        return companyInfoImpl;
    }

    public void setCompanyInfoImpl(CompanyInfoImpl companyInfoImpl) {
        this.companyInfoImpl = companyInfoImpl;
    }
    
    
    public void insert(){
    
    companyInfoImpl.saveCompanyIngo(ci);
    }
     public List<SelectItem> getAllComanyList(){
          return companyInfoImpl.getCompanyID();
      }   
       
    
}
