/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.launch.pojo;

import ticket.com.pojo.*;
import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Emrul
 */
public class Launch_TimeSchedule  implements java.io.Serializable {


     private Integer launchTimeId;
     private Integer launchId;
     public String launchName;
     private String departFrom;
     private Date deptTime;
     private Date arrivTime;
     private String arriveTo;    

    public Integer getLaunchTimeId() {
        return launchTimeId;
    }

    public void setLaunchTimeId(Integer launchTimeId) {
        this.launchTimeId = launchTimeId;
    }

    public Integer getLaunchId() {
        return launchId;
    }

    public void setLaunchId(Integer launchId) {
        this.launchId = launchId;
    }

    public String getDepartFrom() {
        return departFrom;
    }

    public void setDepartFrom(String departFrom) {
        this.departFrom = departFrom;
    }

    public Date getDeptTime() {
        return deptTime;
    }

    public void setDeptTime(Date deptTime) {
        this.deptTime = deptTime;
    }

    public Date getArrivTime() {
        return arrivTime;
    }

    public void setArrivTime(Date arrivTime) {
        this.arrivTime = arrivTime;
    }

    public String getArriveTo() {
        return arriveTo;
    }

    public void setArriveTo(String arriveTo) {
        this.arriveTo = arriveTo;
    }

    public String getLaunchName() {
        return launchName;
    }

    public void setLaunchName(String launchName) {
        this.launchName = launchName;
    }
     
     
     
}
