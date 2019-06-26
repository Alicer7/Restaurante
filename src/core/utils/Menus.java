/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.utils;

import core.database.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Freddy
 */
public class Menus {
    private Integer id;
    private String nombre;
    private Integer comida_id;
    private Integer bebida_id;

    public Menus() {
    }

    public Menus(Integer id, String nombre, Integer comida_id, Integer bebida_id) {
        this.id = id;
        this.nombre = nombre;
        this.comida_id = comida_id;
        this.bebida_id = bebida_id;
    }
    
    public ArrayList<Menus> getMenus (){
        Connection conn= new Conexion().connect();
        
        ArrayList<Menus> listaMenus = new ArrayList<>();
        
        String sql = "SELECT * FROM `menus`";
        
        try {
            Statement stm;
            stm = conn.createStatement();
            ResultSet rst;
            rst = stm.executeQuery(sql);
            
            while (rst.next()){
                Menus menus = new Menus(
                        rst.getInt(1), 
                        rst.getString(2), 
                        rst.getInt(3), 
                        rst.getInt(4)
                );
                
                listaMenus.add(menus);
                
            }
        } catch (SQLException e) {
        }
        
        return listaMenus;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getComida_id() {
        return comida_id;
    }

    public Integer getBebida_id() {
        return bebida_id;
    }
    
}
