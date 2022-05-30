/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.*;

/**
 *
 * @author user
 */
public class View_JumlahBarang extends JFrame{
    JLabel lNama = new JLabel("Nama");
    public JLabel fNama = new JLabel();
    JLabel lMassa = new JLabel("Massa(gr)");
    public JLabel fMassa = new JLabel();
    JLabel lHarga = new JLabel("Harga Satuan");
    public JLabel fHarga = new JLabel();
    
    JLabel lJumlah = new JLabel("Banyak");
    JTextField fJumlah = new JTextField();
    
    JButton bTotal = new JButton("Total Harga");
    JButton bKembali = new JButton("Kembali");
    JButton bEdit = new JButton("Edit");
    JButton bHapus = new JButton("Hapus");
    
    public View_JumlahBarang(){
        setTitle("Barang");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(330,230);
        setLocationRelativeTo(null);
        
        add(lNama);
        add(fNama);
        add(lMassa);
        add(fMassa);
        add(lHarga);
        add(fHarga);
        add(lJumlah);
        add(fJumlah);
        add(bTotal);
        add(bKembali);
        add(bEdit);
        add(bHapus);
        
        
        lNama.setBounds(10, 10, 180, 20);
        fNama.setBounds(120, 10, 180, 20);
        lMassa.setBounds(10, 40, 180, 20);
        fMassa.setBounds(120, 40, 180, 20);
        lHarga.setBounds(10, 70, 180, 20);
        fHarga.setBounds(120, 70, 180, 20);
        lJumlah.setBounds(10, 100, 180, 20);
        fJumlah.setBounds(120, 100, 180, 20);
        bTotal.setBounds(100, 130, 100, 20);
        bKembali.setBounds(10, 160, 90, 20);
        bEdit.setBounds(110, 160, 90, 20);
        bHapus.setBounds(210, 160, 90, 20);
    }
    
    public JButton getTotal(){
        return bTotal;
    }
    
    public JButton getKembali(){
        return bKembali;
    }
    
    public JButton getEdit(){
        return bEdit;
    }
    
    public JButton getHapus(){
        return bHapus;
    }
    
    public JTextField getJumlah(){
        return fJumlah;
    }
}
