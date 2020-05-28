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
public class PowerSource implements Serializable {

    private int id;
    private String description;
    
    
    //Empty constructor for Seriizable rules
    public PowerSource() {
    }

    public PowerSource(int id) {
        this.id = id;
    }

    public PowerSource(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}