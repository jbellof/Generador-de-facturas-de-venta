/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.gfacturas.modelo;

/**
 *
 * @author LENOVO
 */
public class ImplementProductoDao implements productosDao{
ConexionSqlPost base = new ConexionSqlPost();
    @Override
    public boolean agregarproducto(Producto pro) {
       boolean registrado = false;
        String sql = "INSERT INTO productos(nombrep,costo) VALUES(?,?)";
     
        try {
            
            ConexionSqlPost.c = base.getConnection();
            ConexionSqlPost.st = ConexionSqlPost.c.prepareStatement(sql);
            ConexionSqlPost.st.setString(1, pro.getNombrep());
            ConexionSqlPost.st.setLong(2, pro.getCosto());
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

    @Override
    public Producto getProducto(Producto pro) {
        Producto producto = pro;
        String sql = "SELECT * FROM productos";
        try {
            ConexionSqlPost.c = base.getConnection();
            ConexionSqlPost.st = ConexionSqlPost.c.prepareStatement(sql);
            ConexionSqlPost.rs = ConexionSqlPost.st.executeQuery();
            while (ConexionSqlPost.rs.next()) {
                if(ConexionSqlPost.rs.getString(2).equals(pro.getNombrep())){
                    producto.setCodigo(ConexionSqlPost.rs.getInt(1));
                    producto.setCosto(ConexionSqlPost.rs.getInt(3));
                    producto.setEstado(ConexionSqlPost.rs.getString(4));
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return producto;
    }
    
}
