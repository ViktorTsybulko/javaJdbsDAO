package com.jdbc.main;

import com.jdbc.dao.CustomerDao;
import com.jdbc.dao.TelecastDao;
import com.jdbc.dao.TrailerDao;
import com.jdbc.dao.impl.CustomerDaoImpl;
import com.jdbc.dao.impl.TelecastDaoImpl;
import com.jdbc.dao.impl.TrailerDaoImpl;

import java.sql.Time;

public class Main {
    public static void main(String[] args) {
        //CustomerDao customerDao  = new CustomerDaoImpl();
        //System.out.println(customerDao.findAll());
        //System.out.println(customerDao.findById(656));
        //System.out.println(customerDao.findByFirm("P&G"));
        //System.out.println(customerDao.findByContactPerson("Иванов"));
        //System.out.println(customerDao.findByCode(5454553));
        //System.out.println(customerDao.findByTelephone("0934545320"));

        //TelecastDao telecastDao = new TelecastDaoImpl();
        //System.out.println(telecastDao.findAll());
        //System.out.println(telecastDao.findById(501));
        //System.out.println(telecastDao.findByName("Х-фактор"));
        //System.out.println(telecastDao.findByRate(8));
        //System.out.println(telecastDao.findByCostMinute(300.0));


        //TrailerDao trailerDao = new TrailerDaoImpl();
        //System.out.println(trailerDao.findAll());
        //System.out.println(trailerDao.findById(1));
        //System.out.println(trailerDao.findByName("Colgate"));
        //System.out.println(trailerDao.findByDuration(new Time(0,1,30)));


    }

}
