/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.nishu_widlon_a2.model;

import java.io.Serializable;


/**
 *
 * @author nishu
 */
 
public class Avenger implements Serializable{
    
    private int id;
    private String name;
    private String description;
    private PowerSource powerSource;


    public Avenger() {
    }

    public Avenger(String name, String description, PowerSource powerSource) {
        this.name = name;
        this.description = description;
        this.powerSource = powerSource;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PowerSource getPowerSource() {
        return powerSource;
    }

    public void setPowerSource(PowerSource powerSource) {
        this.powerSource = powerSource;
    }
    
    

}
