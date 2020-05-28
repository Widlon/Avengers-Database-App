/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.nishu_widlon_a2.taghandlers;


import com.mycompany.nishu_widlon_a2.model.PowerSource;
import com.mycompany.nishu_widlon_a2.model.PowerSourceDb;
import java.util.ArrayList;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author nishu
 */
public class PowerSourceHandler extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException {
        
        try {
            
            JspWriter out = getJspContext().getOut();
            ArrayList<PowerSource> powerSources = PowerSourceDb.getPowerSources();
            
            try {
                out.print("<select name='powerSources'>");
                for (int i = 0; i < powerSources.size(); i++) {
                    out.print("<option value = '"+powerSources.get(i).getId()+"'>"
                            + powerSources.get(i).getDescription() + "</option>");
                }
                out.print("</select>");
                
                JspFragment f = getJspBody();
                if (f != null) {
                    f.invoke(out);
                }
                
            } catch (java.io.IOException ex) {
                throw new JspException("Error in HelloTag tag", ex);
            }
            
        } catch (Exception ex) {
                throw new JspException("Error in HelloTag tag", ex);
        }

    }

}