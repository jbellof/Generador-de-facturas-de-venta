/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.gfacturas.modelo;

import javax.swing.JFileChooser;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author LENOVO
 */
public class Directorio {

    JButton go;

    JFileChooser chooser;
    String choosertitle;

    public void direct() {
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle(choosertitle);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        System.out.println("thsisbihwgiua" + JFileChooser.DIRECTORIES_ONLY);
        //
        // disable the "All files" option.
        //
        chooser.setAcceptAllFileFilterUsed(false);
        //    
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): "
                    + chooser.getCurrentDirectory());
            System.out.println("getSelectedFile() : "
                    + chooser.getSelectedFile());
            PlantillaPDF pla = new  PlantillaPDF("cristian", "cristian", "juan", "ayer", "pasivo");
            pla.crearPlantilla(String.valueOf(chooser.getSelectedFile()));
        } else {
            System.out.println("No Selection ");
        }
    }
}
