/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.controlloer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import ticket.com.implDao.BusTimeScheduleDaoImpl;
import ticket.com.implDao.SealsInfoImplDao;
import ticket.com.pojo.BusTimeSchedule;

import ticket.com.pojo.SealsInfo;

import ticket.com.pojo.TotalSeat;

/**
 *
 * @author Emrul
 */
public class SealsControl {

    private TotalSeat totalSeat1 = new TotalSeat();
    private SealsInfoImplDao sealsInfoImplDao = new SealsInfoImplDao();
    private SealsInfo sealsInfo = new SealsInfo();
    private BusTimeSchedule busTimeSchedule = new BusTimeSchedule();
    private BusTimeScheduleDaoImpl timeScheduleDaoImpl = new BusTimeScheduleDaoImpl();

    String selectedSeats, soldedSeat;
    double totalvalue;

    public double getTotalvalue() {
        return totalvalue;
    }

    public void setTotalvalue(double totalvalue) {
        this.totalvalue = totalvalue;
    }

    public TotalSeat getTotalSeat1() {
        return totalSeat1;
    }

    public void setTotalSeat1(TotalSeat totalSeat1) {
        this.totalSeat1 = totalSeat1;
    }

    public BusTimeSchedule getBusTimeSchedule() {
        return busTimeSchedule;
    }

    public void setBusTimeSchedule(BusTimeSchedule busTimeSchedule) {
        this.busTimeSchedule = busTimeSchedule;
    }

    public BusTimeScheduleDaoImpl getTimeScheduleDaoImpl() {
        return timeScheduleDaoImpl;
    }

    public void setTimeScheduleDaoImpl(BusTimeScheduleDaoImpl timeScheduleDaoImpl) {
        this.timeScheduleDaoImpl = timeScheduleDaoImpl;
    }

    public SealsInfoImplDao getSealsInfoImplDao() {
        return sealsInfoImplDao;
    }

    public void setSealsInfoImplDao(SealsInfoImplDao sealsInfoImplDao) {
        this.sealsInfoImplDao = sealsInfoImplDao;
    }

    public SealsInfo getSealsInfo() {
        return sealsInfo;
    }

    public void setSealsInfo(SealsInfo sealsInfo) {
        this.sealsInfo = sealsInfo;
    }

    public void getTimeSheduleById() {
        busTimeSchedule = timeScheduleDaoImpl.getAvailableSeatsForSeal(busTimeSchedule);
    }

    int totalSeat;

    public void init() {
        totalSeat = busTimeSchedule.getTotSeatNo() / 4;
        String seat[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        for (int i = 0; i < totalSeat; i++) {
            TotalSeat sname = new TotalSeat();
            for (int j = 1; j < 5; j++) {

                if (j == 1) {
                    String b = check(seat[i] + j);
                    if (b == null) {
                        sname.setFirst("");
                    } else {
                        sname.setFirst(b);
                    }
                } else if (j == 2) {
                    String b = check(seat[i] + j);
                    if (b == null) {
                        sname.setSecond("");
                    } else {
                        sname.setSecond(b);
                    }
                } else if (j == 3) {
                    String b = check(seat[i] + j);
                    if (b == null) {
                        sname.setThird("");
                    } else {
                        sname.setThird(b);
                    }
                } else {
                    String b = check(seat[i] + j);
                    if (b == null) {
                        sname.setFourth("");
                    } else {
                        sname.setFourth(b);
                    }
                }
            }

            seatlist.add(sname);
        }
    }

    List<TotalSeat> seatlist = new ArrayList<TotalSeat>();

    public List<TotalSeat> getTotalSeatName() {
        seatlist.clear();
        getTimeSheduleById();
        init();
        return seatlist;
    }

    public String check(String a) {

        String r = null;
        ArrayList<String> splitsplit = new ArrayList(Arrays.asList(busTimeSchedule.getAvailableSeat().split("\\s*,\\s*")));
        soldTicket();     
        ArrayList<String> unsoldSeat = new ArrayList();

        if (soldedSeat != null) {
 ArrayList<String> solded = new ArrayList(Arrays.asList(soldedSeat.split("\\s*,\\s*")));
            for (int i = 0; i < splitsplit.size(); i++) {

                if (!solded.contains(splitsplit.get(i))) {

                    unsoldSeat.add(splitsplit.get(i));
                }
            }

            for (String splitsplitcheck : unsoldSeat) {
                if (a.equals(splitsplitcheck)) {
                    r = a;
                    break;
                }
            }
            return r;
        } else {
            for (String splitsplitcheck : splitsplit) {
                if (a.equals(splitsplitcheck)) {
                    r = a;
                    break;
                }
            }
            return r;
        }
    }

    List<SealsInfo> selectedSeatlist = new ArrayList<SealsInfo>();

    public List<SealsInfo> getsSelectedSeatList() {
        selectedSeatlist.clear();
      //  totalvalue=0;
        SealsInfo st = new SealsInfo();
        st.setSelectedSeat(selectedSeats);
        st.setPrice(busTimeSchedule.getValue());
        selectedSeatlist.add(st);

        return selectedSeatlist;
    }

    public void allSetectedSeat() {
        if(sealsInfo.getSelectedSeat()!=""){
         if (selectedSeats == null) {
             totalvalue+=busTimeSchedule.getValue();
            selectedSeats = sealsInfo.getSelectedSeat();
        } else {
             totalvalue+=busTimeSchedule.getValue();
            selectedSeats += "," + sealsInfo.getSelectedSeat();
        }   
        }
        
    }

    public String sealsSeat() {
        
        sealsInfo.setSelectedSeat(selectedSeats);
        selectedSeats = null;
        sealsInfo.setTimeSheduleId(busTimeSchedule.getBusTimeId());
        sealsInfo.setPrice((int) totalvalue);       
        sealsInfoImplDao.insert(sealsInfo);
         totalvalue=0;
        return "SelectForSeal";
    }

//Searching sold ticket on the date and bus id 
    public void soldTicket() {
        soldedSeat=null;
        try {
            sealsInfo.setTimeSheduleId(busTimeSchedule.getBusTimeId());
            soldedSeat = sealsInfoImplDao.getAvailableSeatsForSeal(sealsInfo);
            System.out.println("Solded seaat " + soldedSeat);
        } catch (Exception e) {
            System.out.println("Solded Ticket" + e);
        }

    }

}
