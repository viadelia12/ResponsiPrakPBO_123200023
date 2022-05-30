/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author user
 */
public class Model {
    String DBurl = "jdbc:mysql://localhost/barang";
    String DBusername = "root";
    String DBpassword = "";
    Connection koneksi;
    Statement statement;
    
    public Model(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = (Connection) DriverManager.getConnection(DBurl,DBusername,DBpassword);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            System.out.println("Koneksi gagal");
        }
    }
    
    public int getData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from barang";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            return jmlData;
            
        }catch(Exception ex){
            return 0;
        }
    }
    
    public void InputBarang(String nama, double massa, double harga){
        int jmlData = 0;
        try{
           String query = "INSERT INTO `barang`(`nama`, `massa`, `harga`) VALUES ('"+nama+"', '"+massa+"', '"+harga+"')";
           statement.executeUpdate(query);
           JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!");
        }catch(Exception ex){
           JOptionPane.showMessageDialog(null, "Data tidak berhasil ditambahkan!");
        }
    }
}
