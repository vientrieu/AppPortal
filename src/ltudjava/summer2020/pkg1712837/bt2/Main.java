/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltudjava.summer2020.pkg1712837.bt2;

import FORM.GiaoVuForm;
import DAO.SinhvienDAO;
import FORM.Login;
import POJO.Sinhvien;
import java.io.IOException;

/**
 *
 * @author mangv
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Login newlogin=new Login();
        
        newlogin.setVisible(true);
        newlogin.setLocationRelativeTo (null);
        
//        GiaoVu newlogin=new GiaoVu();
//        newlogin.setVisible(true);
//        GiaoVuForm newf=new GiaoVuForm();
//        newf.setVisible(true);
//        newf.setLocationRelativeTo(null);
    }
    
}
