/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO_DEAN;

import java.sql.ResultSet;
import java.util.ArrayList;
import POJO_DEAN.KhachHang;

/**
 *
 * @author tandat
 */
public class KhachHangDAO {
    public static ArrayList<KhachHang> getDSKH(){
        ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
        try {
            String sql = "select * from KhachHang";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                KhachHang kh = new KhachHang(rs.getString("MaKH").trim(), rs.getString("SoDTKH").trim(), 
                        rs.getString("HoTenKH").trim(), rs.getString("GioiTinhKH").trim(), 
                        rs.getString("DiaChiKH").trim(), rs.getString("EmailKH").trim());
                dskh.add(kh);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return dskh;
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
    public static ArrayList<KhachHang> SapXep(String obj,String styleSort){
        ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
        try {
            String sql = "select * from KhachHang order by "+obj+" "+styleSort+"";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                KhachHang kh = new KhachHang(rs.getString("MaKH").trim(), rs.getString("SoDTKH").trim(), 
                        rs.getString("HoTenKH").trim(), rs.getString("GioiTinhKH").trim(), 
                        rs.getString("DiaChiKH").trim(), rs.getString("EmailKH").trim());
                dskh.add(kh);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return dskh;
    }
    public static ArrayList<String> listSDT(String sdt){
        ArrayList<String> dsSDT = new ArrayList<String>();
        try {
            String sql = "select SoDTKH from KhachHang where SoDTKH like '%"+sdt+"%'";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                dsSDT.add(rs.getString(1));
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return dsSDT;
    }
    public static ArrayList<KhachHang> TimKiem(String obj, String value){
        ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
        try {
            String sql = "select * from KhachHang where "+obj+" like N'%"+value+"%'";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                KhachHang kh = new KhachHang(rs.getString("MaKH").trim(), rs.getString("SoDTKH").trim(), 
                        rs.getString("HoTenKH").trim(), rs.getString("GioiTinhKH").trim(), 
                        rs.getString("DiaChiKH").trim(), rs.getString("EmailKH").trim());
                dskh.add(kh);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return dskh;
    }
    public static String XuatMaKH(String sdt){
        String kq = "";
        try {
            String sql = "select MaKH from KhachHang where SoDTKH = '"+sdt+"'";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                kq = rs.getString(1);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return kq;
    }
    public static int TimKiemSDT(String sdt){
        int kq = 0;
        try {
            String sql = "select count(MaKH) from KhachHang where SoDTKH = '"+sdt+"'";
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
    public static int TimKiemMaKH(String makh){
        int kq = 0;
        try {
            String sql = "select count(MaKH) from KhachHang where MaKH = '"+makh+"'";
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
}
