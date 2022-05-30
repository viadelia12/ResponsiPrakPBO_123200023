/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.*;
import model.*;

/**
 *
 * @author user
 */
public class EditController {
    View_Input input;
    Model model;
    String id;
    
    public EditController(View_Input input, Model model, String id){
        this.input = input;
        this.model = model;
        this.id = id;
        
        String detailbarang[] = model.Barang(id);
        input.fNama.setText(detailbarang[1]);
        input.fMassa.setText(detailbarang[2]);
        input.fHarga.setText(detailbarang[3]);
        
        input.getSubmit().addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent ae){
               model.updateBarang(id,input.getNama(),input.getMassa(),input.getHarga());
               View_Lihat tabel = new View_Lihat();
               input.setVisible(false);
               ReadController Start = new ReadController(tabel,model);
           }
        });
        
        input.getKembali().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                View view = new View();
                input.setVisible(false);
                BarangController Start = new BarangController(view);                
            }
        });
        
        input.getReset().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                input.fNama.setText("");
                input.fMassa.setText("");
                input.fHarga.setText("");
            }
        });
    }
}
