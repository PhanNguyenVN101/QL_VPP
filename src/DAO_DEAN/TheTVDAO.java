/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO_DEAN;

import POJO_DEAN.TheTV;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author tandat
 */
public class TheTVDAO {
    public static ArrayList<TheTV> getDST(){
        ArrayList<TheTV> dst = new ArrayList<TheTV>();
        try {
            String sql = "select MaThe,MaKH,TichDiem,"
                    + "format(NgayLapThe,'dd/MM/yyyy') as NgayLapThe from TheTV";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                TheTV t = new TheTV(rs.getString("MaThe").trim(), 
                        rs.getString("MaKH").trim(), rs.getString("NgayLapThe").trim(), 
                        rs.getInt("TichDiem"));
                dst.add(t);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return dst;
    }
    public static int ThemXoaSua(String sql){
        int i=0;
        try {
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
             i = cn.executeUpdate(sql);
            cn.close();
            System.out.println("Thêm/xóa/sửa thành công");
            
        } catch (Exception e) {
            System.out.println("Thêm/xóa/sửa không thành công");
           
        }
        return i;
    }
    public static ArrayList<TheTV> SapXep(String obj,String styleSort){
        ArrayList<TheTV> dst = new ArrayList<TheTV>();
        try {
            String sql = "select MaThe,MaKH,TichDiem,"
                    + "format(NgayLapThe,'dd/MM/yyyy') as NgayLapThe from TheTV";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                TheTV t = new TheTV(rs.getString("MaThe").trim(), 
                        rs.getString("MaKH").trim(), rs.getString("NgayLapThe").trim(), 
                        rs.getInt("TichDiem"));
                dst.add(t);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return dst;
    }
    public static ArrayList<TheTV> TimKiem(String obj, String value){
        ArrayList<TheTV> dst = new ArrayList<TheTV>();
        try {
            String sql = "select MaThe,MaKH,TichDiem,"
                    + "format(NgayLapThe,'dd/MM/yyyy') as NgayLapThe from TheTV";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                TheTV t = new TheTV(rs.getString("MaThe").trim(), 
                        rs.getString("MaKH").trim(), rs.getString("NgayLapThe").trim(), 
                        rs.getInt("TichDiem"));
                dst.add(t);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return dst;
    }
    public static int XuatTichDiem(String makh){
        int kq=0;
        try {
            String sql = "select TichDiem from TheTV where MaKH = '"+makh+"'";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                kq = rs.getInt(1);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return kq;
    }
    public static int XacNhanTheTV(String makh){
        int kq=0;
        try {
            String sql = "select count(*) from TheTV where MaKH = '"+makh+"'";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                kq = rs.getInt(1);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return kq;
    }
}
