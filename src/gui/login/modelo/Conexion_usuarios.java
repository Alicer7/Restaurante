
package gui.login.modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion_usuarios {
    
    private final String base = "cafebar";
    private final String user = "root";
    private final String password = "333561222587421319";
    private final String url = "jdbc:mysql://localhost/" + base;
    private Connection con = null;
//    
//     private final String base = "mydb";
//    private final String user = "alicer";
//    private final String password = "admin";
//    private final String url = "jdbc:mysql://192.168.1.29/" + base;
//    private Connection con = null;
    
    public Connection getConexion()
    {
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
            
        } catch(SQLException e)
        {
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
      return con;  
    }

}
