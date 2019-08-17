/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Alicer
 */
public class Conexion {
//    private final String host = "192.168.1.2";
    private final String host = "localhost";
    private final String port="3306";
    private final String db = "cafebar"; // Nombre de la BD.
    private final String user = "root";
//    private final String user = "freddy";
    private final String password = "";
//    private final String password = "%Freddy101";
//    private final String password = "fe95aca7184807452_7";
    
    private final String charset="?useUnicode=yes&characterEncoding=UTF-8";
    
    String botones[] = {"Aceptar", "Contactar"};
    private final String tituloMensaje = "¡Error de conexión!";
    private final String mensajeDR = "Conexion: > Driver Not Found >";
    private final String mensajeDB = "Conexion: > Database Not Found >";
    private final String mensajeService = "\nVerifica que todo esté en orden o ponte en contacto con el servicio técnico.";
    private JOptionPane jOptionPane;
    
    private Connection DBConnection;
   
    private void errorX (String mensaje){
        Integer eleccion = JOptionPane.showOptionDialog(null, mensaje, tituloMensaje, 0, 0, null, botones, this);
        
        if (eleccion == JOptionPane.YES_OPTION) {
            System.err.println("YES!!!");
            System.exit(0);
        } else if (eleccion == JOptionPane.NO_OPTION) {
            System.err.println("NO!!!");
            System.exit(0);
        } else {
            System.err.println("Uknow!!!");
        } 
    }
    
    public Connection connect(){
    
        try{
            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("MySQL Driver OK");
        } catch(ClassNotFoundException err){
            System.err.println(mensajeDR + err);
            errorX (mensajeDR);
        }                
        try{
            DBConnection=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db+charset,user, password);
//          System.out.println("DB conection up");
        } catch(SQLException err){
            System.err.println(mensajeDB + err);
            errorX (mensajeDB);
        }
        return DBConnection;        
    }
    
}
