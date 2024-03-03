/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO_DEAN;

import POJO_DEAN.SanPham;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author tandat
 */
public class SanPhamDAO {
    public static ArrayList<SanPham> getDSSP(){
        ArrayList<SanPham> dssp = new ArrayList<SanPham>();
//        public SanPham(String masp, String tensp, String dvt, 
//                String loaisp, String thuonghieu, int sl, int giaban, int gianhap)
        try {
            String sql = "select MaSP,TenSP,SoLuong,DonViTinh,GiaBan,GiaNhap,LoaiSP,"
                    + "ThuongHieu from SanPham";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                SanPham sp = new SanPham(rs.getString("MaSP").trim(), 
                        rs.getString("TenSP").trim(), rs.getString("DonViTinh").trim(), 
                        rs.getString("LoaiSP").trim(), rs.getString("ThuongHieu").trim(),
                        rs.getInt("SoLuong"), rs.getInt("GiaBan"),
                        rs.getInt("GiaNhap"));
                dssp.add(sp);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return dssp;
    }
    public static ArrayList<SanPham> getDSSP_TimKiem(){
        ArrayList<SanPham> dssp = new ArrayList<SanPham>();
//        String masp, String tensp, String dvt, int sl, int giaban
        try {
            String sql = "select MaSP,TenSP,SoLuong,DonViTinh,GiaBan from SanPham";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                SanPham sp = new SanPham(rs.getString("MaSP").trim(), 
                        rs.getString("TenSP").trim(), rs.getString("DonViTinh").trim(),  
                        rs.getInt("SoLuong"), rs.getInt("GiaBan"));
                dssp.add(sp);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return dssp;
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
    public static ArrayList<SanPham> SapXep(String obj,String styleSort){
        ArrayList<SanPham> dssp = new ArrayList<SanPham>();
        try {
            String sql = "select MaSP,TenSP,SoLuong,DonViTinh,GiaBan,GiaNhap,LoaiSP,"
                    + "ThuongHieu from SanPham order by "+obj+" "+styleSort+"";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                SanPham sp = new SanPham(rs.getString("MaSP").trim(), 
                        rs.getString("TenSP").trim(), rs.getString("DonViTinh").trim(), 
                        rs.getString("LoaiSP").trim(), rs.getString("ThuongHieu").trim(),
                        rs.getInt("SoLuong"), rs.getInt("GiaBan"),
                        rs.getInt("GiaNhap"));
                dssp.add(sp);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return dssp;
    }
    public static ArrayList<SanPham> TimKiemTenSP(String ten){
        ArrayList<SanPham> dssp = new ArrayList<SanPham>();
        try {
            String sql = "select MaSP,TenSP,SoLuong,DonViTinh,GiaBan"
                    + " from SanPham where TenSP like N'%"+ten+"%'";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                SanPham sp = new SanPham(rs.getString("MaSP").trim(), 
                        rs.getString("TenSP").trim(), rs.getString("DonViTinh").trim(),  
                        rs.getInt("SoLuong"), rs.getInt("GiaBan"));
                dssp.add(sp);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return dssp;
    } 
    public static ArrayList<SanPham> TimKiem(String obj, String value){
        ArrayList<SanPham> dssp = new ArrayList<SanPham>();
        try {
            String sql = "select MaSP,TenSP,SoLuong,DonViTinh,GiaBan,GiaNhap,LoaiSP,"
                    + "ThuongHieu from SanPham where "+obj+" like N'%"+value+"%'";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                SanPham sp = new SanPham(rs.getString("MaSP").trim(), 
                        rs.getString("TenSP").trim(), rs.getString("DonViTinh").trim(), 
                        rs.getString("LoaiSP").trim(), rs.getString("ThuongHieu").trim(),
                        rs.getInt("SoLuong"), rs.getInt("GiaBan"),
                        rs.getInt("GiaNhap"));
                dssp.add(sp);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return dssp;
    }
    public static String TimLinkHinh(String masp){
        String kq="";
        try {
            String sql = "select HinhAnhSP from SanPham where MaSP = '"+masp+"'";
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
    public static int XuatSL_MaSP(String masp){
        int kq=0;
        try {
            String sql = "select SoLuong from SanPham where MaSP = '"+masp+"'";
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
