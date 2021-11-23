/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.software.gfacturas.modelo;

import java.util.Random;

/**
 *
 * @author Cristian Castro
 */
public class Usuario {
    private String id,nombreC,userName,password;
    private String cod;
    public Usuario(String nombreC, String userName, String password) {
        this.nombreC = nombreC;
        this.userName = userName;
        this.password = password;
    }
    

    public String getId() {
        int i = (int) Math.floor(Math.random() * (999 - 100 + 1) + 100);//(int) Math.floor(Math.random() * (999 - 2 + 1) + 2);
        Random random = new Random();
        String a = "";
        for (int j = 0; j < 3; j++) {
            char randomizedCharacter = (char) (random.nextInt(26) + 'a');
            a += randomizedCharacter;
        }
        id = a + i;
        return id;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }
    

    public void setId(String id) {
        this.id = id;
    }
    public String getIdem(){
        return id;
    }

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
