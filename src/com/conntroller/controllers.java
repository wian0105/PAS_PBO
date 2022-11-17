/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.conntroller;

import com.view.view;
import java.sql.*;

/**
 *
 * @author USER
 */
public interface controllers {
    public void simpan(view v) throws SQLException;
    public void ubah(view v) throws SQLException;
    public void hapus(view v) throws SQLException;
    public void reset(view v) throws SQLException;
    public void tampil(view v) throws SQLException;
    public void klikTable(view v) throws SQLException;
}
