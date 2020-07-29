/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.ThoikhoabieuDAO.session;
import POJO.Dangkymonhoc;
import POJO.Sinhvien;
import UTIL.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author mangv
 */
public class SinhvienDAO {
    static Session session=null;
    public static Sinhvien getSinhvien(String Mssv) {
        session = HibernateUtil.getSessionFactory().openSession();
        Sinhvien sv = null;
        sv = (Sinhvien) session.get(Sinhvien.class, Mssv);
        return sv;
    }
    ;
    public void addSinhvien(Sinhvien sv) {
        if(getSinhvien(sv.getMssv())!=null) return;
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();
        session.save(sv);
        tx.commit();
        session.close();
    }
    ;
    public List getListSVLop(String MaLop, String MaMh) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String myqr="";
        if(MaLop.equals("")) return null;
        if (MaMh.equals("")) {
            myqr = "from Sinhvien sv where sv.maLop = \'" + MaLop + "\'";
        }
        else
        {
            myqr = "select sv "
            + "from Sinhvien sv, Dangkymonhoc dk "
            + "where sv.mssv = dk.id.mssv and dk.id.maLop = \'"+ MaLop + "\' and dk.id.maMh = \'"+ MaMh +"\'";
        }
        Query query = session.createQuery(myqr);
        List<Sinhvien> svList = query.list();
        tx.commit();
        session.close();
        return svList;
    }
    ;
    public void updateSinhvien(Sinhvien sv) {
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();
        session.saveOrUpdate(sv);
        tx.commit();
        session.close();
    }
    ;
    
}
