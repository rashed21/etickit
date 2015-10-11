/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.controlloer;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;
import ticket.com.implDao.BusTimeScheduleDaoImpl;
import ticket.com.pojo.BusTimeSchedule;
import ticket.com.pojo.TotalSeat;

/**
 *
 * @author Emrul
 */
public class BusTimeScheduleControl {

    private BusTimeScheduleDaoImpl timeScheduleDaoImpl = new BusTimeScheduleDaoImpl();
    private BusTimeSchedule busTimeSchedule = new BusTimeSchedule();
    int totalSeat;
    private TotalSeat totalSeat1 = new TotalSeat();
    
    
    String []a, b, c;

    public String[] getA() {
        return a;
    }

    public void setA(String[] a) {
        this.a = a;
    }

    public String[] getB() {
        return b;
    }

    public void setB(String[] b) {
        this.b = b;
    }

    public String[] getC() {
        return c;
    }

    public void setC(String[] c) {
        this.c = c;
    }

    

    public TotalSeat getTotalSeat1() {
        return totalSeat1;
    }

    public void setTotalSeat1(TotalSeat totalSeat1) {
        this.totalSeat1 = totalSeat1;
    }

    public BusTimeScheduleDaoImpl getTimeScheduleDaoImpl() {
        return timeScheduleDaoImpl;
    }

    public void setTimeScheduleDaoImpl(BusTimeScheduleDaoImpl timeScheduleDaoImpl) {
        this.timeScheduleDaoImpl = timeScheduleDaoImpl;
    }

    public BusTimeSchedule getBusTimeSchedule() {
        return busTimeSchedule;
    }

    public void setBusTimeSchedule(BusTimeSchedule busTimeSchedule) {
        this.busTimeSchedule = busTimeSchedule;
    }
    String allseat = "";

 

    public void delete(int i) {
        timeScheduleDaoImpl.delete(i);

    }

    public void test() {
        totalSeat = busTimeSchedule.getTotSeatNo() / 4;
        System.out.println("Total Seat is print here " + busTimeSchedule.getTotSeatNo());
        System.out.println("Loop value" + totalSeat);
        init();
    }
public String call(){
    return "viewSeatsOnSearch.xhtml";
}
    
    
    
    
    
    public List<BusTimeSchedule> getAllBusTimeShedule() {

        return timeScheduleDaoImpl.getAllBusTimeShedule();
    }

    
     public List<BusTimeSchedule> getAvailableSeatsBus() {
         System.out.println("Searching for available seats................on..." +busTimeSchedule.getArriveTo());
        return timeScheduleDaoImpl.getAvailableSeatsBus(busTimeSchedule);
    }
    
    
    
   public List<SelectItem> getAllBusTimeSheduleList() {

        return timeScheduleDaoImpl.getBusTimeSdeduleList();
    }
    
    
    
    
    
//Daynamicaly seat generate ocoading goes here
    List<TotalSeat> seatlist = new ArrayList<TotalSeat>();

    public List<TotalSeat> getTotalSeatName() {
        return seatlist;
    }

    
    
    
    
//    private String[] selectedSeats;
//    private List<String> seats = new ArrayList<String>();
//    @PostConstruct
//    public void init() {
//
//        String seat[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
//        for (int i = 0; i < totalSeat; i++) {
//            TotalSeat sname = new TotalSeat();
//            for (int j = 1; j < 5; j++) {
//                seats.add(seat[i] + j);
//                if (j == 1) {
//                    sname.setFirst(seat[i] + j);
//                } else if (j == 2) {
//                    sname.setSecond(seat[i] + j);
//                } else if (j == 3) {
//                    sname.setThird(seat[i] + j);
//                } else {
//                    sname.setFourth(seat[i] + j);
//                }
//
//            }
//            seatlist.add(sname);
//
//        }
//
//    }

    private String[] selectedSeats;
    private List<String> seats = new ArrayList<String>();
   @PostConstruct
    public void init() {

        String seat[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        for (int i = 0; i < 10; i++) {
            TotalSeat sname = new TotalSeat();
            for (int j = 1; j < 5; j++) {
                seats.add(seat[i] + j);
                if (j == 1) {
                    sname.setFirst(seat[i] + j);
                } else if (j == 2) {
                    sname.setSecond(seat[i] + j);
                } else if (j == 3) {
                    sname.setThird(seat[i] + j);
                } else {
                    sname.setFourth(seat[i] + j);
                }
            }
            seatlist.add(sname);
        }
    }
    
    
        List<TotalSeat> allotedSeat = new ArrayList<TotalSeat>();

    public List<TotalSeat> getTotalSeatWtihAlloted() {
         for (int i = 0; i < 10; i++) {
           for (int j = 1; j < 5; j++) {
              for(String s:  seats){
        TotalSeat tot=seatlist.get(j);
        TotalSeat AddToalloted = new TotalSeat();
        
           if (j == 1) {
                     if(s.equalsIgnoreCase(tot.getFirst())){
                    AddToalloted.setFirst("Sold");
                }else{
                     AddToalloted.setFirst(tot.getFirst());
                }
                } else if (j == 2) {
                    if(s.equalsIgnoreCase(tot.getSecond())){
                    AddToalloted.setSecond("Sold");
                }else{
                     AddToalloted.setSecond(tot.getSecond());
                }
                } else if (j == 3) {
                     if(s.equalsIgnoreCase(tot.getThird())){
                    AddToalloted.setThird("Sold");
                }else{
                     AddToalloted.setThird(tot.getThird());
                }
                } else {
                     if(s.equalsIgnoreCase(tot.getFourth())){
                    AddToalloted.setFourth("Sold");
                }else{
                     AddToalloted.setFourth(tot.getFourth());
                }
                }
               
        
        
             }
            }  
             
         }
             
      
        return allotedSeat;
    }

    
    
    
    
    
    
    
    public String[] getSelectedSeats() {
       // System.out.println("Total Selected Seat" + selectedSeats);
        return selectedSeats;
    }

    public void setSelectedSeats(String[] selectedSeats) {
        this.selectedSeats = selectedSeats;
    }

    public List<String> getSeats() {

        return seats;
    }
    

    public void insert() {

        for (String selectedSeat : selectedSeats) {
            allseat += selectedSeat + ", ";
        }
        busTimeSchedule.setAvailableSeat(allseat);
        timeScheduleDaoImpl.insert(busTimeSchedule);
        selectedSeats =new String[0];
        totalSeat1=new TotalSeat();
    }
    
    
    
    public boolean testMe(){
        System.out.println("Just for test i am here..............."+a[0] +a[1]+a[2]);
        return false;
    }
    
    
}
