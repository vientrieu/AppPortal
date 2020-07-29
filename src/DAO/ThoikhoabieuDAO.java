/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.SinhvienDAO.session;
import POJO.Dangkymonhoc;
import POJO.DangkymonhocId;
import POJO.Sinhvien;
import POJO.Thoikhoabieu;
import POJO.ThoikhoabieuId;
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
public class ThoikhoabieuDAO {
    static Session session=null;
    public static Thoikhoabieu getThoikhoabieu(ThoikhoabieuId idtkb) {
        session = HibernateUtil.getSessionFactory().openSession();
        Thoikhoabieu tkb = null;
        tkb = (Thoikhoabieu) session.get(Thoikhoabieu.class, idtkb);
        return tkb;
    }
    ;
    public void addThoikhoabieu(Thoikhoabieu tkb) {
        if(getThoikhoabieu(tkb.getId())!=null) return;
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();
        session.save(tkb);
        Query query = session.createQuery("from Sinhvien");
        List<Sinhvien> svList = query.list();
        for (Sinhvien sv : svList) {
            if(sv.getMaLop().equals(tkb.getId().getMaLop()))
            {
                DangkymonhocId iddkmh = new DangkymonhocId();
                Dangkymonhoc dkmh = new Dangkymonhoc();
                DangkymonhocDAO dkmhDAO = new DangkymonhocDAO();
                iddkmh.setMaLop(tkb.getId().getMaLop());
                iddkmh.setMaMh(tkb.getId().getMaMh());
                iddkmh.setMssv(sv.getMssv());
                iddkmh.setNamHoc(2020);
                dkmh.setId(iddkmh);
                dkmhDAO.addDangkymonhoc(dkmh);
//                System.out.print(sv.getHoTen());
            }
        }
        tx.commit();
        session.close();
    }
    ;
    public List getListTKB(String MaLop) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String myqr="";
        if(MaLop.equals("")) return null;
        else
        {
            myqr = "from Thoikhoabieu tkb where tkb.id.maLop = \'" + MaLop + "\'";
        }
        Query query = session.createQuery(myqr);
        List<Thoikhoabieu> tkbList = query.list();
        tx.commit();
        session.close();
        return tkbList;
    }
    ;
}
