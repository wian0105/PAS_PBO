/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

import com.conntroller.controllers;
import com.koneksi.koneksi;
import com.view.view;
import java.io.Externalizable;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class model implements controllers{

    @Override
    public void simpan(view v) throws SQLException {
        try {
            Connection con = koneksi.getcon();
            String sql = "INSERT INTO barang VALUES(?,?,?,?)";
            PreparedStatement stt = con.prepareStatement(sql);
            stt.setInt(1, Integer.parseInt(v.txtId.getText()));
            stt.setString(2, v.txtNama.getText());
            stt.setString(3, v.txtJenis.getText());
            stt.setInt(4, Integer.parseInt(v.txtJml.getText()));
            stt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
            stt.close();
            reset(v);
        } catch (Exception e) {
            System.out.println(e);
        } finally{
            tampil(v);
            v.setLebarKolom();
        }
        
    }

    @Override
    public void ubah(view v) throws SQLException {
        try {
            Connection con = koneksi.getcon();
            String sql = "UPDATE barang SET nama=?, jenis=?, jumlah=? WHERE id=?";
            PreparedStatement stt = con.prepareStatement(sql);
            stt.setInt(4, Integer.parseInt(v.txtId.getText()));
            stt.setString(1, v.txtNama.getText());
            stt.setString(2, v.txtJenis.getText());
            stt.setInt(3, Integer.parseInt(v.txtJml.getText()));
            stt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
            stt.close();
            reset(v);
        } catch (Exception e){
            System.out.println(e);
        }finally {
            tampil(v);
            v.setLebarKolom();
        }
    }

    @Override
    public void hapus(view v) throws SQLException {
        try {
            Connection con = koneksi.getcon();
            String sql = "DELETE FROM barang WHERE id=?";
            PreparedStatement stt = con.prepareStatement(sql);
            stt.setInt(1, Integer.parseInt(v.txtId.getText()));
            stt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus");
            stt.close();
            reset(v);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            tampil(v);
            v.setLebarKolom();
        }
    }

    @Override
    public void reset(view v) throws SQLException {
        v.txtId.setText("");
        v.txtNama.setText("");
        v.txtJenis.setText("");
        v.txtJml.setText("");
    }

    @Override
    public void tampil(view v) throws SQLException {
        v.tblmodel.getDataVector().removeAllElements();
        v.tblmodel.fireTableDataChanged();
        
        try {
            Connection con = koneksi.getcon();
            Statement stt = con.createStatement();
            String sql = "SELECT * FROM barang ORDER BY id ASC";
            ResultSet rs = stt.executeQuery(sql);
            while (rs.next()) {                
                Object[] ob = new Object[8];
                ob[0] = rs.getString(1);
                ob[1] = rs.getString(2);
                ob[2] = rs.getString(3);
                ob[3] = rs.getString(4);
                v.tblmodel.addRow(ob);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void klikTable(view v) throws SQLException {
        try {
            int pilih = v.tbl.getSelectedRow();
            v.txtId.setText(v.tblmodel.getValueAt(pilih, 0).toString());
            v.txtNama.setText(v.tblmodel.getValueAt(pilih, 1).toString());
            v.txtJenis.setText(v.tblmodel.getValueAt(pilih, 2).toString());
            v.txtJml.setText(v.tblmodel.getValueAt(pilih, 3).toString());
          
        } catch (Exception e) {
            
        }
    }
    
}
