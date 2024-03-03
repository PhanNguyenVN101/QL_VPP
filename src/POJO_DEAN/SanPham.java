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
public class SanPham {
    private String masp,tensp,dvt,loaisp,thuonghieu,hinh;
    private int sl,giaban,gianhap;


    public SanPham(String masp, String tensp, String dvt, int sl, int giaban) {
        this.masp = masp;
        this.tensp = tensp;
        this.dvt = dvt;
        this.sl = sl;
        this.giaban = giaban;
    }



    public SanPham(String masp, String tensp, String dvt, String loaisp, String thuonghieu, int sl, int giaban, int gianhap) {
        this.masp = masp;
        this.tensp = tensp;
        this.dvt = dvt;
        this.loaisp = loaisp;
        this.thuonghieu = thuonghieu;
        this.sl = sl;
        this.giaban = giaban;
        this.gianhap = gianhap;
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

    public String getDvt() {
        return dvt;
    }

    public void setDvt(String dvt) {
        this.dvt = dvt;
    }

    public String getLoaisp() {
        return loaisp;
    }

    public void setLoaisp(String loaisp) {
        this.loaisp = loaisp;
    }

    public String getThuonghieu() {
        return thuonghieu;
    }

    public void setThuonghieu(String thuonghieu) {
        this.thuonghieu = thuonghieu;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public int getGiaban() {
        return giaban;
    }

    public void setGiaban(int giaban) {
        this.giaban = giaban;
    }

    public int getGianhap() {
        return gianhap;
    }

    public void setGianhap(int gianhap) {
        this.gianhap = gianhap;
    }
    
}
