/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltudjava.summer2020.pkg1712837.bt2;

import POJO.Diem;
import POJO.DiemId;
import POJO.Sinhvien;
import POJO.Thoikhoabieu;
import POJO.ThoikhoabieuId;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mangv
 */
public class ReadCSV {

    public List ReadClass(File file) throws IOException {
        // open file input stream
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                      new FileInputStream(file), "utf-8"));
        // read file line by line
        String line = null;
        Scanner scanner = null;
        int index = 0;
        List<Sinhvien> svList = new ArrayList<>();
        reader.readLine();
        while ((line = reader.readLine()) != null) {
            Sinhvien sv = new Sinhvien();
            scanner = new Scanner(line);
            scanner.useDelimiter(",");
            while (scanner.hasNext()) {
                String data = scanner.next();
                if (index == 1) {
                    sv.setMaLop(data);
                } else if (index == 2) {
                    sv.setMssv(data);
                    sv.setPassword(data);
                } else if (index == 3) {
                    sv.setHoTen(data);
                } else if (index == 4) {
                    sv.setGioiTinh(data);
                } else if (index == 5) {
                    sv.setCmnd(data);
                } else {
                }
                index++;
            }
            index = 0;
            svList.add(sv);
        }
        reader.close();
        return svList;
    };
    public List ReadTKB(File file) throws IOException {
        // open file input stream
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                      new FileInputStream(file), "utf-8"));
        // read file line by line
        String line = null;
        Scanner scanner = null;
        int index = 0;
        List<Thoikhoabieu> tkbList = new ArrayList<>();
        reader.readLine();
        while ((line = reader.readLine()) != null) {
            Thoikhoabieu tkb= new Thoikhoabieu();
            ThoikhoabieuId idtkb = new ThoikhoabieuId();
            scanner = new Scanner(line);
            scanner.useDelimiter(",");
            while (scanner.hasNext()) {
                String data = scanner.next();
                if (index == 1) {
                    idtkb.setMaLop(data);
                } else if (index == 2) {
                    idtkb.setMaMh(data);
                    tkb.setId(idtkb);
                } else if (index == 3) {
                    tkb.setTenMh(data);
                } else if (index == 4) {
                    tkb.setPhong(data);
                } else {
                }
                index++;
            }
            index = 0;
            tkbList.add(tkb);
        }
        reader.close();
        return tkbList;
    };
     public List ReadDiem(File file) throws IOException {
        // open file input stream
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                      new FileInputStream(file), "utf-8"));
        // read file line by line
        String line = null;
        Scanner scanner = null;
        int index = 0;
        List<Diem> diemList = new ArrayList<>();
        reader.readLine();
        while ((line = reader.readLine()) != null) {
            DiemId iddiem = new DiemId();
            Diem diem = new Diem();
            scanner = new Scanner(line);
            scanner.useDelimiter(",");
            while (scanner.hasNext()) {
                String data = scanner.next();
                if (index == 1) {
                    iddiem.setMaLop(data);
                } else if (index == 2) {
                    iddiem.setMaMh(data);
                } else if (index == 3) {
                    iddiem.setMssv(data);
                    iddiem.setNamHoc(2020);
                    diem.setId(iddiem);
                } else if (index == 5) {
                    diem.setDiemGk(Float.valueOf(data));
                } else if (index == 6) {
                    diem.setDiemCk(Float.valueOf(data));
                } else if (index == 7) {
                    diem.setDiemKhac(Float.valueOf(data)); 
                } else if (index == 8) {
                diem.setDiemTk(Float.valueOf(data));
                } else {
                }
                index++;
            }
            index = 0;
            diemList.add(diem);
        }
        reader.close();
        return diemList;
    };
}
