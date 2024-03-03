/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO_DEAN;
import POJO_DEAN.HoaDon;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author tandat
 */
public class HoaDonDAO {
    public static ArrayList<HoaDon> getDSHD(){
        ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();
        try {
            String sql = "select MaHD,TongSL,TongTienHD,GiamGia,ThanhTien,TrangThai, \n" +
                           "format(TGLap,'dd/MM/yyyy, hh:mm:ss tt') as TGLap from HoaDon";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                HoaDon hd = new HoaDon(rs.getString("MaHD"),rs.getInt("TongSL"),
                        rs.getInt("TongTienHD"),rs.getInt("GiamGia"),rs.getInt("ThanhTien"),
                        rs.getString("TrangThai"),rs.getString("TGLap"));
                dshd.add(hd);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return dshd;
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
    public static ArrayList<HoaDon> SapXep(String obj,String styleSort){
        ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();
        try {
            String sql = "select MaHD,TongSL,TongTienHD,GiamGia,ThanhTien,TrangThai,format(TGLap,'dd/MM/yyyy, hh:mm:ss tt') as TGLap from HoaDon "
                    + "order by "+obj+" "+styleSort+"";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                HoaDon hd = new HoaDon(rs.getString("MaHD"),rs.getInt("TongSL"),
                        rs.getInt("TongTienHD"),rs.getInt("GiamGia"),rs.getInt("ThanhTien"),
                        rs.getString("TrangThai"),rs.getString("TGLap"));
                dshd.add(hd);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return dshd;
    }
    public static ArrayList<HoaDon> TimKiem(String obj, String value){
        ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();
        try {
            String sql = "select MaHD,TongSL,TongTienHD,GiamGia,ThanhTien,TrangThai,format(TGLap,'dd/MM/yyyy, hh:mm:ss tt') as TGLap from HoaDon "
                    + "where "+obj+" like N'%"+value+"%'";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                HoaDon hd = new HoaDon(rs.getString("MaHD"),rs.getInt("TongSL"),
                        rs.getInt("TongTienHD"),rs.getInt("GiamGia"),rs.getInt("ThanhTien"),
                        rs.getString("TrangThai"),rs.getString("TGLap"));
                dshd.add(hd);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return dshd;
    }
    public static int XacNhanHD(String MaHD){
        int kq=0;
        try {
            String sql = "select count(MaHD) from HoaDon where MaHD = '"+MaHD+"'";
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
    public static String LoaiGG(String MaHD){
        String kq="";
        try {
            String sql = "select LoaiGG from HoaDon where MaHD = '"+MaHD+"'";
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
    public static String XuatTenNV(String MaHD){
        String kq="";
        try {
            String sql = "select HoTenNV from HoaDon hd, NhanVien nv "
                    + "where hd.MaNV = nv.MaNV and MaHD = '"+MaHD+"'";
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
    public static String XuatMaHD_ChuaThanhToan(){
        String kq="";
        try {
            String sql = "select MaHD from HoaDon where TrangThai = N'Chưa thanh toán'";
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
    public static String XuatTGLap(String MaHD){
        String kq="";
        try {
            String sql = "select format(TGLap,'dd/MM/yyyy, hh:mm:ss tt') as TGLap from HoaDon where MaHD = '"+MaHD+"'";
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
    public static String XuatMaKH(String MaHD){
        String kq="";
        try {
            String sql = "select MaKH from HoaDon where MaHD = '"+MaHD+"'";
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
    public static String XuatTenKH(String MaHD){
        String kq="", makh = XuatMaKH(MaHD);
        try {
            if(makh == null)
                kq = "Khách vãng lai";
            else{
                String sql = "select HoTenKH from HoaDon hd, KhachHang kh \n" +
                            "where hd.MaKH = kh.MaKH\n" +
                            "and MaHD = '"+MaHD+"' and hd.MaKH = '"+makh+"'";
                ConnectionDB cn = new ConnectionDB();
                cn.getCn();
                ResultSet rs = cn.executeQuery(sql);
                while(rs.next()){
                    kq=rs.getString(1);
                }
                cn.close();
            }
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return kq;
    }
    public static String XuatTongSL(String MaHD){
        String kq="";
        try {
            String sql = "select TongSL from HoaDon where MaHD = '"+MaHD+"'";
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
    public static String XuatHD_ChuaThanhToan(){
        String kq="";
        try {
            String sql = "select top(1) MaHD from HoaDon where TrangThai = N'Chưa thanh toán'";
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
    public static String XuatTongTienHD(String MaHD){
        String kq="";
        try {
            String sql = "select TongTienHD from HoaDon where MaHD = '"+MaHD+"'";
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
    public static String XuatGiamGia(String MaHD){
        String kq="",kq1="";
        try {
            String sql = "select GiamGia,LoaiGG from HoaDon where MaHD = '"+MaHD+"'";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                kq=rs.getString(1);
                kq1=rs.getString(2);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return kq+' '+kq1;
    }
    public static String XuatThanhTien(String MaHD){
        String kq="";
        try {
            String sql = "select ThanhTien from HoaDon where MaHD = '"+MaHD+"'";
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
    public static String XuatTrangThai(String MaHD){
        String kq="";
        try {
            String sql = "select TrangThai from HoaDon where MaHD = '"+MaHD+"'";
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
