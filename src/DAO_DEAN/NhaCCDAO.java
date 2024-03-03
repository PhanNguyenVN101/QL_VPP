/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO_DEAN;

import POJO_DEAN.NhaCC;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author tandat
 */
public class NhaCCDAO {
    public static ArrayList<NhaCC> getDSNCC(){
//        NhaCC(String mancc, String sdtncc, String hotenncc, String gioitinhncc, 
//                String diachincc, String sanphamcc)
        
        ArrayList<NhaCC> dsncc = new ArrayList<NhaCC>();
        try {
            String sql = "select * from NhaCC";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                NhaCC ncc = new NhaCC(rs.getString("MaNhaCC"),rs.getString("SoDTNCC"),
                        rs.getString("HoTenNCC"),rs.getString("GioiTinhNCC"),rs.getString("DiaChiNCC"),
                        rs.getString("SanPhamCC"));
                dsncc.add(ncc);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return dsncc;
    }
    public static String ThongTinNhaCC(String mancc){

        String kq="";
        try {
            String sql = "select * from NhaCC where MaNhaCC = '"+mancc+"'";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                kq+="Mã số: "+rs.getString("MaNhaCC")+"\n\nSố điện thoại: "+rs.getString("SoDTNCC")
                        +"\n\nHọ tên: "+rs.getString("HoTenNCC")+"\n\nGiới tính: "+rs.getString("GioiTinhNCC")
                        +"\n\nĐịa chỉ: "+rs.getString("DiaChiNCC")+"\n\nSản phẩm cung cấp:\n"+rs.getString("SanPhamCC");
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return kq;
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
    public static ArrayList<NhaCC> SapXep(String obj,String styleSort){
        ArrayList<NhaCC> dsncc = new ArrayList<NhaCC>();
        try {
            String sql = "select * from NhaCC "
                    + "order by "+obj+" "+styleSort+"";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                NhaCC ncc = new NhaCC(rs.getString("MaNhaCC"),rs.getString("SoDTNCC"),
                        rs.getString("HoTenNCC"),rs.getString("GioiTinhNCC"),rs.getString("DiaChiNCC"),
                        rs.getString("SanPhamCC"));
                dsncc.add(ncc);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return dsncc;
    }
    public static ArrayList<NhaCC> TimKiem(String obj, String value){
        ArrayList<NhaCC> dsncc = new ArrayList<NhaCC>();
        try {
            String sql = "select * from NhaCC "
                    + "where "+obj+" like N'%"+value+"%'";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                NhaCC ncc = new NhaCC(rs.getString("MaNhaCC"),rs.getString("SoDTNCC"),
                        rs.getString("HoTenNCC"),rs.getString("GioiTinhNCC"),rs.getString("DiaChiNCC"),
                        rs.getString("SanPhamCC"));
                dsncc.add(ncc);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return dsncc;
    }
    public static int TimKiemSDT(String sdt){
        int kq = 0;
        try {
            String sql = "select count(MaNhaCC) from NhaCC where SoDTNCC = '"+sdt+"'";
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
