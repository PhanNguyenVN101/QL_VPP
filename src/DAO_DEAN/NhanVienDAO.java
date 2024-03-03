/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO_DEAN;
import POJO_DEAN.NhanVien;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author tandat
 */
public class NhanVienDAO {
//    public NhanVien(String ma, String hoten, String gioitinh, String sdt, String socccd,
//            String ngaysinh, String diachi, String quequan, String hinhanh)
    public static ArrayList<NhanVien> getDSNV(){
        ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
        try {
            String sql = "select MaNV,HoTenNV,GioiTinhNV,SDT_NV,"
                    + "SoCCCD,format(NgaySinh,'dd/MM/yyyy') as NgaySinh,DiaChiNV,QueQuan from NhanVien";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                NhanVien nv = new NhanVien(rs.getString("MaNV").trim(), 
                        rs.getString("HoTenNV").trim(), rs.getString("GioiTinhNV").trim(), 
                        rs.getString("SDT_NV").trim(), rs.getString("SoCCCD").trim(),
                        rs.getString("NgaySinh").trim(), rs.getString("DiaChiNV").trim(),
                        rs.getString("QueQuan").trim());
                dsnv.add(nv);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return dsnv;
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
    public static ArrayList<NhanVien> SapXep(String obj,String styleSort){
        ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
        try {
            String sql = "select MaNV,HoTenNV,GioiTinhNV,SDT_NV,"
                    + "SoCCCD,format(NgaySinh,'dd/MM/yyyy') as NgaySinh,DiaChiNV,QueQuan from NhanVien order by "+obj+" "+styleSort+"";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                NhanVien nv = new NhanVien(rs.getString("MaNV").trim(), 
                        rs.getString("HoTenNV").trim(), rs.getString("GioiTinhNV").trim(), 
                        rs.getString("SDT_NV").trim(), rs.getString("SoCCCD").trim(),
                        rs.getString("NgaySinh").trim(), rs.getString("DiaChiNV").trim(),
                        rs.getString("QueQuan").trim());
                dsnv.add(nv);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return dsnv;
    }
    public static ArrayList<NhanVien> TimKiem(String obj, String value){
        ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
        try {
            String sql = "select MaNV,HoTenNV,GioiTinhNV,SDT_NV,"
                    + "SoCCCD,format(NgaySinh,'dd/MM/yyyy') as NgaySinh,DiaChiNV,QueQuan from NhanVien where "+obj+" like N'%"+value+"%'";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                NhanVien nv = new NhanVien(rs.getString("MaNV").trim(), 
                        rs.getString("HoTenNV").trim(), rs.getString("GioiTinhNV").trim(), 
                        rs.getString("SDT_NV").trim(), rs.getString("SoCCCD").trim(),
                        rs.getString("NgaySinh").trim(), rs.getString("DiaChiNV").trim(),
                        rs.getString("QueQuan").trim());
                dsnv.add(nv);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return dsnv;
    }
    public static String TimLinkHinh(String manv){
        String kq="";
        try {
            String sql = "select HinhAnh from NhanVien where MaNV = '"+manv+"'";
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
    public static int TimSDT(String sdt){
        int kq=0;
        try {
            String sql = "select count(SDT_NV) from NhanVien where SDT_NV = '"+sdt+"'";
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
    public static int TimSoCCCD(String socccd){
        int kq=0;
        try {
            String sql = "select count(SoCCCD) from NhanVien where SoCCCD = '"+socccd+"'";
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
