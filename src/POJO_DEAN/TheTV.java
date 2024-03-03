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
public class TheTV {
    private String mathe,makh,ngaylapthe;
    private int tichdiem;

    public TheTV(String mathe, String makh, String ngaylapthe, int tichdiem) {
        this.mathe = mathe;
        this.makh = makh;
        this.ngaylapthe = ngaylapthe;
        this.tichdiem = tichdiem;
    }

    
    public String getMathe() {
        return mathe;
    }

    public void setMathe(String mathe) {
        this.mathe = mathe;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getNgaylapthe() {
        return ngaylapthe;
    }

    public void setNgaylapthe(String ngaylapthe) {
        this.ngaylapthe = ngaylapthe;
    }

    public int getTichdiem() {
        return tichdiem;
    }

    public void setTichdiem(int tichdiem) {
        this.tichdiem = tichdiem;
    }
    
    
}
