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
public class View extends JFrame{
    JLabel lMainMenu = new JLabel("Main Menu");
    JButton btnTambah = new JButton("Tambah Barang");
    JButton btnLihat = new JButton("Lihat Barang");


    public View(){
        setSize(190, 150);
        setVisible(true);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        
        setLayout(null);
        add(lMainMenu);
        add(btnTambah);
        add(btnLihat);

        lMainMenu.setBounds(50,10,120,20);
        btnTambah.setBounds(10, 40, 150, 20);
        btnLihat.setBounds(10, 80, 150, 20);
    }
    
    public JButton getTambah(){
        return btnTambah;
    }
    
    public JButton getLihat(){
        return btnLihat;
    }
}
