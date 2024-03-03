/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO_DEAN;

import POJO_DEAN.DonDatHang;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author tandat
 */
public class DonDatHangDAO {
    public static ArrayList<DonDatHang> getDSDDH(){
        //DonDatHang(String maddh, String mancc, String nhanvien, 
        //String ngaydh, String trangthaidh, String capnhattonkho, int tongslspdh)
        
        ArrayList<DonDatHang> dsddh = new ArrayList<DonDatHang>();
        try {
            String sql = "select MaDonDH,MaNCC,HoTenNV,TongSLSPD,format(NgayDH,'dd/MM/yyyy') as NgayDH,TrangThaiDH,CapNhatTonKho \n" +
                    "from DonDatHang ddh, NhanVien nv\n" +
                    "where ddh.MaNV = nv.MaNV";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                DonDatHang ddh = new DonDatHang(rs.getString("MaDonDH"),rs.getString("MaNCC"),
                        rs.getString("HoTenNV"),rs.getString("NgayDH"),rs.getString("TrangThaiDH"),
                        rs.getString("CapNhatTonKho"),rs.getInt("TongSLSPD"));
                dsddh.add(ddh);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return dsddh;
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
    public static ArrayList<DonDatHang> SapXep(String obj,String styleSort){
        ArrayList<DonDatHang> dsddh = new ArrayList<DonDatHang>();
        try {
            String sql = "select MaDonDH,MaNCC,HoTenNV,TongSLSPD,format(NgayDH,'dd/MM/yyyy') as NgayDH,TrangThaiDH,CapNhatTonKho \n" +
                    "from DonDatHang ddh, NhaCC ncc, NhanVien nv\n" +
                    "where ddh.MaNV = nv.MaNV\n"
                    + "order by "+obj+" "+styleSort+"";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                DonDatHang ddh = new DonDatHang(rs.getString("MaDonDH"),rs.getString("MaNCC"),
                        rs.getString("HoTenNV"),rs.getString("NgayDH"),rs.getString("TrangThaiDH"),
                        rs.getString("CapNhatTonKho"),rs.getInt("TongSLSPD"));
                dsddh.add(ddh);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return dsddh;
    }
    public static ArrayList<DonDatHang> TimKiem(String obj, String value){
        ArrayList<DonDatHang> dsddh = new ArrayList<DonDatHang>();
        try {
            String sql = "select MaDonDH,MaNCC,HoTenNV,TongSLSPD,format(NgayDH,'dd/MM/yyyy') as NgayDH,TrangThaiDH,CapNhatTonKho \n" +
                    "from DonDatHang ddh, NhaCC ncc, NhanVien nv\n" +
                    "where ddh.MaNV = nv.MaNV\n"
                    + "and "+obj+" like N'%"+value+"%'";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                DonDatHang ddh = new DonDatHang(rs.getString("MaDonDH"),rs.getString("MaNCC"),
                        rs.getString("HoTenNV"),rs.getString("NgayDH"),rs.getString("TrangThaiDH"),
                        rs.getString("CapNhatTonKho"),rs.getInt("TongSLSPD"));
                dsddh.add(ddh);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return dsddh;
    }
    public static int XuatTongSLSPDat(String madh){

        int kq=0;
        try {
            String sql = "select TongSLSPD from DonDatHang where MaDonDH = '"+madh+"'";
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
    public static int DemSLSPCTDDH(String madh){

        int kq=0;
        try {
            String sql = "select count(*) from CTDonDatHang where MaDonDH = '"+madh+"'";
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
    public static String XuatNgayDatHang(String madh){

        String kq="";
        try {
            String sql = "select format(NgayDH,'dd/MM/yyyy') as NgayDH from DonDatHang where MaDonDH = '"+madh+"'";
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
    public static String XuatTTDatHang(String madh){

        String kq="";
        try {
            String sql = "select TrangThaiDH from DonDatHang where MaDonDH = '"+madh+"'";
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
    public static String XuatCNTK(String madh){

        String kq="";
        try {
            String sql = "select CapNhatTonKho from DonDatHang where MaDonDH = '"+madh+"'";
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
}
