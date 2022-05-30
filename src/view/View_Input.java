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
public class View_Input extends JFrame{
    JLabel lInput = new JLabel("Input Barang");
    JLabel lNama = new JLabel("Nama");
    public JTextField fNama = new JTextField();
    JLabel lMassa = new JLabel("Massa(gr)");
    public JTextField fMassa = new JTextField();
    JLabel lHarga = new JLabel("Harga Satuan");
    public JTextField fHarga = new JTextField();
    
    JButton bSubmit = new JButton("Submit");
    JButton bReset = new JButton("Reset");
    JButton bKembali = new JButton("Kembali");
    
    public View_Input(){
        setSize(340, 240);
        setTitle("Input Barang");
        setVisible(true);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        
        setLayout(null);
        add(lInput);
        add(lNama);
        add(fNama);
        add(lMassa);
        add(fMassa);
        add(lHarga);
        add(fHarga);
        add(bSubmit);
        add(bReset);
        add(bKembali);
        

        lInput.setBounds(10,10,100,20);
        lNama.setBounds(10, 40, 180, 20);
        fNama.setBounds(120, 40, 180, 20);
        lMassa.setBounds(10, 70, 180, 20);
        fMassa.setBounds(120, 70, 180, 20);
        lHarga.setBounds(10, 100, 180, 20);
        fHarga.setBounds(120, 100, 180, 20);
        bSubmit.setBounds(50, 130, 100, 20);
        bReset.setBounds(160, 130, 100, 20);
        bKembali.setBounds(10, 160, 300, 20);
    }
    
    public String getNama(){
        return fNama.getText();
    }
    
    public double getMassa() {
        double massa=Double.parseDouble(fMassa.getText());                
        return massa;
    }
    
    public double getHarga() {
        double harga=Double.parseDouble(fHarga.getText());                
        return harga;
    }
    
    public JButton getSubmit(){
        return bSubmit;
    }
    
    public JButton getReset(){
        return bReset;
    }
    
    public JButton getKembali(){
        return bKembali;
    }
}
