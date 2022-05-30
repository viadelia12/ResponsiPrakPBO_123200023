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
public class JumlahBarangController {
    String id;
    Model model = new Model();
    View_JumlahBarang viewjumlahbarang;
    
    public JumlahBarangController(View_JumlahBarang viewjumlahbarang, Model model, String id){
        this.viewjumlahbarang = viewjumlahbarang;
        this.model = model;
        this.id = id;
        String detailbarang[] = model.Barang(id);
        
        viewjumlahbarang.fNama.setText(detailbarang[1]);
        viewjumlahbarang.fMassa.setText(detailbarang[2]);
        viewjumlahbarang.fHarga.setText(detailbarang[3]);

        viewjumlahbarang.getKembali().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                View StartView = new View();
                viewjumlahbarang.setVisible(false);
                BarangController Start = new BarangController(StartView);
            }
        });
        
        viewjumlahbarang.getEdit().addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent ae){
               View_Input input = new View_Input();
               viewjumlahbarang.setVisible(false);
               EditController edit = new EditController(input,model,id);
           }
        });
        
        viewjumlahbarang.getHapus().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                int inputhapus = JOptionPane.showConfirmDialog(null,
                        "Apa anda ingin menghapus data barang dengan ID " + id + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

                if (inputhapus == 0) {
                    model.deleteBarang(id);    
                    View_Lihat viewlihat = new View_Lihat();
                    viewjumlahbarang.setVisible(false);
                    ReadController read = new ReadController(viewlihat, model);
                } else {
                    JOptionPane.showMessageDialog(null, "Data Tidak Jadi Dihapus");
                }
            }
        });
        
        viewjumlahbarang.getTotal().addActionListener(new ActionListener(){
           @Override
            public void actionPerformed(ActionEvent ae){
                View_TotalHarga totalharga = new View_TotalHarga();
                viewjumlahbarang.setVisible(false);
                totalharga.fNama.setText(detailbarang[1]);
                totalharga.fMassa.setText(detailbarang[2]);
                totalharga.fHarga.setText(detailbarang[3]);
                double tot_harga = Double.parseDouble(detailbarang[3]);
                String jumlah = viewjumlahbarang.getJumlah().getText();
                double inputan = Double.parseDouble(jumlah);
                
                if(inputan<1){
                    JOptionPane.showMessageDialog(null, "Jumlah Barang Minimal 1");
                }else if(inputan>=1 && inputan<12){
                    double total = inputan*tot_harga;
                    String hasil = Double.toString(total);
                    totalharga.fTotalHarga.setText(hasil);
                }else if(inputan>=12 && inputan<20){
                    double total = inputan*tot_harga*0.95;
                    String hasil = Double.toString(total);
                    totalharga.fTotalHarga.setText(hasil);
                }else if(inputan>=20 && inputan<144){
                    double total = inputan*tot_harga*0.9;
                    String hasil = Double.toString(total);
                    totalharga.fTotalHarga.setText(hasil);
                }else{
                    double total = inputan*tot_harga*0.75;
                    String hasil = Double.toString(total);
                    totalharga.fTotalHarga.setText(hasil);
                }
                
                totalharga.getKembali().addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae){
                        View_Lihat tabel = new View_Lihat();
                        totalharga.setVisible(false);
                        ReadController Start = new ReadController(tabel, model);
                    }
                });
            }
           
        });
    }
}
