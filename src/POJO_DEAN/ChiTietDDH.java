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
public class ChiTietDDH {
    private String masp,tensp;
    private int soluongdat;

    public ChiTietDDH(String masp, String tensp, int soluongdat) {
        this.masp = masp;
        this.tensp = tensp;
        this.soluongdat = soluongdat;
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

    public int getSoluongdat() {
        return soluongdat;
    }

    public void setSoluongdat(int soluongdat) {
        this.soluongdat = soluongdat;
    }

    
    
    
}
