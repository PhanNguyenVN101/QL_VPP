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
public class ChiTietHD {
    private String masp,tensp;
    private int soluong,tongtien;

    public ChiTietHD(String masp, String tensp, int soluong, int tongtien) {
        this.masp = masp;
        this.tensp = tensp;
        this.soluong = soluong;
        this.tongtien = tongtien;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }
    
    
}
