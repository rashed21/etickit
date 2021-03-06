/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.launch.pojo;

/**
 *
 * @author Robin Khan
 */


import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import ticket.com.connection.DBConnectionHandler;

/**
 * CompanyInfo generated by hbm2java
 */
public class Launch_CompanyInfo  implements java.io.Serializable {


     private int companyId;
     private String companyName;
     private String headOffice;
     private String contactPerson;
     private String contactNo;
    
     private Set busInfos = new HashSet(0);

    public Launch_CompanyInfo() {
    }

	
    public Launch_CompanyInfo(int companyId, String companyName, String headOffice, String contactPerson, String contactNo) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.headOffice = headOffice;
        this.contactPerson = contactPerson;
        this.contactNo = contactNo;
    }
    public Launch_CompanyInfo(int companyId, String companyName, String headOffice, String contactPerson, String contactNo, Set busInfos) {
       this.companyId = companyId;
       this.companyName = companyName;
       this.headOffice = headOffice;
       this.contactPerson = contactPerson;
       this.contactNo = contactNo;
       this.busInfos = busInfos;
    }
   
    public int getCompanyId() {
        return this.companyId;
    }
    
    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
    public String getCompanyName() {
        return this.companyName;
    }
    
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getHeadOffice() {
        return this.headOffice;
    }
    
    public void setHeadOffice(String headOffice) {
        this.headOffice = headOffice;
    }
    public String getContactPerson() {
        return this.contactPerson;
    }
    
    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }
    public String getContactNo() {
        return this.contactNo;
    }
    
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
    public Set getBusInfos() {
        return this.busInfos;
    }
    
    public void setBusInfos(Set busInfos) {
        this.busInfos = busInfos;
    }


//      public boolean saveRegistrationInfo() {
//    boolean returnValue = false;
//    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//    String d1 = df.format(this.getRegistrationDate());
//
//    String sql = "insert into sch_std_registration (std_id, acyid, section_id, group_id, reg_date, std_roll_no) values(?,?,?,?,?,?)";
//    try {
//      Connection con = DBConnect.getConnection();
//      PreparedStatement ps = con.prepareStatement(sql);
//      ps.setInt(1, this.getStudentId());
//      ps.setInt(2, this.getAcademicYearId());
//      ps.setInt(3, this.getSectionId());
//      ps.setInt(4, this.getGroupId());
//      ps.setString(5, d1);
//      ps.setInt(6, this.getStudentRollNo());
//      int i = ps.executeUpdate();
//      if (i > 0) {
//        returnValue = true;
//      }
//    } catch (SQLException e) {
//      e.printStackTrace();
//    }
//    return returnValue;
//  }
    
    
//    public boolean saveCompanyIngo(){
//    boolean returnValue = false;
//    String sql="insert into company_info(company_id,company_name,head_office,contact_person,contact_no)values(?,?,?,?,?)";
//    
//        try {
//            Connection connection=DBConnect.getConnection();
//            PreparedStatement ps=connection.prepareStatement(sql);
//            
//            ps.setInt(1, this.getCompanyId());
//            ps.setString(2, this.getCompanyName());
//            ps.setString(3, this.getContactPerson());
//            ps.setString(4, this.getHeadOffice());
//            ps.setString(5, this.getContactNo());
//            
//            int i=ps.executeUpdate();
//            
//            if (i>0) {
//                
//                returnValue= true;
//                
//            }
//            
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    
//        return returnValue;
//    
//    }

    
//    
//      public List<SubjectBean> getAllSubjectName() {
//    List<SubjectBean> data = new ArrayList<SubjectBean>();
//    String sql = "select * from school.sch_subject;";
//    try {
//      Statement st = DBConnect.getConnection().createStatement();
//      ResultSet rs = st.executeQuery(sql);
//      while (rs.next()) {
//        SubjectBean cb = new SubjectBean();
//        cb.setSubjectCode(rs.getInt("subject_code"));
//        cb.setSubjectName(rs.getString("subject_name"));
//        data.add(cb);
//      }
//    } catch (SQLException ex) {
//      Logger.getLogger(SubjectBean.class.getName()).log(Level.SEVERE, null, ex);
//    }
//    return data;
//  }

    
    
    public List<Launch_CompanyInfo> getCompanyinfo(){
    List<Launch_CompanyInfo> data =new ArrayList<Launch_CompanyInfo>();
    String sql="select * from ticket.company_info;";
    
        try {
            Statement st=DBConnectionHandler.getConnection().createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
            
                Launch_CompanyInfo cinfo=new Launch_CompanyInfo();
                cinfo.setCompanyId(rs.getInt("company_id"));
                cinfo.setCompanyName(rs.getString("company_name"));
                cinfo.setContactPerson(rs.getString("contact_person"));
                cinfo.setHeadOffice(rs.getString("head_office"));
                cinfo.setContactNo(rs.getString("contact_no"));
                data.add(cinfo);
            
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return data;
    }
}
