/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.nishu_widlon_a2.db.Servlets;

import com.mycompany.nishu_widlon_a2.model.Avenger;
import com.mycompany.nishu_widlon_a2.model.AvengerDb;
import com.mycompany.nishu_widlon_a2.model.PowerSource;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author nishu
 */

public class AddAvenger extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        int addSucefully = 0;

        try (PrintWriter out = response.getWriter()) {

            //Requesting user inputs to create new Avanger
            String avengerName = request.getParameter("avengerName");
            String avengerDescription = request.getParameter("avengerDescription");
            String powerSources = request.getParameter("powerSources");

            writeHeader(out);

            if (avengerName.trim().equals("") || avengerDescription.trim().equals("")) {
                
                out.println("<h1> Please fill blank</h1>");
                
            } else {
                
                //Getting list from AvengerDb class and creating new Avanger instance.
                addSucefully = AvengerDb.addAvenger(new Avenger(avengerName, avengerDescription,
                        new PowerSource(Integer.valueOf(powerSources))));
                
                if (addSucefully == 1) {
                    out.println("<h1> Avenger added successfully</h1>");
                } else {
                    out.println("<h1> Avenger added fail</h1>");
                }
            }

            writeFooter(out);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

    }

}

