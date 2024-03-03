/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO_DEAN;

import POJO_DEAN.ChiTietDDH;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author tandat
 */
public class CTDonDHDAO {
    public static ArrayList<ChiTietDDH> getDSCTDDH(String maddh){
        //DonDatHang(String maddh, String mancc, String nhanvien, 
        //String ngaydh, String trangthaidh, String capnhattonkho, int tongslspdh)
        
        ArrayList<ChiTietDDH> dsctddh = new ArrayList<ChiTietDDH>();
        try {
            String sql = "select ctddh.MaSP,TenSP,SoLuongSPD \n" +
                        "from CTDonDatHang ctddh, SanPham sp \n" +
                        "where ctddh.MaSP = sp.MaSP  and MaDonDH = '"+maddh+"' ";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                ChiTietDDH ctddh = new ChiTietDDH(rs.getString("MaSP"),rs.getString("TenSP"),rs.getInt("SoLuongSPD"));
                dsctddh.add(ctddh);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return dsctddh;
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
    
    public static int XuatSLDat(String madon, String masp){
        int kq=0;
        try {
            String sql = "select SoLuongSPD from CTDonDatHang where MaDonDH = '"+madon+"' and MaSP = '"+masp+"'";
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
    public static ArrayList<String> XuatMaSP_DDH(String madon){
        ArrayList<String> dsmsp = new ArrayList<String>();
        try {
            String sql = "select MaSP from CTDonDatHang where MaCTHD = '"+madon+"'";
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
