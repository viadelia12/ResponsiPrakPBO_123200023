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
        
        try {
           String query = "SELECT * FROM `barang` WHERE nama='" +nama+"'"; 
           statement = koneksi.createStatement();
//           System.out.println(nama + " " + Massa + " " + Harga);
           ResultSet resultSet = statement.executeQuery(query);
           
            while (resultSet.next()){ 
                jmlData++;
            }
            statement.close();
            if (jmlData==0) {
                query = "INSERT INTO `barang` (`nama`,`massa`,`harga`) VALUES('"+nama+"', '"+massa+"', '"+harga+"')";
                statement = koneksi.createStatement();
                statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data sudah tersedia");
            }
        }catch(Exception ex){
           JOptionPane.showMessageDialog(null, "Data tidak berhasil ditambahkan!");
        }
    }
    
    public String[][] ReadBarang(){
        try{
            int jmlData = 0;
            String data[][] = new String[getData()][4]; //baris sesuai banyak data di db, kolom ada 4
            String query = "SELECT * FROM barang";
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                data[jmlData][0] = resultSet.getString("id");
                data[jmlData][1] = resultSet.getString("nama");
                data[jmlData][2] = resultSet.getString("massa");
                data[jmlData][3] = resultSet.getString("harga");
                jmlData++;
            }
            return data;
        }catch(Exception ex){
           JOptionPane.showMessageDialog(null, "Data masih kosong!");
           return null;
        }
    }
    
    public String[] Barang(String id){
        try{
            String data[] = new String[4];
            String query = "SELECT * FROM barang WHERE id = '"+id+"'";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                data[0] = resultSet.getString("id");
                data[1] = resultSet.getString("nama");
                data[2] = Double.toString(resultSet.getDouble("massa"));
                data[3] = Double.toString(resultSet.getDouble("harga"));
            }
            return data;
        }catch(Exception ex){
           JOptionPane.showMessageDialog(null, "Data tidak ditemukan!");
           return null;
        }
    }
    
    public void deleteBarang(String id){
        try{
            String query = "DELETE FROM barang WHERE id = '"+id+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
        }catch(Exception ex){
           JOptionPane.showMessageDialog(null, "Data tidak berhasil dihapus!");
        }
    }
    
    public void updateBarang(String id, String nama, double massa, double harga){
        int jmlData = 0;
        try{
            String query = "SELECT * FROM barang WHERE id='" + id+"'"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            if (jmlData==1) {
                query = "UPDATE barang SET nama='"+nama+"', massa='" + massa + "', harga='" + harga + "' WHERE id='" + id+"'"; 
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Data berhasil diupdate");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data Tidak Tersedia");
            }
        }catch(Exception ex){
           JOptionPane.showMessageDialog(null, "Data tidak berhasil diupdate!");
        }
    }
    
}
