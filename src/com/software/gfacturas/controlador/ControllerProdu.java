/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.gfacturas.controlador;

import com.software.gfacturas.modelo.ImplementProductoDao;
import com.software.gfacturas.modelo.Producto;

/**
 *
 * @author LENOVO
 */
public class ControllerProdu {
    ImplementProductoDao im = new ImplementProductoDao();
    public boolean agreagarProducto(Producto pro){
        return im.agregarproducto(pro);
    }
    public Producto getPro(Producto pro){
        return im.getProducto(pro);
    }
}
