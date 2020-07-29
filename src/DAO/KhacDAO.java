/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Khac;
import POJO.Sinhvien;
import UTIL.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author mangv
 */
public class KhacDAO {
    static Session session=null;
    public static Khac getKhac(String Loaidulieu) {
        session = HibernateUtil.getSessionFactory().openSession();
        Khac k = null;
        k = (Khac) session.get(Khac.class, Loaidulieu);
        return k;
    }
    ;
    public void updateKhac(Khac k) {
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();
        session.saveOrUpdate(k);
        tx.commit();
        session.close();
    }
    ;
    
}
