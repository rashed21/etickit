/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.launch.controlloer;

import ticket.com.controlloer.*;
import ticket.com.implDao.BoardingAreaImplDao;
import ticket.com.launch.implDao.LaunchBoardingAreaImplDao;
import ticket.com.launch.pojo.LaunchBordingArea;
import ticket.com.pojo.BoardingArea;
import ticket.com.pojo.Bus_type;

/**
 *
 * @author Emrul
 */
public class LaunchBoardingAreaControl {
    public LaunchBoardingAreaImplDao launchBoardingAreaImplDao=new LaunchBoardingAreaImplDao();
    public LaunchBordingArea boardingArea=new LaunchBordingArea();

    public LaunchBoardingAreaImplDao getLaunchBoardingAreaImplDao() {
        return launchBoardingAreaImplDao;
    }

    public void setLaunchBoardingAreaImplDao(LaunchBoardingAreaImplDao launchBoardingAreaImplDao) {
        this.launchBoardingAreaImplDao = launchBoardingAreaImplDao;
    }

    public LaunchBordingArea getBoardingArea() {
        return boardingArea;
    }

    public void setBoardingArea(LaunchBordingArea boardingArea) {
        this.boardingArea = boardingArea;
    }
   

  
    
    
    public void insert(){
        launchBoardingAreaImplDao.insert(boardingArea);
    }
    
}
