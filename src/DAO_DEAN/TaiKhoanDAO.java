/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO_DEAN;

import POJO_DEAN.TaiKhoan;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author tandat
 */
public class TaiKhoanDAO {
        public static ArrayList<TaiKhoan> getDSTK(){
        ArrayList<TaiKhoan> dstk = new ArrayList<TaiKhoan>();
        try {
            String sql = "select * from TaiKhoan where MaNV is not null";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                TaiKhoan tk = new TaiKhoan(rs.getString("TenTK").trim(), 
                        rs.getString("MatKhau").trim(), rs.getString("MaNV").trim(), 
                        rs.getString("Quyen").trim());
                dstk.add(tk);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return dstk;
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
    public static ArrayList<TaiKhoan> SapXep(String obj,String styleSort){
        ArrayList<TaiKhoan> dstk = new ArrayList<TaiKhoan>();
        try {
            String sql = "select * from TaiKhoan where MaNV is not null order by "+obj+" "+styleSort+"";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                TaiKhoan tk = new TaiKhoan(rs.getString("TenTK").trim(), 
                        rs.getString("MatKhau").trim(), rs.getString("MaNV").trim(), 
                        rs.getString("Quyen").trim());
                dstk.add(tk);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return dstk;
    }
    public static ArrayList<TaiKhoan> TimKiem(String obj, String value){
        ArrayList<TaiKhoan> dstk = new ArrayList<TaiKhoan>();
        try {
            String sql = "select * from TaiKhoan where MaNV is not null and "+obj+" like N'%"+value+"%'";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                TaiKhoan tk = new TaiKhoan(rs.getString("TenTK").trim(), 
                        rs.getString("MatKhau").trim(), rs.getString("MaNV").trim(), 
                        rs.getString("Quyen").trim());
                dstk.add(tk);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return dstk;
    }
    public static int XacNhanTK(String tenTK, String MatKhau){
        int kq=0;
        try {
            String sql = "select count(*) from TaiKhoan where TenTK = '"+tenTK+"' and MatKhau = '"+MatKhau+"'";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                 kq=rs.getInt(1);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return kq;
    }
    public static String XuatMaNV(String tenTK){
        String kq="";
        try {
            String sql = "select MaNV from TaiKhoan where TenTK = '"+tenTK+"'";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                 kq=rs.getString(1);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return kq;
    }
    public static String XuatQuyen(String tenTK){
        String kq="";
        try {
            String sql = "select Quyen from TaiKhoan where TenTK = '"+tenTK+"'";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                 kq=rs.getString(1);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return kq;
    }
    public static String XuatMatKhau(String tenTK){
        String kq="";
        try {
            String sql = "select MatKhau from TaiKhoan where TenTK = '"+tenTK+"'";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                 kq=rs.getString(1);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return kq;
    }
    public static ArrayList<String> getDSQuyen(){
        ArrayList<String> dsquyen = new ArrayList<String>();
        try {
            String sql = "select distinct Quyen from TaiKhoan";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                String quyen = rs.getString(1);
                dsquyen.add(quyen);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return dsquyen;
    }
}
