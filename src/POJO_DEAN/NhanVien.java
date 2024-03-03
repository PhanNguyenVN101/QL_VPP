/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO_DEAN;

/**
 *
 * @author tandat
 */
public class NhanVien {
    private String ma,hoten,gioitinh,sdt,socccd,ngaysinh,diachi,quequan;

    public NhanVien(String ma, String hoten, String gioitinh, String sdt, String socccd, String ngaysinh, String diachi, String quequan) {
        this.ma = ma;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.sdt = sdt;
        this.socccd = socccd;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.quequan = quequan;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getSocccd() {
        return socccd;
    }

    public void setSocccd(String socccd) {
        this.socccd = socccd;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }
    
}
