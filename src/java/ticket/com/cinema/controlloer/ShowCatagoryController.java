/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.com.cinema.controlloer;

import ticket.com.cinema.implDao.ShowCatagoryImplDao;
import ticket.com.cinema.pojo.ShowCatagory;

/**
 *
 * @author Emrul
 */
public class ShowCatagoryController {
  private   ShowCatagory showCatagory=new ShowCatagory();
  private ShowCatagoryImplDao catagoryImplDao=new  ShowCatagoryImplDao();

    public ShowCatagory getShowCatagory() {
        return showCatagory;
    }

    public void setShowCatagory(ShowCatagory showCatagory) {
        this.showCatagory = showCatagory;
    }

    public ShowCatagoryImplDao getCatagoryImplDao() {
        return catagoryImplDao;
    }

    public void setCatagoryImplDao(ShowCatagoryImplDao catagoryImplDao) {
        this.catagoryImplDao = catagoryImplDao;
    }
  
  public void insert(){
      try {
           catagoryImplDao.insert(showCatagory);
      } catch (Exception e) {
      }finally{
          showCatagory=null;
      }
     
  }
}
