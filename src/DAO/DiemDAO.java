/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Diem;
import POJO.DiemId;
import POJO.Sinhvien;
import UTIL.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author mangv
 */
public class DiemDAO {
    static Session session=null;
    public static Diem getDiem(DiemId iddiem) {
        session = HibernateUtil.getSessionFactory().openSession();
        Diem diem = null;
        diem = (Diem) session.get(Diem.class, iddiem);
        return diem;
    }
    ;
    public static List getDiemSV(String mssv) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String myqr="";
            myqr = "select diem "
            + "from Diem diem "
            + "where diem.id.mssv = \'" + mssv + "\'";
        Query query = session.createQuery(myqr);
        List diemList = query.list();
        tx.commit();
        session.close();
        return diemList;
    }
    ;
    public static List getListDiem(String MaLop, String MaMh) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String myqr="";
        if(MaLop.equals("")) return null;
        else if(MaMh.equals("")) return null;
        else
        {
            myqr = "select sv.hoTen, diem "
            + "from Sinhvien sv, Diem diem "
            + "where sv.mssv = diem.id.mssv and diem.id.maLop = \'"+ MaLop + "\' and diem.id.maMh = \'"+ MaMh +"\'";
        }
        Query query = session.createQuery(myqr);
        List<Object[]> diemList = query.list();
        tx.commit();
        session.close();
        return diemList;
    }
    ;
    public void addDiem(Diem diem) {
        if(getDiem(diem.getId())!=null) return;
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();
        session.save(diem);
        tx.commit();
        session.close();
    }
    ;
    public void deleteDiem(Diem diem) {
        if(getDiem(diem.getId())==null) return;
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();
        session.delete(diem);
        tx.commit();
        session.close();
    }
    ;
    public void updateDiem(Diem diem) {
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();
        session.saveOrUpdate(diem);
        tx.commit();
        session.close();
    }
    ;
}
