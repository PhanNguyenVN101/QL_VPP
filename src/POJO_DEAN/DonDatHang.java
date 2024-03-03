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
public class DonDatHang {
    private String maddh,mancc,nhanvien,ngaydh,trangthaidh,capnhattonkho;
    private int tongslspdh;

    public DonDatHang(String maddh, String mancc, String nhanvien, String ngaydh, String trangthaidh, String capnhattonkho, int tongslspdh) {
        this.maddh = maddh;
        this.mancc = mancc;
        this.nhanvien = nhanvien;
        this.ngaydh = ngaydh;
        this.trangthaidh = trangthaidh;
        this.capnhattonkho = capnhattonkho;
        this.tongslspdh = tongslspdh;
    }

    public String getMaddh() {
        return maddh;
    }

    public void setMaddh(String maddh) {
        this.maddh = maddh;
    }

    public String getMancc() {
        return mancc;
    }

    public void setMancc(String nhacc) {
        this.mancc = nhacc;
    }

    public String getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(String nhanvien) {
        this.nhanvien = nhanvien;
    }

    public String getNgaydh() {
        return ngaydh;
    }

    public void setNgaydh(String ngaydh) {
        this.ngaydh = ngaydh;
    }

    public String getTrangthaidh() {
        return trangthaidh;
    }

    public void setTrangthaidh(String trangthaidh) {
        this.trangthaidh = trangthaidh;
    }

    public String getCapnhattonkho() {
        return capnhattonkho;
    }

    public void setCapnhattonkho(String capnhattonkho) {
        this.capnhattonkho = capnhattonkho;
    }

    public int getTongslspdh() {
        return tongslspdh;
    }

    public void setTongslspdh(int tongslspdh) {
        this.tongslspdh = tongslspdh;
    }

    
    
}
