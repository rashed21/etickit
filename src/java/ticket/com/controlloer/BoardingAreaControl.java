/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.controlloer;

import java.util.List;
import ticket.com.implDao.BoardingAreaImplDao;
import ticket.com.pojo.BoardingArea;
import ticket.com.pojo.Bus_type;

/**
 *
 * @author Emrul
 */
public class BoardingAreaControl {
    public BoardingAreaImplDao boardingAreaImplDao=new BoardingAreaImplDao();
    public BoardingArea boardingArea=new BoardingArea();
    public Bus_type bus_type=new Bus_type();

    public Bus_type getBus_type() {
        return bus_type;
    }

    public void setBus_type(Bus_type bus_type) {
        this.bus_type = bus_type;
    }

    public BoardingAreaImplDao getBoardingAreaImplDao() {
        return boardingAreaImplDao;
    }

    public void setBoardingAreaImplDao(BoardingAreaImplDao boardingAreaImplDao) {
        this.boardingAreaImplDao = boardingAreaImplDao;
    }

    public BoardingArea getBoardingArea() {
        return boardingArea;
    }

    public void setBoardingArea(BoardingArea boardingArea) {
        this.boardingArea = boardingArea;
    }
    
    
    public void insert(){
        boardingAreaImplDao.insert(boardingArea);
    }
    public List<BoardingArea> getAllBoardingArea() {
        return boardingAreaImplDao.getAllBoardingArea();
    }
}
