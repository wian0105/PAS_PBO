/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.koneksi;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author USER
 */
public class koneksi {
    private static Connection con;
    public static Connection getcon() {
            if (con == null) {
                try {
                    String url = "jdbc:mysql://localhost/pas_pbo";
                    String username = "root";
                    String password = "";
                    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                    con = DriverManager.getConnection(url, username , password);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        return con;
}
}
