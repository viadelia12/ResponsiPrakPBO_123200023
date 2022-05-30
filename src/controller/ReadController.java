/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.*;
import javax.swing.*;
import view.*;
import model.*;

/**
 *
 * @author user
 */
public class ReadController {
    Model model;
    View_Lihat view_lihat;
    
    public ReadController(View_Lihat view_lihat, Model model){
        this.model = model;
        this.view_lihat = view_lihat;
        
        if(model.getData()!=0){
            String dataBarang[][] = model.ReadBarang();
            view_lihat.tabel.setModel((new JTable(dataBarang, view_lihat.namaKolom)).getModel());
        }else {
            JOptionPane.showMessageDialog(null, "Data Tidak Tersedia");
        }
        
        view_lihat.getKembali().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                View StartView = new View();
                view_lihat.setVisible(false);
                BarangController Start = new BarangController(StartView);
            }
        });
        
        view_lihat.tabel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                super.mousePressed(e);
                int baris = view_lihat.tabel.getSelectedRow();
                String selected = view_lihat.tabel.getValueAt(baris, 0).toString();
                View_JumlahBarang jb = new View_JumlahBarang();
                view_lihat.setVisible(false);
                JumlahBarangController jbcontroller=new JumlahBarangController(jb,model,selected);
                
            }

        });
        
    }
}
