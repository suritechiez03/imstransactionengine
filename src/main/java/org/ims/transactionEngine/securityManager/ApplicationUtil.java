/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ims.transactionEngine.securityManager;

/**
 * 
 * @author Suresh Kumar V
 */
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import java.text.ParseException;
import org.hibernate.Session;
import org.ims.dao.session.HibernateUtil;

/**
 *
 * @author root
 */
public class ApplicationUtil {
    /*
          Used to convert date to us date format 'yyyy-MM-dd'
    */
    public static Date tousformat(String dateString) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.parse(dateString);
    }

    public static Date toIndianformat(String dateString) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.parse(dateString);
    }

    public static Date getDate() throws ParseException {
        Date date = new Date();
        Calendar cal= Calendar.getInstance();
              
        return tousformat(cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH)+1) + "-" + cal.get(Calendar.DAY_OF_MONTH));
    }

    public static String GenerateInvoiceNumber(long invoiceno) {

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        if (month < 3) {
            year = year - 1;
        }
        int remainder1 = year / 1000;
        year = year % 1000;
        int remainder2 = year / 100;
        year = year % 100;
        int year2 = year + 1;
        int remainder3 = year / 10;
        year = year % 10;
        int remainder4 = year;
        int remainder5 = year2 / 10;
        year2 = year2 % 10;
        int remainder6 = year2;
        //for 1st digit
        String temp = ((String) Character.toString((char) (65 + remainder1 - 1)));
        String invoiceyear;
        if (temp.equals("@")) {
            invoiceyear = "O";
        } else {
            invoiceyear = temp;
        }
        //for 2nd digit
        temp = ((String) Character.toString((char) (65 + remainder2 - 1)));
        if (temp.equals("@")) {
            invoiceyear = invoiceyear + "O";
        } else {
            invoiceyear = invoiceyear + temp;
        }
        //for 3rd digit
        temp = ((String) Character.toString((char) (65 + remainder3 - 1)));
        if (temp.equals("@")) {
            invoiceyear = invoiceyear + "O";
        } else {
            invoiceyear = invoiceyear + temp;
        }

        //for 4th digit
        temp = ((String) Character.toString((char) (65 + remainder4 - 1)));
        if (temp.equals("@")) {
            invoiceyear = invoiceyear + "O";
        } else {
            invoiceyear = invoiceyear + temp;
        }

        //for 5th digit
        temp = ((String) Character.toString((char) (65 + remainder5 - 1)));
        if (temp.equals("@")) {
            invoiceyear = invoiceyear + "O";
        } else {
            invoiceyear = invoiceyear + temp;
        }
        //for 6th digit
        temp = ((String) Character.toString((char) (65 + remainder6 - 1)));
        if (temp.equals("@")) {
            invoiceyear = invoiceyear + "O";
        } else {
            invoiceyear = invoiceyear + temp;
        }
        if (invoiceno < 9) {
            invoiceyear = invoiceyear + "-0";
        } else {
            invoiceyear = invoiceyear + "-";
        }
        System.out.println(invoiceno);

        return (invoiceyear + (invoiceno + 1)).toString();
    }
    
}

