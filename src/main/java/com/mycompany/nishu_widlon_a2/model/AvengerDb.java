/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.nishu_widlon_a2.model;

import com.mycompany.nishu_widlon_a2.db.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author nishu
 */


public class AvengerDb {

    public static Connection conn = null;
    public static PreparedStatement ps = null;
    public static ResultSet rs = null;
    public static String driver = "org.postgresql.Driver";

    public static ArrayList<Avenger> getAvengers() throws Exception {

        ArrayList<Avenger> avengers = new ArrayList<>();

        //initialize database
        try {

            connectDataBase();
            String sql = "SELECT * FROM avengers";

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                int powerSourceID = rs.getInt("powerSource");
                String avengerName = rs.getString("avengername");
                String description = rs.getString("description");

                PowerSource powerSource = PowerSourceDb.getPowerSource(powerSourceID);

                avengers.add(new Avenger(avengerName, description, powerSource));
            }

        } catch (ClassNotFoundException ex) {
            throw new Exception(ex.toString());
        } catch (SQLException ex) {
            throw new Exception(ex.toString());
        } finally {
            DBConnector.closeJDBCObjects(conn, ps, rs);

        }

        return avengers;
    }

    //This method gets the user inputs to create and save a new avenger character to the database
    public static int addAvenger(Avenger avenger) throws Exception {

        //Initialize data
        try {
            connectDataBase();

            String name = avenger.getName();//getting name
            String description = avenger.getDescription();//getting description
            int powerSource = avenger.getPowerSource().getId();

            String sql = "INSERT INTO Avengers(avengerName, description, powerSource) "
                    + "VALUES(?,?,?)";

            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setInt(3, powerSource);
            int psNumber = ps.executeUpdate();

            return psNumber;
        } catch (ClassNotFoundException ex) {
            throw new Exception(ex.toString());
        } catch (SQLException ex) {
            throw new Exception(ex.toString());
        } finally {
            DBConnector.closeJDBCObjects(conn, ps, rs);
        }

    }

    // Connect to DataBase
    public static Connection connectDataBase() throws Exception {

        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        if (dbUrl != null && dbUrl.length() > 0) {
            conn = DBConnector.getConnection(driver, dbUrl);
        } else {
            String connUrl = "jdbc:postgresql://localhost/";
            String database = "Widlon";
            String user = "postgres";
            String pass = "Nishu123";

            conn = DBConnector.getConnection(driver, connUrl,
                    database, user, pass);
        }
        return conn;
    }
}
