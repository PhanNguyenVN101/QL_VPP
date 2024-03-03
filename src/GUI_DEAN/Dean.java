/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_DEAN;

import javax.swing.JFrame;

/**
 *
 * @author doanc
 */
public class Dean extends JFrame{
  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        
        LoadForm load = new LoadForm();
        load.setVisible(true);
        FormDangNhap sign = new FormDangNhap();
        
        try {
            for (int i=0;i<=100;i++)
            {
                Thread.sleep(25);
                load.lbl_load.setText(Integer.toString(i)+"%");
                load.loadingbar.setValue(i);
                if(i==100)
                {
                    load.setVisible(false);
                    sign.setVisible(true);
                }
            }
        }catch(Exception e){
    }
    }

   
}
