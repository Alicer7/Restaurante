/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import restaurante.personal;

/**
 *
 * @author Alicer
 */
public class Conector {

    private PreparedStatement psInsertar;
    private Statement stmt;
    private Connection conn;

    public void insertar(personal p) throws  SQLException{
        String url= "jdbc:mysql://localhost:3306/cafebar?user=root"; 
        conn = DriverManager.getConnection(url); 
        stmt = conn.createStatement();
        psInsertar = conn.prepareStatement("insert into "); 
        
        
    }

}
