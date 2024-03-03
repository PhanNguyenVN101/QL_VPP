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
public class HoaDon {
    private String mahd;
    private int tongsl,tongtienhd,giamgia,thanhtien;
    private String trangthai, tg;

    public HoaDon(String mahd, int tongsl, int tongtienhd, int giamgia, int thanhtien, String trangthai, String tg) {
        this.mahd = mahd;
        this.tongsl = tongsl;
        this.tongtienhd = tongtienhd;
        this.giamgia = giamgia;
        this.thanhtien = thanhtien;
        this.trangthai = trangthai;
        this.tg = tg;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public int getTongsl() {
        return tongsl;
    }

    public void setTongsl(int tongsl) {
        this.tongsl = tongsl;
    }

    public int getTongtienhd() {
        return tongtienhd;
    }

    public void setTongtienhd(int tongtienhd) {
        this.tongtienhd = tongtienhd;
    }

    public int getGiamgia() {
        return giamgia;
    }

    public void setGiamgia(int giamgia) {
        this.giamgia = giamgia;
    }

    public int getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public String getTg() {
        return tg;
    }

    public void setTg(String tg) {
        this.tg = tg;
    }

    
    
}
