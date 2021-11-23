/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.gfacturas.modelo;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class PlantillaPDF {
    String nombre;
    String cliente;
    String productos;
    String fecha;
    String estado;
    String total;
    
    
    Document documento;
    FileOutputStream archivo;
    Paragraph titulo;

    public PlantillaPDF(String cliente,String productos,String fecha,String estado,String total){
        this.total = total;
        this.cliente = cliente;
        this.productos = productos;
        this.fecha = fecha;
        this.estado= estado;
        
        documento=new Document();
        titulo = new  Paragraph("Factura");
    }
  public void crearPlantilla(String root){
    try {
        
        archivo = new  FileOutputStream(root+"\\Factura.pdf");
        PdfWriter.getInstance(documento, archivo);
        documento.open();
        titulo.setAlignment(1);
        
        documento.add(titulo);
        documento.add(new Paragraph("Cliente: "  + cliente));
        documento.add(new Paragraph("Fecha: "  + fecha));
        documento.add(new Paragraph("Productos: "  + productos));
        documento.add(Chunk.NEWLINE);
        documento.add(new Paragraph("TOTAL: "  + total));
        documento.add(Chunk.NEWLINE);
         
         //Paragraph texto = new Paragraph("factura de ventas ");
         //texto.setAlignment(Element.ALIGN_JUSTIFIED);
         //documento.add(texto);
         
           documento.add(Chunk.NEWLINE);
           
            documento.add(new Paragraph("Estado: "  + estado));
            documento.close();
            System.out.println("archivo creado");
    }   catch (FileNotFoundException ex) {
            Logger.getLogger(PlantillaPDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(PlantillaPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
}
