/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.implDao;

import java.sql.PreparedStatement;
import ticket.com.connection.DBConnectionHandler;
import ticket.com.pojo.VillageInfo;

/**
 *
 * @author Emrul
 */
public class VillageInfoImpDao {
    public boolean insert(VillageInfo obj) {
        String sql = "insert into villageinfo(v_name,wd_id) values (?,?)";
        try {
            PreparedStatement ps = DBConnectionHandler.getConnection().prepareStatement(sql);
            ps.setString(1, obj.getVname());
            ps.setInt(2, obj.getWard());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;

    }
    
   
}
