package ticket.com.pojo;
// Generated May 31, 2015 12:08:42 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Unioninfo generated by hbm2java
 */
public class Unioninfo  implements java.io.Serializable {


     private int upId;
     private Upazilainfo upazilainfo;
     private String upname;
     private int uzid;

    public int getUpId() {
        return upId;
    }

    public void setUpId(int upId) {
        this.upId = upId;
    }

    public int getUzid() {
        return uzid;
    }

    public void setUzid(int uzid) {
        this.uzid = uzid;
    }
     private Set wardinfos = new HashSet(0);

    public Unioninfo() {
    }

    public Unioninfo(Upazilainfo upazilainfo, String upname, Set wardinfos) {
       this.upazilainfo = upazilainfo;
       this.upname = upname;
       this.wardinfos = wardinfos;
    }
   
  
    
 
    public Upazilainfo getUpazilainfo() {
        return this.upazilainfo;
    }
    
    public void setUpazilainfo(Upazilainfo upazilainfo) {
        this.upazilainfo = upazilainfo;
    }
    public String getUpname() {
        return this.upname;
    }
    
    public void setUpname(String upname) {
        this.upname = upname;
    }
    public Set getWardinfos() {
        return this.wardinfos;
    }
    
    public void setWardinfos(Set wardinfos) {
        this.wardinfos = wardinfos;
    }




}


