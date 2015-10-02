/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.launch.implDao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import ticket.com.connection.DBConnectionHandler;
import ticket.com.launch.pojo.LaunchAvailableSeatOnSearch;
import ticket.com.launch.pojo.Launch_TimeSchedule;

/**
 *
 * @author Emrul
 */
public class LaunchAvailableSeatOnSearchImplDao {

    public List<LaunchAvailableSeatOnSearch> getAllLaunchTimeSheduleOnSearchList(Launch_TimeSchedule obj) {
        List<LaunchAvailableSeatOnSearch> list = new ArrayList<LaunchAvailableSeatOnSearch>();

        String sql = "SELECT launch_info.launch_name,\n"
                + "       launch_time_schedule.dept_time,\n"
                + "       launch_time_schedule.arriv_time,\n"
                + "       launch_time_schedule.depart_from,\n"
                + "       launch_time_schedule.arrive_to,\n"
                + "       launch_available_seat.availableSeat,\n"
                + "       launch_available_seat.seat_names,\n"
                + "       launch_available_seat.per_seat_fair,\n"
                + "       seat_catagory.cata_name,\n"
                + "       seat_type.type_name,\n"
                + "       launch_available_seat.lau_ava_seat_id,\n"
                + "       launch_time_schedule.launch_time_id\n"
                + "  FROM (((ticket.launch_available_seat launch_available_seat\n"
                + "          INNER JOIN ticket.seat_type seat_type\n"
                + "             ON (launch_available_seat.seat_type_id = seat_type.seat_type_id))\n"
                + "         INNER JOIN ticket.launch_time_schedule launch_time_schedule\n"
                + "            ON (launch_available_seat.launch_time_id =\n"
                + "                   launch_time_schedule.launch_time_id))\n"
                + "        INNER JOIN ticket.launch_info launch_info\n"
                + "           ON (launch_time_schedule.launch_id = launch_info.launch_id))\n"
                + "       INNER JOIN ticket.seat_catagory seat_catagory\n"
                + "          ON (launch_available_seat.cata_id = seat_catagory.cata_id)\n"
                + " WHERE (launch_time_schedule.launch_time_id = '" + obj.getLaunchTimeId() + "');";

        try {
            Statement st = DBConnectionHandler.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                LaunchAvailableSeatOnSearch ru = new LaunchAvailableSeatOnSearch();
                ru.setLaunchName(rs.getString("launch_name"));
                ru.setDepartFrom(rs.getString("depart_from"));
                ru.setDeptTime((Time) rs.getTime("dept_time"));
                ru.setArrivTime((Time) rs.getTime("arriv_time"));
                ru.setArriveTo(rs.getString("arrive_to"));
                ru.setAvailableSeat(rs.getInt("availableSeat"));
                ru.setSeatCataName(rs.getString("cata_name"));
                ru.setTypeName(rs.getString("type_name"));
                ru.setSeatName(rs.getString("seat_names"));
                ru.setFair(rs.getDouble("per_seat_fair"));
                ru.setLau_ava_seatID(rs.getInt("lau_ava_seat_id"));

                list.add(ru);

            }
        } catch (Exception e) {
        }
        return list;
    }

}
