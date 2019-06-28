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
//     private final String URL = "jdbc:mysql://192.168.1.2:3306/"; // Ubicación de la BD.
//    private final String BD = "cafebar"; // Nombre de la BD.
//    private final String USER = "freddy";
//    private final String PASSWORD = "freddy";
//    
//    private final String URL = "jdbc:mysql://localhost:3306/"; // Ubicación de la BD.
//    private final String BD = "cafebar"; // Nombre de la BD.
//    private final String USER = "root";
//    private final String PASSWORD = "333561222587421319";
    
//    private final String port="3306";
//    private final String url = "jdbc:mysql://192.168.1.2:"+port+"/"; // Ubicación de la BD.
//    private final String db = "cafebar"; // Nombre de la BD.
//    private final String user = "root";
////    private final String password = "333561222587421319";
//    private final String password = "fe95aca7184807452_7";
    
    private final String port="3306";
    private final String url = "jdbc:mysql://dbsx.cnou9bzubn5m.us-east-2.rds.amazonaws.com:"+port+"/"; // Ubicación de la BD.
    private final String db = "cafebar"; // Nombre de la BD.
    private final String user = "freddy";
    private final String password = "%Freddy101";
    
    private Connection DBConnection;
    
    public Connection connect(){
    
        try{
            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("MySQL Driver OK");
        } catch(ClassNotFoundException cnfe){
            System.err.println("Driver not found" + cnfe);
        }                
        try{
          DBConnection=DriverManager.getConnection(url+db,user,password);
//          System.out.println("DB conection up");
        } catch(SQLException se){
          System.err.println("Database Not Found");  
        }
        return DBConnection;        
    }
    
}
