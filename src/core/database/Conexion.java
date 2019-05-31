/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Alicer
 */
public class Conexion {
//    private final String URL = "jdbc:mysql://tcp.ngrok.io:17152/"; // Ubicación de la BD.
//    private final String BD = "cafebar"; // Nombre de la BD.
//    private final String USER = "freddy";
//    private final String PASSWORD = "freddy";
    
    
     private final String URL = "jdbc:mysql://localhost:3306/"; // Ubicación de la BD.
    private final String BD = "cafebar"; // Nombre de la BD.
    private final String USER = "root";
    private final String PASSWORD = "";


    public Connection conexion_7 = null;

    @SuppressWarnings("finally")
    public Connection conectar() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion_7 = DriverManager.getConnection(URL + BD, USER, PASSWORD);
            if (conexion_7 != null) {
                System.out.println("¡Conexión Exitosa!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return conexion_7;
        }
    }
}