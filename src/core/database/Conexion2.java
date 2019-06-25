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
 * @author freddy
 */
public class Conexion2 {
    private final String port="3306";
    private final String url = "jdbc:mysql://192.168.8.101:"+port+"/"; // Ubicación de la BD.
    private final String db = "cafebar"; // Nombre de la BD.
    private final String user = "freddy";
    private final String password = "freddy";
    
    private Connection DBConnection;
    public Connection connect(){
    
        try{
            Class.forName("com.mysql.jdbc.Driver");         
        }
        catch(ClassNotFoundException cnfe){
            System.out.println("Driver not found" + cnfe);
        }                
        try{
          DBConnection=DriverManager.getConnection(url+db,user,password);
          System.out.println("Database Connected");
        }
        catch(SQLException se){
          System.err.println("Database Not Found");  
        }
        System.out.println("Database Succesfull");
        return DBConnection;        
    }
}
