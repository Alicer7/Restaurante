/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.database.querry;

import core.database.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Freddy
 */
public class Almacen {
    
    private final Conexion conexion = new Conexion();
    
    public ResultSet mostrarCarnes (){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) conexion.connect();
            String sql = "SELECT `id`, `nombre`, `stock`, `costo` FROM `materiaprima`";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.close();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return rs;
    }
    
    public ResultSet buscarCarnes (String busqueda){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) conexion.connect();
            String sql = "select id, nombre, stock, costo from materiaprima where nombre LIKE '%" + busqueda + "%' order by(id) ";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.close();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return rs;
    }

    public void registroCarnes (String nombre, Integer stock, Integer stock_min, Integer stock_max){
        try (com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) conexion.connect()) {
            PreparedStatement ps = null;
            ps = conn.prepareStatement("INSERT INTO `materiaprima` (`nombre`, `stock`, `stock_min`, `stock_max`) VALUES (?,?,?,?)");
            ps.setString(1, nombre);
            ps.setInt(2, stock);
            ps.setInt(3, stock_min);
            ps.setInt(4, stock_max);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Ingresado Correctamente");
        } catch (SQLException ex) {
            Logger.getLogger(Almacen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
