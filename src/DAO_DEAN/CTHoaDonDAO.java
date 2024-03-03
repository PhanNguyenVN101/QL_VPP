/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO_DEAN;

import POJO_DEAN.ChiTietHD;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author tandat
 */
public class CTHoaDonDAO {

    public static ArrayList<ChiTietHD> getDSCTHD_MaHD(String mahd){
        ArrayList<ChiTietHD> dscthd = new ArrayList<ChiTietHD>();
        try {
            String sql = "select cthd.MaSP, TenSP ,SoLuongSP,TongTien \n" +
                         "from CTHD cthd, SanPham sp where cthd.MaSP = sp.MaSP and MaCTHD = '"+mahd+"'";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                ChiTietHD cthd = new ChiTietHD(rs.getString("MaSP"),rs.getString("TenSP"),
                        rs.getInt("SoLuongSP"),rs.getInt("TongTien"));
                dscthd.add(cthd);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return dscthd;
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
    public static int XuatSL_MaCTHD(String macthd, String masp){
        int kq=0;
        try {
            String sql = "select SoLuongSP from CTHD where MaCTHD = '"+macthd+"' and MaSP = '"+masp+"'";
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
    public static int DemSLSP_HD(String macthd){
        int kq=0;
        try {
            String sql = "select count(*) from CTHD where MaCTHD =  '"+macthd+"'";
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
    public static ArrayList<String> XuatMaSP_HD(String MaCTHD){
        ArrayList<String> dsmsp = new ArrayList<String>();
        try {
            String sql = "select MaSP from CTHD where MaCTHD = '"+MaCTHD+"'";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                dsmsp.add(rs.getString(1));
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return dsmsp;
    }
}
