/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.cinema.pojo;

/**
 *
 * @author Emrul
 */
public class HallSeatCatagory {
    private int hallSeatCataId;
   private int hallId;
   private String hallName;
   private String cataName;

    public int getHallSeatCataId() {
        return hallSeatCataId;
    }

    public void setHallSeatCataId(int hallSeatCataId) {
        this.hallSeatCataId = hallSeatCataId;
    }

    public int getHallId() {
        return hallId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    public String getCataName() {
        return cataName;
    }

    public void setCataName(String cataName) {
        this.cataName = cataName;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }
   
   
}
