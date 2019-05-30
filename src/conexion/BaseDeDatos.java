/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Alicer
 */
public class BaseDeDatos {
    private final String URL = "jdbc:mysql://tcp.ngrok.io:16506/"; // Ubicación de la BD.
    private final String BD = "cafebar"; // Nombre de la BD.
    private final String USER = "freddy";
    private final String PASSWORD = "freddy";

    public Connection conexion = null;

    @SuppressWarnings("finally")
    public Connection conectar() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(URL + BD, USER, PASSWORD);
            if (conexion != null) {
                System.out.println("¡Conexión Exitosa!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return conexion;
        }
    }
}