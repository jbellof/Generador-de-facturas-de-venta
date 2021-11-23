/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.software.gfacturas.modelo;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Cristian Castro
 */
public class ConexionSqlPost {
    Connection con;
    public static PreparedStatement st;
    public static ResultSet rs;
    public static Connection c;
    /*
    import java.sql.*;
    public  PreparedStatement st;
    public  ResultSet rs;
    public  Connection c;
    */
    public Connection getConnection() {
        try {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //con = DriverManager.getConnection("jdbc:postgresql://node5107-tarcinesoft.sp.skdrive.net:5432/postgres","webadmin","PZtiGgnYhL");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/gFacturas","postgres","1234");
        } catch (SQLException e) {
            System.out.println("holax2");
            e.printStackTrace();
        }
        return con;
    }
}
