/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.software.gfacturas.modelo;

/**
 *
 * @author Cristian Castro
 */
public interface usuarioDAO {
    public boolean existeUsuario(Usuario usu);
    public boolean registrarUsuario(Usuario usu);
    public Usuario obtenerUsuario(String name,String pass);
    public boolean vUsu(String name);
}
