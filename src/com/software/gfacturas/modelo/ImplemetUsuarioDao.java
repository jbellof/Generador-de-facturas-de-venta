/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.software.gfacturas.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cristian Castro
 */
public class ImplemetUsuarioDao implements usuarioDAO {

    ConexionSqlPost base = new ConexionSqlPost();
    
    @Override
    public boolean existeUsuario(Usuario usu) {
        boolean existe = false;
        String sql = "SELECT * FROM usuarios;";//userName,password
        try {
            ConexionSqlPost.c = base.getConnection();
            ConexionSqlPost.st = ConexionSqlPost.c.prepareStatement(sql);
            ConexionSqlPost.rs = ConexionSqlPost.st.executeQuery();
            while (ConexionSqlPost.rs.next()) {
                if (ConexionSqlPost.rs.getString(3).trim().equals(usu.getUserName()) && ConexionSqlPost.rs.getString(4).trim().equals(usu.getPassword())) {
                    //System.out.println("entró");
                    existe = true;
                    break;
                }
            }
            ConexionSqlPost.c.close();
            ConexionSqlPost.st.close();
            ConexionSqlPost.rs.close();

        } catch (Exception e) {
            System.out.println("hola");
            e.printStackTrace();
            return false;
        }
        return existe;
    }

    @Override
    public boolean registrarUsuario(Usuario usu) {
        boolean registrado = false;
        String sql = "INSERT INTO usuarios VALUES(?,?,?,?)";// (id,nombre,user,Password)
        usu.setId(usu.getId());
        while (ValidarID(usu.getIdem())) {
            usu.setId(usu.getId());
        }

        try {
            
            ConexionSqlPost.c = base.getConnection();
            ConexionSqlPost.st = ConexionSqlPost.c.prepareStatement(sql);
            ConexionSqlPost.st.setString(1, usu.getIdem());
            ConexionSqlPost.st.setString(2, usu.getNombreC());
            ConexionSqlPost.st.setString(3, usu.getUserName());
            ConexionSqlPost.st.setString(4, usu.getPassword());
            int rowInsert = ConexionSqlPost.st.executeUpdate();
            if(rowInsert > 0){
                System.out.println("hhhhhhhh");
                registrado = true;
            }
            ConexionSqlPost.c.close();
            ConexionSqlPost.st.close();
            
            
        } catch (Exception e) {
            e.printStackTrace();
            registrado = false;
        }
        return registrado;
    }
    public boolean ValidarID(String id) {
        boolean existe = false;
        String sql = "SELECT * FROM usuarios";
        try {
            ConexionSqlPost.c = base.getConnection();
            ConexionSqlPost.st = ConexionSqlPost.c.prepareStatement(sql);
            ConexionSqlPost.rs = ConexionSqlPost.st.executeQuery();
            while (ConexionSqlPost.rs.next()) {
                if(ConexionSqlPost.rs.getString(1).equals(id)){
                    existe = true;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            existe = false;
        }
        return existe;
    }

    @Override
    public Usuario obtenerUsuario(String name, String pass) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (!existeUsuario(new Usuario("", name, pass))) {
            return null;
        }
        Usuario usu = null;
        String sql = "SELECT * FROM usuarios;";
        try {
            ConexionSqlPost.c = base.getConnection();
            ConexionSqlPost.st = ConexionSqlPost.c.prepareStatement(sql);
            ConexionSqlPost.rs = ConexionSqlPost.st.executeQuery();

            while (ConexionSqlPost.rs.next()) {
                if (ConexionSqlPost.rs.getString(3).trim().equals(name) && ConexionSqlPost.rs.getString(4).trim().equals(pass)) {
                    usu = new Usuario(ConexionSqlPost.rs.getString(2), ConexionSqlPost.rs.getString(3), ConexionSqlPost.rs.getString(4));
                    usu.setId(ConexionSqlPost.rs.getString(1));
                    break;
                }
            }

            ConexionSqlPost.c.close();
            ConexionSqlPost.st.close();
            ConexionSqlPost.rs.close();

        } catch (Exception e) {
            System.out.println("com.software.gfacturas.modelo.ImplemetUsuarioDao.obtenerUsuario()");
            e.printStackTrace();
        }
        return usu;
    }
    public List<Producto> getPro(){
        List<Producto> Names = new ArrayList<>();
        String sql = "SELECT * FROM productos;";
        try {
            ConexionSqlPost.c = base.getConnection();
            ConexionSqlPost.st = ConexionSqlPost.c.prepareStatement(sql);
            ConexionSqlPost.rs = ConexionSqlPost.st.executeQuery();

            while (ConexionSqlPost.rs.next()) {
                Names.add(new Producto(ConexionSqlPost.rs.getString(2), 0));
            }

            ConexionSqlPost.c.close();
            ConexionSqlPost.st.close();
            ConexionSqlPost.rs.close();

        } catch (Exception e) {
            
            e.printStackTrace();
        }
        return Names;
    }
    @Override
    public boolean vUsu(String name) {
        boolean existe = false;
        String sql = "SELECT * FROM usuarios";
        try {
            ConexionSqlPost.c = base.getConnection();
            ConexionSqlPost.st = ConexionSqlPost.c.prepareStatement(sql);
            ConexionSqlPost.rs = ConexionSqlPost.st.executeQuery();
            while (ConexionSqlPost.rs.next()) {
                if (ConexionSqlPost.rs.getString(3).equals(name)) {
                    existe = true;
                    break;
                }
            }

            ConexionSqlPost.c.close();
            ConexionSqlPost.st.close();
            ConexionSqlPost.rs.close();

        } catch (Exception e) {
            System.out.println("sdvhuevuyewsdguegiegwisgewuiguiewfsgiuewgiewfg");
            existe = false;
            e.printStackTrace();
        }
        return existe;
    }

}
