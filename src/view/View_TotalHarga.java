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
public class View_TotalHarga extends JFrame{
    JLabel lNama = new JLabel("Nama");
    public JLabel fNama = new JLabel();
    JLabel lMassa = new JLabel("Massa(gr)");
    public JLabel fMassa = new JLabel();
    JLabel lHarga = new JLabel("Harga Satuan");
    public JLabel fHarga = new JLabel();
    JLabel lTotalHarga = new JLabel("Total Harga");
    public JLabel fTotalHarga = new JLabel();
    
    JButton bKembali = new JButton("Kembali");
    
    public View_TotalHarga(){
        setTitle("Detail Barang");
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
        add(lTotalHarga);
        add(fTotalHarga);
        add(bKembali);
        
        lNama.setBounds(10, 10, 180, 20);
        fNama.setBounds(120, 10, 180, 20);
        lMassa.setBounds(10, 40, 180, 20);
        fMassa.setBounds(120, 40, 180, 20);
        lHarga.setBounds(10, 70, 180, 20);
        fHarga.setBounds(120, 70, 180, 20);
        lTotalHarga.setBounds(10, 100, 180, 20);
        fTotalHarga.setBounds(120, 100, 180, 20);
        bKembali.setBounds(10, 130, 100, 20);
    }
    
    public JButton getKembali() {
        return bKembali;
    }
}
