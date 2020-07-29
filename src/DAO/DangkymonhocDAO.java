/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Dangkymonhoc;
import POJO.DangkymonhocId;
import UTIL.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author mangv
 */
public class DangkymonhocDAO {
    static Session session=null;
    public static Dangkymonhoc getDangkymonhoc(DangkymonhocId iddkmh) {
        session = HibernateUtil.getSessionFactory().openSession();
        Dangkymonhoc dkmh = null;
        dkmh = (Dangkymonhoc) session.get(Dangkymonhoc.class, iddkmh);
        return dkmh;
    }
    ;
    public void addDangkymonhoc(Dangkymonhoc dkmh) {
        if(getDangkymonhoc(dkmh.getId())!=null) return;
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();
        session.save(dkmh);
        tx.commit();
        session.close();
    }
    ;
    public void deleteDangkymonhoc(Dangkymonhoc dkmh) {
        if(getDangkymonhoc(dkmh.getId())==null) return;
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();
        session.delete(dkmh);
        tx.commit();
        session.close();
    }
    ;
}
