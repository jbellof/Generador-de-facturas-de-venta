/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.gfacturas.modelo;

import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface productosDao {
    public boolean  agregarproducto(Producto pro);
    public Producto getProducto(Producto pro);
}
