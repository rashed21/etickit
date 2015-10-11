/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.implDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import ticket.com.connection.DBConnectionHandler;
import ticket.com.pojo.UserInfo;

/**
 *
 * @author Emrul
 */
public class UserInfoImplDao {

    java.sql.Date Date = null;

    Date date = new Date();

    public boolean insert(UserInfo obj) {
        String sql = "insert into user_info(uname,pass,mobile_no,sec_question,sec_answer,reg_date,role_id) values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = DBConnectionHandler.getConnection().prepareStatement(sql);
            ps.setString(1, obj.getUname());
            ps.setString(2, obj.getPass());
            ps.setString(3, obj.getMobileNo());
            ps.setString(4, obj.getSecQuestion());
            ps.setString(5, obj.getSecAnswer());

            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

            ps.setString(6, "" + format.format(new Date()));

            ps.setInt(7, obj.getUserRoleId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;

    }

    public boolean register(UserInfo obj) {
        String sql = "insert into user_info(uname,pass,mobile_no,address,p_address,reg_date,email,name,gender) values (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = DBConnectionHandler.getConnection().prepareStatement(sql);
            ps.setString(1, obj.getUname());
            ps.setString(2, obj.getPass());
            ps.setString(3, obj.getMobileNo());
            ps.setInt(4, obj.getAddressId());
            ps.setString(5, obj.getPresentAddress());

            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

            ps.setString(6, "" + format.format(new Date()));

            ps.setString(7, obj.getEmail());
            ps.setString(8, obj.getName());

            ps.setString(9, obj.getGender());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;

    }

    public boolean delete(int id) {

        String sql = "DELETE FROM user_info WHERE user_id=?;";

        try {
            PreparedStatement ps = DBConnectionHandler.getConnection().prepareStatement(sql);
            ps.setInt(1, id);

            int i = ps.executeUpdate();
        } catch (SQLException ex) {

        }

        return true;
    }

    public List<UserInfo> getAllUserRole() {
        List<UserInfo> list = new ArrayList<UserInfo>();
        String sql = "SELECT * FROM user_info;";
        try {
            Statement st = DBConnectionHandler.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                UserInfo ru = new UserInfo();
                ru.setIsactivea(rs.getString("isactivea"));
                ru.setMobileNo(rs.getString("mobile_no"));
                ru.setPass(rs.getString("pass"));
                ru.setRegDate(rs.getDate("reg_date"));
                ru.setSecAnswer(rs.getString("sec_answer"));
                ru.setSecQuestion(rs.getString("sec_question"));
                ru.setUname(rs.getString("uname"));
                ru.setUserId(rs.getInt("user_id"));
                ru.setUserRole(rs.getInt("role_id"));

                list.add(ru);
            }
        } catch (Exception e) {
        }
        return list;
    }

    //user name check for unique
    public String UserNamecheck(UserInfo userInfo) {

        String msg = null;
        String sql = "SELECT * FROM user_info where uname='" + userInfo.getUname() + "';";
        try {
            Statement st = DBConnectionHandler.getConnection().createStatement();
            System.out.println("Before if");
            ResultSet rs = st.executeQuery(sql);

            if (rs.relative(1)) {
                msg = "User Name already exist";
            } else {
                msg = "";

            }

        } catch (Exception e) {
        }
        return msg;
    }

    public String userLogin(String name, String pass) {

        String msg = null;
        String sql = "SELECT * FROM user_info where uname='" + name + "' and pass='" + pass + "';";
        try {

            System.out.println(name + "    " + pass);

            Statement st = DBConnectionHandler.getConnection().createStatement();
            System.out.println("Before if");
            ResultSet rs = st.executeQuery(sql);

            if (rs.relative(1)) {
                msg = "Congratulation " + name;
            } else {
                msg = "Please input correct";

            }

        } catch (Exception e) {
        }
        return msg;
    }

}
