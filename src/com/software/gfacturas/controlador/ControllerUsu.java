/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.software.gfacturas.controlador;

import com.software.gfacturas.modelo.*;
import java.util.List;

/**
 *
 * @author Cristian Castro
 */
public class ControllerUsu {
    
    ImplemetUsuarioDao im = new ImplemetUsuarioDao();
    
    public Usuario getUsuario(String name,String pass){
        return im.obtenerUsuario(name, pass);
    }
    public boolean existe(String user){
        return im.vUsu(user);
    }
    public boolean registro(Usuario usu){
        return im.registrarUsuario(usu);
    }
    public List<Producto> getNameProductos(){
        return im.getPro();
    }
}
