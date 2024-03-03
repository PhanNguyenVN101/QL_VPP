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
public class NhaCC {
    private String mancc,sdtncc,hotenncc,gioitinhncc,diachincc,sanphamcc;

    public NhaCC(String mancc, String sdtncc, String hotenncc, String gioitinhncc, String diachincc, String sanphamcc) {
        this.mancc = mancc;
        this.sdtncc = sdtncc;
        this.hotenncc = hotenncc;
        this.gioitinhncc = gioitinhncc;
        this.diachincc = diachincc;
        this.sanphamcc = sanphamcc;
    }

    public String getMancc() {
        return mancc;
    }

    public void setMancc(String mancc) {
        this.mancc = mancc;
    }

    public String getSdtncc() {
        return sdtncc;
    }

    public void setSdtncc(String sdtncc) {
        this.sdtncc = sdtncc;
    }

    public String getHotenncc() {
        return hotenncc;
    }

    public void setHotenncc(String hotenncc) {
        this.hotenncc = hotenncc;
    }

    public String getGioitinhncc() {
        return gioitinhncc;
    }

    public void setGioitinhncc(String gioitinhncc) {
        this.gioitinhncc = gioitinhncc;
    }

    public String getDiachincc() {
        return diachincc;
    }

    public void setDiachincc(String diachincc) {
        this.diachincc = diachincc;
    }

    public String getSanphamcc() {
        return sanphamcc;
    }

    public void setSanphamcc(String sanphamcc) {
        this.sanphamcc = sanphamcc;
    }
    
}
