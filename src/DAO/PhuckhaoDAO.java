/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Phuckhao;
import POJO.PhuckhaoId;
import UTIL.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author mangv
 */
public class PhuckhaoDAO {
    static Session session=null;
    public static Phuckhao getPhuckhao(PhuckhaoId idpk) {
        session = HibernateUtil.getSessionFactory().openSession();
        Phuckhao pk = null;
        pk = (Phuckhao) session.get(Phuckhao.class, idpk);
        return pk;
    }
    ;
    public static List getListPhuckhao() {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String myqr="from Phuckhao";
        Query query = session.createQuery(myqr);
        List pkList = query.list();
        tx.commit();
        session.close();
        return pkList;
    }
    ;
    public void deletePhuckhao(Phuckhao pk) {
        if(getPhuckhao(pk.getId())==null) return;
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();
        session.delete(pk);
        tx.commit();
        session.close();
    }
    ;
     public void addPhuckhao(Phuckhao pk) {
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();
        session.saveOrUpdate(pk);
        tx.commit();
        session.close();
    }
    ;
}
