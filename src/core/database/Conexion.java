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
    private final String host = "192.168.10.11";
//    private final String host = "localhost";
    private final String port="3306";
    private final String db = "cafebar"; // Nombre de la BD.
//    private final String user = "root";
    private final String user = "freddy";
    private final String password = "%Freddy101";
//    private final String password = "fe95aca7184807452_7";
    
    private final String charset="?useUnicode=yes&characterEncoding=UTF-8";
    
    private Connection DBConnection;
    
    public Connection connect(){
    
        try{
            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("MySQL Driver OK");
        } catch(ClassNotFoundException cnfe){
            System.err.println("Driver not found" + cnfe);
        }                
        try{
          DBConnection=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db+charset,user, password);
//          System.out.println("DB conection up");
        } catch(SQLException se){
          System.err.println("Database Not Found");  
        }
        return DBConnection;        
    }
    
}
